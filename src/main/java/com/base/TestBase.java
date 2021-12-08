package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
public static WebDriver driver;
public static Properties prop;
public static ExtentReports extent;
public static Logger logger;

public static ExtentSparkReporter reporter;

public TestBase() {
	prop = new Properties();
try {
	FileInputStream fis=new FileInputStream("./src/main/java/com/config/config.properties");
	prop.load(fis);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	public static void setup() {
		logger=Logger.getLogger(TestBase.class);
		
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		if(browser.equals("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			logger.info("Identified and open the browser as chrome");
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Identified and open the browser as firefox");
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			logger.info("Identified and open the browser as IE");
		}
		
		driver.get(url);
		logger.info("Application launched successful");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
		
	}
	
	public void ExtentReportSetup() {
		String reportpath = System.getProperty("user.dir") + "/extentreport/index1.html";
		reporter = new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test;
	}

	public void CloseReportSetup() {
		extent.flush();
	}
	
	
	public static void closesetup(){
		driver.quit();
	}

}
