package tests;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.PageObjects.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

    if (Platform.getInstance().isAndroid()){
        return;
    }

    WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
    WelcomePageObject.waitForLearnMoreLink();
    WelcomePageObject.clickNextButton();

    WelcomePageObject.waitForNewWaysToExploreText();
    WelcomePageObject.clickNextButton();

    WelcomePageObject.waitForAddOrEditPreferredLanguageText();
    WelcomePageObject.clickNextButton();

    WelcomePageObject.waitForLearnMoreDataCollectedText();
    WelcomePageObject.clickGetStartedButton();
    }

    @Test
    public void testSkipWelcomePages(){
    WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
    WelcomePageObject.clickSkip();
    }
}
