import java.util.Scanner;
import java.io.Serializable;

public class Inventory implements Serializable
{
    private String Product_Name = " ",  Manufacturer = " " ;
    private long ItemId = 0 , ItemSellingPrice = 0;
    private long  Receipt_Sellingprice = 0 , Receipt_Quantity = 0 ; 
    private long Buying_price = 0, MRP = 0  ;
    private int BuyQuantity = 0 , SellQuantity = 0 ;
    private int ItemBuyQuantity = 0 , ItemSellQuantity = 0 , AvailableQuantity = 0;

    private static int Total_Quantity = 0 , ReceiptNo = 0 ;
    private static long Total_Sellingprice = 0 , Total_Buyingprice = 0 ;

    transient Scanner Sc = new Scanner(System.in);
    Personal_Utility pu = new Personal_Utility();

    public Inventory(long Item_Id)
    {
        int flag = -1 ;

        System.out.print("\nEnter Product Name: ") ;
        Product_Name = Sc.nextLine() ;
        Product_Name = Personal_Utility.capitailizeWord(Product_Name) ;

        System.out.print("Enter Manufacturer/Author: ") ;
        Manufacturer = Sc.nextLine() ;
        Manufacturer = Personal_Utility.capitailizeWord(Manufacturer) ;

        this.ItemId = Item_Id ;
        do
        {
            Scanner sc = new Scanner(System.in) ;
            try 
            {
                System.out.print("Enter Market Retail Price: ");
                MRP = sc.nextLong() ;
                flag = 1 ;
            }
            catch (Exception e) 
            {
                System.out.println("\n Wrong Input Please Enter In No. Format Again ") ;
                flag = 0 ;
            }
        }while(flag != 1) ;
    }

    public void Buy()
    {
        int flag = -1 ;
        do
        {
            Scanner sc = new Scanner(System.in) ;
            try 
            {
                System.out.print("Enter Product Buying price: ") ;
                long price  =  sc.nextLong() ;
                if(Buying_price == 0)
                {
                    Buying_price = price ;
                }
                else
                {
                    Buying_price = (Buying_price + price)/2 ;
                }
                
                System.out.print("Enter Quantity of Product: ") ;
                BuyQuantity =  sc.nextInt() ;
            
                ItemBuyQuantity = ItemBuyQuantity + BuyQuantity ;
                AvailableQuantity = AvailableQuantity + BuyQuantity ;
                Total_Quantity = Total_Quantity + BuyQuantity ;
                Total_Buyingprice = Total_Buyingprice + Buying_price * BuyQuantity ;

                flag = 1 ;          
                break ;
            }
            catch (Exception e)
            {
                System.out.println("\n Wrong Input Please Provide No. as input");
                flag = 0 ;
            }
        }while(flag != 1) ;
    }

    public void sell()
    {
        int flag = -1 ;
        long price = 0 ;
        do
        {   
            do
            {
                Scanner sc = new Scanner(System.in) ;
                try 
                {
                    System.out.print("Enter Product Selling price: ") ;
                    price =  sc.nextLong() ;
                    System.out.print("Enter Quantity of Product Sold: ") ;
                    SellQuantity =  sc.nextInt() ;

                    flag = 1 ;
                    break ;
                }
                catch (Exception e)
                {
                    System.out.println("\n Wrong Input Please Provide No. as input");
                    flag = 0 ;
                }
            }while(flag != 1) ;

            if(SellQuantity > AvailableQuantity)
            {
                System.out.println("\nWrong Quantity ") ;
                System.out.println("You Do Not Have That Much Quantity In Store") ;
                System.out.println("\nAvailable Product Quantity: " + AvailableQuantity + "\n") ;
                flag = 0 ;
            }
            else
            {   
                Receipt_Quantity = Receipt_Quantity + SellQuantity ; 
                ItemSellQuantity = ItemSellQuantity + SellQuantity ;
                AvailableQuantity = AvailableQuantity - SellQuantity ;
                Total_Quantity = Total_Quantity - SellQuantity ;
                Total_Sellingprice = Total_Sellingprice + ItemSellingPrice * SellQuantity ;
                flag = 1 ;
            }

            if(flag == 1)
            {
                if(Receipt_Sellingprice == 0)
                {
                    Receipt_Sellingprice = price ;                   
                }
                else
                {
                    Receipt_Sellingprice  = (Receipt_Sellingprice + price)/2 ;
                }

                if(ItemSellingPrice == 0)
                {
                    ItemSellingPrice = price ;
                }
                else
                {
                    ItemSellingPrice  = (ItemSellingPrice + price)/2 ;
                }
            }

        } while (flag != 1);
    }

