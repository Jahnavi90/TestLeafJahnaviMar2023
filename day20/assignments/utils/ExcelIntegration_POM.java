package utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration_POM {
	public static String[][] readExcel(String ExcelFile) throws IOException {
		XSSFWorkbook wbook = new XSSFWorkbook("./ExcelIntegration/"+ExcelFile+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();
		String[][] create = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				create[i-1][j] = stringCellValue;
			}
		}	
		wbook.close();
		return create;
	}
}
