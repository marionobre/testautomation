package marionobre.pt.testautomation.datadriven;

import java.io.IOException;
import java.util.HashMap;

public class Form {

TestRunner runner;
	
	public Form(TestRunner rn) {
		runner=rn;
	}

	public void setName(String value) {
		runner.createObject("userName").clear();
		runner.createObject("userName").sendKeys(value);
	}
	
	public void setEmail(String value) {
		runner.createObject("userEmail").clear();
		runner.createObject("userEmail").sendKeys(value);
	}
	
	public void setCurrentAddress(String value) {
		runner.createObject("currentAddress").clear();
		runner.createObject("currentAddress").sendKeys(value);
	}
	
	public void setPermanentAddress(String value) {
		runner.createObject("permanentAddress").clear();
		runner.createObject("permanentAddress").sendKeys(value);
	}
	
	public void clickSubmit() {
		runner.createObject("submit").click();
	}
	
	public void fillForm() {
		setName("John");
		setEmail("john.rambo@mail.com");
		setCurrentAddress("Rambo Street");
		setPermanentAddress("Real Rambo");
	}
	
	public void dataFile() {
		try {
			HashMap<String, String> Data = new HashMap<String, String>();
			ExcelReader readFile = new ExcelReader();
			Data =readFile.readExcel("Data.xlsx");
			for (int i = 0; i < Data.size()/4; i++) {
				setName(Data.get(String.valueOf(i) + 				"Name"));
				setEmail(Data.get(String.valueOf(i) + 				"Email"));
				setCurrentAddress(Data.get(String.valueOf(i) + 		"Address1"));
				setPermanentAddress(Data.get(String.valueOf(i) + 	"Address2"));
				clickSubmit();
				verify("name", 				Data.get(String.valueOf(i) + "Name"));
				verify("email", 			Data.get(String.valueOf(i) + "Email"));
				verify("currentaddress", 	Data.get(String.valueOf(i) + "Address1"));
				verify("permanentaddress", 	Data.get(String.valueOf(i) + "Address2"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
