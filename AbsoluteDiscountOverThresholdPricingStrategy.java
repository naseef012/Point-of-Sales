package cse327;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {
	int discount=100;
	int threshold=1000;
	
	public int getTotal (Sale s)
	{
		int temp = 0;
		int pdt = s.getPreDiscountTotal();
		if (pdt < threshold)
		{
			return pdt;
		}
		else
		{
			temp = pdt - discount;
		}
		//System.out.println(s.getPreDiscountTotal() + ", " + temp);
		return temp;
	}

}
