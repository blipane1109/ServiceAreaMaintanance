package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ObjectRepository {
	
	public WebElement element = null;
	
	public static By by_username=By.xpath("//input[@name='username']");
	public static By by_password=By.xpath("//input[@name='password']");
	public static By by_submit=By.xpath("//input[@name='submit']");
	public static By by_landingpg=By.xpath("//h1[text()='Welcome']");
	public static By by_menu=By.xpath("//mat-icon[text()='menu']");
	public static By by_services=By.xpath("//a[@href='#/services']");
	public static By by_Home=By.xpath("//a[@href='#/']");
	public static By by_countries=By.xpath("//p[text()='Countries']");
	public static By by_countrysearch=By.xpath("//input[@placeholder='Search by name or code']");
	public static By by_servicesList=By.xpath("//span[@class='header mat-line']");
	public static By by_countryname=By.xpath("//span[@class='header mat-line']");
	public static By by_countriesList=By.xpath("//a[@ng-reflect-klass='list-item']");
	public static By by_countriescodelist=By.xpath("//div[@class='icon mat-list-avatar']");
	public static By by_Errormessage=By.xpath("//p[text()='No Search Results Found']");
	public static By by_FirstService=By.xpath("(//a//div[@class= 'header-column']//span)[1]");
	public static By by_headersubtitle=By.xpath("//span[@class='app-subtitle ng-star-inserted']");
	public static By by_download_service=By.xpath("(//mat-icon[@class='icon-font mat-icon material-icons'])[2]");
	public static By by_Search=By.xpath("//input[@placeholder='Search by name or code']");
	 public static By by_servicecoveragelist=By.xpath("//p[@class='category']");
	 public static By by_publicationinfobar=By.xpath("//mat-panel-title[contains(.,'Publication ')]/../..");
	 public static By by_publishwhole=By.xpath("//span[text()='Publish']/..");
	 public static By by_profiledesccodewhole=By.xpath("(//span[@class='value mat-line ng-star-inserted'])[7]/..");
	 public static By by_Country_Service_SearchBar=By.xpath("//mat-panel-title[text()='Services']/../../../../..//input");
	 public static By by_MoreInfotoggle=By.xpath("//span[text()='More Info']/../..//button");
	 public static By by_SortButton=By.xpath("//button[@class='sort-btn mat-icon-button']//span[1]");
	 public static By by_AtoZSort=By.xpath("(//mat-option[@class='mat-option mat-active'])[1]");
	  public static By by_quickysearchmagnify=By.xpath("//button[@class='search-icon mat-icon-button']");
	  public static By by_quicksearchbox=By.xpath("//div[@class='advanced-modal']");
	  public static By by_searchbutton=By.xpath("//button[@class='search-btn mat-icon-button']");
	  public static By by_searchbar=By.xpath("//input[@placeholder='Search by name or code']");
	  public static By by_sortbuton=By.xpath("//button[@class='sort-btn mat-icon-button']");
	  public static By by_download_icon=By.xpath("//mat-icon[text()='file_download']");
	  
	  
	////input[@name='email']
	
	

}
