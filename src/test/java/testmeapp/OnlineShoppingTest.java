package testmeapp;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import testmeapp.Drivers;

public class OnlineShoppingTest {
	WebDriver driver;
	Select s;
	WebDriverWait wait;
	Actions act;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

  @BeforeTest
  public void beforeTest() {
	  driver=Drivers.getDriver("Chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
  }
 @Test(priority=1)
 public void testRegistration() {
	 
	  Assert.assertEquals(driver.getTitle(),"Home");
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
	  driver.findElement(By.name("firstName")).sendKeys("VidhyaAnbu");
	//  WebDriverWait wait1=new WebDriverWait(driver,20);
	//  boolean flag1=wait1.until(ExpectedConditions.textToBe(By.id("err"), "Name Already Exists"));
	// System.out.println(flag1);
	//  Assert.assertFalse(flag1);
	 
	  driver.findElement(By.name("lastName")).sendKeys("Anbazhagan");
	  driver.findElement(By.name("password")).sendKeys("vidhya98");
	  driver.findElement(By.name("confirmPassword")).sendKeys("vidhya98");
	  WebElement radio1= driver.findElement(By.xpath("//input[@type='radio' and @value='Female']"));
	  radio1.click();
	 // 
	  driver.findElement(By.name("emailAddress")).sendKeys("vidhya98@gmail.com");
	  driver.findElement(By.name("mobileNumber")).sendKeys("7708884554");
	  
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img ")).click();
	  s=new Select (driver.findElement(By.xpath("/html/body/div/div/div/select[1]")));
	  s.selectByVisibleText("Mar");
	  s=new Select (driver.findElement(By.xpath("/html/body/div/div/div/select[2]")));
	   s.selectByVisibleText("1998");
	   driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[4]/a")).click();
	   
	   s=new Select (driver.findElement(By.name("securityQuestion")));
	   s.selectByValue("411011");
	   driver.findElement(By.name("answer")).sendKeys("Black");
	   WebElement e=driver.findElement(By.name("userName"));
		  String t=e.getAttribute("value");
		  if(t.isEmpty()) {
			  driver.findElement(By.name("userName")).sendKeys("Vidhya1998");
			  
		  }
	   driver.findElement(By.name("Submit")).click();
	   Assert.assertEquals(driver.getTitle(), "Login");
	  // logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	   
	
	  
	  
	  
  } 
  @Test(priority=2)
  public void testLogin() {
	  
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("password123");
		driver.findElement(By.name("Login")).click();
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		System.out.println("Found Signout");
		Assert.assertEquals(driver.getTitle(),"Home");
	

	  
  }
  @Test(priority=3)
  public void testCart() {
	  //act = new Actions(driver);
	  logger=extent.createTest("TestCart");
	 driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span")).click();
	 driver.findElement(By.linkText("Electronics")).click();
	 wait=new WebDriverWait(driver,60);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Head Phone")));
	 driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/ul/li[1]/a/span")).click();
	 Assert.assertEquals(driver.getTitle(),"Search");
	 driver.findElement(By.linkText("Add to cart")).click();
	 Assert.assertEquals(driver.getTitle(),"Search");
	 WebDriverWait wait=new WebDriverWait(driver,30);
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")));
	 driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
	 Assert.assertEquals(driver.getTitle(),"View Cart");
	 driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a ")).click();
	Assert.assertEquals(driver.getTitle(), "Cart Checkout");
	 driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input ")).click();
	  wait=new WebDriverWait(driver,30);
	 //wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("//*[@id=\"horizontalTab\"]/div[1]/h2")));
	  Assert.assertEquals(driver.getTitle(),"Redirecting to Payment Gateway");
	
	 
	  
	 
  }
  @Test(priority=4)
  public void testPayment() {
	 	
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 // Assert.assertEquals(driver.getTitle()," Payment Gateway");
		 // driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/label/i")).click(); //bank //*[@id="swit"]/div[1]/div/label/text()
		//  b.click();
	   //	  act.moveToElement(driver.findElement(By.xpath("//*[@id=\"btn\"]"))).click().build().perform();
	     WebElement b= driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label"));
	     b.click();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     WebElement d=  driver.findElement(By.xpath("//*[@id=\"btn\"]"));
	     d.click();
         //driver.findElement(By.partialLinkText("Continue")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
	      Assert.assertEquals(driver.getTitle(),"Payment Gateway");
	      logger.log(Status.INFO, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		  driver.findElement(By.name("username")).sendKeys("123456");
		  driver.findElement(By.name("password")).sendKeys("Pass@456");
		  driver.findElement(By.xpath("//input[@type='submit']")).click();  
		  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();  
		  Assert.assertEquals(driver.getTitle(),"Order Details");
		  logger.log(Status.INFO, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		  driver.findElement(By.linkText("Home")).click();
		  
		
		  
		  
	  
  }
 

  @AfterTest
  public void afterTest() {
	//  extent.close();
	  driver.close();
  }

}
