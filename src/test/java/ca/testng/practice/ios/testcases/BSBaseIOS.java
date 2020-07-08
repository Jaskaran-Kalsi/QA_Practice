package ca.testng.practice.ios.testcases;

import com.browserstack.local.Local;
import com.google.common.flogger.FluentLogger;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ekotliar
 * @since May 05, 2020
 */
@SuppressWarnings("unchecked")
public class BSBaseIOS {

    /**
     * Test Name for the test being executed by current Thread.
     */
    private ThreadLocal<String> testName = new ThreadLocal<>();

    protected FluentLogger logger = FluentLogger.forEnclosingClass();

    public WebDriver driver;

    private Local local;

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"config", "environment"})
    public void setUpTest(String config_file, String environment, Method method, ITestContext iTestContext) throws Exception {

        // To read description for the test.
        Test test = method.getAnnotation(Test.class);

        // Set TestName to method name if description is missing.
        testName.set(test.description());

        if (testName.get().isEmpty()) {
            testName.set(method.getName());
        }

        iTestContext.setAttribute("testName", testName.get());
        logger.atInfo().log("Executing Test Case: [" + testName.get() + "]");

        if (config_file.toLowerCase().contains("local")) {
            localDriver(config_file, environment);
        } else {
            cloudDriver(config_file, environment);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        if (driver!=null) {
            driver.quit();
        }

        if(local != null) local.stop();
        logger.atInfo().log("Test Ended...");
    }

    public void cloudDriver(String config_file, String environment) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/ios/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            if (pair.getValue().toString().contains("Tab")) {
                capabilities.setCapability(MobileCapabilityType.ORIENTATION, "LANDSCAPE");
            }
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = (String) config.get("user");

        String accessKey = (String) config.get("key");

        String app = (String) config.get("app");
        if(app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }

        capabilities.setCapability("name", testName.get());

        if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
            local = new Local();
            Map<String, String> options = new HashMap<>();
            options.put("key", accessKey);
            local.start(options);
        }

        driver = new IOSDriver<IOSElement>(new URL("http://"
                + username
                + ":"
                + accessKey
                + "@"
                + config.get("server")
                + "/wd/hub"), capabilities
        );
    }

    public void localDriver(String config_file, String environment) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/ios/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                if (pair.getKey().toString().equalsIgnoreCase("app")) {
                    Path apkPath = Paths.get(pair.getValue().toString());
                    capabilities.setCapability(pair.getKey().toString(), apkPath.toAbsolutePath().toString());
                } else {
                    capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
                }
            }
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

        driver = new IOSDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    public void swipe() {
        // calculate bottom & top of the screen
        Dimension size = driver.manage().window().getSize();
        int middleX = (int) (size.getWidth() * 0.5);
        int bottomY = (int) (size.getHeight() * 0.8);
        int topY = (int) (size.getHeight() * 0.3);
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(middleX, topY))
                .release()
                .perform();
        logger.atInfo().log("Swipe Completed.");
    }



    public void swipeHorizontal(WebElement elementFrom, WebElement elementTo) {
        Point pFrom = elementFrom.getLocation();
        Point pTo = elementTo.getLocation();
        PointOption<ElementOption> pressOptionsFrom = new PointOption<>();
        pressOptionsFrom.withCoordinates(pFrom);
        PointOption<ElementOption> pressOptionsTo = new PointOption<>();
        pressOptionsTo.withCoordinates(pTo);
        TouchAction<AndroidTouchAction> action = new AndroidTouchAction((PerformsTouchActions) driver).
                longPress(pressOptionsFrom).
                moveTo(pressOptionsTo).
                release();
        action.perform();
        logger.atInfo().log("Scroll Completed.");
    }
/*
   //test to tap player for palyer controls
         public void tapPlayer(int x, int y) {
        new TouchAction((PerformsTouchActions) driver)
                .tap(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .perform();
    }
*/

}
