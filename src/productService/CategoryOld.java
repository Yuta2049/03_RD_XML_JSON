//package productService;
//
//import javax.xml.bind.annotation.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@XmlType(name = "category")
//@XmlRootElement
//public class CategoryOld
//{
//    @XmlElement(name = "categoryname")
//    public String categoryName;
//
//
//    @XmlElement(name = "subcategory")
//    @XmlElementWrapper(name="subcategories", nillable = true)
//    public List<Subcategory> subcategories;
//
//
//
//    public CategoryOld() {
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public void setSubcategorieses(List<Subcategory> subcategorieses) {
//        this.subcategories = subcategorieses;
//    }
//
//
//
//
//    static class Subcategory {
//
//        public String subcategoryName;
//
//        @XmlElement(name = "product")
//        @XmlElementWrapper(name="products", nillable = true)
//        public List<Product> productList;
//
//        public String getSubcategoryName() {
//            return subcategoryName;
//        }
//
//        public List<Product> getProductListst() {
//            return productList;
//        }
//
//        public void setName(String subcategoryName) {
//            this.subcategoryName = subcategoryName;
//        }
//
//        public void setProductList(List<Product> productList) {
//            this.productList = productList;
//        }
//
//        public Subcategory() {
//        }
//    }
//
//}
//
//
