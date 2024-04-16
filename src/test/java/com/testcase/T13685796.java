package com.testcase;

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

public class T13685796 {

	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "Test_Case_ID_T13685796.html");

		extent = new ExtentReports();

		sparkReporter.loadJSONConfig(new File(
				"C:\\Users\\yogesh.paneerselvam\\eclipse-workspace\\GL_App_TC\\src\\test\\resources\\extent-report-config.json"));

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Test Environment", "GL 2.4_Regression_Round-2");

		extent.setSystemInfo("Test Case ID: ", "T13685796");

		extent.setSystemInfo("Test Case Name: ",
				"Uploading documents with different sizes (Upload Documents )(Part 1)");

		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("User", "Yogesh");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void endReport() {
		test.pass("closed the browser");
		test.info("test completed");
		extent.flush();
	}

	@BeforeMethod
	public void loginPage() {

		// initializing and starting the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://lms-stg-globallearn2.trialinteractive.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));// implicitly wait

	}

	@Test(priority = 1)
	public void externalTrainingcourse1() throws Exception {

		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("cainternal12@ti.com");

		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		driver.findElement(By.xpath("//button[@id='login-button']")).click();

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
		driver.findElement(By.xpath("(//*[@id='fullname'])[1]")).sendKeys("TY-01042024Y");

		// enter the short name
		driver.findElement(By.xpath("(//*[@id='shortname'])[1]")).sendKeys("YYTT-2024Y");

		// select the catalog
		driver.findElement(By.xpath("(//*[text()='Y_catalog'])[1]")).click();

		Thread.sleep(2000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

//		// clicking the cancel button
//		driver.findElement(By.xpath("(//*[text()='Cancel'])[1]")).click();
//		test.pass(" clicking the cancel button ");

		Thread.sleep(3000);

		// clicking the next button
		WebElement searchUser = driver.findElement(By.xpath("(//*[@id='searchusersgroups'])[1]"));
		searchUser.click();
		searchUser.sendKeys("test12m@gmail.com");

		Thread.sleep(3000);

		// clicking the next button
		driver.findElement(By.xpath("(//*[@id='cbxitem'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("(//*[@id='addusers'])[1]")).click();

		Thread.sleep(2000);

		// Add user button
		driver.findElement(By.xpath("(//*[@class='chbx'])[6]")).click();

//		// previous button
//		driver.findElement(By.xpath("(//*[text()='Previous'])[1]")).click();
//		test.pass(" previous button ");

		Thread.sleep(4000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

		// check box Learner Uploads Evidence
		driver.findElement(By.xpath("(//*[@id='evidence_type1'])[1]")).click();

		Thread.sleep(5000);

		// next button
		driver.findElement(By.xpath("(//*[@id='submitsinglebtn'])[1]")).click();

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

//		// View Course button
		driver.findElement(By.xpath("(//*[text()='View Course'])[1]")).click();

		driver.close();

	}

//-----------------------------------------------------------------------------------------------------------	

	@Test(priority = 2)
	public void uploadDocument0Kb() throws Exception {

		test = extent.createTest("T13685796_step_1", "Expected Result- Document is not uploaded.")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("//input[@id='pre-username']")).sendKeys("test12m@gmail.com");

		driver.findElement(By.xpath("//button[@id='proceed-username-button']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");

		driver.findElement(By.xpath("//button[@id='login-button']")).click();

		Thread.sleep(3000);

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TY-01042024Y");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='TY-01042024Y']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='Upload']")).click();

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob = new Robot();
		rob.delay(2000);
		// given the system path
		StringSelection s = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\Test_docs\\0kb.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		// Function Keys on Keyboard
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		rob.delay(4000);// delay

		String path1 = captureScreenShot("T13685796_step_1");
		test.addScreenCaptureFromPath(path1, "Step-1_Actual Result: Document is not uploaded. ");

		Thread.sleep(5000);

//------------------------------------------------------------------------------------------------------------
		test = extent.createTest("T13685796_step_2", "Expected Result- Document is uploaded")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='Upload']")).click();

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob1 = new Robot();
		rob1.delay(2000);
		// given the system path
		StringSelection s1 = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\Test_docs\\34kb.pdf");
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
		Thread.sleep(6000);

		String path2 = captureScreenShot("T13685796_step_2");
		test.addScreenCaptureFromPath(path2, "Step-2_Actual Result: Document is uploaded ");

		driver.findElement(By.xpath("//*[@id='saveselfdocument']")).click();

		test = extent.createTest("T13685796_step_3", "Expected Result- Document is displayed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='close'])[3]")).click();

		String path3 = captureScreenShot("T13685796_step_3");
		test.addScreenCaptureFromPath(path3, "Step-3_Actual Result: Document is displayed ");

		Thread.sleep(5000);

// ------------------------------------------------------------------------------------------------------

		test = extent.createTest("T13685796_step_4", "Expected Result- Document is uploaded")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TY-01042024Y");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='TY-01042024Y']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-pen'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa fa-trash'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob21 = new Robot();
		rob21.delay(2000);
		// given the system path
		StringSelection s21 = new StringSelection("C:/Users/yogesh.paneerselvam/Desktop/Automation/Test_docs/2MB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s21, null);
		// Function Keys on Keyboard
		rob21.keyPress(KeyEvent.VK_CONTROL);
		rob21.keyPress(KeyEvent.VK_V);
		rob21.keyRelease(KeyEvent.VK_CONTROL);
		rob21.keyRelease(KeyEvent.VK_V);
		rob21.keyPress(KeyEvent.VK_ENTER);
		rob21.keyRelease(KeyEvent.VK_ENTER);
		rob21.delay(2000);// delay
		rob21.delay(4000);// delay

		Thread.sleep(6000);

		String path4 = captureScreenShot("T13685796_step_4");
		test.addScreenCaptureFromPath(path4, "Step-4_Actual Result: Document is uploaded ");

		driver.findElement(By.xpath("//*[@id='saveselfdocument']")).click();

		Thread.sleep(3000);

		test = extent.createTest("T13685796_step_5", "Expected Result- Document is displayed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@class='close'])[3]")).click();

		String path5 = captureScreenShot("T13685796_step_5");
		test.addScreenCaptureFromPath(path5, "Step-5_Actual Result: Document is displayed");

		Thread.sleep(10000);

//-------------------------------------------------------------------------------------------------------------------	

		test = extent.createTest("T13685796_step_6", "Expected Result-Document is uploaded")

				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TY-01042024Y");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='TY-01042024Y']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-pen'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa fa-trash'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob31 = new Robot();

		rob31.delay(2000);

		// given the system path
		StringSelection s31 = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\Test_docs\\50MB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s31, null);

		// Function Keys on Keyboard
		rob31.keyPress(KeyEvent.VK_CONTROL);
		rob31.keyPress(KeyEvent.VK_V);

		rob31.keyRelease(KeyEvent.VK_CONTROL);
		rob31.keyRelease(KeyEvent.VK_V);

		rob31.keyPress(KeyEvent.VK_ENTER);
		rob31.keyRelease(KeyEvent.VK_ENTER);

		rob31.delay(2000);// delay
		rob31.delay(4000);// delay

		Thread.sleep(10000);

		String path6 = captureScreenShot("T13685796_step_6");
		test.addScreenCaptureFromPath(path6, "Step-6_Actual Result: Document is uploaded");

		driver.findElement(By.xpath("//*[@id='saveselfdocument']")).click();
		Thread.sleep(3000);

		test = extent.createTest("T13685796_step_7", "Expected Result- Document is displayed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		driver.findElement(By.xpath("(//*[@class='close'])[3]")).click();

		String path7 = captureScreenShot("T13685796_step_7");
		test.addScreenCaptureFromPath(path7, "Step-7_Actual Result: Document is displayed");

		Thread.sleep(5000);

//---------------------------------------------------------------------------------------------------------------	

		test = extent.createTest("T13685796_step_8", "Expected Result- Document is uploaded")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// scroll down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement Element2 = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js2.executeScript("arguments[0].scrollIntoView();", Element2);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TY-01042024Y");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='TY-01042024Y']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-pen'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa fa-trash'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob4 = new Robot();

		rob4.delay(2000);

		// given the system path
		StringSelection s4 = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\Test_docs\\200MB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s4, null);

		// Function Keys on Keyboard
		rob4.keyPress(KeyEvent.VK_CONTROL);
		rob4.keyPress(KeyEvent.VK_V);
		rob4.keyRelease(KeyEvent.VK_CONTROL);
		rob4.keyRelease(KeyEvent.VK_V);
		rob4.keyPress(KeyEvent.VK_ENTER);
		rob4.keyRelease(KeyEvent.VK_ENTER);
		rob4.delay(2000);// delay
		rob4.delay(4000);// delay

		Thread.sleep(10000);

		String path8 = captureScreenShot("T13685796_step_8");
		test.addScreenCaptureFromPath(path8, "Step-8_Actual Result: Document is uploaded");

		driver.findElement(By.xpath("//*[@id='saveselfdocument']")).click();

		test = extent.createTest("T13685796_step_9", "Expected Result- Document is displayed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(20000);
		driver.findElement(By.xpath("(//*[@class='close'])[3]")).click();

		String path9 = captureScreenShot("T13685796_step_9");
		test.addScreenCaptureFromPath(path9, "Step-9_Actual Result: Document is displayed");

		Thread.sleep(5000);

//-----------------------------------------------------------------------------------------------------------------------------------		

		test = extent.createTest("T13685796_step_10", "Expected Result- Document is uploaded")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		// scroll down
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		WebElement Element6 = driver.findElement(By.xpath("//*[text()='My Courses']"));
		js6.executeScript("arguments[0].scrollIntoView();", Element6);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@id='keywords'])[1]")).sendKeys("TY-01042024Y");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='TY-01042024Y']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa-solid fa-pen'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[@class='fa fa-trash'])[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='upload-pic']/parent::div[@id='upic_block']")).click();

		// using robot class
		Robot rob5 = new Robot();

		rob5.delay(2000);

		// given the system path
		StringSelection s5 = new StringSelection(
				"C:\\Users\\yogesh.paneerselvam\\Desktop\\Automation\\Test_docs\\0kb.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s5, null);

		// Function Keys on Keyboard
		rob5.keyPress(KeyEvent.VK_CONTROL);
		rob5.keyPress(KeyEvent.VK_V);

		rob5.keyRelease(KeyEvent.VK_CONTROL);
		rob5.keyRelease(KeyEvent.VK_V);

		rob5.keyPress(KeyEvent.VK_ENTER);
		rob4.keyRelease(KeyEvent.VK_ENTER);

		rob5.delay(2000);// delay
		rob5.delay(4000);// delay

		Thread.sleep(10000);
		String path10 = captureScreenShot("T13685796_step_10");
		test.addScreenCaptureFromPath(path10, "Step-10_Actual Result: Document is uploaded");

		driver.findElement(By.xpath("//*[@id='saveselfdocument']")).click();

		test = extent.createTest("T13685796_step_11", "Expected Result-  Document is displayed")
				.assignAuthor("Karthikeyan").assignCategory("GL 2.4_Regression_Round-2")
				.assignDevice("chrome Version 123.0.6312.107");

		Thread.sleep(20000);

		driver.findElement(By.xpath("(//*[@class='close'])[3]")).click();

		String path11 = captureScreenShot("T13685796_step_11");
		test.addScreenCaptureFromPath(path11, "Step-11_Actual Result: Document is displayed");

		Thread.sleep(5000);

	}

	public static String captureScreenShot(String fileName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/T13685796/" + fileName + dateName + ".jpg";

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
