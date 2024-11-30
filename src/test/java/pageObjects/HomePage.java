package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
		
@FindBy(xpath="//span[normalize-space()=\"My Account\"]") 
WebElement InkMyAccount;
@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement InkRegister;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement lnklogin;  //login btn


public void ClickMyAccount()
{
	InkMyAccount.click(); 
}
public void ClickRegister()
{
	InkRegister.click();
}
public void Clicklogin()
{
	lnklogin.click();
}
}
