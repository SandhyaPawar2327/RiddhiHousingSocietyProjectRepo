package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.BaseClass;

public class ListOfExpensesPom {
WebDriver driver;
public ListOfExpensesPom(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//span[text()=\"Expenses\"]")WebElement txtExpenses;
@FindBy(xpath="//a[@href=\"list_expenses.php\"]")WebElement listExpenses;
@FindBy(xpath="//input[@name=\"from_date\"]")WebElement fromDate;
@FindBy(xpath="//input[@name=\"to_date\"]")WebElement toDate;
@FindBy(xpath="//select[@id=\"selectbox\"]")WebElement drp_selectEmp;
@FindBy(xpath="//button[@name=\"submit\"]")WebElement btnSearch;
@FindBy(xpath="//input[@type=\"search\"]")WebElement Search;
//@FindBy(xpath="//a[@href=\"list_expenses.php?deleteid=58\"]")WebElement btnDelete;
@FindBy(xpath="(//a[@class=\"btn btn-danger btn-sm\"])[1]")WebElement deleteRecord;
@FindBy(xpath="body[class=\"app sidebar-mini rtl\"]")WebElement scrollbar;
@FindBy(xpath="//div[@class=\"alert alert-success\"]")WebElement sucessMsg;
public void clickOnExpenses() {
	txtExpenses.click();
}
public void clickonListExpenses() {
	listExpenses.click();
}
public void enterFromDate() {
	fromDate.click();
	fromDate.sendKeys("05/06/2023");
}
public void enterToDate() {
	toDate.click();
	toDate.sendKeys("09/07/2023");
}
public void selectempDrpodown(String value) throws Exception {
	drp_selectEmp.click();
	Select s=new Select(drp_selectEmp);
	s.selectByValue(value);
	
}
public void clickonSearch() {
	btnSearch.click();
}
public void search() {
	Search.click();
}
public void delete () throws InterruptedException {
	deleteRecord.click();
	Alert alt=driver.switchTo().alert();
	//capturing alert message
	String alertMessage=driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	System.out.println(sucessMsg.getText());
}

//public void scrolling(WebElement element) 
public void scrolling(){
	//scrollbar.click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].scrollIntoView();",element);
	js.executeScript("window.scrollBy(0,4000)", " ");
	//js.executeScript("window.scrollBy(0,-4000)"," ");  //for down to up scrolling
	scrollbar.click();
}

}
