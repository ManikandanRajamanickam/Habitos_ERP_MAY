package Habitos_QA_ERP.HBERP;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Depriceation {

	WebDriver d;

	static org.apache.log4j.Logger logger;

	@Test(priority = 1)

	public void Valid_Login() {

		d.manage().window().maximize();

		String un = "vivek";
		String pw = "vivek";

		WebElement uname = d.findElement(By.xpath("//input[@id='kitchen_user_user_name']"));

		WebElement pwd = d.findElement(By.xpath("//input[@id='kitchen_user_password_digest']"));

		WebElement submit = d.findElement(By.name("commit"));

		if (uname.equals(d.switchTo().activeElement())) {

			uname.sendKeys(un);

			uname.sendKeys(Keys.TAB);

		} else {

			logger.error("Verify that if the user can enter the user name");

		}

		if (pwd.equals(d.switchTo().activeElement())) {

			pwd.sendKeys(pw);

		} else {

		}

		if (submit.isEnabled()) {

			submit.click();

		} else {

			// logger.error("Verify that user can login with valid credentials");

		}
	}

	// DEPRICEATION CATEGORY

	@Test(priority = 2)

	public void depriceation() throws InterruptedException {

		try {

			logger = logger.getLogger(" Habitos - DEPRICEATION - ADD");

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();
			WebElement masters = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			masters.click();

			logger.info("Verify  that if click master menu it getting to collapse");

			Thread.sleep(2000);

		}

		catch (Exception e) {

			logger.info("Verify  that if click master menu it getting to collapse");

		}

		d.get("http://192.168.1.230:4000/depriciation_categories");

		String url = "http://192.168.1.230:4000/depriciation_categories";

		if (d.getCurrentUrl().equals(url)) {

			logger.info("If click depriceation category menu it should redirect to related screen");

		} else {

			logger.error("If click depriceation category menu it should redirect to related screen");

		}

	}

	
	@Test(priority = 3)

	public void add_depriceation() throws IOException {

		try {

			WebElement add = d.findElement(By.xpath("//a[@class='btn']"));

			// add.isDisplayed();

			add.click();
			
			d.get("http://192.168.1.230:4000/depriciation_categories/new");

			logger.info("If click add button it should redirect to add screen");
			
			Thread.sleep(2000);

		} catch (Exception e) {

			logger.error("If click submit button it should redirect to index screen");

		}
		
		// Add depriceation

		try {

			Thread.sleep(200);

			WebElement depet = d.findElement(By.xpath("//input[@id='depriciation_category_name']"));

			// depet.isDisplayed();

			depet.sendKeys("Damaging");

			Thread.sleep(200);

			depet.sendKeys(Keys.TAB);

			Thread.sleep(200);

			logger.info("Verify that user can enter the depriciation category in input field");
		}

		catch (Exception e) {

			logger.error("Verify that user can enter the depriciation category in input field");
		}
		
		
	// Dep Category
		
		try {
			
			Thread.sleep(200);
			
			WebElement  desc = d.findElement(By.xpath("//textarea[@id='depriciation_category_description']"));
			
			desc.sendKeys("depriceation");
			
			Thread.sleep(200);
			
			desc.sendKeys(Keys.TAB);
			
			logger.info("Verify that if the user can enter the description in input field");
						
		} catch (Exception e) {
			
			logger.error("Verify that if the user can enter the description in input field");
		}
				
						
	// Dep Percentage
		
		try {
			
			Thread.sleep(200);
			
			WebElement dpercent = d.findElement(By.xpath("//input[@id='depriciation_category_depreciation_percentage']"));

			// dpercent.click();

			dpercent.sendKeys("25");

			Thread.sleep(200);

			logger.info("Verify that user can enter the depriciation percentage  in input field");

		} catch (Exception e) { 
			
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\depri.jpg"));
			
			logger.error("Verify that user can enter the depriciation percentage in input field");
		}
			 
		
		try {
			
			Thread.sleep(200);
			
			WebElement submit = d.findElement(By.xpath("//input[@name='commit']"));

			 submit.isDisplayed();

			Thread.sleep(100);

			submit.click();

			logger.info("If click submit button it should redirect to index screen");

		} catch (Exception e) {

			logger.error("If click submit button it should redirect to index screen");

		}
	}

	@Test(priority = 4)

	public void add_depriceation_values() throws InterruptedException {

		try {

			WebElement srch = d.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));

			srch.isDisplayed();

			srch.sendKeys("Damaging");
 
			Thread.sleep(200);

			WebElement filter = d.findElement(By.xpath("//td[@class='sorting_1']"));

			filter.isDisplayed();

			logger.info("Depriceation category  is successfully added");

		} catch (Exception e) {

			logger.error("Depriceation category  is successfully added");

		}

	}

	@BeforeTest
	public void beforeTest() {

		try {

			logger = logger.getLogger(" Habitos - Depreciation");

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			d = new ChromeDriver();

			logger.info("browser gets open");

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);

			d.get("http://192.168.1.230:4000/");

		} catch (Exception e) {

			logger.error("browser gets valid ip address");

		}

	}

	
	@AfterTest
	public void afterTest() {

		d.close();
	}

}
