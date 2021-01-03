import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    String SKIP_BUTTON = "//*[contains(@text,'SKIP')]";
    String SEARCH_WIKIPEDIA = "//*[contains(@text,'Search Wikipedia')]";
    String WORD_FOR_SEARCH = "Java";
    String EMPTY_SEARCH = "Bla zzz bla qwe";
    String SEARCH_DESCRIPTION_ARTICLE = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Object-oriented programming language']";
    String CANCEL_SEARCH_BUTTON = "//android.widget.ImageView[@resource-id='org.wikipedia:id/search_close_btn']";

    private AppiumDriver driver; //обьявление новой переменной driver

    @Before
    public void setUp() throws Exception{ //установка всех необходимых параметров, чтобы запустить Appium driver и поднять апп на эмуляторе
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","10.0");
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
    searchWikipediaArticle();
    }

    @Test
    public void testCancelSearch(){
    skipButtonClick();
    searchWikipediaClick();
    searchWikipediaArticle();
    cancelSearchWikipediaArticle();
    }

    public void skipButtonClick(){
    waitForElementByXpathAndClick(
    SKIP_BUTTON,
    "Cannot find [SKIP] button",
    5);
    }

    public void searchWikipediaClick(){

   waitForElementByXpathAndClick(
    SEARCH_WIKIPEDIA,
    "Cannot find search input",
    5);
    }

    public void searchWikipediaArticle(){

   waitForElementByXpathAndSendKeys(
   SEARCH_WIKIPEDIA,
   WORD_FOR_SEARCH,
   "Cannot find search input",
   5);

   waitForElementPresentByXpath(
   SEARCH_DESCRIPTION_ARTICLE,
   "Cannot find " + SEARCH_DESCRIPTION_ARTICLE + " topic searching by " + WORD_FOR_SEARCH,
   12);
    }

    public void cancelSearchWikipediaArticle(){

    waitForElementByXpathAndClick(
    CANCEL_SEARCH_BUTTON,
    "Cannot find [x] cancel search button",
    10);

    waitForElementNotPresent(
    CANCEL_SEARCH_BUTTON,
    "[X] is still presented on the page",
    5);
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds){ //поиск элемента по Xpath и ожидание его появления
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); //метод Selenium
    wait.withMessage(error_message + "\n");
    By by = By.xpath(xpath);
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds){ //поиск элемента по Id и ожидание его появления
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); //метод Selenium
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message){ //Перегруженный метод поиска элемента по Xpath и ожидание его появления
        return waitForElementPresentByXpath(xpath, error_message,5);
    }

    private WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
    WebElement element = waitForElementPresentByXpath(xpath, error_message, timeOutInSeconds);
    element.click();
    return element;
    }

    private WebElement waitForElementByIdAndClick(String id, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
    WebElement element = waitForElementPresentById(id, error_message, timeOutInSeconds);
    element.click();
    return element;
    }

    private WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и введение в него текста
        WebElement element = waitForElementPresentByXpath(xpath, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(String id, String error_message, long timeoutInSeconds){ //Метод, определяющий отсутствие элемента на странице
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    By by = By.id(id);
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}


