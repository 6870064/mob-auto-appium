package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class NavigationUI extends MainPageObject{

    public NavigationUI (AppiumDriver driver) {
        super(driver);
    }

    private static final String
    BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
    CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']",
    SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]";

    public void backFromSaveList(){

        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot click [<] button the first time",
                5);

        this.waitForElementPresent(
                By.xpath(BACK_BUTTON),
                "Cannot find [<] button",
                5);

        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot click [<] button the second time",
                5);

        this.waitForElementAndClick(
                By.xpath(CANCEL_SEARCH_BUTTON),
                "Cannot find [X] button on the page",
                5);

        this.waitForElementPresent(
                By.xpath(SEARCH_INIT_ELEMENT),
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
