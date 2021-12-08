package com.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.FlightBooking;

import junit.framework.Assert;

public class FlightBookingTest extends TestBase {
FlightBooking bk;

	
	@BeforeMethod
	public void book() {
		setup();
		bk = new FlightBooking();
	}
	
	
	
	@Test//(enabled=false)
	public void TestFlightBooking() throws InterruptedException {
		boolean b= bk.Bookingaflight();
		Assert.assertTrue(b);
	}
	
}


