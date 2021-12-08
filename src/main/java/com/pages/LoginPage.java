package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class LoginPage extends TestBase{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "spnMyAcc" ) WebElement myAccount;
	@FindBy(id = "shwlogn" ) WebElement login;
	@FindBy(id = "txtEmail" ) WebElement loginID;
	@FindBy(id = "shwotp" ) WebElement Continue;
	@FindBy(id = "shwlgnbx" ) WebElement loginWithPassword;
	@FindBy(id = "txtEmail2" ) WebElement password1;
	@FindBy(xpath = "//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input" ) WebElement loginButton;
    @FindBy(id = "ValidPass") WebElement actualText;
		
	public boolean validateLogin(String username,String password) throws InterruptedException {
		
		myAccount.click();
		login.click();
		loginID.sendKeys(username);   
		Continue.click();
		loginWithPassword.click();
		password1.sendKeys(password);  
		loginButton.click();
		Thread.sleep(3000);
		boolean actual= driver.findElement(By.id("welcome-det-User")).isDisplayed();
	    return actual;
	
		}
	
	
	public String validateLoginInvalidNo(String invalidusername) throws InterruptedException {
		
		myAccount.click();
		login.click();
		loginID.sendKeys(invalidusername);  
		Continue.click();
		String value=driver.findElement(By.id("RegValidPhone")).getText();
		return value;
				
		}
	
	
	public String validateLoginInvalidPass(String username,String invalidpass) throws InterruptedException {
		myAccount.click();
		login.click();
		loginID.sendKeys(username);
		Continue.click();
		loginWithPassword.click();
		password1.sendKeys(invalidpass); 
		loginButton.click();
		Thread.sleep(3000);
		String value=driver.findElement(By.id("ValidPass")).getText();
		return value;
				
		}

	
}









	


