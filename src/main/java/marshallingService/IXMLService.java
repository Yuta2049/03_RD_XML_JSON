package marshallingService;

import productService.ProductsData;

public interface IXMLService {

    void writeToXML(ProductsData productsData);

    ProductsData readFromXML();
}
