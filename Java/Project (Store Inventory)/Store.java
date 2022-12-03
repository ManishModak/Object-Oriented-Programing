public class Store
{
    public static void main(String[] args) 
    {
        Personal_Utility pu = new Personal_Utility() ;
        int choice = -1 ;
        pu.getInfoFromFile();
        pu.setstaticvariables();

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
            switch (choice) 
            {
                case 1:
                    try 
                    {
                        pu.purchase();
                    } 
                    catch (Exception e) 
                    {
                       throw new RuntimeException(e);
                    }
                    break;
            
                case 2:
                    try 
                    {
                        pu.sell();
                        pu.CustomerReceipt();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    try 
                    {
                        pu.ProfitLoss() ;
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    try 
                    {
                        pu.productinfo();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 5:
                    try 
                    {
                        pu.productlist();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 6:
                    try 
                    {
                        pu.Storestock();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case 7:
                    try 
                    {
                       pu.Transactionhistory();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException();
                    }
                    break;

                case 8:
                    try 
                    {
                        pu.Productedit();
                    } 
                    catch (Exception e) 
                    {
                        throw new RuntimeException();
                    }
                    break;

                case 0:
                    pu.writeInfoToFile();
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
Product ID Is: 797721663


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
Enter Manufacturer/Author: nutella
Enter Market Retail Price: 1000
Enter Product Buying price: 750
Enter Quantity of Product: 100

Product Registered Sucessfully
Product ID Is: 281169387


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
|          797721663            |            Dog Food           |            1000               |           Nutella             |
--------------------------------------------------------------------------------------------------------------------------------
|          281169387            |            Cat Food           |            1000               |           Nutella             |
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
 */