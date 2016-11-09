package cse327;
import java.util.*;
public class ProcessSaleController {

	Sale sale ;//= new Sale ();
	SaleFactory sf =new SaleFactory ();
	public Sale getSale() {
		return sale;
	}
	public void newSale(){
		this.sale= new Sale();
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	void addItem (int id, int qty)
	{
		sale.addSalesLineItem(id, qty);
	}
	
}
