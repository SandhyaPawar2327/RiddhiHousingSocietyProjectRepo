package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.BaseClass;

public class SectionPom{
	WebDriver driver;
	

@FindBy(how=How.XPATH,using="(//span[@class=\"app-menu__label\"])[2]")WebElement btnSection;       
@FindBy(how=How.XPATH,using="//input[@name='sectionname']") WebElement enterSecName;
@FindBy(how=How.XPATH,using="//button[@name='submit']") WebElement btnSubmit;
@FindBy(xpath="//select[@name=\'sampleTable_length\']")WebElement drp_section;
@FindBy(xpath="//input[@type=\"search\"]")WebElement Search;
@FindBy(xpath="//div[@class=\"alert alert-danger\"]") WebElement alertMsg;

public SectionPom(WebDriver driver) 
{  this.driver=driver;
    PageFactory.initElements(driver, this);
}


public void clickOnSection() throws Exception  {
	 btnSection.click();
	 Thread.sleep(1000);
}

public void sectionName(String sectionName) {
	 enterSecName.sendKeys(sectionName);
}
public void clickOnSubmit() throws Exception {
	 btnSubmit.click();
	 Thread.sleep(1000);
}

public void drp_show( String value)
{   Select s=new Select(drp_section);
      s.selectByValue(value);
}
public void search(String value) {
	Search.sendKeys(value);
}
public void printAlertMsg() {
	alertMsg.getText();
}
}





