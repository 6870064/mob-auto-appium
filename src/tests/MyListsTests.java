package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.PageObjects.*;
import lib.ui.factories.*;
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
   public void testLogin(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();

        LoginPageObject LoginPageObject = LoginPageObjectFactory.get(driver);
        LoginPageObject.userLogin();
    }

    @Test
    public void testSaveTwoArticles(){ // Ex5: Тест: сохранение двух статей

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipButtonClick();

        if (Platform.getInstance().isIOS()) {
            LoginPageObject LoginPageObject = LoginPageObjectFactory.get(driver);
            LoginPageObject.userLogin();
        }

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
        if (Platform.getInstance().isIOS()) {
            SearchPageObject.searchFieldClear();
        }
        SearchPageObject.searchArticleTitle(Second_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Second_article_description);

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addSecondArticleToMyList();
        } else {
            ArticlePageObject.addArticleToMySaved();
            NavigationUI.backFromSaveList();
        }

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.myListsOpening();
            MyListsPageObject.swipeArticleToDelete();
            MyListsPageObject.articleAvailabilityCheck();
        } else {
            MyListsPageObject.savedOpening();
        }
    }
}
