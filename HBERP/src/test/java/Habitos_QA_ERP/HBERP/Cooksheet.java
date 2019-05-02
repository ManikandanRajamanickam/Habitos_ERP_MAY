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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.annotations.AfterTest;

public class Cooksheet {

	WebDriver d;

	static org.apache.log4j.Logger logger;

	// VALID LOGIN

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

		}
	}

	@Test(priority = 2)

	public void Cook_Sheet() {

		// MENU OPEN

		try {

			Thread.sleep(200);

			WebElement master = d.findElement(By.id("sidebarCollapse"));

			master.click();

			WebElement masterck = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			masterck.click();

			logger.info("verify that if click master menu it should open");

		} catch (Exception e) {

			logger.error("verify that if click master menu it should open");
		}
		

		try {
   
			/*WebElement cooksht = d
					.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Cook Sheet')]"));

			cooksht.click();*/

			Thread.sleep(2000);

			d.get("http://192.168.1.230:4000/menu_customers/cook_sheet_edit");
			
			Thread.sleep(2000);
			
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\maxi.jpg"));

			logger.info("Verify that if click cook sheet it should redirect to related  screen");

		} catch (Exception e) {

			logger.error("Verify that if click cook sheet it should redirect to related  screen");
		}

	}

	@Test(priority = 3)

	public void clientcooksheet() {

		// Values Checking

		try { 
			
			//d.manage().window().maximize();
						
			WebElement date = d.findElement(By.xpath("//input[@id='txtFrom']"));
			
			date.click();
			
			logger.info("Verify that if the date is presented in cook sheet");

			WebElement client = d.findElement(By.xpath("//th[@class='tenant_cooksheet']"));

			Thread.sleep(200);

			logger.info("Verify that if the client name is correctly displayed");

			Thread.sleep(500);

			WebElement mealtime = d.findElement(By.xpath("//th[contains(text(),'Breakfast')]"));

			String brk = "Breakfast";

			logger.info("Verify that if the meal time is correctly displayed");

		} catch (Exception e) {

			/*WebElement submit = d.findElement(By.xpath("//*[@id=\"report\"]"));

			submit.click();*/

			logger.error("Verify that if the cook sheet contain the values");

		}

		// RECEPIE VALUES CHECKING

		try {

			WebElement receipe1 = d.findElement(By.xpath("//td[contains(text(),'Dal Payasam')]"));

			Thread.sleep(200);

			receipe1.isDisplayed();

			logger.info("Verify that if the receipe1 name is correctly displayed in cook sheet");

		} catch (Exception e) {

			logger.error("Verify that if the receipe1 name is correctly displayed in cook sheet");

		}

		try {

			Thread.sleep(200);

			WebElement receipe2 = d.findElement(By.xpath("//td[contains(text(),'Coriander Rice')]"));

			receipe2.isDisplayed();

			logger.info("Verify that if the receipe2 name is correctly displayed in cook sheet");

		}

		catch (Exception e) {
			
			logger.error("Verify that if the receipe2 name is correctly displayed in cook sheet");
		}

		try {

			Thread.sleep(200);

			WebElement receipe3 = d.findElement(By.xpath("//td[contains(text(),'Peanut Salad')]"));

			receipe3.isDisplayed();

			logger.info("Verify that if the receipe3 name is correctly displayed in cook sheet");

		} catch (Exception e) {

			logger.error("Verify that if the receipe3 name is correctly displayed in cook sheet");

		}

	}

	@BeforeTest
	
	public void beforeTest() {

		try {

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			d = new ChromeDriver();

			d.get("http://192.168.1.230:4000/");

			logger.info("browser gets valid ip address");

		}

		catch (Exception e) {

			System.out.println("Login is not working");

		}

	}

	@AfterTest

	public void afterTest() {

		d.close();

	}
}
