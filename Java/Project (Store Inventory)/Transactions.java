import java.io.Serializable;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter;

public class Transactions implements Serializable
{
    private String Transcation_Type ;
    private long Amount ;
    private String ProductName ;
    private int Quantity ;

    private transient LocalDateTime Current_DateTime = LocalDateTime.now() ; 
    private transient DateTimeFormatter DateTime_Formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss a") ;
    
    private String DateTime = Current_DateTime.format(DateTime_Formatter) ; 

    public Transactions(String ProductName , String Transasction_Type , long Amount , int Quantity)
    {
        this.ProductName = ProductName ;
        this.Transcation_Type = Transasction_Type ;
        this.Amount = Amount ;
        this.Quantity = Quantity ;
    }

    public void Transaction_History()
    {
        System.out.println(String.format("%1s %18s %2s %15s %10s %10s %10s %12s %10s %16s %7s", "|", DateTime ,"|", ProductName ,"|",Quantity,"|",Amount,"|",Transcation_Type,"|")) ;
    }

}