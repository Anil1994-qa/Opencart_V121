package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AccountRegistraionPage extends BasePage {

	public AccountRegistraionPage(WebDriver driver) {
		super(driver);
		
	}
	//Locators 
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement firstName; 
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement lastName; 
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement email; 
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephone; 
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement password; 
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement confirmPassword; 
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBox;
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement continueCTA; 
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
//Action Methods
	public void setFirstName(String fname) //---here the parameter is taken from test case
	{
		firstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		this.email.sendKeys(email);
	}
	public void setTelephone(String teleph)
	{
		telephone.sendKeys(teleph);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void setConfirmPassword(String confirm_pwd)
	{
		confirmPassword.sendKeys(confirm_pwd);
	}
	public void setprivacypolicy()
	{
		checkBox.click();
	}
	public void clickContinue()
	{
		continueCTA.click();
	}
	public String getConfirmationmsg()
	{
		try 
		{
			return(confirmationmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
