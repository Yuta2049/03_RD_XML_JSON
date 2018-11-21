package marshallingService;

import productService.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLService {


    public void saveToXML(ProductsData productsData) {


        try {

            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
            ParameterAdapter adapter = new ParameterAdapter(jc);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setAdapter(adapter);
            //File xml = new File("src/blog/anyelement/adapted/input.xml");
            File xml = new File("input.xml");
            //Method action = (Method) unmarshaller.unmarshal(xml);


            Marshaller marshaller = jc.createMarshaller();
            marshaller.setAdapter(adapter);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //marshaller.marshal(productsData, System.out);
            marshaller.marshal(productsData, xml);


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
            //File xml = new File("src/blog/anyelement/adapted/input.xml");
            File xml = new File("input.xml");
            //Method action = (Method) unmarshaller.unmarshal(xml);

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
