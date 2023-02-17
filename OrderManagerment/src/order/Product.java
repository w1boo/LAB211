/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

/**
 *
 * @author Khoa
 */
public class Product {
    private String ProductID;
    private String ProductName;
    private String unit;
    private String origin;
    private double price;

    public Product(String ProductID, String ProductName, String unit, String origin, double price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.unit = unit;
        this.origin = origin;
        this.price = price;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ProductID +","+ ProductName + ","+ unit+","+origin+","+price;
    }
    
}
