package productService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "subcategory")
@XmlRootElement
public class Subcategory {

    private String subcategoryName;

    private List<Product> productList;

    public Subcategory() {
    }

    @XmlElement(name = "subcategoryname")
    public String getSubcategoryName() {
        return subcategoryName;
    }

    @XmlElement(name = "product")
    @XmlElementWrapper(name="products", nillable = true)
    public List<productService.Product> getProductList() {
        return productList;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
