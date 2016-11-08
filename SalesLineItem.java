package cse327;


public class SalesLineItem {
	int quantity;
	ProductSpecification ps = new ProductSpecification();
	SaleFactory sf = new SaleFactory ();
	
	
	public SalesLineItem() {
		super();
	}

	SalesLineItem (int id, int quantity)
	{   
		//super();
		this.ps = sf.getProductSpecification (id);
		this.quantity = quantity;
	}
	
	void setQuantity (int quantity)
	{
		this.quantity = quantity;
	}
	
	int getQuantity ()
	{
		return quantity;
	}
	int getSubtotal ()
	{
		return quantity * ps.price;
	}

}
