package marionobre.pt.testautomation.structured;

public class Form {

TestRunner runner;
	
	/*
	 * When Form class is initialized it will be attached to the current test runner
	 * If a new tab is opened a new test runner must be initialized for the Form class to work on the new tab
	 */
	public Form(TestRunner rn) {
		runner=rn;
	}

	/*
	 * Sets the field Name to a specific value
	 */
	public void setName(String value) {
		runner.createObject("userName").sendKeys(value);
	}
	
	/*
	 * Sets the field Email to a specific value
	 */
	public void setEmail(String value) {
		runner.createObject("userEmail").sendKeys(value);
	}
	
	/*
	 * Sets the field CurrentAddress to a specific value
	 */
	public void setCurrentAddress(String value) {
		runner.createObject("currentAddress").sendKeys(value);
	}
	
	/*
	 * Sets the field PermanentAddress to a specific value
	 */
	public void setPermanentAddress(String value) {
		runner.createObject("permanentAddress").sendKeys(value);
	}
	
	/*
	 * Clicks the submit button
	 */
	public void clickSubmit() {
		runner.createObject("submit").click();
	}
	
	/*
	 * Fills the form with a specific data defined within the class
	 */
	public void fillForm() {
		setName("John");
		setEmail("john.rambo@mail.com");
		setCurrentAddress("Rambo Street");
		setPermanentAddress("Real Rambo");
	}
	
	/**
	 * Verify that the field is set to the value given
	 * @param field name of the field to be verified
	 * @param expectedValue value that is expected to appear in the field
	 * @return
	 */
	public Boolean verify(String field, String expectedValue) {
		switch (field) {
		case "name":
			return runner.createObject("name").getText().equals(expectedValue);
		case "email":
			return runner.createObject("email").getText().equals(expectedValue);
		case "currentaddress":
			return runner.createObject("currentAddress").getText().equals(expectedValue);
		case "permanentaddress":
			return runner.createObject("permanentAddress").getText().equals(expectedValue);
		default:
			return false;
		}
	}
}
