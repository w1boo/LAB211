/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Validation;
/**
 *
 * @author Khoa
 */
public class BookList {
    static String filePath = "file\\Book.dat";
    private ArrayList<Book> list = new ArrayList();
    private PublisherList pL;
    String id;
         public BookList(PublisherList publisherList) {
        this.pL = publisherList;
    }
    
    public void addBook(){
        String publisherId;
        Publisher publisher;
        int index;
        do{
         id = Validation.regexString("Input book'id(Bxxxxx): ", "Invalid id , try again", "^[B]\\d{5}$");
        index =kiemtraID(id);
        if(index >=0){
            System.out.println("ID is already in list, Try again");
        }
        }while(index>=0);
        String name = Validation.regexString("Input book's name: ", "Invalid name, try again", "^[^\\d]{5,30}$");
        double price = Validation.getADouble("Input book's price: ", "Invalid price , try again", 0);
        int quanity = Validation.getAnInteger("Input book's quanity: ", "Invalid quanity , try again", 0);
        do{
         publisherId = Validation.regexString("Input id(Pxxxxx): ", "Invalid input , try again.", "^[P]\\d{5}$");
        publisher = pL.findPublisher(publisherId);
        if (publisher == null) {
        System.out.println("Publisher's Id is not found.");
        }
        }while(publisher == null);
        String status = Validation.regexString("Input book's status: ", "Invalid input , try again", "(Available)|(Not Available)");
//        list.add(new Book(id, name, price, quanity, publisherId, status));
        Book book = new Book(id, name, price, quanity, publisherId, status);
        book.setPublisher(publisher);
        list.add(book);
//        Book book = new Book(id, name, price, quanity, publisherID, status);
//        book.setPublisher(publisher);
//        //list.add(new Book(id, name, price, quanity, quanity, status));
//        list.add(book);
        System.out.println("BOOK ADDED");
    }
   
        
//        public Publisher findPublisher() {
//        for (Publisher publisher : publisherList) {
//            if (publisher.getId().equals(id)) {
//                return publisher;
//            }
//        }
//        return null;
//    }

    
        public int kiemtraID(String IdKiemTra) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(IdKiemTra)) {
                return i;
            }

        }
        return -1;

    }
        
    public void deleteBook(){
         id = Validation.regexString("Input id: ", "Invalid id , try again", "^[B]\\d{5}");
        int index= kiemtraID(id);
        if(index == -1){
            System.out.println("ID not found");
            
        }else{
            list.remove(index);
            System.out.println("Remove successfully");
        }
    }   
//    public void SearchBook(){
//        boolean flag = false;
//        String Search = Validation.getString("Enter book's name: ", "Invalid name, try again");
//         for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getName().contains(Search)){
//               list.get(i).showInfo();
//                flag = true;
//            }
//            
//        }
//         if(flag==false){
//             System.out.println("Have no any Book");
//         }
//}
    public void SearchBook(){
    boolean flag = false;
    String search = Validation.getString("Enter book's name: ", "Invalid name, try again");
    String publisherID = Validation.getString("Enter publisher's ID: ", "Invalid ID, try again");
    for (int i = 0; i < list.size(); i++) {
        if(list.get(i).getName().contains(search) && list.get(i).getPublisher().getId().equals(publisherID)){
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");
            System.out.println("|    ID    |   NAME   |   PRICE  |  QUANITY  | SUBTOTAL | PUBLISHER NAME     |         STATUS      |");
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");
            list.get(i).showInfo();
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");
            flag = true;
        }
    }
    if(flag==false){
        System.out.println("Have no any Book");
    }
}

    public void printBook() {
        if (list.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("BOOKS LIST: ");
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");
            System.out.println("|    ID    |   NAME   |   PRICE  |  QUANITY  | SUBTOTAL | PUBLISHER NAME     |         STATUS      |");
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");
            Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1.getQuanity()!= b2.getQuanity()) {
                    return b1.getQuanity()- b2.getQuanity();
                } else {
                    return (int)(b1.getPrice() - b2.getPrice());
                }
            }
        });
            for (int i = 0; i < list.size(); i++) {
                list.get(i).showInfo();

            }
            System.out.println("+----------+----------+----------+-----------+----------+--------------------+---------------------+");

        }
    }
    public void updateBook(){
        id = Validation.regexString("Input id: ", "Invalid id , try again", "^[B]\\d{5}");
        int index =kiemtraID(id);
        if(index == -1){
            System.out.println("No ID to update");
        }else{
            String name = Validation.updateString("Input new book's name: ",list.get(index).getName());
        double price = Validation.updateADouble("Input new book's price: ", 0,list.get(index).getPrice());
        int quanity = Validation.updateAnInteger("Input new book's quanity: ", 0,list.get(index).getQuanity());
        String status = Validation.updateString("Input new book's status: ", list.get(index).getStatus());
        list.get(index).setName(name);
        list.get(index).setPrice(price);
        list.get(index).setQuanity(quanity);
        list.get(index).setStatus(status);  
        
        }
    }
    public void saveBooksToFile() {
    try {
        FileOutputStream fos = new FileOutputStream("file\\Book.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list); 
        oos.close();
        fos.close();
        System.out.println("Data saved to file successfully.");
    } catch (IOException e) {
    }
}

public void readBooksFromFile() {
    try {
        FileInputStream fis = new FileInputStream("file\\Book.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<Book>) ois.readObject();
        ois.close();
        fis.close();
        printBook();
    } catch (IOException | ClassNotFoundException e) {
    }

}
    

}
