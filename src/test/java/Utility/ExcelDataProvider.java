package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public void test_data() throws IOException {
	String path="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\RiddhiProjectData.xlsx";
    FileInputStream file= new FileInputStream(path);
    XSSFWorkbook wb=new XSSFWorkbook(file);
   String testdata= wb.getSheet("SectionSheet").getRow(0).getCell(0).getStringCellValue();
    System.out.println(testdata);
}
}