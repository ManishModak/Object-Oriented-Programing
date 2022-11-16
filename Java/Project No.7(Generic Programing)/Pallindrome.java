import java.util.* ;                                                       // util pacakage contain string bulider class

public class Palindrome {

	public static void ispalindrome(String Stringdata) 
	{
		StringBuilder OriginalString = new StringBuilder(Stringdata) ;        // Creating StringBuilder Obj And 
	                                                                        // Storing String In StringBuilder
		OriginalString.reverse() ;                                            // Reversing The OriginalString
		
		String rev_Stringdata = OriginalString.toString() ;                   // Storing reversed StringBuilder in String
		
		if(Stringdata.equals(rev_Stringdata))                                 // comparing accepted string and stored string
		{
			System.out.println(Stringdata + " is palindrome") ;                 // Results
		}
		else
		{
			System.out.println(Stringdata + " is not palindrome");
		}
    
    /*                                                                    // Old Method to check pallindrome
		int i = 0 , j = Stringdata.length() - 1 ;                             // without String Builder class
		
		while(i < j)
		{
			if(Stringdata.charAt(i) != Stringdata.charAt(j))
			{
				return false;
			}
			i++ ;
			j-- ;		
		}
		
		return true ;
		*/
		
	}
	
	
	public static void main(String[] args)
	{
		  
		Scanner Sc = new Scanner(System.in) ;
		
		System.out.print("Enter the String : ");                            // Accepting String
		
		String Stringdata = Sc.next() ;             
		
		ispalindrome(Stringdata) ;                                          // Passing String as Parameter
		
		/*if(ispalindrome(Stringdata))                                      // My old method to check pallindrome
		{
			System.out.println(Stringdata + " is a palindrome") ;
		}
		else
		{
			System.out.println(Stringdata + " is not a palindrome") ;
		}
		*/

		Sc.close();
	}

}

/*-//-//-//-//-//-//-//-//-//-//-//-//-Output-//-//-//-//-//-//-//-//-//-//-//-//-

Enter the String : AABBCC
AABBCC is not palindrome

Enter the String : AABAA
AABAA is palindrome

*/
