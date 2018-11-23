package demoService;

import marshallingService.GSONService;
import marshallingService.IGSONService;
import marshallingService.IXMLService;
import marshallingService.XMLService;
import productService.ProductService;
import productService.ProductsData;

public class DemoService implements IDemoService {

    @Override
    public void showDemo() {

        ProductService productService = new ProductService();

        ProductsData productsData = productService.generateData();

        IXMLService xmlService = new XMLService();
        xmlService.writeToXML(productsData);

        ProductsData productData2 = xmlService.readFromXML();

        IGSONService gsonService = new GSONService();
        gsonService.writeToGSON(productsData);
        gsonService.readFromGSON();

    }

}
