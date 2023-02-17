/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khoa
 */
public class OrderList {
    private HashMap<String, Customer> customerMap;
    private ArrayList<Order> list;
    private CustomerList customerList;
    public OrderList(CustomerList customerList){
        customerMap = new HashMap<String, Customer>();
        customerMap = customerList.readCustomersFile("customers.txt");
        this.list= new ArrayList<>();
        this.customerList = customerList;
    }
public ArrayList<Order> readOrdersFile(HashMap<String, Customer> customerMap, String filename) {
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
            if (customer == null) {
                System.out.println("Invalid customer ID: " + customerID);
                continue;
            }

            Order order = new Order(orderID, customer, productID, orderQuantity, orderDate, status);
            list.add(order);
        }
    } catch (IOException e) {
        System.out.println("Error reading from file: " + e.getMessage());
    }
    return list;
}


public void PrintOrdersFromFile(String filename) {
    list.clear();
    list = readOrdersFile(customerMap, filename);
    Collections.sort(list, new Comparator<Order>() {
        public int compare(Order o1, Order o2) {
            String name1 = o1.getCustomerID();
            String name2 = o2.getCustomerID();
            return name1.compareTo(name2);
        }
    });
    for (Order order : list) {
        System.out.println(order.toString());
    }
}
}
