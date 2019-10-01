package testmeapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {
	static WebDriver driver;
 public static WebDriver getDriver(String browser) {
	 if(browser.equals("Firefox")) {
		 System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
		 driver =new FirefoxDriver();
	 }
	 else if( browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();}
		else
			System.out.println("Invalid browser !!");
	return driver;
		 
			 
	 
 }
}
