import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class FirstTest {

    String SKIP_BUTTON = "//*[contains(@text,'SKIP')]";
    String SEARCH_WIKIPEDIA = "//*[contains(@text,'Search Wikipedia')]";
    String FIRST_WORD_FOR_SEARCH = "Java";
    String FIRST_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Object-oriented programming language']";
    String SECOND_WORD_FOR_SEARCH = "Rammstein";
    String SECOND_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='German industrial metal band']";
    String WORD_FOR_EMPTY_SEARCH = "Bla zzz qwerty";
    String CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']";
    String FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]";
    String SECOND_ARTICLE_TITLE = "//*[contains(@text,'Rammstein')]";
    String FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]";
    String SAVE_BUTTON = "//android.widget.TextView[@resource-id='org.wikipedia:id/article_menu_bookmark']";
    String ADD_TO_LIST_BUTTON = "//*[contains(@text,'ADD TO LIST')]";
    String CREATE_NEW_LIST_BUTTON = "//*[contains(@text,'Create new')]";
    String NAME_OF_THE_LIST = "//*[contains(@text,'Name of this list')]";
    String DESCRIPTION_OF_THE_LIST = "//*[contains(@text,'Description (optional)')]";
    String OK_BUTTON = "//*[contains(@text,'OK')]";
    String NAME_OF_THE_LIST_VALUE = "First list title";
    String DESCRIPTION_OF_THE_LIST_VALUE = "First list description";
    String LIST_TITLE_ON_READING_LIST_POP_UP = "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title']";
    String BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";
    String VIEW_LIST_BUTTON = "//*[contains(@text,'VIEW LIST')]";
    String NO_RESULTS_STRING = "//android.widget.TextView[@resource-id='org.wikipedia:id/results_text']";

    private AppiumDriver driver; //обьявление новой переменной driver

    @Before
    public void setUp() throws Exception{ //установка всех необходимых параметров, чтобы запустить Appium driver и поднять апп на эмуляторе
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/dzmitryviachaslavau/Documents/MobileAutomationCourse/HomeTasks/mob-auto-appium/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //запуск Android driver и передача ему capabilities
    }

    @After
    public void tearDown(){ // tear down - метод используется, чтобы выключить Appium driver и закрыть апп на эмуляторе
        driver.quit();
    }

    @Test
    public void testArticleSearch() {
    skipButtonClick();
    searchWikipediaClick();
    searchArticleTitle();
    }

    @Test
    public void testCancelSearch(){ // Ex3 Hometask
    skipButtonClick();
    searchWikipediaClick();
    searchArticleTitle();
    cancelArticleSearch();
    }

