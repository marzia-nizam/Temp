package legal.reg;





import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//import static com.heliumhq.API.*;

public class Settings extends LegalRegressionSharedFunctions{
  @Test
  public void TestSettings() throws InterruptedException {
	  
	  Login("THE TESTING ACCOUNT");
	  Thread.sleep(5000);
	  verifyElementVisibility(".//h1[@id='welcome-message']");
	  System.out.println("Welcome Message is Visible");
	
	  GotoAccount();
      AccountVerification();
	  CompanyStructureVerification();
	  
	  Scenario1();
	  
	  Scenario2();
	  Scenario3and4();
	  RolesVerification();
	  Scenario2Roles();
	  Scenario1Roles();
	  BrandSettings();
	  ///GotoUser();
	  Thread.sleep(2000);
	  clickSideBarItem("Users");
	  Thread.sleep(3000);
	  
	  UserVerification();
	  Thread.sleep(20000);
	  UserEditVerification();
	  /*
	  */
	
  }
  public void GotoAccount() throws InterruptedException
  {
	  //driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  clickSideBarItem("Settings");
	  Thread.sleep(4000);
	  clickSideBarItem("Account");
	  //driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[1]/a/span")).click();
	  Thread.sleep(2000);
  }
  
  public void GotoUser() throws InterruptedException
  {
	 // driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  Thread.sleep(2000);
	//  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[2]/a/span")).click();
	  clickSideBarItem("Settings");
	  Thread.sleep(5000);
	  clickSideBarItem("Users");
	  Thread.sleep(2000);
  }
  
