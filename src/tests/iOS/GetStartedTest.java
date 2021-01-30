package tests.iOS;
import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends iOSTestCase {

    @Test
    public void testPassThroughWelcome() {

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
    WelcomePageObject.clickSearchInput();
    }
}
