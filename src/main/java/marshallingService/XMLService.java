package marshallingService;

import productService.*;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static productService.Constants.xmlFileName;
import static productService.Constants.xsdFileName;

public class XMLService implements IXMLService {

    @Override
    public void writeToXML(ProductsData productsData) {

        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);

            File xmlFile = new File(xmlFileName);

            Marshaller marshaller = jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, xsdFileName);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, xsdFileName);

            marshaller.marshal(productsData, xmlFile);

        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
            e.printStackTrace();
        }

    }

    boolean getXMLFileIsValid() {

        //try (StringReader stringReader = new StringReader(xmlFileName);){
        try {

            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdFileName));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFileName));

        } catch (Exception e) {
            System.out.println("Возникли ошибки при валидации xml");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public ProductsData readFromXML() {

        ProductsData productsData = new ProductsData();
        List<Category> categoryList = new ArrayList<>();

        try {

            StreamSource inputStream = new StreamSource(new File(xmlFileName));
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader streamReader = factory.createXMLStreamReader(inputStream);

            if (getXMLFileIsValid()) {

                while (streamReader.hasNext()) {

                    int eventType = streamReader.next();
                    if (eventType == XMLStreamConstants.START_ELEMENT) {

                        if (streamReader.getLocalName().equals("category")) {

                            JAXBContext jc = JAXBContext.newInstance(Category.class);
                            Unmarshaller unmarshaller = jc.createUnmarshaller();
                            JAXBElement<Category> jb = unmarshaller.unmarshal(streamReader, Category.class);

                            Category category = jb.getValue();
                            categoryList.add(category);
                        }
                    }
                }

                streamReader.close();

            }

        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ ЧТЕНИИ ИЗ XML!");
            e.printStackTrace();
        }

        productsData.setCategoryList(categoryList);

        return productsData;

    }
}
