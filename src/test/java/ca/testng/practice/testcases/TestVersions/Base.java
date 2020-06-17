package ca.testng.practice.testcases.TestVersions;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @author jkalsi - QA_Practice
 * @since May 21, 2020
 */
public class Base {

    static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException, InterruptedException {
        File fs = new File("/Users/ekotliar/Project/QA_Practice/src/test/resources/applications/android-release-build-4.0.0-405.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(5000);
        return driver;
    }

    public static void swipe() {
        // calculate bottom & top of the screen
        Dimension size = driver.manage().window().getSize();
        int middleX = (int) (size.getWidth() * 0.5);
        int bottomY = (int) (size.getHeight() * 0.8);
        int topY = (int) (size.getHeight() * 0.3);
        new TouchAction(driver)
                .press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(middleX, topY))
                .release()
                .perform();
    }


    public static void swipeHoriz() {
        // TODO Auto-generated method stub
        MobileElement elementFrom = driver.findElement(MobileBy.AndroidUIAutomator("description(\"Port Hope police hand out tickets to park-goers\")"));
        MobileElement elementTo = driver.findElement(MobileBy.AndroidUIAutomator("description(\"Watch out for loan scams during COVID-19 pandemic, experts warn\")"));


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

        }

    }

