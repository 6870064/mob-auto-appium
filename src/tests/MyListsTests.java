package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
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
        ArticlePageObject.addFirstArticleToMyList();
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
        ArticlePageObject.addFirstArticleToMyList();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.backFromSaveList();
        ArticlePageObject.addSecondArticleToMyList();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.myListsOpening();
        MyListsPageObject.swipeArticleToDelete();
        MyListsPageObject.articleAvailabilityCheck();
    }
}
