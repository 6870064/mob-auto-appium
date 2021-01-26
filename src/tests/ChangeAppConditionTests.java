package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;
import java.time.Duration;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testFirstTestToRotate(){ //Ex7*: Поворот экрана. Первый тест, который падает

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.rotateToLandscape();
        SearchPageObject.clickByArticleWithSubstring(Article_description);
    }

    @Test
    public void testSecondTestToRotate(){ //Ex7*: Поворот экрана. Второй тест, который не падает

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.rotateToLandscape();
        NavigationUI.rotateToPortrait();
    }

    @Test
    public void testAppInBackground(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.appInBackground(Duration.ofSeconds(3));

        ArticlePageObject.articleTitleAfterBackground();
    }
}
