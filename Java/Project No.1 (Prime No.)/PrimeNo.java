import java.util.Scanner;

public class pn {
	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		int num ;
		boolean flag = false;

		do{
			System.out.print("\nEnter the no.: ") ;
			num = obj.nextInt();
		}while(num < 1);
		
		if(num == 1) 
		{
			flag = false;
		}
		else 
		{
			if(num % 2 == 0) 
			{
				if (num == 2) 
				{
					flag = true ;
				}
				else
				{
					flag = false ;
				}
			}
			else
			{
				int n = (int) Math.ceil(Math.sqrt(num));
				for (int i = 3 ; i <=  n ; i +=2 )
				{
					if( num % i == 0)
					{
						flag = false ;
						break;
					}
					else
					{
						flag = true ;
					}
				}
			}
		}

		if(flag)
		{
			System.out.println(num+" is prime");
		}
		else
		{
			System.out.println(num+" is not prime");
		}
		obj.close();
	}

}
