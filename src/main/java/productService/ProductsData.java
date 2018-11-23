package productService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
public class ProductsData {

    private List<Category> categoryList;

    public ProductsData() {
    }

    @XmlElement(name = "category")
    @XmlElementWrapper(name = "categories", nillable = true)
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Category currentCategory : categoryList) {
            stringBuilder.append("Категория: ").append(currentCategory.getCategoryName()).append("\n");
            for (Subcategory currentSubcategory : currentCategory.getSubcategoryList()) {
                stringBuilder.append("   Подкатегория: ").append(currentSubcategory.getSubcategoryName()).append("\n");
                for (Product currentProduct : currentSubcategory.getProductList()) {
                    stringBuilder.append("      Продукт: ").append("\n");
                    stringBuilder.append("         Модель           : ").append(currentProduct.getModel()).append("\n");
                    stringBuilder.append("         Цвет             : ").append(currentProduct.getColor()).append("\n");
                    stringBuilder.append("         Производитель    : ").append(currentProduct.getProducer()).append("\n");
                    stringBuilder.append("         Дата изготовления: ").append(currentProduct.getDateOfManufacture()).append("\n");
                    stringBuilder.append("         Цена             : ").append(currentProduct.getPrice()).append("\n");
                    stringBuilder.append("         Количество:      : ").append(currentProduct.getQuantity()).append("\n");
                }
            }
        }

        return stringBuilder.toString();
    }
}


