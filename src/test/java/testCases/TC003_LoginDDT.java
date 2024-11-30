package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="datadriven group")//Getting data provider from the different class
void verifyLoginDDT(String email, String pwd, String result)
{

	logger.info("***LoginDDT Test Strated***");
	try
	{
		
		
		    //Home page
		 	HomePage hp=new HomePage(driver);
		 	hp.ClickMyAccount();
            hp.Clicklogin();
		 	
	        //Login page--PO class
	        LoginPage log=new LoginPage(driver);
	        log.setEmail(email);
	        log.setPassword(pwd);
	        log.clickLogin();
	        
	        
	MyAccountPage myacc= new MyAccountPage(driver);//This driver came from base class
	      boolean targetpage= myacc.isMyAccountExists();
	             myacc.clickLogOut();
     
      
       /* 
       Data is Valid --Login success--Test pass--logout
                       Login success--Test fail
       * 
       Data is Invalid --Login success--Test fail--logout
                         Login failed--Test pass
       */
       if(result.equalsIgnoreCase("Valid"))
       {
    	    if(targetpage==true)
    	    {
    	    	myacc.clickLogOut();
    	    	Assert.assertTrue(true); 	
    	    }
    	    else
    	    {
    	    	Assert.assertTrue(false);
    	    }
    	    if(result.equalsIgnoreCase("Invalid")) 
    	    {
    	    	myacc.clickLogOut();
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
	      logger.info("***LoginDDT Test Finished***");
	      
}

	
}
