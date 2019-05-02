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
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MenuPlanner {
	
	static WebDriver d;
	static org.apache.log4j.Logger logger; 
		
	// LOGIN
	
	@Test (priority = 1)
	   
	public void Valid_Login() {

		d.manage().window().maximize();

		String un = "vivek";
		String pw = "vivek";

		WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
		WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
		// WebElement Rme =
		// d.findElement(By.xpath("//*[@id=\"new_kitchen_user\"]/div/div[2]/span/input"));
		WebElement submit = d.findElement(By.name("commit"));

		if (uname.equals(d.switchTo().activeElement())) {

			// logger.info("Verify that if the username fields get autofocus");

			uname.sendKeys(un);

			// logger.info("Verify that if the user can enter the user name");

			uname.sendKeys(Keys.TAB);

		} else {

			// logger.error("Verify that if the user can enter the user name");

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
		
	@Test (priority = 2)
	
	public void Menu_Planner() {
		
		try {

			Thread.sleep(200);

			WebElement sidebar = d.findElement(By.id("sidebarCollapse"));

			sidebar.click();

			logger.info("Verify  that if click master menu it getting to collapse");

			WebElement master = d.findElement(By.xpath("//span[contains(text(),'Masters')]"));

			master.click();

			Thread.sleep(2000);
			
			WebElement menuplanner = d.findElement(By.xpath("//a[contains(text(),'Menu Planner')]"));
			menuplanner.click();		
			
			Thread.sleep(2000);
						
			String url = "http://192.168.1.230:4000/normalmenu_sites/new_menu_planner";
						
			if (d.getCurrentUrl().equals(url)) {

			//	logger.info("Verify that if click menu planner menu it should redirect to menu planner screen");

			} else {

			//	logger.error("Verify that if click menu planner menu  it should redirect to menu planner screen");
			}
		
			} catch (Exception e) {

			logger.error("Verify  that if click master menu it getting to collapse");
		}
	}
	
	// MENU PLANNING

	@Test (priority = 3)
	
	public void Menu_planner_plan()

	{

		try {

			// PLAN NAME Focus

			Thread.sleep(10000);

			WebElement focus = d.findElement(By.xpath("//input[@title='Plan Name']"));

			if (focus.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the plan name field is focus");

			}

		} catch (Exception e) {

			logger.error("Verify that if the plan name field is focus");
		}
	
		// **************************************************************************************** //
		
		// PLAN NAME

		try {

			Thread.sleep(2000);

			WebElement p_name = d.findElement(By.xpath("//input[@title='Plan Name']"));

			p_name.sendKeys("2day Lunch 24/04");
						
			p_name.sendKeys(Keys.TAB);
			
			logger.info("user can enter the plan name in input field");

		} catch (Exception e) {

			logger.error("user can enter the plan name in input field");

		}
				
		
		// Assign date
		 
		try {
					
		WebElement date = d.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div[2]/div[2]/div/input"));

		date.click();

		Thread.sleep(200);
		
		date.sendKeys("08/04/2019");

		Thread.sleep(200);
		
		logger.info("user can select the  Plan creation date using date picker");
				
		date.sendKeys(Keys.TAB);
							
		/*				
		 
		d.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	
			d.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();

			logger.info("user can select the  current date in date field");
		 
		 */
		
		} catch (Exception e) {

			logger.error("user can select the  Plan creation date using date picker");

		}
		
		
		// Plan for No of Days Selection
		
		try {
			
			WebElement days = d.findElement(By.id("no_of_days"));
			
			Select type = new Select(days);
			
			type.selectByIndex(2);

			logger.info("User can assign no of days");
			
			
		} catch (Exception e2) {
			
			logger.error("User can assign no of days");
					
		}
		
		}
		
	// **************************************************************************************** //
			
	// Break Fast

	@Test(priority = 4)
	
	public void Breakfast() {

		try {

			Thread.sleep(200);

			WebElement bfast = d.findElement(By.xpath("//button[contains(text(),'Breakfast')]"));

			bfast.isDisplayed();

			Thread.sleep(500);

			bfast.click();

			logger.info("Verify that if the break fast meal course is present");

		} catch (Exception e) {

			logger.error("Verify that if the break fast meal course is present");

		}

		// ADD ROW

		try {

			WebElement row = d.findElement(
					By.xpath("//div[@id='collapse1']//button[@class='btn addrow'][contains(text(),'+ Add row')]"));

			for (int i = 0; i <= 2; i++) {

				Thread.sleep(200);

				row.click();

			}

			logger.info("If click add row button it should create the new row for meal course");

		} catch (Exception e) {

			logger.error("Ff click add row button it should create the new row for meal course");

		}
			
		// MEAL _ CATEGORY

		try {

			Thread.sleep(500);

			WebElement row1_cat = d.findElement(By.xpath("//tr[1]//td[1]//div[1]//a[1]//span[1]"));
			row1_cat.click();

			Thread.sleep(200);

			WebElement re_cat = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Desserts')]"));
			re_cat.click();

			Thread.sleep(200);
	//		re_cat.sendKeys(Keys.ENTER);

			Thread.sleep(200);

			String category = "Desserts";

			WebElement cate = d.findElement(By.xpath("//tr[1]//td[1]//div[1]//a[1]//span[1]"));

			cate.getText().equals(category);

			logger.info("Verify that user can able to select the meal category");

		} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

		}

		// ------------------------------------------------------------------------------------------------//

		// MEAL - RECEPIE

		try {

			WebElement recepie = d.findElement(By.xpath("//tr[1]//td[1]//div[2]//a[1]//span[1]"));

			recepie.click(); 
			
			Thread.sleep(500);
			
			WebElement values =  d.findElement(By.xpath("//a[contains(text(),'Dal Payasam')]"));
			
			values.click(); 

			Thread.sleep(200);

			String category = "Dal Payasam";

			WebElement cate = d.findElement(By.xpath("//tr[1]//td[1]//div[2]//a[1]//span[1]"));

			cate.getText().equals(category);

			logger.info("Verify that user can able to select the meal category");

		} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

		}

		// CHECK BOX

		try {

			WebElement check = d.findElement(By.xpath("//div[@id='collapse1']//th[1]//label[1]"));

			check.isEnabled();

			Thread.sleep(200);

			check.click();

			logger.info("User can able to select the check box");

		} catch (Exception e) {

			logger.error("User can able to select the check box");

		}
				
		// 2ND PLAN
			
		// MEAL _ CATEGORY
			
			try {
							
				Thread.sleep(500);
									
				WebElement row1_cat  = d.findElement(By.xpath("//tr[1]//td[2]//div[1]//a[1]//span[1]"));
				
				row1_cat.click();
				
				Thread.sleep(200);
				
				WebElement filter  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Main Course')]"));
										
				filter.click();
							
				Thread.sleep(200);
				
				String category = "Main Course";
				
				WebElement cate = d.findElement(By.xpath("//tr[1]//td[2]//div[1]//a[1]//span[1]"));
				
				cate.getText().equals(category);		
				
				logger.info("Verify that user can able to select the 2nd meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the 2nd meal category");
								
			}
			
			
			// MEAL - RECEPIE
				
			
			try {
				
				WebElement recepie  = d.findElement(By.xpath("//tr[1]//td[2]//div[2]//a[1]//span[1]"));
				
				recepie.click();
				
				WebElement filter  = d.findElement(By.xpath("//a[contains(text(),'Coriander Rice')]"));
										
				filter.click();
				
				Thread.sleep(200);
			
				String category = "Coriander Rice";
				
				WebElement catea = d.findElement(By.xpath("//tr[1]//td[2]//div[2]//a[1]//span[1]"));
				
				catea.getText().equals(category);		
				
				logger.info("Verify that user can able to select the meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the meal category");
								
			}
			
			// CHECK BOX
			
			try {

				WebElement check = d.findElement(By.xpath("//div[@id='collapse1']//th[2]//label[1]"));

				check.isEnabled();

				Thread.sleep(200);

				check.click();

				logger.info("User can able to select the check box");

			} catch (Exception e) {

				logger.error("User can able to select the check box");

			}		
											
			
			// 2RD Row ADD
			
			// MEAL _ CATEGORY
					
		try {
						
			Thread.sleep(500);
								
			WebElement row1_cat  = d.findElement(By.xpath("//tr[1]//td[3]//div[1]//a[1]//span[1]"));
			
			row1_cat.click();
						
			Thread.sleep(200);
			
			WebElement filter  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Soup')]"));
						
			filter.click();
			
		//	filter.sendKeys(Keys.ENTER);
							
		//	re_cat.sendKeys(Keys.ENTER);
						
			Thread.sleep(200);
			
			String category = "Soup";
			
			WebElement cate = d.findElement(By.xpath("//tr[1]//td[3]//div[1]//a[1]//span[1]"));
			
			cate.getText().equals(category);		
			
			logger.info("Verify that user can able to select the 3rd meal category");
						
			
		} catch (Exception e) {
		
			logger.error("Verify that user can able to select the 3rd meal category");
							
		}
		
		
		// MEAL - RECEPIE
			
		
		try {
			
			Thread.sleep(300);
			
			WebElement recepie  = d.findElement(By.xpath("//tr[1]//td[3]//div[2]//a[1]//span[1]"));
			
			recepie.click();
			
			Thread.sleep(300);
			
			WebElement filter  = d.findElement(By.xpath("//a[contains(text(),'Corn Chowder')]"));
			
			filter.click();
			
			Thread.sleep(200);
		
			String category = "Coriander Rice";
			
			WebElement catea = d.findElement(By.xpath("//tr[1]//td[3]//div[2]//a[1]//span[1]"));
			
			catea.getText().equals(category);		
			
			logger.info("Verify that user can able to select the meal category");
						
			
		} catch (Exception e) {
		
			logger.error("Verify that user can able to select the meal category");
							
		}
		
		// CHECK BOX
		
		try {

			WebElement check = d.findElement(By.xpath("//div[@id='collapse1']//th[3]//label[1]"));

			check.isEnabled();

			Thread.sleep(200);

			check.click();

			logger.info("User can able to select the check box");

		} catch (Exception e) {

			logger.error("User can able to select the check box");

		}		
										
	}
	
	// 2ND ROW ADD
		
	@Test (priority =5)
	
	public void menuplan_row2() {
				
		// MEAL _ CATEGORY

		try {

			Thread.sleep(500);

			WebElement row1_cat = d.findElement(By.xpath("//tr[2]//td[1]//div[1]//a[1]//span[1]"));
			row1_cat.click();

			Thread.sleep(200);

			WebElement re_cat = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Snacks')]"));
			re_cat.click();

			Thread.sleep(200);
		
			String category = "Snacks";

			WebElement cate = d.findElement(By.xpath("//tr[2]//td[1]//div[1]//a[1]//span[1]"));

			if (cate.getText().equals(category)) {

				logger.info("Verify that user can able to select the meal category");
			}

		} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

		}

		// ------------------------------------------------------------------------------------------------//

		// MEAL - RECEPIE

		try {

			WebElement recepie = d.findElement(By.xpath("//tr[2]//td[1]//div[2]//a[1]//span[1]"));

			recepie.click();

			 WebElement dal = d.findElement(By.xpath("//a[contains(text(),'Jaggery Fruit Cake')]"));

			 dal.click();
	
			Thread.sleep(200);

			String category = "Jaggery Fruit Cake";

			WebElement cate = d.findElement(By.xpath("//tr[2]//td[1]//div[2]//a[1]//span[1]"));

			if (cate.getText().equals(category)) {
				
				logger.info("Verify that user can able to select the meal category");
			
			}
			
		} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

		}

			
		// 2ND PLAN
			
		// MEAL _ CATEGORY
			
			try {
							
				Thread.sleep(500);
									
				WebElement row1_cat  = d.findElement(By.xpath("//tr[2]//td[2]//div[1]//a[1]//span[1]"));
				
				row1_cat.click();
				
				Thread.sleep(200);
				
				WebElement cate =  d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Desserts')]"));
				
				cate.click();
							
				Thread.sleep(200);
				
				String category = "Desserts";
									
				if (row1_cat.getText().equals(category)) {
					
				logger.info("Verify that user can able to select the 2nd meal category");
			
				}			
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the 2nd meal category");
								
			}
			
			
			// MEAL - RECEPIE
				
			
			try {
			
				Thread.sleep(200);
				
				WebElement recepie  = d.findElement(By.xpath("//tr[2]//td[2]//div[2]//a[1]//span[1]"));
				
				recepie.click();
				
				Thread.sleep(200);
				
				WebElement recepie1  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Dal Payasam')]"));
				
				recepie1.click();
				
				Thread.sleep(200);
			
				String category = "Dal Payasam";
												
				if (recepie.getText().equals(category)) {
					
					logger.info("Verify that user can able to select the meal category");
					
				}
											
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the meal category");
								
			}
															
			
			// 3RD PLAN
		
			// MEAL _ CATEGORY
		
		try {
						
			Thread.sleep(500);
								
			WebElement row1_cat  = d.findElement(By.xpath("//tr[2]//td[3]//div[1]//a[1]//span[1]"));
			
			row1_cat.click();
			
			Thread.sleep(200);
			
			WebElement cate  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Snacks')]"));
			
			cate.click();
					
			Thread.sleep(200);
			
			String category = "Snacks";

			if (row1_cat.getText().equals(category)) {

				logger.info("Verify that user can able to select the 3rd meal category");

			}

		} catch (Exception e) {

			logger.error("Verify that user can able to select the 3rd meal category");

		}
		
		
		// MEAL - RECEPIE
			
	  try {
			
			Thread.sleep(200);
			
			WebElement recepie  = d.findElement(By.xpath("//tr[2]//td[3]//div[2]//a[1]//span[1]"));
			
			recepie.click();
			
			Thread.sleep(200);
			
			WebElement recepie1  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Palli Palayam Idli')]"));
			
			recepie1.click();
						
			Thread.sleep(200);
		
			String category = "Palli Palayam Idli";
			
			if (recepie.getText().equals(category)) {

			logger.info("Verify that user can able to select the meal category");

			}

			} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

			}
		
	}
	
	
