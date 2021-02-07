package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds){ //поиск элемента и ожидание его появления

    By by = this.getLocatorByString(locator);
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); //метод Selenium
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(String locator, String error_message){ //Перегруженный метод поиска элемента по Xpath и ожидание его появления
        return waitForElementPresent(locator, error_message,5);
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementByIdAndClick(String locator, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и клик по нему
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeOutInSeconds){ //Ожидание отображение элемента и введение в него текста
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds){ //Метод, определяющий отсутствие элемента на странице

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds){ //Метод, очищающий элемент от информации, которую ввели мы или которая была введена до нас
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
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

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes){ //метод свайпа до заданного элемента (например, свайп вверх до футера, низа страницы).

     By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size()==0){

            if (already_swiped > max_swipes){
                this.waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message,0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeElementToTheLeft(String locator, String error_message){
        WebElement element = waitForElementPresent(
                locator,
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

    private By getLocatorByString(String locator_with_type){  //Метод для определения типа локатора
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];  //В строку by_type передается первая часть разделенного локатора
        String locator = exploded_locator[1];  //В строку locator передается вторая часть разделенного локатора

        if (by_type.equals("xpath")){  // логика для разделенных локаторов
            return By.xpath(locator);
        } else if (by_type.equals("id")){
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locator_with_type);
        }
    }

    public int getAmountOfElements(String locator){  //Метод, определяющий кол-во элементов, которые мы нашли

        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes){

        int already_swiped = 0;

        while (!this.isElementLocatedOnTheScreen(locator)){
            if(already_swiped > max_swipes){
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }


    public boolean isElementLocatedOnTheScreen(String locator){
        int element_location_by_y = this.waitForElementPresent(
                locator,
                "Cannot find element by locator",
                1).
                getLocation().
                getY();
        int screen_size_by_y = driver.
                manage().
                window().
                getSize().
                getHeight();
        return element_location_by_y < screen_size_by_y;
    }
}
