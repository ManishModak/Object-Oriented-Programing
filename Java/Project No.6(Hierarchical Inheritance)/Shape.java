abstract public class Shape                             //class must be abstract even if there is one abstract method
{
	
	protected double x , y ;
	
	abstract public void getdata() ;                      //abstract methods so we can modify according to our needs
	                                                      //in derived classes
	abstract public void compute_area() ;
	
}
