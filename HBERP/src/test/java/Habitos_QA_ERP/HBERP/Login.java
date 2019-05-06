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

public class Login {

	static WebDriver d;
	
	static org.apache.log4j.Logger logger;
		
  // IN_ VALID LOGIN
	
	@Test (priority = 1)
  
	public void Invalid_Login() {

	{
 
			d.manage().window().maximize();
			 
			logger = logger.getLogger("Habitos - LOGIN");

			String un = "vivek";
			String pw = "vivek kumar";

			WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
			WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
			WebElement submit = d.findElement(By.name("commit"));

			if (uname.isDisplayed()) {

				logger.info("Verify that if the User Name field is present ");

			} else {

				logger.error("Verify that if the User Name field is present ");

			}

			if (uname.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the username fields get autofocus");

				uname.sendKeys(un);

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

				pwd.sendKeys(pw);

			} else {

				logger.error("Verify that if the password fields get focused");
			}

			if (submit.isEnabled()) {

				submit.click();

				String url = "http://192.168.1.230:4000";

				String curl = d.getCurrentUrl();

				if (d.getCurrentUrl().equals(url)) {

					logger.error("Verify that if the user can't able to login with Invalid credentials");

				} else {

					logger.info("Verify that if the user can't able to login with Invalid credentials");

				}

			} else {

				logger.error("Verify that user can't able to click the submit");

			}
	  }
  }
	
	@Test (priority = 2)
	  
	public void Invalid_Login1() {

		{
			logger = logger.getLogger("Habitos - LOGIN");
 
			String un = "    ";
			String pw = "    ";

			WebElement uname = d.findElement(By.id("kitchen_user_user_name"));
			WebElement pwd = d.findElement(By.id("kitchen_user_password_digest"));
			WebElement submit = d.findElement(By.name("commit"));

			if (uname.isDisplayed()) {

				logger.info("Verify that if the User Name field is present ");

			} else {

				logger.error("Verify that if the User Name field is present ");

			}

			if (uname.equals(d.switchTo().activeElement())) {

				logger.info("Verify that if the username fields get autofocus");

				uname.sendKeys(un);

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

				pwd.sendKeys(pw);

			} else {

				logger.error("Verify that if the password fields get focused");
			}

			if (submit.isEnabled()) {

				submit.click();

				String url = "http://192.168.1.230:4000";

				String curl = d.getCurrentUrl();

				if (d.getCurrentUrl().equals(url)) {

					logger.error("Verify that if the user can't able to login with Invalid credentials");

				} else {

					logger.info("Verify that if the user can't able to login with Invalid credentials");

				}

			} else {

				logger.error("Verify that user can't able to click the submit");

			}
	  }
  }
  	
  // VALID LOGIN 
  
  @Test (priority = 3)
  
  public void Valid_Login() throws InterruptedException {
	  
	  logger = logger.getLogger("Habitos - LOGIN");
  
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
    
  // PROPERTY CONFIGURATION 
   
  @BeforeTest
  
    public void beforeTest() {
  
	  try {
  
			logger = logger.getLogger("Habitos - LOGIN");

			PropertyConfigurator.configure("log4jproperties.txt");

			Thread.sleep(100);

			System.setProperty("webdriver.chrome.driver", "../HBERP/resources/chromedriver.exe");

			d = new ChromeDriver();

			logger.info("browser gets open");

			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);

			d.manage().window().maximize();

			Thread.sleep(2000);

			d.get("http://192.168.1.230:4000");

			logger.info("browser gets valid ip address");

		}

		catch (Exception e) {

			System.out.println(e);
			
		System.out.println("Login is not working");

		}

}
  
  // Browser Closed
  
  @AfterTest
  
  public void afterTest() {
	  
	  d.close();
 }
  
}
