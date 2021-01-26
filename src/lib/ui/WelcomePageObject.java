package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE = "New ways to explore",
    STEP_ADD_OR_EDIT = "Add or edit preferred languages",
    STEP_LEARN_MORE_DATA = "Learn more about data collected",
    NEXT_BUTTON = "Next",
    GET_STARTED_BUTTON = "Get started";

    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(By.id(STEP_LEARN_MORE_LINK),"Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(By.id(NEXT_BUTTON),"Cannot find and click " +NEXT_BUTTON+ " button", 10);
    }

    public void waitForNewWaysToExploreText(){
        this.waitForElementPresent(By.id(STEP_NEW_WAYS_TO_EXPLORE),"Cannot find " + STEP_NEW_WAYS_TO_EXPLORE + " text", 10);
    }

    public void waitForAddOrEditPreferredLanguageText(){
        this.waitForElementPresent(By.id(STEP_ADD_OR_EDIT),"Cannot find " + STEP_ADD_OR_EDIT + " text", 10);
    }

    public void waitForLearnMoreDataCollectedText(){
        this.waitForElementPresent(By.id(STEP_LEARN_MORE_DATA),"Cannot find " + STEP_LEARN_MORE_DATA + " link", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(By.id(GET_STARTED_BUTTON),"Cannot find and click " +GET_STARTED_BUTTON+ " button", 10);
    }

}
