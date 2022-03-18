package pack123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.TaskPage;

public class Pac {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kshitij Gaikwad\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost/login.do");
	
	     LoginPage loginPage = new LoginPage(driver);
	   //  loginPage.sendUserName();
	   //  loginPage.sendPasswordName(pass);
	     loginPage.clickOnKeepMeLogin();
	     loginPage.clickOnLogin();
	     
	     ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
	     applicationHeaderPage.openTaskPage();
	     String url = driver.getCurrentUrl();
	     String title = driver.getTitle();
	     if ( url.equals("http://localhost/tasks/otasklist.do"))
	     {
	    	 System.out.println("Pass");
	     }
	     else
	     {
	    	 System.out.println("Fail");
	     }
	     
	     if ( title.equals("actiTIME - Open Tasks"))
	     {
	    	 System.out.println("Pass");
	     }
	     else
	     {
	    	 System.out.println("Fail");
	     }
	     applicationHeaderPage.openReportPage();
	     applicationHeaderPage.openUserPage();
	     applicationHeaderPage.openWorkSchedulePage();
	     
	     TaskPage taskPage = new TaskPage(driver);
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

}
