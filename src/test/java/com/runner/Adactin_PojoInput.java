package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Base.HotelUtilities;
import com.Base.WebPageUtilities;

public class Adactin_PojoInput extends WebPageUtilities {

	public static WebDriver driver = launchBrowser("chrome");
	 static HotelUtilities hotelUtils = new HotelUtilities(driver); 
	
	public static void main(String[] args) throws IOException {
		
		launchUrl("https://adactinhotelapp.com");

		hotelUtils.login();
		hotelUtils.navigateTo("search");
		hotelUtils.search("London","Hotel Creek","Standard","3","20/02/2023","25/02/2023","2","2");
		hotelUtils.book();
		hotelUtils.navigateTo("logout");
		
		quit();
	}

}
