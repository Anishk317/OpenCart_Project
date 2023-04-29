package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement paswrd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	
	//Action Methods
	public void setEmail(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void setpaswrd(String passwrd)
	{
		paswrd.sendKeys(passwrd);;
	}
	
	public void clicklogin()
	{
		loginBtn.click();
	}
	
}
