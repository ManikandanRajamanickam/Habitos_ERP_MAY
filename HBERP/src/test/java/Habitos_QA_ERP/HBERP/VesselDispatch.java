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
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class VesselDispatch {
	
	WebDriver d;
	
	static org.apache.log4j.Logger logger;
	
	@Test (priority = 1)
	
	public void Valid_Login() {
		
		
		
		d.manage().window().maximize();
		 
		String un = "vivek";
		String pw = "vivek";

		WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
		WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
		WebElement submit = d.findElement(By.name("commit"));

		
		if (uname.equals(d.switchTo().activeElement())) {

			//	logger.info("Verify that if the username fields get autofocus");

				uname.sendKeys(un);

		//		logger.info("Verify that if the user can enter the user name");

				uname.sendKeys(Keys.TAB);

			} else {

				logger.error("Verify that if the user can enter the user name");

			}

			if (pwd.equals(d.switchTo().activeElement())) {

		//		logger.info("Verify that if the password fields get focused");

				pwd.sendKeys(pw);

			} else {

			// 	logger.error("Verify that if the password fields get focused");
			}

			if (submit.isEnabled()) {

			//	 logger.info("Verify that user can login with valid credentials");

				submit.click();

			} else {

			//	logger.error("Verify that user can login with valid credentials");

			}
	}
	
	@Test (priority = 2)
    
	public void master() {
			
		try {

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			WebElement masters = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			masters.click();

			Thread.sleep(2000);

			logger.info("Verify  that if click master menu it getting to collapse");

		}

		catch (Exception e) {

			logger.error("Verify  that if click master menu it getting to collapse");
		}
		
		
		
		try {

		d.get("http://192.168.1.230:4000/vesselplanners/vessel_dispatch");

		// logger.info("verify that if click vessel dispatch menu it should redirect to related screen"); 

		} catch (Exception e) {

		 	logger.error("verify that if click vessel dispatch menu it should redirect to related screen"); 

		}
	
		String url = "http://192.168.1.230:4000/vesselplanners/vessel_dispatch";
		
		if (d.getCurrentUrl().equals(url)) {
			
			
			logger.info("verify that if click vessel dispatch menu it should redirect to related screen"); 
			
			
		} else {
			
			logger.error("verify that if click vessel dispatch menu it should redirect to related screen"); 

		}
		
	 	
	}
		
	@Test (priority = 3)
	
	public void vessel_dispatched() {
				
		// DATE FILETER
		
		try {
			
			Thread.sleep(2000);
				
			WebElement date = d.findElement(By.xpath("//input[@id='date_input']"));
			
			date.isDisplayed();
			
			date.click();
			
			Thread.sleep(200);
			
			WebElement nxtdate = d.findElement(By.xpath("//span[@class='flatpickr-day ']"));
			
			nxtdate.click();
			
			logger.info("Verify that user can click the next date into date picker");
			
			date.sendKeys(Keys.TAB);
					  
			} catch (Exception e) {

			logger.error("Verify that user can click the next date into date picker");
			
			}

		
		// Client Name
		 	
		try {
			
			Thread.sleep(200);

			WebElement date = d.findElement(By.id("clientname"));

			date.click();
			
			date.sendKeys("Vidhya Vikas");

			Thread.sleep(200);

			date.sendKeys(Keys.ENTER);

			logger.info("user can select the client type");

			date.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("user can select the client type");

		}
			
		
		// Meal Course

		try {
			
			Thread.sleep(200);

			WebElement mealcourse = d.findElement(By.id("dispatch_mealcourse"));

			mealcourse.click();

			Thread.sleep(200);

			mealcourse.sendKeys("Br");

			Thread.sleep(200);

			mealcourse.sendKeys(Keys.ENTER);

			logger.info("user can select  the meal course");

		//	mealcourse.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("user can select  the meal course");

		}
				
		// submit
			
			try {

				Thread.sleep(2000);

				WebElement submit = d.findElement(By.name("commit"));

				submit.click();

				Thread.sleep(2000);

				WebElement client = d.findElement(By.xpath("//*[@id=\"quantity\"]"));

				client.isDisplayed();

				logger.info("Verify the client datas is correct or not");

			} catch (Exception e) {

				logger.error("Verify the client datas is correct or not");

			}
}
	
	@Test (priority = 4)
	
	public void splitqty() {

		try {

			Thread.sleep(2000);

			WebElement Midaysnaks = d.findElement(By.xpath("//table[@id='quantity']//tbody"));

			Thread.sleep(200);

			if (Midaysnaks.isDisplayed()) {

				Midaysnaks.click();

				Thread.sleep(200);

				WebElement qty = d.findElement(By.id("qty_"));

				qty.isDisplayed();
				
				qty.click();
				
				for (int i = 0; i <=4; i++) {
					
					qty.sendKeys(Keys.ARROW_LEFT);
					
				}
				
				qty.sendKeys(Keys.BACK_SPACE);

				Thread.sleep(500);

				qty.sendKeys("1");

				Thread.sleep(1000);

				qty.sendKeys(Keys.TAB);

				Thread.sleep(500);

				qty.sendKeys(Keys.TAB);

				logger.info("Verify that user can select the particular utensils");

			}

		} catch (Exception e) {

			logger.error("Verify that user can select the particular utensils");

		}
	}
	
	// VESSEL SELECTING
	
	@Test(priority =4)

	public void vessel_planing() {
			
	// VESSEL PLAN

		try {

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"utensil_id_\"])[2]"));

			uten.click();

			Thread.sleep(200);

			uten.sendKeys("30");

			uten.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that user can select the particular utensils");

		} catch (Exception e) {

			logger.error("Verify that user can select the particular utensils");
		}		
		
		
		// VESSEL ID
				
		try {
			
			
			WebElement uten = d.findElement(By.xpath("(//*[@id=\"tag_id_\"])[2]"));

			uten.click();

			Thread.sleep(200);

			uten.sendKeys(Keys.ARROW_DOWN);
						
			uten.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that user can select the Utensils Id's ");
						
		} catch (Exception e) {
			
			logger.error("Verify that user can select the Utensils Id's ");
	}
		
				
		// SUBMIT BUTTON
		
		
		try {

			WebElement commit = d.findElement(By.xpath("//input[@value='submit']"));

			commit.isDisplayed();

			commit.click();

		} catch (Exception e) {

		}

	}
		
	// WASTAGE ENTER
		
	public void wastagenter() {
		
		try {

			Thread.sleep(3000);

			WebElement wastage = d.findElement(By.xpath("//input[@value='Submit']"));

			wastage.click();

			logger.info("Verify that if click submit button it should redirect to wastage screen automatically");

		} catch (Exception e) {

			logger.error("Verify that if click submit button it should redirect to wastage screen automatically");
		}
		
		// WASTAGE ENTER

		try {

			// wastage 1

			WebElement wage1 = d.findElement(By.xpath("(wastage_)[1]"));
			wage1.click();
			Thread.sleep(200);
			wage1.sendKeys("1kg");

			// Wastage 2

			WebElement wage2 = d.findElement(By.xpath("(wastage_)[2]"));
			wage2.click();
			Thread.sleep(200);
			wage2.sendKeys("2kg");			

			logger.info("verify that user can enter the wastage for particular item");
			
		} catch (Exception e) {

			
			logger.error("verify that user can enter the wastage for particular item");	
			
		}		
			
		// SUBMIT

		try {

			WebElement commit = d.findElement(By.xpath("//input[@value='submit']"));

			commit.isDisplayed();

			commit.click();

			logger.info("Verify that if the user can enter the submit button");

		} catch (Exception e) {

			logger.error("Verify that if the user can enter the submit button");

		}
	}

	@BeforeTest
	
	public void beforeTest() throws InterruptedException {

		try {

			logger = logger.getLogger(" Habitos - Vessel Dispatch");

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");
			
			d = new ChromeDriver();

			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);

			d.get("http://192.168.1.230:4000/");

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
