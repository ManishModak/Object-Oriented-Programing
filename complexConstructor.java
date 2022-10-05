
public class complexConstructor {
private int real , img  ;
	
	public complexConstructor (int x , int y)			//Parameterized Constructor (x,y int type variable to store passed value)
	{
		real = x ;
		img = y ;
	}
	
	public complexConstructor()							//Default Constructor (called when new obj created)
	{
		real = 0 ;
		img = 0 ;
	}
	
	public void Add(complexConstructor x , complexConstructor y) 			// Methods ( Here x,y of ComplexConstructor user defined datatype i.e class)
	{																		// x,y will create copy of original obj and make changes in it
		real = x.real + y.real ;
		img = x.img + y.img ;
	}
	
	public void Subtract(complexConstructor x , complexConstructor y)
	{
		real = x.real - y.real ;
		img = x.img - y.img ;
	}
	
	public void Multiply(complexConstructor x , complexConstructor y)
	{
		real = (x.real*y.real - x.img*y.img) ;
		img = (x.real*y.img - y.real*x.img) ;
	}
	
	public void Divide(complexConstructor x , complexConstructor y)
	{
		real = (x.real*y.real + x.img*y.img)/(y.real*y.real + y.img*y.img) ;
		img = (x.img*y.real - x.real*y.img)/(y.real*y.real + y.img*y.img) ;
	}
	
	public void display()
	{
		System.out.println(real+"+"+img+"i") ;
	}

}
