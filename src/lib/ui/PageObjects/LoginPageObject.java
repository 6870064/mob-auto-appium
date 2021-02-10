package lib.ui.PageObjects;

import io.appium.java_client.AppiumDriver;

abstract public class LoginPageObject extends MainPageObject {

    protected static String
    LOG_IN_TO_SYNC_BUTTON,
    ENTER_USERNAME_FIELD,
    ENTER_PASSWORD_FIELD,
    USER_LOGIN,
    USER_PASSWORD,
    LOG_IN_BUTTON,
    CLOSE_SYNC_POP_UP_BUTTON;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void userLogin(){

    this.waitForElementAndClick(
    LOG_IN_TO_SYNC_BUTTON,
    "Cannot click Log in button",
    10);

    this.waitForElementAndSendKeys(
    ENTER_USERNAME_FIELD,
    USER_LOGIN,
   "Cannot send user login",
   10);

   this.waitForElementAndSendKeys(
   ENTER_PASSWORD_FIELD,
   USER_PASSWORD,
   "Cannot send user password",
   10);

   this.waitForElementAndClick(
   LOG_IN_BUTTON,
   "Cannot click [Log in] button",
   10);

   this.waitForElementAndClick(
   CLOSE_SYNC_POP_UP_BUTTON,
   "Cannot click [x] on pop up",
   10);
    }
}
