package com.productus.test;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OnlineShopping {

	
	static WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver","D://driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = true,priority = 1,groups = "SignTest",description = "Welcome to onlineshopping ")
	public void signin() throws InterruptedException {
		
	driver.findElement(By.xpath("//a[@class='login']")).click();
	
	System.out.println("This is inside signin method==="+Thread.currentThread().getId());
	}
	
	@Test(priority = 2,groups = "CreateAccountTest",description = "Please Signin for shopping")
//	@Parameters({"email"})
	public void createaccount() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("Title of shopping website===" + title);
		Thread.sleep(7000);
	     driver.findElement(By.xpath("//input[contains(@id,'email_create')]")).sendKeys("apples777@gmail.com");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click(); 
	     Thread.sleep(4000);
	     System.out.println("This is inside createaccount method===" +Thread.currentThread().getId());
	}
	
	@Test(priority = 3,groups = "SubmitTest",description = "Shopping List")
	//@Parameters({"customername"})
	public void mandatorydetails() throws InterruptedException {
		
	driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("customername");
		//System.out.println("This is inside mandatorydetails method==="+Thread.currentThread().getId());
			}
	@AfterClass
	public void teardown() {
		//driver.close();
	}
}