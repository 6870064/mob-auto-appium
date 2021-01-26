package tests;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testEmptySearch(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchWithEmptyResult();
    }

    @Test
    public void testArticleSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.waitForSearchResult(Article_description);
    }

    @Test
    public void testCancelSearch(){ // Ex3 Hometask

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchArticleTitle(First_word_for_search);
        SearchPageObject.waitForSearchResult(Article_description);
        SearchPageObject.cancelArticleSearch();
    }

    @Test
    public void testAmountOfNotEmptySearch(){  //Ex6: Тест: Assert Title

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipButtonClick();
        SearchPageObject.initSearchInput();
        SearchPageObject.assertTitleCheck();
    }
}
