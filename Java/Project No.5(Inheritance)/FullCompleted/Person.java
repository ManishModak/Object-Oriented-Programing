import java.util.* ;

public class Person 
{
	private String Name , PAN , Email , EmployeeId ;
	private int Age , i = 10 , Flag = -1 ;
	private Long MobileNo , DD , MM , YYYY  ;
	
	public Person()
	{
		Scanner Sc = new Scanner(System.in) ;
		
		System.out.print("\nEnter Name : ") ;
		Name = Sc.next() ;
		System.out.print("Enter DOB : DD/MM/YYYY ") ;
		do
		{
			if(Flag == 0)
			{
				System.out.println("INVALID") ;
			}
			
			DD = Sc.nextLong() ;
			MM = Sc.nextLong() ;
			YYYY = Sc.nextLong() ;
			
			if(YYYY % 4 == 0)
			{
				if(MM==01 || MM==03 || MM==05 || MM==07 || MM==8 || MM==10 || MM==12)
				{
					if(DD <= 31)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}
				}
				else if(MM == 02)
				{
					if(DD <= 29)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}	
				}
				else if (MM == 4 || MM == 6 || MM == 9 || MM == 11 )
				{
					if(DD <= 30)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}
				}
				else
				{
					Flag = 0 ;
				}
			}
			else
			{
			if(MM==01 || MM==03 || MM==05 || MM==07 || MM==8 || MM==10 || MM==12)
				{
					if(DD <= 31)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}
				}
				else if(MM == 02)
				{
					if(DD <= 28)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}	
				}		
				else if (MM == 4 || MM == 6 || MM == 9 || MM == 11 )
				{
					if(DD <= 30)
					{
						Flag = 1 ;
					}
					else
					{
						Flag = 0 ;
					}
				}
				else
				{
					Flag = 0 ;
				}

			}
		}while( Flag != 1 ) ;
		
		System.out.print("Enter Age : ") ;
		Age = Sc.nextInt() ;
		System.out.print("Enter EmployeeId : ") ;
		EmployeeId = Sc.next() ;
		System.out.print("Enter Email : ") ;
		Email = Sc.next() ;
		
		System.out.print("Enter Pan No. : ");
		do
		{
			if(i != 10)
			{
				System.out.println("INVALID") ;
			}
			PAN = Sc.next() ;
			String S = String.valueOf(PAN) ;
		    i = S.length() ;
		}while( i != 10) ;
		
		System.out.print("Enter Mobile No. : ");
		do
		{
			if(i != 10)
			{
				System.out.println("INVALID") ;
			}
			MobileNo = Sc.nextLong() ;
			String S = String.valueOf(MobileNo) ;
		    i = S.length() ;
		}while( i != 10) ;
		
	}
	
	public void display()
	{
		System.out.println("Name : " + Name + "\t" + "Employee Id : " + EmployeeId + "\t" + "DOB : " + DD +"."+ MM + "." + YYYY  ) ;
		System.out.println("Age : " + Age + "\t" + "PAN no. : " + PAN + "\t" + "Moblie No : " + MobileNo ) ;
		System.out.print("Email : " + Email ) ;
	}
}
