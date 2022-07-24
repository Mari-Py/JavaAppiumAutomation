import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public class FirstTest {
    public AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("13081JECB06380")
                .setAppPackage("org.wikipedia")
                .setAppActivity(".main.MainActivity")
                .setApp("")
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
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
