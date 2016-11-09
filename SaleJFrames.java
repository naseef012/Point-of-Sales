package cse327;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class SaleJFrames implements PropertyListener {
	private static JTextField textDiscount;
	 //ProcessSaleController psc = new ProcessSaleController();
	  static int total=0;
	  static JComboBox comboBox;
	  static JFrame frame = new JFrame();
	  static JTable table = new JTable();
	  static DefaultTableModel model = new DefaultTableModel();
	  static JTextField textId = new JTextField();
	  static JTextField textqty = new JTextField();
	  static JButton btnItem = new JButton("Add Item");
	  static JButton btnNewSale = new JButton("NewSale"); 
	  static JScrollPane pane = new JScrollPane(table);
	  private static JTextField textVat;
	  static int l=1;
	  private static JTextField textGtotal;
	  public static String [] filename= {"Senior Discount 10%", "Eid Discount 10% over 1000tk","Best For Customer", "Best for Store"};
	  
	 
	  
    public static void main(String[] args){
       
        //JFrame frame = new JFrame();
        //JTable table = new JTable();   
      
       
        ProcessSaleController psc = new ProcessSaleController();
        PercentageDiscountPricingStrategy pdps = new PercentageDiscountPricingStrategy();
        SaleFactory sf = new SaleFactory ();
        Sale s = new Sale();
        
        psc.newSale();
        
        Object[] columns = {"SL","ID","Name","Quantity","Unit Price","Sub Total"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);      
    
        textId.setBounds(79, 237, 100, 25);
        textqty.setBounds(79, 267, 100, 25);

        btnItem.setBounds(79, 299, 100, 25);
        btnNewSale.setBounds(79, 206, 100, 25);

        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(pane);
        
       
        frame.getContentPane().add(textId);
        frame.getContentPane().add(textqty);
       
        frame.getContentPane().add(btnItem);
        frame.getContentPane().add(btnNewSale);
        
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(23, 242, 46, 14);
        frame.getContentPane().add(lblId);
        
        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(10, 267, 59, 14);
        frame.getContentPane().add(lblQuantity);
        
        textDiscount = new JTextField();
        textDiscount.setBounds(298, 239, 86, 20);
        frame.getContentPane().add(textDiscount);
        textDiscount.setColumns(10);
        
        JLabel lblDiscount = new JLabel("Discount");
        lblDiscount.setBounds(223, 242, 65, 14);
        frame.getContentPane().add(lblDiscount);
        
        textVat = new JTextField();
        textVat.setBounds(298, 269, 86, 20);
        frame.getContentPane().add(textVat);
        textVat.setColumns(10);
        
        JLabel lblVat = new JLabel("VAT");
        lblVat.setBounds(242, 272, 46, 14);
        frame.getContentPane().add(lblVat);
        
        textGtotal = new JTextField();
        textGtotal.setBounds(298, 301, 86, 20);
        frame.getContentPane().add(textGtotal);
        textGtotal.setColumns(10);
        
        JLabel lblGrandTotal = new JLabel("Grand Total");
        lblGrandTotal.setBounds(210, 304, 78, 14);
        frame.getContentPane().add(lblGrandTotal);
        
        comboBox = new JComboBox(filename);
        comboBox.setBounds(461, 242, 228, 20);
        frame.getContentPane().add(comboBox);
        
        JButton btnDiscount = new JButton("Calculate Discount");
        btnDiscount.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (comboBox.getSelectedIndex()==0 )
        		{
        			ISalePricingStrategy isps = new PercentageDiscountPricingStrategy();
        		    psc.getSale().setPricingStrategy(isps);
        			textGtotal.setText (""+psc.sale.getGrandTotal());
        			textVat.setText(""+psc.sale.getVATAmount());
        		}
        		if (comboBox.getSelectedIndex()==1)
        		{
        			
        			if (psc.sale.getTotal()>=1000)
        				textDiscount.setText("100");
        			ISalePricingStrategy isps = new AbsoluteDiscountOverThresholdPricingStrategy ();
        			psc.sale.setPricingStrategy(isps);
        			textGtotal.setText(""+psc.sale.getGrandTotal());
        			textVat.setText(""+psc.sale.getVATAmount());
        			
        		}
        		if (comboBox.getSelectedIndex()==2)
        		{
        			ISalePricingStrategy isps = new CompositeBestForCustomerPricingStrategy()
        					.add(new AbsoluteDiscountOverThresholdPricingStrategy())
        					.add(new PercentageDiscountPricingStrategy());
        			psc.sale.setPricingStrategy(isps);
        			textGtotal.setText(""+psc.sale.getGrandTotal());
        		}
        		if (comboBox.getSelectedIndex()==3)
        		{
        			ISalePricingStrategy isps = new CompositeBestForStorePricingStrategy()
        					.add(new AbsoluteDiscountOverThresholdPricingStrategy())
        					.add(new PercentageDiscountPricingStrategy());
        			psc.sale.setPricingStrategy(isps);
        			textGtotal.setText(""+psc.sale.getGrandTotal());
        		}
        	}
        });
        btnDiscount.setBounds(461, 312, 228, 23);
        frame.getContentPane().add(btnDiscount);
        
        JLabel lblDiscountStrategy = new JLabel("Discount Strategy");
        lblDiscountStrategy.setBounds(461, 217, 115, 14);
        frame.getContentPane().add(lblDiscountStrategy);
        
       
        
        Object[] row = new Object[6];
        
        // button add item
        btnItem.addActionListener(new ActionListener(){

        	@Override        	
            public void actionPerformed(ActionEvent e) {
        	
        	
        	if (Integer.parseInt(textId.getText())>=1 && Integer.parseInt(textId.getText())<=sf.getSize() && Integer.parseInt(textqty.getText())>0)
		        	{
		        		SalesLineItem sli =new SalesLineItem(Integer.parseInt(textId.getText()),Integer.parseInt(textqty.getText()) );
		                psc.addItem(Integer.parseInt(textId.getText()), Integer.parseInt(textqty.getText()));
		                //initializeSale (psc.sale);
		                //s.addPropertyListeners(psc.sale);
		        		row[0] =""+l; //textId.getText();
		                row[1] = Integer.parseInt(textId.getText());
		                row[2] = "" +sf.getProductSpecification(Integer.parseInt(textId.getText())).getName();
		                row[3] = Integer.parseInt(textqty.getText());
		                row[4] =""+sf.getProductSpecification(Integer.parseInt(textId.getText())).getPrice() ;
		                row[5] = ""+sli.getSubtotal();
		                
		                model.addRow(row);
		                
		                total+=sli.getSubtotal();
		                l++;
		                
		                //textTotal.setText(""+psc.sale.getTotal());
		                textVat.setText(""+psc.sale.getVATAmount());
		                textGtotal.setText(""+psc.sale.getGrandTotal());
		                Toolkit.getDefaultToolkit().beep();
		                JOptionPane.showMessageDialog(null," " +sli.getSubtotal());
		        	
		        	}
        	
        	else 
		        	{
		        		JOptionPane.showMessageDialog(null, "NO ITEM FOUND");
		        	}
            }

        });
        
        
        comboBox.addActionListener(new ActionListener()
        {
        	 @Override
        	public void actionPerformed (ActionEvent e)
        	{
        		// System.out.println(comboBox.getSelectedIndex());
        	}
        });

        // button new sale

        btnNewSale.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	psc.newSale();
            	
            	textDiscount.setText("");
            	textqty.setText("");
            	textId.setText("");
            	textVat.setText("");
            	textGtotal.setText("");
        	
            	table.getModel();
            	l=1;
            	while (model.getRowCount()>0)
            	{
            		for (int k=0;k<model.getRowCount();k++)
            		{
            			model.removeRow(k);
            		}
            	}
             }
          }
        );
      
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
   
    }
 
    public void  initializeSale (Sale sale)
    {
   	 	sale.addPropertyListeners(this);
    }

	@Override
	public void onPropertyEvent(Sale source, String name, int value) {
		// TODO Auto-generated method stub
		if (name.equals("sale.total")==true)
		{
		
			Toolkit tk = Toolkit.getDefaultToolkit();
		    tk.beep();
		}
		
	}
}

