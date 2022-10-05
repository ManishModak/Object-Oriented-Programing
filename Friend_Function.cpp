#include<iostream>
using namespace std ;

class Meter_Centi ;                                                                 // Forward Declaration so it can be used in friend function

class Feet_Inches                                                                   // First Class
{
    private :
        double Feet , Inches ;

    public :
        Feet_Inches(double Ft, double In) ;
        void display() ;
        friend Feet_Inches Add (Feet_Inches , Meter_Centi) ;
        friend Meter_Centi Add (Meter_Centi , Feet_Inches) ;
        friend Feet_Inches Sub (Feet_Inches , Meter_Centi) ;
        friend Meter_Centi Sub (Meter_Centi , Feet_Inches) ;
};

class Meter_Centi                                                                    // Second Class
{
    private :
        double Meter , Centi ;

    public :
        Meter_Centi(double M , double Cm) ;
        void display() ;
        friend Meter_Centi Add (Meter_Centi , Feet_Inches) ;
        friend Feet_Inches Add (Feet_Inches , Meter_Centi) ;
        friend Meter_Centi Sub (Meter_Centi , Feet_Inches) ;
        friend Feet_Inches Sub (Feet_Inches , Meter_Centi) ;
};

Meter_Centi :: Meter_Centi( double M , double Cm )                                   
{
    Meter = M ;
    Centi = Cm ;
}

Feet_Inches :: Feet_Inches ( double Ft , double In)
{
    Feet = Ft ;
    Inches = In ;
}

void Feet_Inches :: display()
{
    cout << "The Total Distance is : " << Feet << "  Ft" << "\t" << Inches << "  Inch" << "\n" ;
} 

void Meter_Centi :: display()
{
    cout << "The Total Distance is : " << Meter << "  M" << "\t" << Centi << "  Cm" ;
}

Feet_Inches Add (Feet_Inches Ft , Meter_Centi M)                                                    // Defining Friend Functions
{
    int temp ;
    temp = (int) Ft.Feet*12 + Ft.Inches + (M.Centi*0.393701) + (M.Meter*39.3701) ;
    Feet_Inches temp1 (0,0) ;
    temp1.Feet = temp / 12 ;
    temp1.Inches = temp % 12 ;
    return temp1 ;                                                                                  // retuning value to store in object created in main
} 


Meter_Centi Add (Meter_Centi M , Feet_Inches Ft)
{
    int temp ;
    temp = (int) M.Centi + (Ft.Inches * 2.54 ) + (M.Meter * 100 ) + (Ft.Feet*30.48) ;
    Meter_Centi temp2 (0,0) ;
    temp2.Meter = temp / 100 ;
    temp2.Centi = temp % 100 ;
    return temp2 ;
}

Feet_Inches Sub (Feet_Inches Ft , Meter_Centi M)
{
    int temp ;
    temp = (int) Ft.Feet*12 + Ft.Inches - (M.Centi*0.393701) - (M.Meter*39.3700787) ;
    Feet_Inches temp3 (0,0) ;
    temp3.Feet = temp / 12 ;
    temp3.Inches = temp % 12 ;
    return temp3 ;
}

Meter_Centi Sub (Meter_Centi M , Feet_Inches Ft)
{
    int temp ;
    temp = (int) M.Centi - (Ft.Inches * 2.54 ) + (M.Meter * 100 ) - (Ft.Feet*30.48) ;
    Meter_Centi temp4 (0,0) ;
    temp4.Meter = temp / 100 ;
    temp4.Centi = temp % 100 ;
    return temp4 ;
}


