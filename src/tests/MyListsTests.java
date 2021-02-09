package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    @Test
    public void testSaveOneArticle(){

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addFirstArticleToMyList();
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
    }

    @Test
    public void testSaveTwoArticles(){ // Ex5: Тест: сохранение двух статей

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addFirstArticleToMyList();
        } else {
            ArticlePageObject.addArticleToMySaved();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.backFromSaveList();

        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Second_article_description);

        ArticlePageObject.addSecondArticleToMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.myListsOpening();
        MyListsPageObject.swipeArticleToDelete();
        MyListsPageObject.articleAvailabilityCheck();
    }
}
