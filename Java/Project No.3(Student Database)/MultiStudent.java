import java.util.* ;

public class MultiStudent                                             // Creating Class 
{
	private int age ;
	private String name ;
	
	public void getdata()                                               // Getdata Method For Taking Input
	{
		Scanner Sc = new Scanner(System.in);
		System.out.println("Enter the Age:");
		age = Sc.nextInt() ;
		System.out.println("Enter the Name :");
		name = Sc.next() ;
		Sc.close() ;
	}
	
	public void display()                                               // Display Method To Display
	{
		System.out.println("Age" + "\t" + "Name") ;
		System.out.println(age + "\t" + name) ;
	}
	
}
