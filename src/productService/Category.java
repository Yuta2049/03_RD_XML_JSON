package productService;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@XmlType(name = "category")
@XmlRootElement
public class Category
{
    @XmlElement(name = "categoryname")
    public String categoryname;

    //@XmlElement(name = "subcategorieses")
    //@XmlElementWrapper(name="subcategoriesList", nillable = true)
    public List<Subcategory> subcategorieses;



    public Category() {
    }

    /*@XmlElementWrapper(name="wild-animals", nillable = true)
    public List<Product> getProducts() {

        Product product = new Product("Apple", "iPhone 7", LocalDate.of(2017, 11, 1), "black", 200.0, 3.0);

        Product product2 = new Product("Apple", "iPhone 8", LocalDate.of(2018, 11, 1), "gold", 300.0, 4.0);

        Product product3 = new Product("Apple", "iPhone 9", LocalDate.of(2019, 11, 1), "gray", 500.0, 5.0);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        return products;
    }*/

    /*public String getCategoryname() {
        return categoryname;
    }*/

    /*public List<Subcategory> getSubcategorieses() {
        return subcategorieses;
    }*/

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setSubcategorieses(List<Subcategory> subcategorieses) {
        this.subcategorieses = subcategorieses;
    }

    //@XmlElementWrapper(name="subcategoriesList", nillable = true)
    public List<Subcategory> getSubcategories() {

        Subcategory subcategory = new Subcategory();
        subcategory.setName("SUBCATEGORY 1");
        Product product = new Product("Apple", "iPhone 7", LocalDate.of(2017, 11, 1), "black", 200.0, 3.0);
        Product product2 = new Product("Apple", "iPhone 8", LocalDate.of(2018, 11, 1), "gold", 300.0, 4.0);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        subcategory.setProductList(products);


        Subcategory subcategory2 = new Subcategory();
        subcategory2.setName("SUBCATEGORY 2");
        Product product3 = new Product("Apple", "iPhone 9", LocalDate.of(2019, 11, 1), "gray", 500.0, 5.0);
        List<Product> products2 = new ArrayList<>();
        products2.add(product3);
        subcategory2.setProductList(products2);


        List<Subcategory> subcategoriesList = new ArrayList<>();
        subcategoriesList.add(subcategory);
        subcategoriesList.add(subcategory2);

        return subcategoriesList;
    }


    static class Subcategory {

        @XmlElement(name = "subcategoryname")
        public String subcategoryName;

        //@XmlAttribute(name = "product")
        //public int weight;


        //@XmlElement(name = "subcategoryname")
        public List<Product> productList;

        public String getName() {
            return subcategoryName;
        }

        public List<Product> getProductListst() {
            return productList;
        }

        public void setName(String subcategoryName) {
            this.subcategoryName = subcategoryName;
        }

        public void setProductList(List<Product> productList) {
            this.productList = productList;
        }

        public Subcategory() {
        }
    }

}


