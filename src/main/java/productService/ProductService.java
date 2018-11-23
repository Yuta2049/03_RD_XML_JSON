package productService;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ProductService {

    public ProductsData generateData() {

        List<Category> categoryList = new ArrayList<Category>();

        Category category = new Category();
        category.setCategoryName("CATEGORY 1");
        category.setSubcategoryList(getSubcategories());


        Category category2 = new Category();
        category2.setCategoryName("CATEGORY 2");
        category2.setSubcategoryList(getSubcategories());


        //List<Category> categories = new ArrayList<>();
        categoryList.add(category);
        categoryList.add(category2);

        ProductsData productsData = new ProductsData();
        productsData.setCategoryList(categoryList);

        return productsData;
    }

    public List<Subcategory> getSubcategories() {

        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName("SUBCATEGORY 1");
        Product product = new Product("Apple", "AA123", LocalDate.of(2017, 11, 1), "black", 200.0, 3.0);
        Product product2 = new Product("Apple", "BB345", LocalDate.of(2018, 11, 1), "gold", 300.0, 4.0);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        subcategory.setProductList(products);


        Subcategory subcategory2 = new Subcategory();
        subcategory2.setSubcategoryName("SUBCATEGORY 2");
        Product product3 = new Product("Apple", "CC789", LocalDate.of(2019, 11, 1), "gray", 500.0, 5.0);
        List<Product> products2 = new ArrayList<>();
        products2.add(product3);
        subcategory2.setProductList(products2);


        List<Subcategory> subcategoriesList = new ArrayList<>();
        subcategoriesList.add(subcategory);
        subcategoriesList.add(subcategory2);

        return subcategoriesList;


    }



}
