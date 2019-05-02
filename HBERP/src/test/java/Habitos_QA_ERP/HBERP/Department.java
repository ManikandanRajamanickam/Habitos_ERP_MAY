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
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Department {

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

	// DEPARTMENT

	@Test(priority = 2)

	public void Departments() throws InterruptedException {

		try {

			logger = logger.getLogger(" Habitos - DEPARTMENT");

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			WebElement masters = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			masters.click();

			logger.info("Verify  that if click master menu it getting to collapse");

			d.get("http://192.168.1.230:4000/departments");
		
			
		}

		catch (Exception e) {

			logger.error("Verify  that if click master menu it getting to collapse");

		}	

		
		String url = "http://192.168.1.230:4000/departments";
		
		if (d.getCurrentUrl().equals(url)) {
						
			Thread.sleep(2000);
			
			logger.info("if click department menu it should redirect the related screen");
			
		} else {

			logger.error("if click department menu it should redirect the related screen");
						
		}
				 
	}
				
	@Test(priority = 3)

	public void add_department() {

		try {

			logger = logger.getLogger(" Habitos - DEPARTMENT - ADD");

			WebElement add = d.findElement(By.xpath("//a[@class='btn']"));

			add.click();

			logger.info("If click add button it should redirect to add screen");
			
		} catch (Exception e) {

			logger.error("If click add button it should redirect to add screen");

		}

		
		try {
			
			Thread.sleep(2000);

			WebElement depet = d.findElement(By.xpath("//input[@id='department_name']"));

			depet.sendKeys("Dispatched");

			Thread.sleep(200);
			
			logger.info("Verify that user can enter the department name in input field");
		
		} catch (Exception e) {

			logger.error("Verify that user can enter the department name in input field");

		}

		

			try {
			
			WebElement submit = d.findElement(By.xpath("//input[@value='submit']"));

			Thread.sleep(100);

			submit.click();

			logger.info("If click submit button it should redirect to index screen");
			
		} catch (Exception e) {

			logger.error("If click submit button it should redirect to index screen");

		}

	}

	@Test(priority = 4)

	public void add_department_values() throws InterruptedException {

		try {

			WebElement srch = d.findElement(By.xpath("//input[@type='search']"));

			srch.sendKeys("Dispatched");

			Thread.sleep(200);

			WebElement filter = d.findElement(By.xpath("//td[@class='sorting_1']"));
			
			filter.isDisplayed();

			logger.info("Department is successfully added");

		} catch (Exception e) {

			logger.error("Department is successfully added");

		}

	}

	@BeforeTest

	public void beforeTest() {

		try {

			logger = logger.getLogger(" Habitos - Assets");

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
