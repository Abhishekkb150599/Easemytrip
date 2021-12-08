package com.testcase;
import org.openqa.selenium.*;

import com.pages.HotelSearch;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import io.github.bonigarcia.*;
import junit.framework.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;


public class HotelSearchTest extends TestBase {
	
	HotelSearch hs;
	ExtentTest test;
	

	@BeforeMethod
	public void initialize() {
		setup();
		hs = new HotelSearch();
		
	}
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	@Test 
	public void validHotelSrch() throws InterruptedException{
		logger.info("Validating Hotel Search with valid Hotel name");
		test=extent.createTest("Validating Hotel Search with valid Hotel name");
		boolean display = hs.validHotelSearching();
		test.log(Status.PASS, "Calling the method from Hotel Search");
		logger.info("Calling the method from Hotel Search");
		Assert.assertTrue(display);
		test.log(Status.PASS, "Comparing if the returned value is true");
		logger.info("Comparing if the returned value is true");
		test.log(Status.PASS, "ValidateSearch with valid Hotel name passed successfully");
		logger.info("ValidateSearch with valid Hotel name passed successfully");
		
	}
	
	@Test 
	public void invalidHotelSrch() throws InterruptedException{
		logger.info("Validating Hotel Search with invalid Hotel name");
		test=extent.createTest("Validating Hotel Search with invalid Hotel name");
		
		String ExpectedAlert = "Please select city location name";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		String actualAlert=hs.invalidHotelSearching();
		test.log(Status.PASS, "Calling the method from HotelSearch");
		logger.info("Calling the method from HotelSearch");
		

		Assert.assertEquals(ExpectedAlert ,actualAlert );
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("Comparing actual and expected value");
		test.log(Status.PASS, "ValidateSearch with invalid Hotel name passed successfully");
		logger.info("ValidateSearch with invalid Hotel name passed successfully");
		
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