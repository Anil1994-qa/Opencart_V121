package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
 public	LoginPage(WebDriver driver){
		super(driver);
	}
 //Locators
@FindBy(xpath="//input[@id='input-email']") 
WebElement email;
@FindBy(xpath="//input[@id='input-password']")
WebElement pwd;
@FindBy(xpath="//input[@value='Login']")
WebElement loginbtn;



//Action Methods
public void setEmail(String email)
{
	this.email.sendKeys(email);
}
public void setPassword(String pwd)
{
	 this.pwd.sendKeys(pwd);
}
 public void clickLogin()
 {
	 loginbtn.click();
 }

 
 
 
 
 
 
 
 
 
 
 
}
