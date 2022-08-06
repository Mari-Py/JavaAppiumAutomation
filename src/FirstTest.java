import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;


public class FirstTest {
    public AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("7BKDU17609005457")
                .setAppPackage("org.wikipedia")
                .setAppActivity(".main.MainActivity")
                .setApp("C:/Users/beret/IdeaProjects/JavaAppiumAutomation/apks/org.wikipedia_50413_apps.evozi.com.apk")
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Не нахожу Поиск по Википедии",
                5
                );
        waitAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Не могу ввести Java",
                5
                );

        waitForElementPresent(
                By.xpath("(//*)[@text='Java'][1]"),
                "Не нахожу Язык программирования в поиске Java",
                15
                );
    }

    @Test
    public void secondTest()
    {
        waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Не нахожу Поиск по Википедии",
                5
                );

        waitAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Не могу ввести Java",
                5
                );

        waitAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Не могу найти Х, чтобы закрыть поиск",
                5
                );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Х до сих пор присутствует на странице",
                5
                );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitAndClick(By by, String error_message, long timeout)
    {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.click();
        return element;
    }

    private WebElement waitAndSendKeys(By by, String value, String error_message, long timeout)
    {
        WebElement element = waitForElementPresent(by, error_message, timeout);
        element.sendKeys(value);
        return element;
    }

    private Boolean waitForElementNotPresent(By by, String error_messege, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(error_messege + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

}