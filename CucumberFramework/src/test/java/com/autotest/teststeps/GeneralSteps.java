package com.autotest.teststeps;

import com.automation.pages.PageManager;
import com.automation.pages.common.WebPage;
import com.automation.pages.dealerfx.HomePage;
import com.automation.utils.dataProvider.TestParameters;
import com.automation.utils.otherUtils.CommonMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GeneralSteps extends BaseTestSteps {

    /**
     * Logs in using given credentials.
     * Assumes browser is on a login page
     *
     * @param browser
     * @param evnRUL
     */

    HomePage homePage = new HomePage();

    @Given("^I launched browser \"(.*)\" and open (.+)$")
    public void iLaunchBrowserAndOpenURLuser(String browser, String evnRUL) {
        PageManager.quitBrowser();
        PageManager.launchBrowser(browser, "no");
        String url = PageManager.getEnvURL(evnRUL);
        TestParameters.setUrlEnv(url);
        TestParameters.setBrowserName(browser);
        TestParameters.updateTestEnv(url);
        WebPage.openURL(url);
        WebPage.initializeJSONObject();        
    }

    @Given("^I launch browser \"(.*)\" in \"(.*)\" and open \"(.*)\"$")
    public void iLaunchBrowserAndOpenURLWithHeadless(String browser, String head, String evnRUL) {
        PageManager.quitBrowser();
        PageManager.launchBrowser(browser, head);
        String url = PageManager.getEnvURL(evnRUL);
        TestParameters.setUrlEnv(url);
        TestParameters.setBrowserName(browser);
        TestParameters.updateTestEnv(url);
        WebPage.openURL(url);
        WebPage.initializeJSONObject();        
    }



    @And("^I set \"([^\"]*)\" to the 'DMS'$")
    public void setToTheDMS(String dms) {
        if (dms.equalsIgnoreCase("default"))
        {  String url = TestParameters.getUrlEnv();
            dms = TestParameters.get_OEM_DummyDealer(url) + " Framework" ;
        }
        TestParameters.setDMSName(dms);
        System.out.println("The current DMS is : " + dms);
    }
    
    @And("^I search the  \"([^\"]*)\" on the 'Search' page$")
    public void searchOnThePage(String searchCriteria) {
    	homePage.enterSearchCriteria(searchCriteria);
    	homePage.click("SEARCH");
    }
    
    @And("^I note down the search results$")
    public void noteDownSearchResuls() {    
    	homePage.displaySearchResults();
    }
    
    @And("^I click on Amazon link$")
    public void clickTheLink() {    
    	homePage.click("AMAZON");
    }
    
    @And("^I click on All button on search and select \"([^\"]*)\" as category$")
    public void selectCategory(String category) {    
    	homePage.selectAction(category);
    }

    @And("^I search Product \"([^\"]*)\" from the search bar$")
    public void searchProduct(String product) {
    	homePage.searchProduct(product);
    }
        
    @And("^I apply \"([^\"]*)\" to \"([^\"]*)\" as filter range$")
    public void applyRange(String lowRange, String highRange) {
    	homePage.filterRange(lowRange, highRange);
    }
    
    @And("^Validate the products displayed on the screen are within \"([^\"]*)\" to \"([^\"]*)\" range$")
    public void validateProductRange(String lowRange, String highRange) {
    	homePage.validateProductRange(lowRange, highRange);
    }    
    
    
    @And("^I validate \"([^\"]*)\" as window title of the focussed screen$")
    public void iValidateWindowTitle(String title) {
    	CommonMethods.validateWindowTitle(title);
    }
    
    @And("^I close the current focussed window on the browser$")
    public void iCloseCurrentOpenWindowOntheBrowser() {
    	CommonMethods.closeWindow();
    }         

}
