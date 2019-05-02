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
import java.util.Date;
import org.testng.annotations.Test;
import org.testng.annotations.Test;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterTest;

    public class VesselPlanner {
	
	WebDriver d;
	
	static org.apache.log4j.Logger logger; 
	
	// VALID LOGIN

	@Test(priority = 1)

	public void Valid_Login() {

		d.manage().window().maximize();

		String un = "vivek";
		String pw = "vivek";

		WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
		WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
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

	public void vessels_plan() throws InterruptedException {

		try {

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			WebElement masters = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			masters.click();

			logger.info("Verify  that if click master menu it getting to collapse");

		} catch (Exception e) {

			logger.error("Verify  that if click master menu it getting to collapse");

		}
			
				 
			Thread.sleep(2000);
			
			d.get("http://192.168.1.230:4000/vesselplanners/new1");
			
			String url = "http://192.168.1.230:4000/vesselplanners/new1";

			if (d.getCurrentUrl().equals(url)) {

				logger.info("Verify that if click menu planner menu it should redirect to menu planner screen");

			} else {

				logger.error("Verify that if click menu planner menu  it should redirect to menu planner screen");
			}
	
	}
	
	
	@Test(priority = 3)
	
	public void countcheck() {

		try {

			WebElement count = d.findElement(By.xpath("//a[contains(text(),'Planned:')]"));

			String cnt = count.getText().toString();

			System.out.println(cnt); 

		} catch (Exception e) {

			System.out.println("Cont able to find the planned count");

		}

	}

	@Test(priority = 4)

	public void Vessels_planned() {

		// Vessels planning

		// Date filter

		try {

		 
			Thread.sleep(2000);

			WebElement datefield = d.findElement(By.xpath("//input[@placeholder='dd-mm-yyyy']"));
			
			datefield.click();
	
			Thread.sleep(200);
	 
			WebElement currentdate = d.findElement(By.xpath("//span[@class='flatpickr-day ']"));

			Thread.sleep(200);
			
			currentdate.click();
			
			//System.out.println(currentdate); 
			
			logger.info("Verify that user can click the date into date picker");

			//currentdate.sendKeys(Keys.TAB);

			} catch (Exception e) {

				System.out.println(e);
				
			logger.error("Verify that user can click the date into date picker");
			
			}

			
		// Client Name

			
		try {
 
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

			WebElement mealcourse = d.findElement(By.xpath("//select[@id='vessel_mealcourse']"));

			mealcourse.click();

			Thread.sleep(200);

			mealcourse.sendKeys("Br");

			Thread.sleep(200);

			mealcourse.sendKeys(Keys.ENTER);

			logger.info("user can select  the meal course");

			mealcourse.sendKeys(Keys.TAB);

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

	// QTY SPLIT

	@Test(priority = 5)

	public void qtysplit() {

			try {

				Thread.sleep(2000);

				WebElement Midaysnaks = d.findElement(By.xpath("//form[@action='/vesselplanners/index1']"));

				Thread.sleep(200);

				Midaysnaks.isDisplayed();

				Midaysnaks.click();

				Thread.sleep(200);

				WebElement qty = d.findElement(By.id("qty_"));

				qty.isDisplayed();

				for (int i = 0; i <= 4 ; i++) {

					qty.sendKeys(Keys.ARROW_LEFT);

					// Thread.sleep(300);

				}

				qty.sendKeys(Keys.BACK_SPACE);

				Thread.sleep(500);

				qty.sendKeys("2");

				Thread.sleep(500);

				qty.sendKeys(Keys.TAB);

				logger.info("Verify that user can select the particular utensils");

			

		} catch (Exception e) {

			logger.error("Verify that user can select the particular utensils");

		}
	}

	// VESSEL SELECTING

	@Test(priority = 6)

	public void vessel_planing() {

		// VESSEL PLAN

		try {

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"utensilname_\"])[1]"));

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

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"tag_id_\"])[1]"));

			uten.click();

			Thread.sleep(200);

			uten.sendKeys(Keys.ARROW_DOWN);

			uten.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that user can select the Utensils Id's ");

		} catch (Exception e) {

			logger.error("Verify that user can select the Utensils Id's ");
		}

	}

	@Test(priority = 7)

	public void vessel_planing2() {

		// Vessel plan 1

		try {

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"utensilname_\"])[2]"));

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

			for (int i = 0; i <= 1; i++) {

				uten.sendKeys(Keys.ARROW_DOWN);
			}

			uten.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that user can select the Utensils Id's ");

		} catch (Exception e) {

			logger.error("Verify that user can select the Utensils Id's ");
		}
	}

	@Test(priority = 8)

	public void vessel_planing3() {

		// Vessel plan 1

		try {

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"utensilname_\"])[3]"));

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

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"tag_id_\"])[3]"));

			uten.click();

			Thread.sleep(200);

			for (int i = 0; i <= 1; i++) {

				uten.sendKeys(Keys.ARROW_DOWN);
			}

			uten.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that user can select the Utensils Id's ");

		} catch (Exception e) {

			logger.error("Verify that user can select the Utensils Id's ");
		}

	}

	@Test(priority = 9)

	public void vessel_planing4() {	
				
		// Vessel plan 1

		try {

			WebElement uten = d.findElement(By.xpath("(//*[@id=\"utensilname_\"])[4]"));

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
		
		
		WebElement uten = d.findElement(By.xpath("(//*[@id=\"tag_id_\"])[4]"));

		uten.click();

		Thread.sleep(200);

		for (int i = 0; i <=1; i++) {
			
			uten.sendKeys(Keys.ARROW_DOWN);
		}
					
		uten.sendKeys(Keys.ENTER);

		Thread.sleep(200);

		logger.info("Verify that user can select the Utensils Id's ");
					
	} catch (Exception e) {
		
		logger.error("Verify that user can select the Utensils Id's ");
	}
	
}	

	@Test(priority = 10)

	public void Plannedcountcheck() {

		try {

			WebElement count = d.findElement(By.xpath("//a[contains(text(),'Planned:')]"));

			String Aplanned = count.getText().toString();

			System.out.println(Aplanned);

		
			// SUBMIT
	
			WebElement commit = d.findElement(By.xpath("//input[@value='submit']"));

			if (commit.isDisplayed() && commit.isEnabled()) {

				commit.click();

				logger.info("Verify that if user can click the submit button");

			}
			
			WebElement count1 = d.findElement(By.xpath("//a[contains(text(),'Planned:')]"));

			String Aplanned1 = count.getText().toString();

			System.out.println(Aplanned1);
						
			Thread.sleep(2000);
			

		}

			catch (Exception e) {
				
			logger.error("Verify that if user can click the submit button");

			logger.error("Can't able to planning the vessels");
			
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
  
  public void afterTest() throws InterruptedException {
	  
		Thread.sleep(2000);

		d.close();

  
  }

}
