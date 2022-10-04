import java.util.*;

public class pn {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int num ;
		int flag = -1 ;
		do{
			System.out.println("Enter the no. :") ;
			num = obj.nextInt();
		}while(num < 1);
		//System.out.println(num);
		if(num == 1) 
		{
			flag = 0;
		}
		else 
		{
			if(num % 2 == 0) 
			{
				if (num == 2) 
				{
					flag = 1 ;
				}
				else
				{
					flag = 0 ;
				}
				
			}
			else
			{
				int n = (int) Math.ceil(Math.sqrt(num));
				for (int i = 3 ; i <=  n ; i +=2 )
				{
					if( num % i == 0)
					{
						flag = 0 ;
					}
					else
					{
						flag = 1 ;
					}
				}
			}
		}
		if(flag == 0)
		{
			System.out.println("NO.is not prime");
		}
		else
		{
			System.out.println("NO.is prime");
		}

	}

}
