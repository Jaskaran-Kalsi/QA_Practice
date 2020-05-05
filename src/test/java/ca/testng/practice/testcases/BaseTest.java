package ca.testng.practice.testcases;

import com.browserstack.local.Local;
import com.google.common.flogger.FluentLogger;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jkalsi - QA_Practice
 * @since May 05, 2020
 */
@SuppressWarnings("unchecked")
public class BaseTest {

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

        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
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

        driver = new AndroidDriver(new URL("http://"
                + username
                + ":"
                + accessKey
                + "@"
                + config.get("server")
                + "/wd/hub"), capabilities
        );
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
        if(local != null) local.stop();
        logger.atInfo().log("Test Ended...");
    }
}
