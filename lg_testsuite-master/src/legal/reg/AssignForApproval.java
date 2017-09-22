package legal.reg;
import static com.heliumhq.API.*;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignForApproval extends LegalRegressionSharedFunctions {
  @Test
  
  
  
  public void TestAssignForApproval() throws InterruptedException {
	
	     Login("THE TESTING ACCOUNT");
	     CheckVisibility("//h1[@id='welcome-message']","Morning, Automation. What legal support do you require?");
	     CheckVisibility("//*[@id='page-wrapper']/div[1]/div[2]/div[1]/div/div/div/table/thead/tr/th[1]","Awaiting Approval");
	     CheckVisibility("//*[@id='page-wrapper']/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]","Recently Viewed");
	 /*    InviteUser(InviteUser);
	     YellowFlag();*/
	 /*   GoToYellowFlaggedDoc();
	    SearchForUser();
	    CheckSubmitButton();*/
	   /* SendUserInvite(InviteUser2);
	     SearchFromBackend();
	     CheckReinviteUser();*/
	     UncheckIsApprover();
  }
  
  public void InviteUser(String UserMail) throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[2]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(UserMail);	  
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  waitFunction(20000);
	  CheckVisibility("//*[@id='page-wrapper']/div[2]/div/div/div","Success: an invitation has been emailed to "+UserMail);
	  waitFunction(2000);
	  //check status of the user
	  driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(UserMail);	
	  CheckVisibility("//*[@id='page-wrapper']/div[3]/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[5]/span","Invited");
      
  }
  
  public void YellowFlag() throws InterruptedException
  { 
	  //Test Case Step 6
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a/span")).click();
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
	  Thread.sleep(2000);
      click("Yellow");
      click("Fire Web Service Call");
      
  }
 
  public void GoToYellowFlaggedDoc() throws InterruptedException
  
  {
      //step 7-9	  
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();	  
	     // Thread.sleep(2000);    
	  driver.findElement(By.xpath(".//span[contains(text(),'Document List')]")).click();
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();     
	  Thread.sleep(2000);
	  CheckVisibility("//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span", "Requires Approval");
	  CheckVisibility(".//*[@id='approve-transitions']", "Approvals");
	  driver.findElement(By.xpath(".//*[@id='approve-transitions']")).click();
	  CheckVisibility(".//*[@id='transition-AssignForApproval']", "Assign for Approval");
	  driver.findElement(By.xpath(".//*[@id='transition-AssignForApproval']")).click();
	  CheckVisibility(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input", "");
	  CheckVisibility("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/button[1]", "Submit");
      CheckVisibility("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/button[2]", "Cancel");
  }
 
  public void SearchForUser() throws InterruptedException
  
  {
	driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).click(); 
	 //Search the user based on user email or name
    driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("marzia");
    assertTrue(isElementPresent(By.xpath(".//strong[contains(text(),'Marzia')]")));
    //Serach with any keywords which is not available in email/username
    driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("pooh");
	  assertTrue(isElementPresent(By.xpath(".//a[contains(text(),'No matches found')]")));
	  //Search that user which is invited in step 5
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("automation.test.5152+10@gmail.com");
	  assertTrue(isElementPresent(By.xpath(".//a[contains(text(),'No matches found')]")));
	  //Check that no invited user displayed on the list
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("automation.test.5152+9@gmail.com");
	  assertTrue(isElementPresent(By.xpath(".//a[contains(text(),'No matches found')]")));
	  //Check that only LG users are displayed on the list
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("automation");
	  assertTrue(isElementPresent(By.xpath(".//span[contains(text(),'Severus Snape')]")));
  }
  
  public void CheckSubmitButton() throws InterruptedException
  {
	  //Do not select any user & hit "Submit" button
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/button[1]")).click();
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Please select a valid user')]")));
	  waitFunction(1000);
	  //Now select any user & hit "Submit" button 
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys("disha");
	  driver.findElement(By.xpath(".//strong[contains(text(),'disha')]")).click();
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/button[1]")).click();
	  Thread.sleep(2000);
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Users have been assigned for approval on the document successfully')]")));
	  CheckVisibility("//*[@id='page-wrapper']/div[3]/div[1]/div/div/h2/span","Requires Approval");
	  waitFunction(20000);

	  CheckVisibility("//*[@id='page-wrapper']/div[3]/div[2]/div[3]/div[1]/h5","Assigned Approvers");
	  CheckVisibility("//*[@id='page-wrapper']/div[3]/div[2]/div[3]/div[2]/table/tbody/tr/td[2]/button/div","Unassign");
	  //Again click on Approvals > Assign for Approval > Select some user but do not hit "Submit" button
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='approve-transitions']")).click();
	  driver.findElement(By.xpath(".//*[@id='transition-AssignForApproval']")).click();

	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div/div/input")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/ul/li[1]/a/span")).click();
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/ul/li[4]/a/span")).click();
	  waitFunction(1000);
	  assertTrue(isElementPresent(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div/div[1]/span")));
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div/div[1]/span")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div/div/div[1]/span")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/button[1]")).click();
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Please select a valid user')]")));
  }

  public void SendUserInvite(String UserMail) throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[2]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(UserMail);	  
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  Thread.sleep(10000);
	  CheckMailandSign(InviteUser2,"automation12345");
	  Thread.sleep(20000);  
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
  	driver2.findElement(By.id("identifierId")).sendKeys(MailID2);
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("automation12345");
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();
  //*[@id="gbwa"]/div/a/svg/path
  	// some optional actions for reaching g mail in box 
  	driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
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
		            driver2.findElement(By.partialLinkText("https://plxs-ext.au.auth0.com")).click();
		          
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
		            
		            driver2.findElement(By.xpath("//*[@id='username']")).sendKeys(InviteUser2);
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

  public void SearchFromBackend() throws InterruptedException
  
  {
	  driver.get("https://ext.legalgateway.com.au/admin/");
	 /* driver.findElement(By.id("username")).sendKeys("automation.user.ext@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("password1234567890");
	  driver.findElement(By.id("login-button")).click();*/
	  Thread.sleep(20000);
	  System.out.println("Logged into backend successfully"); 
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//a[contains(text(),'Users')]")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='searchbar']")).sendKeys(InviteUser2);
	  driver.findElement(By.xpath(".//*[@id='changelist-search']/div/input[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='result_list']/tbody/tr/th/a")).click();
	  Thread.sleep(2000);
	  assertTrue(isElementPresent(By.xpath(".//*[@id='id_is_active']")));	
	  Thread.sleep(2000); 
	  DeleteFromFrontend(InviteUser2);
  }
  
  public void DeleteFromFrontend(String User) throws InterruptedException
  {
	  //Login("THE TESTING ACCOUNT");
	  String DeleteMessage = InviteUser2 + " has been deleted";
	  String VerificationMessage = "User " +InviteUser2 + " has used the Legal Gateway in the past. If they accept your invitation they will have access to all documents etc they had before";
	  driver.get("https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
	  driver.findElement(By.id("username")).sendKeys("automation.user.ext@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("password1234567890");
	  driver.findElement(By.id("login-button")).click();
		ImplicitWait(40);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[2]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(User);
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/a")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[1]/div/div/div[1]/div/div/button[2]")).click();
	  Thread.sleep(20000);
	  CheckVisibility("//*[@id='page-wrapper']/div[2]/div/div/div",DeleteMessage);
	  
	  waitFunction(20000);
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(InviteUser2);	  
	  driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	  ;
	  Thread.sleep(20000);
	  CheckVisibility("//*[@id='page-wrapper']/div[2]/div/div/div",VerificationMessage);
	  Thread.sleep(20000);
  }

  public void CheckReinviteUser() throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();	 
	  driver.findElement(By.xpath(".//span[contains(text(),'Document List')]")).click();
      Thread.sleep(20000);      
	  //open doc required approval
      driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[1]/form/fieldset/div/div[3]/div/div/div/input")).click();
      driver.findElement(By.xpath(".//span[contains(text(),'Requires Approval')]")).click();
      Thread.sleep(20000);
      driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();     
      Thread.sleep(2000);
      
    //check for reinvited user
	  driver.findElement(By.xpath(".//*[@id='approve-transitions']")).click();
	  driver.findElement(By.xpath(".//*[@id='transition-AssignForApproval']")).click();
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(InviteUser2);
	  assertTrue(isElementPresent(By.xpath(".//span[contains(text(),'Severus Snape')]")));
	  
    //can select multiple user
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.CONTROL+"a");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div/div/input")).sendKeys(Keys.DELETE);				
	  waitFunction(1000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li[1]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/div")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li[1]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/button[1]")).click();
  }
  public void UncheckIsApprover() throws InterruptedException
  {
	  driver.get("https://ext.legalgateway.com.au/admin/");
	  System.out.println("Logged into backend successfully"); 
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='content-main']/div[5]/table/tbody/tr/th/a")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//a[contains(text(),'THE TESTING ACCOUNT')]")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//a[contains(text(),'User')]")).click();
	  if(driver.findElement(By.id("id_app_permissions-0-is_approver")).getAttribute("checked")!="true")
	  
		  System.out.println("Is approver option under App permissions section is unchecked ");
	  else
		  System.out.println("Is approver option under App permissions section is NOT unchecked ");
  }
}
