package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getFile() {
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/data.xlsx";

		File scrFile = new File(filePath);
		try {
			fis = new FileInputStream(scrFile);
		} catch (FileNotFoundException e) {
			System.out.print("File is not found !!");
		}
		return fis;
	}

	public Object[][] getExcelData() throws IOException {
		fis = getFile();
		// Access Excel workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Access sheet 1 of excel
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		// Get number of rows
		int totalRows = (sheet1.getLastRowNum() + 1);
		// Get number of columns
		int totalCol = 1;
		// Array to access data of cell
		String[][] arrayExcelData = new String[totalRows][totalCol];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				// Get row i
				XSSFRow row = sheet1.getRow(i);
				// Add data of row i & column J to array
				arrayExcelData[i][j] = row.getCell(j).toString();
			}

		}
		wb.close();
		return arrayExcelData;
	}
}
