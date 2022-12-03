import java.util.*;
import java.time.* ;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class Personal_Utility implements Serializable
{
    /*
     * Here,productlist - is arraylist that store all products in inventory as object.
     *      customerlist - is arraylist that store all products customer bought.
     *      storetransactions - is arraylist to store all transaction occurred.
     * 
     * Also transaction,inventory,customer are ref. variables to access methods. 
     */
    private ArrayList<Inventory> productlist = new ArrayList<Inventory>() ;
    private ArrayList<Inventory> customerlist = new ArrayList<Inventory>() ;
    private ArrayList<Transactions> storetransactions = new ArrayList<Transactions>() ;
    private Transactions transaction ;
    private Inventory inventory ;
    private Inventory customer ;

    /*
     *  LocalDateTime - used for getting local date and time.
     *  DateTimeFormatter - used for formatting date and time in special way.
     * 
     *  transient is used to avoid serialization it throws exception NotSerializableException if 
     *  tried to serialization.
     *  Only primitives and classes that implement Serializable interface can be serialized.
     *  Classes like Scanner,LocalDateTime,DateTimeFormatter generally throws NotSerializableException.
     */
    private transient Random randomno = new Random();
    private transient LocalDate Current_Date = LocalDate.now() ;        
    private transient LocalTime Current_Time = LocalTime.now() ;
    private transient DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM") ;
    private transient DateTimeFormatter TimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss a ") ;

    private long ItemId = 0 ;
    private String Customer_Name = " ";

    /*
     * purchase method to add product and assign a id to product.
     * 
     * inventory.Buy() - Buy Method of inventory class refer to that
     * 
     * inventory.Check_Productname() - Get Methods of inventory class refer to that
     * inventory.Check_Buyingprice()
     * inventory.Check_Buyquantity()
     * 
     * productlist.add(inventory) - Adding Product in resp. Arraylist
     * storetransactions.add(transaction) - Storing buying transaction in resp. Arraylist
     */
    public void purchase()
    { 
        int flag = -1 ;
        ItemId = randomno.nextLong(100000000 , 1000000000) ;
        if(productlist.size() == 0)
        {
            flag = 0 ;
        }
        else
        {
            for(int i = 0 ; i < productlist.size() ; i++)
            {   
                inventory = productlist.get(i);
                if(ItemId == inventory.Check_Itemid()) 
                {
                    flag = 1 ;
                }
                else
                {
                    flag = 0 ;
                }
            }
        }

        if(flag == 1)
        {
            purchase();
        }
        else
        {
            inventory = new Inventory(ItemId) ;
            inventory.Buy();                                   // Buy Method of inventory class
            productlist.add(inventory) ;

            System.out.println("\nProduct Registered Sucessfully") ;
            System.out.println("Product ID Is: " + ItemId) ;
            System.out.println("\n") ;

            String ProductName = inventory.Check_Productname(); // Get Methods of inventory class 
            long Buyingprice = inventory.Check_Buyingprice();
            int BuyQuantity = inventory.Check_Buyquantity();
            transaction = new Transactions(ProductName , "Purchased" , Buyingprice , BuyQuantity) ;
            storetransactions.add(transaction) ;
        }    
    }

    /*
     * sell method to sell product.
     * 
     * productlist.get(i) - to get product stored in arraylist at that index.
     * 
     * inventory.Check_Itemid() - Get Methods of inventory class refer to that
     * 
     * customerlist.add(inventory) - Adding Product in resp. Arraylist (customerlist Arraylist).
     * storetransactions.add(transaction) - Storing buying transaction in resp. Arraylist.
     */
    public void sell()
    {
        int choice1 = -1;
        do
        {
            int choice = -1 ;                    
            while (choice != 1)
            {
                ItemId = check_productid() ;                        
                for(int i = 0 ; i < productlist.size() ; i++)
                {
                    inventory = productlist.get(i) ;
                    if(ItemId == inventory.Check_Itemid())
                    {
                        choice = 1 ;
                        inventory.sell() ;
                        if (customerlist.size() == 0) 
                        {
                            customerlist.add(inventory) ;
                        } 
                        else 
                        {
                            for(int j = 0 ; j < customerlist.size() ; j++)
                            {
                                customer = customerlist.get(j) ;
                                if(ItemId != customer.Check_Itemid())
                                {
                                    customerlist.add(inventory) ;
                                }
                            }
                        }
                        
                        String ProductName = inventory.Check_Productname();
                        long Selling_price = inventory.Check_Sellingprice();
                        int SellQuantity = inventory.Check_Sellquantity();
                        transaction = new Transactions(ProductName , "Sold" , Selling_price , SellQuantity) ;
                        storetransactions.add(transaction) ;

                        break ;
                    }
                    else
                    {
                        choice = 0 ;
                    }                           
                }
                if(choice == 0)
                {
                    System.out.println("Invalid Item Id Please Enter Again ") ;
                }
                System.out.println("\n1 . To sell more") ;
                System.out.println("2 . To print Receipt") ;
                choice1 = check_choice();
            } 
        }while(choice1 == 1) ;
    }

    /*
     * CustomerReceipt method to print Receipt
     * 
     * customerlist.get(i) - to get product stored in arraylist at that index.
     * 
     * customer.Check_Sellingprice() - Get Methods of inventory class refer to that.
     * customer.setReceiptvalues() - Set Method of  inventory class refer to that(Sets value of product to zero).
     * 
     * customerlist.clear() - clears customer arraylist after printing so it can be used for another customer. 
     */
    public void CustomerReceipt()
    {
        long Total_Amount = 0 ;
        Scanner Sc = new Scanner(System.in);

        System.out.println("\nEnter Details To Print Receipt") ;           
        System.out.print("Customer_Name: ") ;

        Customer_Name = Sc.nextLine() ;
        Customer_Name = capitailizeWord(Customer_Name) ;

        System.out.println("\nPrinting Receipt......") ;

        String dateString = Current_Date.format(DateFormatter) ;
        String timeString = Current_Time.format(TimeFormatter) ;

        System.out.println("\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/--/-/-/-/--/-/-/- Receipt -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-") ;

        System.out.print("\nDate: " + dateString) ;
        System.out.print("\t\t\t\t" + "Receipt No:" + Inventory.Receipt_No()) ;
        System.out.print("\t\t\t\t" + "Time: " + timeString) ;

        System.out.println("\nName: " + Customer_Name) ;

        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%1s %15s %15s %25s %5s %18s %12s %18s %12s %18s %12s", "|","Item", "|" , "Manufacturer/Author" , "|", "Price($)", "|", "Quantity" ,"|","Total Cost","|"));
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------------------------------------------------------"));

        for(int i = 0 ; i < customerlist.size() ; i++)
        {
            customer = customerlist.get(i) ;
            customer.Customer_Productlist();
            Total_Amount = Total_Amount + customer.Check_Sellingprice() * customer.Check_ReceiptQuantity() ;
            customer.setReceiptvalues(); 
        }

        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println("\nTotal Amount: " + Total_Amount) ; 
        System.out.println("\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- Thank you for Buying -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-") ;
        System.out.println("\n") ;
        
        customerlist.clear() ;
    }

    /*
     * CustomerReceipt method to print Receipt
     * 
     * Inventory.Totalprofitloss() - Totalprofitloss method of inventory class refer to that.
     * inventory.ProfitLoss() - profitloss method of inventory class refer to that.
     * 
     * check_productid() - Method of current class refer to that.
     */
    public void ProfitLoss()
    {
        int choice = -1 ;
        do 
        {
            System.out.println("\n1 . For All Products") ;
            System.out.println("2 . For Individual Product") ;
            System.out.println("0 . To go back") ;

            choice = check_choice();
            switch (choice)
            {
            case 1 :             
                Inventory.Totalprofitloss();
                choice = 0 ;
                break;
                        
            case 2 :              
                while (choice != 1)
                {
                    ItemId = check_productid();
            
                    for(int i = 0 ; i < productlist.size() ; i++ )
                    {
                        inventory = productlist.get(i) ;
                        if(ItemId == inventory.Check_Itemid())
                        {
                            choice = 1 ;
                            inventory.ProfitLoss() ;
                            break ;
                        }
                        else
                        {
                            choice = 0 ;
                        }  
                    }
                    if(choice == 0)
                    {
                        System.out.println("Invalid Item Id Please Enter Again ") ;
                    }
                } 
                System.out.println("\n") ;
                choice = 0 ;
                break;

            case 0:
                System.out.println("\nThank You For Buying\n") ;
                break;
            default :            
                System.out.println("\nEnter Valid Choice!!\n") ;
            }
        } while (choice != 0);
    }

    /*
     * productinfo method to Display product info.
     * 
     * inventory.Product_info() - Product_info method of inventory class refer to that.
     * inventory.ProfitLoss() - profitloss method of inventory class refer to that.
     * 
     * capitailizeWord - Method of current class refer to that.
     */
    public void productinfo()
    {
        int choice = -1 ;
        Scanner Sc = new Scanner(System.in) ;
        do 
        {      
            System.out.println("\n1 . Search By Product Name") ;
            System.out.println("2 . Search By Author/Manufacturer Name") ;
            System.out.println("\n0 . To Go Back\n") ;

            choice = check_choice();
            switch (choice) 
            {
            case 1:
                int choice1 = -1 ;
                while (choice1 != 1)
                {
                    System.out.print("Enter Product Name: ") ;
                    String Product_Name = Sc.nextLine() ;
                    Product_Name = capitailizeWord(Product_Name) ;

                    for(int i = 0 ; i < productlist.size() ; i++ )
                    {
                        inventory = productlist.get(i) ;
                        if( Product_Name.equals(inventory.Check_Productname()))
                        {
                            choice1 = 1 ;
                            inventory.Product_info() ;
                            break ;
                        }
                        else
                        {
                            choice1 = 0 ;
                        }
                                        
                    }
                    if(choice1 == 0)
                    {
                        System.out.println("Product Not Found Enter Again ...... ") ;
                    }                    
                }
                choice = 0 ;
                break;
                            
            case 2:
                choice1 = -1 ;
                while (choice1 != 1)
                {
                    System.out.print("Enter Author/Manufacturer Name: ") ;
                    String Author_Name = Sc.nextLine() ;
                    Author_Name = capitailizeWord(Author_Name) ;

                    for(int i = 0 ; i < productlist.size() ; i++ )
                    {
                        inventory = productlist.get(i) ;
                        if( Author_Name.equals(inventory.Check_Authorname()) )
                        {
                            choice1 = 1 ;
                            inventory.Product_info() ;
                            break ;
                        }
                        else
                        {
                            choice1 = 0 ;
                        }
                                        
                    }
                    if(choice1 == 0)
                    {
                        System.out.println("Author/Manfacturer Not Found Enter Again ..... ") ;
                    }                   
                }
                choice = 0 ;
                break;
            case 0:
                break ;

            default :
                System.out.println("\nEnter Valid Choice!!\n") ;
            }
        } while (choice != 0);
        System.out.println("\n") ;
    }

    /*
     * productinfo method to Display List of all products.
     * 
     * inventory.Check_Itemquantity()- Get method of inventory class refer to that.
     * inventory.Product_list() - Product_list method of inventory class refer to that.
     */
    public void productlist()
    {
        System.out.print("\n") ;
        System.out.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%1s %19s %11s %17s %13s %18s %12s %25s %5s", "|" , "Product ID", "|" , "Item" , "|", "Price($)", "|", "Manufacturer/Author" ,"|"));
        System.out.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------"));

        for(int i = 0 ; i < productlist.size() ; i++)
        {
            inventory = productlist.get(i) ;
            if(inventory.Check_Itemquantity() == 0)
            {
                continue ;
            }
            else
            {
                inventory.Product_list() ;
                System.out.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------"));
            }                  
        }
        System.out.println("\n") ;
       
    }

    /*
     * Storestock method to Display Stock present in store.
     * 
     * Inventory.Total_Quantity() - Total_Quantity method of inventory class refer to that.
     */
    public void Storestock()
    {
        System.out.println("\n") ;
        Inventory.Total_Quantity() ;
        System.out.println("\n") ;
    }

    /*
     * Transactionhistory method to Display Stock present in store.
     * 
     * transaction.Transaction_History()- Transaction_Historymethod of transacation class refer to that.
     */
    public void Transactionhistory()
    {
        System.out.println("\n");
        System.out.println(String.format("%s", "-----------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%1s %18s %6s %17s %8s %14s %6s %15s %7s %19s %4s", "|","Date & Time","|","Product Name","|","Quantity","|","Price($)","|","Transcation_Type","|")) ;
        System.out.println(String.format("%s", "-----------------------------------------------------------------------------------------------------------------------------"));
        for(int i = 0 ; i < storetransactions.size() ; i++)
        {
            transaction = storetransactions.get(i) ;
            transaction.Transaction_History();
            System.out.println(String.format("%s", "-----------------------------------------------------------------------------------------------------------------------------"));                       
        }
        System.out.println("\n") ;
    }

    /*
     * Productedit method to Edit Info Of Product.
     * 
     * inventory = productlist.get(i) - used to get product at paricular index.
     * inventory.Check_Itemid() - Get method of invenory class refer to that.
     * inventory.Product_info() - used to get product info.
     * 
     * inventory.setProduct_Name(Product_Name) - Set methods of inventory class.
     * inventory.setManufacturer(Manufacturer) 
     * inventory.setMRP(MRP) 
     */ 
    public void Productedit()
    {
        int choice = -1 ;
        Scanner Sc = new Scanner(System.in);
        while (choice != 1)
        {
            ItemId = check_productid();
            for(int i = 0 ; i < productlist.size() ; i++ )
            {
                inventory = productlist.get(i) ;
                if(ItemId == inventory.Check_Itemid())
                {
                    choice = 1 ;
                    break ;
                }
                else
                {
                    choice = 0 ;
                }  
            }
            if(choice == 0)
            {
                    System.out.println("Invalid Item Id Please Enter Again ") ;   
            }
        } 

        inventory.Product_info();
        choice = -1 ;     
        do
        {
            System.out.println("\n1 . Edit Product Name") ;
            System.out.println("2 . Edit Manufacturer Name") ;
            System.out.println("3 . Edit MRP") ;
            System.out.println("\n0.To Go Back\n") ;

            choice = check_choice() ;
            switch (choice) 
            {
                case 1:
                    System.out.print("\nEnter Product Name: ") ;
                    String Product_Name = Sc.nextLine() ;
                    Product_Name = capitailizeWord(Product_Name) ;
                    inventory.setProduct_Name(Product_Name);
                    break;

                case 2:
                    System.out.print("\nEnter Manufacturer Name: ") ;
                    String Manufacturer = Sc.nextLine() ;
                    Manufacturer = capitailizeWord(Manufacturer) ;
                    inventory.setManufacturer(Manufacturer);
                    break;

                case 3:
                    System.out.print("\nEnter Market Retail Price: ") ;
                    long MRP = Sc.nextLong() ;
                    inventory.setMRP(MRP);
                    break;

                case 0:
                    System.out.println("\n") ;
                    break;
                default:
                    System.out.println("Please Provide A Valid Choice !!!") ;
            }
        }while(choice != 0);
    }

    /*
     * writeInfoToFile method to store data in a file.
     * 
     * Here,file1 - is object that do operation on "StoreProducts.txt" file that will store
     *              Registered Products And Their All Info.
     *      file2 - is object that do operation on "StoreTransactionHistory.txt"file that will 
     *              store Transaction History of store.
     *      createNewFile() - creates new file of given name and path.
     *  
     *      fileOutputStream - is object of FileOutputStream. 
     *      writer - is object of ObjectOutputStream.
     */
    public void writeInfoToFile() 
    {
        File file1 = new File("StoreProducts.txt");
        if (!file1.exists())                            // If file1 does not exists it creates new file.
        {
            try 
            {
                file1.createNewFile();
            } 
            catch (IOException e) 
            {
                throw new RuntimeException(e);
            }
        }

        File file2 = new File("StoreTransactionHistory.txt");
        if (!file2.exists())                            // If file2 does not exists it creates new file.     
        {
            try 
            {
                file2.createNewFile();
            } 
            catch (IOException e) 
            {
                throw new RuntimeException(e);
            }
        }

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream writer = null;
        try 
        {
            fileOutputStream = new FileOutputStream(file1);          //assigning file1 with fileoutputstream
            writer = new ObjectOutputStream(fileOutputStream);       //assigning fileoutputstream with writer
            writer.writeObject(productlist);                         //writing object productlist

            fileOutputStream = new FileOutputStream(file2);          //assigning file1 with fileoutputstream
            writer = new ObjectOutputStream(fileOutputStream);       //assigning fileoutputstream with writer
            writer.writeObject(storetransactions);                   //writing object productlist
        } 
        catch (IOException e) 
        {
            throw new RuntimeException(e);
        } 
        finally 
        {
            try 
            {
                writer.close();                                     //closing writer and fileoutputstream
                fileOutputStream.close();
            } 
            catch (IOException e) 
            {
                throw new RuntimeException(e);
            }
        }
    }

    /*
     * getInfoFromFile method to store data in a file.
     * 
     * Here,file1 - is object that do operation on "StoreProducts.txt" file that stores
     *              Registered Products And Their All Info.
     *      file2 - is object that do operation on "StoreTransactionHistory.txt"file that
     *              stores Transaction History of store.
     *  
     *      fileInputStream - is object of FileInputStream. 
     *      input - is object of ObjectInputStream.
     */
    public void getInfoFromFile() 
    {
        File file1 = new File("StoreProducts.txt");
        if (!file1.exists()) return;                    //checks if file exists if not ends method(returns)

        File file2 = new File("StoreTransactionHistory.txt");
        if (!file2.exists()) return;                    //checks if file exists if not ends method(returns)

        FileInputStream fileInputStream = null;
        ObjectInputStream input = null;
        try 
        {
            fileInputStream = new FileInputStream(file1);                   //assigning file1 with fileInputstream
            input = new ObjectInputStream(fileInputStream);                 //assigning fileInputstream with input
            productlist = (ArrayList<Inventory>) input.readObject();        //reading object from file and storing in productlist with typecasting in (ArrayList<Inventory>)

            fileInputStream = new FileInputStream(file2);                   //assigning file1 with fileInputstream
            input = new ObjectInputStream(fileInputStream);                 //assigning fileInputstream with input
            storetransactions = (ArrayList<Transactions>) input.readObject();//reading object from file and storing in storetransactions with typecasting in (ArrayList<Inventory>)
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try 
            {
                input.close();                                              //closing input and fileInputStream
                fileInputStream.close();
            } 
            catch (IOException e) 
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void setstaticvariables()
    {
        for(int i = 0 ; i < productlist.size() ; i++)
        {
            inventory = productlist.get(i) ;
            inventory.setstaticvariables() ;
        }
    }

    /*
     *  ccheck_choice method is to check if choice is valid or not .
     */
    public int check_choice()
    {
        int choice = 0 , flag = -1 ;
        do
        {
            Scanner Sc = new Scanner(System.in) ;
            try 
            {
                System.out.print("Enter The Choice: ") ;
                choice = Sc.nextInt() ;
                flag = 1 ;
                break ;
            } 
            catch(InputMismatchException e)
            {
                System.out.println("Oops ... Wrong Input Please provide a no. as input\n") ;
                flag = 0 ;
            }
        }while(flag != 1) ;
        return choice ;
    }

    /*
     *  check_productid method is to check if id is valid or not .
     */
    public long check_productid()
    {
        long Item_Id = 0 ;
        Scanner Sc = new Scanner(System.in) ;
        try
        {
            System.out.print("\nEnter Product_Id: ") ;
            Item_Id = Sc.nextLong() ;
        } 
        catch (Exception e) 
        {
            System.out.println("Oops ... Wrong Input Please provide only a no. as input\n") ;
        }
        return Item_Id ;
    }

    /*
     * capitailizeWord method takes a string(name) and makes it capitlized
     * 
     * s.append(Character.toUpperCase(str.charAt(i))) - appends character in s also at same time capitlize them.
     * s.append(Character.toLowerCase(str.charAt(i))) - appends character in s also at same time decapitlize them.
     * 
     * ch = str.charAt(i) - gets character at i index.
     * s.toString().trim() - trims s and convert it into string ;
     */
    public static String capitailizeWord(String str) 
    {
        StringBuffer s = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < str.length(); i++) 
        {
             
            if (ch == ' ' && str.charAt(i) != ' ')
            {
                s.append(Character.toUpperCase(str.charAt(i)));
            }    
            else
            {
                s.append(Character.toLowerCase(str.charAt(i)));
            }    
            ch = str.charAt(i);
        }
        return s.toString().trim();
    }
}