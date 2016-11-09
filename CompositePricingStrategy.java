package cse327;
import java.util.*;

public abstract class CompositePricingStrategy implements ISalePricingStrategy {
	Sale s = new Sale();
	LinkedList <ISalePricingStrategy> pricing_strat_li = new LinkedList <>();
	//ISalePricingStrategy is;
	public CompositePricingStrategy add (ISalePricingStrategy is)
	{
		pricing_strat_li.add(is);
		return this;
	}
	@Override
	public abstract int getTotal(Sale sale);
	
}
