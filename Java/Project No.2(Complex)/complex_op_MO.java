import java.util.* ;
public class complex_op_MO {

	public static void main(String[] args) {
		
		complexMO c1 = new complexMO() ;
		complexMO c2 = new complexMO() ;
		complexMO c3 = new complexMO() ;
		int c = 0 ;
		
		System.out.println("Enter First No Real and Img value :") ;
		c1.getdata() ;
		
		System.out.println("Enter Second No Real and Img value :") ;
		c2.getdata() ;
		
		
		Scanner scan = new Scanner(System.in) ;
		
		do {
			System.out.println("Enter 1 for addition") ;
			System.out.println("Enter 2 for substraction") ;
			System.out.println("Enter 3 for multiplication") ;
			System.out.println("Enter 4 for division") ;
			//System.out.println("Enter 5 for to display results") ;
			
			c = scan.nextInt();
			switch (c)
			{
				case 1 :
					c3.add(c1 , c2) ;
					c3.display() ;
					break ;
				case 2 :
					c3.sub(c1 , c2) ;
					c3.display() ;
					break ;
				case 3 :
					c3.multii(c1 , c2);
					c3.display() ;
					break ;
				case 4 :
					c3.divide(c1 , c2);
					c3.display() ;
					break ;
				/*case 5 :
					c3.display() ;*/
			}
			
		}while(c>6);
		
	}

}
