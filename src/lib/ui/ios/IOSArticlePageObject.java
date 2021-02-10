package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.PageObjects.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
    FIRST_ARTICLE_TITLE = "id:Java (programming language)";
    SEARCH_INIT_ELEMENT = "xpath:////XCUIElementTypeSearchField[@name='Search Wikipedia']";
    SECOND_ARTICLE_SEARCH_DESCRIPTION = "id:German industrial metal band";
    FOOTER_ELEMENT = "id:View article in browser";
    SAVE_BUTTON = "id:Save for later";
    ADD_TO_LIST_BUTTON = "Add to…";
    CREATE_NEW_LIST_BUTTON = "xpath://*[contains(@text,'Create new')]";
    NAME_OF_THE_LIST = "xpath://*[contains(@text,'Name of this list')]";
    DESCRIPTION_OF_THE_LIST = "xpath://*[contains(@text,'Description (optional)')]";
    ADD_FIRST_ARTICLE_TO_THE_LIST = "id:Add 'Java (programming language)' to a reading list?";
    OK_BUTTON = "xpath://*[contains(@text,'OK')]";
    ADD_BUTTON = "id:Add";
    READING_LIST_TITLE = "id:reading list title";
    OPTIONAL_SHORT_DESCRIPTION = "id:optional short description";
    CREATE_READING_LIST = "id: Create reading list";
    VIEW_LIST_BUTTON = "xpath://*[contains(@text,'VIEW LIST')]";
    SECOND_WORD_FOR_SEARCH = "Rammstein";
    NAME_OF_THE_LIST_VALUE = "First list title";
    DESCRIPTION_OF_THE_LIST_VALUE = "First list description";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
