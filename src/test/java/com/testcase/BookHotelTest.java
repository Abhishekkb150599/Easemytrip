package com.testcase;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import org.testng.annotations.Parameters;

import com.pages.BookHotel;


public class BookHotelTest extends TestBase{
	BookHotel bk;
	ExtentTest test;

	
	@BeforeMethod
	public void setup1() {
		setup();
		bk = new BookHotel();
	}
	
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	
	
	@Test()
	public void TestBookHotel() throws InterruptedException {
		logger.info("Validating Hotel Booking with valid credentials");
		test=extent.createTest("Validating Hotel Booking with valid credentials");
		
		boolean b = bk.ValidateHotelBook();
		test.log(Status.PASS, "Calling the method from HotelBook page");
		logger.info("Calling the method from HotelBook page");
		
		Assert.assertTrue(b);
		test.log(Status.PASS, "Comparing if the returned value is true");
		logger.info("Comparing if the returned value is true");
		test.log(Status.PASS, "Validating Hotel Booking with valid credentials passed successfully");
		logger.info("Validating Hotel Booking with valid credentials passed successfully");
		
		
	}
	
	@Test()
	public void TestBookHotel2() throws InterruptedException{
		logger.info("Validating Hotel Booking with invalid credentials");
		test=extent.createTest("Validating Hotel Booking with invalid credentials");
		
		String Expecteted ="please enter the valid emailid";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		String I = bk.InvalidHotelBook();
		test.log(Status.PASS, "Calling the method from HotelBook page");
		logger.info("Calling the method from HotelBook page");
		
		Assert.assertEquals(Expecteted, I);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("Comparing actual and expected value");
		test.log(Status.PASS, "Validating Hotel Booking with invalid credentials passed successfully");
		logger.info("Validating Hotel Booking with invalid credentials passed successfully");
		
	}
	
	@AfterTest
	public void GenerateReport() {
		CloseReportSetup();
	}
	
	@AfterMethod
	public void close() {
		closesetup();
	}
	


}