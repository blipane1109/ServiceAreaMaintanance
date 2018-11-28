package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import library.*;
import org.apache.log4j.Logger;
public class US_Demo {
	Logger logger = Logger.getLogger(US_Demo.class);
	static String testCaseDesc = null;
	static String passTestCaseDesc = null;
	static String failTestCaseDesc = null;
	static String screenShotName = null;
	static String screenshotPath = null;
	
	
	
	@Test(priority=1)
	public void tc_01() throws Exception{
		String testCaseName="TC_01";
		
		//this is test case 1
		int temp= 0;
		logger.info("Executing the Test Case No. " + testCaseName);
		JavascriptExecutor js=(JavascriptExecutor) BrowserInitialization.driver;
		try {
			boolean isRunnableTest=BackendCommonFunctionality.checkRunStatus(testCaseName);
			if(isRunnableTest){	
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName=BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_"+testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName()+"_"+testCaseName, testCaseDesc);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countries).click();
				Thread.sleep(3000);;
				BrowserInitialization.driver.findElement(ObjectRepository.by_countrysearch).sendKeys(DataObject.getVariable("CountryName", testCaseName));
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countriesList).click();
				Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_Country_Service_SearchBar).sendKeys(DataObject.getVariable("ServiceName",testCaseName));
				Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,750)");
				BrowserInitialization.driver.findElement(ObjectRepository.by_servicesList).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_MoreInfotoggle).click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,1000)");
				String AcessTime="//div[text()='Access Time']/..//span[2]";
				int ok =BrowserInitialization.driver.findElements(By.xpath(AcessTime)).size();
				ArrayList<String> Acess= new ArrayList<String>();
			    for(int i=1;i<=ok;i++)
			    {
			    	String test=BrowserInitialization.driver.findElement(By.xpath("("+AcessTime+")["+i+"]")).getText();
			    	Acess.add(test);
			    }
				
			    for (String List : Acess)
                {
                              if(List.contains(DataObject.getVariable("AcessTime",testCaseName))){
                                       
                              }
                              else{
                                     temp++;
                              }
                }
				if(temp == 0)
				{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);	
				}
				else
				{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}
				
				 }
			
			else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally{
			
			js.executeScript("window.scrollBy(0,-1000)");
			BrowserInitialization.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
			BrowserInitialization.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Reporter.TestCaseEnd();
			logger.info("-------------------------------****------------------------------");
		}
		}
	@Test(priority=2)
	public void tc_02() throws Exception{
		String testCaseName="TC_02";
		logger.info("Executing the Test Case No. " + testCaseName);
		try {
			boolean isRunnableTest=BackendCommonFunctionality.checkRunStatus(testCaseName);
			if(isRunnableTest){	
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName=BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_"+testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName()+"_"+testCaseName, testCaseDesc);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_services).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_Search).sendKeys(DataObject.getVariable("ServiceName", testCaseName));
				ArrayList<WebElement>services=(ArrayList<WebElement>) BrowserInitialization.driver.findElements(ObjectRepository.by_servicesList);
				ArrayList<WebElement>coverages=(ArrayList<WebElement>) BrowserInitialization.driver.findElements(ObjectRepository.by_servicecoveragelist);
				ArrayList<String>serviceslist=new ArrayList<String>();
				ArrayList<String>coverageslist=new ArrayList<String>();
				for(WebElement div:services){
					serviceslist.add(div.getText());
				}
				for(WebElement div:coverages){
					coverageslist.add(div.getText());
	
				}
				Collections.sort(serviceslist);
				Collections.sort(coverageslist);
				ArrayList<String>al=new ArrayList<String>();
				ArrayList<String>cl=new ArrayList<String>();
				al.addAll(serviceslist);
				cl.addAll(coverageslist);
			
				if(serviceslist.equals(al)&&coverageslist.equals(cl) ){
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);	
				}
				
				else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}	
			}		
			else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally{
			
			BrowserInitialization.driver.navigate().refresh();Reporter.TestCaseEnd();
		}	
		
	}
	
	@Test(priority=3)
	public void tc_03() throws Exception
	{
		String testCaseName = "TC_03";
		logger.info("Executing the Test Case No. " + testCaseName);	
		try {
			boolean isRunnableTest = BackendCommonFunctionality.checkRunStatus(testCaseName);
			// System.out.println(isRunnableTest);
			if (isRunnableTest) {
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName = BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_" + testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName() + "_" + testCaseName, testCaseDesc);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_services).click();
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				String searchbuttoncolor= DataObject.getVariable("searchbuttoncolor", testCaseName);
				String searchbarcolor= DataObject.getVariable("searchbarcolor", testCaseName);
				String sortbuttoncolor= DataObject.getVariable("sortbuttoncolor", testCaseName);
				String downloadbuttoncolor= DataObject.getVariable("downloadbuttoncolor", testCaseName);
				String searchbuttcol=BrowserInitialization.driver.findElement(ObjectRepository.by_searchbutton).getCssValue("color");
				String searchBarcol=BrowserInitialization.driver.findElement(ObjectRepository.by_searchbar).getCssValue("color");
				String sortbuttcol=BrowserInitialization.driver.findElement(ObjectRepository.by_sortbuton).getCssValue("color");
				String downloadbuttcol=BrowserInitialization.driver.findElement(ObjectRepository.by_download_icon).getCssValue("color");
				logger.info(searchbuttcol);
				logger.info(searchBarcol);
				logger.info(sortbuttcol);
				logger.info(downloadbuttcol);
				if(searchbuttcol.equals(searchbuttoncolor)&& searchBarcol.equals(searchbarcolor) )
				{
					if(sortbuttcol.equals(sortbuttoncolor) && downloadbuttcol.equals(downloadbuttoncolor))
					{screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
					}		
						
				}
				else
				{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}
			}	
				
		
			else {
					try {
						throw new SkipException(testCaseName + " is Skipped");
					} catch (SkipException e) {
						System.err.println(e.getMessage());
						Assert.fail();
					}}}
					catch (Exception e) {
						e.printStackTrace();
						screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
						BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
						Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
						Assert.fail();
				}
					finally {
						BrowserInitialization.driver.navigate().refresh();
						logger.info("Execution is completed for Test Case No." + testCaseName);
						Reporter.TestCaseEnd();
						logger.info("-------------------------------****------------------------------");
			}
	
		}
	
	
	@Test(priority=5)
	public void tc_05() throws Exception{
		String testCaseName = "TC_05";
		logger.info("Executing the Test Case No. " + testCaseName);
		try {
			boolean isRunnableTest = BackendCommonFunctionality.checkRunStatus(testCaseName);
			if (isRunnableTest) {
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName = BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_" + testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName() + "_" + testCaseName, testCaseDesc);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countries).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_SortButton).click();
				WebElement AtoZ=BrowserInitialization.driver.findElement(ObjectRepository.by_AtoZSort);
				String  weight=AtoZ.getCssValue("font-weight");
				logger.info(weight);
				if(Integer.parseInt(weight)>=700){			
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
					Thread.sleep(2000);
				}else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}
			}else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally {
			BrowserInitialization.driver.navigate().refresh();
			logger.info("Execution is completed for Test Case No." + testCaseName);
			Reporter.TestCaseEnd();
			logger.info("-------------------------------****------------------------------");
		}
}
	
	
	@Test(priority=6)
	public void tc_06() throws Exception{
		String testCaseName="TC_06";
		JavascriptExecutor js=(JavascriptExecutor) BrowserInitialization.driver;
		logger.info("Executing the Test Case No. " + testCaseName);
		try {
			boolean isRunnableTest=BackendCommonFunctionality.checkRunStatus(testCaseName);
			if(isRunnableTest){	
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName=BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_"+testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName()+"_"+testCaseName, testCaseDesc);
				Thread.sleep(3000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				WebElement services=BrowserInitialization.driver.findElement(ObjectRepository.by_services);	
				services.click();
				Actions action=new Actions(BrowserInitialization.driver);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WebElement searchbar=BrowserInitialization.driver.findElement(ObjectRepository.by_Search);
				action.moveToElement(searchbar).click().perform();
				BrowserInitialization.driver.findElement(ObjectRepository.by_Search).sendKeys(DataObject.getVariable("ServiceName", testCaseName));
				BrowserInitialization.driver.findElement(ObjectRepository.by_servicesList).click();
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				js.executeScript("window.scrollBy(0,150)");
				BrowserInitialization.driver.findElement(ObjectRepository.by_Search).sendKeys(DataObject.getVariable("CountryName", testCaseName));
				Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,650)");
				BrowserInitialization.driver.findElement(ObjectRepository.by_countriesList).click();
				if(BrowserInitialization.driver.findElement(ObjectRepository.by_quickysearchmagnify).isDisplayed()){			
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
				
				}else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}	

			}
			else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		
		finally{
			js.executeScript("window.scrollBy(0,-1000)");
				BrowserInitialization.driver.navigate().refresh();
				Reporter.TestCaseEnd();
				logger.info("-------------------------------****------------------------------");
			}
		
		
	}
	
	
	
	

	@Test(priority=7)
	public void tc_07() throws Exception{
		String testCaseName="TC_07";
		logger.info("Executing the Test Case No. " + testCaseName);
		JavascriptExecutor js=(JavascriptExecutor) BrowserInitialization.driver;
		try {
			boolean isRunnableTest=BackendCommonFunctionality.checkRunStatus(testCaseName);
			if(isRunnableTest){	
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName=BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_"+testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName()+"_"+testCaseName, testCaseDesc);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(6000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countries).click();
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String country= DataObject.getVariable("CountryName", testCaseName);
				BrowserInitialization.driver.findElement(ObjectRepository.by_Search).sendKeys(country);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countriesList).click();
				WebElement header=BrowserInitialization.driver.findElement(ObjectRepository.by_headersubtitle);
			    String header1=	header.getText();
			    if(country.equalsIgnoreCase(header1)){
			    	screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);
			    }
			    else{
			    	screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
			    }
			   
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
			BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
			Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
			Assert.fail();
		}
	finally{
		
		BrowserInitialization.driver.navigate().refresh();
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(3000);Reporter.TestCaseEnd();
		logger.info("-------------------------------****------------------------------");
	}		
	}
	
	
	@Test(priority=8)
	public void tc_08() throws Exception{
		String testCaseName = "TC_08";
		logger.info("Executing the Test Case No. " + testCaseName);
		try {
			boolean isRunnableTest = BackendCommonFunctionality.checkRunStatus(testCaseName);
			if (isRunnableTest) {
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName = BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_" + testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName() + "_" + testCaseName, testCaseDesc);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_Home).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_quickysearchmagnify).click();
				Thread.sleep(3000);
				if(BrowserInitialization.driver.findElement(ObjectRepository.by_quicksearchbox).isDisplayed()){			
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
					Thread.sleep(2000);
				}else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}	
			
			}else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally {
			BrowserInitialization.driver.navigate().refresh();
			Thread.sleep(2000);
			logger.info("Execution is completed for Test Case No." + testCaseName);
			Reporter.TestCaseEnd();
			logger.info("-------------------------------****------------------------------");
		}
}
	
	@Test(priority=9)
	public void tc_09() throws Exception{
		String testCaseName = "TC_09";
		logger.info("Executing the Test Case No. " + testCaseName);
		try {
			boolean isRunnableTest = BackendCommonFunctionality.checkRunStatus(testCaseName);
			
			if (isRunnableTest) {
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName = BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_" + testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName() + "_" + testCaseName, testCaseDesc);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_services).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_quickysearchmagnify).click();
				Thread.sleep(3000);
				if(BrowserInitialization.driver.findElement(ObjectRepository.by_quicksearchbox).isDisplayed()){			
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
					Thread.sleep(2000);
				}else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}		
			
			}else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally {
			BrowserInitialization.driver.navigate().refresh();
			Thread.sleep(2000);
			logger.info("Execution is completed for Test Case No." + testCaseName);
			Reporter.TestCaseEnd();
			logger.info("-------------------------------****------------------------------");
		}
}
	
	
	
	@Test(priority=10)
	public void tc_10() throws Exception{
		String testCaseName = "TC_10";
		logger.info("Executing Testcase:" + testCaseName);
		try {
			boolean isRunnableTest = BackendCommonFunctionality.checkRunStatus(testCaseName);
			
			if (isRunnableTest) {
				testCaseDesc=DataObject.getVariable("TestCaseDescription", testCaseName);
				passTestCaseDesc=DataObject.getVariable("TestPass", testCaseName);
				failTestCaseDesc=DataObject.getVariable("TestFail", testCaseName);
				screenShotName = BackendCommonFunctionality.makeDirectory(UserStoryName.getUSName() + "_" + testCaseName);
				Reporter.TestCaseStart(UserStoryName.getUSName() + "_" + testCaseName, testCaseDesc);
				BrowserInitialization.driver.findElement(ObjectRepository.by_menu).click();
				Thread.sleep(2000);
				BrowserInitialization.driver.findElement(ObjectRepository.by_countries).click();
				Thread.sleep(3000);
				BrowserInitialization.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				BrowserInitialization.driver.findElement(ObjectRepository.by_quickysearchmagnify).click();
				Thread.sleep(3000);
				if(BrowserInitialization.driver.findElement(ObjectRepository.by_quicksearchbox).isDisplayed()){			
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "PASS");
					BackendCommonFunctionality.displayTestCaseStatus(passTestCaseDesc, "PASS");
					Reporter.StepDetails("PASS", testCaseDesc, passTestCaseDesc, screenshotPath);				
					Thread.sleep(2000);
				}else{
					screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
					BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
					Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
					Assert.fail();
				}		
			
			}else {
				try {
					throw new SkipException(testCaseName + " is Skipped");
				} catch (SkipException e) {
					System.err.println(e.getMessage());
					Assert.fail();
				}}}
			catch (Exception e) {
				e.printStackTrace();
				screenshotPath = BackendCommonFunctionality.takeScreenshot(testCaseName, screenShotName, "FAIL");
				BackendCommonFunctionality.displayTestCaseStatus(failTestCaseDesc, "FAIL");
				Reporter.StepDetails("FAIL", testCaseDesc, failTestCaseDesc, screenshotPath);
				Assert.fail();
			}
		finally {
			BrowserInitialization.driver.navigate().refresh();
			Thread.sleep(2000);
			logger.info("Execution is completed for Test Case No." + testCaseName);
			Reporter.TestCaseEnd();
			logger.info("-------------------------------****------------------------------");
		}
}
	
	
	
	
	@Parameters({ "US_Name" })
	@BeforeTest
	public void beforeTest(String US_Name) throws InterruptedException, IOException {
		BackendCommonFunctionality.deleteDefaultSuite();
		BrowserInitialization.intilaize();
		BackendCommonFunctionality.login();
		UserStoryName.setUSName(US_Name);
		BackendCommonFunctionality.displayUSName(US_Name);
	}

	@AfterTest
	public void afterTest() {
		BrowserInitialization.driver.quit();
		logger.info("Logged Off From Application");

	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		BackendCommonFunctionality.deleteDefaultSuite();
		BackendCommonFunctionality.getCurrentDateTime();
		Reporter.intilizeReporter();
		
	}
	@AfterSuite
	public void aftersuite() throws Exception{

	//Reporter.terminateReporter();
	Reporter.TestSuiteEnd();
	Zipper.zipReport(Reporter.folderPath);
	BackendCommonFunctionality.takeReportScreenshot();
	Mailer.sendEmail(Reporter.folderPath);
	}
}
	
	


