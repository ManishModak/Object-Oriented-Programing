import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		int Range ; 
		Scanner obj = new Scanner(System.in);
		do{                                                             //For correct input
			System.out.println("Enter the Range :") ;
			Range = obj.nextInt();
		}while(Range < 1);                                               //declaring variables
 	   
		int num ;
		int j = 0 , a = 0;
		int flag = -1 ;
		int Array[] = new int[Range];
		
		//System.out.println(num);
		for (num = 1 ; num <= Range ; num ++ )                          // to repeat for every number
		{
			if(num == 1)                                                // conditions for prime number
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
					for (int i = 2; i <= n ; i ++ )
					{
						if( num % i == 0)
						{
							flag = 0 ;
							break;
						}
						else
						{
							flag = 1 ;
						}
					}
				}
			}
			if( flag == 1 )                                                 //for storing prime numbers in array
			{
				Array[j] = num ;
					j++ ;
			}
			/*if(flag == 0)
			{
				System.out.println("NO.is not prime");
			}
			else
			{
				System.out.println("NO.is prime");
			}*/

		}
		/*for (k = 0 ; k < j ; k++)
		{
			System.out.println(Array[k]);
		}*/
		
		System.out.println("2"+"\t"+"3");
		
		for (a = 0 ; a <= j ; a++)                                        //  loop for printing prime pairs
		{
			if(Array[a+1]-Array[a] == 2)
			{
				System.out.println(Array[a]+"\t"+Array[a+1]);
			}
		}
		
	}

}
