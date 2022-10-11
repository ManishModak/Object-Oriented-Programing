import java.util.* ;
public class EmployeeDatabase 
{

	public static void main(String[] args) 
  {
		
		Scanner Sc = new Scanner(System.in) ;
		Employee E[] = new Employee[20] ;
		int choice , i = 0 , Age , Sr ;
		String Name , Address ; 
		
		do
		{
			System.out.println("\nEnter 1 To Insert") ;
			System.out.println("Enter 2 To Search") ;
			System.out.println("Enter 3 To Replace") ;
			System.out.println("Enter 4 To Display") ;
			System.out.print("Enter The Choice : ");
			choice = Sc.nextInt() ;
			
			switch (choice)
			{
				case 1 :
					
					System.out.print("\nEnter Name Of Employee : ") ;
					Name = Sc.next() ;
					System.out.print("\nEnter Age Of Employee : ") ;
					Age = Sc.nextInt() ;
					System.out.print("\nEnter Address Of Employee : ") ;
					Address = Sc.next();
					
					E[i] = new Employee(Name , Age , Address) ;
					i ++ ;
					break ;
					
				case 2 :
					System.out.print("Enter the Sr no. Want to Search : ") ;
					Sr = Sc.nextInt();
					System.out.println("\n"+"\t"+ "Name" +"\t"+ "Age" +"\t"+ "Address") ;
					E[Sr-1].Display();
					break ;
					
				case 3 :
					
					System.out.print("Enter the Sr no. Want to Override : ") ;
					Sr = Sc.nextInt();
					System.out.print("\nEnter Name Of Employee : ") ;
					Name = Sc.next() ;
					System.out.print("\nEnter Age Of Employee : ") ;
					Age = Sc.nextInt() ;
					System.out.print("\nEnter Address Of Employee : ") ;
					Address = Sc.next();
					
					E[Sr-1] = new Employee(Name , Age , Address) ; 
					break ;
					
				case 4 :
					
					System.out.println("\n"+"Sr" +"\t"+ "Name" +"\t"+ "Age" +"\t"+ "Address") ;
					for (int j = 0 ; j < i ; j++)
					{
						System.out.print(j+1);
						E[j].Display();
					}
					break ;
					
				case 5 :
					
					System.out.println("Operation Has Ended ") ;
			}
      
		}while(choice != 5) ;

	}

}
