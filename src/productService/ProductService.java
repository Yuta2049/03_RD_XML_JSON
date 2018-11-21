package productService;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.omg.IOP.Encoding;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ProductService {

//    private List<Product> products;
//
//    public List<Product> generateProducts() {
//
//        Product product = new Product("Apple", "iPhone 7", LocalDate.of(2017, 11, 1), "black", 200.0, 3.0);
//
//        Product product2 = new Product("Apple", "iPhone 8", LocalDate.of(2018, 11, 1), "gold", 300.0, 4.0);
//
//        Product product3 = new Product("Apple", "iPhone 9", LocalDate.of(2019, 11, 1), "gray", 500.0, 5.0);
//
//
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        products.add(product2);
//        products.add(product3);
//
//        return products;
//    }
//
//
//    @XmlAnyElement
//    public List<Product> getProducts() {
//        //return products;
//        return generateProducts();
//    }


    //public void saveToXML(List<Product> products) {
    public void saveToXML() {


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
            JAXBContext jc = JAXBContext.newInstance(Product.class, Category.Subcategory.class, Category.class);
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
            ProductService productService = new ProductService();
            //List<Product> value1 = productService.getProducts();
            //ParameterAdapter value1 = new ParameterAdapter();

            Category category = new Category();

            category.setCategoryname("CATEGORY 1");
            category.setSubcategorieses(category.getSubcategories());

            //List<Product> valu1 = Category
            //category.getProducts();

            //Subcategory subcategory = new Subcategory();
            //subcategory.getProducts();



            //JAXBElement jx = new JAXBElement(new QName("foo"), value1.getClass(), value1);

                //marshaller.marshal(action, System.out);
                //marshaller.marshal(value1, System.out);
            marshaller.marshal(category, System.out);

            }
            catch (Exception e) {
                System.out.println("ОШИБКА ПРИ СОХРАНЕНИИ В XML!");
                e.printStackTrace();
            }

    }

}