int main()
{
    double Meter , Centi , Feet , Inch ;
    int Choice , c ;

    cout << "Enter the Distance in meter and centimeter resp. " << "\n" ;
    cin >> Meter ;
    cin >> Centi ;

    cout << "Enter the Distance in Feet and Inches resp. " << "\n" ;
    cin >> Feet ;
    cin >> Inch ;

    Feet_Inches F1 (Feet , Inch) ;                                                                    // Need to create objects outside of switch
    Meter_Centi M1 (Meter , Centi) ;                                                                  // Throws Error If Created In Switch

    Feet_Inches F2 (0,0) ;
    Meter_Centi M2 (0,0) ;

    do
    {
        cout <<"\n" << "Enter 1 For Addition" <<"\n" ;
        cout << "Enter 2 For Subtraction" << "\n" ;
        cout << "Enter The Choice : " ;
        cin >> Choice ;
        switch (Choice)
        {
            case 1:
                cout << "\n" << "Enter 1 For Addition In Feet And Inches" <<"\n" ;
                cout << "Enter 2 For Addition In Meter And Centi" << "\n" ;
                cout << "Enter the Choice : " ;
                cin >> c ;
                switch(c)
                {
                    case 1 :
                        F2 = Add (F1 , M1) ;
                        cout <<"\n" << "Enter 3 To Display In Feet And Inches" << "\n" ;
                        break ;
                    case 2 :
                        M2 = Add (M1 , F1) ; 
                         cout <<"\n" << "Enter 4 To Display In Meter And Centimeter" <<"\n" ;      
                }
                break ;

            case 2:
                cout << "\n" << "Enter 1 For Subtraction In Feet And Inches" <<"\n" ;
                cout << "Enter 2 For Subtraction In Meter And Centi" << "\n" ;
                cout << "Enter the Choice : " ;
                cin >> c ;
                switch(c)
                {
                    case 1:
                        F2 = Sub (F1 , M1) ;
                        cout << "\n" << "Enter 3 To Display In Feet And Inches" << "\n";
                        break ;
                    case 2:
                        M2 = Sub (M1 , F1) ;
                        cout << "\n" <<"Enter 4 To Display In Meter And Centimeter" << "\n" ;
                }
                break;
            case 3:
                F2.display() ;
                cout << "\n" << "Enter 5 To end The Operation" << "\n" ;
                break;
            case 4:
                M2.display() ;
                cout << "\n" << "Enter 5 To end The Operation" << "\n";
                break;
            case 5:
                cout << "The Operation Has Ended" ;
        }
       
    } while (Choice != 5);  

    return 0 ;
}

/*********************************************OUTPUT***************************************************


Enter the Distance in meter and centimeter resp. 
137.89
698.12
Enter the Distance in Feet and Inches resp. 
7.17
26.72

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 1

Enter 1 For Addition In Feet And Inches
Enter 2 For Addition In Meter And Centi
Enter the Choice : 1

Enter 3 To Display In Feet And Inches

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 1

Enter 1 For Addition In Feet And Inches
Enter 2 For Addition In Meter And Centi
Enter the Choice : 1

Enter 3 To Display In Feet And Inches

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 3
The Total Distance is : 484  Ft 6  Inch

Enter 5 To end The Operation

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 2

Enter 1 For Subtraction In Feet And Inches
Enter 2 For Subtraction In Meter And Centi
Enter the Choice : 1

Enter 3 To Display In Feet And Inches

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 3
The Total Distance is : -466  Ft        0  Inch

Enter 5 To end The Operation

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 2

Enter 1 For Subtraction In Feet And Inches
Enter 2 For Subtraction In Meter And Centi
Enter the Choice : 2

Enter 4 To Display In Meter And Centimeter

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 4
The Total Distance is : 142  M  0  Cm
Enter 5 To end The Operation

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 2

Enter 1 For Subtraction In Feet And Inches
Enter 2 For Subtraction In Meter And Centi
Enter the Choice : 1

Enter 3 To Display In Feet And Inches

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 3
The Total Distance is : -466  Ft        0  Inch

Enter 5 To end The Operation

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 1

Enter 1 For Addition In Feet And Inches
Enter 2 For Addition In Meter And Centi
Enter the Choice : 2

Enter 4 To Display In Meter And Centimeter

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 4
The Total Distance is : 147  M  73  Cm
Enter 5 To end The Operation

Enter 1 For Addition
Enter 2 For Subtraction
Enter The Choice : 5
The Operation Has Ended
*/
