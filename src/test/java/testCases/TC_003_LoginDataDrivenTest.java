package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email,String pwd,String exp)
	
	{	
		logger.info("*** TC_002_LoginTest Start ***");
		try {
		HomePage hp=new HomePage(driver);
		hp.myaccnt();
		hp.clicklogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setpaswrd(pwd);
		lp.clicklogin();
	
		MyAccountPage myacc=new MyAccountPage(driver);
		
		boolean targetPage=myacc.MyAcctxt();
		
		if(exp.equals("Valid"))
		{
			if(targetPage==true)
			{
				myacc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		if(exp.equals("Invalid"))
		{
			if(targetPage==true)
		
			{
				myacc.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** TC_002_LoginTest finished ***");
		
	
		
	}
	
}
