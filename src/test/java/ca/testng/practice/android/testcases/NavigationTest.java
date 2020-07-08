package ca.testng.practice.android.testcases;

import ca.testng.practice.android.testcases.AndroidBaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavigationTest extends AndroidBaseTest {

    //Skip onboarding

    @Test
    public void test() {

        //wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Skip onboarding


        WebElement skip = driver.findElement(MobileBy.id("com.shawmedia.smglobal:id/left_button"));
        skip.click();

        //wait for Home page elements to load
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Find rotator element and get size of element
        WebElement rotator = driver.findElement(MobileBy.id("com.shawmedia.smglobal:id/rotator_image"));
        //Determine rotator size
        Dimension rotatorSize = rotator.getSize();
        // Determine start and end co-ordinates for horizontal swipe
        int startX = (int) (rotatorSize.getWidth() * 0.8);
        int startY = (int) (rotatorSize.getHeight() * 0.5);
        int endX = (int) (rotatorSize.getWidth() * 0.1);
        int endY = (int) (rotatorSize.getHeight() * 0.5);

        //Swipe from start to end co-ordinates
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endX, endY)).release()
                .perform();

        //wait for next swipe
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Tap on rotator to deeplink to item
        rotator.click();

        //wait for selected item to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //find first locked thumbnail container
        WebElement thumbnail = driver.findElements(MobileBy.id("com.shawmedia.smglobal:id/detail_page_video_art_view")).get(1);
        thumbnail.click();

        //wait for BDU selector window to appear for sign-in flow
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //once BDU selector page loads, select provider Shaw
        WebElement bdu = driver.findElements(MobileBy.id("com.shawmedia.smglobal:id/mvpd_logo")).get(1);
        bdu.click();
        //wait for provider page to load
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //set default browser for provider page in web view
        WebElement browser = driver.findElements(MobileBy.id("android:id/icon")).get(1);
        browser.click();

        WebElement browserOption = driver.findElement(MobileBy.id("android:id/button_always"));
        browserOption.click();























    }


}
