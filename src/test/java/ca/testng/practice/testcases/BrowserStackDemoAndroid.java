package ca.testng.practice.testcases;

import java.net.URL;
        import java.util.List;
        import java.net.MalformedURLException;

        import io.appium.java_client.MobileBy;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidElement;

        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackDemoAndroid {

    public static String userName = "elena605";
    public static String accessKey = "J1p5G99KyrpQWLxyN9fb";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S8 Plus");
        caps.setCapability("os_version", "7.0");
        caps.setCapability("project", "My First Android Project");
        caps.setCapability("build", "My First  Android Build");
        caps.setCapability("name", "Android Sample Test");
        caps.setCapability("app", "bs://e34a6ac7a8319954524ef62e4ee4b6df67e9a311");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Find Me");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert(allProductsName.size() > 0);

        driver.quit();
    }
}
