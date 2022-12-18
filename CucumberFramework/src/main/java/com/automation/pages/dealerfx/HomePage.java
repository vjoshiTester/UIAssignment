package com.automation.pages.dealerfx;

import com.automation.pages.PageManager;
import com.automation.utils.otherUtils.CommonMethods;
import com.automation.utils.sync.SyncPage;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automation.pages.common.WebPage;

public class HomePage extends WebPage {

//    @FindBy(id="banner")
//    private static WebElement bannerFrame;																						// Banner Frame
    private static By bBannerFrame = By.id("banner");
    private static By bSwitchDealerWindow = By.id("impersonate"); 
    private static By bSwitchDealerBtn = By.xpath("//span[@class='delearInfo ng-star-inserted']");    
    private static By bMoreBtn = By.xpath("//div/img[@src='/portal/dist-home/assets/images/nav/more.svg']");    
    private static By bMoreOMMBtn = By.xpath("//a[text()='Online Maintenance Menu']");    
    private static By bMoreTechInspectionBtn = By.xpath("//a[text()='Technician Inspection']");
    private static By bMorePerSerWelBtn = By.xpath("//a[text()='Personalized Service Welcome']");
    private static By bMoreCustMgmtBtn = By.xpath("//a[text()='Customer Management']");    
    private static By bChatIconBtn = By.xpath("//span[@class='material-icons']");    
    private static By bsearchTxtBox = By.xpath("//input[@name='q']");
    private static By bsearchBtn = By.xpath("(//input[@type='submit' and @value='Google Search'])[2]");
    private static By bAmazonLink = By.xpath("(//div/div/a[@href='https://www.amazon.in/'])[2]");
    private static By bAllBtn = By.xpath("//select[@aria-describedby='searchDropdownDescription']");
    private static By bSearchField = By.xpath("//div[@class='nav-search-field ']");
    private static By bProductSearchBtn = By.xpath("//input[@id='nav-search-submit-button']");
    private static By blowPrice = By.xpath("//input[@id='low-price']");
    private static By bhighPrice = By.xpath("//input[@id='high-price']");
    private static By bGoBtn = By.xpath("//input[@class='a-button-input' and @type = 'submit']");
    private static By bRange = By.xpath("//span[@class='a-price-whole']");
    private static By bSearchResults = By.xpath("//div/a[@href]");    

//    @FindBy(id = "contents")      //  Dealer Name
//    private static WebElement frameCont1;
    private static By bFrameCont = By.id("contents");

//    @FindBy(id = "banner")      //  Dealer Name
//    private static WebElement frameBan1;

//    @FindBy(id = "FrameworkMain")      //  Dealer Name
    private static By bFrameMain = By.id("FrameworkMain");
//    private static WebElement frameMain = driver.findElement(bFrameMain);

//    @FindBy(id="txtSearchDealerCode")
//    private static WebElement dealerCode1;
    private static By bDealerCode = By.id("txtSearchDealerCode");


//    @FindBy(css = ".whitetxt>a[onclick*='ImpersonatePage']")   // Select dealerShip link Css
//    private static WebElement threeDots;
    private static By bThreeDots = By.cssSelector(".whitetxt>a[onclick*='ImpersonatePage']");

//    @FindBy(xpath = ".//a[contains(text(),'Click Here to Select')]")   // Select dealerShip link
//    private static WebElement selectDealerLink;
    private static By bSelectDealerLink = By.xpath(".//a[contains(text(),'Click Here to Select')]");

//    @FindBy(id = "txtSearchDealerName")      //  Dealer Name
//    private static WebElement txtdName1;
    private static By bTxtdName = By.id("txtSearchDealerName");
    private static By blblChangeDealer = By.id("changeFocusLabel");    

    private static By bTitle = By.xpath("//tr[@class='SelectedLine']/td[3]");

//    @FindBy(id = "btnSignOut")      //  Dealer Name
//    private static WebElement logoutBtn1;
    private static By bLogout = By.id("btnSignOut");

//    @FindBy(id = "txtSearchDealerCode")      // dealer Code
//    private static WebElement txtdCode;

//    @FindBy(id = "btnSubmit")     // Dealr search Button
//    private static WebElement searchBtn1;
    private static By bSearchBtn = By.id("btnSubmit");

//    @FindBy(xpath = "//table[@id='dImpersonate']/tbody/tr[2]")     // first line of Dealer
//    private static WebElement firstDealer1;
    private static By bFirstDealer = By.xpath("//table[@id='dImpersonate']/tbody/tr[2]");

//    @FindBy(id = "btnOK")     // select button
//    private static WebElement selectBtn1;
    private static By bSelectBtn = By.id("btnOK");

//    @FindBy(xpath = ".//*[@id='form1']/table/tbody/tr[2]/td[2]")     // select button
//    private static WebElement titleWelcome1;
    private static By bWelcome = By.xpath(".//*[@id='form1']/table/tbody/tr[2]/td[2]");

