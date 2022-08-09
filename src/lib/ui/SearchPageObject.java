package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{
    private static final String
            SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "(//*)[@text='{SUBSTRING}'][1]";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHOD (ЗАМЕНА ПОДСТРОКИ)*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHOD (ЗАМЕНА ПОДСТРОКИ)*/

    public void initSearchInput()
    {
        this.waitAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Не нахожу Поиск по Википедии", 5)
    }

    public void typeSearchLine(String search_line)
    {
        this.waitAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Не могу ввести Java", 5)
    }
    public void waitForResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Не нахожу результат: " + substring, 5)
    }

}
