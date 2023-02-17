/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Khoa
 */
public class ProductList {
    public ArrayList<Product> list = new ArrayList<>();
public void readProductsFile(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] productInfo = line.split(",");
            String productID = productInfo[0];
            String productName = productInfo[1];
            String unit = productInfo[2];
            String origin = productInfo[3];
            double price = Double.parseDouble(productInfo[4]);
            Product product = new Product(productID, productName, unit, origin,price);
            list.add(product);
            list.toString();
        }
    } catch (IOException e) {
        System.out.println("Cant read the file");;
    }
}
public void printProductsFile(String filename) {
    readProductsFile(filename);
    for (Product product : list) {
        System.out.println(product.toString());
    }
}
}
