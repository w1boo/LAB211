/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 *
 * @author Khoa
 */
public class Order {
    private String orderID;
    private String customerID;
    private String productID;
    private int orderQuanity;
    private String orderDate;
    private String status;
    private Customer customer;
    public Order(String orderID,Customer customer , String productID, int orderQuanity, String orderDate, String status) {
        this.orderID = orderID;
        this.customer = customer;
        this.customerID = customerID;
        this.productID = productID;
        this.orderQuanity = orderQuanity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOrderQuanity() {
        return orderQuanity;
    }

    public void setOrderQuanity(int orderQuanity) {
        this.orderQuanity = orderQuanity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", customerID=" + customerID + ", productID=" + productID + ", orderQuanity=" + orderQuanity + ", orderDate=" + orderDate + ", status=" + status + ", customer=" + customer + '}';
    }




}
