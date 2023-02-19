/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author Khoa
 */
public class OrderList {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, Product> productMap;
    private HashMap<String, Customer> customerMap;
    private ArrayList<Order> list;
    private ArrayList<Product> pL;
    private CustomerList customerList;
    private ProductList productList;
    public OrderList(CustomerList customerList, ProductList productList){
        customerMap = new HashMap<String, Customer>();
        customerMap = customerList.readCustomersFile("customers.txt");
        productMap = new HashMap<String , Product>();
        productMap = productList.readProductsFile("products.txt");
        this.list= new ArrayList<>();
        this.customerList = customerList;
        this.productList = productList;
    }
public ArrayList<Order> readOrdersFile(HashMap<String, Customer> customerMap,HashMap<String, Product> productMap, String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] orderInfo = line.split(",");
            String orderID = orderInfo[0];
            String customerID = orderInfo[1];
            String productID = orderInfo[2];
            int orderQuantity = Integer.parseInt(orderInfo[3]);
            String orderDate = orderInfo[4];
            String status = orderInfo[5];

            Customer customer = customerMap.get(customerID);
            Product product =productMap.get(productID);
            if (customer == null) {
                System.out.println("Invalid customer ID: " + customerID);
                continue;
            }

            Order order = new Order(orderID, customer, product, orderQuantity, orderDate, status);
            order.setCustomerID(customerID);
            order.setProductID(productID);
            list.add(order);
        }
    } catch (IOException e) {
        System.out.println("Error reading from file: " + e.getMessage());
    }
    return list;
}


public void PrintOrdersFromFile(String filename) {
    list.clear();
    list = readOrdersFile(customerMap,productMap, filename);
    Collections.sort(list, new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
    String lastName1 = o1.getCustomer().getCustomerName().split(" ")[o1.getCustomer().getCustomerName().split(" ").length - 1];
    String lastName2 = o2.getCustomer().getCustomerName().split(" ")[o2.getCustomer().getCustomerName().split(" ").length - 1];
    return lastName1.compareTo(lastName2);       
        }
    });
    for(Order order: list){
        System.out.println(order.toString());
    }
}
public void printPendingOrders(String filename) {
    list.clear();
    list = readOrdersFile(customerMap,productMap, filename);
    Collections.sort(list, new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getOrderDate().compareTo(o2.getOrderDate());
        }
    });
    System.out.println("Pending Orders:");
    for (Order order : list) {
        if (order.getStatus().equalsIgnoreCase("false")) {
            System.out.println(order);
        }
    }
}
public boolean KiemTraOrderID(String orderID) {
    for (Order order : list) {
        if (order.getOrderID().equals(orderID)) {
            return true;
        }
    }
    return false;
}
public boolean KiemTraCustomerID(String customerID) {
    for (Customer customer : customerMap.values()) {
        if (customer.getCustomerID().equals(customerID)) {
            return true;
        }
    }
    return false;
}
public boolean KiemTraProductID(String productID) {
    for (Product product: productMap.values()) {
        if (product.getProductID().equals(productID)) {
            return true;
        }
    }
    return false;
}
public void addNewOrder() {
    boolean status = false;
    boolean index;
    int Quanity;
    String orderDate;
    String orderID, customerID,productID;
    do{
    orderID = Validation.regexString("Input orderID: ", "Invalid ID , try again","^[D]\\d{3}");
    index = KiemTraOrderID(orderID);
    if(index ==true){
        System.out.println("ID is already in list , Try again");
    }
    }while(index == true);
    System.out.println("Choose a customer from the following list:");
    customerList.printCustomersFile("customers.txt");
    do{
    customerID = Validation.regexString("Input customerID: ", "Invalid ID , try again","^[C]\\d{3}$");
    index = KiemTraCustomerID(customerID);
    if(index == false){
        System.out.println("ID not found , Try again");
    }
    }while(index == false);
    
    System.out.println("Choose a product from the following list:");
    productList.printProductsFile("products.txt");
    do{
    productID = Validation.getString("Input productID: ", "Invalid ID, try again");
    index = KiemTraProductID(productID);
    if(index == false){
        System.out.println("ID not found , try again");
    }
    }while(index == false);
    Quanity = Validation.getAnInteger("Input product quanity: ", "Invalid quanity, try again", 0);
    orderDate = Validation.getString("Input order date(MM/DD/YYYY):", "Invalid date");
    System.out.print("Enter Order Status (true/false, default is false): ");
    String statusStr = sc.nextLine();
    if (statusStr.isEmpty()) {
    status = false;
    if (statusStr.equalsIgnoreCase("true")) {
    status = true;
    } else {
    status = false;
    }
if (statusStr.isEmpty()) {
    statusStr = "false";
}
    Customer customer = customerMap.get(customerID);
    Product product = productMap.get(productID);
    Order order = new Order(orderID, customer, product, Quanity, orderDate, statusStr);
    order.setCustomerID(customerID);
    order.setProductID(productID);
    list.add(order);
    System.out.println("New order details: " + order.toString());
    System.out.println("ORDER CREATED SUCCESS");
}
}
    public void saveOrderToFile() {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream("orders.txt"))) {
        for (Order order : list) {
            writer.println(order.toString());
        }
        System.out.println("Orders saved to file.");
    } catch (FileNotFoundException e) {
        System.out.println("Error writing to file");
    }
}
    public void updateOrder(){
        boolean index;
        boolean status = false;
        String OrderID;
        do{
        OrderID= Validation.regexString("Input OrderID: ", "Invalid ID try", "^[D]\\d{3}$");
        index =KiemTraOrderID(OrderID);
        if(index == false){
            System.out.println("ID not found , try again");
        }
        }while(index == false);
            System.out.print("Enter New Order Status (true/false, default is false): ");
    String statusStr = sc.nextLine();
    if (statusStr.isEmpty()) {
    status = false;
    if (statusStr.equalsIgnoreCase("true")) {
    status = true;
    } else {
    status = false;
    }
if (statusStr.isEmpty()) {
    statusStr = "false";
}
    }
    for(Order order: list){
        if(order.getOrderID().equals(OrderID)){
        order.setStatus(statusStr);
            System.out.println("Order status updated");
            saveOrderToFile();

            return;
        
    }     
}
}
    public void deleteOrder(){
        String confirm;
        String OrderID;
        boolean index;
        do{
        OrderID =Validation.regexString("Input OrderID to delete: ", "Invalid ID try again", "^[D]\\d{3}");
        index = KiemTraOrderID(OrderID);
        if(index == false){
            System.out.println("Order ID not found, try again");
        }
        }while(index == false);
        System.out.print("Are you sure you want to delete the order (y/n)? ");
     confirm = sc.nextLine();

    if (confirm.equalsIgnoreCase("y")) {
        for (Order order : list) {
            if (order.getOrderID().equalsIgnoreCase(OrderID)) {
                list.remove(order);
                System.out.println("Order deleted successfully.");
                break;
            }
        }
        saveOrderToFile();

    } else {
        System.out.println("Deletion cancelled.");
    }
        
    }
}
