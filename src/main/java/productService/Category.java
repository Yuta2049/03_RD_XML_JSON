package productService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "category")
@XmlRootElement
public class Category {

    private String categoryName;

    private List<Subcategory> subcategoryList;

    public Category() {
    }

    @XmlElement(name = "categoryname")
    public String getCategoryName() {
        return categoryName;
    }

    @XmlElement(name = "subcategory")
    @XmlElementWrapper(name="subcategories", nillable = true)
    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }
}
