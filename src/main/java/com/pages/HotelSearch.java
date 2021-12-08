package com.pages;

	import com.base.TestBase;

	import java.util.List;
	import org.openqa.selenium.*;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HotelSearch extends TestBase {
		public HotelSearch() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@id=\"myTopnav\"]/div[1]/ul/li[2]/a")
		WebElement Hotel;
		@FindBy(xpath = "//input[@value='Search']")
		WebElement Search;
		@FindBy(xpath ="//div[@class='htl_location']//span[@class='hp_city']")
		WebElement City;
		@FindBy(id ="txtCity")
		WebElement enterCity;
		@FindBy(xpath = "//span[@class='hp_city']")
		WebElement Search1;
		@FindBy(id = "txtCheckInDate")
		WebElement viewRoom;
		@FindBy(xpath = "//a [@ class='btnhtltype1 btnActive']")
		WebElement browseAllHotel;
		@FindBy(xpath = "//a[@class='modi-srec3']")
		WebElement modifySearch;

		public boolean validHotelSearching() throws InterruptedException {

			Hotel.click();
			Search.click();
			Thread.sleep(3000);
//			City.sendKeys()
//			Search1.click();
//			Checkin.click();
//			CheckinDate.click();
//			Checkout.click();
//			CheckoutDate.click();
			boolean display = browseAllHotel.isDisplayed();
			return display;

		}

		public String invalidHotelSearching() throws InterruptedException {
			Hotel.click();
			Thread.sleep(3000);
			City.click();
			Thread.sleep(3000);
			enterCity.sendKeys("uuuuuuuuu");
			Search.click();
			
			String alert= driver.switchTo().alert().getText();
			
			Thread.sleep(3000);
//			boolean display = modifySearch.isDisplayed();

			return alert;

		}

	}


