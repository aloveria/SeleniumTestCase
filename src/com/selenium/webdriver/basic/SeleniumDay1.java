package com.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDay1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void invokeBrowser(){
	
		try {
			System.setProperty("webdriver.chrome.driver", "webDriver\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.get("http://localhost:9090/ProjectManagement");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void findElement(){
		try {
			
			driver.findElement(By.id("username")).sendKeys("businessuser");
			driver.findElement(By.id("password")).sendKeys("businessuser");
			Thread.sleep(3000);
			driver.findElement(By.id("loginBtn")).click();
		
			driver.findElement(By.id("header-menu")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("logout")).click();
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
