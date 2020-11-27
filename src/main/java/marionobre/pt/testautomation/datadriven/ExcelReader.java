package marionobre.pt.testautomation.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	/**
	 * 
	 * @return HashMap with key index + name of column and value
	 * @throws IOException
	 */
	public HashMap<String, String> readExcel(String fileName) throws IOException{
		
		HashMap<String, String> data = new HashMap<String, String>();
		ArrayList<String> column = new ArrayList<String>();
		int countColumns;
		//Opens data file stored in resources
	    File file =    new File(System.getProperty("user.dir")+"\\resources\\" + fileName);
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    //Read sheet inside the workbook by its name
	    XSSFSheet sheet = workbook.getSheet("Sheet1");
	    //Find number of rows in excel file
	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    //Get Column Headers for construction of keys
	    XSSFRow row = sheet.getRow(0);
	    for (countColumns = 0; countColumns < row.getLastCellNum(); countColumns++) {
            //Populate data on Array 
        	column.add(row.getCell(countColumns).getStringCellValue());    
        }
	    //Create a loop over all the rows of excel file to read it
	    for (int i = 1; i < rowCount+1; i++) {
	        row = sheet.getRow(i);
	        //Create a loop to read values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            //Populate data on Array 
		        	data.put(String.valueOf(i-1) + column.get(j), row.getCell(j).getStringCellValue());
		        }
	    	}
	    return data;
		}
	}