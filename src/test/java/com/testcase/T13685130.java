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

public class T13685130 {

	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13685130.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Test Case ID: ", "T13685130");

		extent.setSystemInfo("Test Case Name: ", "Upload eTMF user (who is added to Study Specific Training group)");

		extent.setSystemInfo("Test Environment:", "GL 2.4_Regression_Round-2");

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

		// Create on eTMF and add eTMF user to study specific training group:*/

		// 1) log in as admin on eTMF in e.g. Michael demo room
		// 2) create user e.g. qa+up2_ti1@ecisys.com Pass@123
		// 3) finish invitation flow by created userand log in to eTMF
		// 4) log in as admin on eTMF in e.g. Michael demo room -> go to users
		// management
		// 5) add created user to study specific training group,
		// e.g. BOE3_LMS
		// 6) wait for this user is added to LMS => sqs message is done
		// and user is present in list/edit users page on LMS
		// 7) prepare CVS file for upload user:email as the user from eTMF,
		// but another first and last name password e.g.

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
	public void T13685130_step_1() throws InterruptedException, AWTException, IOException {

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

		// creates a toggle for the given test, add all log events under it
		test = extent.createTest("T13685130_step_1", "Expected Result-upload users")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[text()='Company Dashboard']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);

		// clicking the company dashboard
		driver.findElement(By.xpath("//*[text()='Company Dashboard']")).click();

		// clicking the upload users
		driver.findElement(By.xpath("//*[@id='uploadusers']")).click();

		String path = captureScreenShot("T13685130_step_1");
		test.addScreenCaptureFromPath(path, "Step-1_Actual Result: upload users");

		Thread.sleep(3000);

//------------------------------------------------------------------------------------------------------------------------

		// creates a toggle for the given test, add all log events under it
		test = extent.createTest("T13685130_step_2",
				"Expected Result-System shouldn't update First, Last names, Password of eTMF user"
						+ "e.g. Password cannot be changed by LMS(action is not authorized by eTMF)")
				.assignAuthor("Karthikeyan")
				.assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

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
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\CSV_Format\\Upload eTMF user file.csv");
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

		Thread.sleep(2000);

		String path1 = captureScreenShot("T13685130_step_2");
		test.addScreenCaptureFromPath(path1,
				"Step-2_Actual Result-System shouldn't update First, Last names, Password of eTMF user e.g. Password cannot be changed by LMS(action is not authorized by eTMF)");

		Thread.sleep(3000);

		driver.quit();

	}

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13685130/" + fileName + dateName + ".jpg";

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
