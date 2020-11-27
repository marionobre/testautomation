package marionobre.pt.testautomation.structured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner{
	
	WebDriver driver;
	WebElement element;
	
	/*
	 * Should be called before each jUnit test is started
	 * Starts WebDriverManager which will download the latest version of ChromeDriver if it is missing
	 */
	public void startTest() {
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	}
	
	/*
	 * Should be called before each jUnit test is finished
	 * Closes the browser
	 */
	public void endTest() {
		 driver.close();
	}
	
	/*
	 * Returns the currently opened WebDriver
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/*
	 * Returns the active testrunner
	 */
	public TestRunner getRunner() {
		return this;
	}
	
	/*
	 * Inserts the URL into the browser and set the browser to fullscreen
	 */
	public void navigate(String url) {
		driver.get(url);
		driver.manage().window().fullscreen();
	}
	
	/*
	 * Sets the value of any element to the given arg
	 */
	public void setValue(String value) {
		element.sendKeys(value);
	}
	
	/*
	 * Creates an object by id
	 */
	public WebElement createObject(String id) {
		element = driver.findElement(By.id(id));
		return element;
	}
}
