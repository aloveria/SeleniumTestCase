package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAssertion {

	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Arvic\\Documents\\DEVOPS\\selenium\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get("https://www.gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getTitle() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Gmail");
		System.out.println("Arvic Loveria");
	}
	
	/*@AfterTest
	public void closeBrowser(){
		driver.quit();
	}*/
}
