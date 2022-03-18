package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (xpath = "//input[@placeholder='Username']")
    private WebElement userName;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement keepMeLoginCheckbox;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement login;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
	}
	
	public void sendUserName(String user)
	{
		
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(user);
	}
	
	public void sendPasswordName(String pass)
	{
		
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void clickOnKeepMeLogin()
	{
		if( ! (keepMeLoginCheckbox.isSelected()))
		{
			keepMeLoginCheckbox.click();
		}
		else
		{
			System.out.println("Keep Me Login Checkbox Already Selected");
		}
	}	
		public void clickOnLogin()
		{
			login.click();
		}
		
}
