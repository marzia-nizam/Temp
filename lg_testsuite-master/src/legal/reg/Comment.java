package legal.reg;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Comment extends LegalRegressionSharedFunctions {
  @Test
  public void TestComment() throws InterruptedException {
	  Login("THE TESTING ACCOUNT");
	  verifyElementVisibility(".//*[@id='welcome-message']");
	  System.out.println("Welcome Message is Visible");
	 
	 
	
	  VerifyComments();
	  UploadAmended();
	  YellowDocCreation();
	  AuthoredDocCreation();
	  SendForSignature();
	  
  }
  String Comment="Test comment for flagged document";
  String Comment2="Test comment for flagged document 2";
  public void AppCreation() throws InterruptedException
  {
	  

	  driver.findElement(By.xpath("//img[@alt='TestAppDocuSign']")).click();
	  
	  Thread.sleep(2000);
	  if (iframe != currentFrame) {

          switchToFrame(iframe);

          currentFrame = iframe;
          String str = driver.findElement(By.xpath("//input[@value='AUTHORED']")).getAttribute("checked");
          if (str.equalsIgnoreCase("true"))
          {
              System.out.println("Checkbox selected");
          }
          
          driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva ");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("auricgoldfinger34@outlook.com");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("auricgoldfinger34+1@outlook.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("auricgoldfinger34+11@outlook.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("auricgoldfinger34+111@outlook.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("auricgoldfinger34+1111@outlook.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("auricgoldfinger34+11111@outlook.com");
          driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
          
         
          driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();
	  }
  
  }
  
  public void switchToFrame(int iframe) {

      driver.switchTo().defaultContent();

      driver.switchTo().frame(iframe);

  }
  
  public void VerifyComments() throws InterruptedException
  {

	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div[2]/div[1]/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
	  Thread.sleep(2000);
	  verifyTextPresent("Add Comment");
	//*[@id="page-wrapper"]/div[3]/div[1]/div/div/div[1]/button/div
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button")).click();
	  verifyElementVisibility(".//*[@id='document-tabs-pane-comments']/div[1]/form/div[2]/label");
	  driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("Test Comment");
	  driver.findElement(By.xpath(".//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button")).click();
	  verifyElementVisibility(".//*[@id='document-tabs-pane-all']/div/div/div[1]/div[2]/div[2]/div/button");
	  
  }
  
  
  public void UploadAmended() throws InterruptedException
  {


	  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  UploadFile(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[2]/ul/li/div/div/input","C:\\Amended_File.docx");
      driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[2]/div/div/div[2]/div[2]/div/button")).click();
      driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[2]/div/div/div[2]/div[2]/div/form/div[3]/button[2]/div")).click();
      driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[2]/div/div/div[2]/div[2]/div/button")).click();
      Thread.sleep(20000);
      driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div/textarea")).sendKeys("Test Reply");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button/div")).click();
      
 }
  
public void YellowDocCreation() throws InterruptedException
{
	waitFunction(2000);
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a/span")).click();
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
	  Thread.sleep(20000);
	  if (iframe != currentFrame) {

        switchToFrame(iframe);

        currentFrame = iframe;
	  driver.findElement(By.xpath(".//span[contains(text(),'Yellow')]")).click();

	
	  
	  //go to document
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva ");
      
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
      
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("userregression@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
      
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("userregression+1@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("userregressionround2@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("userregressionround2+1@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("userregressionround3@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("userregressionround3+1@gmail.com");
      driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
	  driver.switchTo().parentFrame();
	  }
      driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();
       Thread.sleep(2000);
      driver.findElement(By.xpath("//span[text()='Document List']")).click();
  
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button[3]")).click();
	  driver.findElement(By.xpath("//*[@id='comment']")).sendKeys(Comment);

	  driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button/div")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button[1]")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='approve-transitions']")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='transition-ApproveAndSend']")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]/div")).click();
	  Thread.sleep(2000);
	  CheckFlaggedMailComments("userregression@gmail.com","@tekarsh.com");
	 // driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span//following::div[text()='Approve and Send for Signature'][2]")).click();
	 // CheckMailandSign("tasnuva113@gmail.com","jimbaker@");
	
      
      
}
public void AuthoredDocCreation() throws InterruptedException
{
	Thread.sleep(20000);
	  driver.findElement(By.xpath("//*[@id='side-menu']/li[2]/a")).click();
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
	  Thread.sleep(20000);
	  if (iframe != currentFrame) {

        switchToFrame(iframe);

        currentFrame = iframe;
	 

	
	  
	  //go to document
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva ");
      
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
      
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("userregression@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
      
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("userregression+1@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("userregressionround2@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("userregressionround2+1@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("userregressionround3@gmail.com");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
      
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
      driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("userregressionround3+1@gmail.com");
      driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
	  driver.switchTo().parentFrame();
	  }
      driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//span[text()='Document List']")).click();
      driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button")).click();
	  driver.findElement(By.xpath("//*[@id='comment']")).sendKeys(Comment);
	  driver.findElement(By.xpath("//label[contains(text(),'Publish this comment to all parties')]")).click();
	  driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button/div")).click();

	  Thread.sleep(20000);
	  
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys(Comment);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='document-tabs-pane-comments']/div[1]/form/div[2]/label")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button")).click();
      CheckMailandSign("userregression@gmail.com","@tekarsh.com");
	//  Thread.sleep(20000);
	//  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button[1]")).click();
	// Thread.sleep(2000);
	//  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/button[3]")).click();
	//  driver.findElement(By.xpath("//*[@id='comment']")).sendKeys(Comment2);
	//  driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button/div")).click();
	//  CheckMailandSign2("userregression@gmail.com","@tekarsh.com");
	//  CheckMailandSign("tasnuva113@gmail.com","jimbaker@");
	 // CheckMailandSignReview("userregression@gmail.com","@tekarsh.com");
	  //After approving the first mail
	//  CheckMailandSignReview("automation.test.515","automation12345");
	//After approving the second mail
	//  CheckMailandSignReview("automation.test.5152","automation12345");
	//After approving the third mail
	//  CheckMailandSignReview("automation.test.515","automation12345");
		//After approving the forth mail
	 // CheckMailandSignReview("automation.test.5152","automation12345");
		//After approving the fifth mail
	 // CheckMailandSignReview("automation.test.515","automation12345");
		//After approving the sixth mail
	 // Logout();
	  
      
      
}

public void CheckMailandSign(String UserID,String Password) throws InterruptedException
{
	    String MainWindowHandle = driver.getWindowHandle();
      
	  //open a new firefox window
	  WebDriver driver2=null;
	  Thread.sleep(98000);
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--start-maximized");
	    driver2 = new ChromeDriver( options1 );
	  //in the new window, go to the intended page
	    driver2.navigate().to("https://accounts.google.com/ServiceLogin?");
  	  Thread.sleep(2000);
  
  	// g mail login
  	driver2.findElement(By.id("identifierId")).sendKeys(UserID);
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(Password);
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();

  	// some optional actions for reaching g mail in box 
  	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
  	driver2.findElement(By.id("gb23")).click();
      
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	  //  String MyMailer = "Legal Gateway";
	  //  String MyMailer2 = "Automation via Leg.";
	    String Commentmail="Automation User added a comment";
	  
	    WebElement element=driver2.findElement(By.xpath("//span[@class='zF']//following::b[text()='Automation User added a comment']"));
	   
	    for(int i=0;i<unreademeil.size();i++)
		{
	    	Thread.sleep(45000);
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(element.getText().equals(Commentmail)){
		            
		           
		            element.click();
		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
		            driver2.findElement(By.xpath("//a[contains(text(),'View')]")).click();
		          
		           String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }
		            try
		            {
		            	driver2.findElement(By.id("username")).getAttribute("value").isEmpty();
		            	driver2.findElement(By.id("username")).sendKeys("userregression@gmail.com");
		            	  driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("@gmail.com");
				            driver2.findElement(By.id("login-button")).click();
				    		ImplicitWait(40);
		            }
		            catch(Exception e)
		            {
		            	e.printStackTrace();
		            }
		          
		    		 
		    	      verifyTextPresent(Comment);
		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
		            		               
		            		               driver2.close(); // close newly opened window when done with it
		            		               driver2.switchTo().window(parentHandle2);
		            		   	           // close newly opened window when done with it
		            		   	          
		            		   	             driver2.close();
		            		               driver.switchTo().window(MainWindowHandle);
		            		               }
		   
		            break;
		        }
		        else{
		            System.out.println("No mail visible");
		        }
		    }
		}

