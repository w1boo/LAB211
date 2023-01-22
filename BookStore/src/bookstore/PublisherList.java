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
public class PublisherList {
    String id;
    static String filePath = "file\\Publisher.dat";
    private ArrayList<Publisher> list = new ArrayList();
    public ArrayList<Publisher> getList() {
    return list;
}
    public void addPublisher() {
        int index ;
        do {
            id = Validation.regexString("Input id(Pxxxxx): ", "Invalid input , try again.", "^[P]\\d{5}$");
            index = kiemtraID(id);

            if (index >= 0) {
                System.out.println("ID already in list. Try again");
            }
        } while (index >= 0);
        String name = Validation.regexString("Input name:", "Invalid input , try again", "^[^\\d]{5,30}$");
        long phoneNumber = Validation.inputPhoneNumber();
        list.add(new Publisher(id, name, phoneNumber));
        System.out.println("PUBLISHER ADDED ");
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).showInfo();
//            
//        }
    }

    public void printPublishers() {
        if (list.isEmpty()) {
            System.out.println("No publishers found.");
        } else {
            System.out.println("PUBLISHERS LIST: ");
            System.out.println("+----------+----------+--------------------+");
            System.out.println("|    ID    |   NAME   |     PHONE NUMBER   |");
            System.out.println("+----------+----------+--------------------+");
            Collections.sort(list, new Comparator<Publisher>() {
    @Override
    public int compare(Publisher p1, Publisher p2) {
        return p1.getName().compareTo(p2.getName());
    }
});
            for (int i = 0; i < list.size(); i++) {
                list.get(i).showInfo();

            }
            System.out.println("+----------+----------+--------------------+");

        }
    }

    public int kiemtraID(String IdKiemTra) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(IdKiemTra)) {
                return i;
            }

        }
        return -1;

    }
public Publisher findPublisher(String id) {   
    for (Publisher publisher : list) {
        if (publisher.getId().equals(id)) {
            return publisher;
        }
    }
    return null;
}

    public void deletePublisher() {
        String id = Validation.regexString("Input id:", "Invalid ID , try again", "^[P]\\d{5}$");
        int index = kiemtraID(id);
        if (index == -1) {
            System.out.println("Publisher’s Id does not exist");

        } else {
            list.remove(index);
            System.out.println("Remove success");
        }
    }
public void savePublishersToFile() {
    try {
        FileOutputStream fos = new FileOutputStream("file\\Publisher.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list); 
        oos.close();
        fos.close();
        System.out.println("Data saved to file successfully.");
    } catch (IOException e) {
    }
}

public void readPublishersFromFile() {
    try {
        FileInputStream fis = new FileInputStream("file\\Publisher.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<Publisher>) ois.readObject();
        ois.close();
        fis.close();
        printPublishers();
    } catch (IOException | ClassNotFoundException e) {
    }

}
//public void checkFilePath() {
//    System.out.println("File path: " + filePath);
//    File file = new File(filePath);
//    if(file.exists()) {
//        System.out.println("File exists at the given path: "+ file.getAbsolutePath());
//    } else {
//        System.out.println("File does not exist at the given path"+ file.getAbsolutePath());
//    }
//}

}
