package com.genericlib.demoblazeweb;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.objectrepo.demoblazeweb.HomePage;

public class Base {

	public static WebDriver driver; 
	public FileLib fl = new FileLib();
	String propPath = "C:\\Users\\Practice\\Java\\Eclipse_Workspace\\DemoblazeWeb\\Test Data\\testdata.properties";
	public HomePage hp;
	public WebDriverWait wait;
	public CommonUtils cu = new CommonUtils();
	
	public static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Extent.html");
	public static ExtentTest test;
	
	@BeforeTest
	public void configBT() {
		extent.attachReporter(spark);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fl.getDataFromProperties(propPath, "url"));
	}
	
	@BeforeMethod
	public void configBM() {
		hp=PageFactory.initElements(driver, HomePage.class);
		hp.getLoginLinktext().click();
		hp.getUserNameTextField().sendKeys(fl.getDataFromProperties(propPath, "username"));
		hp.getPasswordTextField().sendKeys(fl.getDataFromProperties(propPath, "password"));
		hp.getLoginButton().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String un=hp.getNameofUserText().getText();
		System.out.println(un);
		Assert.assertTrue(un.contains(fl.getDataFromProperties(propPath, "username")));	
	}
	
	@AfterMethod
	public void configAM() {
		hp.getLogoutLinktext().click();
		try {
			hp.getLoginLinktext();
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void configAT() {
		driver.quit();
	}
}
