package cse327;

public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy {
	
	@Override
	public int getTotal (Sale sale)
	{
		int highestTotal = 0;
		ISalePricingStrategy isps;
		for (int i =0;i<pricing_strat_li.size();i++)
		{
			isps = pricing_strat_li.get(i);
			highestTotal = Math.max (isps.getTotal(sale),highestTotal);
		}
		System.out.println("Best for store "+highestTotal);
		return highestTotal;

	}
	
}
