package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
/*	 @DataProvider(name= "credentials") 
	   public Object[][] testData(){ 
	 	  Object[][] input= new Object[2][2]; 
	 	  input[0][0] = "admin"; 
	 	  input[0][1] ="admin"; 
	 	  input[1][0] ="admin1234000"; 
	 	  input[1][1]="admin"; 
	 	return input; 
	 	 
	 	  
	  } 
	   @Test(dataProvider ="credentials" ) */
	@Test
	   public void verifyUserIsAbletoLoginValidCredentials(/*String username, String password*/) throws IOException { 
	 	   
	 	String username= ExcelUtilities.readStringData(1, 0, "loginpage"); 
	 	String password = ExcelUtilities.readStringData(1, 1,"loginpage"); 
	 	LoginPage loginpage = new LoginPage(driver); 
	 	loginpage.enterUserNamefield(username); 
	 	loginpage.enterPasswordfield(password); 
	 	loginpage.clickOnsigninbutton(); 
	 	boolean  ishomepageloaded = loginpage.isdashboarddisplayed(); 
	 	Assert.assertTrue(ishomepageloaded,Constant.ERRORMESSAGEFORLOGINPAGE); 
	 	 
	   }
}
