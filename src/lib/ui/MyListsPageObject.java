package lib.ui;
import io.appium.java_client.AppiumDriver;

abstract public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject (AppiumDriver driver){
        super(driver);
    }

    protected static String
    ADD_TO_LIST_BUTTON,
    LIST_TITLE_ON_READING_LIST_POP_UP,
    VIEW_LIST_BUTTON,
    FIRST_ARTICLE_TITLE,
    SECOND_ARTICLE_TITLE,
    SECOND_WORD_FOR_SEARCH;

    public void myListsOpening(){

    this.waitForElementAndClick(
    ADD_TO_LIST_BUTTON,
    "Cannot click [ADD TO LIST] button",
    5);

    this.waitForElementPresent(
    LIST_TITLE_ON_READING_LIST_POP_UP,
    "Cannot open articles list",
    10);

    this.waitForElementAndClick(
    LIST_TITLE_ON_READING_LIST_POP_UP,
    "Cannot open articles list",
    10);

    this.waitForElementAndClick(
    VIEW_LIST_BUTTON,
    "Cannot find [VIEW LIST] button",
    5);

    this.waitForElementPresent(
    SECOND_ARTICLE_TITLE,
    "Cannot find the second saved article",
   10);
    }

    public void swipeArticleToDelete(){

    this.swipeElementToTheLeft(
    FIRST_ARTICLE_TITLE,
    "Cannot find saved first article");

   this.waitForElementNotPresent(
   FIRST_ARTICLE_TITLE,
   "First article is still presented in the saved list",
   12);
    }

    public void articleAvailabilityCheck(){
    this.waitForElementPresent(
    SECOND_ARTICLE_TITLE,
    "Cannot find the second article titled " + SECOND_WORD_FOR_SEARCH,
    12);
    }
}
