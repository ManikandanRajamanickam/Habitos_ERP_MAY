package Habitos_QA_ERP.HBERP;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class HabitosERP {

	static WebDriver d;
	static org.apache.log4j.Logger logger;
	 
	
  @ BeforeClass
   public void beforeTest() {
	  
	  try {

		  System.out.println("Log Out Method is Running");
		  
			logger = logger.getLogger(" Habitos - ERP");

			PropertyConfigurator.configure("log4jproperties.txt");
			
			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "..//ERP//resources//chromedriver_testing.exe");
			
			d = new ChromeDriver();

			logger.info("browser gets open Logout methods");

			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");
			
			
			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);

			//	d.manage().window().maximize();
			
			//	driver = new ChromeDriver();

			Thread.sleep(2000);

			d.get("http://192.168.1.179/");

			logger.info("browser gets valid ip address for Logout methods");

		}

		catch (Exception e) {

			System.out.println("Login is not working");

		}

	}

}


class Loginscreen extends HabitosERP {
	
	
	// IN_ VALID LOGIN

	@Test(priority = 1)

	public void Invalid_Login() {

		{

			d.manage().window().maximize();

			String un = "vivek";

			String pw = "vivek kumar";

			WebElement uname = d.findElement(By.id("kitchen_user_user_name"));

			WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));

			// WebElement Rme = d.findElement(By.name("remember"));
			
			WebElement submit = d.findElement(By.name("commit"));

			if (uname.isDisplayed()) {

				logger.info("Verify that if the User Name field is present ");

			} else {

				logger.error("Verify that if the User Name field is present ");

			}

			if (uname.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the username fields get autofocus");

				uname.sendKeys("vivek");

				uname.sendKeys(Keys.TAB);

			} else {

				logger.error("Verify that if the username fields get autofocus");

			}

			if (pwd.isDisplayed()) {

				logger.info("Verify that if the Password  field is present ");

			} else {

				logger.error("Verify that if the Password  field is present ");

			}

			if (pwd.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the password fields get focused");

				pwd.sendKeys("vivek kumar");

			} else {

				logger.error("Verify that if the password fields get focused");
			}

			if (submit.isEnabled()) {

				submit.click();

				WebElement almsg = d.findElement(By.xpath("//div[@class='alert alert-notice']"));

				String msg = "                     Invalid Username or Password!";

				if (almsg.getText().equals(msg)) {

					logger.info("Verify that if the user can't able to login with Invalid credentials");

					String msgg = almsg.getText().toString();

					System.out.println(msgg);

				} else {

					logger.error("Verify that if the user can't able to login with Invalid credentials");

				}

			} else {

				logger.error("Verify that user can't able to click the submit");

			}
		}
	}
	  
	  
	     // VALID LOGIN 
	  
	  @Test (priority = 2)
	  
	  public void Valid_Login() throws InterruptedException {
	  
			String un = "vivek";
			String pw = "vivek";

			WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
			WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
			// WebElement Rme = d.findElement(By.xpath("//*[@id=\"new_kitchen_user\"]/div/div[2]/span/input")); 
			WebElement submit = d.findElement(By.name("commit"));

			
			if (uname.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the username fields get autofocus");

				uname.sendKeys(un);
			
				logger.info("Verify that if the user can enter the user name");
				
				uname.sendKeys(Keys.TAB);

			} else {

				logger.error("Verify that if the user can enter the user name");
				
			}

			if (pwd.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the password fields get focused");

				pwd.sendKeys(pw);

			} else {

				logger.error("Verify that if the password fields get focused");
			}

			
			if (submit.isEnabled()) {
				
				logger.info("Verify that user can login with valid credentials");
				
				submit.click();
				
							
			} else {

				logger.error("Verify that user can login with valid credentials");
				
			}
			  
	  }
	   
	
}


class Crmscreen extends Loginscreen  {
		
	// INDEX PAGE
	
	 @Test (priority = 1)
	 
	  public void crm_info()  {
		  
		 try {
			 
			 System.out.println("CRM Screen");
			 
			Thread.sleep(2000);
			 		 
			//	 driver.get("http://192.168.1.179/tenants");
			 		 		 
			 WebElement collapse = d.findElement(By.xpath("//a[@id='sidebarCollapse']"));
			
			collapse.click();
			 
			Thread.sleep(500);
			
			WebElement crm = d.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/div[1]/div[1]/a[2]s"));
			crm.click();
			
			Thread.sleep(500);

			WebElement crminfo = d.findElement(By.xpath("//a[contains(text(),'CRM Info')]"));
			crminfo.click();

			logger.info("Verify that if click CRM info it should redirect to crm info index screen ");

		} catch (Exception e) {
			
			System.out.println(e);

			logger.error("Verify that if click CRM info it should redirect to crm info index screen ");
			
			System.out.println("crm info screen");
			
		}
			  
	  }
	   

