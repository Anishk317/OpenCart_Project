package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;							//Logging
import org.apache.logging.log4j.Logger;								//Logging

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;											//Logging
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters(value="browser")
	public void setup(String br)
	{	
		rb=ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass());				//logging
		
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(rb.getString("appURL"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String genString =RandomStringUtils.randomAlphabetic(5);
		return genString;
	}
	

	public String randomNumber()
	{
		String genString2 =RandomStringUtils.randomNumeric(10);
		return genString2;
	}
	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(3);
		String num =RandomStringUtils.randomNumeric(3);
		return(st+"@"+num);
	}

	public String captureScreen(String tname) 
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_"+ timestamp + ".png";	
		
		try 
		{
			FileUtils.copyFile(source, new File(destination));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return destination;
				
	}
}
