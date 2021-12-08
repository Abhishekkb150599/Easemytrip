package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.base.TestBase;

public class FlightSearchingPage extends TestBase {

	public FlightSearchingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"myTopnav\"]/div[1]/ul/li[1]/a")
	WebElement flights;
	@FindBy(id = "FromSector_show")
	WebElement source1;
	@FindBy(id = "Editbox13_show")
	WebElement destination1;
	@FindBy(xpath ="//*[@id=\"search\"]/input")
	WebElement search;
	@FindBy(xpath = "//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]")
	WebElement Booknow;
	@FindBy(xpath = "//div[@class='box']/div[@class='days']/ul/li[text()='12']")
	WebElement Calender;
	@FindBy(id = "fst_5_03/12/2021")
	WebElement Date;

	public boolean enterValidSourceAndValidDest() throws InterruptedException {
		flights.click();
		source1.click();
		Thread.sleep(3000);
		source1.sendKeys("Delhi");
		Thread.sleep(3000);

		source1.sendKeys(Keys.ARROW_DOWN);

		source1.sendKeys(Keys.ENTER);
		destination1.click();
		destination1.sendKeys("Mumbai");
		Thread.sleep(3000);
		destination1.sendKeys(Keys.ARROW_DOWN);
        destination1.sendKeys(Keys.ENTER);
        Calender.click();
		search.click();
		
		Thread.sleep(3000);
		
		boolean condition=Booknow.isDisplayed();
		return condition;
	}

	public String enterValidSourceAndInvalidDest() throws InterruptedException {
		flights.click();
		source1.click();
		Thread.sleep(3000);
		source1.sendKeys("Delhi");
		Thread.sleep(3000);

		source1.sendKeys(Keys.ARROW_DOWN);

		source1.sendKeys(Keys.ENTER);
		destination1.click();
		destination1.sendKeys("ddd");
		search.click();
		Thread.sleep(3000);

		String actualAlert = driver.switchTo().alert().getText();
		return actualAlert;

	}

	public String enterInvalidSourceAndvalidDest() throws InterruptedException {
		flights.click();
		source1.click();

		source1.sendKeys("AAA");
		destination1.click();
		destination1.sendKeys("Delhi");
		Thread.sleep(3000);

		source1.sendKeys(Keys.ARROW_DOWN);

		source1.sendKeys(Keys.ENTER);
		search.click();
		Thread.sleep(3000);
		String actualAlert = driver.switchTo().alert().getText();
		return actualAlert;

	}
	
	public String enterInvalidSourceAndInvalidDest() throws InterruptedException {
		flights.click();
		source1.click();

		source1.sendKeys("AAA");
		destination1.click();
		destination1.sendKeys("ddd");
		search.click();
		Thread.sleep(3000);
		String actualAlert = driver.switchTo().alert().getText();
		return actualAlert;

	}

}
