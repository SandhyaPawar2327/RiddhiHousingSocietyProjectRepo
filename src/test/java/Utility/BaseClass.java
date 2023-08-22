package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	
	
	public static String addSection="gardensections";
	public static String secdropDown;
	public WebElement drp_section;
	public WebElement getsucessfulMsg;
	public WebElement drp_addContent;
	public static String search="sandhya pawar";
	
	
	protected ReadConfig readconfig=new ReadConfig();
	
	
	
	public static WebDriver driver;
	public String browser=readconfig.getBrowserName();
	public String url = readconfig.getApplicationURL();
	public String userName = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static Logger log;
	
	@BeforeTest
	public void setup() {
	
	log = LogManager.getLogger(BaseClass.class);
	
	if(browser.equalsIgnoreCase("chrome")) {
	   driver=new ChromeDriver();
	   log.info("Launching Chrome Browser");
	}
	else if(browser.equalsIgnoreCase("Edge"))
	{
		driver=new EdgeDriver();
		log.info("Launching Edge Browser");
	}
	else {
		     log.info("Invalid Browser");
		
	     }
	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

}
@AfterTest
public void tearDown() {
driver.close();
}
	public static void custom_handleDropDown(WebElement element, String visibleText) throws Exception {
		Select s=new Select(element);
		System.out.println(s.getFirstSelectedOption().getText());
		//s.selectByVisibleText(visibleText);
				}
	
public static void captureScreenshoot(String filename) throws IOException {
	

	String rs=RandomString.make(5);      // RandomString is a class make is a method of rs
	
	String Path="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\CapturedScreenShot";
	
	TakesScreenshot ts=(TakesScreenshot)driver;    //TakesScreenshot is a interface we can not create object of interface we can give reference of takesscrenshot 
  
	File source=ts.getScreenshotAs(OutputType.FILE);
  
	File destination=new File(Path+"//"+rs+".png");
  
	FileUtils.copyFile(source, destination);
	
	

}
public Object[][] exlRead(String excelFilePath) throws Exception {

	DataFormatter dFormatter = new DataFormatter();
	int row = XLUtils.getRowCount(excelFilePath, "sheet1");
	int column = XLUtils.getCellCount(excelFilePath, "sheet1", 1);
	FileInputStream file = new FileInputStream(excelFilePath);
	XSSFWorkbook wb = new XSSFWorkbook(file);
	XSSFSheet sh = wb.getSheet("Sheet1");

	Object[][] obj1 = new Object[row][1];

	Map<String, String> mapData;

	for (int i = 1; i <= row; i++) {
		
		mapData = new HashMap<String, String>();
		
		for (int j = 0; j < column; j++) {

			String key = dFormatter.formatCellValue(sh.getRow(0).getCell(j));

			String value = dFormatter.formatCellValue(sh.getRow(i).getCell(j));

			mapData.put(key, value);
		}
		
		obj1[i-1][0] = mapData;
	}
	return obj1;
}
	


}