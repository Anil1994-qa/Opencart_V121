package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager; //log4j import
import org.apache.logging.log4j.Logger;     //log4j import

public class BaseClass {
public static WebDriver driver;
public Logger logger;	 //Log4j

	 @BeforeClass (groups={"Sanity", "Regression","Master"})
	 void Setup()
	 {
		logger = LogManager.getLogger(this.getClass()); //what ever test case we are running that class name it should take Dynamically so we used this keyword(this is always representing the class) 
		 	
	 	 driver=new EdgeDriver();
	 	 driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://tutorialsninja.com/demo/");
	     driver.manage().window().maximize();
	 }
	 @AfterClass(groups={"Sanity", "Regression","Master"})	
	 void tearDown()
	 {
	 	driver.quit();
	 }
	 public String randomString()  //created method to generate random Strings
	 {
	 	 String genratedString= RandomStringUtils.randomAlphabetic(5);
	 	 return genratedString;
	 }
	 public String randomNum()//created method to generate random Numbers
	 {
	 	 String genratedNum= RandomStringUtils.randomNumeric(10);
	 	 return genratedNum;
	 }
	 public String randomAlphaNum()//created method to generate random Alpha numeric methods
	 {
	 	 String genratedString= RandomStringUtils.randomAlphabetic(3);
	 	 String genratedNum= RandomStringUtils.randomAlphabetic(3);
	 	 return genratedNum+"@"+genratedString;
	 }
	 
	 public String captureScreen(String tname) throws IOException
	 {
		 String timestamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		 
		 TakesScreenshot takesScreenShot=(TakesScreenshot) driver;
		 File sourceFile= takesScreenShot.getScreenshotAs(OutputType.FILE);
		 
		 String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp;
		 File targetFile=new File(targetFilePath);
		 
		 sourceFile.renameTo(targetFile);
		 
		 return targetFilePath;
	 }
}
