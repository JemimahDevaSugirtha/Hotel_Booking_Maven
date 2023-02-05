package com.runner;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.Base.WebPageUtilities;

public class Broken_Links extends WebPageUtilities {
	public static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException,IOException {
		
		driver = launchBrowser("chrome");
		
		launchUrl("http://www.deadlinkcity.com/");
		//find_Broken_Links();
		find_Broken_Image();
		quit();
	}
}
