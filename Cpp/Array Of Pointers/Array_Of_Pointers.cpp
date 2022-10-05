#include<iostream>
using namespace std ;				


class Student										// Class Declaration
{
	private :
		int age ;
		char name[10] ;
	public :
		void getdata();
		void display();
};

void Student :: getdata()
{
	cout << "Enter the name of student"<< "\n" ;
	cin >> name ;
	cout << "Enter the age of student"<< "\n" ;
	cin >> age ;
}

void Student :: display()
{
	cout << name << "\t" << age << "\n" ;
}

int main()
{
	int n , i , search ;
	cout << "Enter the no. of students" ;
	cin >> n ;
	Student *p[n];									// Array Of Pointers
	
	for ( i = 0 ; i < n ; i++ )							// Assigninig Objects To Pointers
	{
		p[i] = new Student() ;	
	}
	
	for ( i = 0 ; i < n ; i++ )							// Assigning Data To Objects
     	{
           	p[i] -> getdata() ;       
     	}
	
	cout << "Name" << "\t" << "Age" << "\n" ;
	
	for ( i = 0 ; i < n ; i++ )							// Displaying Student Data
	{
		p[i] -> display() ;
	}

	cout << "Enter the no. to Search" << "\n" ;					// Displaying Student Data According Sr. NO.
	cin >> search ;
	p[search - 1] -> display() ;

	return 0 ;
}

