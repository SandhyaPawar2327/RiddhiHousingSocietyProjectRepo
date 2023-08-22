package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.BaseClass;


public class ExpensesPom {
	WebDriver driver;
	public ExpensesPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}		
@FindBy(xpath="(//span[@class=\"app-menu__label\"])[6]")WebElement txtExpenses;
@FindBy(xpath="(//a[@class=\"treeview-item \"])[6]")WebElement txtAddExpenses;
@FindBy(xpath="//input[@name=\"employee_name\"]")WebElement txtempName;
@FindBy(xpath="//input[@name=\"expense_amount\"]")WebElement txtexpensesAmount;
@FindBy(xpath="(//select[@name=\"expense_mode\"])[1]")WebElement drpExpensesType;
@FindBy(xpath="(//select[@name=\"expense_mode\"])[2]")WebElement drpExpensesMode;
@FindBy(xpath="//textarea[@name=\"expense_note\"]")WebElement expensesNote;
@FindBy(xpath="//input[@name=\"expense_date\"]")WebElement expenseDate;
@FindBy(xpath="//button[@name='submit']")WebElement submit;
@FindBy(xpath="//button[@type=\"reset\"]")WebElement clear;


public void clickOnExpenses() {
	txtExpenses.click();
}
public void clickonAddExpenses() {
	txtAddExpenses.click();
}
public void enterEmpName(String empName) {
	txtempName.sendKeys(empName);
}
public void enterExpensesAmt(String expensesamount ) {
	
	txtexpensesAmount.sendKeys(expensesamount);
	
}
public void selectExpensesType(String value) throws Exception {
	Select s=new Select(drpExpensesType);
	s.selectByValue(value);
	//BaseClass.custom_handleDropDown(drpExpensesType,value);
}
public void selectExpensesMode(String value) throws Exception {
	Select s=new Select(drpExpensesMode);
	s.selectByValue(value);
	//BaseClass.custom_handleDropDown(drpExpensesMode, value);
}
public void addExpensesNote(String note) {
	expensesNote.sendKeys(note);
	
}
public void Date(String date) {
	expenseDate.sendKeys(date);
	
}
public void clickonSubmit() {
	submit.click();
}
public void clickonClear() {
clear.clear();
}
}