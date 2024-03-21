package SalesforceAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSF {
	
	protected static WebDriver driver = null;
	
	public void createDriver(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void sendingText(WebElement textToSend, String UserText ) {
		textToSend.sendKeys(UserText);
		System.out.println("Text entered is " + UserText);
	}
	
	public void ClickBut(WebElement ele, String object) {
		ele.click();
		System.out.println("User clicked " + object);
	}
	
	public void gettingText(WebElement textToGet) {
		String newText = textToGet.getText();
		System.out.println("Text got from web element is " + newText);
	}
	
	public void clearTextBox(WebElement ele, String object) {
		ele.clear();
		System.out.println("Text Box cleared" + object);
	}
	

}
