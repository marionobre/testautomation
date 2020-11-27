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
    driver.findElement(By.id("userName")).sendKeys("Big Bird");
    driver.findElement(By.id("userEmail")).sendKeys("bigbird@sesamestreet.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Bird House");
    driver.findElement(By.id("permanentAddress")).sendKeys("Sesame Street");
    //clicks the submit button
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:Big Bird"));
  }
  
  @Test
  public void FormTestEmail() {
	//start browser with the URL given in the args
    driver.get("https://demoqa.com/text-box");
    //changes the browser to fullscreen
    driver.manage().window().fullscreen();
    //fills data on the required fields
    driver.findElement(By.id("userName")).sendKeys("Big Bird");
    driver.findElement(By.id("userEmail")).sendKeys("bigbird@sesamestreet.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Bird House");
    driver.findElement(By.id("permanentAddress")).sendKeys("Sesame Street");
    //clicks the submit button
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected
    assertThat(driver.findElement(By.id("email")).getText(), is("Email:bigbird@sesamestreet.com"));
  }
  
  @Test
  public void FormTestNameForceFail() {
    driver.get("https://demoqa.com/text-box");
    driver.manage().window().fullscreen();
    driver.findElement(By.id("userName")).sendKeys("Big Bird");
    driver.findElement(By.id("userEmail")).sendKeys("bigbird@sesamestreet.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Bird House");
    driver.findElement(By.id("permanentAddress")).sendKeys("Sesame Street");
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected (in this test it will fail on purpose
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:Elmo"));
  }
  
  @Test
  public void FormTestEmailForceFail() {
    driver.get("https://demoqa.com/text-box");
    driver.manage().window().fullscreen();
    driver.findElement(By.id("userName")).sendKeys("Big Bird");
    driver.findElement(By.id("userEmail")).sendKeys("bigbird@sesamestreet.com");
    driver.findElement(By.id("currentAddress")).sendKeys("The Bird House");
    driver.findElement(By.id("permanentAddress")).sendKeys("Sesame Street");
    driver.findElement(By.id("submit")).click();
    //checks that the text is what was expected (in this test it will fail on purpose
    assertThat(driver.findElement(By.id("email")).getText(), is("Email:bigbirdsesamestreet.com"));
  }
  
}
