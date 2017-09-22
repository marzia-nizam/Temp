package legal.reg;

import static org.testng.Assert.assertTrue;

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
import org.testng.annotations.Test;

public class FileUploads extends LegalRegressionSharedFunctions {
  @Test
  public void TestFileUploads() throws InterruptedException {
	  
	    Login("THE TESTING ACCOUNT");
	 //  CheckVisibility("//h1[@id='welcome-message']","Morning, Marzia. What legal support do you require?");
	    DocCreationAuthoredNonLG();
	    
	 //   DocCreationAuthoredLG();
	    ZeroByteFileUpload();
	   ImageTextFileUpload();
	//    LargeFileUpload();    
	   CheckCommentBoxAppears();
	 //   DocCreationAuthoredNonLG();
	//   CreateAnotherDoc();
	     
  } 
  
  public void DocCreationAuthoredNonLG() throws InterruptedException
  {
  	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
  	  Thread.sleep(35000);
  	  if (iframe != currentFrame) {

          switchToFrame(iframe);

          currentFrame = iframe;
          Thread.sleep(20000);
       /*   String str = driver.findElement(By.xpath("//input[@value='AUTHORED']")).getAttribute("checked");
          if (str.equalsIgnoreCase("true"))
          {
              System.out.println("Checkbox selected");
          }*/
          
          driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva Disha");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("automation.test.515@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("automation.test.5152@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("automation.test.515+1@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("automation.test.5152+1@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("automation.test.515+3@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("automation.test.5152+3@gmail.com");
          driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
           
        
           driver.switchTo().parentFrame();
          Thread.sleep(20000);

  	  }
  	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a")).click();
  	 Thread.sleep(20000);}
  
  
  public void DocCreationAuthoredLG() throws InterruptedException
  {
	  	  
	  driver.findElement(By.xpath(".//small[contains(text(),'TestAppDocuSign')]")).click();
  	  Thread.sleep(20000);
  	  if (iframe != currentFrame) {

          switchToFrame(iframe);
          Thread.sleep(20000);
          currentFrame = iframe;
     
          //go to document
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva Disha");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
          
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("tasnuvadisha113@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
          
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("automation.test.5152@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("automation.test.515+1@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("automation.test.5152+1@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("automation.test.515+3@gmail.com");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
          
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
          driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("automation.test.5152+3@gmail.com");
          driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
          
          System.out.println("The .docx LG file has been downloaded succesfully");
  }
}

  public void ZeroByteFileUpload() throws InterruptedException
  {
	   driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();	  
	   Thread.sleep(2000);    
	   driver.findElement(By.xpath(".//span[contains(text(),'Document List')]")).click();
	   Thread.sleep(20000);	
	   driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
	   waitFunction(2000);
	   driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	   driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();

	  try{
           uploadFile("C:\\ZeroByte.docx");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Please select a different file.')]")));
	 
  }

  public void ImageTextFileUpload() throws InterruptedException
  {
	//  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();

	  try{
           uploadFile("C:\\image.jpg");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]")).click();
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Please upload a valid file type: only .doc, .docx, and .pdf files are accepted.')]")));
  
	  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();

	  try{
           uploadFile("C:\\Text.txt");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]")).click();
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'Please upload a valid file type: only .doc, .docx, and .pdf files are accepted.')]")));
      
  }

  public void LargeFileUpload() throws InterruptedException
  {
/*	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/ul/li[1]/a/span")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]/span/a")).click();
	  waitFunction(2000);*/
	  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();

	  try{
           uploadFile("C:\\20MB.pdf");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	  Thread.sleep(220000);
	  assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'File upload failed')]")));
	  
  }
  
  public void CheckCommentBoxAppears() throws InterruptedException
  {
	//  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a/span")).click();
	//  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/ul/li[1]/a/span")).click();
	//  Thread.sleep(20000);
	//  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
//	  waitFunction(2000);
	  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();
	
	  try{
           uploadFile("C:\\Example Report.docx");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	     Thread.sleep(2000);
	     assertTrue(isElementPresent(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div/textarea")));
	     driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]/div")).click();
	     waitFunction(6000);  
	  
	     //compare
		 driver.findElement(By.xpath(".//*[@id='document-versions-dropdown']")).click();
		 driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[1]/div/label/input")).click();
		 driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[2]/div/label/input")).click();
		 driver.findElement(By.xpath("//div[contains(text(),'Run Comparison')]")).click();
		 Thread.sleep(20000);
		 
		 //send for Signature
		 driver.navigate().back();
		 waitFunction(2000);  
		 driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button[1]")).click();
		 CheckMailandSign("automation.test.515","automation12345");
  }
  public void CheckMailandSign(String UserID,String Password) throws InterruptedException
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
    	driver2.findElement(By.xpath("//*[@id='gbwa']")).click();
    	driver2.findElement(By.id("gb23")).click();
        
  	    String parentHandle = driver2.getWindowHandle(); // get the current window handle
  	    
  	    List<WebElement> unreademeil = driver2.findElements(By.xpath("//*[@class='zF']"));
  	    String MyMailer = "Marzia Nizam via Legal .";
  	    String MyMailer2 = "Marzia Nizam via Leg.";
  	    for(int i=0;i<unreademeil.size();i++)
  		{
  		    if(unreademeil.get(i).isDisplayed()==true){
  		     
  		    	//String parentHandle2 = driver2.getWindowHandle(); 
  		    	
  		        if(unreademeil.get(i).getText().equals(MyMailer) || unreademeil.get(i).getText().equals(MyMailer2)){
  		            System.out.println("Yes we have got mail form " + MyMailer);
  		           
  		            unreademeil.get(i).click();
  		          //  driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password/")).click();
  		            driver2.findElement(By.xpath("//a[contains(text(),'Review')]")).click();
  		          
  		           String parentHandle2 = driver2.getWindowHandle(); 
  		            for (String winHandle : driver2.getWindowHandles()) {
  		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
  		      	    }           
  		         //   driver2.findElement(By.xpath("//*[@id='password']")).sendKeys("456789@");
  		          
  		            Thread.sleep(20000);
  		       
  		           driver2.findElement(By.xpath(".//*[@id='root']/div/div/div/div[1]/div/div/button[1]")).click();
  		          Thread.sleep(35000);
  		         assertTrue(isElementPresent(By.xpath(".//div[contains(text(),'There as an issue with the document that you uploaded and it no longer contains the required Anchor Tabs to facilitate signing. For more assistance please contact support@plxs.com.au')]")));  		            		   	          
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
  	 
  public void CreateAnotherDoc() throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/ul/li[1]/a/span")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]/span/a")).click();
	  waitFunction(2000);
	  driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();

	  try{
           uploadFile("C:\\Example Report.docx");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	     Thread.sleep(2000);
	     assertTrue(isElementPresent(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div/textarea")));
	     driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]")).click();
	     waitFunction(6000);  
	     
	     //download file
	     driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/div/table/tbody/tr/td[1]/small/a")).click();
	     driver.findElement(By.xpath(".//*[@id='upload-approved-or-executed']")).click();
		  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/div[1]/ul/li[1]/div/div/input")).click();
		  try{
	           uploadFile("C:\\Users\\Mim\\Downloads\\QA_TEST_AGREEMENT.doc");

	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]")).click();
          driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/div[1]/button[1]")).click();
  }
  	 
  }
