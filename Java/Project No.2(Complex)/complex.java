import java.util.Scanner;

public class complex {
	private int real1 , img1 ;
	private int real2 , img2 ;
	private int real3 , img3 ;
	
	public void getdata()
	{
		Scanner Sc = new Scanner(System.in) ;
		System.out.println("Enter first Complex no Real and Img value") ;
		real1 = Sc.nextInt() ;
		img1 = Sc.nextInt() ;
		System.out.println("Enter second Complex no Real and Img value") ;
		real2 = Sc.nextInt() ;
		img2 = Sc.nextInt() ;
	}
	public void add()
	{
		real3 = real1 + real2 ;
		img3 = img1 + img2 ; 
	}
	public void display()
	{
		System.out.println(real3 + "+" + img3 + "i") ;  
	}

}
