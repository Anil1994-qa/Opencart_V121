package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistraionPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{	
@Test(groups={"Regression","Master"})
void verify_account_registration()
{
	
	logger.info("****** Starting TC001_AccountRegistrationTest *****");
	
	try
	{
	HomePage hp=new HomePage(driver); //Create PO class object to invoke POM methods
	hp.ClickMyAccount();
	logger.info("Clicked on My Account Link");
    hp.ClickRegister();
	logger.info("Clicked on My Register Link");
	
	
    AccountRegistraionPage regpage=new AccountRegistraionPage(driver);
    
	logger.info("Providing customer details..");
    regpage.setFirstName(randomString().toUpperCase());
    regpage.setLastName(randomString().toUpperCase());
    regpage.setEmail(randomString()+"@gmail.com");  //Randomly generated the email
    regpage.setTelephone(randomNum());
    
    String password=randomAlphaNum();// Created this variable to store the same value which is passed in the set password bcz randomAlphaNum() method will dynamically changing the values
    
    regpage.setPassword(password);
    regpage.setConfirmPassword(password);
    
    regpage.setprivacypolicy();
    regpage.clickContinue();

   //Validation Part
	logger.info("Validating expected message..");
  String confirmationmsg= regpage.getConfirmationmsg(); //This method will return in a String format so we need to store it in String variable
  Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		logger.error("Test failed..");
		//logger.debug("Debug logs.."); // this will capture debug level logs if test is got failed
		Assert.fail();
	}
	logger.info("****** Finished TC001_AccountRegistrationTest *****");
	
  }
}
