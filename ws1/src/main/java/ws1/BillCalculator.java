package ws1;

import java.util.ArrayList;
import java.util.List;

public class BillCalculator {
	
	List<Double> billItems;
	
	public BillCalculator() {
		this.billItems = new ArrayList<>();
	}
	
	/** returns the new total */
	public double addItem (double price) {
		billItems.add(price);
		return calculateTotal();		
	}
	
	/** returns the new total */ 
	public double removeLastItem() {
		if (this.billItems.isEmpty())
			return 0;
		
		int lastIndex = this.billItems.size()-1;
		billItems.remove(lastIndex);
		return calculateTotal();
	}	
	
	/** returns the new total after discount */ 
	public double applyDiscount (int percentage) { 
		if (percentage < 0)
			percentage = 0;
		else if (percentage > 100)
			percentage = 100;
		double totalBeforeDiscount = calculateTotal();
		return totalBeforeDiscount - ((percentage/100.0)*totalBeforeDiscount);
	}	
	
	/** returns the bill total */
	public double calculateTotal() { 
		double total = 0.0;
		for (Double itemPrice : billItems) {
			total += itemPrice;
		}
		return total;
	}
	
	public String toString() 
	{
		if(billItems.isEmpty())
			return "NOTHING";
		
		StringBuilder sb = new StringBuilder();
		
		for(Double item : billItems) 
		{
			sb.append(item);
			sb.append("\n");			
		}
		return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		BillCalculator bc = new BillCalculator();
		System.out.println(bc.calculateTotal());
		System.out.println(bc);
		
		System.out.println("Adding items ... ");
		
		System.out.println(bc.addItem(5));
		System.out.println(bc.addItem(2));
		System.out.println(bc.addItem(4));
		
		System.out.println("Removing an item ... ");
		System.out.println(bc.removeLastItem());
		
		System.out.println("Applying a discount ... ");
		System.out.println(bc.applyDiscount(50));
		
		System.out.println("Printing the List ... ");
		System.out.println(bc);
	}

}
