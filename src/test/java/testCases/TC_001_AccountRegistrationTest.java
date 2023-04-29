package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Master","Regression"})
	void test_Account_Registration() throws InterruptedException
	{

		logger.info("***  Starting TC_001_AccountRegistrationTest  ***");
		logger.debug("<<<  Application logs  >>>");
		//try
			
			HomePage hp=new HomePage(driver);
			
			hp.myaccnt();
			logger.info("Clicked on My Account Link");
			hp.registerlink();
			logger.info("Clicked on registerlink Link");
			RegisterationPage rp=new RegisterationPage(driver);
			
			logger.info("Providing Customer Data");
			
			rp.firstname(randomString().toUpperCase());
			
			rp.lastname(randomString().toUpperCase());
			
			rp.email(randomString()+"@gmail.com");
			
			//rp.number(randomNumber());
			
			String pass=randomAlphaNumeric();
			
			rp.password(pass);
			
			//rp.confirmpassword(pass);
			
			
			rp.chckbox();
			//Thread.sleep(3000);
			rp.continueBtn();
			logger.info("Clicked on continue button");
			
			
			String message=rp.successText();
			
			logger.info("Clicked on My Account Link");
			
			logger.info("Validating Expected Message");
			
			Assert.assertEquals(message, "Your Account Has Been Created!","Test Failed");
		
			
	
			/*catch(Exception e)
			{
				logger.info("test Failed");
				Assert.fail();
			}*/
		
		logger.info("***  Finished TC_001_AccountRegistrationTest  ***");
		}
}
