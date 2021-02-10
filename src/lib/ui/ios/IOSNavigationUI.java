package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.PageObjects.NavigationUI;

public class IOSNavigationUI extends NavigationUI {


    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }

    static {
    BACK_BUTTON = "id:Back";
    EXPLORE_BUTTON = "id:Explore";
    }
}
