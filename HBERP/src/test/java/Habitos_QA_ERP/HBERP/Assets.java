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
import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Assets {

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

	@Test(priority = 2)

	public void Assets() {

		try {

			logger = logger.getLogger(" Habitos - Assets");

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();
			
			Thread.sleep(200);
		  
			WebElement facility = d.findElement(By.xpath("//span[contains(text(),'Facility Management')]"));
			
			facility.isDisplayed();
			
			facility.click();
			
			logger.info("Verify that if click facility menu it should opent the menu");

			
		} catch (Exception e) {

			logger.error("Verify that if click facility menu it should opent the menu");

		}
			
		
		try {

			Thread.sleep(2000);

			WebElement utensils = d.findElement(By.xpath("//a[contains(text(),'Assets')]"));

			utensils.isDisplayed();

			utensils.click();

			Thread.sleep(2000);

			logger.info("Verify that if click asset menu it should redirect to related  screen");

		} catch (Exception e) {

			logger.error("Verify that if click asset menu it should redirect to related  screen");

		}
		 			   
	}
	   
	// ADD ASSET - 1
	
	@Test(priority = 3)

	public void Add_Assets() throws InterruptedException {

		// Add Assets

		try {

			WebElement add = d.findElement(By.xpath("//a[@class='btn']"));

			add.isDisplayed();

			add.click();

			logger.info("Verify that if the add button is present ");

		} catch (Exception e) {

			logger.error("Verify that if the add button is present ");

		}
			
		d.get("http://192.168.1.230:4000/utensils/new");
		
		 String url = "http://192.168.1.230:4000/utensils/new";
		
		if ( d.getCurrentUrl().equals(url)) {
  
			logger.info("If click add button is should redirect to add new screen");

			
		} else {
			
			logger.error("If click add button is should redirect to add new screen");

		}
		
		
		// Facility Add

		try {

			logger = logger.getLogger(" Habitos - Assets - Add");

			Thread.sleep(200);

			WebElement facility = d.findElement(By.xpath("//select[@id='utensil_kitchen_id']"));

			facility.isDisplayed();

			facility.click();

			Thread.sleep(200);

			facility.sendKeys("i");

			Thread.sleep(200);

			facility.sendKeys(Keys.ENTER);

			facility.sendKeys(Keys.TAB);
 
			logger.info("Verify that user can select the facility name");
			

		} catch (Exception e) {

			logger.error("Verify that user can select the facility name");

		}

		// Department

		try {

			WebElement dept = d.findElement(By.xpath("//select[@id='type1']"));

			dept.click();

			Thread.sleep(200);

			dept.sendKeys("D");

			String depart = "Dispatched";

			dept.sendKeys(Keys.TAB);

			Thread.sleep(200);

			dept.sendKeys(Keys.TAB);
		 
			logger.info("Verify that user can select the Department");
			
		} catch (Exception e) {

			logger.error("Verify that user can select the Department");

		}

		// Depriciation Category

		try

		{

			WebElement depr = d.findElement(By.xpath("//select[@id='dep_cat']"));

			depr.isDisplayed();

			depr.click();

			Thread.sleep(200);

			depr.sendKeys("da");

			Thread.sleep(200);

			depr.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			depr.sendKeys(Keys.TAB);

			Thread.sleep(200); 

			logger.info("Verify that if the user can select the depriciation category");

		} catch (Exception e) {

			logger.error("Verify that if the user can select the depriciation category");

		}

		// DEP Percentage
		
		WebElement pervalue = d.findElement(By.xpath("//input[@id='dep_per']"));

		String values = "25.0";

		if (pervalue.getText().equals(values)) {

			Thread.sleep(200);

			logger.info("Verify that if select depriciation category it should get depriceation percentage automatically");

		} else {

			logger.info("Verify that if select depriciation category it should get depriceation percentage automatically");

		}
		
				
		// TRACKING Status

		try {

			Thread.sleep(2000);

			WebElement cate = d.findElement(By.xpath("//span[contains(text(),'Transit')]"));

			 cate.isDisplayed();

			cate.click(); 

			Thread.sleep(200);
			
			// cate.sendKeys(Keys.TAB);

			logger.info("if click transit it should select the ratio button");
			

		} catch (Exception e) {

			logger.error("if click transit it should select the ratio button");

		}

		// Ventor

		try {

			WebElement ven = d.findElement(By.xpath("//input[@id='utensil_vendor']"));

			ven.isDisplayed();
 
			ven.click();

			Thread.sleep(200);

			ven.sendKeys("QA");

			logger.info("Verify that user can select the depriciation category");

			// ven.sendKeys(Keys.TAB);

			Thread.sleep(200);

		} catch (Exception e) {

			logger.error("Verify that user can select the depriciation category");

		}
 
		// Utensils Names

		try {

			WebElement ven = d.findElement(By.xpath("//select[@id='utensil_utensilname_id']"));

			//ven.isDisplayed();

			ven.click();

			Thread.sleep(200);

			/*
			 * WebElement vessel =
			 * d.findElement(By.xpath("//option[contains(text(),'30 Ltr Hot pack')]"));
			 * 
			 * vessel.click();
			 */

			ven.sendKeys("30");

			Thread.sleep(200);

			ven.sendKeys(Keys.ENTER);

			logger.info("Verify that user can able to select the utensils name");

		}

		catch (Exception e) {

			logger.error("Verify that user can able to select the utensils name");

		}
		
		
		try {
			
			Thread.sleep(200);			
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			
			Thread.sleep(200);
			
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			
			logger.info("Verify that if the page scroll is working");
			
		} catch (Exception e) {
			
			logger.info("Verify that if the page scroll is working");
		}
		
		
		// BODY WEIGHT

		try {
			
			Thread.sleep(200);

			WebElement ven = d.findElement(By.id("utensil_tare_weight"));

			Thread.sleep(200);

			ven.click();

			ven.sendKeys("750 g");

			logger.info("Verify that user can enter the utensil body wight ");
			
		}

		catch (Exception e) {

			logger.error("Verify that user can enter the utensil body wight ");

		}

		
		// Lid Weight

		try {

			WebElement lid = d.findElement(By.id("utensil_lid_weight"));

			Thread.sleep(200);

			lid.click();

			lid.sendKeys("750 g");

			Thread.sleep(200);

			//	lid.sendKeys(Keys.TAB);
			
			logger.info("Verify that user can enter the utensil Lid Weight");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the utensil Lid Weight");

		}

		// PRICE DETAILS

		try {

			WebElement ven = d.findElement(By.xpath("//input[@name='utensil[price]']"));

			Thread.sleep(200);

			ven.sendKeys("1200");

			ven.sendKeys(Keys.TAB);

			Thread.sleep(200); 
			
			logger.info("Verify that user can enter the  utensils price");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the  utensils price");

		}

		// COUNT

		try {

			WebElement ven = d.findElement(By.xpath("//input[@id='utensil_count']"));

			Thread.sleep(200);

			ven.sendKeys("20");

			ven.sendKeys(Keys.TAB);

			Thread.sleep(200); 
			 
			logger.info("Verify that user can enter the utensils count");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the utensils count");

		}

		// SUBMIT

		try {

			WebElement submit = d.findElement(By.xpath("//input[@value='Submit']"));

			Thread.sleep(200);

			// submit.isDisplayed();

			submit.click();

			logger.info("User can able click the submit button");

		}

		catch (Exception e) {

			logger.error("User can able click the submit button");

		}

	}

	// ASSET VAULE CHECK

	@Test(priority = 4)

	public void asset_value() {

		try {

			String url = "http://192.168.1.230:4000/utensils";
			
			d.get("http://192.168.1.230:4000/utensils");
			
			Thread.sleep(2000);
			
			WebElement srch = d.findElement(By.xpath("//input[@type='search']"));

			srch.isDisplayed();

			srch.sendKeys("30 Ltr");

			Thread.sleep(200);

			String asset = "30 Ltr Hor pack";

			WebElement filter = d.findElement(By.xpath("//td[contains(text(),'30 Ltr Hot Pack')]"));

			filter.isDisplayed();

			logger.info("Asset is successfully added");

		} catch (Exception e) {

			logger.error("Asset is not successfully added");

		}

	}

	// ADD ASSET - 2
	
	@Test(priority = 5)

	public void Add_Assets_2() {

	// Add Button  
				
		try {

			WebElement add = d.findElement(By.xpath("//a[@class='btn']"));

			add.isDisplayed();

			add.click();
 
			logger.info("If click add button is should redirect to add new screen");

		} catch (Exception e) {

			logger.error("If click add button is should redirect to add new screen");

		}
		
		// Facility Add

		try {

			logger = logger.getLogger(" Habitos - Assets - Add");

			Thread.sleep(200);

			WebElement facility = d.findElement(By.xpath("//select[@id='utensil_kitchen_id']"));

			facility.click();

			Thread.sleep(200);

			facility.sendKeys("i");

			Thread.sleep(200);

			facility.sendKeys(Keys.ENTER);

			logger.info("Verify that user can select the facility name");

			facility.sendKeys(Keys.TAB);

			Thread.sleep(200);

			facility.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("Verify that user can select the facility name");

		}

		// Department

		try {

			WebElement dept = d.findElement(By.xpath("//select[@id='type1']"));

			dept.click();

			Thread.sleep(200);

			dept.sendKeys("D");

			logger.info("Verify that user can select the Department");

			dept.sendKeys(Keys.TAB);

			Thread.sleep(200);

			dept.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("Verify that user can select the Department");

		}

		
		// Depriciation Category

		try

		{

			WebElement depr = d.findElement(By.xpath("//select[@id='dep_cat']"));

			depr.click();

			Thread.sleep(200);

			depr.sendKeys("da");

			Thread.sleep(200);

			depr.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			logger.info("Verify that if the user can select the depriciation category");

			depr.sendKeys(Keys.TAB);

			Thread.sleep(200);

			depr.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("Verify that user can select the depriciation category");

		}

		// DEP Percentage

		try {

			Thread.sleep(2000);

			WebElement pervalue = d.findElement(By.xpath("//input[@id='dep_per']"));

			String values = "25.0";

			Thread.sleep(200);

			logger.info(
					"Verify that if click depriciation category it should get depriceation percentage automatically");

		}

		catch (Exception e) {

			logger.error(
					"Verify that if click depriciation category it should get depriceation percentage automatically");

		}

		// TRACKING Status

		try {

			Thread.sleep(2000);

			WebElement cate = d.findElement(By.xpath("//span[contains(text(),'Internal')]"));

			//cate.isDisplayed();

			cate.click();

			Thread.sleep(200);

			logger.info("if click transit it should select the ratio button");

			cate.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.info("if click transit it should select the ratio button");

		}

		// Ventor

		try {

			WebElement ven = d.findElement(By.xpath("//input[@id='utensil_vendor']"));

			if (ven.isDisplayed()) {

				ven.click();

				Thread.sleep(200);

				ven.sendKeys("QA");

				logger.info("Verify that user can select the depriciation category");

				ven.sendKeys(Keys.TAB);

				Thread.sleep(200);

			}

		} catch (Exception e) {

			logger.error("Verify that user can select the depriciation category");

		}

		// Utensils Names

		try {

			WebElement ven = d.findElement(By.xpath("//select[@id='utensil_utensilname_id']"));

			if (ven.isDisplayed()) {

				ven.click();

				Thread.sleep(200);

				ven.sendKeys("21");

				Thread.sleep(200);

				ven.sendKeys(Keys.ENTER);

				WebElement uname = d.findElement(By.id("utensil_utensilname_id"));

				String utensilname = "30 Ltr Hot pack";

				if (uname.getText().equals(utensilname)) {

					uname.click();

					logger.info("Verify that user can able to select the utensils name");

				}

			}

		}

		catch (Exception e) {

			logger.error("Verify that user can able to select the utensils name");

		}

		// BODY WEIGHT

		try {

			WebElement ven = d.findElement(By.xpath("//input[@id='utensil_tare_weight']"));

			Thread.sleep(200);

			ven.click();

			ven.sendKeys("750 g");
			
			logger.info("Verify that user enter the utensils body weights");

		}

		catch (Exception e) {

			logger.error("Verify that user enter the utensils body weights");

		}

		// Lid Weight

		try {

			WebElement lid = d.findElement(By.xpath("//input[@id='utensil_lid_weight']"));

			Thread.sleep(200);

			lid.click();

			lid.sendKeys("750 g");

			Thread.sleep(200);

			lid.sendKeys(Keys.TAB);
			
			logger.info("Verify that user can enter the  utensils Lid Weight");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the  utensils Lid Weight");

		}

		// PRICE DETAILS

		try {

			WebElement ven = d.findElement(By.xpath("//input[@name='utensil[price]']"));

			Thread.sleep(200);

			ven.sendKeys("1200");

			ven.sendKeys(Keys.TAB);

			Thread.sleep(200);

			ven.sendKeys(Keys.TAB);
			
			logger.info("Verify that user can enter the utensils price amount");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the utensils price amount");

		}

		// COUNT

		try {

			WebElement ven = d.findElement(By.xpath("//input[@id='utensil_count']"));

			Thread.sleep(200);

			ven.sendKeys("20");

			ven.sendKeys(Keys.TAB);

			Thread.sleep(200);

			ven.sendKeys(Keys.TAB);
			
			logger.info("Verify that user can enter the utensils count");

		}

		catch (Exception e) {

			logger.error("Verify that user can enter the utensils count");

		}

		
		// SUBMIT

		try {

			WebElement submit = d.findElement(By.xpath("//input[@value='Submit']"));

			Thread.sleep(200);

			if (submit.isDisplayed() && submit.isEnabled()) {

				submit.click();

				logger.info("User can able click the submit button");

			}

		}

		catch (Exception e) {

			logger.error("User can able click the submit button");

		}

	}
		 
	// ASSET EDIT
		
	 @Test (priority = 6)
	 
	 public void Asset_Edit() {
	 
		try {

			logger = logger.getLogger(" Habitos - Asset -  update");

			WebElement filter = d.findElement(By.xpath("//input[@type='search']"));

			filter.click();

			Thread.sleep(2000);

			filter.sendKeys("21 Ltr");

			WebElement asset_edit = d.findElement(By.xpath("//td[@class='sorting_1']"));

			asset_edit.click();

			Thread.sleep(2000);

			logger.info("Verify that can search the asset name using searching box");

		} catch (Exception e) {

			logger.error("Verify that can search the asset name using searching box");

		}

		// Assets status click

		try {

			WebElement status = d.findElement(By.xpath("//i[@title='Status']"));

			status.isDisplayed();

			status.click();

			logger.info("If click asset status  button it should redirect to related screen");

			Thread.sleep(200);

		} catch (Exception e) {

			logger.error("If click asset status  button it should redirect to related screen");

		}

		// Status Add

		try {

			Thread.sleep(200);

			WebElement add = d.findElement(By.xpath("//a[@class='btn']"));
			add.click();

			logger.info("Verify that if click add button it should redirect to related screen");

			Thread.sleep(200);

			WebElement date = d.findElement(By.xpath("//input[@id='status_date']"));
			date.click();

			Thread.sleep(200);

			date.sendKeys("22042019");

			Thread.sleep(200);
			date.sendKeys(Keys.TAB);

		} catch (Exception e) {

			logger.error("Verify that if click add button it should redirect to related screen");

		}
	 
		// Utensil Name

		try {

			WebElement utname = d.findElement(By.xpath("//select[@id='status_Utensilname']"));
			utname.click();

			Thread.sleep(200);

			utname.sendKeys("21");

			utname.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			utname.sendKeys(Keys.TAB);

			logger.info("Verify that user can select the utensils name");

		} catch (Exception e) {

			logger.error("Verify that user can select the utensils name");
		}

		// Kitchen Name

		try {

			WebElement sfrom = d.findElement(By.xpath("//select[@id='status_From']"));

			sfrom.click();

			Thread.sleep(200);

			sfrom.sendKeys("I");

			sfrom.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			sfrom.sendKeys(Keys.TAB);

			logger.info("Verify that user can select the Kitchen  name");

		} catch (Exception e) {

			logger.error("Verify that user can select the Kitchen  name");

		}

		// COUNT

		try {

			WebElement qty = d.findElement(By.xpath("//input[@id='qty']"));

			qty.click();

			Thread.sleep(200);

			qty.sendKeys("10");

			Thread.sleep(200);

			qty.sendKeys(Keys.TAB);

			logger.info("Verify that user can Enter the Count");

		} catch (Exception e) {

			logger.error("Verify that user can Enter the Count");

		}

		// STAUTS

		try {

			WebElement status = d.findElement(By.xpath("//select[@id='status_type']"));

			status.click();

			Thread.sleep(200);

			status.sendKeys("Ma");

			Thread.sleep(200);

			status.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			status.sendKeys(Keys.TAB);

			logger.info("Verify that user can Enter the Count");

		} catch (Exception e) {

			logger.error("Verify that user can Enter the Count");

		}

		// SUBMIT

		try {

			WebElement submit = d.findElement(By.xpath("//input[@value='Save']"));

			if (submit.isDisplayed() && submit.isEnabled()) {

				Thread.sleep(200);

				submit.click();

				logger.info("Verify that user can Click the submit button");

			}

		} catch (Exception e) {

			logger.error("Verify that user can Click the submit button");

		}

		try {

			WebElement mainte = d.findElement(By.xpath("//td[contains(text(),'Maintainence')]"));

			mainte.isDisplayed();

			logger.info("Verify that it successfully add the status");

		} catch (Exception e) {

			logger.error("Verify that it successfully add the status");

		}
	 
	 }
		
	 @Test (priority =7)
	 
	 public void assets_Edits() {
	 
	 try {
	 
	 Thread.sleep(200);
	 
	 WebElement srch = d.findElement(By.xpath("//input[@type='search']"));
	 
	 srch.isDisplayed();
	 
	 srch.sendKeys("21 Ltr");
	 
	 Thread.sleep(200);
	 
	 WebElement filter = d.findElement(By.xpath("//td[contains(text(),'Maintainence')]"));
	 
	 filter.click();
	 
	 Thread.sleep(2000);
	 
	 WebElement asset_edit = d.findElement(By.xpath("//i[@class='far fa-edit']"));
	 
	 asset_edit.click();
	 
	 logger.info("If click edit button it should redirect to related screen");
	 
	 Thread.sleep(200);
	 
	 
	 } catch (Exception e) {
	 
	 logger.error("If click edit button it should redirect to related screen");
	 
	 }
	 
	 }
	 	 
	 @Test (priority = 8)
	 
	 public void Asset_Trackings1()
	 
	 {
	 
	 // Kitchen Name
	 
	 try {
	 
	 Thread.sleep(2000);
	 
	 WebElement sfrom = d.findElement(By.xpath("//input[@id='movable_qty']"));
	 
	 sfrom.click();
	 
	 Thread.sleep(200);
	 
	 sfrom.sendKeys("5");
	 
	 Thread.sleep(200);
	 
	 WebElement mstatus = d.findElement(By.xpath("//select[@id='movable_status']"));
	 
	 mstatus.click();
	 
	 Thread.sleep(200);
	 
	 mstatus.sendKeys("I");
	 
	 mstatus.sendKeys(Keys.ENTER);
	 
	 logger.info("Verify that user can change status maintenace into  Inhouse");
	 
	 } catch (Exception e) {
	 
	 logger.error("Verify that user can change status maintenace into  Inhouse");
	 
	 }
	 
	 // SUBMIT
	 
	 try {
	 
	 WebElement submit = d.findElement(By.name("commit"));
	 
	 if (submit.isDisplayed() && submit.isEnabled()) {
	 
	 Thread.sleep(200);
	 
	 submit.click();
	 
	 logger.
	 info("Verify that if change the status it should affect the assets staus and count"
	 );
	 
	 }
	 
	 } catch (Exception e) {
	 
	 logger.
	 error("Verify that if change the status it should affect the assets staus and count"
	 );
	 
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
