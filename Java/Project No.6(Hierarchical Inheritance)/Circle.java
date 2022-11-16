import java.util.Scanner;

public class circle extends Shape                                           // Base class inherited
{ 
	
	Scanner Sc = new Scanner(System.in) ;
	private double area ;
	                                                    
	public void getdata()                                                     // Declaring methods according to needs
	{ 
		System.out.print("Enter Radius : ") ;
		x = Sc.nextDouble() ;
	}
	
	public void compute_area()
	{
		area = 3.14 * x * x ;
		System.out.println("Area of Triangle is " + area + "\n") ;
	}
	
}
