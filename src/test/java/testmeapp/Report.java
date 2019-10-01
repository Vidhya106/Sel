package testmeapp;

import org.testng.annotations.Test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import Selenium.ReportsNew.UtilityClass;

public class Report {
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	Select s;
	WebDriverWait wait;
	Actions act;

	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Reports.html", true);
		extent.addSystemInfo("Host Name", "TestMe");
		extent.addSystemInfo("Environment", "Selenium Testing");
		extent.addSystemInfo("User Name", "V");
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Test(priority=1)
	public void testRegistration() {
		logger = extent.startTest("testRegistration");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		//BrforeTest
	  driver=Drivers.getDriver("Chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  //TestRegistration
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
			  System.out.println("Invalid");
			  driver.findElement(By.name("userName")).sendKeys("Vidhya98");
			  
		  }
	   driver.findElement(By.name("Submit")).click();
	   Assert.assertEquals(driver.getTitle(), "Login");}
	@Test(priority=2)
	public void testLogin() {
		logger = extent.startTest("testLogin");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	   
	   //Login
	   driver.findElement(By.name("userName")).sendKeys("Vidhya98");
		driver.findElement(By.name("password")).sendKeys("vidhya98");
		driver.findElement(By.name("Login")).click();
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		System.out.println("Found Signout");
		Assert.assertEquals(driver.getTitle(),"Home");}
	@Test(priority=3)
	public void passTest3() {
		logger = extent.startTest("passTest3");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		
		//TestCart
		 driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span")).click();
		 driver.findElement(By.linkText("Electronics")).click();
		 wait=new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Head Phone")));
		 driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/ul/li[2]/a")).click();
		 Assert.assertEquals(driver.getTitle(),"Search");
		 driver.findElement(By.linkText("Add to cart")).click();
		 Assert.assertEquals(driver.getTitle(),"Search");
		  wait=new WebDriverWait(driver,30);
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
	public void passTest4() {
		logger = extent.startTest("passTest4");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		  //TestPayment
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
		     WebElement b= driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label"));
		     b.click();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     WebElement d=  driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		     d.click();
	         //driver.findElement(By.partialLinkText("Continue")).click();
	         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
		      Assert.assertEquals(driver.getTitle(),"Payment Gateway");
		     
			  driver.findElement(By.name("username")).sendKeys("123456");
			  driver.findElement(By.name("password")).sendKeys("Pass@456");
			  driver.findElement(By.xpath("//input[@type='submit']")).click();  
			  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
			  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();  
			  Assert.assertEquals(driver.getTitle(),"Order Details");
			 
			  driver.findElement(By.linkText("Home")).click();
		 
	}

	//@Test
	/*public void failTest() {
		logger = extent.startTest("failTest");
		driver = Drivers.getDriver("firefox");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		String title = driver.getTitle();
		Assert.assertEquals(title, "NoTitle");
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
*/
	/*@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}  */
 
 
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = Report.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Failed is " + result.getName());
			//logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = Report.getScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		extent.close();
		driver.close();
	}

 
}
