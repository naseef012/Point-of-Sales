package cse327;

public class PercentageDiscountPricingStrategy implements ISalePricingStrategy {
	double percentage = 0.1;
	@Override
	public int getTotal (Sale sale)
	{   
	
		//System.out.println("hello "+(sale.getPreDiscountTotal()));
		//return (int) (((sale.getPreDiscountTotal())+ sale.vat)*0.1);
		double x = (sale.getPreDiscountTotal()- (sale.getPreDiscountTotal()*percentage));
		//System.out.println (" PercentageDisc  "+ x);
		return (int)  (sale.getPreDiscountTotal()- (sale.getPreDiscountTotal()*percentage));
	}

}