@Test (priority =6)

public void menuplan_row3() {
			
	// MEAL _ CATEGORY

	try {

		Thread.sleep(500);

		WebElement row1_cat = d.findElement(By.xpath("//tr[3]//td[1]//div[1]//a[1]//span[1]"));
		row1_cat.click();

		Thread.sleep(200);

		WebElement re_cat = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Desserts')]"));
		re_cat.click();

		Thread.sleep(200);
	
		String category = "Desserts";

		WebElement cate = d.findElement(By.xpath("//tr[3]//td[1]//div[1]//a[1]//span[1]"));

		if (cate.getText().equals(category)) {
			
			logger.info("Verify that user can able to select the meal category");
			
		}
		

	} catch (Exception e) {

		logger.error("Verify that user can able to select the meal category");

	}

	// ------------------------------------------------------------------------------------------------//

	// MEAL - RECEPIE

	try {

		WebElement recepie = d.findElement(By.xpath("//tr[3]//td[1]//div[2]//a[1]//span[1]"));

		recepie.click();

		 WebElement dal = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Wheat Payasam')]"));

		 dal.click();

		Thread.sleep(200);

		String category = "Wheat Payasam";

		if (recepie.getText().equals(category)) {
			
			logger.info("Verify that user can able to select the meal category");
	
		}		

	} catch (Exception e) {

		logger.error("Verify that user can able to select the meal category");

	}

		
	// 2ND PLAN
		
	// MEAL _ CATEGORY
		
		try {
						
			Thread.sleep(500);
								
			WebElement row1_cat  = d.findElement(By.xpath("//tr[3]//td[2]//div[1]//a[1]//span[1]"));
			
			row1_cat.click();
			
			Thread.sleep(200);
			
			WebElement cate =  d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Salad')]"));
			
			cate.click();
			
			Thread.sleep(200);
			
			String category = "Salad";
			
			if (row1_cat.getText().equals(category)) {
		
			logger.info("Verify that user can able to select the 2nd meal category");
			
			}			
			
			
		} catch (Exception e) {
		
			logger.error("Verify that user can able to select the 2nd meal category");
							
		}
		
		
		// MEAL - RECEPIE
			
		
		try {
			
			WebElement recepie  = d.findElement(By.xpath("//tr[3]//td[2]//div[2]//a[1]//span[1]"));
			
			recepie.click();
			
			WebElement recepie1  = d.findElement(By.xpath("//a[contains(text(),'Peanut Salad')]"));
			
			recepie1.click();
			
			Thread.sleep(200);
		
			String category = "Peanut Salad";			
				
			if (recepie.getText().equals(category)) {

				logger.info("Verify that user can able to select the meal category");
				
			}
									
		} catch (Exception e) {
		
			logger.error("Verify that user can able to select the meal category");
							
		}
														
		
// 3RD PLAN
	
// MEAL _ CATEGORY
	
	try {
					
		Thread.sleep(500);
							
		WebElement row1_cat  = d.findElement(By.xpath("//tr[3]//td[3]//div[1]//a[1]//span[1]"));
		
		row1_cat.click();
		
		Thread.sleep(200);
		
		WebElement cate  = d.findElement(By.xpath("//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Soup')]"));
		
		cate.click();
				
		Thread.sleep(200);
		
		String category = "Soup";
		
		if (row1_cat.getText().equals(category)) {
			
			logger.info("Verify that user can able to select the 3rd meal category");
			
		}
			
		
	} catch (Exception e) {
	
		logger.error("Verify that user can able to select the 3rd meal category");
						
	}
	
	
	
	// MEAL - RECEPIE
		
	
		try {

			Thread.sleep(200);

			WebElement recepie = d.findElement(By.xpath("//tr[3]//td[3]//div[2]//a[1]//span[1]"));

			recepie.click();

			Thread.sleep(200);

			WebElement recepie1 = d.findElement(By.xpath(
					"//div[@class='dropdown-menu ng-scope show']//a[@class='ng-binding'][contains(text(),'Tomato Soup')]"));

			recepie1.click();

			Thread.sleep(200);

			String category = "Palli Palayam Idli";

			if (recepie.getText().equals(category)) {

				logger.info("Verify that user can able to select the meal category");

			}

		} catch (Exception e) {

			logger.error("Verify that user can able to select the meal category");

		}	
	}

		// **************************************************************************************** //
	
	/*
		// LUNCH PLANNING
		
		@Test (priority = 5)
		
		public void Lunch() {
			
			try {
				
				Thread.sleep(200);
				
				WebElement lunch = d.findElement(By.xpath("//*[@id=\"heading0\"]/h5/button"));
				lunch.isDisplayed();
				
				lunch.click();
				
				logger.info("Verify that if the Lunch  meal course card  is present");
				
			} catch (Exception e) {
						
			
				logger.error("Verify that if the Lunch  meal course card  is present");
			
			}
			
			// MEAL PLAN
			
			try {
						
				WebElement row = d.findElement(By.xpath("//*[@id=\"collapse0\"]/div/button"));
				
				row.click();	
									
				logger.info("if click add row button it should create the meal course add rows");
				
			} catch (Exception e) {
			
				logger.error("if click add row button it should create the meal course add rows");

			}		
			
			
			// MEAL _ CATEGORY
			
			try {
				
				
				Thread.sleep(500);
						
				WebElement row1_cat  = d.findElement(By.xpath("(//*[@id=\"category\"]/a)[1]"));
				
				row1_cat.click();
				
				WebElement re_cat = d.findElement(By.xpath("//*[@id=\"category\"]/div/div[1]/input[1]"));
				re_cat.sendKeys("Indian");
				
				Thread.sleep(200);
				
				re_cat.sendKeys(Keys.ENTER);
							
				Thread.sleep(200);
				
				String category = "Indian Gravy";
				
				WebElement cate = d.findElement(By.xpath("(//*[@id=\"category\"]/a)[1]"));
				
				cate.getText().equals(category);		
				
				logger.info("Verify that user can able to select the meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can't able to select the meal category");
								
			}
			
			
			// MEAL - RECEPIE
				
			
			try {
				
				WebElement recepie  = d.findElement(By.xpath("(//*[@id=\"reciperecipe\"]/a)[1]"));
				
				recepie.click();
				
				WebElement dal = d.findElement(By.xpath("//*[@id=\"reciperecipe\"]/div/div[1]/input[1]"));
				
				dal.sendKeys("Dal Pay");
				
				dal.sendKeys(Keys.ENTER);
			
				Thread.sleep(200);
			
				String category = "Paneer Makhani";
				
				WebElement cate = d.findElement(By.xpath("(//*[@id=\"reciperecipe\"]/a)[1]"));
				
				cate.getText().equals(category);		
				
				logger.info("Verify that user can able to select the meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the meal category");
								
			}
					
			

			try {
						
				WebElement row = d.findElement(By.xpath("//*[@id=\"collapse1\"]/div/button"));
				
				row.click();	
									
				logger.info("if click add row button it should create the meal course add rows");
				
			} catch (Exception e) {
			
				logger.error("if click add row button it should create the meal course add rows");

			}		
				
			
		// 2ND PLAN
			
			
		// MEAL _ CATEGORY
			
			try {
							
				Thread.sleep(500);
									
				WebElement row1_cat  = d.findElement(By.xpath("(//*[@id=\"category\"]/a)[2]"));
				
				row1_cat.click();
				
				Thread.sleep(200);
				
				WebElement re_cat = d.findElement(By.xpath("//*[@id=\"category\"]/div/ul/li[6]/a"));
			
				re_cat.click();
				
				Thread.sleep(200);
				
			//	re_cat.sendKeys(Keys.ENTER);
							
				Thread.sleep(200);
				
				String category = "Main Course";
				
				WebElement cate = d.findElement(By.xpath("(//*[@id=\"category\"]/a)[2]"));
				
				cate.getText().equals(category);		
				
				logger.info("Verify that user can able to select the meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the meal category");
								
			}
			
			
			// MEAL - RECEPIE
				
			
			try {
				
				WebElement recepie  = d.findElement(By.xpath("(//*[@id=\"reciperecipe\"]/a)[2]"));
				
				recepie.click();
				
				WebElement dala = d.findElement(By.xpath("//*[@id=\"reciperecipe\"]/div/ul/li[1]/a"));
				
				dala.click();
				
				Thread.sleep(200);
			
				String category = "Peanut Salad";
				
				WebElement catea = d.findElement(By.xpath("(//*[@id=\"reciperecipe\"]/a)[2]"));
				
				catea.getText().equals(category);		
				
				logger.info("Verify that user can able to select the meal category");
							
				
			} catch (Exception e) {
			
				logger.error("Verify that user can able to select the meal category");
								
			}
			
			// CHECK BOX
			
			try {

				WebElement check = d.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div/table/thead/tr/th/label/input"));

				check.isEnabled();

				Thread.sleep(200);

				check.click();

				logger.info("User can able to select the check box");

			} catch (Exception e) {

				logger.error("User can able to select the check box");

			}	
		
			
		}
	
		// **************************************************************************************** //
	*/
	
		@Test (priority = 7)
		
		public void Menu_plan_client() {
			
			
			// Client Type_School

			try {

				WebElement corporate = d.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/div[2]/div[1]/div/ul"));

				String text = corporate.getText().toString();

				System.out.println(text);
							
				WebElement client = d
						.findElement(By.xpath("//label[@class='radio-label']//span[@class='ng-binding'][contains(text(),'School')]"));

				if (client.isDisplayed()) {

					client.click();

					logger.info("user can able to select the client type into school");

				} else {

					logger.error("user can able to select the client type into school");
				}
				
				
				if (client.isSelected()) {

					
					logger.info("verify that if select client type is school the ratio button it should be active");
	
				}
				
				} catch (Exception e) {

					logger.error("verify that if select client type is school the ratio button it should be active");

				}
					
		
			// CLIENT CATEGORY    
	 
			try {
				

				WebElement primary = d
						.findElement(By.xpath("//span[contains(text(),'Primary')]"));
				
				WebElement secondary  = d
						.findElement(By.xpath("//span[contains(text(),'Secondary')]"));
							
				String c_cate1 = "Primary";
			
				String c_cate2 = "Seconday";

				if (primary.getText().equals(c_cate1) && secondary.getText().equals(c_cate2)) {
					
					logger.info("If click Client type as School it should display the client type as Primary and Secondary");
					
				}
			}				
					
			catch (Exception e) {
				
				logger.info("If click Client type as School it should display the client type as Primary and Secondary");
							
			}
			
			
			// CLIENT CATEGOERY
			
			try {
				
				WebElement secondary  = d
						.findElement(By.xpath("//span[contains(text(),'Secondary')]"));
				
				secondary.click();
				
				if (secondary.isSelected()) {
					
					logger.info("Verify that if click client category as Secondary it should active the radio button");
					
				}
				
			} catch (Exception e) {
				
				logger.info("Verify that if click client category as Secondary it should active the radio button");
				
			}
					
					
			// Spread Type
				
			try {

				Thread.sleep(200);

				WebElement spread = d.findElement(By.xpath("//span[contains(text(),'3 Spread')]"));
				
				if (spread.isDisplayed()) {
					
				spread.click();

				logger.info("User can able to select the spread type into 3 Spread");
					
				}
				
			} catch (Exception e) {

				logger.info("User can able to select the spread type into 3 Spread");
			}

			
			
			// Meal Course -  BREAKFAST
			
			try {
				
				// LUNCH
				
				Thread.sleep(200);
				
				WebElement brk = d.findElement(By.xpath("//button[@title='Lunch']"));
				
				if (brk.isDisplayed()) {

					brk.click();
									
				}
				
				Thread.sleep(200);
				
				// BREAK FAST
				
				WebElement mtime = d.findElement(By.xpath("//span[contains(text(),'Breakfast')]"));
				
				if (mtime.isDisplayed()) {

					mtime.click();
						
				}
				
				// De-Select
				
				WebElement lunch = d.findElement(By.xpath("//span[@class='text'][contains(text(),'Lunch')]"));
				
				if (lunch.isDisplayed()) {
				
					lunch.click();
				}
						
				
				Thread.sleep(200);
				
				WebElement close = d.findElement(By.xpath("//button[@title='Breakfast']"));
				
				close.click();
				
				Thread.sleep(200);
				
				logger.info("Verify that user can able to select the meal course");	
				
			} catch (Exception e) {
				
				logger.error("Verify that user can able to select the meal course");	
							
			}
			
		}
		
		
		@Test (priority = 8)
		
		public void assignedClient() {
			
			// 	Assign Client - Displayed

			try {

			Thread.sleep(200);

			WebElement assign = d.findElement(By.xpath("//span[contains(text(),'Vidhya Vikas School-')]"));

			assign.isDisplayed();
			
			logger.info("Verify that it should display the  Client while filtering the client type, Category, Spread type");

			Thread.sleep(200);
				
			assign.click();

			if (assign.isSelected()) {
				
				logger.info("Verify that if click the Client it should selected the check box automatically");
			}
						
		} catch (Exception e) {

			logger.error("Verify that it should display the  Client while filtering the client type, Category, Spread type");

			logger.error("Verify that if click the Client it should selected the check box automatically");


		}
			
		// ASSIGN

		try {

			WebElement assignbtn = d.findElement(By.xpath("//button[@class='btn btn-primary assign_btn']"));

			if (assignbtn.isDisplayed() && assignbtn.isEnabled()) {

				logger.info("Verify that whether the assign button is enabled or not");

				assignbtn.click();
								
			}

		} catch (Exception e) {

			logger.error("Verify that whether the assign button is enabled or not");

		}
		
		// Plan Alert
		
		try {
			
			Thread.sleep(2000);
						
			Alert alert = d.switchTo().alert();
			
			alert.accept();
			
			logger.info("Verify that if click the Assign button it should display the success Alert message for Menu has planned");			
			
		} catch (Exception e) {
			
			logger.error("Verify that if click the Assign button it should display the success Alert message for Menu has planned");
		}
		
						
		// PROCEED TO MENU
		
		try {

			WebElement proceed = d.findElement(By.id("assigned_clients"));

			if (proceed.isEnabled()) {

			proceed.click();

			logger.info("If click Proceed to menu button it should redirect to Menu cycle screen automatically");
							
			}

		} catch (Exception e) {

			logger.error("If click Proceed to menu button it should redirect to Menu cycle screen automatically");

		}

	}
		
	// **************************************************************************************** //
		
  
  @BeforeTest
  
  public void beforeTest() {
	  
			
		try {
		 
			logger = logger.getLogger("Habitos - Menu Planner");

			PropertyConfigurator.configure("log4jproperties.txt");
			
			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			  d = new ChromeDriver();

		//	logger.info("browser gets open");

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
