package ca.testng.practice.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author jkalsi - QA_Practice
 * @since May 05, 2020
 */
public class SingleTest extends BaseTest {
    @Test
    public void test() {
        String searchTerm = "Hello";
        // Write first test in this.
        logger.atInfo().log("Starting Test...");
        WebElement search = driver.findElement(MobileBy.AccessibilityId("Search Wikipedia"));
        search.click();

        WebElement searchBox = driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text"));
        searchBox.sendKeys(searchTerm);
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement pageTitle = driver.findElement(By.id("org.wikipedia.alpha:id/view_page_title_text"));
        Assert.assertEquals(pageTitle.getText(), searchTerm);
    }
}
