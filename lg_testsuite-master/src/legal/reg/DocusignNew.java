package legal.reg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DocusignNew extends LegalRegressionSharedFunctions {
  @Test
  public void TestNewDocusign() throws InterruptedException {
	
	  Login("THE TESTING ACCOUNT");
	//  Logout();
	 // BackendLogin();
	  AuthoredDocCreation();
	  
  }
  
 
  public void BackendLogin() throws InterruptedException
  {   
	 
	  String MainWindowHandle = driver.getWindowHandle();
      
 	  //open a new firefox window
 	  WebDriver driver2=null;
 	
 		ChromeOptions options1 = new ChromeOptions();
 		options1.addArguments("--start-maximized");
 	    driver2 = new ChromeDriver( options1 );
	  driver2.get("https://ext.legalgateway.com.au/admin/");
	  driver2.findElement(By.id("username")).sendKeys("disha.tasnuva@tekarsh.com");
	  driver2.findElement(By.id("password")).sendKeys("456789@");
	  driver2.findElement(By.id("login-button")).click();
	  Thread.sleep(20000);
	  driver2.findElement(By.linkText("Apps")).click();
	  Thread.sleep(2000);
	  driver2.findElement(By.linkText("TestAppDocuSign")).click();
	  Thread.sleep(2000);
	  Select oSelect = new Select(driver2.findElement(By.name("launch_mode")));
	  oSelect.selectByVisibleText("Iframe");
	  driver2.findElement(By.xpath("//input[@value='Save']")).click();
	  Thread.sleep(2000);
	  driver2.close();
	  driver.switchTo().window(MainWindowHandle);
      Login("THE TESTING ACCOUNT");
  }
  
  public void AuthoredDocCreation() throws InterruptedException
  {
	 
  	waitFunction(2000);
  	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a/span")).click();
  	  waitFunction(2000);
  	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
  	  Thread.sleep(35000);
  	  if (iframe != currentFrame) {

          switchToFrame(iframe);

          currentFrame = iframe;
  	 

  	
  	  
  	  //go to document
  
  	  driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
        driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva Disha");
        
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
        driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Document List']")).click();
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
        Thread.sleep(2000);
        LegalRegressionSharedFunctions.CheckVisibility(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span", "Authored");
        LegalRegressionSharedFunctions.verifyElementVisibility("//h5[text()='Recipients']//following::div[@class='DocumentRecipientList__recipientStatus__3ZtKw DocumentRecipientList__signatureRequired__qNVHy'][1]");
        driver.findElement(By.xpath("//button[@name='SendForSignature']")).click();
        Thread.sleep(20000);
        LegalRegressionSharedFunctions.CheckVisibility(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span", "Awaiting Signature");
        LegalRegressionSharedFunctions.verifyElementVisibility(".//*[@id='page-wrapper']/div[2]/div[2]/div[3]/div[2]/ul/li[1]/ul/li/div[2]");
        CheckMailandSignRoundone("userregression@gmail.com","@tekarsh.com");
        CheckMailandSignRoundtwo("userregressionround2@gmail.com","@tekarsh.com");
        CheckMailandSignRoundthree("userregressionround3@gmail.com","@tekarsh.com");
  	  //driver.findElement(By.xpath("//*[@id='approve-transitions']")).click();
  	  //driver.findElement(By.xpath("//*[@id='transition-ApproveAndSend']/div")).click();
  	 // driver.findElement(By.xpath("//*[@id='page-wrapper']/div[4]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]/div")).click();
  	 /* CheckMailandSign("tasnuvadisha113@gmail.com","jimbaker@");
  	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/button[2]/div")).click();
  	  Thread.sleep(2000);
  	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/button[3]")).click();
  	  driver.findElement(By.xpath("//*[@id='comment']")).sendKeys(Comment2);
  	  driver.findElement(By.xpath("//*[@id='document-tabs-pane-comments']/div[1]/form/div[3]/button/div")).click();
  	//  CheckMailandSign("tasnuvadisha113@gmail.com","jimbaker@");
  	  CheckMailandSignReview("tasnuvadisha113@gmail.com","jimbaker@");
  	  //After approving the first mail
  	  CheckMailandSignReview("automation.test.515","automation12345");
  	//After approving the second mail
  	  CheckMailandSignReview("automation.test.5152","automation12345");
  	//After approving the third mail
  	  CheckMailandSignReview("automation.test.515","automation12345");
  		//After approving the forth mail
  	  CheckMailandSignReview("automation.test.5152","automation12345");
  		//After approving the fifth mail
  	  CheckMailandSignReview("automation.test.515","automation12345");
  		//After approving the sixth mail
  	  Logout();*/
  	  
        
        
  }
  
  public void CheckMailandSignRoundone(String UserID,String Password) throws InterruptedException
  {
  	    
        
  	  //open a new firefox window
  	  
	  WebDriver driver2=null;
	   String MainWindowHandle = driver.getWindowHandle();
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
    	//driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver2.findElement(By.id("signIn")).click();
        Thread.sleep(2000);
    	// some optional actions for reaching g mail in box 
    	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
    	driver2.findElement(By.id("gb23")).click();
        
  	   
  	  Thread.sleep(20000);
  	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
  	   // String MyMailer = "Legal Gateway";
  	    String MyMailer2 = "disha tasnuva via Leg.";
  	    
  	    for(int i=0;i<unreademeil.size();i++)
  		{
  		    if(unreademeil.get(i).isDisplayed()==true){
  		     
  		    	//String parentHandle2 = driver2.getWindowHandle(); 
  		    	
  		        if(unreademeil.get(i).getText().equals(MyMailer2)){
  		            System.out.println("Yes we have got mail form " + MyMailer2);
  		           
  		            unreademeil.get(i).click();
  		            Thread.sleep(2000);
  		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
  		            driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][1]")).click();
  		          
  		           String parentHandle2 = driver2.getWindowHandle(); 
  		            for (String winHandle : driver2.getWindowHandles()) {
  		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		      	    }           
  		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("@gmail.com");
  		            driver2.findElement(By.id("login-button")).click();
  		    		ImplicitWait(40);
  		    		 
  		    	     
  		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		    	      Thread.sleep(20000);
  		    	    WebElement element4 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		          if(element4.isDisplayed())
  		          {
  		         	 element4.click();
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		          else
  		          {
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		        
  		        
  		          
  		          Thread.sleep(2000);
  		          driver2.findElement(By.xpath("//button[@class='tab-button']")).click();
  		          Thread.sleep(2000);
  		         driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		             Thread.sleep(20000);
  		             //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		             
  		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		            		               
  		            		               driver2.close(); // close newly opened window when done with it
  		            		               driver2.switchTo().window(parentHandle2);
  		            		             //driver2.findElement(By.xpath("//div[@class='h7']//following::a[contains(text(),'Review')][1]")).click();
  		            		               Thread.sleep(2000);
  		            		           driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][2]")).click();
  		              		           String parentHandle3 = driver2.getWindowHandle(); 
  		              		            for (String winHandle : driver2.getWindowHandles()) {
  		              		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		              		      	    }  
  		              		            Thread.sleep(20000);
  		              		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("@gmail.com");
  		              		            driver2.findElement(By.id("login-button")).click();
  		              		    		ImplicitWait(40);
  		              		    	
  		       		    		 
  		       		    	     
  		      		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		      		    	      Thread.sleep(20000);
  		      		    	    WebElement element5 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		      		          if(element5.isDisplayed())
  		      		          {
  		      		         	 element5.click();
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		          else
  		      		          {
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		        
  		      		        
  		      		          
  		      		          Thread.sleep(2000);
  		      		      driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][2]")).click();
  		      		  driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][1]")).click();
  		      		          Thread.sleep(2000);
  		      		         
  		      		         
  		      		          
  		      		        	driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		      		          
  		      		    
  		      		             Thread.sleep(20000);
  		              		    	      
  		              		    	      
  		              		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		              		            		               
  		              		            		               driver2.close();
  		              		            		               // close newly opened window when done with it
                                                               
                                                               
  		              		            		               driver2.switchTo().window(parentHandle3);
  		            		   	           // close newly opened window when done with it
  		            		   	          
  		            		   	             driver2.close();
  		            		               driver.switchTo().window(MainWindowHandle);
  		            		               }
  		   
  		            break;
  		        }
  		        else{
  		            System.out.println("No mail form " + MyMailer2);
  		        }
  		    }
  		}
  
  public void CheckMailandSignRoundtwo(String UserID,String Password) throws InterruptedException
  {
  	    
        
  	  //open a new firefox window
  	  
	  WebDriver driver2=null;
	   String MainWindowHandle = driver.getWindowHandle();
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
    	//driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver2.findElement(By.id("signIn")).click();
        Thread.sleep(2000);
    	// some optional actions for reaching g mail in box 
    	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
    	driver2.findElement(By.id("gb23")).click();
        
  	   
    	  Thread.sleep(20000);
  	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
  	    //String MyMailer = "Legal Gateway";
  	    String MyMailer2 = "disha tasnuva via Leg.";
  	
  	    for(int i=0;i<unreademeil.size();i++)
  		{
  		    if(unreademeil.get(i).isDisplayed()==true){
  		     
  		    	//String parentHandle2 = driver2.getWindowHandle(); 
  		    	
  		        if(unreademeil.get(i).getText().equals(MyMailer2)){
  		            System.out.println("Yes we have got mail form " + MyMailer2);
  		           
  		            unreademeil.get(i).click();
  		          Thread.sleep(2000);
  		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
  		            driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][2]")).click();
  		          
  		           String parentHandle2 = driver2.getWindowHandle(); 
  		            for (String winHandle : driver2.getWindowHandles()) {
  		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		      	    }           
  		           
  		    		ImplicitWait(40);
  		    		 
  		    	     
  		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		    	      Thread.sleep(20000);
  		    	    WebElement element4 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		          if(element4.isDisplayed())
  		          {
  		         	 element4.click();
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		          else
  		          {
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		        
  		        
  		          
  		         
  		          Thread.sleep(2000);
  		         driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button']")).click();
  		       Thread.sleep(2000);
  		       driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		             Thread.sleep(20000);
  		             //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		             
  		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		            		               
  		            		               driver2.close(); // close newly opened window when done with it
  		            		               driver2.switchTo().window(parentHandle2);
  		            		             Thread.sleep(2000);
  		            		             driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][1]")).click();
  		            	  		          
  		              		           String parentHandle3 = driver2.getWindowHandle(); 
  		              		            for (String winHandle : driver2.getWindowHandles()) {
  		              		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		              		      	    }           
  		              		         
  		              		    		ImplicitWait(40);
  		              		    	
  		       		    		 
  		       		    	     
  		      		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		      		    	      Thread.sleep(20000);
  		      		    	    WebElement element5 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		      		          if(element5.isDisplayed())
  		      		          {
  		      		         	 element5.click();
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		          else
  		      		          {
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		        
  		      		        
  		      		          
  		      		          Thread.sleep(2000);
  		      		          driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][2]")).click();
  		      		      driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][1]")).click();
  		      		          Thread.sleep(2000);
  		      		         
  		      		         
  		      		          
  		      		        	driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		      		          
  		      		    
  		      		             Thread.sleep(20000);
  		              		    	      
  		              		    	      
  		              		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		              		            		               
  		              		            		               driver2.close();
  		              		            		               
                                                               
  		              		            		               driver2.switchTo().window(parentHandle3);
  		            		   	           // close newly opened window when done with it
  		            		   	          
  		            		   	             driver2.close();
  		            		               driver.switchTo().window(MainWindowHandle);
  		            		               }
  		   
  		            break;
  		        }
  		        else{
  		            System.out.println("No mail form " + MyMailer2);
  		        }
  		    }
  		}
  
  public void CheckMailandSignRoundthree(String UserID,String Password) throws InterruptedException
  {
  	    
        
  	  //open a new firefox window
  	  
	  WebDriver driver2=null;
	   String MainWindowHandle = driver.getWindowHandle();
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
    	//driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver2.findElement(By.id("signIn")).click();
        Thread.sleep(2000);
    	// some optional actions for reaching g mail in box 
    	driver2.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
    	driver2.findElement(By.id("gb23")).click();
        
  	   
    	  Thread.sleep(20000);
  	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
  	    //String MyMailer = "Legal Gateway";
  	    String MyMailer2 = "disha tasnuva via Leg.";
  	
  	    for(int i=0;i<unreademeil.size();i++)
  		{
  		    if(unreademeil.get(i).isDisplayed()==true){
  		     
  		    	//String parentHandle2 = driver2.getWindowHandle(); 
  		    	
  		        if(unreademeil.get(i).getText().equals(MyMailer2)){
  		            System.out.println("Yes we have got mail form " + MyMailer2);
  		           
  		            unreademeil.get(i).click();
  		          Thread.sleep(2000);
  		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
  		            driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][2]")).click();
  		          
  		           String parentHandle2 = driver2.getWindowHandle(); 
  		            for (String winHandle : driver2.getWindowHandles()) {
  		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		      	    }           
  		           
  		    		ImplicitWait(40);
  		    		 
  		    	     
  		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		    	      Thread.sleep(20000);
  		    	    WebElement element4 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		          if(element4.isDisplayed())
  		          {
  		         	 element4.click();
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		          else
  		          {
  		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		          }
  		        
  		      
  		          
  		        
  		          Thread.sleep(2000);
  		         driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button']")).click();
  		       Thread.sleep(2000);
  		         
  		         
 		          
		        	driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		             Thread.sleep(20000);
  		             //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		             
  		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		            		               
  		            		               driver2.close(); // close newly opened window when done with it
  		            		               driver2.switchTo().window(parentHandle2);
  		            		             Thread.sleep(2000);
  		            		             driver2.findElement(By.xpath("//h2[text()='disha tasnuva from THE TESTING ACCOUNT has sent a document for you to review and sign']//following::a[contains(text(),'Review')][1]")).click();
  		            	  		          
  		              		           String parentHandle3 = driver2.getWindowHandle(); 
  		              		            for (String winHandle : driver2.getWindowHandles()) {
  		              		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		              		      	    }           
  		              		            driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("@gmail.com");
  		              		            driver2.findElement(By.id("login-button")).click();
  		              		    		ImplicitWait(40);
  		              		    	
  		       		    		 
  		       		    	     
  		      		    	      driver2.findElement(By.xpath("//button[@name='SignDocument']")).click();
  		      		    	      Thread.sleep(20000);
  		      		    	    WebElement element5 =  driver2.findElement(By.xpath(".//*[@id='disclosureAccepted']"));
  		      		          if(element5.isDisplayed())
  		      		          {
  		      		         	 element5.click();
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		          else
  		      		          {
  		      		         	 driver2.findElement(By.xpath("//button[@class='btn btn-main btn-lg']")).click();
  		      		          }
  		      		        
  		      		    
  		      		          Thread.sleep(2000);
  		      		          driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][2]")).click();
  		      		      driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']//following::button[@class='tab-button'][1]")).click();
  		      		          Thread.sleep(2000);
  		      		         
  		      		         
  		      		          
  		      		        	driver2.findElement(By.xpath(".//*[@id='action-bar-btn-finish']")).click();
  		      		          
  		      		    
  		      		             Thread.sleep(20000);
  		              		    	      
  		              		    	      
  		              		            		               //driver2.findElement(By.xpath(".//*[@id='save-a-copy-create-account']/div[1]/div/div[4]/button[2]")).click();
  		              		            		               
  		              		            		               driver2.close();
  		              		            		               
                                                               
  		              		            		               driver2.switchTo().window(parentHandle3);
  		            		   	           // close newly opened window when done with it
  		            		   	          
  		            		   	             driver2.close();
  		            		               driver.switchTo().window(MainWindowHandle);
  		            		               }
  		   
  		            break;
  		        }
  		        else{
  		            System.out.println("No mail form " + MyMailer2);
  		        }
  		    }
  		}
  

 
  
  
  
  
  public void switchToFrame(int iframe) {

      driver.switchTo().defaultContent();

      driver.switchTo().frame(iframe);

  }
  
  
  
}
