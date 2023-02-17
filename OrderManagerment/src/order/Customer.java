/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

/**
 *
 * @author Khoa
 */
public class Customer {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private String phoneNumber;

    public Customer() {
        customerID = "";
        customerName= "";
        customerAddress= "";
        phoneNumber = "";
    }

    public Customer(String customerID, String customerName, String customerAddress, String phoneNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  customerID+","+ customerName +"," + customerAddress  + "," + phoneNumber;
    }
    
    
}
