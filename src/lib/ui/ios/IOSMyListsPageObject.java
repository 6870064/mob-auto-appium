package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
    ADD_TO_LIST_BUTTON = "xpath://*[contains(@text,'ADD TO LIST')]";
    LIST_TITLE_ON_READING_LIST_POP_UP = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title']";
    VIEW_LIST_BUTTON = "xpath://*[contains(@text,'VIEW LIST')]";
    FIRST_ARTICLE_TITLE = "xpath://*[contains(@text,'Java (programming language)')]";
    SECOND_ARTICLE_TITLE = "xpath://*[contains(@text,'Rammstein')]";
    SECOND_WORD_FOR_SEARCH = "Rammstein";
    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
