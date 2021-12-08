

package com.testcase;

import static org.testng.Assert.assertEquals;

import org.apache.tools.ant.property.GetProperty;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;

import com.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	ExtentTest test;
	

	@BeforeMethod
	public  void setup1() {
		setup();
		lp = new LoginPage();
		
	
	}
	
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	
	@Test()
	public void validateLoginTest() throws InterruptedException {
		logger.info("Validating login with valid username and password");
		test=extent.createTest("Validating login with valid username and password");
		
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		test.log(Status.PASS, "reading properties file");
		logger.info("Reading username and password from properties file");
		
		boolean a=lp.validateLogin(username, password);
		test.log(Status.PASS, "Calling the method from LoginPage");
		test.log(Status.PASS, "User name entered successfully");
		test.log(Status.PASS, "Password entered successfully");
		
		logger.info("Calling the method from LoginPage");
		
		Assert.assertTrue(a);
		test.log(Status.PASS, "Comparing if the returned value is true");
		logger.info("Comparing if the returned value is true");
		test.log(Status.PASS, "ValidateLogin with valid username and password passed successfully");
		logger.info("ValidateLogin with valid username and password passed successfully");
		
	}
	
	
	@Test()
	public void validateLoginInvalidNoTest() throws InterruptedException {
		logger.info("Validating invalid username testcase");
		test=extent.createTest("Validating Login with invalid username");
		
		String invalidusername=prop.getProperty("invalidusername");
		test.log(Status.PASS, "reading properties file");
		logger.info("reading properties file");
		
		String expected="* Enter a valid Phone Number";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		String actual=lp.validateLoginInvalidNo(invalidusername);
		test.log(Status.PASS, "Calling the method from LoginPage");
		test.log(Status.PASS, "Invalid User name entered successfully");
		
		logger.info("Calling the method from LoginPage");
		
		Assert.assertEquals(expected, actual);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("comparing actual and expected value");
		
		System.out.println(actual);
		test.log(Status.PASS, "Validate LoginTest with Invalidusername passed successfully");
		logger.info("Validate LoginTest with Invalidusername passed successfully");
	}
	
	
	@Test()
	public void validateLoginInvalidpassTest() throws InterruptedException {
		logger.info("Validating login with valid username and invalid password");
		test = extent.createTest("Validating Login with Invalid password");
		
		String username=prop.getProperty("username");
		String invalidpass=prop.getProperty("invalidpass");
		test.log(Status.PASS, "reading properties file");
		logger.info("reading properties file");
		
		String expected="* Enter valid Password";
		test.log(Status.PASS, "Entering the expected value");
		logger.info("Entering the expected value");
		
		String actual=lp.validateLoginInvalidPass(username, invalidpass);
		test.log(Status.PASS, "Calling the method from LoginPage");
		test.log(Status.PASS, "User name entered successfully");
		test.log(Status.PASS, "Invalid Password entered successfully");
		
		logger.info("Calling the method from LoginPage");
		
		Assert.assertEquals(expected, actual);
		test.log(Status.PASS, "Comparing actual and expected value");
		logger.info("comparing actual and expected value");
		
		System.out.println(actual);
		test.log(Status.PASS, "Validate Login with Invalid password passed successfully ");
		logger.info("Validate Login with Invalid password passed successfully");
	}
	
	@AfterTest
	public void GenerateReport() {
		CloseReportSetup();
	}
	
	
	
	@AfterMethod
	public void closeSetup(){
		closesetup();
		
	}
}