	 // ADD- CLIENT
	 
	 @Test (priority = 3)
	 
	 public void crm_info_add() {

			try

			{

				WebElement Add = d.findElement(By.xpath("//a[@class='btn']"));

				Add.isDisplayed();

				Thread.sleep(200);

				Add.click();

				logger.info("Verify that if click add new button it should redirect to add new screen");

			} catch (Exception e) {

				logger.error("Verify that if click add new button it should redirect to add new screen");

			}
			
			
			try {
				
				// customer name

			WebElement cname = d.findElement(By.id("tenant_name"));

			
			if (cname.equals(d.switchTo().activeElement())) {
				
				logger.info("Verify that if the user name field is focused");
				
			} else {

				logger.error("Verify that if the user name field is focused");
				
			}
						
				if (cname.isDisplayed()) {

					cname.sendKeys("Chinmaya Vidyalaya School");

					logger.info("User can enter the name in name field");

					cname.sendKeys(Keys.TAB);
					
					
				} else {

					logger.error("User can't enter the name");

			}

				// Client Type

				WebElement category = d.findElement(By.id("tenant_site_category_id"));

				if (category.isDisplayed()) {

					// category.click();

					Thread.sleep(300);

					category.sendKeys("s");

					logger.info("User can able to select the client type");						
				
			} else {
				
				logger.error("user can't able to select the client type");

			}
			
			// email
				
			WebElement cemail = d.findElement(By.id("tenant_email"));
		
			if (cemail.isDisplayed()) {
				
				cemail.sendKeys("manikandan.rajamanickam@adcltech.com");
					
				cemail.sendKeys(Keys.TAB);
				
				logger.info("User can enter the email id");
				
			} else {

				logger.error("user can't able to enter the email");
				
			}
			
			try {
				
				
				WebElement clogo = d.findElement(By.id("tenant_image_attributes_image_path"));
				
				clogo.sendKeys("C:\\Users\\altius\\Desktop\\images.jpg");
			
				logger.info("Verify that if the customer logo image getting to upload");
				
				
			} catch (Exception e) {
		
				logger.info("Verify that if the customer logo image getting to upload");
		
			}		
			
			
			// Address
			
			WebElement cadd = d.findElement(By.id("tenant_address"));
			
			if (cadd.isDisplayed()) {

				cadd.sendKeys("56c bharathi park road 2nd cross SB Colony");

				logger.info("User can enter the address in address field");

				cadd.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to enter the addresses");

			}

			// Facility
			
			WebElement cfacility = d.findElement(By.id("tenant_kitchen_id"));
			
			if (cfacility.isDisplayed()) {

			
				//	cfacility.click();

				Thread.sleep(200);

				cfacility.sendKeys("i");

				logger.info("User can able to select the facilities");

				cfacility.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to select the kitchen");

			}
			
			
			// Lat value
			
				WebElement clat = d.findElement(By.id("tenant_latitude"));

				if (clat.isDisplayed())

				{
					clat.sendKeys("11.074820");

					logger.info("user can enter the lat value");

					clat.sendKeys(Keys.TAB);

				} else {

					logger.error("user can't able enter the lat value");

				}
						
		
			// Long Values
				
			WebElement clong = d.findElement(By.id("tenant_longitude"));
			
			if (clong.isDisplayed()) {

				clong.sendKeys("77.002160");

				logger.info("user can enter the longtitue values");

				clong.sendKeys(Keys.TAB);

			} else {

				logger.error("user can't able to enter the longtitude values");
		
			}
			
			
		// Contact person
			
			WebElement cperson1 = d.findElement(By.id("tenant_contact_person1"));
		
			if (cperson1.isDisplayed()) {
				
				cperson1.click();
				
				cperson1.sendKeys("Manikandan Manickam");
				
				logger.info("Verify that if user can enter the contact person name");
				
			} else {

				logger.error("Verify that if user can enter the contact person name");
				
			}
			
			
			// Point of contact 
			
			
			WebElement poc = d.findElement(By.xpath("//input[@id='tenant_contact_person2']"));
			
			if (poc.isDisplayed()) {
				
				poc.click();
				
				poc.sendKeys("Manikandan");
				
				logger.info("Verify that if user can enter the Point of contact name");
				
			} else {

				logger.error("Verify that if user can enter the Point of contact name");
				
			}
			
			
			// contact no
			
			WebElement cmobile= d.findElement(By.id("tenant_phone1"));
			
			
			if (cmobile.isDisplayed()) {
				
				cmobile.click();
				
				cmobile.sendKeys("9360254870");
				
				logger.info("Verify that user can enter the mobile number in mobile field");
							
			} else {

				logger.error("Verify that user can enter the mobile number in mobile field");
				
				}

			}

			catch (Exception e) {

			}

		}
	 	 	 
