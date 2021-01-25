package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver){
    super(driver);
    }

    private static final String
    FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]",
    SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
    SECOND_WORD_FOR_SEARCH = "Rammstein",
    SECOND_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='German industrial metal band']",
    FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]",
    SAVE_BUTTON = "//android.widget.TextView[@resource-id='org.wikipedia:id/article_menu_bookmark']",
    ADD_TO_LIST_BUTTON = "//*[contains(@text,'ADD TO LIST')]",
    CREATE_NEW_LIST_BUTTON = "//*[contains(@text,'Create new')]",
    NAME_OF_THE_LIST = "//*[contains(@text,'Name of this list')]",
    DESCRIPTION_OF_THE_LIST = "//*[contains(@text,'Description (optional)')]",
    OK_BUTTON = "//*[contains(@text,'OK')]",
    NAME_OF_THE_LIST_VALUE = "First list title",
    DESCRIPTION_OF_THE_LIST_VALUE = "First list description",
    VIEW_LIST_BUTTON = "//*[contains(@text,'VIEW LIST')]";

    public WebElement waitForTitleElement(){
    return this.waitForElementPresent(By.xpath(FIRST_ARTICLE_TITLE), "Cannot find article on the page!", 15);
    }

    public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
    }

    public void swipeToFooter(){
    this.swipeUpToFindElement(
    By.xpath(FOOTER_ELEMENT),
    "Can't find footer element 'View article in browser' link",
    300);
    }

    public void addFirstArticleToMyList(){

    this.waitForElementAndClick(
    By.xpath(SAVE_BUTTON),
    "Cannot click [Save] button in tab bar",
    10);

    this.waitForElementAndClick(
    By.xpath(ADD_TO_LIST_BUTTON),
    "Cannot click [ADD TO LIST] button",
    5);

    this.waitForElementAndClick(
    By.xpath(CREATE_NEW_LIST_BUTTON),
    "Cannot click [Create New] button",
    10);

    this.waitForElementAndSendKeys(
    By.xpath(NAME_OF_THE_LIST),
    NAME_OF_THE_LIST_VALUE,
    "Cannot find 'Name of the list' field",
    5);

    this.waitForElementAndSendKeys(
    By.xpath(DESCRIPTION_OF_THE_LIST),
    DESCRIPTION_OF_THE_LIST_VALUE,
    "Cannot find 'Name of the list' field",
    5);

    this.waitForElementAndClick(
    By.xpath(OK_BUTTON),
    "Cannot find 'Description of the list' field",
    5);

    this.waitForElementAndClick(
    By.xpath(VIEW_LIST_BUTTON),
    "Cannot find [VIEW LIST] button",
    5);

    this.waitForElementPresent(
    By.xpath(FIRST_ARTICLE_TITLE),
    "Cannot find saved article",
    10);
    }

    public void addSecondArticleToMyList(){

        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INIT_ELEMENT),
                SECOND_WORD_FOR_SEARCH,
                "Cannot find search input",
                5);

        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find " + SECOND_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + SECOND_WORD_FOR_SEARCH,
                12);

        this.waitForElementAndClick(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find article title description",
                10);

        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot click [Save] button in tab bar",
                10);
    }

    public void articleTitleAfterBackground(){

        this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find article title after being in background",
                10);
    }

}
