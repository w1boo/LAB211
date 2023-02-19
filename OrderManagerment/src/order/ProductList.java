/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Khoa
 */
public class ProductList {
    public ArrayList<Product> list = new ArrayList<>();
public HashMap<String, Product> readProductsFile(String filename) {
        HashMap<String, Product> productMap = new HashMap<>();
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
            productMap.put(productID, product);
            list.add(product);

        }
    } catch (IOException e) {
        System.out.println("Cant read the file");;
    }
    return productMap;
}
    public void printProductsFile(String filename) {
        list.clear();
        readProductsFile(filename);
        for (Product product : list){
            System.out.println(product.toString());
        }
    }
}
