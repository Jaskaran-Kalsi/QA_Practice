package ca.testng.practice.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.chrono.ChronoLocalDate;
import java.util.concurrent.TimeUnit;

/**
 * @author j kalsi - QA_Practice 
 * @since May 05, 2020
 */
public class SingleTest extends BaseTest {
    @Test
    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Write first test in this.
        logger.atInfo().log("Starting Test...");
        WebElement search = driver.findElement(MobileBy.AccessibilityId("Search Wikipedia"));
        search.click();

        WebElement searchBox = driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text"));
        searchBox.sendKeys("rohini");
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement pageTitle = driver.findElement(By.id("org.wikipedia.alpha:id/view_page_title_text"));
        Assert.assertEquals(pageTitle.getText(), "Rohini");
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));



        WebElement Button = driver.findElement(By.className("android.widget.ImageButton"));
        Button.click();

        //WebElement toolbar = driver.findElement(By.id("org.wikipedia.alpha:id/page_toolbar"));
        //toolbar.clear();
        //Thread.sleep(5000);

        WebElement logo = driver.findElement(By.id("org.wikipedia.alpha:id/view_list_card_header_menu"));
        logo.click();

        WebElement hide = driver.findElement(By.id("org.wikipedia.alpha:id/title"));
        hide.click();



        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"org.wikipedia.alpha:id/view_card_action_footer_button_text\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"SAVE\")"));

        //Perform the action on the element
         element.click();



        WebElement gotit = driver.findElement(By.id("org.wikipedia.alpha:id/onboarding_button"));
        gotit.click();

    }

}