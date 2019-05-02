package Habitos_QA_ERP.HBERP;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AssignedMenu {

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

			// logger.info("Verify that if the username fields get autofocus");

			uname.sendKeys(un);

			// logger.info("Verify that if the user can enter the user name");

			uname.sendKeys(Keys.TAB);

		} else {

			logger.error("Verify that if the user can enter the user name");

		}

		if (pwd.equals(d.switchTo().activeElement())) {

			// logger.info("Verify that if the password fields get focused");

			pwd.sendKeys(pw);

		} else {

			// logger.error("Verify that if the password fields get focused");
		}

		if (submit.isEnabled()) {

			// logger.info("Verify that user can login with valid credentials");

			submit.click();

		} else {

			// logger.error("Verify that user can login with valid credentials");

		}
	}

	@Test(priority = 2)

	public void sidebar() throws InterruptedException {

		try

		{
			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			logger.info("Verify  that if click master menu it getting to collapse");

			WebElement crm = d.findElement(By.xpath("//span[contains(text(),'CRM')]"));

			crm.click();

			Thread.sleep(2000);

			WebElement asmenu = d.findElement(By.xpath("//a[contains(text(),'Assigned Menu')]"));

			asmenu.isDisplayed();

			asmenu.click();

			Thread.sleep(2000);

			String url = "http://192.168.1.18:4000/assigned_menu";

			if (d.getCurrentUrl().equals(url)) {

				logger.info("if click department menu it should redirect the related screen");

			}

		}

		catch (Exception e) {

			logger.error("if click department menu it should redirect the related screen");

		}

	}

	@Test(priority = 3)

	public void assinged() throws InterruptedException {

		try {

			Thread.sleep(200);

			WebElement date = d.findElement(By.xpath("//input[@id='date_range']"));
			date.click();

			logger.info("Verify  that if click date picker it should open the calender");

			Thread.sleep(200);
 
			WebElement fdate = d.findElement(By.xpath(" //div[@class='flatpickr-days']//span[2]"));

			fdate.click();

			Thread.sleep(2000);

			WebElement tdate = d.findElement(By.xpath("//span[contains(text(),'30')]"));

			tdate.isDisplayed();

			tdate.click();

			Thread.sleep(2000);

			date.sendKeys(Keys.TAB);

		}

		catch (Exception e) {

			logger.error("Verify  that if click date picker it should open the calender");

		}

		// CLIENT SELECT

		try {

			WebElement cname = d.findElement(By.xpath("//select[@name='client_name']"));

			Thread.sleep(2000);

			cname.click();

			WebElement bharathi = d.findElement(By.xpath("//option[contains(text(),'Vidhya Vikas School')]"));

			bharathi.click();

			logger.info("Verify that user can click the client name using drop down menu");

		} catch (Exception e) {

			logger.error("Verify that user can click the client name using drop down menu");

		}

		// DATA VERIFYING

		try {

			WebElement cname = d.findElement(By.xpath("//h4[contains(text(),'Vidhya Vikas School')]"));

			String name = "Vidhya Vikas School";

			String cnm = cname.getText().toString();

			if (cname.getText().equals(name)) {

				System.out.println(cnm);

				logger.info("Verify that if the assigned menu details are properly displayed");

			}

		} catch (Exception e) {

			logger.error("Verify that if the assigned menu details are properly displayed");

		}

		// EMAIL SENDING

		try {

			Thread.sleep(2000);

			System.out.println("E-mail testing");

			WebElement email = d.findElement(By.id("mailable_email_id"));

			String emailid = "manikandan.rajamanickam@adcltech.com";

			String gett = email.getText().toString();

			if (email.isDisplayed()) {

				System.out.println(gett);

				logger.info("Verify that if the client email id correctly displayed");

				Thread.sleep(200);

				WebElement ebutton = d.findElement(By.xpath("//button[@id='send_email_btn']"));

				if (ebutton.isDisplayed() && ebutton.isEnabled()) {

					Thread.sleep(200);

					email.clear();

					Thread.sleep(200);

					ebutton.click();

					Thread.sleep(200);

					WebElement alert = d.findElement(By.xpath("//div[@class='swal2-popup swal2-modal swal2-show']"));

					alert.isDisplayed();

					Thread.sleep(200);

					WebElement ok = d.findElement(By.xpath("//div[@class='swal2-actions']//button[1]"));

					ok.click();

					Thread.sleep(200);

					email.click();

					Thread.sleep(200);

					email.sendKeys("manikandan.rajamanickam@adcltech.com");

					ebutton.click();

					Thread.sleep(5000);

					email.click();

					Thread.sleep(5000);

					WebElement sending = d.findElement(By.xpath("//div[@id='snackbar']"));

					String mssg = sending.getText().toString();

					Thread.sleep(3000);

					String msg = "Mail sent successfully";

					AssertJUnit.assertEquals(mssg, msg);

					logger.info("Verify that if the mail is successfully sent or not");

				}

			}

		} catch (Exception e) {

			logger.error("Verify that if the client email id correctly displayed");

		}

	}

	@BeforeTest

	public void beforeTest() {

		try {

			logger = logger.getLogger(" Habitos - Assigned Menu");

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");
			
			d = new ChromeDriver();

			// logger.info("browser gets open");

			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);

			d.get("http://192.168.1.230:4000");

		}

		catch (Exception e) {

			logger.error("browser isn't open");

		}
	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		Thread.sleep(3000);

		d.close();

	}

}
