package Utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter extends BaseClass implements ITestListener {
	public ExtentReports extentReports;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext iTestContext) {
		DateTimeFormatter formatedDateTime=DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStamString=LocalDateTime.now().format(formatedDateTime);
		String reportName="./test-output/test-report/Test-Report_"+ timeStamString +".html";
		
	sparkReporter=new ExtentSparkReporter(reportName);
	 sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle(reportName);sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
		sparkReporter.config().setReportName("Pet Store Users API");
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("HostName", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user","Sandhya");
		
}
	public void onTestSuccess(ITestResult result) {
		logger=extentReports.createTest(result.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		log.info(result.getMethod().getMethodName()+"Testcase is passed");
		
		
}
	public void onTestFailure(ITestResult result) {
		DateTimeFormatter formatedDateTime=DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStamString=LocalDateTime.now().format(formatedDateTime);
		
		logger=extentReports.createTest(result.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		log.info(result.getMethod().getMethodName()+"TestCase failed");
		try {
			captureScreenshoot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenShotName=result.getMethod().getMethodName() +timeStamString +".png";
		String screenShotPath = "./Screenshots/" + screenShotName;
		log.info(result.getMethod().getMethodName()+" Testcase failed");
		try {
			captureScreenshoot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath,result.getName()).build());
		
	}
	public void onTestSkipped(ITestResult result) {
		logger=extentReports.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

		
			}
	public void onFinish(ITestContext context) {
		extentReports.flush();
			}



}
