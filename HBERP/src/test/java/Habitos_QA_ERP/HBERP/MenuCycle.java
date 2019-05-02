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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

   public class MenuCycle {
	
   WebDriver d;
	
   static org.apache.log4j.Logger logger; 
  
    // VALID LOGIN
	
   @Test (priority = 1) 
   
   public void Valid_Login() {
	  		 	 
	 	 	d.manage().window().maximize();
	 	 
	 		String un = "vivek";
	 		String pw = "vivek";

	 		WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
	 		WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
	 		// WebElement Rme = d.findElement(By.xpath("//*[@id=\"new_kitchen_user\"]/div/div[2]/span/input")); 
	 		WebElement submit = d.findElement(By.name("commit"));

	 		
		if (uname.equals(d.switchTo().activeElement())) {

			uname.sendKeys(un);

			uname.sendKeys(Keys.TAB);

	 		} else {

	 	//		logger.error("Verify that if the user can enter the user name");
	 			
	 		}

	 		if (pwd.equals(d.switchTo().activeElement())) {

	 		//	logger.info("Verify that if the password fields get focused");

	 			pwd.sendKeys(pw);

	 		} else {

	 		//	logger.error("Verify that if the password fields get focused");
	 		
	 		}

	 		
	 		if (submit.isEnabled()) {
	 			
	 			//		logger.info("Verify that user can login with valid credentials");
	 			
	 			submit.click();
	 			
	 						
	 		} else {

	 		//	logger.error("Verify that user can login with valid credentials");
	 			
	 		}
	 		  
	  }
      
   // MENU CYCLE ASSIGN
   
	@Test(priority = 2)

	public void master() throws IOException {

		try {

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			WebElement master = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			master.click();

			logger.info("Verify that if click master menu it getting to collapse");

			Thread.sleep(2000);

		} catch (Exception e) {

			logger.info("Verify that if click master menu it getting to collapse");
		}
	}
   
	
   @Test (priority = 3)
   
	public void menu_cyc() throws IOException {

		try {

			Thread.sleep(2000);

			WebElement menucycle = d.findElement(By.xpath("//a[contains(text(),'Menu Cycle')]"));

			// menucycle.isDisplayed();

			menucycle.click();

			logger.info("Verify  that if click menu cycle it should redirect to related screen");

			/*
			 * String url = "http://192.168.1.230:4000/normalmenu_sites/menu_cycle";
			 * 
			 * if (d.getCurrentUrl().equals(url)) {
			 * 
			 * logger.info("If click menu cycle menu it should redirect to related screen");
			 * 
			 * }
			 */

		} catch (Exception e) {

			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\mc.jpg"));

			logger.error("Verify  that if click menu cycle it should redirect to related screen");
		}
	   
		// EDIT BUTTON
	   	   
		try {

			// Client Filter
			
			d.get("http://192.168.1.230:4000/normalmenu_sites/menu_cycle");
			
			Thread.sleep(200);

			WebElement srch = d.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));

			srch.sendKeys("2day Lunch 24/04");
			
			Thread.sleep(500);

			WebElement row = d.findElement(By.xpath("//td[@class='ng-binding sorting_1']"));

			row.isDisplayed();

			logger.info("If Search the Plan name into search box it should fileter the plan");

		} catch (Exception e) {

			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\mcy.jpg"));

			logger.error("If Search the Plan name into search box it should fileter the plan");

		}
	   
	   // Client Edit
	   
			
		try {

			Thread.sleep(300);

			WebElement edit = d.findElement(By.xpath("//a[contains(text(),'Edit')]"));

			if (edit.isDisplayed()) {

				Thread.sleep(100);

				edit.click();

				Thread.sleep(2000);
				
			}
			
			WebElement title = d.findElement(By.xpath("//h1[@class='planner-title page_title']"));
			
			String Mcycle = "Menu Cycle Assign";
									
			if (title.getText().equals(Mcycle)) {
					
			logger.info("If click edit button it should redirect to related screen");

			}
				
		} catch (Exception e) {

			logger.info("If click edit button it should redirect to related screen");

		}
   }
      
   	// ****************************************** //
   
	@Test (priority = 4)
	
	public void Menu_cyclePlan() {

		// sub plan name

			try {
				
			Thread.sleep(20000);

			WebElement sub_plan = d.findElement(By.id("header_0"));
						
			if (sub_plan.isDisplayed()) {
				
				logger.info("Verify that if sub plan is displayed or not");	
				
				sub_plan.click();
								
			}
			
			Thread.sleep(200);

			WebElement open = d.findElement(By.xpath("//button[@class='btn btn-client ng-binding']"));

			if (open.isDisplayed()) {

				logger.info("Verify that if should open the card while clicking the plan name");

			}

		} catch (Exception e) {

			logger.error("Verify that if should open the card while clicking the plan name");

		}

			// **************************************************************************************************************//
											
		// Tenant Click action

		try {

			Thread.sleep(2000);

			WebElement tenant1 = d.findElement(By.xpath("//button[@class='btn btn-client ng-binding']"));

			if (tenant1.isDisplayed())

			{

				tenant1.click();

				logger.info("Veify that if click tenant name it should open the relared meal card");
			}

		}

		catch (Exception e) {

			logger.error("Veify that tenant name is present");

		}
				

		// Vales Verification _ Client Type
		
		try {

			WebElement ctype = d.findElement(By.xpath("//span[contains(text(),'School')]"));
		
			if (ctype.isDisplayed() && ctype.isEnabled()) {
				
				logger.info("Verify that if the client type is correct");

			}

		} 
		
		catch (Exception e) {

			logger.error("Verify that if the client type is correct");

		}
		
		
		
		// Vales Verification _ Client Category

		try {

			WebElement ccate = d
					.findElement(By.xpath("//span[contains(text(),'Secondary')]"));
			
			if (ccate.isDisplayed() && ccate.isEnabled()) {

				logger.info("Verify that if the client category is correctly displayed");
			}

		} catch (Exception e) {

			logger.error("Verify that if the client category is correctly displayed ");

		}
		
		// Value Verification - Spread Type
		
		
		try {
			
			WebElement Sptype =d.findElement(By.xpath("//span[contains(text(),'3 Spread')]")) ;
			
				
			if (Sptype.isDisplayed() && Sptype.isEnabled()) {
				
				logger.info("Verify that if the spread type is displayed corrected");
			
			}
						
		} catch (Exception e) {

			logger.error("Verify that if the spread type is displayed corrected");

		}
		
								
	}
	
	// ****************************************** //
		
	@Test (priority = 5)
	
	public void Menu_cycle_plan() throws IOException {
					
		// Menu Cycle Assign

		// DATE ASSIGN

			try {
				
			Thread.sleep(200);

			WebElement date = d.findElement(By.xpath("//div[@id='collapse1']//a[@class='ng-scope ng-binding editable editable-click editable-empty'][contains(text(),'Day1')]"));

			date.isDisplayed();

			date.click();

			Thread.sleep(200);
			
			/*WebElement cdate = d.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
			
			cdate.click();*/

			Thread.sleep(200);

			WebElement currentdate = d.findElement(By.xpath("//div[@class='input-group']//input[@type='text']"));
			
			currentdate.click();

			currentdate.sendKeys("24-April-2019");
			
			Thread.sleep(200);

			WebElement tik = d.findElement(By.xpath("//button[@title='Submit']"));

			tik.click();

			Thread.sleep(200);

			logger.info("verify that user can assign the date");

		} catch (Exception e) {

			
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\date.jpg"));

			
			logger.error("verify that user can assign the date");
		}
			 
	// TENANT UPDATE

		try {

			WebElement check = d.findElement(By.xpath("//div[@class='d-flex align-items-center justify-content-between mb-2 ng-scope']//label[@class='checkbox-label']"));

			if (check.isDisplayed()) {

				// System.out.println("check box isn't selected");

				check.click();

				logger.info("verify that if the check box is checked or not");

			}

		} catch (Exception e) {

			logger.error("verify that if the check box is checked or not");

		}
		
	// TENANT UPDATE _ 2

	try {

			Thread.sleep(2000);

			WebElement update = d.findElement(By.xpath("//button[contains(text(),'Update')]"));

			if (update.isDisplayed()) {

				update.click();

				logger.info("User can click the update button");

			}

		} catch (Exception e) {

			logger.error("verify that if the check box is checked or not");

	 }
		 
		// Alert Handling

		try {

			Thread.sleep(2000);

			Alert alert = d.switchTo().alert();

			logger.info("If click update button it should display the alert message");

			Thread.sleep(2000);
			
			alert.accept();
			
			Thread.sleep(3000);

		} catch (Exception e) {

			logger.error(e);

			logger.error("If click update button it should display the alert message");

		}

	}	
	
	/*

	// Tenant Update _ 2

	  try {

		    Thread.sleep(2000);

			WebElement tenant2 = d.findElement(By.xpath("//*[@id=\"client_0\"]/div/div[2]/label/span"));

			tenant2.isDisplayed();

			tenant2.click();

			Thread.sleep(1000);

			WebElement lunch = d.findElement(By.id("collapse0"));

			lunch.isDisplayed();

			lunch.click();

			logger.info("verify that if click Lunch meal course it should open the particular card");

		} catch (Exception e) {

			logger.error("verify that if click Lunch meal course it should open the particular card");

		}
			
		// DATE ASSIGN TENANT 2

		try {

			WebElement date = d
					.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div/table/thead/tr/th[1]/label/span/a"));

			date.isDisplayed();

			date.click();

			Thread.sleep(200);

			WebElement currentdate = d.findElement(By.className("btn btn-default btn-sm active"));

			currentdate.click();

			logger.info("verify that user can select the current date");

		} catch (Exception e) {

			logger.error("verify that user can select the current date");

		}
			
			
		// Check Box checking

		try {

			WebElement check = d
					.findElement(By.xpath("//*[@id=\"collapse0\"]/div/div/table/thead/tr/th[1]/label/input"));

			if (!check.isSelected()) {

				check.click();

				logger.info("Verify that user can able to select the check box");

			} else {

				check.click();

				logger.info("Verify that user can able to selected the check box");

			}

		} catch (Exception e) {

			logger.error("Verify that user can't able to select the check box");

		}
						
		// Check box clicking

		try {

			WebElement nxtdate = d.findElement(By.xpath("//*[@id=\"collapse0\"]/div/div/table/thead/tr/th[2]/label/input"));

			if (!nxtdate.isSelected()) {

				nxtdate.click();

				logger.info("Verify that user can able to check the select all option");

			} else {

				nxtdate.click();

			}

		} catch (Exception e) {

			logger.error("Verify that user can able to check the select all option");

		}
			
			
		// Check box clicking

		try {

			WebElement nxtdate1 = d
					.findElement(By.xpath("//*[@id=\"collapse0\"]/div/div/table/thead/tr/th[3]/label/input"));

			if (!nxtdate1.isSelected()) {

				nxtdate1.click();

				logger.info("Verify that user can able to check the select all option");

			} else {

				nxtdate1.click();

			}

		} catch (Exception e) {

			logger.error("Verify that user can able to check the select all option");

		}
		
			
		// TENANT UPDATE _ 2

		try {

			WebElement check1 = d.findElement(By.xpath("//*[@id=\"client_0\"]/div/div[2]/label/input"));

			if (!check1.isSelected()) {

				System.out.println("Check box isn't selected");

				check1.click();

				logger.info("verify that if the check box is checked or not");

				Thread.sleep(200);

				WebElement update = d.findElement(By.xpath("//*[@id=\"client_0\"]/div/div[2]/button"));

				update.isDisplayed();

				update.click();

			}

			else {

				check1.click();

			}

		} catch (Exception e) {

			logger.error("verify that if the check box is checked or not");

		}

		// Alert Handling

		try {

			d.switchTo().alert().accept();

		} catch (Exception e) {

			logger.error(e);

		}

	}

*/
    
	// ****************************************** //
      
	@BeforeTest

	public void beforeTest() {

		try {

			

			logger = logger.getLogger(" Habitos - Menu Cycle");

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			  d = new ChromeDriver();

			logger.info("browser gets open");

			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);
		
			d.get("http://192.168.1.230:4000/");

			//	logger.info("browser gets valid ip address");

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
