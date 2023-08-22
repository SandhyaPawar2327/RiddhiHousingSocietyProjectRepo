package TestCases;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ExpensesPom;
import Utility.BaseClass;

public class ExpensesTestCases extends BaseClass {
Map<String,String>maptestMap;	
@DataProvider(name="testlink")
public Object[][]getData() throws Exception{
	String fileString="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\AddExpensesData.xlsx";
Object[][]obj=exlRead(fileString);
return obj;
		
}
public void loginPage() {
	LoginTC_01 logintc=new LoginTC_01();
	logintc.LoginDDT(userName, password);
	
}
@Test(dataProvider="testlink")
public void addExpensesTC_01(Map<String,String>maptestMap) throws Exception {
	ExpensesPom expense=new ExpensesPom(driver);
	loginPage();
	expense.clickOnExpenses();
	expense.clickonAddExpenses();
	expense.enterEmpName(maptestMap.get("ExpenseDoneBy"));
	expense.enterExpensesAmt(maptestMap.get("ExpenseAmt"));
	expense.selectExpensesType(maptestMap.get("ExpenseType"));
	expense.selectExpensesMode(maptestMap.get("ExpenseMode"));
	expense.Date(maptestMap.get("ExpenseDate"));
    expense.addExpensesNote(maptestMap.get("Note"));
	expense.clickonSubmit();
}

public void addExpensesTC_02(Map<String,String>maptestMap) throws Exception{
	ExpensesPom expense=new ExpensesPom(driver);
	loginPage();
	expense.clickOnExpenses();
	expense.clickonAddExpenses();
	expense.enterEmpName(maptestMap.get("ExpenseDoneBy"));
	expense.enterExpensesAmt(maptestMap.get("ExpenseAmt"));
	expense.selectExpensesType(maptestMap.get("ExpenseType"));
	expense.selectExpensesMode(maptestMap.get("ExpenseMode"));
	expense.Date(maptestMap.get("ExpenseDate"));
    expense.addExpensesNote(maptestMap.get("Note"));
	expense.clickonSubmit();
	expense.clickonClear();
}
}

	