public void CheckMailandSign2(String UserID,String Password) throws InterruptedException
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
  	driver2.findElement(By.id("identifierId")).sendKeys(UserID);
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(Password);
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();

  	// some optional actions for reaching g mail in box 
  	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
  	driver2.findElement(By.id("gb23")).click();
      
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	  //  String MyMailer = "Legal Gateway";
	  //  String MyMailer2 = " tasnuva via Leg.";
	    String Commentmail=" Automation User added a comment";
	    Thread.sleep(35000);
	    WebElement element=driver2.findElement(By.xpath("//span[@class='zF']//following::b[text()='Automation User added a comment'][2]"));
	   
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(element.getText().equals(Commentmail)){
		            
		           
		            element.click();
		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
		            driver2.findElement(By.xpath("//a[contains(text(),'View')]")).click();
		          
		           String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }
		            try
		            {
		            	driver2.findElement(By.id("username")).getAttribute("value").isEmpty();
		            	driver2.findElement(By.id("username")).sendKeys("userregression@gmail.com");
		            }
		            catch(Exception e)
		            {
		            	e.printStackTrace();
		            }
		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("@gmail.com");
		            driver2.findElement(By.id("login-button")).click();
		    		ImplicitWait(40);
		    		 
		    	      verifyTextPresent(Comment2);
		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
		            		               
		            		               driver2.close(); // close newly opened window when done with it
		            		               driver2.switchTo().window(parentHandle2);
		            		   	           // close newly opened window when done with it
		            		   	          
		            		   	             driver2.close();
		            		               driver.switchTo().window(MainWindowHandle);
		            		               }
		   
		            break;
		        }
		        else{
		            System.out.println("No mail visible");
		        }
		    }
		}


