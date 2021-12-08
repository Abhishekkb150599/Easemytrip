package com.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.pages.FlightSearchingPage;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestSourceAndDestination extends TestBase {
	WebDriver driver;
	FlightSearchingPage lp;
	ExtentTest test;

	@BeforeMethod

	public void Initialize() {
		setup();
		lp=new FlightSearchingPage();

	}
	
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	@Test()
	public void validSourceAndvalidDestination() throws InterruptedException {
		logger.info("Validating Search with valid source and destination");
		test=extent.createTest("Validating Search with valid source and destination");
		
		boolean condition=lp.enterValidSourceAndValidDest();
		test.log(Status.PASS, "Calling the method from FlightSearchPage");
		test.log(Status.PASS, " Valid Source City entered successfully");
		test.log(Status.PASS, "Valid Destination city entered successfully");
		
		logger.info("Calling the method from FlightSearchPage");
		
		Assert.assertTrue(condition);
		test.log(Status.PASS, "Comparing if the returned value is true");
		logger.info("Comparing if the returned value is true");
		test.log(Status.PASS, "ValidateSearch with valid source and destination passed successfully");
		logger.info("ValidateSearch with valid source and destination passed successfully");
	}

	@Test()
	public void ValidSourceAndInvalidDestination() throws InterruptedException {
		logger.info("Validating Search with valid source and invalid destination");
		test=extent.createTest("Validating Search with valid source and invalid destination");
		
		String actualAlert = lp.enterValidSourceAndInvalidDest();
		test.log(Status.PASS, "Calling the method from FlightSearchPage");
		logger.info("Calling the method from FlightSearchPage");
		
		String expectedAlert = "Enter valid destination city";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		Assert.assertEquals(actualAlert, expectedAlert);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("Comparing actual and expected value");
		test.log(Status.PASS, "ValidateSearch with valid source and invalid destination passed successfully");
		logger.info("ValidateSearch with valid source and invalid destination passed successfully");
	}

	@Test()

	public void InvalidSourceAndvalidDestination() throws InterruptedException {
		test=extent.createTest("Validating Search with invalid source and valid destination");
		logger.info("Validating Search with invalid source and valid destination");
		
		String actualAlert = lp.enterInvalidSourceAndvalidDest();
		test.log(Status.PASS, "Calling the method from FlightSearchPage");
		logger.info("Calling the method from FlightSearchPage");
		
		String expectedAlert = "Enter valid origin city";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		Assert.assertEquals(actualAlert, expectedAlert);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("Comparing actual and expected value");
		test.log(Status.PASS, "ValidateSearch with invalid source and valid destination passed successfully");
		logger.info("ValidateSearch with invalid source and valid destination passed successfully");
	}
	
	@Test()

	public void InvalidSourceAndInvalidDestination() throws InterruptedException {
		test=extent.createTest("Validating Search with invalid source and invalid destination");
		logger.info("Validating Search with invalid source and invalid destination");

		String actualAlert = lp.enterInvalidSourceAndInvalidDest();
		test.log(Status.PASS, "Calling the method from FlightSearchPage");
		logger.info("Calling the method from FlightSearchPage");
		
		String expectedAlert = "Enter valid origin city";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		
		Assert.assertEquals(actualAlert, expectedAlert);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("Comparing actual and expected value");
		test.log(Status.PASS, "ValidateSearch with invalid source and invalid destination passed successfully");
		logger.info("ValidateSearch with invalid source and invalid destination passed successfully");

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
