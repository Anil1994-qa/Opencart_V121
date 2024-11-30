package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass_TC002 {

public WebDriver driver;
public Logger logger;  //log4j2
public Properties p;

@BeforeClass(groups={"Sanity", "Regression","Master"})	
@Parameters({"os","browser"})
public void Setup(String os,String br) throws InterruptedException, IOException {
	
	//Loading property file
	FileReader file= new FileReader("./src//test//resources//config.properties");
	p=new Properties();
	p.load(file);
	
	logger=LogManager.getLogger(this.getClass());
	
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//OS --this is coming from xml
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if (os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else if(os.equalsIgnoreCase("Linux"))
		{
			capabilities.setPlatform(Platform.LINUX);
		}
		else
		{
			System.out.println("No matching OS");
			return;
		}
		
	    //browser
	     switch(br.toLowerCase())
	     {
	     case "chrome": capabilities.setBrowserName("chrome"); break;
	     case "edge": capabilities.setBrowserName("Microsoftedge");break;
	     case "firefox": capabilities.setBrowserName("firefox");break;
	     default: System.out.println("No matching browser");
	     }
	      driver=new RemoteWebDriver(new URL(" http://192.168.1.4:4444/wd/hub"),capabilities);
	}
	
	     if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	     {
	    	 //This below code is run in local system
	    		switch(br.toLowerCase())
	    		{
	    		case "chrome":driver=new ChromeDriver();
	    		break;
	    		case "edge":driver=new EdgeDriver();
	    		break;
	    		case "firefox":driver=new FirefoxDriver();
	    		break;
	    		default :System.out.println("Invalid Browser");
	    		return;
	    		}
	       }
	       logger = LogManager.getLogger(this.getClass());
	       driver.get(p.getProperty("appURL"));
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	       driver.manage().window().maximize();
	       Thread.sleep(3000);
	      }
@AfterClass(groups={"Sanity", "Regression","Master"})	
public void teardown()
{
	driver.quit();
}
/*
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
*/
}
