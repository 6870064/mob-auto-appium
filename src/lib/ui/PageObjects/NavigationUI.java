package lib.ui.PageObjects;
import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;

abstract public class NavigationUI extends MainPageObject{

    public NavigationUI (AppiumDriver driver) {
        super(driver);
    }

    protected static String
    BACK_BUTTON,
    CANCEL_SEARCH_BUTTON,
    EXPLORE_BUTTON,
    SEARCH_INIT_ELEMENT;

    public void backFromSaveList(){

    if (Platform.getInstance().isAndroid()){
        this.waitForElementAndClick(
                BACK_BUTTON,
                "Cannot click [<] button the first time",
                5);

        this.waitForElementPresent(
                BACK_BUTTON,
                "Cannot find [<] button",
                5);

        this.waitForElementAndClick(
                BACK_BUTTON,
                "Cannot click [<] button the second time",
                5);

        this.waitForElementAndClick(
                CANCEL_SEARCH_BUTTON,
                "Cannot find [X] button on the page",
                5);

        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find 'Search Wikipedia' field",
                5);
    } else {
    this.waitForElementAndClick(
    BACK_BUTTON,
    "Cannot tap [<] Back button to return on the main screen",
    12);
    }
    }

    public void searchFieldClear(){
    this.waitForElementAndClick(
    CANCEL_SEARCH_BUTTON,
    "Cannot find and click Cancel search button",
   10);
    }


    public void appInBackground(Duration seconds){
        driver.runAppInBackground(Duration.ofSeconds(3));
    }

    public void rotateToLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateToPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

}
