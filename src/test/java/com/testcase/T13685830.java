package com.testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T13685830 {
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13685830.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Test Environment:", "GL 2.4_Regression_Round-2");

		extent.setSystemInfo("Test Case ID: ", "T13685830");

		extent.setSystemInfo("Test Case Name: ", "External Training record Change Status from Approved to Rejected");

		extent.setSystemInfo("HostName: ", "LocalHost");

		extent.setSystemInfo("OS", "Windows10");

		extent.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void endReport() throws Exception {
		test.pass("closed the browser");
		test.info("test completed");
		extent.flush();

	}

	@BeforeMethod
	public void loginPage() throws Exception {

		// Preconditions:

		// 1. Log in as learner
		// Go to Transcript -> External Training

		// Create 1 record:
		// Click "Add New Record"
		// Fill in all required fields -> Click "Next"
		// Upload any document -> Click "Next"
		// Click "Add Record"

		// Log in as CA
		// Go to Transcript -> External Training
		// Find record from precondition -> Approve this document
		// Click on Document name
		// Click "Change Status"

		// initializing and starting the browser.
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

	}

	@Test
	public void Preconditions() throws InterruptedException, AWTException, IOException {

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		// Implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("Yogi4learner@ti.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// Clicking login button.
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		Thread.sleep(2000);

		// Clicking the Transcript
		driver.findElement(By.xpath("//*[text()='Transcript']")).click();

		Thread.sleep(2000);

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[text()='External Training']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		// Clicking the External Training
		driver.findElement(By.xpath("//*[text()='External Training']")).click();

		Thread.sleep(2000);

		// Clicking the Add New Record
		driver.findElement(By.xpath("//*[text()=' Add New Record']")).click();

		// Entering the External training name
		driver.findElement(By.xpath("//*[@id='fldname']")).sendKeys("TestYON_12");

		// entering the schoole/company
		driver.findElement(By.xpath("//*[@id='fldcompany']")).sendKeys("TestON-97");

		// selecting date the completion date.
		driver.findElement(By.xpath("//*[@id='fldcompletiondate']")).click();

		Robot completiondate = new Robot();

		completiondate.keyPress(KeyEvent.VK_ENTER);
		completiondate.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);

		// Clicking the next button
		driver.findElement(By.xpath("//*[text()='Next']")).click();

		// Upload Evidence On Behalf Of Learner
		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='etupload_block']")).click();

		Thread.sleep(5000);// delay

		// using robot class
		Robot selectDocument = new Robot();
		selectDocument.delay(2000);
		// given the system path
		StringSelection s = new StringSelection("C:\\Users\\yogesh.paneerselvam\\Downloads\\New folder\\sample_1.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		// Function Keys on Keyboard
		selectDocument.keyPress(KeyEvent.VK_CONTROL);
		selectDocument.keyPress(KeyEvent.VK_V);
		selectDocument.keyRelease(KeyEvent.VK_CONTROL);
		selectDocument.keyRelease(KeyEvent.VK_V);
		selectDocument.keyPress(KeyEvent.VK_ENTER);
		selectDocument.keyRelease(KeyEvent.VK_ENTER);
		selectDocument.delay(2000);// delay
		selectDocument.delay(4000);// delay

		Thread.sleep(3000);

		// Clicking the next button
		driver.findElement(By.xpath("//*[text()='Next']")).click();

		// Clicking the Add Record button
		driver.findElement(By.xpath("//*[text()='Add Record']")).click();

		Thread.sleep(3000);

		// Clicking the cancel arror
		driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).click();

		Thread.sleep(3000);

		driver.quit();

//------------------------------------------------------------------------------------------------------------		

		WebDriverManager.chromedriver().clearDriverCache().setup();

		driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		// Implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		// creates a toggle for the given test, add all log events under it
		test = extent.createTest("T13685830-External Training record Change Status from Approved to Rejected")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		test.log(Status.INFO, "Starting ");

		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("cainternal12@ti.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// Clicking login button.
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		// scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Element1 = driver.findElement(By.xpath("//*[text()='Company Dashboard']"));
		js1.executeScript("arguments[0].scrollIntoView();", Element1);

		// Clicking the Transcript
		driver.findElement(By.xpath("//*[text()='Transcript']")).click();

		Thread.sleep(2000);

		// scroll down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement Element2 = driver.findElement(By.xpath("//*[text()='External Training']"));
		js2.executeScript("arguments[0].scrollIntoView();", Element2);

		test = extent
				.createTest("T13685830-Step-1",
						"Expected Result: REJECTED status is displayed Status Change Reason field is empty")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// Clicking the External Training
		driver.findElement(By.xpath("//*[text()='External Training']")).click();

		// course name drop down
		driver.findElement(By.xpath("//*[@id='fcoursename']")).click();

		Thread.sleep(2000);

		// course name search
		driver.findElement(By.xpath("//*[@id='fcoursename_search']")).sendKeys("TestYON_12");

		Thread.sleep(3000);

		// select the check box
		driver.findElement(By.xpath("(//*[text()='Select all'])[2]")).click();

		Thread.sleep(3000);

		// clicking the apply button
		driver.findElement(By.xpath("(//*[text()='Apply'])[2]")).click();

		Thread.sleep(2000);

		// clicking the evi_files button
		driver.findElement(By.xpath("(//*[@class='evi_files'])[1]")).click();

		Thread.sleep(2000);

		// clicking the Approve button
		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		Thread.sleep(2000);

		// clicking the Approve document button
		driver.findElement(By.xpath("(//*[text()='Approve Document'])[2]")).click();

		Thread.sleep(2000);

		// clicking the cancel arror
		driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).click();

		Thread.sleep(2000);

		// course name drop down
		driver.findElement(By.xpath("//*[@id='fcoursename']")).click();

		// course name search
		driver.findElement(By.xpath("//*[@id='fcoursename_search']")).sendKeys("TestYON_12");

		Thread.sleep(3000);

		// select the check box
		driver.findElement(By.xpath("(//*[text()='Select all'])[2]")).click();

		// clicking the apply button
		driver.findElement(By.xpath("(//*[text()='Apply'])[2]")).click();

		Thread.sleep(2000);

		// clicking the evi_files button
		driver.findElement(By.xpath("(//*[@class='evi_files'])[1]")).click();

		Thread.sleep(2000);

		// clicking change status button
		driver.findElement(By.xpath("(//*[@class='fa fa-pencil primarycolor'])[1]")).click();

		Thread.sleep(2000);

		String path = captureScreenShot("T13685830_step_1");
		test.addScreenCaptureFromPath(path,
				"Step-1_Actual Result:  REJECTED status is displayed Status Change Reason field is empty");

