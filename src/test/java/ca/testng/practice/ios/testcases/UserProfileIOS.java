package ca.testng.practice.ios.testcases;
import ca.testng.practice.android.testcases.BSBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UserProfileIOS extends BSBaseIOS {
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
        // go to Profile and Settings screen
        driver.findElement(By.id("com.shawmedia.smglobal:id/profile_and_settings_button")).click();
        Thread.sleep(2000);
       // go back to main screen by Back button
        driver.findElement(By.id("com.shawmedia.smglobal:id/setting_back_button")).click();
        Thread.sleep(2000);
        // go to Profile and Settings screen
        driver.findElement(By.id("com.shawmedia.smglobal:id/profile_and_settings_button")).click();
        Thread.sleep(2000);
        //print out screen name
        MobileElement header = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/settings_activity_title"));
        String headerProfile = header.getText();
        System.out.println(headerProfile);
        //print out Message from Profile screen
        MobileElement Messaging = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/authorized_brands_messaging"));
        String profileMessaging = Messaging.getText();
        System.out.println(profileMessaging);
        // go to app settings screen
        driver.findElement(By.id("com.shawmedia.smglobal:id/app_settings_button")).click();
        Thread.sleep(2000);

        // go back to main screen by Back button
        driver.findElement(By.id("com.shawmedia.smglobal:id/setting_back_button")).click();
        Thread.sleep(2000);
        // go to About screen
        driver.findElement(By.id("com.shawmedia.smglobal:id/about_button")).click();

        // print out if Global Logo found
        MobileElement Logo = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/global_logo"));
        System.out.println("Global Logo is displayed");

       // print out app version
        MobileElement Version = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/about_app_version"));
        String AppVersion = Version.getText();
        System.out.println("App Version  " + AppVersion);


        Thread.sleep(2000);

       // go to Terms and conditions screen, select browser and back
        driver.findElement(By.id("com.shawmedia.smglobal:id/about_terms_condition")).click();



       //Below code should be activated when running on BS devices

            MobileElement popUpChrome = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Chrome\"]"));
            if (popUpChrome.isDisplayed()) {
                popUpChrome.click();
                MobileElement popUpButtonAlways = driver.findElement(By.id("android:id/button_always"));
                popUpButtonAlways.click();
            } else {
              driver.findElement(By.id("com.android.chrome:id/close_button")).click();

                logger.atInfo().log("Select Browser PopUp Not Displayed");

                   }


        Thread.sleep(2000);

        driver.findElement(By.id("com.android.chrome:id/close_button")).click();


        // go to Privacy Policy screen and Back
        driver.findElement(By.id("com.shawmedia.smglobal:id/about_privacy_policy")).click();

        driver.findElement(By.id("com.android.chrome:id/close_button")).click();

        // go to Ads Terms and conditions screen and back
        driver.findElement(By.id("com.shawmedia.smglobal:id/about_ads_terms_condition")).click();

        driver.findElement(By.id("com.android.chrome:id/close_button")).click();

        // go to About Ad choices screen and back
        driver.findElement(By.id("com.shawmedia.smglobal:id/about_ad_choices")).click();


        driver.findElement(By.id("com.android.chrome:id/close_button")).click();

        // go to Copyright screen
        // print out Copyright message
        MobileElement Copyright = (MobileElement) driver.findElement(By.id("com.shawmedia.smglobal:id/about_copy_right_text"));
        String AppCopyright = Copyright.getText();
        System.out.println("App Copyright  " + AppCopyright);

        Thread.sleep(2000);


    }
}
