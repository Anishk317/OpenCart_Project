package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	
	@Test(groups= {"Master","Sanity"})
	public void test_Login()
	{	logger.info("*** TC_002_LoginTest Start ***");
		try {
		HomePage hp=new HomePage(driver);
		hp.myaccnt();
		hp.clicklogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setpaswrd(rb.getString("pass"));
		lp.clicklogin();
	
		MyAccountPage myacc=new MyAccountPage(driver);
		
		boolean status=myacc.MyAcctxt();
		
		Assert.assertEquals(status, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** TC_002_LoginTest finished ***");
		
	}
	
}
