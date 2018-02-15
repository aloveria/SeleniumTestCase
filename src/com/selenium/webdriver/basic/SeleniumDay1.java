package com.selenium.webdriver.basic;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
		
		Map<String, String> map = getParameter();
		
		try {
			System.setProperty("webdriver.chrome.driver", "webDriver\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.get(map.get("appUrl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void getPageTitle(){
		assertTrue(driver.getTitle().contains("Project Management"));
		System.out.println("Page Title: " + driver.getTitle());
	}
	
	public Map<String, String> getParameter(){
		
		Map<String, String> map = readParameter();
		return map;
	}
	
	public Map<String, String> readParameter(){
		
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			String fileName = "testCase.properties";
			input = SeleniumDay1.class.getClassLoader().getResourceAsStream(fileName);
			
			if(input == null) {
				System.out.println("Sorry, unable to find " + fileName);
			}
			
			prop.load(input);
			map.put("appUrl", prop.getProperty("appUrl"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return map;
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