  public void AccountVerification() throws InterruptedException
  {

	  CheckVisibility(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[1]/a", "Company Structure");
	  CheckVisibility(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[2]/a", "Roles");
	  CheckVisibility(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[3]/a", "Brand Settings");
	  
  }
  
  public void CompanyStructureVerification() throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[1]/a")).click();
	  CheckVisibility(".//*[@id='page-wrapper']/div[1]/div/ol/li[1]", "Settings");
	  CheckVisibility(".//*[@id='page-wrapper']/div[1]/div/ol/li[2]", "Account");
	  CheckVisibility(".//*[@id='page-wrapper']/div[1]/div/ol/li[3]", "Company Structure");

	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/a")).click();
	  String OrganisationName="Test Organisation 1";
	  driver.findElement(By.name("name")).sendKeys(OrganisationName);
	  Select oSelect1 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect1.selectByVisibleText("THE TESTING ACCOUNT");
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      Thread.sleep(30000);
      CheckVisibility("//*[@id='page-wrapper']/div[2]/div/div/div", "Organisational unit added");
      driver.findElement(By.xpath(".//div[text()='THE TESTING ACCOUNT']//preceding::button[text()='Expand']")).click();
     // driver.findElement(By.xpath(".//div[text()='THE TESTING ACCOUNT']//preceding::button[text()='Collapse']")).click();
      
      Thread.sleep(1500);
      driver.findElement(By.xpath("//div[contains(text(),'"+OrganisationName+"')]")).click();
      Thread.sleep(1500);
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button[2]")).click();
      //CheckVisibility("//*[@id='page-wrapper']/div[3]/div/div/div", "Organisational unit deleted");
 
  }
  
 
  
  public void Scenario1() throws InterruptedException
  {
	  String firstorg="org unit 1";
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  driver.findElement(By.name("name")).sendKeys(firstorg);
	  Select oSelect1 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect1.selectByVisibleText("THE TESTING ACCOUNT");
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      String secondorg="org unit 2";
      Thread.sleep(20000);
      driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  Thread.sleep(20000);
      driver.findElement(By.name("name")).sendKeys(secondorg);
      Thread.sleep(20000);
	  Select oSelect2 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect2.selectByVisibleText("THE TESTING ACCOUNT");
      verifyElementVisibility("//option[contains(text(),'"+firstorg+"')]");
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      String thirdorg="org unit 3";
      Thread.sleep(20000);
      driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  Thread.sleep(20000);
      driver.findElement(By.name("name")).sendKeys(thirdorg);
	  Select oSelect3 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect3.selectByVisibleText("THE TESTING ACCOUNT");
      verifyElementVisibility("//option[contains(text(),'"+secondorg+"')]");
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      verifyElementVisibility("//div[contains(text(),'"+thirdorg+"')]");
  }
  
  public void Scenario2() throws InterruptedException
  {
	  String firstorg="Org A";
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  driver.findElement(By.name("name")).sendKeys(firstorg);
	  Select oSelect1 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect1.selectByVisibleText("THE TESTING ACCOUNT");
      ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      driver.findElement(By.xpath(".//label[contains(.,'Org Name')]//following::button[contains(.,'Save')][1]")).click();
      String secondorg="Org B";
      Thread.sleep(20000);
      driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  Thread.sleep(20000);
      driver.findElement(By.name("name")).sendKeys(secondorg);
	  Select oSelect2 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect2.selectByVisibleText("THE TESTING ACCOUNT");
      verifyElementVisibility("//option[contains(text(),'"+firstorg+"')]");
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      String childorg1="Org A1";
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.name("name")).sendKeys(childorg1);
	  Select oSelect3 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect3.selectByVisibleText(firstorg);
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      String childorg2="Org B1";
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  Thread.sleep(20000);
	  driver.findElement(By.name("name")).sendKeys(childorg2);
	  Select oSelect4 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect4.selectByVisibleText(secondorg);
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      Thread.sleep(20000);
      driver.findElement(By.xpath("//div[contains(text(),'"+secondorg+"')]")).click();
      Select oSelect5 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect5.selectByVisibleText(firstorg);
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      Thread.sleep(20000);
      AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[1]/div[2]/div/span","Organisation contains sub units that would exceed the maximum depth allowed" );
      
    
  }
  
  public void Scenario3and4() throws InterruptedException
  {
	  String firstorg="Test Org";
	  Thread.sleep(2000);
      driver.findElement(By.xpath("//a[contains(text(),'Create Sub Unit')]")).click();
	  driver.findElement(By.name("name")).sendKeys(firstorg);
	  Select oSelect1 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect1.selectByVisibleText("THE TESTING ACCOUNT");
      ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
     driver.findElement(By.xpath(".//label[contains(.,'Org Name')]//following::button[contains(.,'Save')][1]")).click();
      // driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div/ul/li/button")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(text(),'"+firstorg+"')]")).click();
      String editedorg=firstorg+"s";
      driver.findElement(By.name("name")).clear();
      driver.findElement(By.name("name")).sendKeys(editedorg);
      ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      
      driver.findElement(By.xpath(".//label[contains(.,'Org Name')]//following::button[contains(.,'Save')][1]")).click();
      
      Thread.sleep(4000);
      verifyTextPresent(editedorg);
      driver.findElement(By.xpath("//div[contains(text(),'"+editedorg+"')]")).click();
      Thread.sleep(3000);
      driver.findElement(By.name("name")).clear();
   
      ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      driver.findElement(By.xpath(".//label[contains(.,'Org Name')]//following::button[contains(.,'Save')][1]")).click();
      
      Thread.sleep(5000);
      AssertVerification("//span[contains(text(),'This field may not be blank.')]","This field may not be blank." );
      driver.findElement(By.name("name")).sendKeys(editedorg);
      Select oSelect3 = new Select(driver.findElement(By.name("organisationParent")));
      oSelect3.selectByIndex(0);
      ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/form/fieldset/div[3]/button")).click();
      driver.findElement(By.xpath(".//label[contains(.,'Org Name')]//following::button[contains(.,'Save')][1]")).click();
      
      Thread.sleep(3000);
      verifyTextPresent("Please select an item in the list.");
      
      }
  
  
  public void RolesVerification() throws InterruptedException
  {
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[2]/a")).click();
	  driver.findElement(By.xpath(".//a[contains(.,'Roles')]")).click();
	  
	  WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manager')]"));
	  String text=element.getText();
	  element.click();
	  WebElement element2 = driver.findElement(By.xpath("//h2[contains(text(),'Manager')]"));
	  String text2=element2.getText();
	  if(text.equals(text2))
	  {
		  System.out.println("Redirected to the correct role");
		  
	  }
	  String textcolor=element2.getCssValue("color");
	  
	  System.out.println(textcolor);
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[2]/a")).click();
	  ///driver.findElement(By.xpath("//a[contains(text(),'User')]")).click();
	  verifyTextPresent("rh");
	  verifyTextPresent("th");
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).click();
	  VerifyListofElementsVisibility(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li/a/span");
	  String Activeuser="disha";
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).sendKeys(Activeuser);
	  verifyTextPresent(Activeuser);
	  String Inactiveuser="dany";
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).clear();
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).sendKeys(Inactiveuser);
	  AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li/a","No matches found." );
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).sendKeys("disha tasnuva");
	  waitFunction(2000);
	  ///driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[1]/a/span/span")).click();
	  driver.findElement(By.xpath(".//strong[contains(text(),'disha tasnuva')]")).click(); ////
	  
	  //  click("disha tasnuva");
	//  driver.findElement(By.xpath("*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li/a/span/strong")).click();
	  Thread.sleep(2000);
	  ///driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/button")).click();
	  driver.findElement(By.xpath("//button[text()='Add Users']")).click(); ////
	  Thread.sleep(4000);
	  AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","Users were assigned to the role successfully" );
	  driver.findElement(By.xpath("//a[contains(text(),'disha tasnuva')]//following::button[contains(text(),'Remove')][1]")).click();
	  //scrollUp();
	  waitFunction(3000);
	  AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","disha tasnuva was removed from this role" );
	  
  
  }
  
  public void Scenario1Roles() throws InterruptedException
  {
	 // driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[2]/a")).click();
	  //click("Account");
	  //driver.findElement(By.xpath(""))
	  clickSideBarItem("Settings");
	  Thread.sleep(4000);
	  clickSideBarItem("Account");
	  driver.findElement(By.xpath(".//a[contains(.,'Roles')]")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Manager')]")).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).click();
	  driver.findElement(By.xpath(".//h2[contains(text(),'Manager')]//following::input[@placeholder='Add User']")).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).sendKeys("disha tasnuva");
	  driver.findElement(By.xpath(".//h2[contains(text(),'Manager')]//following::input[@placeholder='Add User']")).sendKeys("disha tasnuva");
	  waitFunction(2000);
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/h2")).click();
	  driver.findElement(By.xpath(".//strong[text()='disha tasnuva']")).click();
	  
	  waitFunction(1000);
	  ///driver.findElement(By.xpath(".//h2[contains(text(),'Manager')]//following::input[@placeholder='Add User']")).click();///
	  driver.findElement(By.xpath(".//h2[text()='Manager']//following::input[1]")).click();
	  ///driver.findElement(By.xpath(".//h2[contains(text(),'Manager')]//following::input[@placeholder='Add User']")).sendKeys("Cersei Lannister");////
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/input")).sendKeys("Cersei Lannister");
	 /// driver.findElement(By.xpath(".//h2[text()='Manager']//following::input[1]")).sendKeys("Cersei Lannister");
	  waitFunction(2000);
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li/a/span/strong")).click();
	 /// driver.findElement(By.xpath(".//strong[text()='Cersei Lannister']")).click();////
	  ///driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/h2")).click();
	  Thread.sleep(3000);////
      driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/button")).click();
      Thread.sleep(4000);
	  AssertVerification("//*[@id='page-wrapper']/div[2]/div/div/div","Users were assigned to the role successfully" );
  }
  public void Scenario2Roles() throws InterruptedException
  {
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/a/span")).click();
	  driver.findElement(By.xpath(".//*[@id='side-menu']/li[6]/ul/li[1]/a/span")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Roles')]")).click();
	 // click("Roles");
	  driver.findElement(By.xpath("//a[contains(text(),'Manager')]")).click();
	  VerifyListofElementsVisibility(".//*[@id='page-wrapper']/div[2]/div/div/div/div[1]/div/div/div[2]/div/table/tbody/tr/td[4]");
      WebElement element=driver.findElement(By.xpath("//td[@class='client-name']/a[contains(text(),'Tehrin Disha')]//following::td[2]"));
      String Text=element.getText();
      driver.findElement(By.xpath("//a[contains(text(),'Tehrin Disha')]")).click();
      WebElement element2=driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div/div[2]/dl/dd[3]"));
      String Text2=element2.getText();
      if(Text.equals(Text2))
	  {
		  System.out.println("Last Login time verified");
		  
	  }
      verifyElementVisibility(".//*[@id='page-wrapper']/div[2]/div/div[2]/div/div[1]/h5");
      verifyElementVisibility("//dl[@class='dl-horizontal']");
      verifyElementVisibility(".//*[@id='user-permissions-pane-organisation-roles']/div/div/span/button");
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-roles']/div/div/span/button")).click();
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-roles']/div/div/div/div/div/div/input")).click();
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-roles']/div/div/div/div/div/div/input")).sendKeys("User");
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-roles']/div/div/div/div/ul/li/a/span/strong")).click();
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-roles']/div/div/span/button")).click();
      Thread.sleep(20000);
	  AssertVerification("//*[@id='page-wrapper']/div[2]/div/div/div","User roles updated" );
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//a[contains(text(),'User')]//following::button[contains(text(),'Remove')]")).click();
	  Thread.sleep(20000);
	  AssertVerification("//*[@id='page-wrapper']/div[2]/div/div/div","User roles removed successfully" );
	  verifyElementVisibility("//table[@class='table table-striped table-hover']");
      driver.findElement(By.xpath("//a[contains(text(),'Units')]")).click();
      verifyElementVisibility(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/span/button");
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/span/button")).click();

      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/div/div/div/div/input")).click();
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/div/div/div/div/input")).sendKeys("Test Organisation");
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/div/div/ul/li/a/span/strong")).click();
      driver.findElement(By.xpath(".//*[@id='user-permissions-pane-organisation-permissions']/div/div/span/button")).click();
      Thread.sleep(20000);
	  AssertVerification("//*[@id='page-wrapper']/div[2]/div/div/div","User assigned to organisations" );
	  driver.findElement(By.xpath("//a[contains(text(),'Test Orgs')]//following::button")).click();
	  Thread.sleep(20000);
	  AssertVerification("//*[@id='page-wrapper']/div[2]/div/div/div","User unassigned from organisations" );
      verifyElementVisibility("//table[@class='table table-striped table-hover']");
      
	  
  }

public  void BrandSettings() throws InterruptedException
  {
	//driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/ul/li[3]/a")).click();
	 //click("Brand Settings");
	 Thread.sleep(3000);
	driver.findElement(By.xpath(".//a[contains(.,'Brand Settings')]")).click();
	Thread.sleep(3000);
	 ///AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[1]/label","Site Name" );
	 AssertVerification(".//label[text()='Site Name']", "Site Name");
	
	//AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[2]/label","Domain" );
	 AssertVerification(".//label[text()='Domain']", "Domain");
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[3]/label","Icon" );
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[4]/label","Large" );
	 UploadFile(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[3]/div/div/div/input","C:\\image.jpg");
	 Thread.sleep(5000);
	 UploadFile(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[1]/div[4]/div/div/div/input","C:\\test.png");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/div[2]/div/div/form/fieldset/div[3]/button")).click();
	 Thread.sleep(3000);
  }
  
  
public  void UserVerification() throws InterruptedException
{

	VerifyListofElementsVisibility("//td[@class='client-name']/a");
	VerifyListofElementsVisibility("//td[@class='client-status']/span");
	 verifyElementVisibility(".//*[@id='search']");
	 verifyElementVisibility(".//*[@id='invite-button']");
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 verifyElementVisibility(".//input[@id='email']");////
	 String InvalidEmail="InvalidAdrress";
	 Thread.sleep(2000);
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(InvalidEmail);
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 Thread.sleep(2000);
//	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","Error inviting user "+InvalidEmail+": Enter a valid email address." );
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 Thread.sleep(5000);
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","Error inviting user : Enter a valid email address." );
	 String ValidEmail="tasnuvatehrin@gmail.com";
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 Thread.sleep(7000);
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ValidEmail);
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 Thread.sleep(4000);
	// AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","Success: an invitation has been emailed to "+ValidEmail+"" );
	 String ExistingEmail="disha.tasnuva@tekarsh.com";
	 
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ExistingEmail);
	 driver.findElement(By.xpath(".//*[@id='invite-button']")).click();
	 Thread.sleep(2000);
//	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","User "+ExistingEmail+" already exists" );
	 
}

