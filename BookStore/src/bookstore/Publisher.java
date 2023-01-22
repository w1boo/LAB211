/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Khoa
 */
public class Publisher implements Serializable{
    private List<Book> books;
    private String id;
    private String name;
    private long phoneNumber;

    public Publisher() {
        id = "P00000";
        name = "";
        phoneNumber = 0;
    }

public void addBook(Book book) {
    books.add(book);
}

    public Publisher(String id, String name, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.books = new ArrayList<>();
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
     public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return name;
    }
    public void showInfo(){
        System.out.printf("|%-10s|%-10s|%-20d|\n",id,name,phoneNumber);
    }

}
