package marionobre.pt.testautomation.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner{
	
	WebDriver driver;
	WebElement element;
	
	public void startTest() {
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	}
	
	public void endTest() {
		 driver.close();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public TestRunner getRunner() {
		return this;
	}
	
	public void navigate(String url) {
		driver.get(url);
		driver.manage().window().fullscreen();
	}
	
	public void setValue(String value) {
		element.sendKeys(value);
	}
	
	public WebElement createObject(String id) {
		element = driver.findElement(By.id(id));
		return element;
	}
}
