import java.util.* ;

public class Rectangle extends Shape                              // Base class inherited
{
	Scanner Sc = new Scanner(System.in) ;
	private double area ;
	
	public void getdata()                                           // Declaring methods according to needs
	{
		System.out.print("Enter Length : ") ;
		x = Sc.nextDouble() ;
		
		System.out.print("Enter Breadth : ") ;
		y = Sc.nextDouble() ;
	}
	
	public void compute_area()
	{
		area = x * y ;
		System.out.println("Area of Rectangle is " + area + "\n") ;
		
	}
	
}
