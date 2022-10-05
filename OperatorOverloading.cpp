#include<iostream>
using namespace std ;

class sample
{
    int num;

    public:
        void getdata();
        void display();
        friend sample operator + (int  , sample);
        friend sample operator + (sample , int );
};

void sample :: getdata()
{
    cout<< "Enter a number:";
    cin >> num;
}

void sample ::display() 
{
    cout << "\n" << "The number is:" << num ;
    
}

sample operator+(sample x, int y) {
    sample temp;
    temp.num = y + x.num;
    return temp;
}

sample operator+(int y, sample x){
    sample temp;
    temp.num = x.num + y ;
    return temp;
}

int main() {

    sample obj1, obj2, obj3 ;

    obj1.getdata();
    obj1.display();

    int x;
    cout << "\n" << "Enter value for x: " ;
    cin >> x;

    obj2 = obj1 + x;
    obj2.display();

    obj3 = x + obj1;
    obj3.display();
}

/***************Output******************
Enter a number:72

The number is:72
Enter value for x: 7

The number is:79
The number is:79
*/