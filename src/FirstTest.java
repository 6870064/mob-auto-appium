import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class FirstTest {

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
    public void firstTest(){
        System.out.println("First test run");
    }
}


