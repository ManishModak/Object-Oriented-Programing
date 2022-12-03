public class Store
{
    public static void main(String[] args) 
    {
        Personal_Utility pu = new Personal_Utility() ;
        int choice = -1 ;
        pu.getInfoFromFile();                                       // getInfoFromFile Method Defined in Peronal_utility
        pu.setstaticvariables();                                    // setstaticvariables Method Defined in Peronal_utility

        System.out.println("\n-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Welcome To Store Inventory -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- \n") ;
        do 
        {
            System.out.println("1 . To Register Purchased Product ") ;
            System.out.println("2 . To Sell Product") ;
            System.out.println("3 . To Calculate Profit/Loss ") ;
            System.out.println("4 . For Individual Product Information ") ;
            System.out.println("5 . For List Of All Available Products") ;
            System.out.println("6 . For Total Stock Present In Store Of All Products") ;
            System.out.println("7 . To Display Store Transaction History") ;
            System.out.println("8 . To Edit Product Details") ;  
                
            System.out.println("\n0 . To Close Store Inventory\n") ;
            choice = pu.check_choice();
            switch (choice)                                          // MAIN MENU
            {                                                        // Try Catch Blocks For exceptions
                case 1:
                    try 
                    {
                        pu.purchase();                              // Purchase Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                       throw new RuntimeException(e);
                    }
                    break;
            
                case 2:
                    try 
                    {
                        pu.sell();                                  // Sell Method Defined in Peronal_utility
                        pu.CustomerReceipt();                       // CustomerReceipt Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    try 
                    {
                        pu.ProfitLoss() ;                           // ProfitLoss Method Defined in Peronal_utility
                    }   
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    try 
                    {   
                        pu.productinfo();                           // productinfo Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 5:
                    try 
                    {
                        pu.productlist();                           // productlist Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 6:
                    try 
                    {
                        pu.Storestock();                            // Storestock Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 7:
                    try 
                    {
                       pu.Transactionhistory();                     // Transactionhistory Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException();
                    }
                    break;

                case 8:
                    try 
                    {
                        pu.Productedit();                           // Productedit Method Defined in Peronal_utility
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException();
                    }
                    break;

                case 0:
                    pu.writeInfoToFile();                           // writeInfoToFile Method Defined in Peronal_utility
                    System.out.println("\n") ;
                    System.out.println("-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Inventory Closed -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- \n\n") ;
                    break;
                default:
                    System.out.println("\nEnter Valid Choice!!\n") ;
            }
        } while (choice != 0);
    }
}
/*
 * ********************************************************************** OUTPUT **********************************************************************
 * 
-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Welcome To Store Inventory -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- 

1 . To Register Purchased Product 
2 . To Sell Product
3 . To Calculate Profit/Loss 
4 . For Individual Product Information 
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 1

Enter Product Name: dog food
Enter Manufacturer/Author: nutella
Enter Market Retail Price: 1000
Enter Product Buying price: 750
Enter Quantity of Product: 100

Product Registered Sucessfully
Product ID Is: 432672324


1 . To Register Purchased Product 
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 1

Enter Product Name: cat food
Enter Manufacturer/Author: nutella pro
Enter Market Retail Price: 1000
Enter Product Buying price: 750
Enter Quantity of Product: 100

Product Registered Sucessfully
Product ID Is: 871766604


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 5

--------------------------------------------------------------------------------------------------------------------------------
|          Product ID           |              Item             |           Price($)            |       Manufacturer/Author     |
--------------------------------------------------------------------------------------------------------------------------------
|          432672324            |            Dog Food           |            1000               |           Nutella             |
--------------------------------------------------------------------------------------------------------------------------------
|          871766604            |            Cat Food           |            1000               |       Nutella Pro             |
--------------------------------------------------------------------------------------------------------------------------------


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 6


Total quantity of products in store is 200


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 0


-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Inventory Closed -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-


PS C:\Users\manis\Projects\OOP\Mini Project(Inventory)> cd "c:\Users\manis\Projects\OOP\Mini Project(Inventory)\" ; if ($?) { javac Store.java } ; if ($?) { java Store }

-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Welcome To Store Inventory -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-

1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 2

Enter Product_Id: 432672324  
Enter Product Selling price: 800
Enter Quantity of Product Sold: 100

1 . To sell more
2 . To print Receipt
Enter The Choice: 1

Enter Product_Id:  871766604 
Enter Product Selling price: 800
Enter Quantity of Product Sold: 100

1 . To sell more
2 . To print Receipt
Enter The Choice: 2

Enter Details To Print Receipt
Customer_Name: manish modak

Printing Receipt......

/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/--/-/-/-/--/-/-/- Receipt -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-    

Date: 2022-02-12                                Receipt No:1                            Time: 19:18:27 pm
Name: Manish Modak
----------------------------------------------------------------------------------------------------------------------------------------------------------------        
|            Item               |       Manufacturer/Author     |           Price($)            |           Quantity            |         Total Cost            |       
----------------------------------------------------------------------------------------------------------------------------------------------------------------        
|           Dog Food            |           Nutella             |             800               |             100               |             80000             |       
|           Cat Food            |       Nutella Pro             |             800               |             100               |             80000             |       
----------------------------------------------------------------------------------------------------------------------------------------------------------------        

Total Amount: 160000

/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- Thank you for Buying -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-     


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 6

Total quantity of products in store is 0

1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 7

-----------------------------------------------------------------------------------------------------------------------------
|        Date & Time      |      Product Name        |       Quantity      |        Price($)       |    Transcation_Type    |
-----------------------------------------------------------------------------------------------------------------------------
| 2022-02-12 19:17:38 pm  |        Dog Food          |        100          |          750          |        Purchased       |
-----------------------------------------------------------------------------------------------------------------------------
| 2022-02-12 19:18:03 pm  |        Cat Food          |        100          |          750          |        Purchased       |
-----------------------------------------------------------------------------------------------------------------------------
| 2022-02-12 19:18:51 pm  |        Dog Food          |        100          |          800          |             Sold       |
-----------------------------------------------------------------------------------------------------------------------------
| 2022-02-12 19:19:06 pm  |        Cat Food          |        100          |          800          |             Sold       |
-----------------------------------------------------------------------------------------------------------------------------

1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 3

1 . For All Products
2 . For Individual Product
0 . To go back
Enter The Choice: 2

Enter Product_Id:  871766604 

You Have Gained 5000 Rs. On Sold Product

1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 3

1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 8

Enter Product_Id: 432672324  

Product Name: Dog Food
Product Id: 432672324
Manufacturer/Author: Nutella
Market Retail Price: 1000
Avilable Quantity: 0

1 . Edit Product Name
2 . Edit Manufacturer Name
3 . Edit MRP

0.To Go Back

Enter The Choice: 1

Enter Product Name: apple

1 . Edit Product Name
2 . Edit Manufacturer Name
3 . Edit MRP

0.To Go Back

Enter The Choice: 2

Enter Manufacturer Name: local

1 . Edit Product Name
2 . Edit Manufacturer Name
3 . Edit MRP

0.To Go Back

Enter The Choice: 3

Enter Market Retail Price: 1000

1 . Edit Product Name
2 . Edit Manufacturer Name
3 . Edit MRP

0.To Go Back

Enter The Choice: 0


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 4

1 . Search By Product Name
2 . Search By Author/Manufacturer Name

0 . To Go Back

Enter The Choice: 1
Enter Product Name: apple

Product Name: Apple
Product Id: 432672324
Manufacturer/Author: Local
Market Retail Price: 1000
Avilable Quantity: 0


1 . To Register Purchased Product
2 . To Sell Product
3 . To Calculate Profit/Loss
4 . For Individual Product Information
5 . For List Of All Available Products
6 . For Total Stock Present In Store Of All Products
7 . To Display Store Transaction History
8 . To Edit Product Details

0 . To Close Store Inventory

Enter The Choice: 0


-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//- Inventory Closed -//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-//-
 */