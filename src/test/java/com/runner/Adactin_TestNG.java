package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Base.HotelUtilities;
import com.Base.WebPageUtilities;

public class Adactin_TestNG extends WebPageUtilities {
	public static WebDriver driver; //= launchBrowser("chrome");
	static HotelUtilities hotelUtils; //= new HotelUtilities(driver);
	
	@BeforeSuite (groups = "Test1")
	private void sessionStart() {
		System.out.println("Session Started");
	}
	
	@AfterSuite (groups = "Test1")
	private void sessionEnd() {
		System.out.println("Session End");
	}
	
	@BeforeTest (groups = "Test1")
	public void browserLaunch() {
		driver = launchBrowser("chrome");
		hotelUtils = new HotelUtilities(driver);
		launchUrl("https://adactinhotelapp.com");
	}
	
	@AfterTest (groups = "Test1")
	public void closeBrowser() {
		quit();
	}
	
	@BeforeClass (groups = "Test1")
	private void max() {
		maximize();
	}
	
	@AfterClass (groups = "Test1")
	private void min() {
		minimize();
	}
	
	@BeforeMethod (groups = "Test1")
	public void login() throws IOException {
		launchUrl("https://adactinhotelapp.com");
		hotelUtils.login();
	}
	
	@AfterMethod (groups = "Test1")
	public void logout() throws IOException {	
		hotelUtils.navigateTo("logout");	
	}
	
	@Test(priority = 1, invocationCount = 2,invocationTimeOut = 35000, dependsOnMethods = "sydney",alwaysRun = true)
	public void london() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("London","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();	
	}
	
	@Test(priority = -1, expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
	public void sydney() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("sydney","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	@Test(priority = 5, description = "melbourne booking", groups = "Test1") 
	public void melbourne() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("Melbourne","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	@Test(priority = 3, dependsOnMethods = "melbourne",timeOut = 15000, groups = "Test1")
	public void newYork() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("New York","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	//ignore testcase type-1
	@Ignore
	@Test(priority = 2, groups = "Test1")
	public void brisbane() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("Brisbane","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	//ignore testcase type-2
	@Test(priority = 6,enabled = false)
	public void adelaide() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("Adelaide","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	//ignore testcase type-3 via xml
	@Test(priority = 7)
	public void los_Angeles() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("Los Angeles","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
	}
	
	@Test(groups = "Parallel")
	public void paris() throws IOException {
		WebDriver driver1 = launchBrowser("chrome");
		hotelUtils = new HotelUtilities(driver1);
		launchUrl("https://adactinhotelapp.com");
		hotelUtils.login();
		hotelUtils.navigateTo("search");
		hotelUtils.search("Paris","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","1");
		hotelUtils.book();
		hotelUtils.navigateTo("logout");
		quit();
	}
	
	
	@Test(groups = "Parallel", dataProvider = "provide")
	public void paris1(String username, String password) throws IOException {
		WebDriver driver2 = launchBrowser("edge");
		hotelUtils = new HotelUtilities(driver2);
		launchUrl("https://adactinhotelapp.com");
		hotelUtils.login(username,password);
		hotelUtils.navigateTo("search");
		hotelUtils.search("Paris","Hotel Sunshine","Standard","4","21/02/2023","24/02/2023","2","2");
		hotelUtils.book();
		hotelUtils.navigateTo("logout");
		quit();
	}
	
	@DataProvider
	private String[][] provide() {
		String[][] a = {{"JemimahDS","Jds@97"}};
		return a;
		
	}
}
