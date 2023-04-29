package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterationPage extends BasePage{
	
	public RegisterationPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(css="#input-email")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chckbox;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement registertxt;

	
	//Action Methods
	public void firstname(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	
	public void lastname(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void email(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void password(String pswrd)
	{
		passWord.sendKeys(pswrd);
	}
	
	public void chckbox()
	{
		//chckbox.click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", chckbox);
	}
	
	public void continueBtn()
	{
		//continuebtn.click();;
		
		JavascriptExecutor js2= (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", continuebtn);
		
		/*WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
		mywait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();*/
	}
	
	public String successText()
	{
		try {
		return (registertxt.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
