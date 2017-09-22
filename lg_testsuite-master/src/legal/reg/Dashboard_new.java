package legal.reg;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dashboard_new extends LegalRegressionSharedFunctions {
  @Test
  public void TestDashboard() throws InterruptedException {
	  Login("THE TESTING ACCOUNT");
	  DashboardVerification();
	  Backend(); 
	  DocCreationFlagged("Red","Needs Legal Review");
  }
    
  public static void DashboardVerification()
	{
		verifyElementVisibility(".//*[@id='welcome-message']");
		System.out.println("The welcome message is visible");
		LegalRegressionSharedFunctions.VerifyListofElementsVisibility("//div[@class='text-center no-padding']/img");
		CheckVisibility(".//*[@id='page-wrapper']/div[1]/div[2]/div[1]/div/div/div/table/thead/tr/th[1]","Awaiting Approval");
		List<WebElement> approvaldocs = (List<WebElement>) driver.findElements(By.xpath("//th[contains(text(),'Awaiting Approval')]//following::td[@class='project-title']/span/a"));
	  	int approvaldocscount = approvaldocs.size();
	  	System.out.println( "The number of documents under Awaiting Approval status are " + approvaldocscount);
	  			  for(int i = 1; i < approvaldocscount; ++i) {
	  			   
	  			      if(  ( approvaldocs.get(i).isDisplayed()==true))
	  			    {
 	  			    	   
	  			    	  System.out.println("The document number "+ i +" under awaiting approval is visible");
	  			    	   
	  			    	  
	  			    	   
	  			       }
	  			       else
	  			       {
	  			    	   System.out.println("The document number "+ i +" under awaiting approval is not visible");
	  			       }
	  			    
	  			  }
		CheckVisibility(".//*[@id='page-wrapper']/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]","Recently Viewed");
		List<WebElement> rvdocs = (List<WebElement>) driver.findElements(By.xpath("//th[contains(text(),'Recently Viewed')]//following::td[@class='project-title']/span/a"));
	  	int rvdocscount = rvdocs.size();
	  	System.out.println( "The number of documents under Recently Viewed status are " + rvdocscount);
	  			  for(int i = 1; i < rvdocscount; ++i) {
	  			   
	  			      if(  ( rvdocs.get(i).isDisplayed()==true))
	  			    {
 	  			    	   
	  			    	  System.out.println("The document number "+ i +" under awaiting approval is visible");
	  			    	   
	  			    	  
	  			    	   
	  			       }
	  			       else
	  			       {
	  			    	   System.out.println("The document number "+ i +" under awaiting approval is not visible");
	  			       }
	  			    
	  			  }
	  			verifyImagePresence(".//*[@id='user-initials']/img"); 
	  			Logout()  ;
	
	}
  
    public void Backend() throws InterruptedException
    {
    	 String MainWindowHandle = driver.getWindowHandle();
         
     	  //open a new firefox window
     	  WebDriver driver2=null;
     	
     		ChromeOptions options1 = new ChromeOptions();
     		options1.addArguments("--start-maximized");
     	    driver2 = new ChromeDriver( options1 );
     	  //in the new window, go to the intended page
     	  driver2.navigate().to("https://ext.legalgateway.com.au/admin/");
     	  Thread.sleep(2000);
     	 driver2.findElement(By.id("username")).sendKeys("automation.user.ext@gmail.com");
 		driver2.findElement(By.id("password")).sendKeys("password1234567890");
 		driver2.findElement(By.id("login-button")).click();
 		  Thread.sleep(20000);
 		driver2.findElement(By.linkText("Organisation user organisations")).click();
 		 Thread.sleep(2000);
 		driver2.findElement(By.id("searchbar")).sendKeys("automation.user.ext@gmail.com");
 		driver2.findElement(By.xpath("//input[@value='Search']")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.xpath(".//h1[contains(text(),'Select organisation user organisation to change')]//following::a[contains(text(),'Automation User <')][1]")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Add another User Role")).click();
 		 Select oSelect2 = new Select(driver2.findElement(By.name("roles-1-role")));
 		 oSelect2.selectByVisibleText("THE TESTING ACCOUNT: User");
 		 driver2.findElement(By.xpath("//input[@value='Save']")).click();
 		Thread.sleep(20000);
 		driver2.findElement(By.linkText("Home")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Apps")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Status App")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Add another Organisation App Permission")).click();
 		Select oSelect3 = new Select(driver2.findElement(By.name("organisation_permissions-0-organisation")));
		 oSelect3.selectByVisibleText("THE TESTING ACCOUNT");
 		driver2.findElement(By.xpath("//input[@value='Save']")).click();
 		driver2.findElement(By.linkText("Home")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Roles")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.xpath(".//a[contains(text(),'THE TESTING ACCOUNT')]")).click();
 		Thread.sleep(20000);
 		driver2.findElement(By.xpath(".//a[contains(text(),'User')]")).click();
 		Thread.sleep(2000);
 		driver2.findElement(By.linkText("Add another App Permission")).click();
 		Select oSelect4 = new Select(driver2.findElement(By.name("app_permissions-1-app")));
		 oSelect4.selectByVisibleText("Status App");
		 driver2.findElement(By.xpath("//input[@value='Save']")).click();
 		 driver2.close();
         driver.switchTo().window(MainWindowHandle);
         Login("THE TESTING ACCOUNT");
         Thread.sleep(20000);
         verifyTextPresent("Get legal advice");
         driver.findElement(By.xpath(".//*[@id='side-menu']/li[4]/a")).click();
         Thread.sleep(2000);
         verifyTextPresent("Status App");
         Logout();
        
         
    	  //open a new firefox window
    	  WebDriver driver3=null;
    	
    		ChromeOptions options2 = new ChromeOptions();
    		options2.addArguments("--start-maximized");
    	    driver3 = new ChromeDriver( options1 );
    	  //in the new window, go to the intended page
    	  driver3.navigate().to("https://ext.legalgateway.com.au/admin/");
    	  Thread.sleep(2000);
    	 driver3.findElement(By.id("username")).sendKeys("automation.user.ext@gmail.com");
		driver3.findElement(By.id("password")).sendKeys("password1234567890");
		driver3.findElement(By.id("login-button")).click();
		  Thread.sleep(20000);
		driver3.findElement(By.linkText("Apps")).click();
		 Thread.sleep(20000);
		WebElement element2= driver3.findElement(By.linkText("Status App"));
		
		element2.click();
		Thread.sleep(20000);
		driver3.findElement(By.xpath(".//*[@id='id_organisation_permissions-0-DELETE']")).click();
		Thread.sleep(20000);
		driver3.findElement(By.xpath("//input[@value='Save']")).click();
		driver3.close();
		driver.switchTo().window(MainWindowHandle);
		Thread.sleep(20000);
		 Login("THE TESTING ACCOUNT");
         Thread.sleep(20000);
         verifyTextPresent("Get legal advice");
        
     	  
    }
    
    public void DocCreationFlagged(String FlagColor,String FlagState) throws InterruptedException
    {
     driver.findElement(By.xpath("//img[@alt='TestAppDocuSign']")).click();
  	  Thread.sleep(20000);
  	  if (iframe != currentFrame) {

            switchToFrame(iframe);

            currentFrame = iframe;
            
            driver.findElement(By.xpath("//span[contains(text(),'"+FlagColor+"')]")).click();
            driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).clear();
            driver.findElement(By.xpath("//p[contains(text(),'Counterparty')]//following::input[@class='qtext'][1]")).sendKeys("Tasnuva Disha");
            
            driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).clear();
            driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][2]")).sendKeys("Aegon");
            
            driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).clear();
            driver.findElement(By.xpath("//strong[text()='Party 2']//preceding::input[@class='qtext'][1]")).sendKeys("auricgoldfinger34@outlook.com");
            
            driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][2]")).sendKeys("Visenya");
            
            driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 2']//preceding::input[@class='qtext'][1]")).sendKeys("severussnape120@outlook.com");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][4]")).sendKeys("Rhaenys");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][3]")).sendKeys("rhaenystarg@outlook.com");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][2]")).sendKeys("Rhaegar");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//preceding::input[@class='qtext'][1]")).sendKeys("tasdis@outlook.com");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][1]")).sendKeys("Viserys");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][2]")).sendKeys("viseyrystarg@outlook.com");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][3]")).sendKeys("Daenerys");
            
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).clear();
            driver.findElement(By.xpath("//span[text()='Round 3']//following::input[@class='qtext'][4]")).sendKeys("tehrintas@outlook.com");
            driver.findElement(By.xpath("//button[contains(text(),'Fire Web Service Call')]")).click();
            
            String downloadFilepath = "c:\\download";
      	
      	  
      	  WebElement element= driver.findElement(By.xpath("//*[@id='qa_session']/div[1]/span/a"));
      	  String Text=element.getText();
      	  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--test-type");
            options.addArguments("--disable-extensions"); //to disable browser extension popup
            driver.findElement(By.linkText(Text)).click();
            System.out.println("The .docx file has been downloaded succesfully");
            driver.switchTo().parentFrame();
            driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a")).click();
      	    Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Document List']")).click();
            driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
            
            Thread.sleep(2000);
            
           LegalRegressionSharedFunctions.CheckVisibility(".//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span", FlagState);
           driver.findElement(By.xpath("//div[text()='Mark In Review']")).click();
           Thread.sleep(20000);
           LegalRegressionSharedFunctions.CheckVisibility(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/h2/span", "In Review");
           Thread.sleep(20000);
           driver.findElement(By.xpath(".//*[@id='approve-transitions']")).click();
           Thread.sleep(2000);
           driver.findElement(By.xpath(".//*[@id='transition-Approve']")).click();
           driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/textarea")).sendKeys("test approve");
           driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button[1]")).click();
           Thread.sleep(40000);
           LegalRegressionSharedFunctions.CheckVisibility("//*[@id='page-wrapper']/div[2]/div[1]/div/div/h2/span", "Approved");
           driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a")).click();
           Thread.sleep(20000);
           LegalRegressionSharedFunctions.CheckVisibility(".//*[@id='page-wrapper']/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/span", "Approved");
           driver.findElement(By.xpath("//*[@id='side-menu']/li[3]/a")).click();
           Thread.sleep(20000);
           driver.findElement(By.xpath("//span[text()='Document List']")).click();
           WebElement element2=driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[2]/span"));
           String status=element2.getText();
           driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/a")).click();
           driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a")).click();
           Thread.sleep(20000);
           WebElement element3=driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/span"));
           String status2=element3.getText();
           if(status.equals(status2))
           {
        	   System.out.println("The recently viewed document is showed");
           }
           driver.findElement(By.xpath(".//*[@id='user-initials']/img"));
           driver.findElement(By.xpath(".//*[@id='page-wrapper']/nav/ul/li/div/ul/li[1]/a")).click();
           Logout();
  	  }
            
  	  }
  	  
  	  public void switchToFrame(int iframe) {

  	      driver.switchTo().defaultContent();

  	      driver.switchTo().frame(iframe);

  	  }
  	  
  	  
    
    
    
    
}
