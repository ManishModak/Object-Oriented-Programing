public class Employee extends Student 
{
	private String Address ;
	
	public DerivedClass(String name , int age , String Address)
	{
		super(name , age) ;
		this.Address = Address ;
	}
	
	public void Display()
	{
		display();
		System.out.println("\t" + Address );
	}
}
