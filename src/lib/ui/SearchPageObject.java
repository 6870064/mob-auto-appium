package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class SearchPageObject extends MainPageObject{

    private static final String
    SKIP_BUTTON = "//*[contains(@text,'SKIP')]",
    SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='{SUBSTRING}']",
    WORD_FOR_EMPTY_SEARCH = "Bla zzz qwerty",
    CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']",
    NO_RESULTS_STRING = "//android.widget.TextView[@resource-id='org.wikipedia:id/results_text']",
    NOT_EMPTY_SEARCH_VALUE = "Rammstein discography",
    NOT_EMPTY_SEARCH_LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_container']";


    public SearchPageObject(AppiumDriver driver){
    super(driver);
    }

    public void skipButtonClick(){
    this.waitForElementAndClick(
    By.xpath(SKIP_BUTTON),
    "Cannot find [SKIP] button",
    5);
    }

    public void initSearchInput(){

    this.waitForElementAndClick(
    By.xpath(SEARCH_INIT_ELEMENT) ,
    "Cannot find search input",
    5);
    }

    public void searchArticleTitle(String search_line){

    this.waitForElementAndSendKeys(
    By.xpath(SEARCH_INIT_ELEMENT),
    search_line,
    "Cannot find search input",
    5);
    }

    public void waitForSearchResult(){
    this.waitForElementPresent(
    By.xpath(SEARCH_RESULT_BY_SUBSTRING_TPL),
    "Cannot find search result");
    }

    public void searchWithEmptyResult(){

    this.waitForElementAndSendKeys(
    By.xpath(SEARCH_INIT_ELEMENT),
    WORD_FOR_EMPTY_SEARCH,
    "Cannot find search input",
    5);

    this.waitForElementPresent(
    By.xpath(NO_RESULTS_STRING),
    "Cannot find " + NO_RESULTS_STRING + " topic searching by " + WORD_FOR_EMPTY_SEARCH,
    12);
    }

    public void cancelArticleSearch(){

    this.waitForElementAndClick(
    By.xpath(CANCEL_SEARCH_BUTTON),
    "Cannot find [x] cancel search button",
    10);

   this.waitForElementNotPresent(
   By.xpath(CANCEL_SEARCH_BUTTON),
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
    this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " +substring);
    }

    public void clickByArticleWithSubstring(String substring){
    String search_result_xpath = getResultSearchElement(substring);
    this.waitForElementAndClick(
    By.xpath(search_result_xpath),
    "Cannot find and click search result with substring " +substring,
    10);
    }

    private int getAmountOfElements(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertTitleCheck(){
        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INIT_ELEMENT),
                NOT_EMPTY_SEARCH_VALUE,
                "Cannot find search input",
                10);

        this.waitForElementPresent(
                By.xpath(NOT_EMPTY_SEARCH_LOCATOR),
                "Cannot find anything by the request " + NOT_EMPTY_SEARCH_VALUE,
                10);

        int amount_of_search_results = getAmountOfElements(
                By.xpath(NOT_EMPTY_SEARCH_LOCATOR)
        );

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results >0);
    }

}
