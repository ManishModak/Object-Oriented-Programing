import java.util.* ;

public class CalculateArea {

	public static void main(String[] args) {

		Scanner Sc =  new Scanner(System.in) ;
		
		int choice ;
		
		Shape S ;                                                           // Only ref. variable 
		                                                                    // so we can create object of the type we need only   
		do
		{                                                                   // Menu
			System.out.println("Enter 1 to Compute Area Of Rectangle") ;      // Cases so we create object of specific class
			System.out.println("Enter 2 to Compute Area Of Triangle") ;
			System.out.println("Enter 3 to Compute Area Of Circle") ;
			
			System.out.print("Enter The No : ") ;                   
			choice = Sc.nextInt() ;
			System.out.print("\n") ;
			switch(choice)
			{
			case 1:
				S = new Rectangle() ;
				S.getdata() ;
				S.compute_area() ;
				System.out.println("Enter 4 to End Program") ;
				break ;
			case 2:
				S = new Triangle() ;
				S.getdata() ;
				S.compute_area() ;
				System.out.println("Enter 4 to End Program") ;
				break ;
			case 3:
				S = new circle() ;
				S.getdata() ;
				S.compute_area() ;
				System.out.println("Enter 4 to End Program") ;
				break ;
			case 4:
				System.out.print("Operation Ended") ;
			}
			
		}while( choice != 4 ) ;
		
	}

}



/*
**********************************************OUTPUT********************************************
Enter 1 to Compute Area Of Rectangle
Enter 2 to Compute Area Of Triangle
Enter 3 to Compute Area Of Circle
Enter The No : 1

Enter Length : 12
Enter Breadth : 20
Area of Rectangle is 240.0

Enter 4 to End Program
Enter 1 to Compute Area Of Rectangle
Enter 2 to Compute Area Of Triangle
Enter 3 to Compute Area Of Circle
Enter The No : 2

Enter Base : 5
Enter Height : 6
Area of Triangle is 15.0

Enter 4 to End Program
Enter 1 to Compute Area Of Rectangle
Enter 2 to Compute Area Of Triangle
Enter 3 to Compute Area Of Circle
Enter The No : 3

Enter Radius : 6
Area of Triangle is 113.03999999999999

Enter 4 to End Program
Enter 1 to Compute Area Of Rectangle
Enter 2 to Compute Area Of Triangle
Enter 3 to Compute Area Of Circle
Enter The No : 4

Operation Ended

*/
