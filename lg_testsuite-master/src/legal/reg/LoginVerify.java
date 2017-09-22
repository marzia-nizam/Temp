package legal.reg;
import static com.heliumhq.API.*;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginVerify extends LegalRegressionSharedFunctions {
  @Test
  public void Login() throws InterruptedException, AWTException {
	  
       LegalRegressionSharedFunctions.Login("THE TESTING ACCOUNT");
       LegalRegressionSharedFunctions.Logout();
       ForgetPassword();
       InvalidCredentials();
	   ResetPassword();
  }
  
  public void ForgetPassword() throws InterruptedException, AWTException
  {
	  driver.findElement(By.xpath(".//small[contains(text(),'Forgot password?')]")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("automation.test.5152+28982032@gmail.com");
	  driver.findElement(By.xpath(".//button[contains(text(),'Reset Password')]")).click();
	  String MainWindowHandle = driver.getWindowHandle();
      
  	  //open a new firefox window
  	    WebDriver driver2=null;
  	
  		ChromeOptions options1 = new ChromeOptions();
  		options1.addArguments("--start-maximized");
  	    driver2 = new ChromeDriver( options1 );
  
  	  //in the new window, go to the intended page
    	  driver2.navigate().to("https://accounts.google.com/ServiceLogin?");
    	  Thread.sleep(2000);
    
    	// g mail login
    	driver2.findElement(By.id("identifierId")).sendKeys("automation.test.5152");
    	driver2.findElement(By.id("identifierNext")).click();
    	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("automation12345");
    	Thread.sleep(2000);
    	driver2.findElement(By.id("passwordNext")).click();
    	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver2.findElement(By.id("signIn")).click();

    	// some optional actions for reaching g mail in box 
    	 driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
    	driver2.findElement(By.id("gb23")).click();
        
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	    String MyMailer = "Legal Gateway";
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(unreademeil.get(i).getText().equals(MyMailer)){
		            System.out.println("Yes we have got mail form " + MyMailer);
		           
		            unreademeil.get(i).click();
		            driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
		          
		            String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }           
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).sendKeys("456789@");
		            Thread.sleep(2000);
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).sendKeys("456789@");
		           
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/button")).click();
		            
		            Thread.sleep(2000);
		            
		            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+28982032@gmail.com");
		            
                    //Now log in with old password	
		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("123456@");
		     		driver2.findElement(By.id("login-button")).click();
		     		highlight($(".alert"));
		     		waitFunction(2000);
		     		
		     	
		     		//Now log in with correct password but uppercase
		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys(CONTROL+"a");
		     		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("$%^&*(2");
		     		driver2.findElement(By.id("login-button")).click();
		     		highlight($(".alert"));
		     		waitFunction(2000);
		     		//Now log in with correct password
		     		
		     		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys(CONTROL+"a");
		     		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
		     		driver2.findElement(By.id("login-button")).click();
		   
		            break;
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		        
		    //    driver2.quit();
		   //     driver.close();
		    }
		}

  
  }

  public void InvalidCredentials() throws InterruptedException
  {
	  //Enter an invalid  email address
	  
	  driver.get("https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
	  driver.findElement(By.id("username")).sendKeys("ThisIsAnInvalidEmailID@invalid.com");
	  driver.findElement(By.id("password")).sendKeys("456789@");
	  driver.findElement(By.id("login-button")).click();
	  highlight($(".alert"));
	  
	  //Reset password for non LG user
	  
	  driver.findElement(By.xpath(".//small[contains(text(),'Forgot password?')]")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("automation.test.5152+7777@gmail.com");
	  click("Reset Password");
	  highlight($(".alert"));
	  
	  //check mail
       String MainWindowHandle = driver.getWindowHandle();
      
  	  //open a new firefox window
  	    WebDriver driver2=null;
  	
  		ChromeOptions options1 = new ChromeOptions();
  		options1.addArguments("--start-maximized");
  	    driver2 = new ChromeDriver( options1 );
  
  	  //in the new window, go to the intended page
    	  driver2.navigate().to("https://accounts.google.com/ServiceLogin?");
    	  Thread.sleep(2000);
    
    	// g mail login
    	driver2.findElement(By.id("identifierId")).sendKeys("automation.test.5152");
    	driver2.findElement(By.id("identifierNext")).click();
    	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("automation12345");
    	Thread.sleep(2000);
    	driver2.findElement(By.id("passwordNext")).click();
    	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver2.findElement(By.id("signIn")).click();

    	// some optional actions for reaching g mail in box 
    	driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
    	driver2.findElement(By.id("gb23")).click();
        
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	    String MyMailer = "Legal Gateway";
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(unreademeil.get(i).getText().equals(MyMailer)){
		            System.out.println("Yes we have got mail form " + MyMailer);		           
		   
		            
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		       
		      
		    }
		}
	//    driver.quit();
	    //forgot pass with uppercase username
	   
	    driver2.get("https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
	    waitFunction(20000);
	    driver2.findElement(By.xpath(".//small[contains(text(),'Forgot password?')]")).click();
		driver2.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("AUTOMATION.TEST.5152+28982032@GMAIL.COM");
		driver2.findElement(By.xpath(".//button[contains(text(),'Reset Password')]")).click();
		highlight($(".alert"));
	//	
		//check mail 
		//driver2.quit();
	
		  
	  	  //in the new window, go to the intended page
	    	  driver2.navigate().to("https://accounts.google.com/ServiceLogin?");
	    	  Thread.sleep(2000);
	    
	    	// g mail login
	  /*  	driver2.findElement(By.id("identifierId")).sendKeys("automation.test.5152");
	    	driver2.findElement(By.id("identifierNext")).click();
	    	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("automation12345");
	    	Thread.sleep(2000);
	    	driver2.findElement(By.id("passwordNext")).click();
	    	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	//driver2.findElement(By.id("signIn")).click();*/

	    	// some optional actions for reaching g mail in box 
	    	 driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
	    	driver2.findElement(By.id("gb23")).click();
	    	List<WebElement> unreademeil2 = driver2.findElements(By.xpath("//*[@class='zF']"));
		  
		    for(int i=0;i<unreademeil2.size();i++)
			{
			    if(unreademeil2.get(i).isDisplayed()==true){
			     
			    	//String parentHandle2 = driver2.getWindowHandle(); 
			    	
			        if(unreademeil2.get(i).getText().equals(MyMailer)){
			            System.out.println("Yes we have got mail form " + MyMailer);		           
			   
			            break;
			        }
			        else{
			            System.out.println("No mail form " + MyMailer);
			        }
			       
			      
			    }
			}
	     //  driver3.quit();
  }

  public void ResetPassword() throws InterruptedException
  {
	  driver.get("https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
	  driver.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+28982032@gmail.com");      
      driver.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
	  driver.findElement(By.id("login-button")).click();
	  
	  Thread.sleep(20000);
	  click("Settings");
	  click("Users");
	  driver.findElement(By.xpath(".//*[@id='search']")).sendKeys("automation.test.5152+28982032@gmail.com");
	  click("Severus Snape");
	  click("Reset Password");
	  waitFunction(20000);
	  
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Success: a password reset link has been email to automation.test.5152+28982032@gmail.com')]")));
	  
	  //check mail
	  
	  WebDriver driver2=null;
	  	
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--start-maximized");
	    driver2 = new ChromeDriver( options1 );

	  //in the new window, go to the intended page
  	  driver2.navigate().to("https://accounts.google.com/ServiceLogin?");
  	  Thread.sleep(2000);
  
  	// g mail login
  	driver2.findElement(By.id("identifierId")).sendKeys("automation.test.5152");
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("automation12345");
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();

  	// some optional actions for reaching g mail in box 
  driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
  	driver2.findElement(By.id("gb23")).click();
      
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	    String MyMailer = "Legal Gateway";
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(unreademeil.get(i).getText().equals(MyMailer)){
		            System.out.println("Yes we have got mail form " + MyMailer);
		           
		            unreademeil.get(i).click();
		            driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
		          
		            String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }           
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).sendKeys("456789@");
		            Thread.sleep(2000);
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).sendKeys("456789@");
		           
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/button")).click();
		            
		            Thread.sleep(2000);
		            
		            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+28982032@gmail.com");
		   
		     		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
		     		driver2.findElement(By.id("login-button")).click();
		   
		            break;
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		        
		        driver2.quit();
		        driver.close();
		    }
		}
  }
  
  }


