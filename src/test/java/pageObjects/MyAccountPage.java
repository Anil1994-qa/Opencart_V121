package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass_TC002;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//h2[normalize-space()='My Account']") 
WebElement msgHeading;

@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement lnkLogout;



public boolean isMyAccountExists() //return type is true or false we are not doing any validation here
{
	try
	{
	return msgHeading.isDisplayed();  //If my displayed it will return true else false that is the reason we captured on try catch blog
	
	}
	catch(Exception e)
	{
      return false;
	}
}
	
public void clickLogOut()
	{
		lnkLogout.click();
	}
}
