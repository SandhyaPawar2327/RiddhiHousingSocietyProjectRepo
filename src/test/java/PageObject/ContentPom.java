package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.BaseClass;

public class ContentPom {
	WebDriver driver;
	    public ContentPom(WebDriver driver) 
	    {
		   this.driver=driver;
           PageFactory.initElements(driver, this);
	    }
@FindBy(how=How.XPATH,using="(//span[@class='app-menu__label'])[3]") WebElement contentClick;
@FindBy(how=How.XPATH,using="//a[@href='add-content.php']")WebElement addContentClick;
@FindBy(xpath="//select[@id=\"select\"]")WebElement selectContentDrp;
@FindBy(xpath="//input[@name=\"contenttitle\"]")WebElement txtcontenttitle;
@FindBy(xpath="//input[@name=\"price\"]")WebElement txtcontentprice;
@FindBy(xpath="//input[@name=\"sequence\"]")WebElement txtcontentsequence;
@FindBy(xpath="//input[@name=\"alt_tag\"]")WebElement setTag;
@FindBy(xpath="//textarea[@name=\"contentdesc\"]")WebElement txtcontentdescrip;
@FindBy(xpath="//input[@name=\"content_date\"]")WebElement date;
@FindBy(xpath="//input[@name=\"content_location\"]")WebElement txtcontentlocation;
@FindBy(xpath="//input[@name=\"link\"]")WebElement txtlink;
@FindBy(xpath="//input[@name=\"image_filename\"]")WebElement setImageFile;
@FindBy(xpath="//button[@name=\"submit\"]")WebElement btnsubmit;
@FindBy(xpath="//div[@class=\"alert alert-success\"]")WebElement getsucessMsg;


            public void clickContent() 
            {
	            contentClick.click();
            }

            public void clickAddContent() 
            {
	             addContentClick.click();
            }
            public void contentDropdown(String value) throws Exception  {
                   Select s=new Select(selectContentDrp);
                   s.selectByValue(value);
            }
            public void entercontenttittle(String contenttittle) {
            	txtcontenttitle.sendKeys(contenttittle);
            }
            public void enterconttentprice(String price) {
            	txtcontentprice.sendKeys(price);
            }
            public void entercontentseqence(String sequence) {
            	txtcontentsequence.sendKeys(sequence);
            }
            public void entercontentdescription(String description) {
            	txtcontentdescrip.sendKeys(description);	
            }
            public void enterDate(String contentDate ) {
            	
            	date.sendKeys(contentDate);
            }
            public void entercontentlocation(String location) {
            	txtcontentlocation.sendKeys(location);
            }
            public void enterlink(String link) {
            	txtlink.sendKeys(link);
            }
           
            public void setContentImage(String path) {
            	setImageFile.sendKeys(path);
            }
            public void setContentTag(String tag) {
            	setTag.sendKeys(tag);
            }
            public void clicksubmit(){
            	btnsubmit.click();	
            }
            public void printSuccessMsg() {
            	getsucessMsg.getText();
            	
            }

            }