	 // ADD MEAL INFO

	 @Test (priority = 4)
	 
	 public void crm_info_Mealinfo() throws InterruptedException {
		  
		  
		 // BREAK FAST PLANNING
			
				try

				{

					WebElement mtime = d.findElement(By.id("tenant_tenant_details_attributes_0_meal_time"));

					Select time = new Select(mtime);

					time.selectByIndex(2);

					logger.info("Verify that user can able to select the meal time");

				} catch (Exception e) {

					logger.error("Verify that user can able to select the meal time");

				}

				 // Client Category
				
				try {
								
					WebElement mtype = d.findElement(By.id("student_type_"));

					Select type = new Select(mtype);
					
					type.selectByIndex(1);

					logger.info("Verify that user can able to select meal type");

				} catch (Exception e) {

					logger.error("Verify that user can able to select meal type");

				}
				
				// Spread Type 
				
				try {
					
					WebElement stype = d.findElement(By.id("spread_type_"));
					Select studenttype = new Select(stype);	
					studenttype.selectByIndex(1);

					logger.info("Verify that user can able to select Student type");

				} catch (Exception e) {

					logger.error("Verify that user can able to select Student type");

				}

				
				// Total Count
				
				try {
				
					WebElement tcount = d.findElement(By.id("tenant_tenant_details_attributes_0_quantity"));
					
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
					
					WebElement ctime = d.findElement(By.id("tenant_tenant_details_attributes_0_meal_plan"));

					ctime.click();
					
					Thread.sleep(200);

					WebElement counsume = d.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_meal_plan\"]/option[18]"));
					counsume.click();

