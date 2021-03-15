package ws1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class BillCalculatorTests {

	@Test
	public void testNoItems() {
		BillCalculator bc = new BillCalculator();
		assertEquals(0,bc.calculateTotal(), "Empty Bill");
	}
	
	@Test
	public void testAddOneItem() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
	}
	
	@Test
	public void testAddThreeItems() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertEquals(8, bc.addItem(1),"Adding item of value 1");
	}
	
	@Test
	public void testToStringEmptyBill() {
		BillCalculator bc = new BillCalculator();
		assertEquals("NOTHING", bc.toString());
	}
	@Test
	public void testToStringNonEmptyBill() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertNotEquals("NOTHING", bc.toString());
	}
	
	@Test
	public void testCalculateTotal()
	{
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertEquals(7,bc.calculateTotal(), "5+2=7");
		
	}
	@Test
	public void testFreeLunch() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertEquals(0, bc.applyDiscount(100),"Applying 100% discount");
	}
	
	@Test
	public void testNegativeDiscount() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertEquals(7, bc.applyDiscount(-50),"Applying -50% discount");
	}
	
	@Test
	public void testDiscountGreaterThanHundred() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5),"Adding item of value 5");
		assertEquals(7, bc.addItem(2),"Adding item of value 2");
		assertEquals(0, bc.applyDiscount(150),"Applying 150% discount");
	}
	
	@Test 
	public void testRemoveLastItem() {
		BillCalculator bc = new BillCalculator();
		assertEquals(0, bc.removeLastItem(),"Removing Last Item from empty list");
		bc.addItem(5);
		assertEquals(0, bc.removeLastItem(),"Removing Last Item");
		
		
	}
}
