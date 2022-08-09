package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import junit.framework.TestCase;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://0.0.0.0:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("7BKDU17609005457")
                .setAppPackage("org.wikipedia")
                .setAppActivity(".main.MainActivity")
                .setApp("C:/Users/beret/IdeaProjects/JavaAppiumAutomation/apks/org.wikipedia_50413_apps.evozi.com.apk")
                .setNoReset(true);

        driver = new AndroidDriver(new URL(AppiumURL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
}
