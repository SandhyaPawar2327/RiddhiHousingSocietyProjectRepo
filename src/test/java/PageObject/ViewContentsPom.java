package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class ViewContentsPom {
WebDriver driver;
	public ViewContentsPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}

@FindBy(xpath="(//span[@class='app-menu__label'])[3]") WebElement contentClick;
@FindBy(xpath="//a[@href=\"listcontents.php\"]")WebElement clickViewContent;
@FindBy(xpath="//select[@name=\"sampleTable_length\"]")WebElement drp_viewContent;
@FindBy(xpath="(//button[@id=\"dropdownMenuButton\"])[1]")WebElement btn_Actions;
@FindBy(xpath="(//a[@title=\"View Content\"])[1]")WebElement btnView;
@FindBy(xpath="(//a[@title=\"Edit Content\"])[1]")WebElement btnEdit;
@FindBy(xpath="(//a[@title=\"Add Photos\"])[1]")WebElement btnAddPhotos;
@FindBy(xpath="//input[@type=\"file\"]")WebElement labelchoosefile;
@FindBy(xpath="//button[@type=\"submit\"]")WebElement btnUploadphoto;
@FindBy(xpath="//div[@class=\"alert alert-success\"]")WebElement photouploadsuccessMsg;
@FindBy(xpath="(//a[@title=\"Add Videos\"])[9]")WebElement btnAddVideos;
@FindBy(xpath="//input[@name=\"link\"]")WebElement enterLink;
@FindBy(xpath="//button[@type=\"submit\"]")WebElement btnSubmit;
@FindBy(xpath="(//a[@title=\"Delete Record\"])[1]")WebElement btnDelete;




public void clickContent() 
{
    contentClick.click();
}

public void clickOnviewContent() {
	clickViewContent.click();
}
public void showdropdown(String value) throws Exception {
	BaseClass.custom_handleDropDown(drp_viewContent,value);
}
public void clickonActions() {
	btn_Actions.click();
}
public void clickonView() {
	btnView.click();
}
public void clickonEdit() {
	btnEdit.click();
}
public void clickonAddPhotos() {
	btnAddPhotos.click();
}
public void clickonchooseFile(String addphotospath) {
	labelchoosefile.sendKeys(addphotospath);	
}
public void messagePrint() {
	System.out.println(photouploadsuccessMsg.getText());
}
public void clickonUploadPhoto() {
	btnUploadphoto.click();

}
public void clickonVideo() {
	btnAddVideos.click();
}
public void enterLink(String addVideoslink) {
	enterLink.sendKeys(addVideoslink);
}
public void clikonSubmit() {
	btnSubmit.click();
}
public void clickonDelete() {
	btnDelete.click();
}
}
