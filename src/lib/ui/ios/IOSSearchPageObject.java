package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    static {
    SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
    SEARCH_INIT_ELEMENT = "xpath:////XCUIElementTypeSearchField[@name='Search Wikipedia']";
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
    WORD_FOR_EMPTY_SEARCH = "Bla zzz qwerty";
    CANCEL_SEARCH_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
    NO_RESULTS_STRING = "xpath://XCUIElementTypeStaticText[@name='No results found']";
    NOT_EMPTY_SEARCH_VALUE = "Rammstein discography";
    NOT_EMPTY_SEARCH_LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']";
    }
}