    //use to detect if login user is MTI admin
    private static By bMTIAdmin = By.xpath("//td[contains(text(),'Administration')]");

    private static By bNissanService = By.xpath("//td[contains(text(),'Nissan')]");

    private static By bNissanServiceDashboard = By.xpath("//td[contains(text(),'Nissan')]/parent::tr/parent::tbody/parent::table/parent::div/following::div[1]//td[contains(text(),'Service Dashboard')]");

    private static By bToyotaService = By.xpath("//td[contains(text(),'Toyota Service')]");

    private static By bToyotaServiceDashboard = By.xpath("//td[contains(text(),'Toyota Service')]/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div[1]//td[contains(text(),'Service Dashboard')]");

    private static By bServiceAssistServiceDashboard = By.xpath("//td[contains(text(),'Service Assist')]/../../../../following-sibling::div//td[contains(text(),'Service Dashboard')]");

    private static By bTechInspectionLink = By.xpath(".//td[contains(text(),'Technician Inspection')]");

    private static By bServiceAssistTechInspection = By.xpath("//td[contains(text(),'Service Assist')]/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div//td[contains(text(),'Technician Inspection')]");

    private static By bToyotaTechInspection = By.xpath("//td[contains(text(),'Toyota Service')]/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div[1]//td[contains(text(),'Technician Inspection')]");

    private static By bVWService = By.xpath("//td[contains(text(),'VW Service Drive')]");

    private static By bVWServiceDashboard = By.xpath("(//td[contains(text(),'Service Dashboard')])[7]");

    private static By bServiceAssist = By.xpath("//td[contains(text(),'Service Assist')]");

    private static By bServiceDashboard = By.xpath("//td[contains(text(),'Service Dashboard')]");

    private static By bToyotaAdvisorCheckIn = By.xpath("(.//tbody//td[text()='Advisor Check-In'])[2]");

//    @FindBy(xpath = ".//tbody//td[text()='Advisor Check-In']")  // select TD App
//    private static WebElement advisorCheckInLink;
    private static By bAdvisorCheckInLink = By.xpath(".//tbody//td[text()='Advisor Check-In']");

    private static By bWiAdvisor = By.xpath("//td[text()='wiADVISOR Tools']");

    private static By bWiAdvisorCustomerConnect = By.xpath("//td[text()='wiADVISOR Tools']/../../../../following-sibling::div//td[text()='Customer Connect']");

    private static By bWiAdvisorTechnicianDashboard = By.xpath("//td[text()='wiADVISOR Tools']/../../../../following-sibling::div//td[text()='Technician Dashboard']");

    private static By bWiAdvisorTechnicianInspection = By.xpath("//td[text()='wiADVISOR Tools']/../../../../following-sibling::div//td[text()='Technician Inspection']");

    private static By bMarketingTool = By.xpath("//td[text()='Marketing Tools']");

    private static By bMarketingToolCustomerConnect = By.xpath("//td[contains(text(),'Marketing Tools')]/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div//td[contains(text(),'Customer Connect')]");

    private static By bMarketingToolServiceDashboard = By.xpath("//td[contains(text(),'Marketing Tools')]/parent::tr/parent::tbody/parent::table/parent::div/following::div[1]//td[contains(text(),'Service Dashboard')]");

    private static By bMarketingToolAppointmentManager = By.xpath("//td[contains(text(),'Marketing Tools')]/../../../../following-sibling::div//td[contains(text(),'Appointment Manager')]");

    private static By bMarketingToolAdvisorCheckIn = By.xpath("//td[text()='Marketing Tools']/../../../../following-sibling::div//td[text()='Advisor Check-In']");

    private static By bAppointmentManager = By.xpath("//td[text()='Appointment Manager']");
    
    private static By bSideBarTextAppointmentManager = By.xpath("//div[text()='Appointment Manager']");    

    private static By bGuestConnectLink = By.xpath(".//tbody//td[text()='Guest Connect']");

    private static By bCustomerConnectLink = By.xpath(".//tbody//td[text()='Customer Connect']");

    private static By bProfile = By.xpath("//td[text()='Profile']");
    
    private static By bSideBarPayments = By.xpath("//img[@src='/portal/dist-home/assets/images/nav/attach_money.svg']");    

    private static By bSideBarAppointmentManager = By.xpath("//img[@src='/portal/dist-home/assets/images/nav/event.svg']");    
    
    private static By bLogo = By.xpath("//img[@title='logo']");    

    public static String homePageWindowHandle = null;
    
    public static String getHomePageWindowHandle() {
		return homePageWindowHandle;
	}

	public static void setHomePageWindowHandle(String homePageWindowHandle) {
		HomePage.homePageWindowHandle = homePageWindowHandle;
	}

