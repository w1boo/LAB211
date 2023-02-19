/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.HashMap;
import java.util.Scanner;
import order.Customer;
import order.CustomerList;
import order.ProductList;
import order.OrderList;
        
/**
 *
 * @author Khoa
 */
public class main {
    public static void main(String[] args) {
        int Menuchoice,Subchoice;
        CustomerList cL = new CustomerList();
        ProductList pL = new ProductList();
        OrderList oL= new OrderList(cL,pL);
        HashMap<String, Customer> customerMap = cL.readCustomersFile("customers.txt");
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("MAIN MENU: ");
            System.out.println("1. List all products from file");
            System.out.println("2. List all customers from file");
            System.out.println("3. Find customer ID");
            System.out.println("4. Add a customer");
            System.out.println("5. Update a customer");
            System.out.println("6. Save customer to file");
            System.out.println("7. print all orders");
            System.out.println("8. Print pending orders");
            System.out.println("9. Add new order");
            System.out.println("10.Update order ");
            System.out.println("11.Save order to file");
            System.out.println("12.Exit");
            System.out.print("Choose your option: ");
            Menuchoice = sc.nextInt();
            sc.nextLine();
            switch (Menuchoice) {
                case 1:
                    pL.printProductsFile("products.txt");
                    break;
                case 2:

                    cL.printCustomersFile("customers.txt");
                    break;
                case 3:
                    cL.SearchCustomer();
                    break;
                case 4:
                    cL.addCustomer();
                    break;
                case 5:
                    cL.updateCustomer();
                    break;
                case 6:
                    cL.saveCustomersToFile();
                    break;
                case 7:
                    oL.PrintOrdersFromFile("orders.txt");
                    break;
                case 8:    
                    oL.printPendingOrders("orders.txt");
                    break;
                case 9:
                    oL.addNewOrder();
                    break;
                case 10:
                    System.out.println("1. Update order information");
                    System.out.println("2. Delete order");
                    System.out.print("Enter your choice: ");
                    Subchoice = sc.nextInt();
                    sc.nextLine();
                    switch (Subchoice) {
                        case 1:
                            oL.updateOrder();
                            break;
                        case 2:
                            oL.deleteOrder();
                            break;
                        default:
                            System.out.println("Invalid choice, try again");
                    }
                    break;
                case 11:
                    oL.saveOrderToFile();
                    break;
                case 12:
                    break;
                default:
                    System.out.println("Invalid choice , Try again");
                    break;
            }
        }while(Menuchoice != 12);
        
    }
}
