package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
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
}
