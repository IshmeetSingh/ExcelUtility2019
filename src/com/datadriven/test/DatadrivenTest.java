package com.datadriven.test;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.excel.utility.Xls_Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatadrivenTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\iduggal\\Downloads\\Chrome v80\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?acntType=personal");
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\iduggal\\eclipse-workspace\\ExcelUtility\\src\\com\\testData\\EbayTestData.xlsx");
		
		String firstName = reader.getCellData("RegTestData", "FirstName", 2);
	System.out.println(firstName);
	
	String lastName = reader.getCellData("RegTestData", "LastName", 2);
	System.out.println(lastName);
	String email = reader.getCellData("RegTestData", "Email", 2);
	System.out.println(email);
	String password = reader.getCellData("RegTestData", "Password", 2);
	System.out.println(password);
	
	driver.findElement( By.xpath("//*[@name='firstname']")).sendKeys(firstName);
	driver.findElement( By.xpath("//*[@name='lastname']")).sendKeys(lastName);
	driver.findElement( By.xpath("//*[@name='email']")).sendKeys(email);
	driver.findElement( By.xpath("//*[@type='password']")).sendKeys(password);
	
	driver.findElement( By.xpath("//*[@type='submit']")).click();
	
	
	}

}
