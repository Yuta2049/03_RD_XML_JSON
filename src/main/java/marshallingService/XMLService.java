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

public class XMLService {

    public void writeToXML(ProductsData productsData) {

        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
            ParameterAdapter adapter = new ParameterAdapter(jc);

            File xmlFile = new File("ProductData.xml");

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setAdapter(adapter);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(productsData, xmlFile);


        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
            e.printStackTrace();
        }

    }



    public ProductsData readFromXML() {

        ProductsData productsData = new ProductsData();
        List<Category> categoryList = new ArrayList<>();

        try {


            File xmlFile = new File("ProductData.xml");
            StreamSource xml = new StreamSource(xmlFile);


// Создаем XMLStreamReader, поток разбора
            XMLInputFactory factory = XMLInputFactory.newFactory();
            //XMLStreamReader streamReader = factory.createXMLStreamReader(inputStream);
            XMLStreamReader streamReader = factory.createXMLStreamReader(xml) ;
// Стэк тэгов
            Stack<String> tagStack = new Stack<>();
// Пока есть тэги
            while (streamReader.hasNext()) {
// Берем следующий
                int eventType = streamReader.next();
// Если старт элемента
                if(eventType == XMLStreamConstants.START_ELEMENT) {
//// Помещаем в стэк
//                    tagStack.push(streamReader.getName().toString());
//// Ищем совпадение с обработчиком
//                    TagProcessor t = processorMap.get(tagStack);
//
//                    if(t != null) {
//// Нашли, обрабатываем
//                        t.process(streamReader);
//                        tagStack.pop();
//                    }
//                } else if(eventType == XMLStreamConstants.END_ELEMENT) {
//                    tagStack.pop();
//                }
                    if (streamReader.getLocalName().equals("category")) {
                        //System.out.println(streamReader.);


            JAXBContext jc = JAXBContext.newInstance(Category.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<Category> jb = unmarshaller.unmarshal(streamReader, Category.class);
            //xsr.close();

            Category category = jb.getValue();
            System.out.println(category.getCategoryName());
            //System.out.println(customer.firstName);
            //System.out.println(customer.lastName);
                        categoryList.add(category);

                    }

                }

            }

//            XMLInputFactory xif = XMLInputFactory.newFactory();
//            StreamSource xml = new StreamSource(xmlFile);
//            XMLStreamReader xsr = xif.createXMLStreamReader(xml);
//
//            try {
//                while (xsr.hasNext() && event
//                        !xsr.getLocalName().equals("category"))
//            }
//
//            xsr.nextTag();
//            while(!xsr.getLocalName().equals("category")) {
//                xsr.nextTag();
//            }
//
//            JAXBContext jc = JAXBContext.newInstance(Category.class);
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            JAXBElement<Category> jb = unmarshaller.unmarshal(xsr, Category.class);
//            xsr.close();
//
//            Category category = jb.getValue();
//            System.out.println(category.getCategoryName());
//            //System.out.println(customer.firstName);
//            //System.out.println(customer.lastName);



//            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
//            ParameterAdapter adapter = new ParameterAdapter(jc);
//
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            unmarshaller.setAdapter(adapter);
//
//            File xml = new File("ProductData.xml");
//
//            String xsdFile = "ProductData.xsd";
//
//            //Setup schema validator
//            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema employeeSchema = sf.newSchema(new File(xsdFile));
//            unmarshaller.setSchema(employeeSchema);
//
//
//            productsData = (ProductsData) unmarshaller.unmarshal(xml);
//


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


//    public ProductsData readFromXML() {
//
//        ProductsData productsData = null;
//
//        try {
//
//            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
//            ParameterAdapter adapter = new ParameterAdapter(jc);
//
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            unmarshaller.setAdapter(adapter);
//
//            File xml = new File("ProductData.xml");
//
//            String xsdFile = "ProductData.xsd";
//
//            //Setup schema validator
//            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema employeeSchema = sf.newSchema(new File(xsdFile));
//            unmarshaller.setSchema(employeeSchema);
//
//
//            productsData = (ProductsData) unmarshaller.unmarshal(xml);
//
//            System.out.println("==================================");
//            System.out.println("ДЕСЕРИАЛИЗАЦИЯ ИЗ XML ");
//            System.out.println(productsData.toString());
//
//
//        } catch (Exception e) {
//            System.out.println("ОШИБКА ПРИ ЧТЕНИИ ИЗ XML!");
//            e.printStackTrace();
//        }
//
//        return productsData;
//
//    }

}
