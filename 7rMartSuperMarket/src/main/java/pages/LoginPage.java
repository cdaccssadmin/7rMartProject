package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver; 
	 
 	public  LoginPage(WebDriver driver) { 
 		 
 		this.driver = driver; 
 		PageFactory.initElements(driver,this); 
 		 
 		 
 	} 
 	@FindBy(xpath ="//input[@type='text']") WebElement username; 
 	@FindBy(xpath = "//input[@type='password']") WebElement password; 
 	@FindBy(xpath= "//button[@class='btn btn-dark btn-block']") WebElement signIn; 
 	@FindBy(xpath ="//p[text()='Dashboard']") WebElement dashboard; 
 	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement errormessagedisplayed; 
 	 
 	public void enterUserNamefield(String usernamefield) 
 	{ 
 		username.sendKeys(usernamefield); 
 	 
 	} 
 	 
 	public void enterPasswordfield(String passwordfield) 
 	{ 
 		password.sendKeys(passwordfield); 
 	} 
 	 
 	public void clickOnsigninbutton() { 
 		 
 		signIn.click(); 
 	} 
 	 
 	public boolean isdashboarddisplayed() { 
 		 
 		return dashboard.isDisplayed(); 
 	} 
 	 
 	public boolean getInvalidConfirmation() { 
 		 
 		return errormessagedisplayed.isDisplayed(); 
 	}
}