public void UserEditVerification() throws InterruptedException
{
	 String Username="test zzz account edt";
	 driver.findElement(By.xpath(".//*[@id='search']")).click();
	 driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(Username);
	 Thread.sleep(2000);
	 verifyElementVisibility("//a[contains(text(),'"+Username+"')]");
	 driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[1]/label","First Name" );
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[2]/label","Last Name" );
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[3]/label","Email" );
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[4]/label","Receive Notifications" );
	 driver.findElement(By.xpath(".//*[@id='firstName']")).clear();
	 driver.findElement(By.xpath(".//*[@id='email']")).clear();
	 Thread.sleep(20000);
	 driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();
	 driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();
	 Thread.sleep(2000);
	
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[1]/div/span","Please enter a first name" );
	// AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[2]/div/span","Please enter a last name" );
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div[2]/div/form/fieldset/div[3]/div/span","Please enter a valid email address" );
	 driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys(Username);
	 driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("disha");
	 ///driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("tasnuvatehrin@gmail.com");
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("test4fest+643@gmail.com");
	 
	 driver.findElement(By.xpath(".//*[@id='update-user-btn']")).click();
	 Thread.sleep(20000);
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","User details updated" );
	 driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div[1]/div/div/a")).click();
	 Thread.sleep(20000);
	 driver.findElement(By.xpath(".//button[contains(.,'Reset Password')]")).click();
	 Thread.sleep(20000);
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","Success: a password reset link has been email to test4fest+643@gmail.com" );
	 CheckMailandSign("test4fest@gmail.com","12345mmm");
	 Thread.sleep(10000);
	 driver.findElement(By.xpath("//*[@id='page-wrapper']/div[3]/div/div[1]/div/div/div[1]/div/div/button[2]/div")).click();
	 Thread.sleep(20000);
	 AssertVerification(".//*[@id='page-wrapper']/div[2]/div/div/div","test4fest+643@gmail.com has been deleted" );
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
	driver2.findElement(By.id("identifierId")).sendKeys(email);
	driver2.findElement(By.id("identifierNext")).click();
	driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver2.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
	Thread.sleep(2000);
	driver2.findElement(By.id("passwordNext")).click();
	driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver2.findElement(By.id("signIn")).click();

	// some optional actions for reaching g mail in box 
	driver2.findElement(By.xpath("//*[@title='Google apps' or @aria-label='Google apps']")).click();
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
		            driver2.findElement(By.partialLinkText("https://ext.legalgateway.com.au/gateway/reset-password")).click();
		          
		            String parentHandle2 = driver2.getWindowHandle(); 
		            for (String winHandle : driver2.getWindowHandles()) {
		      	        driver2.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		      	    }  
		          
		           
		            driver2.findElement(By.name("new_password1")).sendKeys("12345mmm");
		            driver2.findElement(By.name("new_password2")).sendKeys("12345mmm");
		            driver2.findElement(By.xpath("//button[contains(text(),'Reset Password')]")).click();
		        Thread.sleep(3000);
		                
		          driver2.close(); // close newly opened window when done with it
		           driver2.switchTo().window(parentHandle2);
		    	 
		    	    Thread.sleep(2000);
		    	    driver2.close();
		            driver.switchTo().window(MainWindowHandle);
		            break;
		        }
		        else{
		            System.out.println("No mail form " + MyMailer);
		        }
		    }
		}
	  
}
}
