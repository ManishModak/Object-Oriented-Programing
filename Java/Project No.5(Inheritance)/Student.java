Public class BaseClass 
{
	private String name ;
	private int age ;
	
	public BaseClass (String name , int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public void display() 
	{
		System.out.print("\t" + name +"\t"+ age ) ;
	}
}
