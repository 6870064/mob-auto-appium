package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver){
    super(driver);
    }

    protected static String
    FIRST_ARTICLE_TITLE,
    SEARCH_INIT_ELEMENT,
    SECOND_ARTICLE_SEARCH_DESCRIPTION,
    FOOTER_ELEMENT,
    SAVE_BUTTON,
    ADD_TO_LIST_BUTTON,
    CREATE_NEW_LIST_BUTTON,
    NAME_OF_THE_LIST,
    DESCRIPTION_OF_THE_LIST,
    CLOSE_SYNC_POP_UP_BUTTON,
    OK_BUTTON,
    VIEW_LIST_BUTTON,
    SECOND_WORD_FOR_SEARCH,
    NAME_OF_THE_LIST_VALUE,
    DESCRIPTION_OF_THE_LIST_VALUE;

    public WebElement waitForTitleElement(){
    return this.waitForElementPresent(FIRST_ARTICLE_TITLE, "Cannot find article on the page!", 15);
    }

    public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    if (Platform.getInstance().isAndroid()){
        return title_element.getAttribute("text");
    } else {
        return title_element.getAttribute("name");
    }
    }

    public void swipeToFooter(){

        if(Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Can't find footer element 'View article in browser' link",
                    300);
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find end of the article",
            300);
        }
    }

    public void addFirstArticleToMyList(){

    this.waitForElementAndClick(
    SAVE_BUTTON,
    "Cannot click [Save] button in tab bar",
    10);

    this.waitForElementAndClick(
    ADD_TO_LIST_BUTTON,
    "Cannot click [ADD TO LIST] button",
    5);

    this.waitForElementAndClick(
    CREATE_NEW_LIST_BUTTON,
    "Cannot click [Create New] button",
    10);

    this.waitForElementAndSendKeys(
    NAME_OF_THE_LIST,
    NAME_OF_THE_LIST_VALUE,
    "Cannot find 'Name of the list' field",
    5);

    this.waitForElementAndSendKeys(
    DESCRIPTION_OF_THE_LIST,
    DESCRIPTION_OF_THE_LIST_VALUE,
    "Cannot find 'Name of the list' field",
    5);

    this.waitForElementAndClick(
    OK_BUTTON,
    "Cannot find 'Description of the list' field",
    5);

    this.waitForElementAndClick(
    VIEW_LIST_BUTTON,
    "Cannot find [VIEW LIST] button",
    5);

    this.waitForElementPresent(
    FIRST_ARTICLE_TITLE,
    "Cannot find saved article",
    10);
    }

    public void addSecondArticleToMyList(){

//    this.waitForElementAndSendKeys(
//    SEARCH_INIT_ELEMENT,
//    SECOND_WORD_FOR_SEARCH,
//    "Cannot find search input",
//    5);
//
//    this.waitForElementPresent(
//    SECOND_ARTICLE_SEARCH_DESCRIPTION,
//    "Cannot find " + SECOND_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + SECOND_WORD_FOR_SEARCH,
//    12);
//
//    this.waitForElementAndClick(
//    SECOND_ARTICLE_SEARCH_DESCRIPTION,
//    "Cannot find article title description",
//    10);

    this.waitForElementAndClick(
    SAVE_BUTTON,
    "Cannot click [Save] button in tab bar",
    10);
    }

    public void addArticleToMySaved(){
    this.waitForElementAndClick(
    SAVE_BUTTON,
    "Cannot close article, cannot find option to add article to the reading list",
    12
     );

    this.waitForElementAndClick(
    CLOSE_SYNC_POP_UP_BUTTON,
    "Cannot tap [x] button on 'Sync your saved articles' pop up",
    10);
    }

    public void addSecondArticleToSaved(){

    this.waitForElementAndSendKeys(
    SEARCH_INIT_ELEMENT,
    SECOND_WORD_FOR_SEARCH,
    "Cannot find search input",
    5);

    this.waitForElementPresent(
    SECOND_ARTICLE_SEARCH_DESCRIPTION,
    "Cannot find " + SECOND_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + SECOND_WORD_FOR_SEARCH,
    12);

    this.waitForElementAndClick(
    SECOND_ARTICLE_SEARCH_DESCRIPTION,
    "Cannot find article title description",
    10);

    this.waitForElementAndClick(
    SAVE_BUTTON,
    "Cannot close article, cannot find option to add article to the reading list",
    12);
    }

    public void articleTitleAfterBackground(){

    this.waitForElementPresent(
    FIRST_ARTICLE_TITLE,
    "Cannot find article title after being in background",
    10);
    }

}
