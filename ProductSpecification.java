package cse327;
import java.util.*;

public class ProductSpecification {
	int id;
	String description,name;     
	int price;
	
	void setId(int id)
	{
		this.id=id;
	}
	int getId()
	{
		return id;
	}
	void setname(String name)
	{
		this.name=name;
	}
	void setPrice(int price)
	{
		this.price = price;
	}
	int getPrice()
	{
		return price;
	}
	void setDescription(String description)
	{
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
}
