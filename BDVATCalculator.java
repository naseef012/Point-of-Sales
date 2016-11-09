package cse327;

public class BDVATCalculator {
	Sale s = new Sale();
		
	float CalculateVATAmount (int total)
	{
		return (float) (total * 0.035);
	}
	

}
