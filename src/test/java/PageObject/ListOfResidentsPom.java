package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfResidentsPom {

	WebDriver driver;
	public ListOfResidentsPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Users']")WebElement users;
	@FindBy(xpath="(//a[@class=\"treeview-item\"])[1]")WebElement listofResidents;
	@FindBy(xpath="//input[@type=\"search\"]")WebElement txtSearch;
	@FindBy(xpath="(//a[text()=\"View\"])[1]")WebElement clickview;
	@FindBy(xpath="(//a[@class=\"btn btn-danger btn-sm\"])[1]")WebElement clickDelete;
	@FindBy(xpath="//div[@class=\"alert alert-success\"]")WebElement successMsgPrint;
	
	
			

public void clickOnUsers() {
	users.click();
}
public void clickonListResidents() {
	listofResidents.click();
}
public void searchResidents(String search) {
	txtSearch.sendKeys(search);
	}
public void clickonView() {
	clickview.click();
}

public void clickonDelete() throws Exception {
	clickDelete.click();
	Alert alt=driver.switchTo().alert();
	//capturing alert message
	String alertMessage=driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
}
public void getSuccessMsg() {
	System.out.println(successMsgPrint.getText());
	
}
}