package lib.ui.android;
import io.appium.java_client.AppiumDriver;
import lib.ui.PageObjects.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    static {
    BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    CANCEL_SEARCH_BUTTON = "xpath://android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']";
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
    }

    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
