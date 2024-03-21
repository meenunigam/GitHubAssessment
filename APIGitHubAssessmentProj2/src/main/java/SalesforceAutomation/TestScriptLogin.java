package SalesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScriptLogin extends BaseTestSF {
	//BaseTestSF baseObj = new BaseTestSF();
	
	public void loginSFOne(String userName, String password) throws InterruptedException {
		
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, "Login Button");
		
		WebElement error = driver.findElement(By.id("error"));
		gettingText(error);
		
		System.out.println(error.getText());
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
public void loginSFTwo(String userName, String password) throws InterruptedException {
		
		createDriver("https://login.salesforce.com");
		Thread.sleep(5000);
		
		WebElement userTextBox = driver.findElement(By.id("username"));
		sendingText(userTextBox,userName);
		
		WebElement passwdTextBox = driver.findElement(By.id("password"));
		sendingText(passwdTextBox,password);
		
		WebElement loginBut = driver.findElement(By.id("Login"));
		ClickBut(loginBut, "Login Button");
		
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		gettingText(homePage);
		
		Thread.sleep(5000);
		
		driver.close();
	}

	public void loginSFThree(String userName, String password) throws InterruptedException {
	
	createDriver("https://login.salesforce.com");
	Thread.sleep(5000);
	
	WebElement userTextBox = driver.findElement(By.id("username"));
	sendingText(userTextBox,userName);
	
	WebElement passwdTextBox = driver.findElement(By.id("password"));
	sendingText(passwdTextBox,password);
	WebElement rememberBut = driver.findElement(By.id("rememberUn"));
	ClickBut(rememberBut, "Remember Check Box");
	
	WebElement loginBut = driver.findElement(By.id("Login"));
	ClickBut(loginBut, " Login Button");
	
	WebElement homePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
	gettingText(homePage);
	
	WebElement userMenu = driver.findElement(By.id("userNavButton"));
	ClickBut(userMenu, "User Menu");
	
	WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
	ClickBut(logout, "Logout Button");
	
	Thread.sleep(2000);
	
	WebElement userNameBox = driver.findElement(By.id("idcard-identity"));
	gettingText(userNameBox);
	
	Thread.sleep(5000);
	
	driver.close();
}

public void loginSFFour(String userName) throws InterruptedException {
	
	createDriver("https://login.salesforce.com");
	Thread.sleep(5000);
	
	WebElement userTextBox = driver.findElement(By.id("username"));
	sendingText(userTextBox,userName);
	
	WebElement forgotpass = driver.findElement(By.id("forgot_password_link"));
	ClickBut(forgotpass, "forgot password");
	
	Thread.sleep(2000);
	WebElement enterEmail = driver.findElement(By.id("un"));
	sendingText(enterEmail, "meenunigam@gmail.com");
	
	WebElement continueBut = driver.findElement(By.id("continue"));
	ClickBut(continueBut, "continue button");
	
	Thread.sleep(5000);
	
	driver.close();
}

public void loginSFFive(String userName, String password) throws InterruptedException {
	
	createDriver("https://login.salesforce.com");
	Thread.sleep(5000);
	
	WebElement userTextBox = driver.findElement(By.id("username"));
	sendingText(userTextBox,userName);
	
	WebElement passwdTextBox = driver.findElement(By.id("password"));
	sendingText(passwdTextBox,password);
	
	WebElement loginBut = driver.findElement(By.id("Login"));
	ClickBut(loginBut, "Login Button");
	
	Thread.sleep(2000);
	
	WebElement error = driver.findElement(By.id("error"));
	gettingText(error);
	
	Thread.sleep(5000);
	
	driver.close();
	}

/*public static void main(String[] args) throws InterruptedException {
	
	TestScriptLogin testObj = new TestScriptLogin();
	String usrName = "meenu@tekarch.com";
	String passwrd = "dolly123";
	
	//testObj.loginSFOne(usrName,passwrd);
	//testObj.loginSFTwo(usrName,passwrd);
	//testObj.loginSFThree(usrName,passwrd);
	//testObj.loginSFFour(usrName);
	testObj.loginSFFive("123", "22131");
}*/

}