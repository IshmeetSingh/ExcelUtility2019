package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class parameterizeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\iduggal\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?acntType=personal");
		Xls_Reader reader = new Xls_Reader("C:\\Users\\iduggal\\eclipse-workspace\\ExcelUtility\\src\\com\\testData\\EbayTestData.xlsx");
	int rowCount = reader.getRowCount("RegTestData");
	
	
	for ( int rowNum = 2; rowNum <= rowCount; rowNum++)

	{
		String firstName = reader.getCellData("RegTestData", "FirstName", rowNum);
		String lastName = reader.getCellData("RegTestData", "LastName", rowNum);
		String email = reader.getCellData("RegTestData", "Email", rowNum);
		String password = reader.getCellData("RegTestData", "Password", rowNum);
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		
		Thread.sleep(5000);
		
		
		driver.findElement( By.xpath("//*[@name='firstname']")).clear();
		driver.findElement( By.xpath("//*[@name='firstname']")).sendKeys(firstName);
		
		driver.findElement( By.xpath("//*[@name='lastname']")).clear();
		driver.findElement( By.xpath("//*[@name='lastname']")).sendKeys(lastName);
		
		driver.findElement( By.xpath("//*[@name='email']")).clear();
		driver.findElement( By.xpath("//*[@name='email']")).sendKeys(email);
		
		driver.findElement( By.xpath("//*[@type='password']")).clear();
		driver.findElement( By.xpath("//*[@type='password']")).sendKeys(password);
		
		driver.findElement( By.xpath("//*[@type='submit']")).click();
		
	}
	
	
	}

}
