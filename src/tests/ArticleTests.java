package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testArticleSwipe() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testArticleSwipeToFooter(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(Second_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Second_article_description);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testCompareArticleTitle(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.clickByArticleWithSubstring(Article_description);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
        "We see unexpected title",
        Expected_article_title,
        article_title);
    }

}
