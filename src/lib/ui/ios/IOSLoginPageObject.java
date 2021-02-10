package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.PageObjects.LoginPageObject;

public class IOSLoginPageObject extends LoginPageObject {

    public IOSLoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    static {
    LOG_IN_TO_SYNC_BUTTON = "id:Log in to sync your saved articles";
    ENTER_USERNAME_FIELD = "id:enter username";
    ENTER_PASSWORD_FIELD = "id:enter password";
    USER_LOGIN = "Dzmitry v";
    USER_PASSWORD = "meo12rnyk";
    LOG_IN_BUTTON = "id:Log in";
    CLOSE_SYNC_POP_UP_BUTTON = "id:places auth close";
    }
}
