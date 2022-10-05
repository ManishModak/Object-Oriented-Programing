import java.util.*;
public class complexMO {
	
	private int real , img ;
	
	public void getdata()
	{
		Scanner Sc = new Scanner(System.in) ;
		real = Sc.nextInt();
		img = Sc.nextInt() ;
	}
	
	public void add(complexMO x , complexMO y)
	{
		real = x.real + y.real ;
		img = x.img + y.img ;
	}
	
	public void sub(complexMO x , complexMO y)
	{
		real = x.real - y.real ;
		img = x.img - y.img ;
	}
	
	public void multii(complexMO x , complexMO y)
	{
		real = (x.real*y.real - x.img*y.img) ;
		img = (x.real*y.img + x.img*y.real) ;
	}
	public void divide(complexMO x , complexMO y)
	{
		real = (x.real*y.real + x.img*y.img)/(y.real*y.real + y.img*y.img) ;
		img = (x.img*y.real - x.real*y.img)/(y.real*y.real + y.img*y.img) ;
	}
	
	public void display()
	{
		System.out.println(real + "+" + img + "i") ;
	}

}
