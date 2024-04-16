package com.testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T13686068 {

	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13686068.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Test Environment:", "GL 2.4_Regression_Round-2");
		extent.setSystemInfo("Test Case ID: ", "T13686068");
		extent.setSystemInfo("Test Case Name: ",
				"User eSigns External Trianing course (incorrect credentials) etmf user");
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

		// There is etmf user
		// 1.Log in as CA
		// 2.Go to Course Management -> Add course -> External Training -> Next
		// 3.Fill in all required fields with valid data on General information (1st
		// step)-> click Next
		// 4.Select 1 user (etmf user) on 2nd step -> click Add 1 user -> click Next
		// 5.Select "Learner Is Required to e-Sign After Evidence Approval" -> click
		// Next
		// 6.Set completion date as yesterday date -> Click Next
		// 7.Click Create course
		// 8.Click View Course (or click on course name on course management page)
		// 9.Click Publish

		// initializing and starting the browser.
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void preconditions() throws InterruptedException, AWTException, IOException {

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		// Implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("cainternal12@ti.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// Clicking login button.
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		Thread.sleep(2000);

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[text()='Company Dashboard']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);

		// clicking the company dashboard
		driver.findElement(By.xpath("//*[text()='Course Management']")).click();

		Thread.sleep(1000);

		// clicking the Add cocurse
		driver.findElement(By.xpath("//*[text()=' Add Course']")).click();

		Thread.sleep(2000);

		// clicking the External Training cocurse
		driver.findElement(By.xpath("(//*[text()='External Training'])[1]")).click();

		Thread.sleep(2000);

		// clicking the Next Button
		driver.findElement(By.xpath("(//*[@id='createcourse'])[1]")).click();

		// enter the first name
		driver.findElement(By.xpath("(//*[@id='fullname'])[1]")).sendKeys("TestON15-18");

		// enter the short name
		driver.findElement(By.xpath("(//*[@id='shortname'])[1]")).sendKeys("TestON015");

		// select the catalog
		driver.findElement(By.xpath("(//*[text()='Y_catalog'])[1]")).click();

		Thread.sleep(2000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		// clicking the cancel button
		//driver.findElement(By.xpath("(//*[text()='Cancel'])[1]")).click();

		Thread.sleep(3000);

		// clicking the next button
		WebElement searchUser = driver.findElement(By.xpath("(//*[@id='searchusersgroups'])[1]"));
		searchUser.click();
		searchUser.clear();
		searchUser.sendKeys("sotewo3027@storesr.com");

		Thread.sleep(3000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='cbxitem'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("(//*[@id='addusers'])[1]")).click();

		Thread.sleep(2000);

		// chack box select
		driver.findElement(By.xpath("//*[@id='cbxall_current']")).click();

		// // previous button //
		//driver.findElement(By.xpath("(//*[text()='Previous'])[1]")).click(); //
	

		Thread.sleep(4000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		Thread.sleep(2000);

		// check box Learner is required to only eSign
		driver.findElement(By.xpath("(//*[@id='evidence_type2'])[1]")).click();

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		Thread.sleep(2000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		WebElement Element1 = driver.findElement(By.xpath("(//*[@class='gl_accordion_head users'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", Element1);

		// Create Course button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		// View Course button
		driver.findElement(By.xpath("(//*[text()='View Course'])[1]")).click();

		Thread.sleep(3000);

		// publish button
		driver.findElement(By.xpath("//*[text()='Publish']")).click();

		Thread.sleep(3000);

		// View Course button
		driver.findElement(By.xpath("(//*[text()='View Course'])[1]")).click();

		driver.quit();

		Thread.sleep(5000);
	}

//-------------------------------------------------------------------------------------------------------------------

	@Test(priority = 2)
	public void step() throws InterruptedException, AWTException, IOException {

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='pre-username']")).sendKeys("sotewo3027@storesr.com");

		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		test = extent.createTest("T13686068_step_1", "Expected Result-eSign Course pop-up appears with")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(3000);

		// scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Element11 = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js1.executeScript("arguments[0].scrollIntoView();", Element11);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TestON15-18");

		driver.findElement(By.xpath("(//*[@class='fa fa-table-cells-large'])[1]")).click();

		Thread.sleep(3000);

		// clicking the eSign
		driver.findElement(By.xpath("(//*[text()='eSign'])[3]")).click();

		Thread.sleep(3000);

		String path = captureScreenShot("T13686068_step_1");
		test.addScreenCaptureFromPath(path, "Step-1_Actual Result: eSign Course pop-up appears with ");

		// singing Reason
		driver.findElement(By.xpath("// *[@id='inputReason']")).click();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		test = extent.createTest("T13686068_step_2", "Expected Result-eSign a course pop-up appears")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		String parentWindowID = driver.getWindowHandle();

		System.out.println(parentWindowID);

		// clicking next buttom
		driver.findElement(By.xpath("//*[text()='Next']")).click();

		Set<String> allWindowsId = driver.getWindowHandles();

		System.out.println(allWindowsId);

		for (String allWindows : allWindowsId) {

			if (!allWindows.equals(parentWindowID)) {

				driver.switchTo().window(allWindows);

				Thread.sleep(4000);

				String path1 = captureScreenShot("T13686068_step_2");
				test.addScreenCaptureFromPath(path1, "Step-2_Actual Result: eSign a course pop-up appears ");

				Thread.sleep(4000);

				test = extent
						.createTest("T13686068_step_3", "Expected Result-Error message Invalid credentialsappears.")
						.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
						.assignDevice("chrome Version 123.0.6312.107");

				// entering user email id
				driver.findElement(By.xpath("//*[@id='pre-username']")).sendKeys("cat12@ti.com");
				driver.findElement(By.xpath("//*[@id='proceed-username-button']")).click();

				Thread.sleep(4000);
				// entering password
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pass@123");

				Thread.sleep(4000);

				// entering password
				driver.findElement(By.xpath("//*[@id='login-button']")).click();

				Thread.sleep(4000);

				String path2 = captureScreenShot("T13686068_step_3");
				test.addScreenCaptureFromPath(path2,
						"Step-3_Actual Result: Error message Invalid credentialsappears. ");

				test = extent.createTest("T13686068_step_4", "Expected Result-Popup Invalid credentials appears")
						.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
						.assignDevice("chrome Version 123.0.6312.107");

				WebElement us = driver.findElement(By.xpath("//*[@id='username']"));
				us.click();
				us.clear();
				us.sendKeys("caint123@ti.com");

				// entering password
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pass@123");

				Thread.sleep(3000);

				// entering password
				driver.findElement(By.xpath("//*[@id='login-button']")).click();

				Thread.sleep(3000);

				String path4 = captureScreenShot("T13686068_step_4");
				test.addScreenCaptureFromPath(path4, "Step-4_Actual Result: Popup Invalid credentials appears ");

				Thread.sleep(3000);

				driver.close();

			}

		}

		driver.switchTo().window(parentWindowID);

		driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-arrow-left'])[1]")).click();

		Thread.sleep(3000);

		// scroll down
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		WebElement Element121 = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js12.executeScript("arguments[0].scrollIntoView();", Element121);

		Thread.sleep(3000);

		test = extent
				.createTest("T13686068_step_5",
						"Expected Result-Course displays eSig button and with eSignature column Not completed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TestON15-18");

		driver.findElement(By.xpath("(//*[@class='fa fa-table-cells-large'])[1]")).click();

		Thread.sleep(3000);

		String path4 = captureScreenShot("T13686068_step_5");
		test.addScreenCaptureFromPath(path4,
				"Step-5_Actual Result: Course displays eSig button and with eSignature column Not completed ");

		Thread.sleep(3000);

		// clicking the eSign
		driver.findElement(By.xpath("(//*[text()='eSign'])[3]")).click();

		Thread.sleep(3000);

		// singing Reason
		driver.findElement(By.xpath("// *[@id='inputReason']")).click();

		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_ENTER);
		r2.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		String parentWindowID1 = driver.getWindowHandle();

		System.out.println(parentWindowID1);

		// clicking next buttom
		driver.findElement(By.xpath("//*[text()='Next']")).click();

		Set<String> allWindowsId1 = driver.getWindowHandles();

		System.out.println(allWindowsId1);

		for (String allWindows1 : allWindowsId1) {

			if (!allWindows1.equals(parentWindowID1)) {

				driver.switchTo().window(allWindows1);

				Thread.sleep(3000);

				// entering user email id
				driver.findElement(By.xpath("//*[@id='pre-username']")).sendKeys("sotewo3027@storesr.com");
				driver.findElement(By.xpath("//*[@id='proceed-username-button']")).click();

				Thread.sleep(2000);

				// entering password
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pass@123");

				Thread.sleep(3000);

				// entering password
				driver.findElement(By.xpath("//*[@id='login-button']")).click();

				Thread.sleep(5000);

				//driver.close();

			}

		}

		driver.switchTo().window(parentWindowID1);

		WebElement elementVisible = driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(elementVisible));

		driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-arrow-left'])[1]")).click();

		Thread.sleep(3000);

		test = extent.createTest("T13686068_step_6",
				"Expected Result-Course Test Training is presented on My courses dashlet with Completed status and date and time of eSign")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(3000);

		// scroll down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement Element2 = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js2.executeScript("arguments[0].scrollIntoView();", Element2);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TestON15-18");
		driver.findElement(By.xpath("(//*[@class='fa fa-table-cells-large'])[1]")).click();

		Thread.sleep(3000);

		String path5 = captureScreenShot("T13686068_step_6");
		test.addScreenCaptureFromPath(path5,
				"Step-6_Actual Result: Course Test Training is presented on My courses dashlet with Completed status and date and time of eSign ");

		driver.quit();
	}

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13686068/" + fileName + dateName + ".jpg";

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
