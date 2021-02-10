package tests;

import lib.CoreTestCase;
import lib.ui.PageObjects.ArticlePageObject;
import lib.ui.PageObjects.NavigationUI;
import lib.ui.PageObjects.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import java.time.Duration;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testFirstTestToRotate(){ //Ex7*: Поворот экрана. Первый тест, который падает

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.rotateToLandscape();
        SearchPageObject.clickByArticleWithSubstring(Article_description);
    }

    @Test
    public void testSecondTestToRotate(){ //Ex7*: Поворот экрана. Второй тест, который не падает

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.rotateToLandscape();
        NavigationUI.rotateToPortrait();
    }

    @Test
    public void testAppInBackground(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.appInBackground(Duration.ofSeconds(3));

        ArticlePageObject.articleTitleAfterBackground();
    }
}
