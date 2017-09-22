package legal.reg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.relation.RoleResult;

import org.junit.Assert;
//import static com.heliumhq.API.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SignUp extends LegalRegressionSharedFunctions {
  @Test
  public void TestSignUp() throws InterruptedException {
	  //LegalRegressionSharedFunctions.Login("THE TESTING ACCOUNT");
	  
	  //SendUserInvite();
	  //SignUpUrl();
	  
	  SignUpToCreateAccount("test4fest+2753@gmail.com", "12345mmm");
	  //driver.close();
	  
	  switchToNewTab(5, "https://ext.legalgateway.com.au/gateway/signup");
	  SignUpWarningValidation();
	  //driver.quit();
	  
	  loginToPlexus("https://ext.legalgateway.com.au/gateway/login?next=/gateway/", "test2fest18+4@gmail.com", "12345mmm");
	   
	  
	  clickSideBarItem("Settings");
	  Thread.sleep(5000);
	  clickSideBarItem("Users");
	  Thread.sleep(3000);
	  verifyUserListPageAppears();
	  
	  
	  inviteUser("test2fest18+4@gmail.com", "test3fest18@gmail.com");
	  
	  searchForUserAndVerify("test3fest18@gmail.com");
	  clickOnTheResult();
	  Thread.sleep(5000);
	  deleteUser();
	  checkIfWarningMessageAppears("test3fest18@gmail.com has been deleted");
	  
	  
	  
	  Thread.sleep(2000);
	  inviteUser("test2fest18+4@gmail.com", "test3fest18@gmail.com");
	  Thread.sleep(5000);
	  checkIfWarningMessageAppears("User test3fest18@gmail.com has used the Legal Gateway in the past. If they accept your invitation they will have access to all documents etc they had before");
	  
	  Thread.sleep(2000);
	  //driver.close();
	  switchToNewTab(6, "https://accounts.google.com/ServiceLogin?");
	  Thread.sleep(2000);
	  loginToGmail("test3fest18@gmail.com", "12345mmm");
	  Thread.sleep(5000);
	  verifyNewEmail("Legal Gateway", "Join THE TESTING ACCOUNT on Legal Gateway");
	  clickNewEmail("Legal Gateway", "Join THE TESTING ACCOUNT on Legal Gateway");
	  clickOnTheGeneratedEmailLink("Join THE TESTING ACCOUNT on Legal Gateway");
	  Thread.sleep(2000);
	  //driver.switchTo().defaultContent();
	  //driver.close();
	  jumpToOpenedNewTab(7);
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  setPassword("test", "account", "12345mmm", "12345mmm");
	  
	  
	  /*
	  String p= driver.getWindowHandle();
	  switchToNewTab(1, "https://accounts.google.com/ServiceLogin?");
	  //String p= driver.getWindowHandle();
	  loginToGmail("test3fest18@gmail.com", "12345mmm");
	  
	  signOutFromGmail();
	  driver.quit();
	  
	  LaunchBrowser();
	  //switchToNewTab(1, "https://accounts.google.com/ServiceLogin?");
	  
	  //driver.switchTo().window(p);
	  driver.navigate().to("https://accounts.google.com/ServiceLogin?");
	  loginToGmail("test4fest@gmail.com", "12345mmm");
	  */
	  
	  
	  
  }
  
  public void verifyUserListPageAppears() throws InterruptedException
  {
	  Thread.sleep(5000);
	  if(driver.findElement(By.xpath(".//div[@class='clients-list']")).isDisplayed())
	  {
		  System.out.println("user list page displayed!");
	  }
	  else
	  {
		  System.out.println("user list page did not display");
	  }
  }
  
  public void clickOnTheResult() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//li[text()='Settings']/following::table[@class='table table-striped table-hover']/tbody/tr/td[2]/a")).click();
  }
  
  public void deleteUser()
  {
	  driver.findElement(By.xpath(".//div[text()='Delete User']")).click();;
  }
  
  public void searchForUserAndVerify(String email)
  {
	  driver.findElement(By.id("search")).sendKeys(email);
	  
	  String rowXpath = ".//li[text()='Settings']/following::table[@class='table table-striped table-hover']/tbody/tr";
	  
	  List<WebElement> RowsTracking = driver.findElements(By.xpath(rowXpath));
	  
	  for (int i = 1; i <= RowsTracking.size(); i++) {
          String xpathRows = "(.//li[text()='Settings']/following::table[@class='table table-striped table-hover']/tbody/tr)[" + i + "]";
          WebElement Row = driver.findElement(By.xpath(xpathRows));
          List<WebElement> Columns = Row.findElements(By.xpath(".//td"));
          //Map<String, String> mapTrackingUI = new HashMap<String, String>();

          for (int j = 1; j < Columns.size(); j++) {

              String trackingData = Columns.get(j).getText().toString();
              switch (j) {
                  case 3: {
                      
                	  if(trackingData.equals(email))
                	  {
                		  System.out.println("result matched with the searched value");
                	  }
                	  else
                	  {
                		  System.out.println("result did not match with the searched value");
                	  }
                      break;
                  }
                  
              }
          }

      }
	  
	  
	  
  }
  
  
  public void SendUserInvite() throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[2]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("automation.test.5152+256352@gmail.com");
	  
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  CheckMailandSign("automation.test.5152@gmail.com","automation12345");
	    
  }
  
  public void inviteUser(String existingEmail, String newEmail) throws InterruptedException
  {
	  driver.findElement(By.xpath(".//button[@id='invite-button']")).click();
	  driver.findElement(By.xpath(".//input[@id='email']")).click();
	  
	  driver.findElement(By.xpath(".//input[@id='email']")).sendKeys(existingEmail);
	  driver.findElement(By.xpath(".//button[@id='invite-button']")).click();
	  
	  Thread.sleep(4000);
	  if(checkIfWarningMessageAppears("User "+existingEmail+" already exists"))
	  {
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(".//button[@id='invite-button']")).click();
		  driver.findElement(By.xpath(".//input[@id='email']")).sendKeys(newEmail);
		  Thread.sleep(5000);
		  driver.findElement(By.xpath(".//button[@id='invite-button']")).click();
	  }
	 
	  
  }
  
  
  public void CheckMailandSign(String email,String password) throws InterruptedException
  {
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
  	driver2.findElement(By.xpath("/*[@id='gbwa']")).click();
  	driver2.findElement(By.id("gb23")).click();
        
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	 // now taking unread email form inbox into a list
		List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	    String MyMailer = "Legal Gateway";
	    
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(unreademeil.get(i).getText().equals(MyMailer)){
		            System.out.println("Yes we have got mail form " + MyMailer);
		           
		            unreademeil.get(i).click();
		            driver2.findElement(By.partialLinkText("https://alliancetest.au.auth0.com")).click();
		            //dev
		        //    driver2.findElement(By.partialLinkText("https://plxs-dev.au.auth0.com")).click();
		            String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }           
		            driver2.findElement(By.name("first_name")).sendKeys("Severus");
		            driver2.findElement(By.name("last_name")).sendKeys("Snape");
		            driver2.findElement(By.name("new_password1")).sendKeys("456789@");
		            driver2.findElement(By.name("new_password2")).sendKeys("456789@");
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[5]/label/input")).click();
		            driver2.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/button")).click();
		            Thread.sleep(20000);
		            
		            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+256352@gmail.com");
		     		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
		     		driver2.findElement(By.id("login-button")).click();
		                
		       /*    driver2.close(); // close newly opened window when done with it
		           driver2.switchTo().window(parentHandle2);
		    	    driver2.close(); // close newly opened window when done with it
		    	   driver2.switchTo().window(parentHandle);
		    	    Thread.sleep(20000);
		    	    driver2.close();
		            driver.switchTo().window(MainWindowHandle);*/
		            break;
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		    }
		}
	  
  }
  
  public void setPassword(String firstName, String lastName, String newPassword, String confirmPassword) throws InterruptedException
  {
	  
	  
	  //driver.get("https://app.legalgateway.com.au/gateway/signup");
	  Thread.sleep(2000);
      driver.findElement(By.name("first_name")).sendKeys(firstName);
      driver.findElement(By.name("last_name")).sendKeys(lastName);
      
      driver.findElement(By.name("new_password1")).sendKeys(newPassword);
      driver.findElement(By.name("new_password2")).sendKeys(confirmPassword+"1234555");
    
      driver.findElement(By.xpath(".//input[@placeholder ='Confirm Password']//following::input[1]")).click();
      
      driver.findElement(By.xpath(".//button[contains(text(),'Set Password')]")).click();
      Thread.sleep(4000);
      if(checkIfPasswordWarningAppears())
      {
    	  //e.printStackTrace();
    	  System.out.println("Password unmatch warning appeared!");
    	  
    	  driver.findElement(By.name("first_name")).clear();
    	  driver.findElement(By.name("first_name")).sendKeys(firstName);
          driver.findElement(By.name("last_name")).clear();
          driver.findElement(By.name("last_name")).sendKeys(lastName);
    	  
    	  
    	  Thread.sleep(1000);
    	  
    	  driver.findElement(By.name("new_password1")).clear();
    	  Thread.sleep(1000);
    	  driver.findElement(By.name("new_password1")).sendKeys(newPassword);
    	  Thread.sleep(1000);
    	  driver.findElement(By.name("new_password2")).clear();
    	  Thread.sleep(1000);
          driver.findElement(By.name("new_password2")).sendKeys(confirmPassword);
          
          driver.findElement(By.xpath(".//input[@placeholder ='Confirm Password']//following::input[1]")).click();
          
          driver.findElement(By.xpath(".//button[contains(text(),'Set Password')]")).click();
      }
      try
      {
    	  
      }
      catch(Exception e)
      {
    	  
      }
      
      Thread.sleep(2000);
      if(driver.findElement(By.xpath(".//button[@id='login-button']")).isDisplayed())
      {
    	  System.out.println("Redirected to login page!");
      }
      else
      {
    	  System.out.println(" Did not Redirect to login page!");
      }
      
      Thread.sleep(5000);
      
      
      driver.findElement(By.xpath(".//input[@placeholder='Email']")).sendKeys("test3fest18@gmail.com");
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("12345mmm");
      driver.findElement(By.xpath(".//button[@id='login-button']")).click();
      
      
      
      
    //step 4-5 to be injected here
      
      driver.findElement(By.xpath(".//h1[contains(text(),'Afternoon')]//following::a[@href='/gateway/apps/19']")).click();
      Thread.sleep(20000);
      if(driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/apps/19"))
      {
    	  System.out.println("Was able to access the app");
      }
      else
      {
    	  System.out.println("Was NOT able to access the app");
      }
      Thread.sleep(3000);
      driver.navigate().back();
      clickSideBarItem("Documents");
      Thread.sleep(5000);
      clickSideBarItem("Document List");
      
      //end here
      
      
      
      Thread.sleep(5);
      String MainWindowHandle = driver.getWindowHandle();
      String parentHandle = driver.getWindowHandle(); // get the current window handle
      switchToNewTab(8, "https://accounts.google.com/ServiceLogin?" );
      Thread.sleep(5000);
      //driver.get("https://accounts.google.com/ServiceLogin?");
      signOutFromGmail();
      
      Thread.sleep(6000);
      driver.navigate().to("https://accounts.google.com/ServiceLogin?");
      Thread.sleep(3000);
      loginToGmail("test3fest18@gmail.com", "12345mmm");
      
      
      verifyNewEmail("Patrick from Plexus", "Welcome to Legal Gateway");
    
    
  }
  
  //code marzia apu
  public void SignUpUrl() throws InterruptedException
  {
	  driver.get("https://ext.legalgateway.com.au/gateway/signup");
	  Thread.sleep(2000);
      driver.findElement(By.name("first_name")).sendKeys("Rhaenys");
      driver.findElement(By.name("last_name")).sendKeys("Targearyen");
      driver.findElement(By.name("email")).sendKeys("automation.test.5152+7023198@gmail.com");
      driver.findElement(By.name("new_password1")).sendKeys("456789@");
      driver.findElement(By.name("new_password2")).sendKeys("456789@");
      driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/div[6]/label/input")).click();
      driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/form/button")).click();
      Thread.sleep(2000);
      String MainWindowHandle = driver.getWindowHandle();
      
  	  //open a new firefox window
  	  WebDriver driver2=null;
  	
  		ChromeOptions options1 = new ChromeOptions();
  		options1.addArguments("--start-maximized");
  	    driver2 = new ChromeDriver( options1 );
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
	            driver2.findElement(By.partialLinkText("https://app.legalgateway.com.au/gateway/signup/activate")).click();
	          
	            String parentHandle2 = driver2.getWindowHandle(); 
	            for (String winHandle : driver2.getWindowHandles()) {
	      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	      	    }       
	            Thread.sleep(2000);
	            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+7023198@gmail.com");
	      	  driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
	      	  driver2.findElement(By.id("login-button")).click();
	   
	            break;
	        }
	        else{
	            System.out.println("No mail form " + MyMailer);
	        }
	    }
	}
   
	  
  }
  //static int increaser=
  public void SignUpToCreateAccount(String email, String password) throws InterruptedException
  {
	  driver.get("https://ext.legalgateway.com.au/gateway/signup");
	  Thread.sleep(2000);
	  Assert.assertTrue("Sign Up page did not appear", driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/signup") );
	  if(driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/signup"))
	  {
		  System.out.println("Sign up page appeared!");
	  }
	  else
	  {
		  System.out.println("Sign up page did not appear!");
	  }
	  
	  driver.findElement(By.name("first_name")).clear();
	  driver.findElement(By.name("first_name")).sendKeys("test");
      driver.findElement(By.name("last_name")).clear();
      driver.findElement(By.name("last_name")).sendKeys("account");
	  
	  
	  driver.findElement(By.name("email")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("email")).sendKeys(email);
	  driver.findElement(By.name("new_password1")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("new_password1")).sendKeys(password);
	  Thread.sleep(1000);
	  driver.findElement(By.name("new_password2")).clear();
	  Thread.sleep(1000);
      driver.findElement(By.name("new_password2")).sendKeys(password);
      
      driver.findElement(By.xpath(".//input[@placeholder ='Confirm Password']//following::input[1]")).click();
      
      driver.findElement(By.xpath(".//button[contains(text(),'Create Account')]")).click();
	  
      Thread.sleep(6000);
	  
      checkIfWarningMessageAppears("User account created. Please check your email to activate your account before logging in.");
      
      Thread.sleep(2000);
      
      Assert.assertTrue("Did not redirect to login page!", driver.findElement(By.xpath(".//button[@id='login-button']")).isDisplayed());
      if(driver.findElement(By.xpath(".//button[@id='login-button']")).isDisplayed())
      {
    	  System.out.println("Redirected to login page!");
      }
      else
      {
    	  System.out.println(" Did not Redirect to login page!");
      }
      
      
      Thread.sleep(2000);
      //String MainWindowHandle = driver.getWindowHandle();
      //driver.close();
      //String parentHandle = driver.getWindowHandle(); // get the current window handle
      switchToNewTab(1, "https://accounts.google.com/ServiceLogin?" );
      //driver.get("https://accounts.google.com/ServiceLogin?");
      loginToGmail("test4fest@gmail.com", password);
      Thread.sleep(5000);
      clickNewEmail("Legal Gateway", "Activate your account");
      activateAccount();
      Thread.sleep(4000);
      //driver.close();
      jumpToOpenedNewTab(2);
      Thread.sleep(4000);
      
      //driver.close();
      
      switchToNewTab(3, "https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
      Thread.sleep(5000);
      loginToPlexus("https://ext.legalgateway.com.au/gateway/login?next=/gateway/", email, password);
      
      //driver.findElement(By.xpath(".//input[@placeholder='Email' or @id='username']")).sendKeys(email);
      //Thread.sleep(1000);
      //driver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys(password);
      //driver.findElement(By.xpath(".//button[@id='login-button']")).click();
     // Thread.sleep(10000);
      
      //step 4-5 to be injected here
      
      driver.findElement(By.xpath(".//h1[contains(text(),'Afternoon')]//following::a[@href='/gateway/apps/19']")).click();
      Thread.sleep(20000);
      Assert.assertTrue("Was NOT able to access the app after creating account!", driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/apps/19"));
      if(driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/apps/19"))
      {
    	  System.out.println("Was able to access the app");
      }
      else
      {
    	  System.out.println("Was NOT able to access the app");
      }
      Thread.sleep(3000);
      driver.navigate().back();
      clickSideBarItem("Documents");
      Thread.sleep(5000);
      clickSideBarItem("Document List");
      
      //end here
      
      Thread.sleep(5000);
      
      //driver.close();
      
      switchToNewTab(4, "https://accounts.google.com/ServiceLogin?");
      Thread.sleep(5000);
      signOutFromGmail();
      driver.navigate().to("https://accounts.google.com/ServiceLogin?");
      
      Thread.sleep(5000);
      loginToGmail("test4fest@gmail.com", password);
      
      verifyNewEmail("Patrick from Plexus", "Welcome to Legal Gateway");
      
      signOutFromGmail();
	  
  }
  
  public void SignUpWarningValidation() throws InterruptedException
  {
	  driver.get("https://ext.legalgateway.com.au/gateway/signup");
	  Thread.sleep(2000);
	  
	  if(driver.getCurrentUrl().equals("https://ext.legalgateway.com.au/gateway/signup"))
	  {
		  System.out.println("Sign up page appeared!");
	  }
	  else
	  {
		  System.out.println("Sign up page did not appear!");
	  }
	  
      driver.findElement(By.name("first_name")).sendKeys("Rhaenys");
      driver.findElement(By.name("last_name")).sendKeys("Targearyen");
      driver.findElement(By.name("email")).sendKeys("testers161@gmail.com");
      driver.findElement(By.name("new_password1")).sendKeys("456789@");
      driver.findElement(By.name("new_password2")).sendKeys("456789@");
    
      driver.findElement(By.xpath(".//input[@placeholder ='Confirm Password']//following::input[1]")).click();
      
      driver.findElement(By.xpath(".//button[contains(text(),'Create Account')]")).click();
      Thread.sleep(2000);
      if(checkIfWarningMessageAppears())
      {
    	  System.out.println("User already exists and warning message appeared!");
    	  
    	  driver.findElement(By.name("first_name")).clear();
    	  driver.findElement(By.name("first_name")).sendKeys("Rhaenys");
    	  driver.findElement(By.name("last_name")).clear();
    	  driver.findElement(By.name("last_name")).sendKeys("Targearyen");
    	  driver.findElement(By.name("email")).clear();
          driver.findElement(By.name("email")).sendKeys("Testers161@gmail.com");
          driver.findElement(By.name("new_password1")).clear();
          driver.findElement(By.name("new_password1")).sendKeys("456789@");
          driver.findElement(By.name("new_password2")).clear();
          driver.findElement(By.name("new_password2")).sendKeys("456789@");
        
          driver.findElement(By.xpath(".//input[@placeholder ='Confirm Password']//following::input[1]")).click();
          
          driver.findElement(By.xpath(".//button[contains(text(),'Create Account')]")).click();
          Thread.sleep(10000);
          try
          {
        	  if(checkIfWarningMessageAppears())
        	  {
            	  System.out.println("Altered with Uppercase letter Still User already exists and warning message appeared!");
            	  
            	  
              }
          }
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
          
    	  //e.printStackTrace();
    	  
      }
      try
      {
    	  
      }
      catch(Exception e)
      {
    	  
      }
      
      
      
      //verifyNewEmail("Legal Gateway", "Welcome to Legal Gateway");
      
      
    /*
    List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
    String MyMailer = "Legal Gateway";
    for(int i=0;i<unreademeil.size();i++)
	{
	    if(unreademeil.get(i).isDisplayed()==true){
	     
	    	//String parentHandle2 = driver2.getWindowHandle(); 
	    	
	        if(unreademeil.get(i).getText().equals(MyMailer)){
	            System.out.println("Yes we have got mail form " + MyMailer);
	           
	            unreademeil.get(i).click();
	            driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/signup/activate")).click();
	          
	            String parentHandle2 = driver2.getWindowHandle(); 
	            for (String winHandle : driver2.getWindowHandles()) {
	      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	      	    }       
	            Thread.sleep(2000);
	            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys("automation.test.5152+7023198@gmail.com");
	      	  driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
	      	  driver2.findElement(By.id("login-button")).click();
	   
	            break;
	        }
	        else{
	            System.out.println("No mail form " + MyMailer);
	        }
	    }
	}
   */
    
    
  }
  
  
  public void switchToNewTab(int tabIndex, String urlToVisit) throws InterruptedException
  {
      ((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
      ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs.get(tabIndex));
      Thread.sleep(1000);
      driver.get(urlToVisit);
  }
  public void jumpToOpenedNewTab(int tabIndex) throws InterruptedException
  {
      //((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
      ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs.get(tabIndex));
      Thread.sleep(1000);
      //driver.get(urlToVisit);
  }
  
  public void loginToGmail(String email, String password) throws InterruptedException
  {
	  try
	  {
		  driver.findElement(By.xpath(".//div[@aria-label='Switch account']")).click();
		  
		  Thread.sleep(3000);
		  
		  //driver.findElement(By.xpath(".//p[text()='"+email+"']")).click();
		  
		  driver.findElement(By.xpath(".//p[contains(text(),'Use another account')]//ancestor::div[@id='identifierLink']")).click();
		  
		  Thread.sleep(3000);
	  }
	  catch(Exception e)
	  {
		  
	  }
	  
      try
      {
          driver.findElement(By.id("identifierId")).sendKeys(email);
          driver.findElement(By.id("identifierNext")).click();
      }
      catch(Exception e)
      {
          System.out.println("Gmail Login : Email field already filled up! waiting for password...");
      }


      

      driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

      try
      {
          driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(password);
          Thread.sleep(2000);
          driver.findElement(By.id("passwordNext")).click();
      }
      catch (Exception e)
      {
    	  
          Thread.sleep(2000);
          driver.findElement(By.xpath(".//span[text()='Next']")).click();
          //e.printStackTrace();
      }

      try
      {
    	  //for recovery option
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath(".//div[text()='Done']")).click();
      }
      catch(Exception e)
      {
    	  
      }
      driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
      
      driver.findElement(By.xpath(".//a[@title='Google apps' or @aria-label='Google apps']")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("gb23")).click();

  }
  
  public void clickNewEmail(String mailFrom, String subject)
  {
      //driver.findElement(By.xpath("//a[@title='Google apps']")).click();
      //driver2.findElement(By.id("gb23")).click();

      String parentHandle = driver.getWindowHandle(); // get the current window handle
      // now taking unread email form inbox into a list
      List<WebElement> unreadEmail = driver.findElements(By.xpath("//*[@class='zF']"));
      //String mailFrom = "Legal Gateway";


      String subjectXpath=".//div[@class='y6']//child::b[text()='"+subject+"']";
      List<WebElement> subjects = driver.findElements(By.xpath(subjectXpath));



      for(int i=0;i<unreadEmail.size();i++)
      {

          if(unreadEmail.get(i).isDisplayed()==true){

              //String parentHandle2 = driver2.getWindowHandle();

              if(unreadEmail.get(i).getText().equals(mailFrom)){
                  counter ++;
                  System.out.println("desired email " + subject + " ");
                  System.out.println(counter+". Received e-mail from " + mailFrom);
                  for(WebElement ele: subjects )
                  {
                      if(ele.isDisplayed())
                      {
                          System.out.println("Email subject :" + subject + " Found");
                          ele.click();
                      }
                      else
                          System.out.println("Email subject :" + subject + " NOT Found");

                      break;

                  }

                  //break;
              }
              else{
                  System.out.println("No mail form " + mailFrom);
              }
              break;
          }
          //break;
      }

  }
  
  public void clickOnTheGeneratedEmailLink(String emailSubject) throws InterruptedException
  {
	  String roleItemXpath = ".//h2[contains(text(),'"+emailSubject+"')]//following::div[@role='listitem']";
	  List<WebElement> roleItems = driver.findElements(By.xpath(roleItemXpath));
	  int desiredRoleItemNo = roleItems.size();
	  
	  WebElement desiredLink = driver.findElement(By.xpath(".//h2[contains(text(),'"+emailSubject+"')]//following::div[@role='listitem']["+desiredRoleItemNo+"]//h2[text()='Join Team']//following::a[1]"));
	  Thread.sleep(2000);
	  desiredLink.click();
	  
	  //driver.close();
	  //jumpToOpenedNewTab(tabIndex);
	  
	  
	  
  }
  
  public void activateAccount() throws InterruptedException
  {
	  String roleItemXpath = ".//h2[contains(text(),'Activate your account')]//following::div[@role='listitem']";
	  List<WebElement> roleItems = driver.findElements(By.xpath(roleItemXpath));
	  int desiredRoleItemNo = roleItems.size();
	  
	  WebElement desiredLink = driver.findElement(By.xpath(".//h2[contains(text(),'Activate your account')]//following::div[@role='listitem']["+desiredRoleItemNo+"]//h2[text()='Welcome to Legal Gateway']//following::a[1]"));
	  Thread.sleep(2000);
	  desiredLink.click();
	  
	  //driver.close();
	  //jumpToOpenedNewTab(tabIndex);
	
  }
  
  
  static int counter=0;
  public void verifyNewEmail(String mailFrom, String emailSubject) throws InterruptedException
  {

      String parentHandle = driver.getWindowHandle(); // get the current window handle

      List<WebElement> unreadEmail = driver.findElements(By.xpath("//*[@class='zF']"));

      String subjectXpath=".//div[@class='y6']//child::b[contains(text(),'"+emailSubject+"')]";
      List<WebElement> subjects = driver.findElements(By.xpath(subjectXpath));

      boolean expectedEmailFound = false;
      for(int i=0;i<unreadEmail.size();i++)
      {
          if(unreadEmail.get(i).isDisplayed())
          {

              if(unreadEmail.get(i).getText().contains(mailFrom))
              {
                  Assert.assertFalse("Expected E-mail not received!", subjects.isEmpty());
                  for (WebElement ele : subjects)
                  {
                      Assert.assertTrue("New Email for account creation has not received!",ele.isDisplayed() && ele.getText().contains(emailSubject));
                      if (ele.isDisplayed() && ele.getText().contains(emailSubject))
                      {
                          counter++;
                          System.out.println();
                          System.out.println(counter + ". Received e-mail from " + mailFrom);
                          System.out.println("Email subject :" + ele.getText());
                          expectedEmailFound = true;
                          break;
                      }
                  }
              }

          }
          if(expectedEmailFound)
          {
              break;
          }

      }

  }
  
  
  public boolean checkIfWarningMessageAppears()
  {
	  WebElement warningMessage = driver.findElement(By.xpath(".//div[contains(text(),'The user already exists.')]"));
	  
	  Assert.assertTrue("Warning Message is not appearing for existing account", warningMessage.isDisplayed());
	  if(warningMessage.isDisplayed())
	  {
		  return true;
	  }
	  else
		  return false;
  }
  
  public boolean checkIfPasswordWarningAppears() throws InterruptedException
  {
	  Assert.assertTrue("Password unmatch warning did not appear", driver.findElement(By.xpath(".//li[contains(text(),'The two password fields didn')]")).isDisplayed());
	  if(driver.findElement(By.xpath(".//li[contains(text(),'The two password fields didn')]")).isDisplayed())
	  {
		  Thread.sleep(3000);
		  System.out.println(driver.findElement(By.xpath(".//li[contains(text(),'The two password fields didn')]")).getText());
		  return true;
	  }
	  else
	  {
		  System.out.println("No error message appeared!");
		  return false;
	  }
	  
  }
  public void signOutFromGmail() throws InterruptedException {
      driver.findElement(By.xpath(".//span[@class='gb_7a gbii']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//a[text()='Sign out']")).click();
  }
  public boolean checkIfWarningMessageAppears(String warning_Message)
  {
	  WebElement warningMessage = driver.findElement(By.xpath(".//div[contains(text(),'"+warning_Message+"')]"));
	  
	  Assert.assertTrue("Warning Message is not appearing for existing account", warningMessage.isDisplayed());
	  if(warningMessage.isDisplayed())
	  {
		  System.out.println(" "+warning_Message +" appeared!");
		  return true;
	  }
	  else
	  {
		  System.out.println(warning_Message +" did not appeared!");
		  return false;
	  }
		  
  }
  
  
  
  
  
  
  
}
