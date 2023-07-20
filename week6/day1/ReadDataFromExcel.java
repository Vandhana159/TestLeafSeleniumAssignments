package testLeafAssignments.week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] excelDatas(String fileName, String sheetName) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/"+fileName+".xlsx");
		System.out.println("File name "+"./data/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheet(sheetName);
		System.out.println("Sheet name "+sheetName);
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		System.out.println("Total number of Rows written in excel excluding column header "+rowCount);
		System.out.println("Total number of Column written in excel "+columnCount);
		for(int i = 1; i <= rowCount; i++) {
			for(int j = 0; j < columnCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		book.close();
		return data;
		
			/*	XSSFWorkbook book = new XSSFWorkbook("./testdata/"+fileName+".xlsx");
				XSSFSheet sheet = book.getSheet(sheetName);
				int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
				System.out.println(physicalNumberOfRows);
				int rowCount = sheet.getLastRowNum();
				System.out.println(rowCount);
				int colCount = sheet.getRow(1).getLastCellNum();
				System.out.println(colCount);
				String[][] data = new String[rowCount][colCount];
				for (int i = 1; i <= rowCount; i++) {
					for (int j = 0; j < colCount; j++) {
						String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
						data[i - 1][j] = stringCellValue;
					}}
				book.close();
				return data;
*/
	}

}
