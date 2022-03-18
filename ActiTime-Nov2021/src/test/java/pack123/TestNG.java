package pack123;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.TaskPage;
import utility.Utility;

public class TestNG extends Browser {
	
	 private WebDriver driver;
	 private ApplicationHeaderPage applicationHeaderPage;
	 private LoginPage loginPage;
	 private TaskPage taskPage;
	 String testID;  //for screenshot
	 static ExtentTest test;
	 static ExtentHtmlReporter reporter;
	 
    @BeforeTest
    @Parameters("browser")
    public void launchBrowser(String browserName)
	{
    	reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Launch Browser");
		if(browserName.equals("Chrome"))
		{
		driver = launchChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
		driver = launchEdgeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
		driver = launchFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void objectOfAllPOMClasses()
	{
		 loginPage = new LoginPage(driver);
		 applicationHeaderPage = new ApplicationHeaderPage(driver);
		 taskPage = new TaskPage(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws IOException 
	{
		System.out.println("Login To Application");
		driver.get("http://localhost/login.do");
		 String user  = Utility.getDataFromExcelSheet("Sheet1", 0, 1);
		 String password  = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
	     loginPage.sendUserName(user);
	     loginPage.sendPasswordName(password);
	     loginPage.clickOnKeepMeLogin();
	     loginPage.clickOnLogin();
	
	}
	
	@Test(priority = 0)
	public void verifyOpenTaskPage()
	{
		testID = "101";
		System.out.println("verify Open Task Page");
	     applicationHeaderPage.openTaskPage();
	     String url = driver.getCurrentUrl();
	     String title = driver.getTitle();

	     SoftAssert soft = new SoftAssert();
	     soft.assertEquals(url,"http://localhost/tasks/otasklist.do");
		 soft.assertEquals(title, "actiTIME - Open Tasks");	
		    
	     
	}
	
	@Test(priority = 1)
	public void verifyOpenReportPage()
	{
		testID = "102";
		System.out.println("verify Open Report Page");
	     applicationHeaderPage.openReportPage();
	     String url = driver.getCurrentUrl();
	     String title = driver.getTitle();
	     
	     SoftAssert soft = new SoftAssert();
	     soft.assertEquals(url, "http://localhost/reports/reports.do");
	     soft.assertEquals(title, "actiTIME - Saved Reports");
	    
	}
	
	@Test(priority = 2)
	public void verifyOpenUserPage()
	{
		testID = "103";
		System.out.println("verify Open User Page");
	     applicationHeaderPage.openUserPage();
	     String url = driver.getCurrentUrl();
	     String title = driver.getTitle();
	     SoftAssert soft = new SoftAssert();
	     soft.assertEquals(url, "http://localhost/administration/userlist.do");
	     soft.assertEquals(title, "actiTIME - User List");
	    
	}
	
	@Test(priority = 3)
	public void verifyWorkSchedulePage()
	{
		testID = "104";
		System.out.println("verify Work Schedule Page");
	     applicationHeaderPage.openWorkSchedulePage();
	     String url = driver.getCurrentUrl();
	     String title = driver.getTitle();
	     SoftAssert soft = new SoftAssert();
	     soft.assertEquals(url, "http://localhost/administration/workingdays.do");
	     soft.assertEquals(title, "actiTIME - Corporate Schedule");
	     
	}
	
	@Test(priority = 4)
	public void verifyTasks() 
	{
		testID = "105";
		System.out.println("verify Tasks On Task Page");
	
	     taskPage.openTaskPage();
	     taskPage.clickOnCreateTask();
	     taskPage.clickOnSelectCustomer();
	     taskPage.clickOnNewCustomer();
	     taskPage.EnterCustomerName();
	     taskPage.enterTheProjectName();
	     taskPage.enterTheTaskName1();
	     taskPage.enterTheTaskName2();
	     taskPage.enterTheTaskName3();
	     taskPage.clickOnTheCheckbox1();
	     taskPage.clickOnTheCheckbox2();
	     taskPage.clickOnTheCheckbox3();
	     taskPage.clickOnTheCreateTasks();
	  
	}
	
	@AfterMethod
	public void clickOnTheLogOutTab(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())  //for only Failed Result
		{
		  Utility.screenshot(driver, testID);
		}
		Thread.sleep(3000);
		System.out.println("logOut");
		 applicationHeaderPage.clickOnLogOutTab();
	}
	
	@AfterClass
	public void clearObjectOfPOMClasses()
	{
		loginPage = null;
		applicationHeaderPage = null;
		taskPage = null;
	}
	
	@AfterTest
	public void closedBrowser()
	{
		System.out.println("closed Browser");
		driver.quit();
		driver = null;
		
		System.gc();  //Delete all object without references
	}
	
	

}
