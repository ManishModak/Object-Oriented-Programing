import java.util.* ;
public class MultiStudent_Main {

	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in) ;
		int n , i , j , k  ;
		System.out.println("Enter the No. Students");
		n = Sc.nextInt();
		MultiStudent S[] = new MultiStudent [n] ;                                 // Array Of Reference Objects
		
    for( j = 0 ; j < n ; j++)                                                 // Creating Class Object At That Reference Object
		{
			S[j] = new MultiStudent() ;
		}
    
		for( i = 0 ; i < n ; i ++)                                                // Taking Input From User
		{
			S[i].getdata() ;
		}
		
		for( k = 0 ; k < n ; k++)                                                 // Displaying Data
		{
			S[i].display() ;
		}

	}

}
