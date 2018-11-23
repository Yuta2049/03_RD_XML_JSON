package productService;

import marshallingService.LocalDateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

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

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getProducer() {
        return producer;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
