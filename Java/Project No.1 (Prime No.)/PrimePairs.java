import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		int Range ; 
		Scanner obj = new Scanner(System.in);
		do{                                                             //For correct input
			System.out.print("\nEnter the Range: ") ;
			Range = obj.nextInt();
		}while(Range < 1);                                               //declaring variables
 	   
		int num =0;
		int j = 0 , a = 0;
		boolean flag = false ;
		int Array[] = new int[Range];

		Array[j] = 2;
		j++;

		for (num = 3 ; num <= Range ; num +=2 )       // to repeat for every number, only checks even numbers
		{
			int n = (int) Math.ceil(Math.sqrt(num));
			for (int i = 2; i <= n ; i ++ )
			{
				if( num % i == 0)
				{
					flag = false ;
					break;						}
				else
				{
					flag = true ;
				}
			}
			if( flag )                            //for storing prime numbers in array
			{
				Array[j] = num ;
					j++ ;
			}
		}
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
