package marshallingService;

import productService.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLService {


    public void saveToXML(ProductsData productsData) {


        try {

//            Product product = products.get(0);
//
//            QName root = new QName("return");
//            //JAXBElement<Product> je = new JAXBElement<Product>(root, Product.class, product);
//                JAXBElement<List<Product>> je = new JAXBElement<List<Product>>(root, Product.class, product);
//
//            XMLOutputFactory xof = XMLOutputFactory.newFactory();
//
//            //XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
//            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileOutputStream("products.xml"), "UTF-8");
//
//
//            xsw.writeStartDocument();
//            xsw.writeStartElement("S", "Envelope", "http://schemas.xmlsoap.org/soap/envelope/");
//            xsw.writeStartElement("S", "Body", "http://schemas.xmlsoap.org/soap/envelope/");
//            xsw.writeStartElement("ns0", "findCustomerResponse", "http://service.jaxws.blog/");
//
//            JAXBContext jc = JAXBContext.newInstance(Product.class);
//            Marshaller marshaller = jc.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//            marshaller.marshal(je, xsw);
//
//            xsw.writeEndDocument();
//            xsw.flush();
//
//            xsw.close();

            //JAXBContext jc = JAXBContext.newInstance(Product.class, Parameter.class);
            //JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class);
            JAXBContext jc = JAXBContext.newInstance(Product.class, Subcategory.class, Category.class, ProductsData.class);
            //JAXBContext jc = JAXBContext.newInstance(Method.class, Parameter.class,
            //        Product.class);
            ParameterAdapter adapter = new ParameterAdapter(jc);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setAdapter(adapter);
            //File xml = new File("src/blog/anyelement/adapted/input.xml");
            File xml = new File("input.xml");
            //Method action = (Method) unmarshaller.unmarshal(xml);


            Marshaller marshaller = jc.createMarshaller();
            marshaller.setAdapter(adapter);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            //String value1 = "test";
            //Product value1 = products.get(0);
            //ProductService productService = new ProductService();

            //List<Product> value1 = productService.getProducts();
            //ParameterAdapter value1 = new ParameterAdapter();

//            CategoryOld category = new CategoryOld();
//            category.setCategoryName("CATEGORY 1");
//            category.setSubcategorieses(category.getSubcategories());


            /*Category category2 = new Category();
            category2.setCategoryName("CATEGORY 2");
            category2.setSubcategorieses(category2.getSubcategories());


            List<Category> categories = new ArrayList<>();
            categories.add(category);
            categories.add(category2);*/


            //List<Product> valu1 = Category
            //category.getProducts();

            //Subcategory subcategory = new Subcategory();
            //subcategory.getProducts();


            //JAXBElement jx = new JAXBElement(new QName("foo"), value1.getClass(), value1);

            //marshaller.marshal(action, System.out);
            //marshaller.marshal(value1, System.out);
            //marshaller.marshal(category, System.out);

            marshaller.marshal(productsData, System.out);


        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
            e.printStackTrace();
        }

    }

}