	private static By bUserOptions = By.xpath("//span[@class='material-icons person' and text()='account_circle']");  
	private static By bResetPassword = By.xpath("//a[text()='Reset Password']");	
	private static By bLog_Out = By.xpath("//a[text()='Logout' or text()='Déconnexion']");	
	private static By bFrench = By.xpath("//label[@for='french']");	
	private static By bEnglishCA = By.xpath("//label[@for='english-ca']");		

	//    @FindBy(id = "hrefLaunchApp")  // App link
//    private static WebElement appLaunch1;
    private static By bAppLaunch = By.id("hrefLaunchApp");


//    @FindBy(css="#upx_GroupHeader1_TR > td:nth-child(2)")
//    private static WebElement administrationMenu;
    private static By bAdministrationMenu = By.cssSelector("#upx_GroupHeader1_TR > td:nth-child(2)");

//    @FindBy(css="#upx_GroupHeader1_Item3 > tbody > tr > td:nth-child(2)")
//    private static WebElement ommAdmin;
    private static By bOmmAdmin = By.cssSelector("#upx_GroupHeader1_Item3 > tbody > tr > td:nth-child(2)");

    private By bApplicationSelection (String applicationPosition){
      String locator = "(//div[@class='box-area'])["+applicationPosition+"]";      
      return By.xpath(locator);
    }	

    // Marketing pop up message
    private static final By hmarketingMessage = By.xpath("//p[text()='Announcing: New Communication Tool']");   
    
    // Marketing pop up message
    private static final By hmarketingMessageDismissBtn = By.xpath("//button[text()='Dismiss']");     
    private static By bPaymentsInFrench = By.xpath("//div[@class='box-header']/h1[text() = 'Paiements']");
    private static By bCustomerConnectInFrench = By.xpath("//div[@class='box-header']/h1[text() = 'Connexion clients']");       
    private static By bChangeDealerCloseButton = By.xpath("//button[@class='close' and text()='×']");    

    private static Logger log = Logger.getLogger(HomePage.class.getName());

    
    private Boolean isPageLoad() {
        return dWait.until(conditionForPage());
    }

    @Override
    protected ExpectedCondition<Boolean> conditionForPage() {
        return ExpectedConditions.titleContains("Application Framework");
    }

     @Override
    protected void switchFrame() {
        driver.switchTo().defaultContent();
    }


    protected void waitForPageToLoad(){																							// Wait for page to finish loading
        pWait.until(SyncPage.condDomReadyState());
//		wait.until(ExpectedConditions.visibilityOf(bannerFrame));
        pWait.until(SyncPage.condPageLoaded(bBannerFrame, bDealerCode));
        log.info("Home Page finished loading");
    }
    
    public void enterSearchCriteria(String criteria) {
    	clearAndInput(bsearchTxtBox, criteria);
    	TabOut();
    }
    
 	public void click(String name) {
		sleep(3000);
		switch (name.toUpperCase()) {
				case "SEARCH":		
				driver.findElement(bsearchBtn).click();
		    	sleep(5000);
		    break;
			case "AMAZON":
				driver.findElement(bAmazonLink).click();
		    	sleep(5000); 			    	
			break;		
			case "PRODUCTSEARCH":
				driver.findElement(bProductSearchBtn).click();
				sleep(500);
			break;
			case "SUBMITGO":
				driver.findElement(bGoBtn).click();
				sleep(5000);
			break;			
			default:
				return;
		}
	}  
	
	public void selectAction(String category) {
		Select sel = new Select(driver.findElement(bAllBtn));
		sel.selectByVisibleText(category);
    	sleep(5000); 				
	}
	
	public void searchProduct(String product) {
    	clearAndInput(bSearchField, product);
    	TabOut();
    	sleep(3000);
    	click("ProductSearch");
	}
	
	public void filterRange(String lowRange, String highRange) {
    	clearAndInput(blowPrice , lowRange);
    	TabOut();
    	clearAndInput(bhighPrice, highRange);
    	sleep(3000);
    	click("SubmitGO");
	}
	
	public void validateProductRange(String lowRange, String highRange) {
		List<WebElement> productRange = driver.findElements(bRange);
		int lRange = Integer.parseInt(lowRange);
		int hRange = Integer.parseInt(highRange);
		for (WebElement webElement : productRange) {
			System.out.println("*********Price range displayed in Rs********** "+ webElement.getText());
			if (!(Integer.parseInt(webElement.getText().replaceAll(",", "")) > hRange) || (Integer.parseInt(webElement.getText().replaceAll(",", "")) < lRange)) {
				System.out.println("Price displayed are falling in the range");
			} else {
			    throw new ArithmeticException();
			}
		}
	}
	
	public void displaySearchResults() {
		List<WebElement> searchResults = driver.findElements(bSearchResults);
		int size = searchResults.size();
		for (int i = 0; i < size; i++) {			
			if (searchResults.get(i).getText().length() > 0) {
				System.out.println("*********Search result is " + searchResults.get(i).getText());
			}
		}
	}
	
	
}


