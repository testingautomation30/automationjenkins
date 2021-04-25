

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Eg {
	
	@Test(groups = {"demo"})
	public void testOne() {
		System.out.println("Test one Methos");	}
	
	
	@Test(groups = {"value"})
	public void testTwo() {
		System.out.println("Test Two Methos");	}
	
	
	@Test(groups = {"demo"})
	public void testThree() {
		System.out.println("Test Three Methos");	}
	
	@BeforeTest
	public void test1() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void test2() {
		System.out.println("after Test");
	}
	
	@BeforeSuite
	public void test3() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void test4() {
		System.out.println("after Suite");
	}
	
	@BeforeClass
	public void test5() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void test6() {
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void test7() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void test8() {
		System.out.println("after method");
	}


}
