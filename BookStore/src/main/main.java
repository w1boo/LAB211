/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import bookstore.PublisherList;
import java.util.Scanner;
import bookstore.BookList;
/**
 *
 * @author Khoa
 */
public class main {
   public static void main(String[] args) {
      PublisherList pL = new PublisherList();
      BookList bL = new BookList(pL);
      Scanner sc = new Scanner(System.in);
      int Menuchoice,publisherChoice,bookChoice;
      do{
          System.out.println("MAIN MENU: ");
        System.out.println("1. Publisher");
        System.out.println("2. Book");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    Menuchoice = sc.nextInt();
        sc.nextLine();
        switch(Menuchoice){
               case 1:
                   do{
                System.out.println("Publisher Menu:");
                System.out.println("1. Add Publisher");
                System.out.println("2. Delete Publisher");
                System.out.println("3. View Publishers");
                System.out.println("4. Save Publishers to File");
                System.out.println("5. Print Publishers from File");
                System.out.println("6. Exit to Main Menu");
                System.out.print("Enter your choice: ");
                publisherChoice = sc.nextInt();
                sc.nextLine();
                switch(publisherChoice) {
                    case 1:
                        pL.addPublisher();
                        break;
                    case 2:
                        pL.deletePublisher();
                        break;
                    case 3:
                        pL.printPublishers();
                        break;
                    case 4:
                        pL.savePublishersToFile();
                        break;
                    case 5:
                        pL.readPublishersFromFile();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                   }while(publisherChoice != 6);
                   break;
            
        case 2:
            do{
                System.out.println("Book Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. View Books");
                System.out.println("4. Search book");
                System.out.println("5. Update book");
                System.out.println("6. Save Book to File");
                System.out.println("7. Print Book from File");
                System.out.println("8. Exit to Main Menu");
                System.out.print("Enter your choice: ");
                bookChoice = sc.nextInt();
                sc.nextLine();
                switch (bookChoice) {
                    case 1:
                        bL.addBook();
                        break;
                    case 2:
                        bL.deleteBook();
                        break;
                    case 3:
                        bL.printBook();
                        break;
                    case 4:
                        bL.SearchBook();
                        break;
                    case 5:
                        bL.updateBook();
                        break;
                    case 6:
                        bL.saveBooksToFile();
                        break;
                    case 7:
                        bL.readBooksFromFile();
                        break;
                    case 8:
                        break;
                }
                if (bookChoice == 8){
                    break;
                }
            }while(bookChoice != 8);
            break;
        case 3:
            return;
        default:
            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            break;
    
        }
      }while(Menuchoice != 3);
   }
}

        
    


