package lib;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.PageObjects.WelcomePageObject;

public class CoreTestCase extends TestCase { //сможем использовать TestCase из JUnitFramework,класс Junit, который имеет методы для тестов (ассерты и тд)

    protected AppiumDriver driver; //обьявление новой переменной driver
    public String Article_description = "Object-oriented programming language";
    public String Expected_article_title = "Java (programming language)";
    public String First_word_for_search = "Java";
    public String Second_word_for_search = "Rammstein";
    public String Second_article_description = "German industrial metal band";

    @Override
    protected void setUp() throws Exception{ //установка всех необходимых параметров, чтобы запустить Appium driver и поднять апп на эмуляторе

    super.setUp();
    driver = Platform.getInstance().getDriver();
//    this.skipeWelcomePageForIOSApp();
    }

    @Override
    protected void tearDown() throws Exception{ // tear down - метод используется, чтобы выключить Appium driver и закрыть апп на эмуляторе
    driver.quit();
    super.tearDown();
    }

    private void skipeWelcomePageForIOSApp(){
        if(Platform.getInstance().isIOS()){
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
