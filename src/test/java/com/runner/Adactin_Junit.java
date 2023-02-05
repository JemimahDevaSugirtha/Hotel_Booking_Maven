package com.runner;

import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import com.Base.HotelUtilities;
import com.Base.WebPageUtilities;

public class Adactin_Junit extends WebPageUtilities{
	
	public static WebDriver driver= launchBrowser("chrome");
	static HotelUtilities hotelUtils = new HotelUtilities(driver);
	
	@BeforeClass
	public static void browserLaunch() {	
		launchUrl("https://adactinhotelapp.com");
	}
	
	@Before
	public void login() throws IOException {
		launchUrl("https://adactinhotelapp.com");
		hotelUtils.login();
	}
	
	@Test
	public void london() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("London","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","2");
		hotelUtils.book();	
	}
	
	@Test
	public void sydney() throws IOException {
		hotelUtils.navigateTo("search");
		hotelUtils.search("Sydney","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","2");
		hotelUtils.book();	
	}
	
	@After
	public void logout() throws IOException {	
		hotelUtils.navigateTo("logout");	
	}
	
	@AfterClass
	public static void closeBrowser() {
		quit();
	}
}
