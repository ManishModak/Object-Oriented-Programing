import java.util.* ;                                                  // util package contains collection framework

public class ArrayLIst 
{
	
	public static void iseven(ArrayList<Integer> AR)                    // Method to check No. is even
	{
		  int m = AR.size() ;
	    int count = 0 ;
	    
	    if(AR.isEmpty())                                                // isEmpty() Method to check if ArrayList Is Empty
	    {
	    	System.out.print("\nINVALID");
	    }
	    else
	    {
	    	for(int i = 0 ; i < m ; i++)
	    	{
	    		int get = AR.get(i) ;                                       // get() Method to get value at parrticular Index
	    		
	    		if(get % 2 == 0)
	    		{
	    			System.out.print("\n"+get+" is even") ;
	    			count ++ ;
	    		}
	    		
	    	}
	    	
	    	System.out.print("\nTotal No. of Even numbers are : " + count);
	    }
	}
	
	public static void isodd(ArrayList<Integer> AR)                     // Method to check No. is odd
	{
		int m = AR.size() ;
	    int count = 0 ;
	    
	    if(AR.isEmpty())                                                // isEmpty() Method to check if ArrayList Is Empty
	    {
	    	System.out.print("\nINVALID");
	    }
	    else
	    {
	    	for(int i = 0 ; i < m ; i++)
	    	{
	    		int get = AR.get(i) ;                                       // get() Method to get value at parrticular Index
	    		
	    		if(get % 2 != 0)
	    		{
	    			System.out.print("\n"+get+" is odd") ;
	    			count ++ ;
	    		}
	    		
	    	}
	    	
	    	System.out.print("\nTotal No. of Odd numbers are : " + count);
	    }
	}
	
	public static void isprime(ArrayList<Integer> AR)                             // isprime Method to check if No. is prime
	{
		int size = AR.size() ;
	
		int Flag = -1 ;
		
		for(int i = 0 ; i < size ; i++)
		{
			int num = AR.get(i) ;
			
			if(num == 1)
			{
				Flag = 0 ;
			}
			else if(num % 2 == 0)
			{
				if (num == 2) 
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
				int n = (int) Math.ceil(Math.sqrt(num));
				for (int j = 3 ; j <= n ; j ++ )
				{
					if( num % j == 0)
					{
						Flag = 0 ;
						break ;
					}
					else
					{
						Flag = 1 ;
					}
				}
			}
	
			if(Flag == 1)
			{
				System.out.print("\n"+num+" is Prime") ;
			}
			else
			{
				System.out.print("\n"+num+" is not Prime") ;
			}
		}
		
	}

	public static void main(String[] args)
	{
	
		Scanner Sc = new Scanner(System.in) ;
		ArrayList<Integer> Ar = new ArrayList<Integer>() ;                          // Creating Arraylist Object Of datatype Integer
		                                                                            // It will store only Integers
		System.out.print("Enter The No. of elments : ");                            // Scanner used to accept size
		int a = Sc.nextInt() ;  
		
		for(int i = 1 ; i <= a ; i++)                                               // limit loop till size
		{
			System.out.print("Enter the number :") ;
			int n = Sc.nextInt() ;
			
			Ar.add(n) ;                                                               // add() method to add no.s in ArrayList
		}
		
		System.out.print("\nArrayList is :") ;
		System.out.println(Ar) ;
	
		iseven(Ar);                                                                // Calling isprime() , iseven() , isodd() Methods
		isodd(Ar) ;
		
		isprime(Ar) ;

	}

}

/*-///-//-///-//-///-//-///-//-///-Output-///-//-///-//-///-//-///-//-///-


Enter The No. of elments : 5
Enter the number :7
Enter the number :6
Enter the number :5
Enter the number :3
Enter the number :2

ArrayList is :[7, 6, 5, 3, 2]

6 is even
2 is even
Total No. of Even numbers are : 2
7 is odd
5 is odd
3 is odd
Total No. of Odd numbers are : 3
7 is Prime
6 is not Prime
5 is Prime
3 is Prime
2 is Prime

*/
