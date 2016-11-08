package cse327;
import java.util.*;

public class Sale {
	
	LinkedList <SalesLineItem> sliList = new LinkedList<SalesLineItem>();
	LinkedList <PropertyListener> lis = new LinkedList<PropertyListener>();
	IVATCalculator ivac;
	
	int total;
	public int vat;
    ISalePricingStrategy isps = null;
	
	public void addSalesLineItem (int id, int qty)
	{
		SalesLineItem sli = new SalesLineItem (id,qty);
		sliList.add (sli);
		setTotal (getPreDiscountTotal());
		//int x= sliList.size();
		//return x;
		
	}
	public void addPropertyListeners (PropertyListener prop)
	{
		lis.add(prop);
	}
	int getTotal ()
	{
		if(isps != null)
		{
			//System.out.println("" +isps.getTotal(this));
			return isps.getTotal(this);
		}
		else
		  //  System.out.println(""+this.getPreDiscountTotal());
			return this.getPreDiscountTotal();
			
	}

	int getVATAmount()
	{
		ivac= SaleFactory.getInstance().getVatCalculator();
		vat = ivac.getVATAmount(this.getTotal());
		return ivac.getVATAmount(this.getTotal());
		//return ivac.getVATAmount(this.getPreDiscountTotal());
	}
	
	int getGrandTotal()
	{
		return this.getTotal()+ this.getVATAmount();
	}
	
	int getSize ()
	{
		return sliList.size();
	}
	int getPreDiscountTotal()
	{
		int total = 0;
		for (SalesLineItem tmp : sliList)
		{
			total += tmp.getSubtotal();
		}
		
		return total;
		//System.out.println(""+total);
	}
	void setPricingStrategy (ISalePricingStrategy isps)
	{
		this.isps = isps;
		
	}
	public void PublishPropertyEvent (String name, int value)
	{
		for (int i=0;i<lis.size();i++)
		{
			PropertyListener prop = lis.get(i);
			prop.onPropertyEvent (this,name,value);
		}
	}
	public void setTotal (int newTotal)
	{
		int total = newTotal;
		PublishPropertyEvent ("sale.total",total);
	}
	

}
