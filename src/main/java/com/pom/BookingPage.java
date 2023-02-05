package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	
	public WebDriver bookingdriver;
	
	public BookingPage(WebDriver driver) {
		
		this.bookingdriver = driver;
		PageFactory.initElements(bookingdriver, this);
	}
	
	@FindBy(xpath = "//label[@id='first_name_span']//preceding-sibling::input[@id='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//label[@id='last_name_span']//preceding-sibling::input[@id='last_name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//label[@id='address_span']//preceding-sibling::textarea[@id='address']")
	private WebElement address;
	
	@FindBy(xpath = "//label[@id='cc_num_tip']//preceding-sibling::input[@id='cc_num']")
	private WebElement creditCardNum;
	
	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement cardType;
	
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement expiryMonth;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement expiryYear;
	
	@FindBy(xpath = "//label[@id='cc_cvv_span']//preceding-sibling::input[@id='cc_cvv']")
	private WebElement cvv;
	
	@FindBy(xpath = "//input[@id='cancel']//preceding-sibling::input[@id='book_now']")
	private WebElement bookNowButton;
	
	@FindBy(xpath = "//input[@id='search_hotel']")
	private WebElement searchHotel;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCardNum() {
		return creditCardNum;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNowButton() {
		return bookNowButton;
	}
	
	public WebElement getSearchHotel() {
		return searchHotel;
	}
	
}
