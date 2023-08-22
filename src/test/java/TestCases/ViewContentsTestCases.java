package TestCases;

import org.testng.annotations.Test;

import PageObject.ViewContentsPom;
import Utility.BaseClass;

public class ViewContentsTestCases extends BaseClass{
	public static String fileuploadapath="C:\\Users\\vijay\\Documents\\num.txt";
	public static String addphotospath="C:\\Users\\vijay\\Desktop\\sandhya\\testing.jpg";    //file path for add photos 
	public static String addVideoslink="https://www.youtube.com/watch?v=gplxQ3mtmGY";        //youtube link for add video

	@Test
public void viewcontenTc01() throws Exception{
	
	
	ViewContentsPom vc=new ViewContentsPom(driver);
	vc.clickContent();
	vc.clickOnviewContent();
	vc.showdropdown("50");
    vc.clickonActions();
	vc.clickonView();
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	vc.clickonActions();
	vc.clickonEdit();
	driver.navigate().back();
	Thread.sleep(2000);
	vc.clickonActions();
	vc.clickonAddPhotos();
	vc.clickonchooseFile(addphotospath);
	vc.clickonUploadPhoto();
	vc.messagePrint();
	driver.navigate().back();
	//vc.messagePrint();
	
	vc.clickonActions();
    vc.clickonVideo();
    vc.enterLink(addVideoslink);
    Thread.sleep(2000);;
    vc.clikonSubmit();
	
}

	
	
}




