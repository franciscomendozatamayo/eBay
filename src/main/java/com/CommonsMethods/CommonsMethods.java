package com.CommonsMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonsMethods {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static String geckodriver = "drivers\\geckodriver.exe";
	
	
	public static WebDriver startBrowser(String browserName, String url) {
		
		switch(browserName) {
		
		case "firefox":
			
			FirefoxOptions optfirefox = new FirefoxOptions();
			optfirefox.addArguments("--incognito");
			System.setProperty("webdriver.gecko.driver", geckodriver);
			driver = new FirefoxDriver(optfirefox);
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			break;
		
		}//end switch
		
		
		wait = new WebDriverWait(driver, 40);
		
		
		return driver;
		
	}//end startBrowser
	
	
	public void sendKeysElement(WebElement element, String text) {
		
		try {
			
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(text);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}//end sendKeysElement
	
	public void clickElement(WebElement element) {
		
		try {
			
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//end clickElement
	
	public String getTextElement(final WebElement element) {


        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        String getTextElement = element.getText();


        return getTextElement;

    }// end methodGetTextElement

	
	public void screenshot(String downloadpath, String name) throws IOException {
		
		//Date date = new Date();
		//DateFormat formatoFecha = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File(downloadpath+name+".jpg"));
		
		
	}//end screenshot
	
	public Boolean clickElementList(List<WebElement> elements, String txt) {
		
		boolean status = false;
		
		System.out.println(elements.size());
		for(WebElement element : elements) {
			
			String value = element.getText();
			
			if(value.contains(txt)) {
				
				System.out.println(element.getText());
				clickElement(element);
				status = true;
				
			}
		}
		
		return status;
		
	}//end clickElementList
	
	public void manageWindowHandles(int Window) {
		
		
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(Window));

		
	}//end manageWindowHandles
	
	
	
	
	

}//end CommonsMethods
