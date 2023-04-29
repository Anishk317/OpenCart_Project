package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myacc;
	
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginlnk;
	
	
	//Action Methods
	public void myaccnt()
	{
		myacc.click();
	}
	
	public void registerlink()
	{
		register.click();
	}
	
	public void clicklogin()
	{
		loginlnk.click();
	}
}
