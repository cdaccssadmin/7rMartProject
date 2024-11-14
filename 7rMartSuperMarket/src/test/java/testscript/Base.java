package testscript;


	

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import constant.Constant;
import utilities.ScreenShotUtility;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;




	public class Base {
		public WebDriver driver; 
		public  ScreenShotUtility scrshot;
		public Properties properties; 
	 	public FileInputStream fis;
		@BeforeMethod(alwaysRun = true)
		@Parameters ("Browser") 
	 	public void initializeBrowser(String Browser) throws Exception 
	 	{ try { 
				properties = new Properties(); 
				fis = new FileInputStream(Constant.CONFIGFILE); 
				properties.load(fis); 

			} catch (FileNotFoundException exception) { 
				exception.printStackTrace(); 
			} 
			if (Browser.equalsIgnoreCase("chrome")) { 
				driver = new ChromeDriver(); 
			} else if (Browser.equalsIgnoreCase("edge")) { 
				driver = new EdgeDriver(); 
			} else if (Browser.equalsIgnoreCase("firefox")) { 
				driver = new FirefoxDriver(); 
			} else { 
				throw new Exception("invalid browser"); 
			}
			
	 	//driver=new EdgeDriver(); 
	 	//driver=new FirefoxDriver(); 
	 	driver.get(properties.getProperty("url")); 
	 	driver.manage().window().maximize(); 
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
	 	
	 	} 
		@AfterMethod
		public void browserQuit(ITestResult iTestResult) throws IOException { 
				if (iTestResult.getStatus() == ITestResult.FAILURE) { 
					scrshot = new ScreenShotUtility(); 
					scrshot.getScreenShot(driver, iTestResult.getName()); 
				} 

				driver.quit(); 
			}
	}


