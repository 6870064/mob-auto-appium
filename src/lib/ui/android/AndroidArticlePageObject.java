package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

   static {
   FIRST_ARTICLE_TITLE = "xpath://*[contains(@text,'Java (programming language)')]";
   SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
   SECOND_ARTICLE_SEARCH_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@text='German industrial metal band']";
   FOOTER_ELEMENT = "xpath://*[contains(@text,'View article in browser')]";
   SAVE_BUTTON = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/article_menu_bookmark']";
   ADD_TO_LIST_BUTTON = "xpath://*[contains(@text,'ADD TO LIST')]";
   CREATE_NEW_LIST_BUTTON = "xpath://*[contains(@text,'Create new')]";
   NAME_OF_THE_LIST = "xpath://*[contains(@text,'Name of this list')]";
   DESCRIPTION_OF_THE_LIST = "xpath://*[contains(@text,'Description (optional)')]";
   OK_BUTTON = "xpath://*[contains(@text,'OK')]";
   VIEW_LIST_BUTTON = "xpath://*[contains(@text,'VIEW LIST')]";
   SECOND_WORD_FOR_SEARCH = "Rammstein";
   NAME_OF_THE_LIST_VALUE = "First list title";
   DESCRIPTION_OF_THE_LIST_VALUE = "First list description";
   }

   public AndroidArticlePageObject(AppiumDriver driver){
       super(driver);
   }
}
