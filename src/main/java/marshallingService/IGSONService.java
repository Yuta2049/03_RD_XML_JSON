package marshallingService;

import productService.ProductsData;

public interface IGSONService {

    ProductsData readFromGSON();

    void writeToGSON(ProductsData productsData);
}
