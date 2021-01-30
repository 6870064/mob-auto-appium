package tests;
import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

    if (this.Platform.isAndroid()){
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
    WelcomePageObject.clickSearchInput();
    }
}