//    @Test
//    public void checkArticleTitle(){ //Ex4*: Тест: проверка слов в поиске
//        //Findelements
//    }

    @Test
    public void testCompareArticleTitle(){
    skipButtonClick();
    searchWikipediaClick();
    searchArticleTitle();
    compareArticleTitle();
    }

    @Test
    public void testArticleSwipe(){
    skipButtonClick();
    searchWikipediaClick();
    searchArticleTitle();
    clickArticleOpen();

    int amountOfSwipes = 12;

    for (int i = 0; i <=amountOfSwipes; i++){
    swipeUp(2000);
     }
    }

    @Test
    public void testArticleSwipeToFooter(){
        skipButtonClick();
        searchWikipediaClick();
        searchArticleTitle();
        clickArticleOpen();
        swipeUpToElement();
    }

    @Test
    public void testEmptySearch(){
        skipButtonClick();
        searchWikipediaClick();
        searchWithEmptyResult();
    }

    @Test
    public void testSaveOneArticle(){
    skipButtonClick();
    searchWikipediaClick();
    saveFirstArticle();
    }

    @Test
    public void testSaveTwoArticles(){
    skipButtonClick();
    searchWikipediaClick();
    saveFirstArticle();
    backFromSaveList();
    saveSecondArticle();

    }

    //navigationBack();
    //        cancelArticleSearch();

    public void skipButtonClick(){
    waitForElementAndClick(
    By.xpath(SKIP_BUTTON),
    "Cannot find [SKIP] button",
    5);
    }

    public void searchWikipediaClick(){

   waitForElementAndClick(
   By.xpath(SEARCH_WIKIPEDIA) ,
   "Cannot find search input",
   5);
    }

    public void searchArticleTitle(){

   waitForElementAndSendKeys(
   By.xpath(SEARCH_WIKIPEDIA),
           FIRST_WORD_FOR_SEARCH,
   "Cannot find search input",
   5);

   waitForElementPresent(
   By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
   "Cannot find " + FIRST_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + FIRST_WORD_FOR_SEARCH,
   12);
    }

    public void searchWithEmptyResult(){

    waitForElementAndSendKeys(
    By.xpath(SEARCH_WIKIPEDIA),
    WORD_FOR_EMPTY_SEARCH,
    "Cannot find search input",
    5);

    waitForElementPresent(
    By.xpath(NO_RESULTS_STRING),
    "Cannot find " + NO_RESULTS_STRING + " topic searching by " + WORD_FOR_EMPTY_SEARCH,
    12);
    }

    public void cancelArticleSearch(){

    waitForElementAndClick(
    By.xpath(CANCEL_SEARCH_BUTTON),
    "Cannot find [x] cancel search button",
    10);

    waitForElementNotPresent(
    By.xpath(CANCEL_SEARCH_BUTTON),
    "[X] is still presented on the page",
    5);
    }

    public String compareArticleTitle(){  //03 Первые тесты на Android/video 10. Assertions.

    waitForElementAndClick(
    By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
    "Cannot find article title description",
    10);

    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
    }

    public void clickArticleOpen(){

    waitForElementAndClick(
    By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
    "Cannot find article title description",
    10);
    }

    public WebElement waitForTitleElement() {
    return waitForElementPresent(
    By.xpath(FIRST_ARTICLE_TITLE),
    "Cannot find article title on the page",
    5);
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds){ //поиск элемента и ожидание его появления
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); //метод Selenium
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message){ //Перегруженный метод поиска элемента по Xpath и ожидание его появления
        return waitForElementPresent(by, error_message,5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
    WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
    element.click();
    return element;
    }

    private WebElement waitForElementByIdAndClick(By by, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
    WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
    element.click();
    return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и введение в него текста
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds){ //Метод, определяющий отсутствие элемента на странице
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds){ //Метод, очищающий элемент от информации, которую ввели мы или которая была введена до нас
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe){
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * 0.8);
    int end_y = (int) (size.height * 0.2);

    action.
    press(PointOption.point(x, start_y)).
    waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe))).
    moveTo(PointOption.point(x, end_y)).
    release().
    perform();
    }

    protected void swipeUpQuick(){
        swipeUp(200);
    }

    protected void swipeUpToElement(){
    swipeUpToFindElement(
    By.xpath(FOOTER_ELEMENT),
    "Can't find footer element 'View article in browser' link",
    30);
    }

    protected void saveFirstArticle(){

    waitForElementAndSendKeys(
    By.xpath(SEARCH_WIKIPEDIA),
            FIRST_WORD_FOR_SEARCH,
    "Cannot find search input",
    5);

    waitForElementPresent(
    By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
    "Cannot find " + FIRST_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + FIRST_WORD_FOR_SEARCH,
     12);

     waitForElementAndClick(
     By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
     "Cannot find article title description",
     10);

    waitForElementAndClick(
    By.xpath(SAVE_BUTTON),
    "Cannot click [Save] button in tab bar",
    10);

    waitForElementAndClick(
    By.xpath(ADD_TO_LIST_BUTTON),
    "Cannot click [ADD TO LIST] button",
    5);

    waitForElementAndClick(
    By.xpath(CREATE_NEW_LIST_BUTTON),
    "Cannot click [Create New] button",
    10);

    waitForElementAndSendKeys(
    By.xpath(NAME_OF_THE_LIST),
    NAME_OF_THE_LIST_VALUE,
   "Cannot find 'Name of the list' field",
   5);

    waitForElementAndSendKeys(
    By.xpath(DESCRIPTION_OF_THE_LIST),
    DESCRIPTION_OF_THE_LIST_VALUE,
    "Cannot find 'Name of the list' field",
    5);

    waitForElementAndClick(
    By.xpath(OK_BUTTON),
    "Cannot find 'Description of the list' field",
    5);

    waitForElementAndClick(
    By.xpath(VIEW_LIST_BUTTON),
    "Cannot find [VIEW LIST] button",
    5);

    waitForElementPresent(
    By.xpath(FIRST_ARTICLE_TITLE),
    "Cannot find saved article",
    10);
    }

    protected void saveSecondArticle(){

        waitForElementAndSendKeys(
                By.xpath(SEARCH_WIKIPEDIA),
                SECOND_WORD_FOR_SEARCH,
                "Cannot find search input",
                5);

        waitForElementPresent(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find " + SECOND_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + SECOND_WORD_FOR_SEARCH,
                12);

        waitForElementAndClick(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find article title description",
                10);

        waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot click [Save] button in tab bar",
                10);

        waitForElementAndClick(
                By.xpath(ADD_TO_LIST_BUTTON),
                "Cannot click [ADD TO LIST] button",
                5);

        waitForElementPresent(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        waitForElementAndClick(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        waitForElementAndClick(
                By.xpath(VIEW_LIST_BUTTON),
                "Cannot find [VIEW LIST] button",
                5);

        waitForElementPresent(
                By.xpath(SECOND_ARTICLE_TITLE),
                "Cannot find the second saved article",
                10);
    }

    public void backFromSaveList(){

    waitForElementAndClick(
    By.xpath(BACK_BUTTON),
    "Cannot click [<] button the first time",
    5);

    waitForElementPresent(
    By.xpath(BACK_BUTTON),
    "Cannot find [<] button",
    5);

    waitForElementAndClick(
    By.xpath(BACK_BUTTON),
    "Cannot click [<] button the second time",
    5);

    waitForElementAndClick(
    By.xpath(CANCEL_SEARCH_BUTTON),
    "Cannot find [X] button on the page",
   5);

    waitForElementPresent(
    By.xpath(SEARCH_WIKIPEDIA),
    "Cannot find 'Search Wikipedia' field",
    5);

    }


    protected void swipeUpToFindElement(By by, String error_message, int max_swipes){ //метод свайпа до заданного элемента (например, свайп вверх до футера, низа страницы).
    int already_swiped = 0;
    while (driver.findElements(by).size()==0){

    if (already_swiped > max_swipes){
    waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message,0);
    return;
        }
    swipeUpQuick();
    ++already_swiped;
        }
    }
}