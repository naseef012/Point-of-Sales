package cse327;

public class MyVATCalculator implements IVATCalculator
{

	//Sale s = new Sale();
	
	@Override
	public int getVATAmount(int saleTotal) 
	{
		double x;
		x= saleTotal*0.05;
		//Math.round( x) ;
		return (int) Math.round(x);
	}
 	

}	
