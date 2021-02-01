package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    static {
    SKIP_BUTTON = "xpath://*[contains(@text,'SKIP')]";
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@text='{SUBSTRING}']";
    WORD_FOR_EMPTY_SEARCH = "Bla zzz qwerty";
    CANCEL_SEARCH_BUTTON = "xpath://android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']";
    NO_RESULTS_STRING = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/results_text']";
    NOT_EMPTY_SEARCH_VALUE = "Rammstein discography";
    NOT_EMPTY_SEARCH_LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']";
    }
}
