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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T13685131 {

	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static  ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13685131.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Test Environment:", "GL 2.4_Regression_Round-2");
		extent.setSystemInfo("Test Case ID: ", "T13685131");
		extent.setSystemInfo("Test Case Name: ",
				"Upload eTMF user (who is not added to Study Specific Training group)");
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

		/*
		 * Preconditions Create on eTMF and NOT add eTMF user to study specific training
		 * group:/*
		 * 
		 * /* 1) log in as admin on eTMF in e.g. Michael demo room
		 */

		/* 2) create user e.g. User 3 Test|qa+up3_ti1@ecisys.com |Pass@123 */

		/* 3) finish invitation flow by created user and log in to eTMF */

		/*
		 * 4) prepare CVS file for upload user without password:email, first and last
		 * names, and password as the same user from eTMF, e.g.
		 */

		// initializing and starting the browser.
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

		// launching Global Learner Application on the browser.
		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		// Implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

	}

	@Test
	public void T13685131_step_1() throws InterruptedException, AWTException, IOException {

		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("cainternal12@ti.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// Clicking login button.
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		/*
		 * Step-1 log in as CA on company with enabled integration ( Trial Interactive
		 * company) -> go to company dashboard -> go to upload users page
		 */

		test = extent.createTest("T13685131-Step-1", "Expected Result: upload users").assignAuthor("Karthikeyan")
				.assignCategory("GL 2.4_Regression_Round-2").assignDevice("chrome Version 123.0.6312.107");

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[text()='Company Dashboard']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);

		// clicking the company dashboard
		driver.findElement(By.xpath("//*[text()='Company Dashboard']")).click();

		// clicking the upload users
		driver.findElement(By.xpath("//*[@id='uploadusers']")).click();

		String path1 = captureScreenShot("T13685131_step_1");
		test.addScreenCaptureFromPath(path1, "Step-1_Actual Result: User is uploaded");

		Thread.sleep(3000);

		/*
		 * Step-2 Upload CSV from preconditions -> select CSV Delimiter > click upload
		 * users -> check info and upload users
		 */

		test = extent.createTest("T13685131-Step-2", "Expected Result: User is uploaded").assignAuthor("Karthikeyan")
				.assignCategory("GL 2.4_Regression_Round-2").assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(2000);

		// clicking the the user file choose
		driver.findElement(By.xpath("//*[@name='userfilechoose']")).click();

		Thread.sleep(2000);

		// clicking the fille
		driver.findElement(By.xpath("//*[text()='Attachment']")).click();

		Thread.sleep(5000);// delay

		// using robot class
		Robot rob = new Robot();

		rob.delay(2000);

		// given the system path
		StringSelection s = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\CSV_Format\\Upload New User File.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		// Function Keys on Keyboard
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);

		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.delay(2000);// delay

		// clicking the fille
		driver.findElement(By.xpath("//*[text()='Upload this file']")).click();

		Thread.sleep(3000);

		// clicking the submit button
		driver.findElement(By.xpath("//*[@id='id_submitbutton']")).click();

		Thread.sleep(2000);

		// upload users button
		driver.findElement(By.xpath("//*[@id='id_submitbutton']")).click();

		// scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Element1 = driver.findElement(By.xpath("// button[text()='Continue']"));
		js1.executeScript("arguments[0].scrollIntoView();", Element1);

		Thread.sleep(1000);

		String path2 = captureScreenShot("T13685131_step_2");
		test.addScreenCaptureFromPath(path2, "Step-2_Actual Result: User is uploaded");

		Thread.sleep(4000);

		driver.quit();
	}

	@Test
	public void T13685131_step_3() throws InterruptedException, AWTException, IOException {

		/* Step-3 Log in as created user on LMS */

		test = extent.createTest("T13685131-Step-3", "Expected Result: User has access to LMS")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// Entering user name Email ID
		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("testlsus97ysll@ti1.com");

		// clicking signin button
		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		// Entering Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		// clicking login button
		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		Thread.sleep(3000);

		String path3 = captureScreenShot("T13685131_step_3");
		test.addScreenCaptureFromPath(path3, "Step-3_Actual Result: User has access to LMS");

		Thread.sleep(3000);

		driver.quit();

	}

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13685131/" + fileName + dateName + ".jpg";

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
