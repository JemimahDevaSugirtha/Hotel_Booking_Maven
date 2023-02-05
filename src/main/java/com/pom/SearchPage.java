package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver searchDriver;
	
	public SearchPage(WebDriver driver) {
		this.searchDriver = driver;
		PageFactory.initElements(searchDriver, this);
	}
	
	
	@FindBy(xpath = "//select[@id='location']")
	private WebElement location;
	
	@FindBy(xpath = "//select[@id='hotels']")
	private WebElement hotels;
	
	@FindBy(xpath = "//select[@id='room_type']")
	private WebElement roomType;
	
	@FindBy(xpath = "//select[@id='room_nos']")
	private WebElement rooms;
	
	@FindBy(xpath = "//input[@id='datepick_in']")
	private WebElement pickInDate;
	
	@FindBy(xpath = "//input[@id='datepick_out']")
	private WebElement pickOutDate;
	
	@FindBy(xpath = "//select[@id='adult_room']")
	private WebElement adultPerRoom;
	
	@FindBy(xpath = "//select[@id='child_room']")
	private WebElement childPerRoom;
	
	@FindBy(xpath = "//input[@id='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='total_radiobutton']//preceding-sibling::input[@id='radiobutton_0']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//input[@id='cancel']//preceding-sibling::input[@id='continue']")
	private WebElement contiueButton;


	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getPickInDate() {
		return pickInDate;
	}

	public WebElement getPickOutDate() {
		return pickOutDate;
	}

	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getChildPerRoom() {
		return childPerRoom;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getContiueButton() {
		return contiueButton;
	}
	
	
}
