package SalesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestScriptOpty extends BaseTestSF{
	
	public void OptySFOne(String userName, String password) throws InterruptedException {
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, " Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(2000);
		
		WebElement opportTab = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		ClickBut(opportTab, "Opportunity Menu");
		
		Thread.sleep(2000);
		
		WebElement dropdnbut = driver.findElement(By.id("fcf"));
		ClickBut(dropdnbut, "drop down button clicked");
		
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	public void OptySFTwo(String userName, String password) throws InterruptedException {
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, " Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(2000);
		
		WebElement opportTab = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		ClickBut(opportTab, "Opportunity Menu");
		
		Thread.sleep(2000);
		
		WebElement newBut = driver.findElement(By.name("new"));
		ClickBut(newBut, "new button clicked");
		
		Thread.sleep(2000);
		
		WebElement opportName = driver.findElement(By.id("opp3"));
		sendingText(opportName,"opportunity name one");
		
		WebElement closeDate = driver.findElement(By.id("opp9"));
		sendingText(closeDate,"2/4/2024");
		
		WebElement stageDropDn = driver.findElement(By.id("opp11"));
		Select select = new Select(stageDropDn);
		select.selectByVisibleText("Qualification");
	
		WebElement saveBut = driver.findElement(By.name("save"));
		ClickBut(saveBut, "save button clicked");
		
		Thread.sleep(2000);
		
		WebElement newOpportunity = driver.findElement(By.id("opp3_ileinner"));
		gettingText(newOpportunity);
		
		if(newOpportunity.getText().equals("opportunity name one")) {
			System.out.println("New Opportunity successfully created");
		}
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	public void OptySFThree(String userName, String password) throws InterruptedException {
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, " Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(2000);
		
		WebElement opportTab = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		ClickBut(opportTab, "Opportunity Menu");
		
		Thread.sleep(2000);
		
		WebElement opportPipeLink = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		ClickBut(opportPipeLink, "Opportunity Pipeline clicked");
		
		Thread.sleep(2000);
		
		WebElement opportPipePage = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"));
		gettingText(opportPipePage);
		
		if(opportPipePage.getText().equals("Opportunity Pipeline")) {
			System.out.println("Successfully clicked opportunity pipeline");
		}
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	public void OptySFFour(String userName, String password) throws InterruptedException {
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, " Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(2000);
		
		WebElement opportTab = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		ClickBut(opportTab, "Opportunity Menu");
		
		Thread.sleep(2000);
		
		WebElement opportStuck = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		ClickBut(opportStuck, "Stuck Opportunity clicked");
		
		Thread.sleep(2000);
		
		WebElement opportStuckPage = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"));
		gettingText(opportStuckPage);
		
		if(opportStuckPage.getText().equals("Stuck Opportunities")) {
			System.out.println("Successfully clicked stuck opportunities");
		}
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	public void OptySFFive(String userName, String password) throws InterruptedException {
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, " Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(2000);
		
		WebElement opportTab = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		ClickBut(opportTab, "Opportunity Menu");
		
		Thread.sleep(2000);
		
		WebElement intervalDropDn = driver.findElement(By.id("quarter_q"));
		Select select = new Select(intervalDropDn);
		select.selectByVisibleText("Current and Next FQ");
		
		WebElement includeDropDn = driver.findElement(By.id("open"));
		Select selectOne = new Select(includeDropDn);
		selectOne.selectByVisibleText("Open Opportunities");
		
		WebElement runReportBut = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		ClickBut(runReportBut, "Run Report Button clicked");
		
		Thread.sleep(2000);
		
		WebElement opportReportPage = driver.findElement(By.xpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"));
		gettingText(opportReportPage);
		
		if(opportReportPage.getText().equals("Opportunity Report")) {
			System.out.println("Successfully clicked run Reports");
		}
		
		Thread.sleep(2000);
		
		driver.close();
	}
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TestScriptOpty testObj = new TestScriptOpty();
		String usrName = "meenu@tekarch.com";
		String passwrd = "dolly123";
		//testObj.OptySFOne(usrName,passwrd);
		//testObj.OptySFTwo(usrName,passwrd);
		//testObj.OptySFThree(usrName,passwrd);
		//testObj.OptySFFour(usrName,passwrd);
		//testObj.OptySFFive(usrName,passwrd);

	}

}
