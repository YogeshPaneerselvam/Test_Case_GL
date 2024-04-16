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

public class T13686136 {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13686136.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Test Environment:", "GL 2.4_Regression_Round-2");
		extent.setSystemInfo("Test Case ID: ", "T13686136");
		extent.setSystemInfo("Test Case Name: ", "Upload New Evidence Document for some users");
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
	public static void loginPage() throws Exception {

		// Preconditions:

		// 1. Log in as CA
		// 2. there are some individual Users: User1, User2
		// 3. Go to Course Management -> Add course -> External Training
		// 4. Fill in all required fields with valid data on General information
		// 5. go to next step and enroll Users: User1, User2
		// 6. go to next step and select "Upload Documents (i.e. Electronic Copy of
		// Attendance Log)"
		// 7. upload some documents ( e.g. : doc1, doc2)
		// 8. go to "Completion settings"
		// 9. checkbox "Use same Document for all Users" is unselected and select
		// documents for users. e.g. doc1, doc2

		// 10. "Use Same Completion date for All Users" is selected
		// 11. set some completion date for individual users
		// 12. click "Next" and Finish the creation and Publish External training
		// 13. Open External Training page
		// 14. Click on N Users
		// 15. Set the check box near the User1 , User2-> Click 'Edit Evidence Document'
		// -> click on the field
		// 16. click 'Upload New Evidence Document'
		// 17. Upload a document and click Upload

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
	public void Preconditions() throws InterruptedException, AWTException, IOException {

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
		driver.findElement(By.xpath("(//*[@id='fullname'])[1]")).sendKeys("TCS-12");

		// enter the short name
		driver.findElement(By.xpath("(//*[@id='shortname'])[1]")).sendKeys("TCS-321");

		// select the catalog
		driver.findElement(By.xpath("(//*[text()='Y_catalog'])[1]")).click();

		Thread.sleep(2000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

//				// clicking the cancel button
//				driver.findElement(By.xpath("(//*[text()='Cancel'])[1]")).click();
//				test.pass(" clicking the cancel button ");

		Thread.sleep(3000);

		// clicking the next button
		WebElement searchUser = driver.findElement(By.xpath("(//*[@id='searchusersgroups'])[1]"));
		searchUser.click();
		searchUser.clear();
		searchUser.sendKeys("Yogi4learner@ti.com");

		Thread.sleep(3000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='cbxitem'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("(//*[@id='addusers'])[1]")).click();

		// clicking the next button
		WebElement searchUser2 = driver.findElement(By.xpath("(//*[@id='searchusersgroups'])[1]"));
		searchUser2.click();
		searchUser2.clear();
		searchUser2.sendKeys("Yogi3learner@ti.com");

		Thread.sleep(3000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='cbxitem'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("(//*[@id='addusers'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("//*[@id='cbxall_current']")).click();

//				// previous button
//				driver.findElement(By.xpath("(//*[text()='Previous'])[1]")).click();
//				test.pass(" previous button ");

		Thread.sleep(4000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		/*
		 * //check box Learner Uploads Evidence
		 * driver.findElement(By.xpath("(//*[@id='evidence_type1'])[1]")).click();
		 * test.pass("check box Learner Uploads Evidence ");
		 * 
		 * //check box Learner is required to only eSign
		 * driver.findElement(By.xpath("(//*[@id='evidence_type2'])[1]")).click();
		 * test.pass("check box Learner is required to only eSign");
		 */

		// Upload Evidence On Behalf Of Learner
		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		Thread.sleep(5000);// delay

		// using robot class
		Robot rob = new Robot();

		rob.delay(2000);

		// given the system path
		StringSelection s = new StringSelection("C:\\Users\\yogesh.paneerselvam\\Downloads\\New folder\\sample_1.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		// Function Keys on Keyboard
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);

		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.delay(2000);// delay
		rob.delay(4000);// delay

		Thread.sleep(3000);

		// Upload Evidence On Behalf Of Learner
		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		Thread.sleep(5000);// delay

		// using robot class
		Robot rob1 = new Robot();

		rob1.delay(2000);

		// given the system path
		StringSelection s1 = new StringSelection("C:\\Users\\yogesh.paneerselvam\\Downloads\\New folder\\sample_3.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);

		// Function Keys on Keyboard
		rob1.keyPress(KeyEvent.VK_CONTROL);
		rob1.keyPress(KeyEvent.VK_V);

		rob1.keyRelease(KeyEvent.VK_CONTROL);
		rob1.keyRelease(KeyEvent.VK_V);

		rob1.keyPress(KeyEvent.VK_ENTER);
		rob1.keyRelease(KeyEvent.VK_ENTER);

		rob1.delay(2000);// delay
		rob1.delay(4000);// delay

		Thread.sleep(2000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='selectdocument evidencedoc '])[1]")).click();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("(//*[@class='selectdocument evidencedoc '])[2]")).click();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyRelease(KeyEvent.VK_DOWN);

		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

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

		// clicking the 1 user button
		driver.findElement(By.xpath("//*[@id='viewUsersOfCourse']")).click();

		Thread.sleep(3000);

		// checkbox
		driver.findElement(By.xpath("//*[@id='cbxall_current']")).click();

		Thread.sleep(2000);

		test = extent.createTest("T13686136_step_1", "Expected Result-Uploaded Document is displayed in the field")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// checkbox
		driver.findElement(By.xpath("//*[text()=' Edit Evidence Document']")).click();

		// clicking the evidence document
		driver.findElement(By.xpath("//*[text()='Select Evidence Document']")).click();

		// save evidence document
		driver.findElement(By.xpath("//*[@id='evidocid']")).click();
		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);

		r2.keyPress(KeyEvent.VK_ENTER);
		r2.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		String path = captureScreenShot("T13686136_step_1");
		test.addScreenCaptureFromPath(path, "Step-1_Actual Result: Uploaded Document is displayed in the field ");

		test = extent.createTest("T13686136_step_2",
				"Expected Result-Pop-up is closed. Uploaded Document is displayed for users in 'Evidence' column")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// save evidence document
		driver.findElement(By.xpath("//*[@id='saveevidencedocument']")).click();

		Thread.sleep(3000);

		String path2 = captureScreenShot("T13686136_step_2");
		test.addScreenCaptureFromPath(path2,
				"Step-2_Actual Result: Pop-up is closed. Uploaded Document is displayed for users in 'Evidence' column ");

		Thread.sleep(3000);

		driver.quit();

	}

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13686136/" + fileName + dateName + ".jpg";

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
