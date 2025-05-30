package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
      
	public static String readDataFromExcel(String sheetname, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		String cell = row.getCell(cellNum).getStringCellValue();
		return cell;
	}
	
}