					logger.info("Verify that user can able to select the consume time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the consume time");

				}
						
				// Dispatch Time 
				
				try {
					
					WebElement distime = d.findElement(By.id("tenant_tenant_details_attributes_0_dispatch_time"));
					distime.click();

					WebElement dispatch = d
							.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_dispatch_time\"]/option[15]"));
					dispatch.click();

					logger.info("Verify that user can able to select the dispatch time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the dispatch time");

				}
				
				// Delivery Time
				
				try {
					
					WebElement deltime = d.findElement(By.id("tenant_tenant_details_attributes_0_delivery_time"));
					
					deltime.click();

					WebElement delivery = d
							.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_0_delivery_time\"]/option[17]"));
					delivery.click();

					logger.info("Verify that user can able to select the delivery time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the delivery time");

				}
				
		
				// Add Row
				
				try {
					
					WebElement add = d.findElement(By.xpath("//*[@id=\"new_tenant\"]/div/div[1]/div[2]/div/div[2]/a"));
					
					Thread.sleep(200);
					
					add.isDisplayed();
					
					add.click();
					
					logger.info("If click Add button it should create a new row");
					
					
				} catch (Exception e) {
					
					
					logger.error("If click Add button it should create a new row");
								
				}
					
		/*		
						
				//LUNCH PLANNING
				
					
			// Meal Time
				
				try

				{

					Thread.sleep(300);
					
					WebElement mtime = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/select[1]"));

					Select time = new Select(mtime);

					time.selectByIndex(1);

					logger.info("Verify that user can able to select the meal time");

				} catch (Exception e) {

					logger.error("Verify that user can able to select the meal time");

				}
				
				
				 // Client Category
				
				try {
					
					
					WebElement mtype = driver.findElement(By.xpath("//*[@id=\"tasks\"]/tbody/tr[3]/td[2]"));
					
					mtype.click();			

					Select type = new Select(mtype);
					
					type.selectByIndex(2);

					logger.info("Verify that user can able to select meal type");

				} catch (Exception e) {

					logger.error("Verify that user can able to select meal type");

				}
				
				// Spread Type 
				
				try {
					
					Thread.sleep(300);
					
					WebElement stype = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[3]/select[1]"));
					
					Select studenttype = new Select(stype);	
					
					studenttype.selectByIndex(2);

					logger.info("Verify that user can able to select Student type");

				} catch (Exception e) {

					logger.error("Verify that user can able to select Student type");

				}

				
				// Total Count
				
				try {
				
					WebElement tcount = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[4]/input[1]"));
					
					if (tcount.isDisplayed()) {

						tcount.sendKeys("120");

						logger.info("Verify that user can able to enter the total count");

					} else {
						
												
					}

				} catch (Exception e) {

					logger.error("Verify that user can able to enter the total count");

				}
				
				
				// Consume time
				
				
				try {
					
					WebElement ctime = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[5]/select[1]"));

					ctime.click();
					
					Thread.sleep(200);

					WebElement counsume = driver
							.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[5]/select[1]/option[28]"));
					counsume.click();

					logger.info("Verify that user can able to select the consume time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the consume time");

				}
						
				// Dispatch Time 
				
				try {
					
					WebElement distime = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[6]/select[1]"));
					distime.click();

					WebElement dispatch = driver
							.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[6]/select[1]/option[26]"));
					dispatch.click();

					logger.info("Verify that user can able to select the dispatch time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the dispatch time");

				}
				
				// Delivery Time
				
				try {
					
					WebElement deltime = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[7]/select[1]"));
					
					deltime.click();

					WebElement delivery = driver.findElement(By.xpath("//*[@id=\"tenant_tenant_details_attributes_1551870516992_delivery_time\"]/option[27]"));
					delivery.click();

					logger.info("Verify that user can able to select the delivery time");

				} catch (Exception e) {

					logger.info("Verify that user can able to select the delivery time");

				}
				
		*/
				
				// SUBMIT BUTTON
				
				Thread.sleep(5000);
				
				WebElement submit = d.findElement(By.name("commit"));
			
				if (submit.isEnabled()) {

					submit.click();

					logger.info("Verify that user can able to click the  submit button");

				} else {

					logger.error("Verify that user can able to click the  submit button");

				}

				
				// Index Page checking
							
				String url = "http://192.168.1.179/tenants";

				d.getCurrentUrl();

				if (url.equals(d.getCurrentUrl())) {

					logger.info("Verify that after creating a new tenent it should redirect to index screen");

				} else {

					logger.error("Verify that after creating a new tenent it should redirect to index screen");

				}
		  
	 }
	 	 
	 @Test (priority = 5)
	 
	 public void crm_info_update() throws InterruptedException {
		  
		 try {

				Thread.sleep(2000);
				
				d.get("http://192.168.1.179/tenants");

				WebElement srch = d.findElement(By.xpath("//input[@type='search']"));
			
				srch.sendKeys("Chinmaya");
				
				Thread.sleep(200);
				
				WebElement filter = d.findElement(By.xpath("//td[@class='sorting_1']"));
				
				String tenant = "Chinmaya Vidyalaya School";
				
				if (filter.getText().equals(tenant)) 
				
				{
					
				Thread.sleep(500);
				
				Actions actions = new Actions(d);
				
				WebElement mainMenu = d.findElement(By.xpath("//td[contains(text(),'Avaliable')]"));
				
				actions.moveToElement(mainMenu);
				
				Thread.sleep(200);

				WebElement subMenu = d.findElement(By.xpath("//a[@id='edit']"));
				actions.moveToElement(subMenu);
				actions.click().build().perform();

				logger.info("Verify that user can click the edit button");
				
				
				}
				
			} catch (Exception e) {

				logger.error("User can able to click edit button");

			}
					
			
			Thread.sleep(500);
			
			WebElement cmobile= d.findElement(By.xpath("//input[@id='tenant_contact_person2']"));
			
			
			if (cmobile.isDisplayed()) {
				
				cmobile.click();
				
				cmobile.clear();
				
				cmobile.sendKeys("vivek");
				
				logger.info("Verify that user can update the mobile number in mobile field");
							
			} else {

				logger.error("Verify that user can update the mobile number in mobile field");
				
				}
			
			
			Thread.sleep(500);
			
			WebElement submit = d.findElement(By.name("commit"));
			
			if (submit.isEnabled()) {

				submit.click();

				logger.info("Verify that user can able to click the  submit button");

			} else {

				logger.error("Verify that user can able to click the  submit button");

			}

			
			// SUBMIT

			try {

				WebElement comit = d.findElement(By.name("commit"));		

				comit.isDisplayed();

				Thread.sleep(200);

				comit.click();

				logger.info("User can able to select the submit button");
				
				
			} catch (Exception e) {

				logger.error("User can able to select the submit button");

			}
			
			
			try {
				
				WebElement srch = d.findElement(By.xpath("//*[@id=\"tenant_filter\"]/label/input"));
				
				Thread.sleep(200);
			
				srch.sendKeys("Bharathi");

				Thread.sleep(500);
			
				String mobile = "936055290";
			
				WebElement mbo = d.findElement(By.xpath("//*[@id=\"6\"]/td[5]"));
			
		     if (mbo.getText().equals(mobile)) {
				
		    	 logger.info("Client was successfully updated");
		    	 
			}			
				
			} catch (Exception e) {
				
				logger.error("Client was successfully updated");
		    	 
			}

		 }
	  
	 
	 @Test (priority = 6)
	 
	 public void crm_info_view() {
		  
		
		 try {

				Thread.sleep(2000);
				
				d.get("http://192.168.1.179/tenants");

				WebElement srch = d.findElement(By.xpath("//input[@type='search']"));
			
				srch.sendKeys("Chinmaya");
				
				Thread.sleep(200);
				
				WebElement filter = d.findElement(By.xpath("//td[@class='sorting_1']"));
				
				String tenant = "Chinmaya Vidyalaya School";
				
				if (filter.getText().equals(tenant)) 
				
				{

				Thread.sleep(500);
				
				Actions actions = new Actions(d);
				
				WebElement mainMenu = d.findElement(By.xpath("//td[contains(text(),'Avaliable')]"));
				
				actions.moveToElement(mainMenu);
				
				Thread.sleep(200);

				WebElement subMenu = d.findElement(By.xpath("//a[@id='show']"));
				actions.moveToElement(subMenu);
				actions.click().build().perform();

				logger.info("Verify that user can click the show  button");
				
				}
				
			} catch (Exception e) {

			logger.error("User can able to click Show  button");

			}
		 
		
			try {
				
				Thread.sleep(500);
				
				WebElement tenant = d.findElement(By.xpath("/html/body/div/div/section/div/div/div/div/div[2]/h3"));
				
				String tname = "Bharathiar Met Hr Sec School CBE";
				
				if (tenant.getText().equals(tname)) {
					
					logger.info("Verify that if the tenat name is correctly display");
					
					Thread.sleep(200);
					
					d.get("http://192.168.1.179/tenants");
					
				}
				
			} catch (Exception e) {
							
				logger.error("Verify that if the tenat name is correctly display");
				
			}
	   }
	 
	 
	 // COLLPASE
	 
	 @Test (priority = 7)
	 
	 public void Software_setup() {
			
			//logger = logger.getLogger(" Habitos - Software Setup");

			try {
				
				 WebElement collapse = d.findElement(By.id("sidebarCollapse"));
				 collapse.click();
				
				Thread.sleep(500);
				
				WebElement crm = d.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[2]"));
				crm.click();
				
				Thread.sleep(500);

				WebElement setup = d.findElement(By.xpath("//*[@id=\"collapseone\"]/div/ul/li[2]/a"));
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

				WebElement Addsetup = d.findElement(By.xpath("/html/body/div/div/section/div/h2/a"));

				if (Addsetup.isDisplayed()) {

					Addsetup.click();

					String url = "http://192.168.1.18:85/software_setups/new";

					d.getCurrentUrl().equals(url);

					logger.info("if click add setup it should redirect to add setup screen");

				} 
				
			}
			
			catch (Exception e) {

				logger.error("if click add setup it should redirect to add setup screen");

			}
		}
		
		
	 // ------------------------------------------------------------------------------------------
	 
		
		// Soft ware Setup

	 @Test (priority = 9)
		
	 public void sw_setup() {

			try {

				WebElement customer = d.findElement(By.id("software_setup_user_tenant_id"));

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

				WebElement name = d.findElement(By.id("software_setup_user_name"));

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

				WebElement email = d.findElement(By.id("software_setup_user_email"));

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

				WebElement mobile = d.findElement(By.xpath("software_setup_user_mobile_number"));

				mobile.isDisplayed();

				mobile.sendKeys("8945458761");

				logger.info("Verify that user can able to enter the mobile number");

			} catch (Exception e) {

				logger.info("Verify that user can able to enter the mobile number");
			}
			
			
			// Role

			try {

				WebElement role = d.findElement(By.id("software_setup_user_role_id"));

				role.click();

				Thread.sleep(300);

			//	WebElement srch = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));

				role.sendKeys("a");

				WebElement admin = d.findElement(By.xpath("select2-software_setup_user_role_id-result-2u56-7"));
				admin.click();

				admin.sendKeys(Keys.TAB);

				logger.info("User can able to select the user role");

			} catch (Exception e) {

				logger.error("User can able to select the user role");

			}
				
				
			// User Name

			try {

				Thread.sleep(500);

				WebElement uname = d.findElement(By.id("un"));

				uname.sendKeys("manikandan");

				logger.info("Verify that user can enter the username in name field");

			} catch (Exception e) {

				logger.info("Verify that user can enter the username in name field");
			
			}

			
			// Password

			try {

				Thread.sleep(500);

				WebElement pwd = d.findElement(By.id("software_setup_user_password_digest"));

				pwd.sendKeys("manikandan");

				logger.info("Verify that user can enter the password in password field");

			} catch (Exception e) {

				logger.info("Verify that user can enter the password in password field");
			}

			// Submit

			try {

				WebElement submit = d.findElement(By.name("commit"));

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

				WebElement collapse = d.findElement(By.id("sidebarCollapse"));
				collapse.click();

				Thread.sleep(500);

				WebElement crm = d.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[2]"));
				crm.click();

				Thread.sleep(500);

				WebElement ind_enroll = d.findElement(By.xpath("//*[@id=\"collapseone\"]/div/ul/li[3]/a"));
				ind_enroll.click();

				String url = "http://192.168.1.18:85/enrol_index";

				if (d.getCurrentUrl().equals(url)) {

					logger.info("Verify that if click info it should redirect to enrollment index screen");

				} else {

					logger.error("Verify that if click info it should redirect to enrollment index screen");

				}

			} catch (Exception e) {

				logger.error("Verify that if click info it should redirect to crm info index screen ");

			}

			
			
			// File Upload

			try {

				WebElement fileupload = d
						.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div/div/div/div[2]/button"));
				fileupload.click();

				WebElement popup = d.findElement(By.xpath("//*[@id=\"myModal1\"]/div/div/div"));
				popup.isDisplayed();

				logger.info("if click import sudent detail button it open the pop-up window");

				Thread.sleep(2000);

				WebElement tenant = d.findElement(By.id("enrolment_tenant_id"));
				tenant.click();

				WebElement client = d.findElement(By.xpath("//*[@id=\"enrolment_tenant_id\"]/option[2]"));
				client.click();

				Thread.sleep(1000);

				WebElement file = d.findElement(By.id("enrolment_file1"));
				
				file.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

				Thread.sleep(1000);

				WebElement upload = d.findElement(By.xpath("//*[@id=\"new_enrolment\"]/div[1]/div[2]/input[2]"));
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

				WebElement add = d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
				add.isEnabled();

				Thread.sleep(200);

				add.click();

				String url = "http://192.168.1.18:85/customer_view_controls/new";

				if (d.getCurrentUrl().equals(url)) {

					logger.info("if click add button it should redirect to add screen");

				} else {

					logger.error("if click add button it should redirect to add screen");

				}
										
				Thread.sleep(2000);
				
				// Customer

				WebElement customer = d.findElement(By.id("customer_view_control_tenant_id"));
				customer.click();

				Thread.sleep(200);

				WebElement value = d.findElement(By.xpath("//*[@id=\"customer_view_control_tenant_id\"]/option[2]"));
				value.click();
				
				// Title

				WebElement title = d.findElement(By.id("customer_view_control_title"));
				title.sendKeys("This month bill attachements");
				
				// Bill1 upload

				Thread.sleep(200);

				WebElement file1 = d.findElement(By.id("customer_view_control_billing_upload"));
				
				file1.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

				Thread.sleep(200);

				WebElement file2 = d.findElement(By.id("customer_view_control_nutrition_upload"));
				
				file1.sendKeys("C:\\Users\\altius\\Desktop\\Habitos (1).pdf");

				Thread.sleep(200);

				WebElement submit = d.findElement(By.name("commit"));
				submit.isEnabled();

				Thread.sleep(200);
				submit.click();

				logger.info("if click sumit button the values gets saved and dispalying to index screen");

			} catch (Exception e) {

				logger.error("if click add button it should redirect to add screen");

				logger.error("if click sumit button the values gets saved and dispalying to index screen");

			}

		}
	
}
