package lib.ui.PageObjects;
import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE = "id:New ways to explore",
    STEP_ADD_OR_EDIT = "id:Add or edit preferred languages",
    STEP_LEARN_MORE_DATA = "id:Learn more about data collected",
    NEXT_BUTTON = "id:Next",
    GET_STARTED_BUTTON = "id:Get started",
    SKIP_BUTTON = "id:Skip",
    SEARCH_INIT_ELEMENT = "id:Search Wikipedia";

    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(NEXT_BUTTON,"Cannot find and click " +NEXT_BUTTON+ " button", 10);
    }

    public void waitForNewWaysToExploreText(){
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE,"Cannot find " + STEP_NEW_WAYS_TO_EXPLORE + " text", 10);
    }

    public void waitForAddOrEditPreferredLanguageText(){
        this.waitForElementPresent(STEP_ADD_OR_EDIT,"Cannot find " + STEP_ADD_OR_EDIT + " text", 10);
    }

    public void waitForLearnMoreDataCollectedText(){
        this.waitForElementPresent(STEP_LEARN_MORE_DATA,"Cannot find " + STEP_LEARN_MORE_DATA + " link", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(GET_STARTED_BUTTON,"Cannot find and click " +GET_STARTED_BUTTON+ " button", 10);
    }

    public void clickSkip(){
    this.waitForElementAndClick(
    SKIP_BUTTON,
    "Cannot find and tap [Skip] button",
    5);

    this.waitForElementPresent(
    SEARCH_INIT_ELEMENT,
    "Cannot find 'Search Wikipedia' input field",
    5);
    }

}
