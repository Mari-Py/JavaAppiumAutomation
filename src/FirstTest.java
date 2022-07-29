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
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();
        driver.findElement(By.id("org.wikipedia:id/search_src_text")).sendKeys("Java");
        driver.findElement(By.xpath("//*resource_id='org.wikipedia:id/page_list_item_description']" +
                "//*[@text='язык программирования']"));


        driver.findElement(By.xpath("//*resource_id='org." +
                "wikipedia:id/page_list_item_description']//*[@text='язык программирования']"));
    }

    private WebElement waitForElementByXpath(String xpath, String error_messege, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(error_messege + "\n");
        By by = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


}