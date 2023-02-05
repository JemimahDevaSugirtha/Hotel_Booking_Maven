package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.HotelUtilities;
import com.Base.WebPageUtilities;

public class Adactin_TestNG_Parallel extends WebPageUtilities {
	public static WebDriver driver; //= launchBrowser("chrome");
	static HotelUtilities hotelUtils; //= new HotelUtilities(driver);
	
	@Parameters("browserName")
	@BeforeMethod
	private void login(String browser) throws IOException {
		driver = launchBrowser(browser);
		hotelUtils = new HotelUtilities(driver);
		launchUrl("https://adactinhotelapp.com");
		hotelUtils.login();
	}
	
	@AfterMethod
	private void logout() throws IOException {
		hotelUtils.navigateTo("logout");
	}
	
	@BeforeClass
	private void sesson() {
		System.out.println("Session Started");
	}
	@AfterClass
	private void quitBrowser() {
		quit();
	}
	
	
	@Test (groups = "parallel", timeOut = 40000)
	public void paris() throws IOException {
		
		hotelUtils.navigateTo("search");
		hotelUtils.search("Paris","Hotel Creek","Standard","3","22/02/2023","24/02/2023","2","1");
		hotelUtils.book();
		
	}
	
	
	@Test(groups = "parallel")
	public void paris1() throws IOException {

		hotelUtils.navigateTo("search");
		hotelUtils.search("Paris","Hotel Sunshine","Standard","4","21/02/2023","24/02/2023","2","2");
		hotelUtils.book();

	}
	
}
