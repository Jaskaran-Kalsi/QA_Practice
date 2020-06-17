package ca.testng.practice.testcases;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserProfile extends BSBase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            //click Skip button
            WebElement skipButton = driver.findElement(MobileBy.AndroidUIAutomator("text(\"SKIP\")"));
            skipButton.click();
        } catch (Exception e) {
            System.out.println("Skip is not found");

        }

        //Thread.sleep(1000);

        driver.findElement(By.id("com.shawmedia.smglobal:id/profile_and_settings_button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("com.shawmedia.smglobal:id/setting_back_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.shawmedia.smglobal:id/profile_and_settings_button")).click();
        Thread.sleep(2000);

        MobileElement header = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/settings_activity_title"));
        String headerProfile = header.getText();
        System.out.println(headerProfile);

        MobileElement Messaging = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/authorized_brands_messaging"));
        String profileMessaging = Messaging.getText();
        System.out.println(profileMessaging);

        driver.findElement(By.id("com.shawmedia.smglobal:id/app_settings_button")).click();
        Thread.sleep(2000);

        //String tagName = header.getAttribute("text");
        //System.out.println("tagName");



    }
}
