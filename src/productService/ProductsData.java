package productService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

//@XmlType(name = "category")
@XmlRootElement
//@XmlType(namespace="http://test.com")
public class ProductsData {

    private List<Category> categoryList;

    public ProductsData() {
    }

    @XmlElement(name = "category")
    @XmlElementWrapper(name="categories", nillable = true)
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
