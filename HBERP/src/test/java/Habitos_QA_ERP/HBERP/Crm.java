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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Crm {
	
WebDriver driver;	

static org.apache.log4j.Logger logger;

@BeforeTest

public void beforeTest()  {
	   
		try {

			logger = logger.getLogger(" Habitos - CRM ");

			PropertyConfigurator.configure("log4jproperties.txt");
			
			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			driver = new ChromeDriver();
				
			Thread.sleep(1000);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(2000);

			driver.get("http://192.168.1.230:4000");

		}

		catch (Exception e) {
		
			logger.error("Browser isn't open");

		}
		
}

 // VALID LOGIN
	
 @Test (priority = 1)
 
 public void Valid_Login() throws InterruptedException {
 	
	 logger = logger.getLogger("Habitos - CRM");
	 
	 driver.manage().window().maximize();
	 
		String un = "vivek";
		String pw = "vivek";

		WebElement uname = driver.findElement(By.id("kitchen_user_user_name"));
		WebElement pwd = driver.findElement(By.id("kitchen_user_password_digest"));
		// WebElement Rme = d.findElement(By.xpath("//*[@id=\"new_kitchen_user\"]/div/div[2]/span/input")); 
		WebElement submit = driver.findElement(By.name("commit"));

		if (uname.equals(driver.switchTo().activeElement())) {

			uname.sendKeys(un);

			uname.sendKeys(Keys.TAB);

		} else {

			// logger.error("Verify that if the user can enter the user name");

		}

		if (pwd.equals(driver.switchTo().activeElement())) {

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
 
 // INDEX PAGE
	
 @Test (priority = 2)
 
	public void crm_info() {

		try {

			logger = logger.getLogger("Habitos - CRM _ INFO");
 
			Thread.sleep(2000);

			WebElement collapse = driver.findElement(By.xpath("//a[@id='sidebarCollapse']"));
			collapse.click();

			Thread.sleep(500);

			WebElement crm = driver.findElement(By.xpath("//span[contains(text(),'CRM')]"));
			crm.click();

			Thread.sleep(500);

			WebElement crminfo = driver.findElement(By.xpath("//a[contains(text(),'CRM Info')]"));
			crminfo.click();

			logger.info("Verify that if click CRM info it should redirect to crm info index screen ");

		} catch (Exception e) {

			System.out.println(e);

			logger.error("Verify that if click CRM info it should redirect to crm info index screen ");

			System.out.println("crm info screen");
		}

	}
  
/*  // ADD- CLIENT

 @Test (priority = 3)
 
 public void crm_info_add() {

		try

		{
			logger = logger.getLogger("Habitos - CRM _ INFO - ADD");

			WebElement Add = driver.findElement(By.xpath("//a[@class='btn']"));

			Add.isDisplayed();

			Thread.sleep(200);

			Add.click();

			logger.info("Verify that if click add new button it should redirect to add new screen");

		} catch (Exception e) {

			logger.error("Verify that if click add new button it should redirect to add new screen");

		}

	
		try {

			// customer name

			logger = logger.getLogger("Habitos - CRM _ INFO - ADD");
			
			WebElement cname = driver.findElement(By.id("tenant_name"));

			if (cname.equals(driver.switchTo().activeElement())) {

				logger.info("Verify that if the user name field is focused");

			} else {

				logger.error("Verify that if the user name field is focused");

			}

			if (cname.isDisplayed()) {

				cname.sendKeys("Vidhya Vikas School");

				logger.info("User can enter the name in name field");

				cname.sendKeys(Keys.TAB);

			} else {

				logger.error("User can't enter the name");

			}
		}

		catch (Exception e) {

			logger.error("Verify that user can enter the client name");

		}
			
			
			// Client Type
		
		try {

			WebElement category = driver.findElement(By.id("tenant_site_category_id"));

			if (category.isDisplayed()) {
 
				Thread.sleep(300);

				category.sendKeys("s");

				logger.info("User can able to select the client type");

			} else {

				logger.error("user can't able to select the client type");

			}

			// email

			WebElement cemail = driver.findElement(By.id("tenant_email"));

			if (cemail.isDisplayed()) {

				Thread.sleep(2000);
				
				cemail.sendKeys("manikandan.rajamanickam@adcltech.com");

				cemail.sendKeys(Keys.TAB);

				logger.info("User can enter the client email - id ");

			} else {

				logger.error("user can't able to enter the client email - id");

			}
			
		}
		
		catch (Exception e) {

			logger.error("user can't able to enter the client  email - id");
			
			
		}
			
			// IMAGE ADD

			try {

				WebElement clogo = driver.findElement(By.id("tenant_image_attributes_image_path"));
				  
  				// clogo.click();

				Thread.sleep(2000);
								                                     
				clogo.sendKeys("C:\\images.jpg");
				
				Thread.sleep(200);

				logger.info("Verify that if the customer logo image getting to upload");

			} catch (Exception e) {

				logger.error(e);
				
				logger.error("Verify that if the customer logo image getting to upload");

			} 

			
			
			
			// Address
			
			try {

			WebElement cadd = driver.findElement(By.id("tenant_address"));

			if (cadd.isDisplayed()) {

				cadd.sendKeys("56c bharathi park road 2nd cross SB Colony");

				logger.info("User can enter the address in address field");

				cadd.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to enter the addresses");

			}

			// Facility

			WebElement cfacility = driver.findElement(By.id("tenant_kitchen_id"));

			if (cfacility.isDisplayed()) {

				Thread.sleep(200);

				cfacility.sendKeys("i");

				logger.info("User can able to select the facilities");

				cfacility.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to select the kitchen");

			}			
			
			}
			catch (Exception e2) {

				
				logger.error("user can't able to select the kitchen");


			}
		
			try {

			// Lat value

			WebElement clat = driver.findElement(By.id("tenant_latitude"));

			if (clat.isDisplayed())

			{
				
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\latvalue.jpg"));
				
				
				clat.sendKeys("11.074820");

				logger.info("user can enter the lat value");

				clat.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able enter the lat value");

			}

			// Long Values

			WebElement clong = driver.findElement(By.id("tenant_longitude"));

			if (clong.isDisplayed()) {
				
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\longvalue.jpg"));

				clong.sendKeys("77.002160");

				logger.info("user can enter the longtitue values");

				clong.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to enter the longtitude values");

			}
			
			}
			catch (Exception e) {
			
				logger.error("user can't able to enter the longtitude values");
			}
			
			// Contact person
			
			try {

			WebElement cperson1 = driver.findElement(By.id("tenant_contact_person1"));

			if (cperson1.isDisplayed()) {

				cperson1.click();

				cperson1.sendKeys("Manikandan Manickam");
				
				cperson1.sendKeys(Keys.TAB);				

				logger.info("Verify that if user can enter the contact person name");

			} else {

				logger.error("Verify that if user can enter the contact person name");

			}

			}
			catch (Exception e) {
				
				logger.error("Verify that if user can enter the contact person name");
				
			}
			
			
			// Point of contact

			try {

				WebElement poc = driver.findElement(By.xpath("//input[@name='tenant[contact_person2]']"));

				poc.click();

				poc.sendKeys("Manikandan");
				
				poc.sendKeys(Keys.TAB);

				logger.info("Verify that if user can enter the Point of contact name");

			} catch (Exception e) {

				logger.error("Verify that if user can enter the Point of contact name");
			}
			


			// contact no
			
			try {

				WebElement cmobile = driver.findElement(By.xpath("//input[@id='tenant_phone1']"));

				cmobile.click();

				cmobile.sendKeys("9360254870");
				
				cmobile.sendKeys(Keys.TAB);

				logger.info("Verify that user can enter the mobile number in mobile field");

			} catch (Exception e) {

				logger.error("Verify that user can enter the mobile number in mobile field");
			}
			
			
			// POC no
			
			try {

				WebElement pno = driver.findElement(By.xpath("//input[@id='tenant_phone2']"));

				pno.click();

				pno.sendKeys("9360285656");

				Thread.sleep(2000);

				pno.sendKeys(Keys.TAB);

				logger.info("Verify that user can enter the POC mobile number in mobile no  field");

			} catch (Exception e) {

				logger.error("Verify that user can enter the POC mobile number in mobile no field");
			}
		
		
		try {

			WebElement gst = driver.findElement(By.id("tenant_gst_number"));

			gst.sendKeys("GSTCBE56CBP2CSB");

			logger.info("Verify that if the user can enter the GST NO");

		
		} catch (Exception e) {

			logger.error("Verify that if the user can enter the GST NO");
		}
		
		
		try {
			
			WebElement color =  driver.findElement(By.id("display_color"));
			
			color.click();
			
			Thread.sleep(200);
			
			WebElement value =  driver.findElement(By.xpath("//body//span[11]"));
			
			value.click();
			
			logger.info("Verify that user can click the client color");
			
			
		} catch (Exception e) {
			
			logger.error("Verify that user can click the client color");
						
		}
		
				
			}
 
 // ADD MEAL INFO

 @Test (priority = 4)
 
 public void crm_info_Mealinfo() throws InterruptedException, IOException {
	  	  
	 // BREAK FAST PLANNING
		
			try

			{
								
				WebElement mtime = driver.findElement(By.id("tenant_tenant_details_attributes_0_meal_time"));

				Select time = new Select(mtime);

				time.selectByIndex(2);

				logger.info("Verify that user can able to select the meal time");

			} catch (Exception e) {

				logger.error("Verify that user can able to select the meal time");

			}

			// Client Category
			
			try {
							
				WebElement mtype = driver.findElement(By.id("student_type_"));
				
				mtype.click();
				
				mtype.sendKeys("s");
				
				mtype.sendKeys(Keys.ENTER);
				
				
				Select type = new Select(mtype);
				
				type.selectByIndex(2);

				logger.info("Verify that user can able to select meal type");

			} catch (Exception e) {

				logger.error("Verify that user can able to select meal type");

			}
			
			// Spread Type 
			
			try {
				
				WebElement stype = driver.findElement(By.id("spread_type_"));
				
				stype.click();
				
				stype.sendKeys("3");
				
				stype.sendKeys(Keys.ENTER);
				
				
				logger.info("Verify that user can able to select Student type");

			} catch (Exception e) {

				logger.error("Verify that user can able to select Student type");

			}

			
			// Total Count
			
			try {
			
				WebElement tcount = driver.findElement(By.id("tenant_tenant_details_attributes_0_quantity"));
				
				if (tcount.isDisplayed()) {

					tcount.sendKeys("75");

					logger.info("Verify that user can able to enter the total count");

				} else {
					
											
				}

			} catch (Exception e) {

				logger.error("Verify that user can able to enter the total count");

			}
			
			
			// Consume time
			
			
			try {
				
				WebElement ctime = driver.findElement(By.id("tenant_tenant_details_attributes_0_meal_plan"));

				ctime.click();
				
				Thread.sleep(200);

				WebElement counsume = driver.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_meal_plan\"]/option[18]"));
				counsume.click();

				logger.info("Verify that user can able to select the consume time");

			} catch (Exception e) {

				logger.info("Verify that user can able to select the consume time");

			}
					

			// Dispatch Time 
			
			try {
				
				WebElement distime = driver.findElement(By.id("tenant_tenant_details_attributes_0_dispatch_time"));
				distime.click();

				WebElement dispatch = driver
						.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_dispatch_time\"]/option[15]"));
				dispatch.click();

				logger.info("Verify that user can able to select the dispatch time");

			} catch (Exception e) {

				logger.info("Verify that user can able to select the dispatch time");

			}
			
			// Delivery Time
			
			try {
				
				WebElement deltime = driver.findElement(By.id("tenant_tenant_details_attributes_0_delivery_time"));
				
				deltime.click();

				WebElement delivery = driver
						.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_delivery_time\"]/option[17]"));
				delivery.click();

				logger.info("Verify that user can able to select the delivery time");

			} catch (Exception e) {

				logger.info("Verify that user can able to select the delivery time");

			}
							
			
			// SUBMIT BUTTON
			
		try {

			Thread.sleep(500);

			WebElement submit = driver.findElement(By.name("commit"));

			submit.click();

			logger.info("Veify that if the user can click the submit button");

		}

		catch (Exception e) {

			logger.error("Verify that user can able to click the  submit button");

		}					
			
		try {

			Thread.sleep(5000);

			WebElement srch = driver.findElement(By.xpath("//input[@type='search']"));

			srch.clear();

			srch.sendKeys("Vidhya Vikas School");

			Thread.sleep(200);

			WebElement filter = driver.findElement(By.xpath("//td[@class='sorting_1']"));

			String tenant = "Vidhya Vikas School";

			if (filter.getText().equals(tenant)) {

				logger.info("Verify that if the client was successfully created");

			}

		} catch (Exception e) {

			logger.error("Verify that if the client was successfully created");
		}

		// Index Page checking

		String url = "http://192.168.1.230:4000/tenants";

		Thread.sleep(1000);

		if (driver.getCurrentUrl().equals(url)) {

			logger.info("Verify that after creating a new tenent it should redirect to index screen");

		} else {

			logger.error("Verify that after creating a new tenent it should redirect to index screen");

		}

	}
   
//ADD MEAL UPDATE
 
 @Test (priority = 5)
 
 public void crm_info_update() throws InterruptedException, IOException {
	  
	 try {

			Thread.sleep(2000);
			
			logger = logger.getLogger("Habitos - CRM _ INFO - UPDATE");
						
			driver.get("http://192.168.1.230:4000/tenants");
						
			WebElement srch = driver.findElement(By.xpath("//input[@type='search']"));
		
			srch.sendKeys("Vidhya Vikas");
			
			Thread.sleep(200);
			
			WebElement filter = driver.findElement(By.xpath("//td[@class='sorting_1']"));
			
			filter.click();
			
			 Thread.sleep(200);
			
			WebElement edit = driver.findElement(By.xpath("//a[@id='edit']"));
			
			edit.click();  
			
			Thread.sleep(500);
			
			Actions actions = new Actions(driver);  
			
			WebElement mainMenu = driver.findElement(By.xpath("//td[contains(text(),'Avaliable')]"));
	
			mainMenu.click();
			
			Thread.sleep(200);
			
			WebElement editbtn = driver.findElement(By.xpath("//a[@id='edit']"));
			
			editbtn.click();
						
			
			actions.moveToElement(mainMenu);
			
			Thread.sleep(200);

			WebElement subMenu = driver.findElement(By.xpath("//a[@id='edit']"));
			actions.moveToElement(subMenu);
			actions.click().build().perform();

			logger.info("Verify that if click edit button it should redirect to related screen");
						
			 
			
		} catch (Exception e) {

			logger.info("Verify that if click edit button it should redirect to related screen");

		}
				
		
		Thread.sleep(500);
		
		WebElement cmobile= driver.findElement(By.xpath("//input[@id='tenant_contact_person1']"));
		
		
		if (cmobile.isDisplayed()) {
			
			cmobile.click();
			
			cmobile.clear();
			
			cmobile.sendKeys("vivek");
			
			logger.info("Verify that user can update the name in primary contact field");
						
		} else {

			logger.info("Verify that user can update the name in primary contact field");
			
		}		
		
	
		Thread.sleep(500);
		
		WebElement submit = driver.findElement(By.xpath("//input[@title='Submit']"));
		
		if (submit.isEnabled()) {

			submit.click();

			logger.info("Verify that user can able to click the  submit button");
			
			Thread.sleep(2000);
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\error1.jpg"));
			
			
		} else {
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\error1.jpg"));
			

			logger.error("Verify that user can able to click the  submit button");

		}
			
	
		try {
			
			Thread.sleep(200);
						
			WebElement srch = driver.findElement(By.xpath("//*[@id=\"tenant_filter\"]/label/input"));
			
			Thread.sleep(200);
		
			srch.sendKeys("Vidhya Vikas");

			Thread.sleep(500);
		
			String contactname = "vivek";
		
			WebElement cname = driver.findElement(By.xpath("//td[contains(text(),'vivek')]"));
		
			if (cname.getText().equals(contactname)) {
			
	    	 logger.info("Client was successfully updated");
	    	 
		}			
			
		} catch (Exception e) {
			
			logger.error("Client was successfully updated");
	    	 
		}

	 }
    
//ADD MEAL VIEW
 */
 @Test (priority = 6)
 
 public void crm_info_view() {
	  	
		try {

			
			logger = logger.getLogger("Habitos - CRM _ INFO - VIEW ");
			
			Thread.sleep(2000);

			WebElement srch = driver.findElement(By.xpath("//input[@type='search']"));
			
			srch.clear();

			srch.sendKeys("Vidhya Vikas");

			Thread.sleep(200);

			WebElement filter = driver.findElement(By.xpath("//td[@class='sorting_1']"));
			
			filter.click();

			String tenant = "Vidhya Vikas School";
						
			WebElement show = driver.findElement(By.id("show"));

			Thread.sleep(200);
				
			show.click();
				
			WebElement title =  driver.findElement(By.xpath("//p[@class='page_path']"));
				
			String  tit = "CRM / CRM Info / Show CRM Info";
				  
				logger.info("Verify that if click view icon it should display the view screen automatically");
				
				logger.info("Verify that the client values are correctly displayed or not");
			 

		} catch (Exception e) {

			logger.error("Verify that if click view icon it should display the view screen automatically");
			
			logger.error("Verify that the client values are correctly displayed or not");
		}

	}
 
 // COLLPASE

 /*
  
 @Test (priority = 7)
 
 public void Software_setup() {
		
		//logger = logger.getLogger(" Habitos - Software Setup");

		try {
			
			 WebElement collapse = driver.findElement(By.id("sidebarCollapse"));
			 collapse.click();
			
			Thread.sleep(500);
			
			WebElement crm = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[2]"));
			crm.click();
			
			Thread.sleep(500);

			WebElement setup = driver.findElement(By.xpath("//*[@id=\"collapseone\"]/div/ul/li[2]/a"));
			setup.click();

			logger.info("Verify that if click software setup it should redirect to software setup index screen ");

		} catch (Exception e) {

			logger.error("Verify that if click software setup it should redirect to software setup index screen ");

		}
 }
 
// Software Setup Add

 @Test (priority = 8)
 
	public void Sw_add() {

		try {

			WebElement Addsetup = driver.findElement(By.xpath("/html/body/div/div/section/div/h2/a"));

			if (Addsetup.isDisplayed()) {

				Addsetup.click();

				String url = "http://192.168.1.230:85/software_setups/new";

				driver.getCurrentUrl().equals(url);

				logger.info("if click add setup it should redirect to add setup screen");

			} 
			
		}
		
		catch (Exception e) {

			logger.error("if click add setup it should redirect to add setup screen");

		}
	}
	
	
// ----------------------------------------------------------------------------------------------------------
	
// Soft ware Setup

 @Test (priority = 9)
	
 public void sw_setup() {

		try {

			WebElement customer = driver.findElement(By.id("software_setup_user_tenant_id"));

			customer.click();

			Thread.sleep(300);

			customer.sendKeys("B");
			
			Thread.sleep(200);
			
			customer.sendKeys(Keys.TAB);

			logger.info("User can able to select the tenant");

		} catch (Exception e) {

			logger.error("User can able to select the tenant");

		}

		// User Name

		try {

			WebElement name = driver.findElement(By.id("software_setup_user_name"));

			if (name.isDisplayed()) {

				name.sendKeys("Manikandan Rajamanickam");

				name.sendKeys(Keys.TAB);

				logger.info("User can enter the Name in Name field");

			}
			
		} catch (Exception e) {

			logger.error("user can't able to enter the email");

		}

		// E - Mail

		try {

			WebElement email = driver.findElement(By.id("software_setup_user_email"));

			if (email.isDisplayed()) {

				email.sendKeys("manikandan.rajamanickam@adcltech.com");

				email.sendKeys(Keys.TAB);

				logger.info("User can enter the email in email field");

			} else {

				logger.error("User can enter the email in email field");

			}

		}

		catch (Exception e) {

			logger.error("User can enter the email in email field");

		}

		// Mobile number

		try {

			WebElement mobile = driver.findElement(By.xpath("software_setup_user_mobile_number"));

			mobile.isDisplayed();

			mobile.sendKeys("8945458761");

			logger.info("Verify that user can able to enter the mobile number");

		} catch (Exception e) {

			logger.info("Verify that user can able to enter the mobile number");
		}
				
	// Role 

		try {

			WebElement role = driver.findElement(By.id("software_setup_user_role_id"));

			role.click();

			Thread.sleep(300);

		//	WebElement srch = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));

			role.sendKeys("a");

			WebElement admin = driver.findElement(By.xpath("select2-software_setup_user_role_id-result-2u56-7"));
			admin.click();

			admin.sendKeys(Keys.TAB);

			logger.info("User can able to select the user role");

		} catch (Exception e) {

			logger.error("User can able to select the user role");

		}
			
			
		// User Name

		try {

			Thread.sleep(500);

			WebElement uname = driver.findElement(By.id("un"));

			uname.sendKeys("manikandan");

			logger.info("Verify that user can enter the username in name field");

		} catch (Exception e) {

			logger.info("Verify that user can enter the username in name field");
		
		}

		
		// Password

		try {

			Thread.sleep(500);

			WebElement pwd = driver.findElement(By.id("software_setup_user_password_digest"));

			pwd.sendKeys("manikandan");

			logger.info("Verify that user can enter the password in password field");

		} catch (Exception e) {

			logger.info("Verify that user can enter the password in password field");
		}

		// Submit

		try {

			WebElement submit = driver.findElement(By.name("commit"));

			if (submit.isDisplayed() || submit.isEnabled()) {

				submit.click();

				logger.info("user can able to click the submit button");
			}

		} catch (Exception e) {

			logger.error("user can able to click the submit button");
		}

	}
	
		
// INDIVIDUAL ENROLLMENT
	
	@Test (priority = 10)
	public void individual_enrollment() {
		
	
		try {

			WebElement collapse = driver.findElement(By.id("sidebarCollapse"));
			collapse.click();

			Thread.sleep(500);

			WebElement crm = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[2]"));
			crm.click();

			Thread.sleep(500);

			WebElement ind_enroll = driver.findElement(By.xpath("//*[@id=\"collapseone\"]/div/ul/li[3]/a"));
			ind_enroll.click();

			String url = "http://192.168.1.230:85/enrol_index";

			if (driver.getCurrentUrl().equals(url)) {

				logger.info("Verify that if click info it should redirect to enrollment index screen");

			} else {

				logger.error("Verify that if click info it should redirect to enrollment index screen");

			}

		} catch (Exception e) {

			logger.error("Verify that if click info it should redirect to crm info index screen ");

		}

		
		
		// File Upload

		try {

			WebElement fileupload = driver
					.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div/div/div/div[2]/button"));
			fileupload.click();

			WebElement popup = driver.findElement(By.xpath("//*[@id=\"myModal1\"]/div/div/div"));
			popup.isDisplayed();

			logger.info("if click import sudent detail button it open the pop-up window");

			Thread.sleep(2000);

			WebElement tenant = driver.findElement(By.id("enrolment_tenant_id"));
			tenant.click();

			WebElement client = driver.findElement(By.xpath("//*[@id=\"enrolment_tenant_id\"]/option[2]"));
			client.click();

			Thread.sleep(1000);

			WebElement file = driver.findElement(By.id("enrolment_file1"));
			
			file.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

			Thread.sleep(1000);

			WebElement upload = driver.findElement(By.xpath("//*[@id=\"new_enrolment\"]/div[1]/div[2]/input[2]"));
			upload.isEnabled();
			Thread.sleep(200);

			upload.click();
			
			logger.info("if click upload button it should upload the enrolment file");
					
				
		} catch (Exception e) {

			logger.error("if click upload button it should upload the enrolment file");
				
		}
		
	}
	
		
	
	@Test(priority = 11)

	public void View_control() {

		// logger = logger.getLogger(" Habitos - View Control");

		try {

			Thread.sleep(200);

			WebElement add = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
			add.isEnabled();

			Thread.sleep(200);

			add.click();

			String url = "http://192.168.1.230:85/customer_view_controls/new";

			if (driver.getCurrentUrl().equals(url)) {

				logger.info("if click add button it should redirect to add screen");

			} else {

				logger.error("if click add button it should redirect to add screen");

			}
									
			Thread.sleep(2000);
			
			// Customer

			WebElement customer = driver.findElement(By.id("customer_view_control_tenant_id"));
			customer.click();

			Thread.sleep(200);

			WebElement value = driver.findElement(By.xpath("//*[@id=\"customer_view_control_tenant_id\"]/option[2]"));
			value.click();
			
			// Title

			WebElement title = driver.findElement(By.id("customer_view_control_title"));
			title.sendKeys("This month bill attachements");
			
			// Bill1 upload

			Thread.sleep(200);

			WebElement file1 = driver.findElement(By.id("customer_view_control_billing_upload"));
			
			file1.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

			Thread.sleep(200);

			WebElement file2 = driver.findElement(By.id("customer_view_control_nutrition_upload"));
			
			file1.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

			Thread.sleep(200);

			WebElement submit = driver.findElement(By.name("commit"));
			submit.isEnabled();

			Thread.sleep(200);
			submit.click();

			logger.info("if click sumit button the values gets saved and dispalying to index screen");

		} catch (Exception e) {

			logger.error("if click add button it should redirect to add screen");

			logger.error("if click sumit button the values gets saved and dispalying to index screen");

		}

	}
	
	*/
  
  @AfterTest
  public void afterTest() {
	  	   
	  driver.close();
  }

}
