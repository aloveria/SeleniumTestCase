package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotation {
  
	@Test
	public void f1() {
		System.out.println("Inside f1");
	}
	
	@Test
	public void f2(){
		System.out.println("Inside f2");
	}
	
	@BeforeTest
	public void beforeAnyTests(){
		System.out.println("Inside before any test");
	}
	
	@AfterTest
	public void afterAllTheTests(){
		System.out.println("Inside after any test");
	}
	
	@BeforeMethod
	public void beforeEveryMethod(){
		System.out.println("Inside before every method");
	}
	
	@AfterMethod
	public void afterEveryMethod(){
		System.out.println("Inside after every method");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Inside before class");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("Inside after class");
	}
	
}
