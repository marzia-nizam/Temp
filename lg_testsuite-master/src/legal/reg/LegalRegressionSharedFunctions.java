package legal.reg;
import static com.heliumhq.API.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static com.heliumhq.API.*;
public class LegalRegressionSharedFunctions {
	
	public static WebDriver driver=null;
    
	
	public static String ActualText= null;
	public static int iframe = 0;
	public static int currentFrame=1;
	public static String Keyword="Acme";
	public static String MailID="automation.test.5152";
	public static String MailID2="automation.test.515";
	static Random random = new Random();
	public static String InviteUser= MailID + "+"+random.nextInt(1000)+"@gmail.com";
	public static String InviteUser2= MailID2 + "+"+random.nextInt(1000)+"@gmail.com";
	
	@BeforeClass(alwaysRun=true)
	public static void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E://ECLIPSE//workplace//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D://ECLIPSE//eclipse workplace//geckodriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	    driver = new ChromeDriver( options );
	    setDriver(driver);
	    getDriver();
		//driver= new FirefoxDriver();
		driver.get("https://ext.legalgateway.com.au/gateway/login?next=/gateway/");
	   
	  
	    
	}
	
	public static void Login(String OrganisationName)
	{
		driver.findElement(By.id("username")).sendKeys("automation.user.ext@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password1234567890");
		driver.findElement(By.id("login-button")).click();
		ImplicitWait(40);
		/*Select oSelect1 = new Select(driver.findElement(By.name("organisation")));
	    oSelect1.selectByVisibleText(OrganisationName);
	    driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[2]")).click();
		ImplicitWait(40);*/
	    //CheckVisibility("//h1[@id='welcome-message']","Afternoon, disha. What legal support do you require?");
		
		System.out.println("Logged in successfully");
		
	}
	
	public static void LoginApp()
	{
		driver.get("https://app.legalgateway.com.au/gateway/login?next=/gateway/");
		driver.findElement(By.id("username")).sendKeys("disha.tasnuva@tekarsh.com");
		driver.findElement(By.id("password")).sendKeys("456789@");
		driver.findElement(By.id("login-button")).click();
		ImplicitWait(40);
		
	    //CheckVisibility("//h1[@id='welcome-message']","Afternoon, disha. What legal support do you require?");
		
		System.out.println("Logged in successfully");
		
	}
	public static void ScrollDownintoView(String xpath)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(xpath)));
	}
	
	
public static void verifyImagePresence(String xpath) {
		
		
	
		
		WebElement ImageFile = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
	    if (!ImagePresent)
	    {
	         System.out.println("Image not displayed.");
	    }
	    else
	    {
	        System.out.println("Image displayed.");
	    }
		
	}

public static void verifyElementVisibility(String xpath)
{
	boolean element=driver.findElement(By.xpath(xpath)).isDisplayed();
	
	if(element==true)
	{
		System.out.println("The element is visible");
	}
	else
	{
		System.out.println("The element is not visible");
	}
	
}

