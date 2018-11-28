package library;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserInitialization {

	public static WebDriver driver=null;
	
	
	/**********************************************
	 * This method will Open the specified browser
	 * 
	 * ********************************************/
	public static void intilaize(){
		
		try {
			String browser=BackendCommonFunctionality.getProperty("Browser");
			switch(browser){
			case "Chrome":{
				String driverpath=BackendCommonFunctionality.getProperty("DriverPath");
				System.setProperty("webdriver.chrome.driver", driverpath+"/chromedriver.exe");
				System.out.println("<----------Opening Chrome Browser------------->");
				driver=new ChromeDriver();
				openApplication();
			break;
			}
			
			case "IE":
			{
			String driverpath=BackendCommonFunctionality.getProperty("DriverParth");
			System.setProperty("webdriver.ie.driver", driverpath+"/IEDriverServer.exe");
			System.out.println("<---------------Opening IE Browser---------------->");
			driver=new InternetExplorerDriver();
			openApplication();
			break;
			}
			
			case "FireFox": {
				String driverPath = BackendCommonFunctionality.getProperty("DriverPath");
				System.setProperty("webdriver.firefox.marionette", driverPath + "FirefoxDriverServer.exe");
				System.out.println("<------------------Opening FireFox Browser-------->");
				driver = new FirefoxDriver();
				openApplication();
				break;

			}
			default:
				System.out.println("Please select the valid Browser");
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will open the Specified URL and Maximizes the Browser
	 * */
		public static void openApplication(){
			try{
			driver.manage().window().maximize();
			String URl=BackendCommonFunctionality.getProperty("URL");
			driver.navigate().to(URl);
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

