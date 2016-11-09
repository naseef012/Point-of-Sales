# Point-of-Sales

CHECK THE RAW VERSION OF THIS "README.MD" FILE FOR BETTER READABILITY. 

Steps to start this Project
  
  1. As this is a Java project any IDE which supports Java will be fine for this. I used Eclipse and uploaded all the source class              files.
  
  2. The main() function is in "SaleJFrames.java" file. So running this will start off the application.
 
  3. Upon starting the software, there are TextFields where you can put the ID number of the product and the Quantity of the product a 
     customer wants.
  
  4. The ID and their respective product names are given below with their pricing. The products are given as demo values and prices            which are not real values. These are only used for project demo.
      
      ID              PRODUCT             PRICE (tK)
      
      1                Bat                100
      
      2                Dumbbell           20
      
      3                Football           500
     
      4                Boot               800
      
      5                Helmet             600
        
   5. On the left there is a dropdown ComboBox which contains different discount strategies. Choosing any one will change the discounted        "Grand Total".
   
   6. The VAT is calculated upon the discounted TotalPrice.
   
   7. The "config.txt" and "config2.txt" files need to be kept in the project folder.
   
   8. "config2.txt" --> This file contains the discount strategy which the store wants to follow for Best for customer and Best for Store        discount strategy
   
   9. "config.txt"  --> This file contains the VAT calculation strategy. Here BDVAT is used.
   
   10. Calculate Discount button calculates the discounts. Unless pressed, the Grand Value will be the value without any kind of                discounts.
   11. "New Sale" removes all the item and makes the GUI suitable for a new customer's sales.
