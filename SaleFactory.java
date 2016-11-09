package cse327;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class SaleFactory {
	LinkedList <ProductSpecification> psList = new LinkedList <ProductSpecification>();
	static SaleFactory instance ;
	static IVATCalculator vatCalculator;
	ISalePricingStrategy isps;
	
	SaleFactory ()
	{
		ProductSpecification ps = new ProductSpecification();
		ps.setId(1);
		ps.setname("Bat");
		ps.setPrice (100);
		ps.setDescription("Cricket");
		psList.add(ps);
		
		ProductSpecification ps2 = new ProductSpecification();
		ps2.setId(2);
		ps2.setname("Dumbell");
		ps2.setPrice (20);
		ps2.setDescription("Stainless steel");
		psList.add(ps2);
		
		ProductSpecification ps3 = new ProductSpecification();
		ps3.setId(3);
		ps3.setname("Football");
		ps3.setPrice (500);
		ps3.setDescription("Nike");
		psList.add(ps3);
		
		ProductSpecification ps4 = new ProductSpecification();
		ps4.setId(4);
		ps4.setname("Boot");
		ps4.setPrice (800);
		ps4.setDescription("Nike");
		psList.add(ps4);
		
		ProductSpecification ps5 = new ProductSpecification();
		ps5.setId(5);
		ps5.setname("Helmet");
		ps5.setPrice (600);
		ps5.setDescription("MRF");
		psList.add(ps5);
		
		//int x = psList.size();
	}
	
	ProductSpecification getProductSpecification (int id)
		{
		
			for (int i = 0; i < psList.size(); i++) 
			{
				if(id==psList.get(i).getId())
				{
					return psList.get(i);
				}
			}
			return null;
		}
  
	
	public int getSize ()
	     {
	    	  return psList.size();
	     }
	public static synchronized SaleFactory getInstance()
	{
		if (instance == null)
		{
			instance = new SaleFactory();
		}
		return instance;
	}
		
	public IVATCalculator getVatCalculator ()
	{
		
		if (vatCalculator == null)
		{
			String className = "BDVATAdapter";//DECLARING STRING VARIABLE THT WILL AUTOOMATICALLY CALL BDVAT ADAPTER
			try(BufferedReader br = new BufferedReader(new FileReader("config.txt")))
			{
				String currentLine;
				while ((currentLine=br.readLine())!=null)
				{
					className = currentLine;
					//System.out.println(currentLine);
				}
			}catch (IOException e)
			{
				e.printStackTrace();
			}
			try{
				vatCalculator = (IVATCalculator)Class.forName(className).newInstance();
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		return vatCalculator;
	}
	public ISalePricingStrategy getPricingStrategy ()
	{
		
		if (isps == null)
		{
			String className = "AbsoluteDiscountOverThresholdPricingStrategy";//DECLARING STRING VARIABLE THT WILL AUTOOMATICALLY CALL BDVAT ADAPTER
			try(BufferedReader br = new BufferedReader(new FileReader("config2.txt")))
			{
				String currentLine;
				while ((currentLine=br.readLine())!=null)
				{
					className = currentLine;
					//System.out.println(currentLine);
				}
			}catch (IOException e)
			{
				e.printStackTrace();
			}
			try{
				isps = (ISalePricingStrategy)Class.forName(className).newInstance();
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		return isps;
	}
	
}