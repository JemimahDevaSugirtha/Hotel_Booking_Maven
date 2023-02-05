package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Base.HotelUtilities;
import com.Base.WebPageUtilities;

public class Adactin_ExcelInput extends WebPageUtilities {

	public static WebDriver driver = launchBrowser("chrome");
	 static HotelUtilities hotelUtils = new HotelUtilities(driver); 
	
	public static void main(String[] args) throws IOException {
		
		launchUrl("https://adactinhotelapp.com");

		hotelUtils.login(from_Excel_Particular("INPUTDATA", "credentials", 1, 0),
				from_Excel_Particular("INPUTDATA", "credentials", 1, 1));
		
		hotelUtils.navigateTo("search");
		
		hotelUtils.search(from_Excel_Particular("INPUTDATA", "search_criteria", 1, 0),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 1),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 2),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 3),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 4),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 5),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 6),
				from_Excel_Particular("INPUTDATA", "search_criteria", 1, 7));
		
		hotelUtils.book(from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 0),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 1),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 2),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 3),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 4),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 5),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 6),
				from_Excel_Particular("INPUTDATA", "Bank_Details", 1, 7));
		
		hotelUtils.navigateTo("bookeditinerary");
		
		hotelUtils.navigateTo("logout");
		
		quit();
	}

}
