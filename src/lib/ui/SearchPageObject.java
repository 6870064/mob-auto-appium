package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
   SKIP_BUTTON = "//*[contains(@text,'SKIP')]",
   SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
    FIRST_WORD_FOR_SEARCH = "Java",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='{SUBSTRING}']",
    SECOND_WORD_FOR_SEARCH = "Rammstein",
    SECOND_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='German industrial metal band']",
    WORD_FOR_EMPTY_SEARCH = "Bla zzz qwerty",
    CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']",
    FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]",
    SECOND_ARTICLE_TITLE = "//*[contains(@text,'Rammstein')]",
    FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]",
    SAVE_BUTTON = "//android.widget.TextView[@resource-id='org.wikipedia:id/article_menu_bookmark']",
    ADD_TO_LIST_BUTTON = "//*[contains(@text,'ADD TO LIST')]",
    CREATE_NEW_LIST_BUTTON = "//*[contains(@text,'Create new')]",
    NAME_OF_THE_LIST = "//*[contains(@text,'Name of this list')]",
    DESCRIPTION_OF_THE_LIST = "//*[contains(@text,'Description (optional)')]",
    OK_BUTTON = "//*[contains(@text,'OK')]",
    NAME_OF_THE_LIST_VALUE = "First list title",
    DESCRIPTION_OF_THE_LIST_VALUE = "First list description",
    LIST_TITLE_ON_READING_LIST_POP_UP = "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title']",
    BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
    VIEW_LIST_BUTTON = "//*[contains(@text,'VIEW LIST')]",
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

    public void searchWikipediaClick(){

    this.waitForElementAndClick(
    By.xpath(SEARCH_INIT_ELEMENT) ,
    "Cannot find search input",
    5);
    }

    public void searchArticleTitle(){

    this.waitForElementAndSendKeys(
    By.xpath(SEARCH_INIT_ELEMENT),
    FIRST_WORD_FOR_SEARCH,
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

}