//----------------------------------------------------------------------------------------------------------------------------------------

		test = extent.createTest("T13685830-Step-2", "Expected Result:  Status Changed pop-up appears")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// status change reason
		driver.findElement(By.xpath("(//*[@id='statusreason'])[1]")).sendKeys("123 abc абв %&^*)!@_#\"? 太阳 XYZ");

		Thread.sleep(3000);

		// clicking save button
		driver.findElement(By.xpath("(//*[text()='Save'])[1]")).click();

		Thread.sleep(3000);

		String path1 = captureScreenShot("T13685830_step_2");
		test.addScreenCaptureFromPath(path1, "Step-2_Actual Result:  Status Changed pop-up appears");

//---------------------------------------------------------------------------------------------------------------------------------------		

		test = extent
				.createTest("T13685830-Step-3",
						"Expected Result:Evidence status is in progress Rejected is displayed in Evidence column")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).click();

		Thread.sleep(2000);

		// course name drop down
		driver.findElement(By.xpath("//*[@id='fcoursename']")).click();

		Thread.sleep(3000);

		// course name search
		driver.findElement(By.xpath("//*[@id='fcoursename_search']")).sendKeys("TestYON_12");

		Thread.sleep(2000);

		// select the check box
		driver.findElement(By.xpath("(//*[text()='Select all'])[2]")).click();

		Thread.sleep(3000);

		// clicking the apply button
		driver.findElement(By.xpath("(//*[text()='Apply'])[2]")).click();

		Thread.sleep(4000);

		String path2 = captureScreenShot("T13685830_step_3");
		test.addScreenCaptureFromPath(path2,
				"Step-3_Actual Result: Evidence status is in progress Rejected is displayed in Evidence column");

//---------------------------------------------------------------------------------------------------------------------------------------------

		test = extent.createTest("T13685830-Step-4",
				"Expected Result:  REJECTED  status is displayed Rejection Reason field is filled in, Rejection Date and other information is correct")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// clicking the evi_files button
		driver.findElement(By.xpath("(//*[@class='evi_files'])[1]")).click();

		Thread.sleep(2000);

		// clicking the evi_files button
		driver.findElement(By.xpath("//*[text()='< Show properties']")).click();

		Thread.sleep(3000);

		String path3 = captureScreenShot("T13685830_step_4");
		test.addScreenCaptureFromPath(path3,
				"Step-4_Actual Result: REJECTED  status is displayed Rejection Reason field is filled in, Rejection Date and other information is correct");

		Thread.sleep(3000);

		driver.quit();

//--------------------------------------------------------------------------------------------------------------
		WebDriverManager.chromedriver().clearDriverCache().setup();

		driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		// Implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		test = extent
				.createTest("T13685830-Step-5",
						"Expected Result: Upload Document button is presented in Evidence column in progress status")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("Yogi4learner@ti.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// Clicking login button.
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		Thread.sleep(2000);

		// Clicking the Transcript
		driver.findElement(By.xpath("//*[text()='Transcript']")).click();

		Thread.sleep(2000);

		// scroll down
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement Element5 = driver.findElement(By.xpath("//*[text()='External Training']"));
		js5.executeScript("arguments[0].scrollIntoView();", Element5);

		// Clicking the External Training
		driver.findElement(By.xpath("//*[text()='External Training']")).click();

		// Clicking the course name
		driver.findElement(By.xpath("//*[text()='Course Name']")).click();

		// course name search
		driver.findElement(By.xpath("//*[@id='fcoursename_search']")).sendKeys("TestYON_12");

		Thread.sleep(2000);

		// select the check box
		driver.findElement(By.xpath("(//*[text()='Select all'])[1]")).click();

		Thread.sleep(2000);

		// clicking the apply button
		driver.findElement(By.xpath("(//*[text()='Apply'])[1]")).click();

		Thread.sleep(3000);

		String path4 = captureScreenShot("T13685830_step_5");
		test.addScreenCaptureFromPath(path4,
				"Step-5_Actual Result: Upload Document button is presented in Evidence column in progress status");

		driver.quit();

	}
	
	

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13685830/" + fileName + dateName + ".jpg";

		// File destination = new File("./TC_ID_T13685830/" + fileName + dateName);

		File finalDestination = new File(destination);

		FileUtils.copyFile(src, finalDestination);

		try {

			FileUtils.copyFile(src, finalDestination);

		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Screenshot saved successfully");

		return finalDestination.getAbsolutePath();
	}

}
