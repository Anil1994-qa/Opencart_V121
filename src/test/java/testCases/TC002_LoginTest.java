package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass_TC002;

public class TC002_LoginTest extends BaseClass_TC002 {  //This test will run only on xml file 
  @Test(groups={"Sanity", "Master"})
	void verifyLogin()
	{
	     logger.info("**Test Started**");
	     try
	     {
	    //Home Page --PO Class
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
        hp.Clicklogin();
        
         //Login page--PO class
	     LoginPage log=new LoginPage(driver);
	     log.setEmail(p.getProperty("email")); // in base class we already created and loaded the property file
	     log.setPassword(p.getProperty("password"));
	     log.clickLogin();
	     
	     //MyAccount Page 
	     MyAccountPage macc=new MyAccountPage(driver);
	     boolean targetpage=macc.isMyAccountExists();
	     
	     //Assert.assertEquals(targetpage, true, "Login Fail");
	     Assert.assertTrue(targetpage);
	     logger.info("**Test Finished**");
	     }
	     catch(Exception e)
	     {
	    	 Assert.fail();
	     }
	  }

	}

