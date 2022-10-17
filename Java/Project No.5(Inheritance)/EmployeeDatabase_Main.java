import java.util.* ;
public class EmployeeDatabase_Main {

	public static void main(String[] args) {
		
		Scanner Sc = new Scanner(System.in) ;
		int Choice , c , i = 0 ;
		Person P[] = new Person[20] ;
		
		do
		{
			System.out.print("Enter 1.Insert") ;
			System.out.print("\nEnter 2.Display") ;
			
			System.out.print("\nEnter No. : " ) ;
			Choice = Sc.nextInt() ;
			System.out.print("\n");
			
			switch(Choice)
			{
			case 1 :
				do
				{
					System.out.print("Enter 1.To Add Assistant Professor data") ;
					System.out.print("\nEnter 2.To Add Associate Professor data") ;
					System.out.print("\nEnter 3.To Add Professor data") ;
					System.out.print("\nEnter No. : " ) ;
					c = Sc.nextInt() ;
					switch(c)
					{
					case 1 :
						P[i] = new AssistantProf() ;
						i++ ;
						System.out.println("Enter 4.To End Operation") ;
						break ;
					case 2 :
						P[i] = new AssociateProf() ;
						i++ ;
						System.out.println("Enter 4.To End Operation") ;
						break ;
					case 3 :
						P[i] = new Professor() ;
						i++ ;
						System.out.println("Enter 4.To End Operation") ;
						break ;
					case 4 :
						System.out.println("End Of Operation\n") ;
					}
					
				}while(c != 4) ;
				break ;
				
			case 2 :
				for (int j = 0 ; j < i ; j++ )
				{
					P[j].display() ;
					System.out.print("\n");
				}
				System.out.print("\n");
				break ;
				
			case 3 :
				System.out.println("End Of Operation") ;
			}
			
		}while(Choice != 3) ;
	}

}


/*
*********************************OUTPUT*************************************
Enter 1.Insert
Enter 2.Display
Enter No. : 1

Enter 1.To Add Assistant Professor data
Enter 2.To Add Associate Professor data
Enter 3.To Add Professor data
Enter No. : 1

Enter Name : manish
Enter DOB : DD/MM/YYYY 31
12
2003
Enter Age : 19
Enter EmployeeId : T21040
Enter Email : manishmodak(0@gmail.com
Enter Pan No. : HJAP871547
Enter Mobile No. : 9356384438
Enter BasicPay : 15600
Enter ADP : 6000
Enter Department : IT

Enter 4.To End Operation
Enter 1.To Add Assistant Professor data
Enter 2.To Add Associate Professor data
Enter 3.To Add Professor data
Enter No. : 2

Enter Name : Aman
Enter DOB : DD/MM/YYYY 02
05
2000
Enter Age : 19
Enter EmployeeId : T21039
Enter Email : amanmunjewar@gmail.com
Enter Pan No. : 4785
INVALID
HYTB747844
Enter Mobile No. : 777
INVALID
8745621745
Enter BasicPay : 37500
Enter ADP : 9000
Enter Department : Comp

Enter 4.To End Operation
Enter 1.To Add Assistant Professor data
Enter 2.To Add Associate Professor data
Enter 3.To Add Professor data
Enter No. : 3

Enter Name : Aniket
Enter DOB : DD/MM/YYYY 21
13
1999
INVALID
21
11
1999
Enter Age : 22
Enter EmployeeId : T21041
Enter Email : aniketmodak@gmail.com
Enter Pan No. : ERWT785641
Enter Mobile No. : 787
INVALID
7788423515
Enter BasicPay : 130000
Enter ADP : 10000
Enter Department : Comp

Enter 4.To End Operation
Enter 1.To Add Assistant Professor data
Enter 2.To Add Associate Professor data
Enter 3.To Add Professor data
Enter No. : 4
End Of Operation

Enter 1.Insert
Enter 2.Display
Enter No. : 2

Name : manish	Employee Id : T21040	DOB : 31.12.2003
Age : 19	PAN no. : HJAP871547	Moblie No : 9356384438
Email : manishmodak(0@gmail.com		Department : IT
GrossSalary : 47784.0	NetSalary : 45170.4

Name : Aman	Employee Id : T21039	DOB : 2.5.2000
Age : 19	PAN no. : HYTB747844	Moblie No : 8745621745
Email : amanmunjewar@gmail.com		Department : Comp
GrossSalary : 106785.0	NetSalary : 101158.5

Name : Aniket	Employee Id : T21041	DOB : 21.11.1999
Age : 22	PAN no. : ERWT785641	Moblie No : 7788423515
Email : aniketmodak@gmail.com		Department : Comp
GrossSalary : 338600.0	NetSalary : 321660.0

Enter 1.Insert
Enter 2.Display
Enter No. : 3

End Of Operation

*/