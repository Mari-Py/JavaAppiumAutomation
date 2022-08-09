import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForResult("Java");
    }

    @Test
    public void testCancelSearch()
    {
        MainPageObject.waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Не нахожу Поиск по Википедии",
                5
                );

        MainPageObject.waitAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Не могу ввести Java",
                5
                );

        MainPageObject.waitAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Не могу найти Х, чтобы закрыть поиск",
                5
                );

        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Х до сих пор присутствует на странице",
                5
                );
    }

    @Test
    public void testCompareArticleTitle()
    {
        MainPageObject.waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Не нахожу Поиск по Википедии",
                5
        );
        MainPageObject.waitAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Не могу ввести Java",
                5
        );

        MainPageObject.waitAndClick(
                By.xpath("(//*)[@text='Java'][2]"),
                "Не могу найти Java",
                5
        );

        WebElement title_element = MainPageObject.waitForElementPresent(
                //By.id("pcs-edit-section-title-description"),
                By.xpath("(//*)[@text='язык программирования']"),
                "Не нахожу название статьи",
                10
        );

        String article_title = title_element.getText();

        Assert.assertEquals(
                "Мы видим не то название",
                "язык программирования",
                article_title
        );

    }




}