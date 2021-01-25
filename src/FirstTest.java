import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception{
    super.setUp();

    MainPageObject = new MainPageObject(driver);
    }

    public String Article_description = "Object-oriented programming language";
    public String Expected_article_title = "Java (programming language)";
    public String First_word_for_search = "Java";
    public String Second_word_for_search = "Rammstein";
    public String Second_article_description = "German industrial metal band";

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

////    @Test
////    public void checkArticleTitle(){ //Ex4*: Тест: проверка слов в поиске
////        //Findelements
////    }
//
    @Test
    public void testCompareArticleTitle(){

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.initSearchInput();
    SearchPageObject.searchArticleTitle(First_word_for_search);
    SearchPageObject.clickByArticleWithSubstring(Article_description);

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String article_title = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
    "We see unexpected title",
    Expected_article_title,
    article_title);
   }

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
    public void testEmptySearch(){

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.skipButtonClick();
    SearchPageObject.initSearchInput();
    SearchPageObject.searchWithEmptyResult();
    }

    @Test
    public void testSaveOneArticle(){

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.initSearchInput();
    SearchPageObject.searchArticleTitle(First_word_for_search);
    SearchPageObject.clickByArticleWithSubstring(Article_description);

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addFirstArticleToMyList();
    }

   @Test
   public void testSaveTwoArticles(){ // Ex5: Тест: сохранение двух статей

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.initSearchInput();
    SearchPageObject.searchArticleTitle(First_word_for_search);
    SearchPageObject.clickByArticleWithSubstring(Article_description);

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
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

    @Test
    public void testAmountOfNotEmptySearch(){  //Ex6: Тест: Assert Title

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.initSearchInput();
    SearchPageObject.assertTitleCheck();
    }

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