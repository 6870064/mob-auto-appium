package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase extends TestCase { //сможем использовать TestCase из JUnitFramework,класс Junit, который имеет методы для тестов (ассерты и тд)

    protected AppiumDriver driver; //обьявление новой переменной driver
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    public String Article_description = "Object-oriented programming language";
    public String Expected_article_title = "Java (programming language)";
    public String First_word_for_search = "Java";
    public String Second_word_for_search = "Rammstein";
    public String Second_article_description = "German industrial metal band";

    @Override
    protected void setUp() throws Exception{ //установка всех необходимых параметров, чтобы запустить Appium driver и поднять апп на эмуляторе

    super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("orientation","PORTRAIT");
        capabilities.setCapability("app","/Users/dzmitryviachaslavau/Documents/MobileAutomationCourse/HomeTasks/mob-auto-appium/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities); //запуск Android driver и передача ему capabilities
    }

    @Override
    protected void tearDown() throws Exception{ // tear down - метод используется, чтобы выключить Appium driver и закрыть апп на эмуляторе
    driver.quit();
    super.tearDown();
    }

}
