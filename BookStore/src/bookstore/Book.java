/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.Serializable;

/**
 *
 * @author Khoa
 */
public class Book implements Serializable{
    private String id;
    private String name;
    private double price;
    private int quanity;
    private Publisher publisher;
    private String status;

    public Book() {
        id = "";
        name = "";
        price = 0;
        quanity= 0;
        status= "";
        
    }

    public Book(String id, String name, double price, int quanity, String publisherID, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanity = quanity;
        this.status = status;
    }

public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double SubTotal(){
        return price*quanity;
}



    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", price=" + price + ", quanity=" + quanity + ", status=" + status + '}';
    }
        public void showInfo(){
        System.out.printf("|%-10s|%-10s|%-10.00f|%-11d|%-10.00f|%-20s|%-21s|\n",id,name,price,quanity,SubTotal(),publisher.toString(),status);
    }
}
