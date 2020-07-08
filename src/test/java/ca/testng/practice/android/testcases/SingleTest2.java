package ca.testng.practice.android.testcases;
import ca.testng.practice.android.testcases.AndroidBaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SingleTest2 extends AndroidBaseTest {
    private Object AndroidDriver;

    //Sharon practice - find overflow menu, go to Settings and click About link
    @Test
    public void test() throws InterruptedException {


        // Write test in this...
        logger.atInfo().log("Starting Test...");
        //find overflow button
        WebElement overflow = driver.findElement(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button"));
        overflow.click();
        //find settings button
        WebElement settings = driver.findElement(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings"));
        settings.click();


        //scroll on page to find About
        //calculate top and bottom of screen

        Dimension size = driver.manage().window().getSize();
        int middleX = (int) (size.getWidth() * 0.5);
        int bottomY = (int) (size.getHeight() * 0.8);
        int topY = (int) (size.getHeight() * 0.3);

        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
                .perform();

        //find About Wiki app link and click
        WebElement about = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='About the Wikipedia app']"));
        about.click();

        //hit Android Back button
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));




    }

}
