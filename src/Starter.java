import productService.Product;
import productService.ProductService;

import java.util.List;

public class Starter {

    public static void main(String[] args) {


        ProductService productService = new ProductService();
        List<Product> products = productService.generateProducts();
        productService.saveToXML(products);

    }
}
