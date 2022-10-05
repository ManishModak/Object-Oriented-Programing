import java.util.* ;
public class Bag_main {

	public static void main(String[] args) {
		
		double weight ;
		String colour ;
		int choice , c ,  Sr , count;
		int i = Bag.count() ;
		Bag S[] = new Bag[20];
		Scanner Sc = new Scanner(System.in) ;
		
		do
		{
			System.out.println("Enter 1 To Insert");
			System.out.println("Enter 2 To Delete");
			System.out.println("Enter 3 To Display");
			System.out.println("Enter 4 To Exit ");
			System.out.print("Enter The choice : ");
			
			choice = Sc.nextInt();
			
			switch(choice)
			{
				case 1 :
					do
					{
						System.out.println("Enter 1 To Insert Default Ball");
						System.out.println("Enter 2 To Insert with Input Weight");
						System.out.println("Enter 3 To Insert with Input colour");
						System.out.println("Enter 4 To Insert with Both Input");
						System.out.print("Enter The choice : ");
						
						c = Sc.nextInt() ;
						switch(c)
						{
							case 1 :
								S[i] = new Bag() ;
								i++ ;
								//System.out.println("\nEnter 5 To Display");
								System.out.println("\nEnter 5 To Exit Insert\n"+"OR");
								break ;
							case 2 :
								System.out.print("Enter The Weight : ");
								weight = Sc.nextDouble();
								S[i] = new Bag(weight) ;
								i++ ;
								
								//System.out.println("\nEnter 5 To Display");
								System.out.println("\nEnter 5 To Exit Insert\n"+"OR");
								break ;
							case 3 :
								System.out.print("Enter The Colour : ");
								colour = Sc.next();
								S[i] = new Bag(colour) ;
								i++ ;
								
								//System.out.println("\nEnter 5 To Display");
								System.out.println("\nEnter 5 To Exit Insert\n"+"OR");
								break ;
							case 4 :
								System.out.print("Enter The Weight : ");
								weight = Sc.nextDouble();
								System.out.print("\n" + "Enter The Colour : ");
								colour = Sc.next();
								S[i] = new Bag(weight , colour) ;
								i++ ;
								
								//System.out.println("\nEnter 5 To Display");
								System.out.println("\nEnter 5 To Exit Insert\n"+"OR");
								break ;
							/*case 5 :
								System.out.println("SrNo." + "\t" + "Weight" + "\t" + "Colour") ;
								for(int j = 0 ; j < i ; j++)
								{
									S[j].display();
								}
								Bag.Output();
								
								System.out.println("\nEnter 6 To Exit Insert\n"+"OR");
								break ;*/
							case 5 :
								System.out.println("Operation has Ended");
						}
					}while(c != 5);
					break ;
				case 2 :
					System.out.print("Enter The SrNo. you want to Delete : ");
					Sr = Sc.nextInt() ;
					count = Bag.count() ;
					S[Sr-1].correction() ;
					while(Sr < count)
					{
						S[Sr - 1] = S[Sr];
						Sr++ ;
					}
					i = Bag.count() ;
					break ;
				case 3 :
					count = Bag.count();
					for(int j = 0 ; j < count ; j++ )
					{
						System.out.print(j+1 + "\t") ;
						S[j].display();
					}
					Bag.Output();
					break ;
				case 4 :
					System.out.println("Operation has Ended");
				
			}
		}while(choice != 4);

	}

}
