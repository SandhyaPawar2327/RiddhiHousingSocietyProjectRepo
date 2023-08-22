package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfTenantsPom {
	WebDriver driver;
	public ListOfTenantsPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
@FindBy(xpath="//span[text()='Users']")WebElement users;
@FindBy(xpath="(//a[@class=\"treeview-item\"])[3]")WebElement clickonListTenants;
@FindBy(xpath="(//a[@class=\"btn btn-info btn-sm\"])[1]")WebElement view;
@FindBy(xpath="(//a[@class=\"btn btn-danger btn-sm\"])[1]")WebElement delete;

public void clickonUsers()
{   users.click();
}
public void clickonListTenants() {
	clickonListTenants.click();
}
public void clickonView() {
view.click();
}
public void clickonDelete() throws Exception {
	delete.click();
	/* Alert alt=driver.switchTo().alert();
   	//capturing alert message
   	String alertMessage=driver.switchTo().alert().getText();
   	System.out.println(alertMessage);
   	Thread.sleep(3000);
   	driver.switchTo().alert().dismiss();*/
}
}
