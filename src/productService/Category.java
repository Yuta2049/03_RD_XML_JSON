package productService;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@XmlType(name = "category")
@XmlRootElement
public class Category
{

    public Category() {
    }

    @XmlElementWrapper(name="wild-animals", nillable = true)
    public List<Product> getProducts() {

        Product product = new Product("Apple", "iPhone 7", LocalDate.of(2017, 11, 1), "black", 200.0, 3.0);

        Product product2 = new Product("Apple", "iPhone 8", LocalDate.of(2018, 11, 1), "gold", 300.0, 4.0);

        Product product3 = new Product("Apple", "iPhone 9", LocalDate.of(2019, 11, 1), "gray", 500.0, 5.0);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        return products;
    }


}


