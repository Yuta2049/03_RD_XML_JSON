package demoService;

import marshallingService.XMLService;
import productService.ProductService;
import productService.ProductsData;

public class DemoService {


    public void showDemo() {

        ProductService productService = new ProductService();
        //List<Category> categoryList = productService.generateData();
        ProductsData productsData = productService.generateData();

        XMLService xmlService = new XMLService();
        xmlService.saveToXML(productsData);


        ProductsData productData2 = xmlService.readFromXML();


    }

}
