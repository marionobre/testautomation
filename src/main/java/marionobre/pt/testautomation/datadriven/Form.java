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
	
	public boolean dataFile() {
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
				if (!verify("name", 			"Name:" + 					Data.get(String.valueOf(i) + "Name"))) { return false;};
				if (!verify("email", 			"Email:" + 					Data.get(String.valueOf(i) + "Email"))) { return false;};
				if (!verify("currentaddress", 	"Current Address :" + 		Data.get(String.valueOf(i) + "Address1"))) { return false;};
				if (!verify("permanentaddress", "Permananet Address :" +	Data.get(String.valueOf(i) + "Address2"))) { return false;};
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public Boolean verify(String field, String expectedValue) {
		switch (field) {
		case "name":
			return runner.createObject("name").getText().equals(expectedValue);
		case "email":
			return runner.createObject("email").getText().equals(expectedValue);
		case "currentaddress":
			return runner.createObject("currentAddress",1).getText().equals(expectedValue);
		case "permanentaddress":
			return runner.createObject("permanentAddress",1).getText().equals(expectedValue);
		default:
			return false;
		}
	}
	
}