public static void VerifyListofElementsVisibility(String xpath)
{
	List<WebElement> elements = (List<WebElement>) driver.findElements(By.xpath(xpath));
	int elementcount = elements.size();
	System.out.println( "The number of elements displayed on this page are " + elementcount);
			  for(int i = 0; i < elementcount; ++i) {
			       
				  
			      if(  ( elements.get(i).isDisplayed()==true))
			       {
			    	   
			    	  System.out.println("The elements are visible");
			    	   
			    	  
			    	   
			       }
			       

  }
}
	
	public static void Logout()
	{
		driver.findElement(By.xpath(".//*[@id='user-initials']/img")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public static void ImplicitWait(int sec)
	{
		 driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		
	}
	
	  public static boolean isElementPresent(By by) {
		    try 
		    {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	
	public static void CheckVisibility(String xpath,String DesiredText)
    {
		WebElement selectElement = driver.findElement(By.xpath(xpath));
		String Text=selectElement.getText();
		System.out.println(Text);
		Assert.assertEquals(Text, DesiredText, "Expected Text not found");
		 System.out.println(Text.equals(DesiredText));
		
  }
	
	 public static void SearchDocuments(String AppOptions) throws InterruptedException
	  {
		  

	      Select oSelect1 = new Select(driver.findElement(By.name("app")));
	      oSelect1.selectByVisibleText(AppOptions);
	      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[1]/form/div[5]/button")).click();
	      Thread.sleep(2000);
	      switch (AppOptions) {
	      case "Influencer Agreement":
	    	  List<WebElement> firstappoption = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//following::span[contains(text(),'Influencer Agreement')]"));
	    	  	int firstappcount = firstappoption.size();
	    	  	System.out.println( "The number of Influencer Agreement documents displayed on this page are " + firstappcount);
	    	  			  for(int i = 0; i < firstappcount; ++i) {
	    	  			   
	    	  			      if(  ( firstappoption.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case "NDA Wizard":
	    	  List<WebElement> secondappoption = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//following::span[contains(text(),'NDA Wizard')]"));
	  	  	int secondappcount = secondappoption.size();
	  	  	System.out.println( "The number of NDA Wizard documents displayed on this page are " + secondappcount);
	  	  			  for(int i = 0; i < secondappcount; ++i) {
	  	  			   
	  	  			      if(  ( secondappoption.get(i).isDisplayed()==true))
	  	  			        {
  	  			    	   
   	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
   	  			    	   
   	  			    	  
   	  			    	   
   	  			       }
   	  			       else
   	  			       {
   	  			    	   System.out.println("The app types of this page are not visible");
   	  			       }
	  	  			    
	  	  			  }
	  	  			  break;
	      case "Promotion Wizard":
	    	  List<WebElement> thirdappoption = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//following::span[contains(text(),'Promotion Wizard')]"));
	    	  	int thirdappcount = thirdappoption.size();
	    	  	System.out.println( "The number of Promotion Wizard documents displayed on this page are " + thirdappcount);
	    	  			  for(int i = 0; i < thirdappcount; ++i) {
	    	  			   
	    	  			      if(  ( thirdappoption.get(i).isDisplayed()==true))
	    	  			      {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			       
	    	  			    
	    	  			  }
	    	  			  break;
	      case "Status App":  
	    	  List<WebElement> forthappoption = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//following::span[contains(text(),'Status App')]"));
	  	  	int forthappcount = forthappoption.size();
	  	  	System.out.println( "The number of Status App documents  displayed on this page are " + forthappcount);
	  	  			  for(int i = 0; i < forthappcount; ++i) {
	  	  			   
	  	  			      if(  ( forthappoption.get(i).isDisplayed()==true))
	  	  			  {
  	  			    	   
   	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
   	  			    	   
   	  			    	  
   	  			    	   
   	  			       }
   	  			       else
   	  			       {
   	  			    	   System.out.println("The app types of this page are not visible");
   	  			       }
	  	  			       
	  	  			    
	  	  			  }
	  	  			  break;
	      case "TestAppDocuSign": 
	    	  List<WebElement> fifthappoption = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//following::span[contains(text(),'TestAppDocuSign')]"));
	    	  	int fifthappcount = fifthappoption.size();
	    	  	System.out.println( "The number of TestAppDocuSign  displayed on this page are " + fifthappcount);
	    	  			  for(int i = 0; i < fifthappcount; ++i) {
	    	  			   
	    	  			      if(  ( fifthappoption.get(i).isDisplayed()==true))
	    	  			       {
	    	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			       
	    	  			    
	    	  			  }
	             
	               break;
	      default: break;
	  }
	 
	  			 
	  
	  }
	
		
		
	
	  public  void switchToFrame(int iframe) {

	      driver.switchTo().defaultContent();

	      driver.switchTo().frame(iframe);

	  }
	  public void loginToPlexus(String url, String email, String password) throws InterruptedException
		{
			driver.get(url);
			driver.findElement(By.id("username")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			ImplicitWait(40);
			Thread.sleep(8000);
			/*boolean applicationError = true;
			do
			{
				try
				{
					Thread.sleep(8000);
					//if(!applicationError)
					if(driver.findElement(By.xpath(".//div[contains(text(),'Application error')]")).isDisplayed())
					{
						
						System.out.println("Application error displayed, refreshing page...");
						driver.navigate().refresh();
						Thread.sleep(8000);
					}
				}
				catch(Exception e)
				{
					System.out.println("Application error did not appear");
					applicationError = false;
				}
			}while(applicationError!=false);*/
			Assert.assertTrue( driver.getTitle().contains("Dashboard") , "Error logging in");
		    //CheckVisibility("//h1[@id='welcome-message']","Afternoon, disha. What legal support do you require?");
			if(driver.getTitle().contains("Dashboard"))
			{
				System.out.println("Logged in successfully");
			}
			else
			{
				System.out.println("Error logging in");
			}
			
		}
		
		public void loginToPlexusFromLoginPage( String email, String password) throws InterruptedException
		{
			//driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			ImplicitWait(40);
			Thread.sleep(8000);
			
			Assert.assertTrue( driver.getTitle().contains("Dashboard") , "Error logging in");
		    //CheckVisibility("//h1[@id='welcome-message']","Afternoon, disha. What legal support do you require?");
			if(driver.getTitle().contains("Dashboard"))
			{
				System.out.println("Logged in successfully");
			}
			else
			{
				System.out.println("Error logging in");
			}
			
		}
		
		public void clickSideBarItem(String itemName)
		{
			driver.findElement(By.xpath(".//div[@class='sidebar-collapse']//../ul[1]//../li/a//following::span[text()='"+itemName+"']")).click();
		}
	  
		
	 public static void SearchDocumentswithStatus(String AppStatus) throws InterruptedException
	  {
		  
	
	      Select oSelect1 = new Select(driver.findElement(By.name("status")));
	      oSelect1.selectByVisibleText(AppStatus);
	      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[1]/form/div[5]/button")).click();
	      Thread.sleep(2000);
	      switch (AppStatus) {
	      case "Amended":
	    	  List<WebElement> firstappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Amended')]"));
	    	  	int firstappstatuscount = firstappoptionstatus.size();
	    	  	System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + firstappstatuscount);
	    	  			  for(int i = 1; i < firstappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( firstappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case "Approved":
	    	  List<WebElement> secondappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Approved')]"));
	    	  	int secondappstatuscount = secondappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + secondappstatuscount);
	    	  			  for(int i = 1; i < secondappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( secondappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case "Authored":
	    	  List<WebElement> thirdappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Authored')]"));
	    	  	int thirdappstatuscount = thirdappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + thirdappstatuscount);
	    	  			  for(int i = 1; i < thirdappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( thirdappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case "Awaiting Signature":  
	    	  List<WebElement> forthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Awaiting Signature')]"));
	    	  	int forthappstatuscount = forthappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + forthappstatuscount);
	    	  			  for(int i = 1; i < forthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( forthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case "Cancelled": 
	    	  List<WebElement> fifthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Cancelled')]"));
	    	  	int fifthappstatuscount = fifthappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + fifthappstatuscount);
	    	  			  for(int i = 1; i < fifthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( fifthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Client Signed":
	    	  List<WebElement> sixthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Client Signed')]"));
	    	  	int sixthappstatuscount = sixthappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + sixthappstatuscount);
	    	  			  for(int i = 1; i < sixthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( sixthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Declined" :
	    	  List<WebElement> seventhappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Declined')]"));
	    	  	int seventhappstatuscount = seventhappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + seventhappstatuscount);
	    	  			  for(int i = 1; i < seventhappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( seventhappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Deleted":
	    	  List<WebElement> eightappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Deleted')]"));
	    	  	int eighthappstatuscount = eightappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + eighthappstatuscount);
	    	  			  for(int i = 1; i < eighthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( eightappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Executed":
	    	  List<WebElement> ninthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Executed')]"));
	    	  	int ninthappstatuscount = ninthappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + ninthappstatuscount);
	    	  			  for(int i = 1; i < ninthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( ninthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Requires Approval":
	    	  List<WebElement> tenthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Requires Approval')]"));
	    	  	int tenthappstatuscount = tenthappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + tenthappstatuscount);
	    	  			  for(int i = 1; i < tenthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( tenthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Flagged (Red)":
	    	  List<WebElement> eleventhappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Flagged (Red)')]"));
	    	  	int eleventhappstatuscount = eleventhappoptionstatus.size();
	    		System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + eleventhappstatuscount);
	    	  			  for(int i = 1; i < eleventhappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( eleventhappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "In Review" :
	    	  List<WebElement> twelvethappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'In Review')]"));
	    	  	int twelvethappstatuscount = twelvethappoptionstatus.size();
	    	  	System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + twelvethappstatuscount);
	    	  			  for(int i = 1; i < twelvethappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( twelvethappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Rejected":
	    	  List<WebElement> thirteenthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Rejected')]"));
	    	  	int thirteenthappstatuscount = thirteenthappoptionstatus.size();
	    	  	System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + thirteenthappstatuscount);
	    	  			  for(int i = 1; i < thirteenthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( thirteenthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Updated":
	    	  List<WebElement> forteenthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Updated')]"));
	    	  	int forteenthappstatuscount = forteenthappoptionstatus.size();
	    	  	System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + forteenthappstatuscount);
	    	  			  for(int i = 1; i < forteenthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( forteenthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      case  "Voided":
	    	  List<WebElement> fifteenthappoptionstatus = (List<WebElement>) driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[contains(text(),'Voided')]"));
	    	  	int fifteenthappstatuscount = fifteenthappoptionstatus.size();
	    	  	System.out.println( "The number of "+AppStatus+" documents displayed on this page are " + fifteenthappstatuscount);
	    	  			  for(int i = 1; i < fifteenthappstatuscount; ++i) {
	    	  			   
	    	  			      if(  ( fifteenthappoptionstatus.get(i).isDisplayed()==true))
	    	  			    {
	      	  			    	   
	    	  			    	  System.out.println("The number "+ i +" document's app option type is visible");
	    	  			    	   
	    	  			    	  
	    	  			    	   
	    	  			       }
	    	  			       else
	    	  			       {
	    	  			    	   System.out.println("The app types of this page are not visible");
	    	  			       }
	    	  			    
	    	  			  }
	    	  			  break;
	      default: break;
	  }
	 
	  			 
	  
	  }
	 
	 
	 
	 public static void AcsendingOrderVerification(String Factors) throws InterruptedException
	  {
		  
	      driver.findElement(By.xpath(".//*[@id='document-sort']")).click();
	      driver.findElement(By.xpath("//a[contains(text(),'"+Factors+"')]")).click();
	      driver.findElement(By.xpath(".//*[@id='document-sort']")).click();
	      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[1]/div/div/div/ul/li[10]/a")).click();
	      Thread.sleep(20000);
	      switch (Factors) {
	      case "Status":
	    	  ArrayList<String> obtainedList1 = new ArrayList<>(); 
	          List<WebElement> elementList1= driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[@class='label label-warning']"));
	         
			for(WebElement we:elementList1){
	             obtainedList1.add(we.getText());
	          }
	          ArrayList<String> sortedList1 = new ArrayList<>();   
	          for(String s:obtainedList1){
	          sortedList1.add(s);
	          }
	          Collections.sort(sortedList1);
	          Assert.assertTrue(sortedList1.equals(obtainedList1));
	          System.out.println("Acsending Order of Status is done correctly");
	    	  break;
	      case "Agreement Type":
	    	  ArrayList<String> obtainedList2 = new ArrayList<>(); 
	          List<WebElement> elementList2= driver.findElements(By.xpath("//span[@class='badge']"));
	          for(WebElement we:elementList2){
	             obtainedList2.add(we.getText());
	          }
	          ArrayList<String> sortedList2 = new ArrayList<>();   
	          for(String s:obtainedList2){
	          sortedList2.add(s);
	          }
	          Collections.sort(sortedList2);
	          Assert.assertTrue(sortedList2.equals(obtainedList2));
	          System.out.println("Acsending Order of Agreement Type is done correctly");
	    	  break;
	      case "Counter Party":
	    	  ArrayList<String> obtainedList3 = new ArrayList<>(); 
	          List<WebElement> elementList3= driver.findElements(By.xpath("//tbody/tr[*]/td[4]"));
	          for(WebElement we:elementList3){
	             obtainedList3.add(we.getText());
	          }
	          ArrayList<String> sortedList3 = new ArrayList<>();   
	          for(String s:obtainedList3){
	          sortedList3.add(s);
	          }
	          Collections.sort(sortedList3);
	        
	          Assert.assertTrue(sortedList3.equals(obtainedList3));
	    	  			  break;
	     
	    
	    	  			  
	      default: break;
	  }
	      
	      
	 }
	 public static void verifyTextPresent(String value)
	 {
	   WebElement element = driver.findElement(By.cssSelector("body"));
	      boolean feedBack = driver.findElement(By.cssSelector("body")).getText().contains(value);
	      boolean feedbackVisible = element.isDisplayed();
	      if(feedBack==true){
	          System.out.println(value+ " is present");
	          if(feedbackVisible==true){
	              System.out.println(value+ " is visible");
	          }
	          else{
	              System.out.println(value+ " is not visible");
	          }
	          

	      }
	      else  {
	          System.out.println(value+ " is not present");

	      } 
	 }
	 
	 public static void DecsendingOrderVerification(String Factors) throws InterruptedException
	  {
		  
		  driver.findElement(By.xpath(".//*[@id='side-menu']/li[3]/a/span")).click();
		 
	      Thread.sleep(20000);
	      driver.findElement(By.xpath(".//*[@id='document-sort']")).click();
	      driver.findElement(By.xpath("//a[contains(text(),'"+Factors+"')]")).click();
	      driver.findElement(By.xpath(".//*[@id='document-sort']")).click();
	      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[1]/div/div/div/ul/li[11]/a")).click();
	      Thread.sleep(20000);
	      switch (Factors) {
	      case "Status":
	    	  ArrayList<String> obtainedList1 = new ArrayList<>(); 
	          List<WebElement> elementList1= driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[@class='label label-warning']"));
	         
			for(WebElement we:elementList1){
	             obtainedList1.add(we.getText());
	          }
	          ArrayList<String> sortedList1 = new ArrayList<>();   
	          for(String s:obtainedList1){
	          sortedList1.add(s);
	          }
	          Collections.sort(sortedList1);
	          Collections.reverse(sortedList1);
	          Assert.assertTrue(sortedList1.equals(obtainedList1));
	          System.out.println("Decsending Order of Status is done correctly");
	    	  break;
	      case "Agreement Type":
	    	  ArrayList<String> obtainedList2 = new ArrayList<>(); 
	          List<WebElement> elementList2= driver.findElements(By.xpath("//td[@class='project-title']/span/a//preceding::span[@class='badge']"));
	          for(WebElement we:elementList2){
	             obtainedList2.add(we.getText());
	          }
	          ArrayList<String> sortedList2 = new ArrayList<>();   
	          for(String s:obtainedList2){
	          sortedList2.add(s);
	          }
	          Collections.sort(sortedList2);
	          Collections.reverse(sortedList2);
	          Assert.assertTrue(sortedList2.equals(obtainedList2));
	          System.out.println("Acsending Order of Agreement Type is done correctly");
	    	  			  break;
	      case "Counter Party":
	    	  ArrayList<String> obtainedList3 = new ArrayList<>(); 
	          List<WebElement> elementList3= driver.findElements(By.xpath("//tbody/tr[*]/td[4]"));
	          for(WebElement we:elementList3){
	             obtainedList3.add(we.getText());
	          }
	          ArrayList<String> sortedList3 = new ArrayList<>();   
	          for(String s:obtainedList3){
	          sortedList3.add(s);
	          }
	          Collections.sort(sortedList3);
	          Collections.reverse(sortedList3);
	          Assert.assertTrue(sortedList3.equals(obtainedList3));
	    	  			  break;
	     
	    
	    	  			  
	      default: break;
	  }
	  }	
	 public static void AssertVerification(String xpath,String DesiredText )
	    {
			WebElement selectElement = driver.findElement(By.xpath(xpath));
			String Text=selectElement.getText();
			System.out.println(Text);
			Assert.assertEquals(Text, DesiredText, "Expected Text not found");
			System.out.println(Text.equals(DesiredText));
			
	    }
	 public static void UploadFile(String xpath,String filelocation) throws InterruptedException
	 {
	 	  driver.findElement(By.xpath(xpath)).click();
	 	 
	 	  try{
	         // uploadFile("C:\\2559_terms_and_conditions.docx");
	 		  uploadFile(filelocation);
	       }
	       catch (Exception e)
	       {
	           System.out.println(e.getMessage());
	       }
	 	
	 }


	 public static void setClipboardData(String string) {
	        StringSelection stringSelection = new StringSelection(string);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	    }

	    public static void uploadFile(String FileName) throws AWTException
	    {
	        setClipboardData(FileName);

	        Robot robot = new Robot();
	        robot.delay(1000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);

	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.delay(3000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        waitFunction(6000);
	    }
	    
	    public static void waitFunction(int time)
	    {
	        try
	        {
	            Thread.sleep(time);

	        }
	        catch (InterruptedException e) {

	            System.out.println(e.getMessage());
	        }
	    }
}
