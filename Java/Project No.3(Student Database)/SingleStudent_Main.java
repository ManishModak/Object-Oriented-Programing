import java.util.* ;

public class SingleStudent_Main
{

	public static void main(String[] args) {
		//Student S = new Student() ;
		//S.getdata();
		
		int age ;
		String name ;
		
		Scanner Sc = new Scanner(System.in) ;
		System.out.println("Enter The Age ");
		age = Sc.nextInt();
		System.out.println("Enter The Name");
		name = Sc.next() ;
		
		SingleStudent S = new SingleStudent(age , name) ;
		S.display();
	}

}
