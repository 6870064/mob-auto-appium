package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.PageObjects.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
    ADD_TO_LIST_BUTTON = "id:Add to...";
    LIST_TITLE_ON_READING_LIST_POP_UP = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title']";
    VIEW_LIST_BUTTON = "xpath://*[contains(@text,'VIEW LIST')]";
    FIRST_ARTICLE_TITLE = "id:Java (programming language)";
    SECOND_ARTICLE_TITLE = "id:Rammstein";
    SAVED_BUTTON = "id:Saved";
    EDIT_BUTTON = "id:Edit";
    FIRST_ARTICLE_CELL = "xpath://XCUIElementTypeLink[@name='Java (programming language) Object-oriented programming language']";
    SECOND_ARTICLE_CELL = "id:Rammstein German industrial metal band";
    SECOND_WORD_FOR_SEARCH = "Rammstein";
    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
