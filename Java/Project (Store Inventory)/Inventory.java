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

    /*
     * transient is used to avoid serialization it throws exception NotSerializableException if 
     * tried to serialization.
     * Only primitives and classes that implement Serializable interface can be serialized.
     * Classes like Scanner,LocalDateTime,DateTimeFormatter generally throws NotSerializableException.
     */
    transient Scanner Sc = new Scanner(System.in);
    Personal_Utility pu = new Personal_Utility();

    /*
     * Inventory Constructor
     * It takes Product Name,Manufacturer Name and MRP
     * Also sets Item id of product.
     */
    public Inventory(long Item_Id)
    {
        int flag = -1 ;

        System.out.print("\nEnter Product Name: ") ;
        Product_Name = Sc.nextLine() ;
        Product_Name = Personal_Utility.capitailizeWord(Product_Name) ;                    // capitailizeWord method of Personal_Utility class

        System.out.print("Enter Manufacturer/Author: ") ;
        Manufacturer = Sc.nextLine() ;
        Manufacturer = Personal_Utility.capitailizeWord(Manufacturer) ;                    // capitailizeWord method of Personal_Utility class

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

    /*
     * Buy Method To Add product To Inventory.
     * 
     * Here,Buying price - is buying price of product by store owner.
     *      ItemBuyQuantity - is Total quantity bought of this item.
     *      AvailableQuantity - is Available quantity of this item.
     *      Total_Quantity - is Total quantity of store products.
     *      Total_Buyingprice - is Total Buying price of all store products.
     */
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

    /*
     * Sell Method To Sell product In Inventory.
     * 
     * Here,Selling price - is aelling  price of product by store owner.
     *      Receipt_Quantity - is quantity that is sold to the customer at the time.
     *      ItemSellQuantity - is Total quantity sold of this item.
     *      AvailableQuantity - is Available quantity of this item.
     *      Total_Quantity - is Total quantity of store products.
     *      Total_Sellingprice - is Total Selling price of all store products.
     */
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

            if(flag == 1)                                                       // To Take Average If bought at different Prices.
            {                                                                   // Unnecessary code for Receipt Selling Prtice ToT you can skip it.
                if(Receipt_Sellingprice == 0)                                   // Dont Know who will buy same product at different prices. TToTT
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

     /*
     * Product_list Method To Display all available products in store in list format.
     * 
     * Here,ItemId - Product Id.
     *      Product_Name - Name of Product.
     *      MRP - Market Retail Price displayed (Not same as Buy And sell price).
     *      Manufacturer - Manufacturer Name.
     */
    public void Product_list()
    {
        System.out.println(String.format("%1s %18s %12s %19s %11s %15s %15s %17s %13s","|", ItemId ,"|", Product_Name ,"|", MRP ,"|", Manufacturer ,"|"));
    } 

    /*
    * Customer_Productlist Method To Display all products that customer bought In list format
    *
    * Here,Product_Name - Name of Product.
    *      Manufacturer - Manufacturer Name.      
    *      Receipt_Quantity  - Quantity of Product Cutomer Bought.
    *      Receipt_Sellingprice - Price At Poduct was sold to customer.
    */
    public void Customer_Productlist()
    {
        System.out.println(String.format("%1s %18s %12s %17s %13s %15s %15s %15s %15s %17s %13s","|", Product_Name ,"|", Manufacturer ,"|", Receipt_Sellingprice ,"|", Receipt_Quantity ,"|", Receipt_Sellingprice*Receipt_Quantity ,"|"));
    }

    /*
    * ProfitLoss Method To Display Profit or Loss Occurred with this product.
    *
    * Here,ItemSellingPrice - Average of Total Selling Prices of Product by diff. Customer.
    *      Buying_price - Buying Price of Item.      
    *      ItemSellQuantity  - Total Quantity of Product Sold     
    */
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

    /*
    * Totalprofitloss Method To Display Total Profit or Loss Occurred In store.
    *
    * Here,Total_Buyingprice - Total Buying Price of product.
    *      Total_Sellingprice -Total Selling Price of product.
    */
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

    /*
    * Product_info Method To Display Product Info.
    *
    * Here,Product_Name - Name of Product.
    *      MRP - Market Retail Price displayed (Not same as Buy And sell price).
    *      Manufacturer - Manufacturer Name.
    *      ItemId - Product Id.
    *      Available Quantity - Available quantity of product.
    */
    public void Product_info()
    {
        System.out.println("\nProduct Name: " + Product_Name) ;
        System.out.println("Product Id: " + ItemId) ;
        System.out.println("Manufacturer/Author: " + Manufacturer) ;
        System.out.println("Market Retail Price: " + MRP) ;
        System.out.println("Avilable Quantity: " + AvailableQuantity) ;
    }

    /*
    * setstaticvariables Method To set static variables as it was before saving.
    *   (Writing in File does not store static variables).
    *
    * Here,Total_Quantity is Total quantity of store products.
    *      Total_Buyingprice - is Total Buying price of all products in store.
    *      Total_Sellingprice - is Total Selling price of all products in store.
    *      ItemBuyQuantity - is Total quantity bought of this item.
    *      ItemSellingPrice - Average of Selling prices of diff. customer.
    */
    public void setstaticvariables()
    {
        this.Total_Quantity = (Total_Quantity + ItemBuyQuantity) - ItemSellQuantity ;
        this.Total_Buyingprice = (Total_Buyingprice + Buying_price) ;
        this.Total_Sellingprice = (Total_Sellingprice + ItemSellingPrice) ;
    }

    /*
     * setReceiptvalues Method To set Receipt variables after printing Cutomer receipt.
     * 
     * Here,Receipt_Sellingprice - Selling price of product for current customer.
     *      Receipt_Quantity - Quantity Of product sold For current customer.
     */
    public void setReceiptvalues()
    {
        this.Receipt_Sellingprice = 0 ;
        this.Receipt_Quantity = 0 ;
    }

    /* 
     *  Total_Quantity Method To Display Total quantity of products in store. 
     * 
     *  Here, Total_Quantity - is Total quantity of all store products.
     */
    public static void Total_Quantity()
    {
        System.out.println("Total quantity of products in store is " + Total_Quantity) ;
    }

    /*
     * Get Methods to return a particular value(variable) of product.
     * Set Methods to set values According to needs. :)
     */
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