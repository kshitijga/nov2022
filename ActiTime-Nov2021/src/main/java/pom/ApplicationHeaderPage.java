package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ApplicationHeaderPage {
	
	@FindBy (xpath = "//div[text()='Time-Track']")
    private WebElement timeTrack;
	
	@FindBy (xpath = "//div[text()='Tasks']")
	private WebElement task;
	
	@FindBy (xpath = "//div[text()='Users']")
	private WebElement users;
	
	@FindBy (xpath = "//div[text()='Reports']")
	private WebElement reports;
	
	@FindBy (xpath = "//div[text()='Work Schedule']")
	private WebElement workSchedule;

	@FindBy (xpath = "//a[@id='logoutLink']")
	private WebElement logOut;
	
	private WebDriver driver;  //to make driver global in wait method
	
	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openTimeTrackPage()
	{
		
		timeTrack.click();
	}
	
	public void openTaskPage()
	{
		task.click();
	}
	
	public void openUserPage()
	{
		users.click();
	}
	
	public void openReportPage()
	{
		reports.click();
	}
	
	public void openWorkSchedulePage()
	{
		workSchedule.click();
	}
	
	public void clickOnLogOutTab()
	{
		logOut.click();
	}
	
}
