package productService;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product")
@XmlRootElement
public class Product {

    private String producer;
    private String model;    // 2 letters, 3 numbers
    private LocalDate dateOfManufacture;
    private String color;
    private double price;
    private double quantity;

    public Product() {
    }

    public Product(String producer, String model, LocalDate dateOfManufacture, String color, double price, double quantity) {
        this.producer = producer;
        this.model = model;
        this.dateOfManufacture = dateOfManufacture;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }


    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

//    public LocalDate getDateOfManufacture() {
//        return dateOfManufacture;
//    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}
