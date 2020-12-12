/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order_inquire_app;
import java.util.Scanner;
import QueuePack.ArrayQueue;
import DoublyPack.DList;


/**
 *
 * @author Cuizon, Cyrex Joshua
 *         Rufano, Peter Paulo 
 */
public class Order_Inquire_App {
    static Scanner sc = new Scanner(System.in);
    static  ArrayQueue<String> strq = new ArrayQueue<>();
    static DList<Items> item = new DList<>();
    static boolean bol = true;
    
    static String name, history = "", hisItem = "";
    static int count = 1;
    
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args){
      SystemStart();     
    }
    
    public static void SystemStart(){
       System.out.print("\n\n\nManagement Com App\n\n");
       System.out.print("Please Select():\n");
       System.out.print("(1) Serve\n");
       System.out.print("(2) Items Management\n");
       System.out.print("(3) Exit\n");
       
       System.out.print("\n\n\n\n");
       System.out.print("Select : ");
       
        int choice = sc.nextInt();
       
       switch(choice){
           case 1:
                Serve();
                break;
            case 2:
                ItemsManage();
                break;
            case 3:
                Exit();
                break;
       }
    }
    
    public static void Serve(){
            
                System.out.print("Enter Your Name for Ticket Queue\n");
                System.out.print(": ");
                name = sc.next();
                
                
                strq.enqueue(name);
                history+="Priority #:" + count + "    Name: " + name + "\n";
                
                count++;
               
                
         System.out.print("Add Another to Queue? \n");
         System.out.print("[1] Yes\n");
         System.out.print("[2] No\n");
         System.out.print(": ");
         int choice = sc.nextInt();
         
          System.out.print("\n\n\n");
          
         switch(choice){
             case 1:
                 Serve();
                 break;
             case 2:
                 Running();
                 break;
         }
         
          
    }
    
     public static void Running(){
         
                while(bol){
                    
                    if(strq.isEmpty()){
                        System.out.print("\nIs Empty : " + strq.isEmpty() + "\n");
                        System.out.print("Queue is now Empty\n");
                        bol = false;
                    }else{
                            System.out.println("\nFirst Serve : " + strq.first() + " \n");
                            strq.dequeue();
                            customerOnRun();
                            System.out.println("Press Enter For Next Queue \n");
                            sc.nextLine();
                    }
                }
         
         SystemStart();
                   
                
    }
     
     public static void customerOnRun(){
         System.out.print("Item: \n\n");
         System.out.print(hisItem);
         System.out.print("\n\n");
         System.out.print("NOTE: Only First and Last you can Choose as avaiable and Look closely the Item you choose\n");
         System.out.print("Choose\n");
         System.out.print("[1] First \n");
         System.out.print("[2] Last\n");
         System.out.print(": ");
         
         int choice = sc.nextInt();
        
        if(choice == 1){
                System.out.print("Selected : \n" + "ID : "+ item.first().getItemID() + " \n"+" Item Name : " + item.first().getItemName() + "\n" + "Item Price : " +  item.first().getItemPrice()+ "\n\n");
                System.out.print("Do you want to buy this item?\n");
                System.out.print("Choose\n");
                System.out.print("[1] Yes \n");
                System.out.print("[2] No\n");
                System.out.print(": ");
                int choice1 = sc.nextInt();
                
                if(choice1 == 1){
                    item.removeFirst();
                    System.out.print("Item is on Cart");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    Running();
                     
                }else{
                    System.out.print("Customer did not Buy\n");
                    System.out.print("Going back ....");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    Running();
                }
                
                
                
        }
        else if(choice == 2){
             System.out.print("Selected : \n" + "ID : "+ item.last().getItemID() + " \n"+" Item Name : " + item.last().getItemName() + "\n" + "Item Price : " + item.last().getItemPrice()+"\n\n");
                System.out.print("Do you want to buy this item?\n");
                System.out.print("Choose\n");
                System.out.print("[1] Yes \n");
                System.out.print("[2] No\n");
                System.out.print(": ");
                int choice2 = sc.nextInt();
                
                if(choice2 == 1){
                    item.removeLast();
                    System.out.print("Item is on Cart");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    Running();
                     
                }else{
                    System.out.print("Customer did not Buy\n");
                    System.out.print("Going back ....");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    Running();
                }
        }
}
    
    public static void ItemsManage(){
        System.out.print("Item Management()\n");
        System.out.print("(1) Display Items\n");
        System.out.print("(2) Add Items\n");
        System.out.print("(3) Remove Items\n");
        System.out.print("(4) Back\n");
        
        System.out.print("\n\n\n\n");
        System.out.print("Select : ");
        
        int choice = sc.nextInt();
        
        switch(choice){
            case 1:
                DisplayItems();
            case 2:
                AddItems();
                break;
            case 3:
                RemoveItems();
                break;
            case 4:
                SystemStart();
                break;
        }
    }
    public static void DisplayItems(){
        if(item.isEmpty()){
            System.out.print("There is no item available.\n");
            System.out.print("Going back....");
            System.out.print("\n\n\n\n");
            sc.nextLine();
            
            ItemsManage();
        }
        System.out.print(hisItem);
        
        sc.nextLine();
        System.out.print("\n\n\n\n");
        
        System.out.print("#Items : " + item.size() + "\n");
        System.out.print("Options Available\n");
        System.out.print("[1] Remove Items \t\t [2] Add Items \t\t [3] Back\n\n");
        int choice = sc.nextInt();
        
        switch(choice){
            case 1 -> RemoveItems();
            case 2 -> AddItems();
            case 3 -> ItemsManage();
        }
        
    }
    public static void AddItems(){
        int a;
        double price;
        String des = "", n = "",brand = "", made = "";
        
        System.out.print("AddItems()\n\n");
        System.out.print("\n\n\n\n\n");
        
        System.out.print("Name of the Item\n");
        n = sc.next();
        System.out.print("\n\n\n\n\n");
        
        System.out.print("Description of the " + n + " \n");
        des = sc.next();
        System.out.print("\n\n\n\n\n");
        
        System.out.print("Brand of the " + n + " \n");
        brand = sc.next();
        System.out.print("\n\n\n\n\n");
        
        System.out.print("Made In ?\n");
        made = sc.next();
        System.out.print("\n\n\n\n\n");
        
        System.out.print("Price of the " + n + "\n");
        price = sc.nextInt();
        System.out.print("\n\n\n\n\n");
        
        System.out.print("ID of the Item\n");
        a = sc.nextInt();
        System.out.print("\n\n\n\n\n");
       
        hisItem+="Item ID : " + a + " \t" + "Item Name : " + n + "\t" + "Description : " + "\t"+ " Brand : " + brand + "\t" + "MadeIn : " + made + "\t" + "Price : PHP " + price + "\t\n\n";
        
        
        Items awd = new Items(a, n, des, brand, made, price);
        
        item.addFirst(awd);
        
        
        System.out.print("Do you still want to Add Item?\n");
        System.out.print("[1] Yes\n");
        System.out.print("[2] No\n");
        System.out.print(": ");
        int choice = sc.nextInt();
        
        
        switch(choice){
            case 1:
                AddItems();
                break;
            case 2:
                Show();
                break;
        }
        
    }
    
    public static void Show(){
        System.out.print("This is the items you added : \n\n\n\n");
        System.out.print(hisItem);
        System.out.print(item.first().getItemID() + "\n");
        
        System.out.print("Size : " + item.size() + "\n");
        System.out.print("Going back....");
        System.out.print("\n\n\n\n");
        sc.nextLine();

        ItemsManage();
    }
    public static void RemoveItems(){
        
        System.out.print("Selected Removing Items\n\n");
        System.out.print("Removing Out off the Inventory\n");
        System.out.print("NOTE: You can only remove First and Last\n");
        System.out.print("NOTE: To be Sure in Deleting the Item \n" );
        System.out.print("Please Look closely the ID of the Item \n");
        sc.nextLine();
        System.out.print("\n\n\n\n");
        
        
        if(item.isEmpty()){
            System.out.print("There is no item available.\n");
            System.out.print("Going back....");
            System.out.print("\n\n\n\n");
            sc.nextLine();
            
            ItemsManage();
        }
        
        System.out.print(hisItem);
        System.out.print("\n\n");
        System.out.print("Select to Remove\n");
        System.out.print("[1] First \n");
        System.out.print("[2] Last\n");
        System.out.print(": ");
        int choice = sc.nextInt();
        
        if(choice == 1){
                System.out.print("Selected : \n" + "ID : "+ item.first().getItemID() + "\n"+"Item Name : " + item.first().getItemName() + "\n\n");
                System.out.print("Do you want to remove this item?\n");
                System.out.print("Choose\n");
                System.out.print("[1] Yes \n");
                System.out.print("[2] No\n");
                System.out.print(": ");
                int choice1 = sc.nextInt();
                
                if(choice1 == 1){
                    item.first().setItemName("NOT AVAILABLE");
                    item.removeFirst();
                    System.out.print("Item is Removed");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    RemoveAgain();
                     
                }else{
                    System.out.print("Going back ....");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    RemoveItems();
                }
                
                
                
        }
        else if(choice == 2){
             System.out.print("Selected : \n" + "ID : "+ item.last().getItemID() + " \n"+" Item Name : " + item.last().getItemName() + "\n\n");
                System.out.print("Do you want to remove this item?\n");
                System.out.print("Choose\n");
                System.out.print("[1] Yes \n");
                System.out.print("[2] No\n");
                System.out.print(": ");
                int choice2 = sc.nextInt();
                
                if(choice2 == 1){
                    item.last().setItemName("NOT AVAILABLE");
                    item.removeLast();
                    System.out.print("Item is Removed");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    RemoveAgain();
                     
                }else{
                    System.out.print("Going back ....");
                    System.out.print("\n\n\n\n");
                    sc.nextLine();
                    RemoveItems();
                }
        }
        
    }

    public static void RemoveAgain(){
        System.out.print("Do you want to remove again?\n");
        System.out.print("[1] Yes\n");
        System.out.print("[2] No\n");
        System.out.print(": ");
        int choice = sc.nextInt();
        
        if(choice == 1){
            System.out.print("\n\n\n\n");
            RemoveItems();
        }else{
            System.out.print("Going Back....");
            System.out.print("\n\n\n\n");
            sc.nextLine();
            ItemsManage();
        }
    }
    
   
    public static void Exit(){
        
        System.out.print("System Closing......\n");
       
        System.exit(0);    
    }

    
    
    
    
    
    
}
