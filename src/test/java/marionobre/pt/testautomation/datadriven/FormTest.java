package marionobre.pt.testautomation.datadriven;

import org.junit.Test;


import org.junit.Before;

import static org.junit.Assert.assertTrue;

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
  public void DataDrivenTest() {
	  navigate("https://demoqa.com/text-box");
	  assertTrue(formPage.dataFile());
  }
  
}
