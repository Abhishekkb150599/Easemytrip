package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class FlightBooking extends TestBase {
		public FlightBooking() {
		PageFactory.initElements(driver, this);
	}


@FindBy(xpath="//*[@id=\"myTopnav\"]/div[1]/ul/li[1]/a")
WebElement Flight;
@FindBy(xpath="//*[@id=\"search\"]/input")
WebElement SearchBox;
@FindBy(xpath="//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]") 
WebElement Book;
@FindBy(xpath = "//*[@id=\"txtEmailId\"]")
WebElement Email1;
@FindBy(xpath="//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span") 
WebElement Check;
@FindBy(xpath="//*[@id=\"spnVerifyEmail\"]")
WebElement Continue;// 
@FindBy(xpath="//*[@id=\"txtCPhone\"]") 
WebElement Phno;
@FindBy(xpath="//*[@id=\"txtFNAdult0\"]")
WebElement FirstName;

@FindBy(xpath="//*[@id=\"txtLNAdult0\"]")
WebElement LastName;
@FindBy(xpath="//*[@id=\"spnTransaction\"]")
WebElement ContinueBooking;
@FindBy(className= "mk-pym")
WebElement PaymentButton;
@FindBy(xpath="//*[@id=\"FromSector_show\"]")
WebElement From;
@FindBy(xpath="//*[@id=\"Editbox13_show\"]")
WebElement To;

public boolean Bookingaflight() {
	Flight.click();

	SearchBox.click();
	Book.click();
	String Emailid= prop.getProperty("email");
	Email1.sendKeys(Emailid);
	Check.click();
	String Firstname1= prop.getProperty("Fname");
	FirstName.sendKeys(Firstname1);
	String Lastname1= prop.getProperty("Lname");
	LastName.sendKeys(Lastname1);
	String Phoneno1= prop.getProperty("Phno");
	Phno.sendKeys(Phoneno1);
	Continue.click();
	boolean a=driver.findElement(By.xpath("//*[@id=\"card\"]/div[9]")).isDisplayed();
	return a;
	
}

public void Bookingflight() {
	Flight.click();

	SearchBox.click();
	Book.click();
	String Emailid= prop.getProperty("email");
	Email1.sendKeys(Emailid);
	Check.click();
	String Firstname1= prop.getProperty("Fname2");
	FirstName.sendKeys(Firstname1);
	String Lastname1= prop.getProperty("Lname2");
	LastName.sendKeys(Lastname1);
	String Phoneno1= prop.getProperty("Phno2");
	Phno.sendKeys(Phoneno1);
	Continue.click();
	boolean a=driver.findElement(By.xpath("//*[@id=\"card\"]/div[9]")).isDisplayed();
}







}
