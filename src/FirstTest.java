import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception{
    super.setUp();

    MainPageObject = new MainPageObject(driver);
    }

    public String Article_description = "Object-oriented programming language";

    @Test
    public void testArticleSearch() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.searchWikipediaClick();
    SearchPageObject.searchArticleTitle();
    SearchPageObject.waitForSearchResult(Article_description);
    }

    @Test
    public void testCancelSearch(){ // Ex3 Hometask

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.skipButtonClick();
    SearchPageObject.searchWikipediaClick();
    SearchPageObject.searchArticleTitle();
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
    SearchPageObject.searchWikipediaClick();
    SearchPageObject.searchArticleTitle();
    SearchPageObject.waitForSearchResult(Article_description);
    SearchPageObject.compareArticleTitle();
   }
//
//    @Test
//    public void testArticleSwipe(){
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.searchArticleTitle();
//    MainPageObject.clickArticleOpen();
//
//    int amountOfSwipes = 12;
//
//    for (int i = 0; i <=amountOfSwipes; i++){
//     MainPageObject.swipeUp(2000);
//     }
//    }
//
//    @Test
//    public void testArticleSwipeToFooter(){
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.searchArticleTitle();
//    MainPageObject.clickArticleOpen();
//    MainPageObject.swipeUpToElement();
//    }
//
//    @Test
//    public void testEmptySearch(){
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.searchWithEmptyResult();
//    }
//
//    @Test
//    public void testSaveOneArticle(){
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.saveFirstArticle();
//    }
//
//    @Test
//    public void testSaveTwoArticles(){ // Ex5: Тест: сохранение двух статей
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.saveFirstArticle();
//    MainPageObject.backFromSaveList();
//    MainPageObject.saveSecondArticle();
//    MainPageObject.swipeArticleToDelete();
//    MainPageObject.articleAvailabilityCheck();
//    }
//
//    @Test
//    public void testAmountOfNotEmptySearch(){ //Ex6: Тест: Assert Title
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.assertTitleCheck();
//    }
//
//    @Test
//   public void testFirstTestToRotate(){ //Ex7*: Поворот экрана. Первый тест, который падает
//   MainPageObject.skipButtonClick();
//   MainPageObject.searchWikipediaClick();
//   MainPageObject.searchArticleTitle();
//   MainPageObject.rotateToLandscape();
//   MainPageObject.clickArticleOpen();
//
//   }
//
//  @Test
//  public void testSecondTestToRotate(){ //Ex7*: Поворот экрана. Второй тест, который не падает
//  MainPageObject.skipButtonClick();
//  MainPageObject.searchWikipediaClick();
//  MainPageObject.rotateToLandscape();
//  MainPageObject.rotateToPortrait();
//   }
//
//    @Test
//    public void testAppInBackground(){
//    MainPageObject.skipButtonClick();
//    MainPageObject.searchWikipediaClick();
//    MainPageObject.searchArticleTitle();
//    MainPageObject.clickArticleOpen();
//    MainPageObject.appInBackground();
//    MainPageObject.articleTitleAfterBackground();
//    }




}