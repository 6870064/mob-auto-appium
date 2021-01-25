package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject (AppiumDriver driver){
        super(driver);
    }

    protected static String
    ADD_TO_LIST_BUTTON = "//*[contains(@text,'ADD TO LIST')]",
    LIST_TITLE_ON_READING_LIST_POP_UP = "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title']",
    VIEW_LIST_BUTTON = "//*[contains(@text,'VIEW LIST')]",
    FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]",
    SECOND_WORD_FOR_SEARCH = "Rammstein",
    SECOND_ARTICLE_TITLE = "//*[contains(@text,'Rammstein')]";

    public void myListsOpening(){

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST_BUTTON),
                "Cannot click [ADD TO LIST] button",
                5);

        this.waitForElementPresent(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        this.waitForElementAndClick(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        this.waitForElementAndClick(
                By.xpath(VIEW_LIST_BUTTON),
                "Cannot find [VIEW LIST] button",
                5);

        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_TITLE),
                "Cannot find the second saved article",
                10);
    }

    public void swipeArticleToDelete(){

        this.swipeElementToTheLeft(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find saved first article");

        this.waitForElementNotPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "First article is still presented in the saved list",
                12);
    }

    public void articleAvailabilityCheck(){
        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_TITLE),
                "Cannot find the second article titled " + SECOND_WORD_FOR_SEARCH,
                12);
    }
}
