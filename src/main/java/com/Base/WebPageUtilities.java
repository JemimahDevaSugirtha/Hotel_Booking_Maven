package com.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class WebPageUtilities {
	public static WebDriver driver;
	private static Actions a;
	private static Robot r;
	private static int count = 0;
	
	public static WebDriver launchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		return driver;		
	}
	
	public static void launchUrl(String url) {	
		driver.get(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();;
	}
	
	public static void minimize() {
		driver.manage().window().minimize();;
	}
	
	public static WebElement element(String elementPath) {
		WebElement foundElement = driver.findElement(By.xpath(elementPath));
		return foundElement;	
	}
	
	public static List<WebElement> elements(String elementPath) {
		List<WebElement> foundElements = driver.findElements(By.xpath(elementPath));
		return foundElements;	
	}
	
	public static void enterText(WebElement elementPath,String text) { //enter text in text box
		elementPath.sendKeys(text);
	}
	
	public static void selectByValue(WebElement elementPath,String value) { //select by value from dropdown box
		
		elementPath.click();
		Select s = new Select(elementPath);
		s.selectByValue(value);
	}
	
	public static void selectByText(WebElement elementPath,String visibleText) { //select by visibletext from dropdown box
		
		elementPath.click();
		Select s = new Select(elementPath);
		s.selectByVisibleText(visibleText);
	}
	
	public static void selectByIndex(WebElement elementPath,int index) { //select by index from dropdown box
		
		elementPath.click();
		Select s = new Select(elementPath);
		s.selectByIndex(index);
	}
	
	public static void clear(WebElement elementPath) { //to clear the text box
		elementPath.clear();
	}
	
	public static void close() { //to close the window
		driver.close();
	}
	
	public static void quit() { //to quit the windows
		driver.quit();
	}
	
	public static void hover(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.moveToElement(elementPath).build().perform();
	}
	
	public static void click(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.click(elementPath).build().perform();
	}
	
	public static void hoverAndClick(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.moveToElement(elementPath).click().build().perform();
	}
	
	public static void hoverAndRightClick(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.moveToElement(elementPath).contextClick().build().perform();
	}
	
	public static void right_Click(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.contextClick(elementPath).build().perform();
	}
	
	public static void double_Click(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.doubleClick(elementPath).build().perform();
	}
	
	public static void clickAndHold(WebElement elementPath) { //mouse action
		a = new Actions(driver);		
		a.clickAndHold(elementPath).build().perform();
	}
	
	public static void releaseHold(WebElement elementPath) { //mouse action
		a = new Actions(driver);
		a.release(elementPath).build().perform();
	}
	
	public static void scrollTo(WebElement elementPath) {  //javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", elementPath);
	}
	
	public static void down() throws AWTException {  //keyboard action
		r = new Robot();	
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void enter() throws AWTException {  //keyboard action
		r = new Robot();	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void single_Window_Switch() { //To switch between 2 window 
		String parent = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); //explicit wait
		Set<String> idset = driver.getWindowHandles();
		for (String id : idset) {
			if (id.equals(parent)) {
				continue;
			} else {
				driver.switchTo().window(id);
			}
		}
	}
	
	public static void multiple_Window_Switch(String url) { //To switch between multiple window
		Set<String> idset = driver.getWindowHandles();
		for (String id : idset) {
			if (driver.switchTo().window(id).getCurrentUrl().equals(url)) {
				break;
			}
		}
	}
	
	public static void screenshot(String screenshotName) throws IOException {
		String path = "D:\\Jemi\\Selenium\\eclipse-workspace\\Hotel_Booking_Maven\\Screenshots\\"+screenshotName+count+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(path));
		++count;
		
		
	}
	
	public static String  from_Excel_Particular(String fileName, String sheetName, int row, int cell) throws IOException {
		
		String path = "D:\\Jemi\\Selenium\\eclipse-workspace\\Hotel_Booking_Maven\\input_file\\"+fileName+".xlsx";
		String val = null;
		File f = new File(path);	
		FileInputStream in = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheet(sheetName);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(cell);
		CellType ct = c.getCellType();
		
		if (ct.equals(CellType.STRING)) {
			val = c.getStringCellValue();
		} else if(ct.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int i = (int) d;
			val = String.valueOf(i);
		}
		return val;
	}
	
	public static void find_Broken_Links() throws MalformedURLException,IOException {
		List<WebElement> all_tags = driver.findElements(By.tagName("a"));
		
		for (WebElement tags : all_tags) {
			
			String link = tags.getAttribute("href");
			
			if(link.isEmpty() || link == null) {
				continue;
			}
			
			URL u = new URL(link);
			
			URLConnection openConnection = u.openConnection();
			HttpURLConnection http = (HttpURLConnection) openConnection;
			int responseCode = http.getResponseCode();
			String responseMessage = http.getResponseMessage();
			
			if (responseCode >= 400) {
				System.out.println("Broken link: "+link+"-->"+responseMessage+"-->"+responseCode);				
			}
		}
		quit();
	}
	
	public static void find_Broken_Image() throws MalformedURLException,IOException {
		List<WebElement> all_tags = driver.findElements(By.tagName("img"));
		
		for (WebElement tags : all_tags) {
			
			String link = tags.getAttribute("src");
			
			if(link.isEmpty() || link == null) {
				continue;
			}
			
			URL u = new URL(link);
			
			//URLConnection openConnection = u.openConnection();
			HttpURLConnection http = (HttpURLConnection) u.openConnection();

			
			if (http.getResponseCode() >= 400) {
				System.out.println("Broken image link: "+link+"-->"+http.getResponseMessage()+"-->"+http.getResponseCode());				
			}
		}
	}
}
