package datadriventest;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class NewTest {
	@Test(dataProvider = "dp")
	public void f(String first, String last, String email, String mobno, String pass) {

	}

	@DataProvider
	public Object[][] dp() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Files//Registration.xlsx");

		XSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		int cellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowNum][cellNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {

				if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.STRING)) {
					obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}

				else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					long value = (long) sheet.getRow(i).getCell(j).getNumericCellValue();
					obj[i][j] = Long.toString(value);
				}
			}
		}
		wb.close();
		return obj;
	}
}
