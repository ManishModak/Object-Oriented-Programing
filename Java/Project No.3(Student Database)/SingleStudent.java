import java.util.* ;
public class SingleStudent {
	private int age ;
	private String name ;
	
	/*public void getdata()
	{
		Scanner Sc = new Scanner(System.in);
		System.out.println("Enter the Age:");
		age = Sc.nextInt() ;
		System.out.println("Enter the Name :");
		name = Sc.next() ;
		Sc.close() ;
	}*/
	
	public Student(int age , String name)                         // Parameterized Constructor
	{
		this.age = age ;
		this.name = name ;
	}
	
	public void display()                                         // Display Method
	{
		System.out.println("Age" + "\t" + "Name") ;
		System.out.println(age + "\t" + name) ;
	}

}
