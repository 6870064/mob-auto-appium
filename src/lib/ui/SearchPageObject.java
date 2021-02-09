package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
    SKIP_BUTTON,
    SEARCH_INIT_ELEMENT,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    WORD_FOR_EMPTY_SEARCH,
    CANCEL_SEARCH_BUTTON,
    NO_RESULTS_STRING,
    NOT_EMPTY_SEARCH_VALUE,
    NOT_EMPTY_SEARCH_LOCATOR;

    public SearchPageObject(AppiumDriver driver){
    super(driver);
    }

    public void skipButtonClick(){
    this.waitForElementAndClick(
    SKIP_BUTTON,
    "Cannot find [SKIP] button",
    5);
    }

    public void initSearchInput(){

    this.waitForElementAndClick(
    SEARCH_INIT_ELEMENT,
    "Cannot find search input",
    5);
    }

    public void searchArticleTitle(String search_line){

    this.waitForElementAndSendKeys(
    SEARCH_INIT_ELEMENT,
    search_line,
    "Cannot find search input",
    5);
    }

    public void waitForSearchResult(){
    this.waitForElementPresent(
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    "Cannot find search result");
    }

    public void searchWithEmptyResult(){

    this.waitForElementAndSendKeys(
    SEARCH_INIT_ELEMENT,
    WORD_FOR_EMPTY_SEARCH,
    "Cannot find search input",
    5);

    this.waitForElementPresent(
    NO_RESULTS_STRING,
    "Cannot find " + NO_RESULTS_STRING + " topic searching by " + WORD_FOR_EMPTY_SEARCH,
    12);
    }

    public void cancelArticleSearch(){

    this.waitForElementAndClick(
    CANCEL_SEARCH_BUTTON,
    "Cannot find [x] cancel search button",
    10);

   this.waitForElementNotPresent(
   CANCEL_SEARCH_BUTTON,
   "[X] is still presented on the page",
   5);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring){
    return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS */

    public void waitForSearchResult(String substring){
    String search_result_xpath = getResultSearchElement(substring);
    this.waitForElementPresent(
    search_result_xpath,
    "Cannot find search result with substring " +substring);
    }

    public void clickByArticleWithSubstring(String substring){
    String search_result_xpath = getResultSearchElement(substring);
    this.waitForElementAndClick(
    search_result_xpath,
    "Cannot find and click search result with substring " +substring,
    10);
    }

    public void assertTitleCheck(){
    this.waitForElementAndSendKeys(
    SEARCH_INIT_ELEMENT,
    NOT_EMPTY_SEARCH_VALUE,
    "Cannot find search input",
    10);

    this.waitForElementPresent(
    NOT_EMPTY_SEARCH_LOCATOR,
    "Cannot find anything by the request " + NOT_EMPTY_SEARCH_VALUE,
    10);

    int amount_of_search_results = getAmountOfElements(
    NOT_EMPTY_SEARCH_LOCATOR);

    Assert.assertTrue(
    "We found too few results!",
    amount_of_search_results >0);
    }


    public void searchFieldClear(){ //Метод клика по кнопке [X] Cancel Search
        this.waitForElementAndClick(CANCEL_SEARCH_BUTTON,"Search cancel button is still presented", 5);

    }

}
