package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import config.Configuration;

public class HomeLoginPage {
	
	WebDriver driver;
	public HomeLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath=Configuration.username)
	WebElement userId;
	@FindBy(xpath=Configuration.password)
	WebElement password;
	@FindBy(how = How.XPATH, using = Configuration.signin)
	WebElement signIn;
	
	public void doLogin(String user, String pass)
	{
		userId.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
	}

}