    public void Product_list()
    {
        System.out.println(String.format("%1s %18s %12s %19s %11s %15s %15s %17s %13s","|", ItemId ,"|", Product_Name ,"|", MRP ,"|", Manufacturer ,"|"));
    } 

    public void Customer_Productlist()
    {
        System.out.println(String.format("%1s %18s %12s %17s %13s %15s %15s %15s %15s %17s %13s","|", Product_Name ,"|", Manufacturer ,"|", Receipt_Sellingprice ,"|", Receipt_Quantity ,"|", Receipt_Sellingprice*Receipt_Quantity ,"|"));
    }

    public void ProfitLoss()
    {
        System.out.print("\n") ;
        if(ItemSellingPrice == 0)
        {
            System.out.println("You Did Not Sold This Product Yet ") ;
        }
        else
        {
            if(Buying_price < ItemSellingPrice)
            {
                long result = ItemSellingPrice - Buying_price ;
                System.out.println("You Have Gained " + result*ItemSellQuantity + " Rs. On Sold Product") ;
            }
            else if(Buying_price > ItemSellingPrice)
            {
                long result = Buying_price - ItemSellingPrice ;
                System.out.println("You have lost " + result*ItemSellQuantity+ " Rs. On sold Product") ;
            }
            else
            {
                System.out.println("You did not gained or lost On This Product") ;
            }
            System.out.print("\n") ;
        }
    }

    public static void Totalprofitloss()
    {
        System.out.println("\n") ;
        if(Total_Buyingprice > Total_Sellingprice)
        {
            long result = Total_Buyingprice - Total_Sellingprice ;
            System.out.println("You have lost " + result + " Rs.") ;
        }
        else if(Total_Sellingprice > Total_Buyingprice)
        {
            long result = Total_Sellingprice - Total_Buyingprice ;
            System.out.println("You have gained " + result + " Rs.") ;
        }
        else
        {
            System.out.println("You did not gained or lost ") ;
        }

        System.out.print("\n") ;
    }

    public void Product_info()
    {
        System.out.println("\nProduct Name: " + Product_Name) ;
        System.out.println("Product Id: " + ItemId) ;
        System.out.println("Manufacturer/Author: " + Manufacturer) ;
        System.out.println("Market Retail Price: " + MRP) ;
        System.out.println("Avilable Quantity: " + AvailableQuantity) ;
    }

    public void setstaticvariables()
    {
        this.Total_Quantity = (Total_Quantity + ItemBuyQuantity) - ItemSellQuantity ;
        this.Total_Buyingprice = (Total_Buyingprice + Buying_price) ;
        this.Total_Sellingprice = (Total_Sellingprice + ItemSellingPrice) ;
    }

    public void setReceiptvalues()
    {
        this.Receipt_Sellingprice = 0 ;
        this.Receipt_Quantity = 0 ;
    }

    public void setProduct_Name(String ProductName)
    {
        this.Product_Name = ProductName;
    }

    public void setMRP(long MRP)
    {
        this.MRP = MRP ;
    }
    
    public void setManufacturer(String Manufacturer)
    {
        this.Manufacturer = Manufacturer ; 
    }

    public static void Total_Quantity()
    {
        System.out.println("Total quantity of products in store is " + Total_Quantity) ;
    }

    public long Check_Itemid()
    {
        return ItemId ;
    }

    public int Check_Itemquantity()
    {
        return AvailableQuantity ;
    }

    public int Check_Buyquantity()
    {
        return BuyQuantity ;
    }

    public int Check_Sellquantity()
    {
        return SellQuantity ;
    }

    public String Check_Productname()
    {
        return Product_Name ;
    }

    public String Check_Authorname()
    {
        return Manufacturer ;
    }

    public long Check_ReceiptQuantity()
    {
        return Receipt_Quantity ;
    }

    public static long Receipt_No()
    {
        ReceiptNo ++ ;
        return ReceiptNo ;
    }

    public long Check_Buyingprice()
    {
        return Buying_price ;
    }

    public long Check_Sellingprice()
    {
        return ItemSellingPrice ;
    }
}