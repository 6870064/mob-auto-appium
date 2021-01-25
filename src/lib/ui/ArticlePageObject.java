package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver){
    super(driver);
    }

    private static final String
    FIRST_ARTICLE_TITLE = "//*[contains(@text,'Java (programming language)')]",
    FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]";

    public WebElement waitForTitleElement(){
    return this.waitForElementPresent(By.xpath(FIRST_ARTICLE_TITLE), "Cannot find article on the page!", 15);
    }

    public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
    }

    public void swipeToFooter(){
    this.swipeUpToFindElement(
    By.xpath(FOOTER_ELEMENT),
    "Can't find footer element 'View article in browser' link",
    300);
    }

}
