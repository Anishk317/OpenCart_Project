package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage 
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAcctxt;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutlnk;
	
	//Action Methods
	public boolean MyAcctxt()
	{	
		try 
		{
			boolean status=myAcctxt.isDisplayed();
			return status;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogout()
	{
		logoutlnk.click();
	}
}
