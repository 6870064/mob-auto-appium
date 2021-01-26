package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class iOSTestCase extends TestCase { //сможем использовать TestCase из JUnitFramework,класс Junit, который имеет методы для тестов (ассерты и тд)

    protected AppiumDriver driver; //обьявление новой переменной driver
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception{ //установка всех необходимых параметров, чтобы запустить Appium driver и поднять апп на эмуляторе

        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone X");
        capabilities.setCapability("platformVersion","11.4");
        capabilities.setCapability("app","/Users/dzmitryviachaslavau/Documents/MobileAutomationCourse/HomeTasks/mob-auto-appium/apks/Wikipedia.app");

        driver = new IOSDriver(new URL(AppiumURL), capabilities); //запуск iOS driver и передача ему capabilities
    }

    @Override
    protected void tearDown() throws Exception{ // tear down - метод используется, чтобы выключить Appium driver и закрыть апп на эмуляторе
        driver.quit();
        super.tearDown();
    }

}
