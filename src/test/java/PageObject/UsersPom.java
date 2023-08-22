package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.BaseClass;

public class UsersPom {
	
WebDriver driver;
public UsersPom(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
//Users and Add user
@FindBy(xpath="//span[text()='Users']")WebElement users;
@FindBy(xpath="(//a[@class='treeview-item '])[5]")WebElement addusers;
@FindBy(xpath="//select[@name=\"role\"]")WebElement selectRole;
@FindBy(xpath="//input[@name=\"fullname\"]")WebElement txtfullName;
@FindBy(xpath="//input[@name=\"mobile\"]")WebElement txtmobileNumber;
@FindBy(xpath="//input[@name=\"password\"]")WebElement txtPassword;
@FindBy(xpath="//input[@name=\"landline\"]")WebElement txtlandline;
@FindBy(xpath="//input[@name=\"email\"]")WebElement txtemail;
@FindBy(xpath="//textarea[@name=\"address\"]")WebElement txtAddress;
@FindBy(xpath="//select[@name=\"gender\"]")WebElement drpGender;
@FindBy(xpath="//input[@name=\"adhar_no\"]")WebElement txtadharnum;
@FindBy(xpath="//input[@name=\"pan_no\"]")WebElement txtpannum;
@FindBy(xpath="//button[@type=\"submit\"]")WebElement submit;
@FindBy(xpath="//button[@type=\"reset\"]")WebElement clear;


public void clickOnUsers() {
	users.click();
}
public void clickOnAddUsers() {
	addusers.click();
}
public void setRole(String role) {
	selectRole.sendKeys(role);
}

public void enterfullname(String name) {
	txtfullName.sendKeys(name);
}
public void entermobilenum(String mobilenum) {
	txtmobileNumber.sendKeys(mobilenum);
}
public void enterpassword(String password) {
	txtPassword.sendKeys(password);
}
public void enterlandlinenumber(String landlinenum) {
	txtlandline.sendKeys(landlinenum);
}
public void enteremail(String email) {
	txtemail.sendKeys(email);
}
public void enteraddress(String address) {
	txtAddress.sendKeys(address);
}
public void selectGender(String Gender) throws Exception {
	Select s=new Select(drpGender);
	s.selectByValue(Gender);
	//s.selectByVisibleText(Gender);
	//BaseClass.custom_handleDropDown(drpGender, Gender);
	
	
}
public void enteradharNumber(String adharnum) {
	txtadharnum.sendKeys(adharnum);
	
}
public void enetrPANnum(String pannum) {
	txtpannum.sendKeys(pannum);
}
public void clickonSubmit() {
	submit.click();
	
}
public void clickonClear() {
	clear.click();
}
}
