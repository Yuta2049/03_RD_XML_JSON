package marshallingService;

import productService.*;
import sun.util.resources.cldr.to.CalendarData_to_TO;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class XMLService implements IXMLService {

    @Override
    public void writeToXML(ProductsData productsData) {

        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);

            File xmlFile = new File("ProductData.xml");

            Marshaller marshaller = jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(productsData, xmlFile);


        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
            e.printStackTrace();
        }

    }


    @Override
    public ProductsData readFromXML() {

        ProductsData productsData = new ProductsData();
        List<Category> categoryList = new ArrayList<>();

        try {

            File xmlFile = new File("ProductData.xml");
            StreamSource inputStream = new StreamSource(xmlFile);

            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader streamReader = factory.createXMLStreamReader(inputStream);

            while (streamReader.hasNext()) {

                int eventType = streamReader.next();
                if(eventType == XMLStreamConstants.START_ELEMENT) {

                    if (streamReader.getLocalName().equals("category")) {

                        JAXBContext jc = JAXBContext.newInstance(Category.class);
                        Unmarshaller unmarshaller = jc.createUnmarshaller();
                        JAXBElement<Category> jb = unmarshaller.unmarshal(streamReader, Category.class);
                        //xsr.close();

                        Category category = jb.getValue();
                        categoryList.add(category);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ ЧТЕНИИ ИЗ XML!");
            e.printStackTrace();
        }

        productsData.setCategoryList(categoryList);

        System.out.println("==================================");
        System.out.println("ДЕСЕРИАЛИЗАЦИЯ ИЗ XML ");
        System.out.println(productsData.toString());

        return productsData;

    }
}
