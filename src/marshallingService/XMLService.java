package marshallingService;

import productService.*;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;

public class XMLService {


    public void saveToXML(ProductsData productsData) {


        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
            ParameterAdapter adapter = new ParameterAdapter(jc);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setAdapter(adapter);
            //File xml = new File("src/blog/anyelement/adapted/ProductData.xml");

            //SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //Schema schema = schemaFactory.newSchema(ProductsData.class.getResource("ProductData.xsd"));
            //unmarshaller.setSchema(schema);

            File xmlFile = new File("ProductData.xml");


            //File xml = new File("ProductData.xml");
            //Method action = (Method) unmarshaller.unmarshal(xml);


            Marshaller marshaller = jc.createMarshaller();
            marshaller.setAdapter(adapter);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION  , "ProductData.xsd");


            //marshaller.marshal(productsData, System.out);
            marshaller.marshal(productsData, xmlFile);


        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
            e.printStackTrace();
        }

    }


    public ProductsData readFromXML() {

        ProductsData productsData = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
            ParameterAdapter adapter = new ParameterAdapter(jc);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setAdapter(adapter);
            //File xml = new File("src/blog/anyelement/adapted/ProductData.xml");
            File xml = new File("ProductData.xml");
            //Method action = (Method) unmarshaller.unmarshal(xml);

            String xsdFile = "ProductData.xsd";

            //Setup schema validator
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema employeeSchema = sf.newSchema(new File(xsdFile));
            unmarshaller.setSchema(employeeSchema);


            productsData = (ProductsData) unmarshaller.unmarshal(xml);

            System.out.println(productsData.getCategoryList().size());


//            Marshaller marshaller = jc.createMarshaller();
//            marshaller.setAdapter(adapter);
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            //marshaller.marshal(productsData, System.out);
//            marshaller.marshal(productsData, xml);



        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ ЧТЕНИИ ИЗ XML!");
            e.printStackTrace();
        }

        return productsData;

    }


}
