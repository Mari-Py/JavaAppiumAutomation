import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        System.out.println("First test run");
    }
}
