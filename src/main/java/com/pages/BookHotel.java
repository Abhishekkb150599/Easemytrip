package com.pages;

import com.base.TestBase;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class BookHotel extends TestBase {
	
	

	
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"myTopnav\"]/div[1]/ul/li[2]/a") WebElement Hotel;
	@FindBy(xpath="/html/body/div[2]/div/div[4]/div/form/div") WebElement SearchBox;
	@FindBy(xpath="//input[@value=\"Search\"]") WebElement Search;
	@FindBy(id = "txtCity") WebElement City;
	@FindBy(xpath="//*[@id=\"searcbar\"]/div/div[3]/button") WebElement Search2;
	@FindBy(xpath="//*[@id=\"hotelListDiv\"]/div[6]/div[2]/div/div/a/div[5]") WebElement ViewRoom;//  //*[@id="hotelListDiv"]/div[1]/div[2]/div/div/a/div[5]
	@FindBy(xpath="//*[@id=\"roomdetails\"]/div[2]/div[4]/div[2]/div/div[2]/div[2]/div[2]/a") WebElement Booknow;////*[@id="divDesc"]/div[3]/div[2]/div[2]/div[6]/a[2]    //*[@id="divDesc"]/div[3]/div[2]/div[2]/div[6]/a[2]

	
	@FindBy(id="txtFirstName1") WebElement Firstname ;
	@FindBy(id="txtLastName1") WebElement Lastname ;
	@FindBy(id="txtEmailId") WebElement Email;
	@FindBy(id="txtCPhone") WebElement Phoneno;
	@FindBy(xpath="//*[@id=\"btnTravellerContinue\"]/div[1]") WebElement payment;
	
	
	
	
	public  boolean ValidateHotelBook() throws InterruptedException {
		
		Hotel.click();
		SearchBox.click();
		City.sendKeys("ITC Maratha");
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(5000);
       	ViewRoom.click();
		Set<String> handles =  driver.getWindowHandles();
		System.out.println(handles);// in handles of all the open windows is stored
		
		Iterator<String> itr = handles.iterator(); //iterator is used to iterate the handles string and get the childwindow id.

		itr.next();

		String childWindow = itr.next();
		System.out.println("Child Window id is "+ childWindow);
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		Booknow.click();
		String Firstname1= prop.getProperty("Fname");
		Firstname.sendKeys(Firstname1);
		String Lastname1= prop.getProperty("Lname");
		Lastname.sendKeys(Lastname1);
		
	
		String Emailid= prop.getProperty("email");
		Email.sendKeys(Emailid);
		String Phoneno1= prop.getProperty("Phno1");
		Phoneno.sendKeys(Phoneno1);
		Thread.sleep(3000);
		
		
		
		payment.click();
		Thread.sleep(3000);
		boolean a=driver.findElement(By.id("CC")).isDisplayed();
		return a;
		
	}
	
	public String InvalidHotelBook() throws InterruptedException {
		
		Hotel.click();
		SearchBox.click();
		City.sendKeys("ITC Maratha");
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(5000);
       	ViewRoom.click();
		Set<String> handles =  driver.getWindowHandles();
		System.out.println(handles);// in handles of all the open windows is stored
		
		Iterator<String> itr = handles.iterator(); //iterator is used to iterate the handles string and get the childwindow id.

		itr.next();

		String childWindow = itr.next();
		System.out.println("Child Window id is "+ childWindow);
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		Booknow.click();
		String Firstname3= prop.getProperty("Fname2");
		Firstname.sendKeys(Firstname3);
		String Lastname3= prop.getProperty("Lname2");
		Lastname.sendKeys(Lastname3);
		String Emailid3= prop.getProperty("email2");
		Email.sendKeys(Emailid3);
		String Phoneno3= prop.getProperty("Phno2");
		Phoneno.sendKeys(Phoneno3);
		Thread.sleep(3000);
		payment.click();
		Thread.sleep(3000);
		String Text= driver.switchTo().alert().getText();
		return Text;
		
		
		
	}


	

}
