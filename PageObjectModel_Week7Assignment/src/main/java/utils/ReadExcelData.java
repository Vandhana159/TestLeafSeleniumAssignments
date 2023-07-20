package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String[][] readData(String fileName,String sheetName) throws IOException {
		//Accessing MS-Excel file/Book with File Name
		XSSFWorkbook book = new XSSFWorkbook("./testdata/"+fileName+".xlsx");
		//Accessing particular sheet in a excel file.book with sheet name 
		XSSFSheet sheet = book.getSheet(sheetName);
		//Getting total number of rows with value in the sheet
		int rowCount = sheet.getLastRowNum();
		//Getting total number of columns with value in the sheet
		int columnCount = sheet.getRow(1).getLastCellNum();
		System.out.println("Total number of Rows written in excel including column header "+rowCount);
		System.out.println("Total number of Column written in excel "+columnCount);
		//Declaring 2D array with fetched row and column count
		String[][] data = new String[rowCount][columnCount];
		//Iterating through row count from index 1 (Because row 0th index contains column header details)
		for(int i =1; i <= rowCount;i++) {
		//Iterating through column count from index 0	
			for(int j =0; j < columnCount; j++) {
		//Declaring a String variable and fetching the values from particular cell with row and column number(like 0,1)
				//and assigning to string variable. 
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
		//Here i value starts from 1 but array index starts from 0. So (i-1) 		
				data[i-1][j] = cellValue;
			}
		}
		//It is mandatory to close the opened book 
		book.close();
		//Returning all the data retrieved from the excel sheet as 2D array(row and column format)
		return data;
	}
}
