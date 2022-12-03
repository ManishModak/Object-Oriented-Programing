import java.io.Serializable;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter;

public class Transactions implements Serializable
{
    private String Transcation_Type ;                       
    private long Amount ;
    private String ProductName ;
    private int Quantity ;

    /*
     *  LocalDateTime - used for getting local date and time.
     *  DateTimeFormatter - used for formatting date and time in special way.
     * 
     *  transient is used to avoid serialization it throws exception NotSerializableException if 
     *  tried to serialization.
     *  Only primitives and classes that implement Serializable interface can be serialized.
     *  Classes like Scanner,LocalDateTime,DateTimeFormatter generally throws NotSerializableException.
     */
    private transient LocalDateTime Current_DateTime = LocalDateTime.now() ; 
    private transient DateTimeFormatter DateTime_Formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss a") ;
    
    private String DateTime = Current_DateTime.format(DateTime_Formatter) ; 

    /*
     *  Transactions Method To Set (Also considered As default Constructor).
     *  Product Name = Product that has bought or sold.
     *  Transasction_Type = Type Bought or Sold.
     *  Amount = Amount in Transaction
     *  Quantity = Quantity of Product 
     */
    public Transactions(String ProductName , String Transasction_Type , long Amount , int Quantity)
    {
        this.ProductName = ProductName ;
        this.Transcation_Type = Transasction_Type ;
        this.Amount = Amount ;
        this.Quantity = Quantity ;
    }

    /*
     * Transaction_History Method used Print Transaction History 
     * String Format used to get perticular format %s represents spaces
     */
    public void Transaction_History()
    {
        System.out.println(String.format("%1s %18s %2s %15s %10s %10s %10s %12s %10s %16s %7s", "|", DateTime ,"|", ProductName ,"|",Quantity,"|",Amount,"|",Transcation_Type,"|")) ;
    }

}