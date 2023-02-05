package com.Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pojo.Credentials;
import com.pom.BookingPage;
import com.pom.LoginPage;
import com.pom.NavigateToPage;
import com.pom.SearchPage;

public class HotelUtilities extends WebPageUtilities {

	
	public static WebDriver driver;
	
	
	public HotelUtilities(WebDriver mainDriver) {
		HotelUtilities.driver = mainDriver;
	}
	
	public void login() throws IOException {		
		LoginPage lgn = new LoginPage(driver);
		Credentials cred = new Credentials();
		
		screenshot("loginpage");
		enterText(lgn.getUserNameBox(), cred.getUsername());
		enterText(lgn.getPasswordBox(), cred.getPassword());
		screenshot("loginpage");
		click(lgn.getLoginButton());
			
	}
	
	public void login(String userName, String password) throws IOException {
		
		LoginPage lgn = new LoginPage(driver);

		screenshot("loginpage");
		enterText(lgn.getUserNameBox(), userName);
		enterText(lgn.getPasswordBox(), password);
		screenshot("loginpage");
		click(lgn.getLoginButton());
	}
	
	public void search(String Location, String hotelName, String roomType, String no_Of_Rooms,String checkInDate, String checkOutDate,
			String adultsPerRoom, String childsPerRoom) throws IOException {
		
		SearchPage srch = new SearchPage(driver);
		
		screenshot("Searchpage");
		selectByText(srch.getLocation(), Location);
		selectByText(srch.getHotels(), hotelName);
		selectByText(srch.getRoomType(), roomType);
		selectByValue(srch.getRooms(), no_Of_Rooms);
		clear(srch.getPickInDate());
		enterText(srch.getPickInDate(),checkInDate);
		clear(srch.getPickOutDate());
		enterText(srch.getPickOutDate(),checkOutDate);
		selectByValue(srch.getAdultPerRoom(), adultsPerRoom);
		selectByValue(srch.getChildPerRoom(), childsPerRoom);
		screenshot("Searchpage");
		click(srch.getSubmitButton());
		screenshot("Searchpage");
		click(srch.getRadioButton());
		screenshot("Searchpage");
		click(srch.getContiueButton());
	}
	
	public void book() throws IOException {
		
		BookingPage bkng = new BookingPage(driver);
		Credentials cred = new Credentials();
		
		enterText(bkng.getFirstName(),cred.getFirstName());
		screenshot("Bookingpage");
		scrollTo(bkng.getFirstName());
		enterText(bkng.getLastName(),cred.getLastName());
		enterText(bkng.getAddress(),cred.getAddress());
		enterText(bkng.getCreditCardNum(),cred.getCreditCardNo());
		selectByText(bkng.getCardType(), cred.getCardType());
		selectByText(bkng.getExpiryMonth(), cred.getExpiryMonth());
		selectByText(bkng.getExpiryYear(), cred.getExpiryYear());
		enterText(bkng.getCvv(),cred.getCvv());
		screenshot("Bookingpage");
		click(bkng.getBookNowButton());	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://adactinhotelapp.com/BookingConfirm.php")); //explicit wait
		screenshot("confirmpage");
		scrollTo(bkng.getSearchHotel());
		screenshot("confirmpage");
	}
	
	public void book(String firstName, String lastName, String address, String creditCardNum, String cardType, String expiryMonth, String expiryYear, String cvv ) throws IOException {
		
		BookingPage bkng = new BookingPage(driver);
		
		enterText(bkng.getFirstName(),firstName);
		screenshot("Bookpage");
		scrollTo(bkng.getFirstName());
		enterText(bkng.getLastName(),lastName);
		enterText(bkng.getAddress(),address);
		enterText(bkng.getCreditCardNum(),creditCardNum);
		selectByText(bkng.getCardType(), cardType);
		selectByText(bkng.getExpiryMonth(), expiryMonth);
		selectByText(bkng.getExpiryYear(), expiryYear);
		enterText(bkng.getCvv(),cvv);
		screenshot("Bookpage");
		click(bkng.getBookNowButton());	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://adactinhotelapp.com/BookingConfirm.php")); //explicit wait
		screenshot("confirmpage");
		scrollTo(bkng.getSearchHotel());
		screenshot("confirmpage");
	}
	
	public void navigateTo(String pageName) throws IOException {
		
		NavigateToPage nav = new NavigateToPage(driver);
		
		if (pageName.equalsIgnoreCase("search")) {
			scrollTo(nav.getSearchHotelButton());
			click(nav.getSearchHotelButton());
		} else if(pageName.equalsIgnoreCase("bookeditinerary")){
			scrollTo(nav.getBookedItineraryButton());
			click(nav.getBookedItineraryButton());
			screenshot("bookeditinerary");
		}else if(pageName.equalsIgnoreCase("logout")){
			scrollTo(nav.getLogoutButton());
			click(nav.getLogoutButton());
		}
	}
}
