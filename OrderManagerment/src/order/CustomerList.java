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
import java.util.HashMap;
import utils.Validation;

/**
 *
 * @author Khoa
 */
public class CustomerList {
    public ArrayList<Customer> list = new ArrayList<>();
    public ArrayList<Order> orderList = new ArrayList<>();
public HashMap<String, Customer> readCustomersFile(String filename) {
    HashMap<String, Customer> customerMap = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] customerInfo = line.split(",");
            String customerID= customerInfo[0];
            String customerName = customerInfo[1];
            String customerAddress = customerInfo[2];
            String customerPhone = customerInfo[3];
            Customer customer = new Customer(customerID, customerName, customerAddress, customerPhone);
            customerMap.put(customerID, customer);
            list.add(customer);
        }
    } catch (IOException e) {
        System.out.println("Can not write to file");
    }
    return customerMap;
}

    public void printCustomersFile(String filename) {
        list.clear();
        readCustomersFile(filename);
    for (Customer customer : list) {
        System.out.println(customer.toString());
    }
 }
public Customer searchCustomerById(String id) {
    for (Customer customer : list) {
        if (customer.getCustomerID().equals(id)) {
            System.out.println(customer.toString());
            return customer;
        }
    }
    System.out.println("Customer not found with id: " + id);
    return null;
}
        public int kiemtraID(String IdKiemTra) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomerID().equals(IdKiemTra)) {
                return i;
            }

        }
        return -1;

    }
    public void SearchCustomer(){
        String id =Validation.regexString("Input CustomerID: ", "Invalid ID", "^[C]\\d{3}$");
        int index = kiemtraID(id);
        if(index == -1){
            System.out.println("ID not found");
            }else{
            System.out.println(list.get(index).toString());
            
        }
    }
    public void addCustomer(){
        String id,name,address;
        String phone;
        int index;
        do{
         id = Validation.regexString("Input Customer's ID: ", "Invalid id , try again", "^[C]\\d{3}$");
        index =kiemtraID(id);
        if(index >=0){
            System.out.println("ID is already in list, Try again");
        }
        }while(index>=0);
        name = Validation.regexString("Input Customer's name: ", "Invalid name, try again", "^[^\\d]{5,30}$");
        address = Validation.getString("Input Customer's address", "Invalid address");
        phone = Validation.regexString("Input phone number: ", "Invalid number, try agian", "^\\d{10,12}$");
        Customer customer = new Customer(id, name, address, phone);
        list.add(customer);
        System.out.println("Customer added");
}
    public void updateCustomer(){
        String id = Validation.regexString("Input customer's ID: ", "Invalid ID, try again", "^[C]\\d{3}$");
        int index = kiemtraID(id);
        if(index == -1){
            System.out.println("ID not found");
        }else{
            String name = Validation.updateString("Input new customer name:", list.get(index).getCustomerName());
            String address = Validation.updateString("Input new customer address: ", list.get(index).getCustomerAddress());
            String phone = Validation.updateString("Input new phone number: ", list.get(index).getPhoneNumber());
            list.get(index).setCustomerName(name);
            list.get(index).setCustomerAddress(address);
            list.get(index).setPhoneNumber(phone);
                try (PrintWriter writer = new PrintWriter(new FileOutputStream("customers.txt"))) {
        for (Customer customer : list) {
            writer.println(customer.toString());
        }
        System.out.println("CUSTOMER UPDATED.");
    } catch (FileNotFoundException e) {
        System.out.println("Error writing to file");
    }
    }
    }
//    public void saveCustomersToFile() {
//    try (PrintWriter writer = new PrintWriter(new FileOutputStream("customers.txt", true))) {
//        for (Customer customer : list) {
//            writer.println(customer.toString());
//        }
//        System.out.println("Customers saved to file");
//    } catch (FileNotFoundException e) {
//        System.out.println("Error writing to file: " + e.getMessage());
//    }
//}
    public void saveCustomersToFile() {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream("customers.txt"))) {
        for (Customer customer : list) {
            writer.println(customer.toString());
        }
        System.out.println("Customers saved to file.");
    } catch (FileNotFoundException e) {
        System.out.println("Error writing to file");
    }
}
}


