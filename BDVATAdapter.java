package cse327;

public class BDVATAdapter implements IVATCalculator {
	BDVATCalculator bdv = new BDVATCalculator ();
	public int getVATAmount(int saletotal)
	{
		return (int) bdv.CalculateVATAmount(saletotal);
	}
}
