import java.util.* ;

public class AssistantProf extends Person 
{
	private Double BasicPay ;
	private String Department ;
	private Double GrossSalary ;
	private Double NetSalary ;
	private Double ADP ;
	
	public AssistantProf()
	{
		Scanner Sc = new Scanner(System.in) ;
		System.out.print("Enter BasicPay : ") ;
		BasicPay = Sc.nextDouble() ;
		System.out.print("Enter ADP : ");
		ADP = Sc.nextDouble() ;
		System.out.print("Enter Department : ") ;
		Department = Sc.next() ;
		System.out.print("\n") ;
		PaySlip() ;
	}
	
	public void PaySlip()
	{
		GrossSalary = BasicPay + (BasicPay + ADP)*1.19 + (BasicPay + ADP)*0.3 ;
		
		NetSalary = GrossSalary - (BasicPay + ADP)*0.12 - (BasicPay + ADP)*0.001 ;
	}
	
	public void display()
	{
		super.display();
		System.out.println("\t\t" + "Department : " + Department ) ;
		System.out.print("GrossSalary : " + GrossSalary + "\t" + "NetSalary : " + NetSalary + "\n");
	}
}
