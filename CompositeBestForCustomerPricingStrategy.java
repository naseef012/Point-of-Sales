package cse327;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy{
	@Override
	public int getTotal (Sale sale)
	{
		int lowestTotal = Integer.MAX_VALUE;
		ISalePricingStrategy isps;
		for (int i=0;i<pricing_strat_li.size();i++)
		{
			isps= pricing_strat_li.get(i);
			int total = isps.getTotal(sale);
			lowestTotal = Math.min(total, lowestTotal);
			
		}
		return lowestTotal;
	}

}
