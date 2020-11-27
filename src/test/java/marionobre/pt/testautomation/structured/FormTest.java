package marionobre.pt.testautomation.structured;

import org.junit.Test;
import org.openqa.selenium.By;


import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
public class FormTest extends TestRunner{
  
	Form formPage;
	
  @Before
  public void setUp() {
	 startTest();
	 formPage = new Form(getRunner());	 
  }
  @After
  public void tearDown() {
    endTest();
  }
  @Test
  public void FormTestName() {
    navigate("https://demoqa.com/text-box");
    formPage.fillForm();
    formPage.clickSubmit();
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:John"));
  }
  
  @Test
  public void FormTestEmail() {
    navigate("https://demoqa.com/text-box");
    formPage.fillForm();
    formPage.clickSubmit();
    assertThat(driver.findElement(By.id("email")).getText(), is("Email:john.rambo@mail.com"));
  }
  
  @Test
  public void FormTestNameForceFail() {
    navigate("https://demoqa.com/text-box");
    formPage.fillForm();
    formPage.clickSubmit();
    assertThat(driver.findElement(By.id("name")).getText(), is("Name:Balboa"));
  }
  
  @Test
  public void FormTestEmailForceFail() {
    navigate("https://demoqa.com/text-box");
    formPage.fillForm();
    formPage.clickSubmit();
    assertThat(driver.findElement(By.id("email")).getText(), is("Email:juan.rambo@mail.com"));
  }
  
}
