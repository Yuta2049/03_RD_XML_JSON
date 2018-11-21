package demoService;

import marshallingService.XMLService;
import productService.Category;
import productService.ProductService;
import productService.ProductsData;

import java.util.List;

public class DemoService {


    public void showDemo() {

        ProductService productService = new ProductService();
        //List<Category> categoryList = productService.generateData();
        ProductsData productsData = productService.generateData();

        XMLService xmlService = new XMLService();
        xmlService.saveToXML(productsData);

    }

}
