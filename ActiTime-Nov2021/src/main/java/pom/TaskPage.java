package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TaskPage {
	
	@FindBy (xpath = "//div[text()='Tasks']")
	private WebElement task;
	
	@FindBy (xpath = "//div[@class='i']")
    private WebElement createTask;
	
	@FindBy (xpath = "//button[text()='- Select Customer -']")
	private WebElement selectCustomer;
	
	@FindBy (xpath = "//a[text()='- New Customer -']")
	private WebElement selectNewCustomer;
	
	 @FindBy (xpath ="//input[@placeholder='Enter Customer Name']")
	  private WebElement enterCustomerName;
	
	@FindBy (xpath = "//input[@placeholder='Enter Project Name']")
	private WebElement enterProjectName;
	
	@FindBy (xpath = "(//input[@placeholder='Enter task name'])[1]")
	private WebElement enterTaskName1;
	
	@FindBy (xpath = "(//input[@placeholder='Enter task name'])[2]")
	private WebElement enterTaskName2;
	
	@FindBy (xpath = "(//input[@placeholder='Enter task name'])[3]")
	private WebElement enterTaskName3;
	
	@FindBy (xpath = "(//input[@type='checkbox'])[6]")
	private WebElement clickOnCheckbox1;
	
	@FindBy (xpath = "(//input[@type='checkbox'])[7]")
	private WebElement clickOnCheckbox2;
	
	@FindBy (xpath = "(//input[@type='checkbox'])[8]")
	private WebElement clickOnCheckbox3;
	
	@FindBy (xpath = "//span[@class='buttonTitle']")
	private WebElement createTasks;
	
	// @FindBy (xpath ="//a[text()='Logout']")
	//  private WebElement logout;
	
//	@FindBy (xpath = "//div[text()='Cancel']")
//	private WebElement clickCancel;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
	}
	
	public void openTaskPage()
	{
		task.click();
	}
	
	public void clickOnCreateTask()
	{
		wait.until(ExpectedConditions.visibilityOf(createTask));
		createTask.click();
	}
	
	public void clickOnSelectCustomer()
	{
		wait.until(ExpectedConditions.visibilityOf(selectCustomer));
		selectCustomer.click();
	}
	
	public void clickOnNewCustomer()
	{
		wait.until(ExpectedConditions.visibilityOf(selectNewCustomer));
		selectNewCustomer.click();
	}
	
	 public void EnterCustomerName() 
	 {
  	   enterCustomerName.sendKeys("Arjun1234567");
	 }
	
	public void enterTheProjectName()
	{
		wait.until(ExpectedConditions.visibilityOf(enterProjectName));
		enterProjectName.sendKeys("ActiTime 2022");
	}
	
	public void enterTheTaskName1()
	{
		wait.until(ExpectedConditions.visibilityOf(enterTaskName1));
		enterTaskName1.sendKeys("Jan");
	}
	
	public void enterTheTaskName2()
	{
		wait.until(ExpectedConditions.visibilityOf(enterTaskName2));
		enterTaskName2.sendKeys("Feb");
	}
	
	public void enterTheTaskName3()
	{
		wait.until(ExpectedConditions.visibilityOf(enterTaskName3));
		enterTaskName3.sendKeys("Mar");
	}
	
	public void clickOnTheCheckbox1()
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCheckbox1));
		clickOnCheckbox1.click();
	}
	
	public void clickOnTheCheckbox2()
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCheckbox2));
		clickOnCheckbox2.click();
	}
	
	
	public void clickOnTheCheckbox3()
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCheckbox3));
		clickOnCheckbox3.click();
	}	
	
	public void clickOnTheCreateTasks()
	{
		wait.until(ExpectedConditions.visibilityOf(createTasks));
		createTasks.click();
	}
	
	//public void clicklogOut()
	//{
	//	wait.until(ExpectedConditions.visibilityOf(logout));
	//	logout.click();
	//}
	
	
}
