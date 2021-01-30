package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class NavigationUI extends MainPageObject{

    public NavigationUI (AppiumDriver driver) {
        super(driver);
    }

    private static final String
    BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    CANCEL_SEARCH_BUTTON = "xpath://android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']",
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";

    public void backFromSaveList(){

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
