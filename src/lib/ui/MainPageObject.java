package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
    FIRST_WORD_FOR_SEARCH = "Java",
    FIRST_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Object-oriented programming language']",
    SECOND_WORD_FOR_SEARCH = "Rammstein",
    SECOND_ARTICLE_SEARCH_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='German industrial metal band']",
    CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']",
    FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]",
    SECOND_ARTICLE_TITLE = "//*[contains(@text,'Rammstein')]",
    FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]",
    SAVE_BUTTON = "//android.widget.TextView[@resource-id='org.wikipedia:id/article_menu_bookmark']",
    ADD_TO_LIST_BUTTON = "//*[contains(@text,'ADD TO LIST')]",
    CREATE_NEW_LIST_BUTTON = "//*[contains(@text,'Create new')]",
    NAME_OF_THE_LIST = "//*[contains(@text,'Name of this list')]",
    DESCRIPTION_OF_THE_LIST = "//*[contains(@text,'Description (optional)')]",
    OK_BUTTON = "//*[contains(@text,'OK')]",
    NAME_OF_THE_LIST_VALUE = "First list title",
    DESCRIPTION_OF_THE_LIST_VALUE = "First list description",
    LIST_TITLE_ON_READING_LIST_POP_UP = "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title']",
    BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
    VIEW_LIST_BUTTON = "//*[contains(@text,'VIEW LIST')]",
    NO_RESULTS_STRING = "//android.widget.TextView[@resource-id='org.wikipedia:id/results_text']",
    NOT_EMPTY_SEARCH_VALUE = "Rammstein discography",
    NOT_EMPTY_SEARCH_LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_container']";


    public String compareArticleTitle(){  //03 Первые тесты на Android/video 10. Assertions.

        this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find article title",
                10);

        this.waitForElementAndClick(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot click article title description",
                10);

        WebElement title_element = waitForTitleElement();
        return title_element.getText();
    }

    public void articleTitleAfterBackground(){

        this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find article title after being in background",
                10);
    }

    public void clickArticleOpen(){

        this.waitForElementAndClick(
                By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find article title description",
                10);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find article title on the page",
                5);
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds){ //поиск элемента и ожидание его появления
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); //метод Selenium
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String error_message){ //Перегруженный метод поиска элемента по Xpath и ожидание его появления
        return waitForElementPresent(by, error_message,5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementByIdAndClick(By by, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и введение в него текста
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds){ //Метод, определяющий отсутствие элемента на странице
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds){ //Метод, очищающий элемент от информации, которую ввели мы или которая была введена до нас
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe){
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


    public void saveFirstArticle(){

        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INIT_ELEMENT),
                FIRST_WORD_FOR_SEARCH,
                "Cannot find search input",
                5);

        this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find " + FIRST_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + FIRST_WORD_FOR_SEARCH,
                12);

        this.waitForElementAndClick(
                By.xpath(FIRST_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find article title description",
                10);

        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot click [Save] button in tab bar",
                10);

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST_BUTTON),
                "Cannot click [ADD TO LIST] button",
                5);

        this.waitForElementAndClick(
                By.xpath(CREATE_NEW_LIST_BUTTON),
                "Cannot click [Create New] button",
                10);

        this.waitForElementAndSendKeys(
                By.xpath(NAME_OF_THE_LIST),
                NAME_OF_THE_LIST_VALUE,
                "Cannot find 'Name of the list' field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath(DESCRIPTION_OF_THE_LIST),
                DESCRIPTION_OF_THE_LIST_VALUE,
                "Cannot find 'Name of the list' field",
                5);

        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Cannot find 'Description of the list' field",
                5);

        this.waitForElementAndClick(
                By.xpath(VIEW_LIST_BUTTON),
                "Cannot find [VIEW LIST] button",
                5);

        this.waitForElementPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find saved article",
                10);
    }

    public void saveSecondArticle(){

        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INIT_ELEMENT),
                SECOND_WORD_FOR_SEARCH,
                "Cannot find search input",
                5);

        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find " + SECOND_ARTICLE_SEARCH_DESCRIPTION + " topic searching by " + SECOND_WORD_FOR_SEARCH,
                12);

        this.waitForElementAndClick(
                By.xpath(SECOND_ARTICLE_SEARCH_DESCRIPTION),
                "Cannot find article title description",
                10);

        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot click [Save] button in tab bar",
                10);

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST_BUTTON),
                "Cannot click [ADD TO LIST] button",
                5);

        this.waitForElementPresent(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        this.waitForElementAndClick(
                By.xpath(LIST_TITLE_ON_READING_LIST_POP_UP),
                "Cannot open articles list",
                10);

        this.waitForElementAndClick(
                By.xpath(VIEW_LIST_BUTTON),
                "Cannot find [VIEW LIST] button",
                5);

        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_TITLE),
                "Cannot find the second saved article",
                10);
    }

    public void backFromSaveList(){

        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot click [<] button the first time",
                5);

        this.waitForElementPresent(
                By.xpath(BACK_BUTTON),
                "Cannot find [<] button",
                5);

        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot click [<] button the second time",
                5);

        this.waitForElementAndClick(
                By.xpath(CANCEL_SEARCH_BUTTON),
                "Cannot find [X] button on the page",
                5);

        this.waitForElementPresent(
                By.xpath(SEARCH_INIT_ELEMENT),
                "Cannot find 'Search Wikipedia' field",
                5);

    }

    public void swipeArticleToDelete(){

        this.swipeElementToTheLeft(
                By.xpath(FIRST_ARTICLE_TITLE),
                "Cannot find saved first article");

        this.waitForElementNotPresent(
                By.xpath(FIRST_ARTICLE_TITLE),
                "First article is still presented in the saved list",
                12);
    }

    public void articleAvailabilityCheck(){
        this.waitForElementPresent(
                By.xpath(SECOND_ARTICLE_TITLE),
                "Cannot find the second article titled " + SECOND_WORD_FOR_SEARCH,
                12);
    }

    public void swipeUpToFindElement(By by, String error_message, int max_swipes){ //метод свайпа до заданного элемента (например, свайп вверх до футера, низа страницы).
        int already_swiped = 0;
        while (driver.findElements(by).size()==0){

            if (already_swiped > max_swipes){
                this.waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message,0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeElementToTheLeft(By by, String error_message){
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) /2;

        TouchAction action = new TouchAction(driver);

        action.
                press(PointOption.point(right_x,middle_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(300))).
                moveTo(PointOption.point(left_x, middle_y)).
                release().
                perform();
    }
    public void appInBackground(){
        driver.runAppInBackground(Duration.ofSeconds(3));
    }

    private int getAmountOfElements(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertTitleCheck(){
        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INIT_ELEMENT),
                NOT_EMPTY_SEARCH_VALUE,
                "Cannot find search input",
                10);

        this.waitForElementPresent(
                By.xpath(NOT_EMPTY_SEARCH_LOCATOR),
                "Cannot find anything by the request " + NOT_EMPTY_SEARCH_VALUE,
                10);

        int amount_of_search_results = getAmountOfElements(
                By.xpath(NOT_EMPTY_SEARCH_LOCATOR)
        );

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results >0);
    }

    public void rotateToLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateToPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

}
