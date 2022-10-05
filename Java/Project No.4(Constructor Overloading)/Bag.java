
public class Bag {

	private double weight ;
	private String colour ;
	private static double Total_weight = 0 ;
	private static int count = 0 ;
	
	public Bag()
	{
		weight = 5.0d ;
		colour = "Green" ;
		Total_weight = Total_weight + weight ;
		count = count + 1 ;
	}
	
	public Bag(double weight)
	{
		this.weight = weight ;
		colour = "Green" ;
		Total_weight = Total_weight + weight ;
		count = count + 1 ;
	}
	
	public Bag(String colour)
	{
		weight = 5.0d ;
		this.colour = colour ;
		Total_weight = Total_weight + weight ;
		count = count + 1 ;
	}
	
	public Bag(double weight , String colour)
	{
		this.weight = weight ;
		this.colour = colour ;
		Total_weight = Total_weight + weight ;
		count = count + 1 ;
	}
	
	public static void Output()
	{
		System.out.print("Total Weight of Bag is : " + Total_weight + "\n") ;
		System.out.print("No. of Balls are : " + count + "\n") ;
	}
	
	public void display()
	{
		 
		System.out.println("\t" + weight + "\t" + colour) ;
		
	}
	
	public static int count()
	{
		return count ;
	}
	
	public void correction()
	{
		Total_weight = Total_weight - weight ;
		count = count - 1 ;
	}
}
