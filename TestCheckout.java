package jl0131;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TestCheckout {
	Checkout checkout = new Checkout();
	
	@Test
	public void test1() {
		checkout.setToolCode("JAKR");
		checkout.setCheckOutDate("9/3/15");
		checkout.setRentalDayCount(5);
		checkout.setDiscountPercent(101);
		
		boolean validationResult = checkout.validateProperties();
		
		// This one will be false because the discount percent is not within the 0 to 100 range
		assertEquals(false, validationResult);
		checkout.generateRentalAgreement();
	}
	
	@Test
	public void test2() {
		checkout.setToolCode("LADW");
		checkout.setCheckOutDate("7/2/20");
		checkout.setRentalDayCount(3);
		checkout.setDiscountPercent(10);
		
		boolean validationResult = checkout.validateProperties();
		assertEquals(true, validationResult);
		checkout.generateRentalAgreement();
	}
	
	@Test
	public void test3() {
		checkout.setToolCode("CHNS");
		checkout.setCheckOutDate("7/2/15");
		checkout.setRentalDayCount(5);
		checkout.setDiscountPercent(25);
		
		boolean validationResult = checkout.validateProperties();
		assertEquals(true, validationResult);
		checkout.generateRentalAgreement();
	}
	
	@Test
	public void test4() {
		checkout.setToolCode("JAKD");
		checkout.setCheckOutDate("9/3/15");
		checkout.setRentalDayCount(6);
		checkout.setDiscountPercent(0);
		
		boolean validationResult = checkout.validateProperties();
		assertEquals(true, validationResult);
		checkout.generateRentalAgreement();
	}
	
	@Test
	public void test5() {
		checkout.setToolCode("JAKR");
		checkout.setCheckOutDate("7/2/15");
		checkout.setRentalDayCount(9);
		checkout.setDiscountPercent(0);
		
		boolean validationResult = checkout.validateProperties();
		assertEquals(true, validationResult);
		checkout.generateRentalAgreement();
	}
	
	@Test
	public void test6() {
		checkout.setToolCode("JAKR");
		checkout.setCheckOutDate("7/2/20");
		checkout.setRentalDayCount(4);
		checkout.setDiscountPercent(50);
		
		boolean validationResult = checkout.validateProperties();
		assertEquals(true, validationResult);
		checkout.generateRentalAgreement();
	}
}
