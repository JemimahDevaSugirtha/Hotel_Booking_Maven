package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver logindriver;
	
	public LoginPage(WebDriver driver) {
		this.logindriver = driver;
		PageFactory.initElements(logindriver, this);
	}
	
	@FindBy(xpath = "//a[text()='Click here to login again']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//span[@id='username_span']//preceding-sibling::input[@id='username']")
	private WebElement userNameBox;
	
	@FindBy(xpath = "//span[@id='password_span']//preceding-sibling::input[@id='password']")
	private WebElement passwordBox;
	
	@FindBy(xpath = "//table[@class='login']/tbody/tr[6]/td[2]/input")
	private WebElement loginButton;

	
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public WebElement getUserNameBox() {
		return userNameBox;
	}

	public WebElement getPasswordBox() {
		return passwordBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
}