public void CheckMailandSignReview(String UserID,String Password) throws InterruptedException
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
  	driver2.findElement(By.id("identifierId")).sendKeys(UserID);
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(Password);
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();

  	// some optional actions for reaching g mail in box 
  	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
  	driver2.findElement(By.id("gb23")).click();
      
	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
	    
	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
	    String MyMailer = " tasnuva via Legal .";
	    String MyMailer2 = " tasnuva via Leg.";
	    for(int i=0;i<unreademeil.size();i++)
		{
		    if(unreademeil.get(i).isDisplayed()==true){
		     
		    	//String parentHandle2 = driver2.getWindowHandle(); 
		    	
		        if(unreademeil.get(i).getText().equals(MyMailer) || unreademeil.get(i).getText().equals(MyMailer2)){
		            System.out.println("Yes we have got mail form " + MyMailer);
		           
		            unreademeil.get(i).click();
		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
		            driver2.findElement(By.xpath("//a[contains(text(),'View')]")).click();
		          
		           String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }
		            WebElement element =driver2.findElement(By.xpath("//div[text()='Please login to review this document']"));
		            if(element.isDisplayed()==true)
		            {
		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
		            driver2.findElement(By.id("login-button")).click();
		    		ImplicitWait(40);
		    		 Select oSelect1 = new Select(driver2.findElement(By.name("organisation")));
		    	      oSelect1.selectByVisibleText("THE TESTING ACCOUNT");
		    	      ImplicitWait(40);
		    	      driver2.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/button[1]")).click();
		            }
		            else
		            {
		            	 driver2.findElement(By.xpath(".//*[@id='root']/div/div/div/div[1]/div/div/button[1]")).click();
		            }
		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
		            		               
		            		               driver2.close(); // close newly opened window when done with it
		            		               driver2.switchTo().window(parentHandle2);
		            		   	           // close newly opened window when done with it
		            		   	          
		            		   	             driver2.close();
		            		               driver.switchTo().window(MainWindowHandle);
		            		               }
		   
		            break;
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		    }
		}



public void CheckFlaggedMailComments(String UserID,String Password) throws InterruptedException
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
  	driver2.findElement(By.id("identifierId")).sendKeys(UserID);
  	driver2.findElement(By.id("identifierNext")).click();
  	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(Password);
  	Thread.sleep(2000);
  	driver2.findElement(By.id("passwordNext")).click();
  	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	//driver2.findElement(By.id("signIn")).click();

  	// some optional actions for reaching g mail in box 
  	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
  	driver2.findElement(By.id("gb23")).click();
     
      
      if( driver2.getPageSource().contains("Automation added a comment"))
      {
    	  System.out.println("The first signer can see the comment mail");
      }
      else
      {
    	  System.out.println("The first signer can't see the comment mail");
      }
	     // get the current window handle
	    
		          
		            		   	          
		            		   	             driver2.close();
		            		               driver.switchTo().window(MainWindowHandle);
		            		               }
		   
public void SendForSignature() throws InterruptedException
{
	

}		       
		    
		

}



