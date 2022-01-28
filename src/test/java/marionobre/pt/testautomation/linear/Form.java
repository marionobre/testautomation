package marionobre.pt.testautomation.linear;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {
  private WebDriver driver;
  
  @Before
  public void setUp() {
	 WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void FormTestName() {
	//start browser with the URL given in the args
    driver.get("https://demoqa.com/text-box");
    //changes the browser to fullscreen
    driver.manage().window().fullscreen();
    //fills data on the required fields
    driver.findElement(By.id("userName")).sendKeys("Super Mario");
    driver.findElement(By.id("userEmail")).sendKeys("mario@supermario.com");
    driver.findElement(By.id("currentAddress")).sendKeys("Mushroom Kingdom");
    driver.findElement(By.id("permanentAddress")).sendKeys("World 1");
    //clicks the submit button
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:Super Mario"));
  }
  
  @Test
  public void FormTestEmail() {
	//start browser with the URL given in the args
    driver.get("https://demoqa.com/text-box");
    //changes the browser to fullscreen
    driver.manage().window().fullscreen();
    //fills data on the required fields
    driver.findElement(By.id("userName")).sendKeys("Luigi");
    driver.findElement(By.id("userEmail")).sendKeys("luigi@supermario.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Mansion");
    driver.findElement(By.id("permanentAddress")).sendKeys("World 2");
    //clicks the submit button
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected
    assertThat(driver.findElement(By.id("email")).getText(), is("Email:luigi@supermario.com"));
  }
  
  @Test
  public void FormTestNameNewData() {
    driver.get("https://demoqa.com/text-box");
    driver.manage().window().fullscreen();
    driver.findElement(By.id("userName")).sendKeys("Toad");
    driver.findElement(By.id("userEmail")).sendKeys("toad@supermario.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Forest");
    driver.findElement(By.id("permanentAddress")).sendKeys("World 3");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:Toad"));
  }
  
}
