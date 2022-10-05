import java.util.* ;
public class complexConstructor_Op {

	public static void main(String[] args) {
		int real1,real2,img1,img2,choice ;
		Scanner Sc = new Scanner(System.in) ;
		
		System.out.println("Enter First No Real and Img value :") ;
		real1 = Sc.nextInt() ;
		img1 = Sc.nextInt() ;
		complexConstructor obj1 = new complexConstructor(real1 , img1) ;
		
		System.out.println("Enter Second No Real and Img value :") ;
		real2 = Sc.nextInt() ;
		img2 = Sc.nextInt();
		complexConstructor obj2 = new complexConstructor(real2 , img2 ) ;
		
		complexConstructor obj3 = new complexConstructor() ;
		
		System.out.println("Enter 1 For Add") ;
		System.out.println("Enter 2 For Subtract") ;
		System.out.println("Enter 3 For Multiply") ;
		System.out.println("Enter 4 For Divide") ;
		
		do
		{
			choice = Sc.nextInt() ;
			switch (choice)
			{
				case 1 :
					obj3.Add(obj1 , obj2) ;
					System.out.println("Operation Complete Enter 5 to get output") ;
					break ;
				case 2 :
					obj3.Subtract(obj1 , obj2) ;
					System.out.println("Operation Complete Enter 5 to get output") ;
					break ;
				case 3 :
					obj3.Multiply(obj1 , obj2) ;
					System.out.println("Operation Complete Enter 5 to get output") ;
					break ;
				case 4:
					obj3.Divide(obj1 , obj2) ;
					System.out.println("Operation Complete Enter 5 to get output") ;
					break ;
				case 5:
					obj3.display();	
			}
			
		}while (choice != 5) ;
	
	}

}
