package ca.testng.practice.ios.testcases;
import ca.testng.practice.android.testcases.BSBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UserProfileIOS extends BSBaseIOS {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
       try {
            //click Skip button
            Thread.sleep(3000);
            //WebElement skipButton = driver.findElement(By.name("text(\"SKIP\")"));
            //skipButton.click();
            driver.findElement(MobileBy.AccessibilityId("SKIP")).click();
        }

        catch (Exception e) {
            System.out.println("Skip is not found");
        }

        Thread.sleep(1000);
        // go to Profile and Settings screen

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"profile unauth\"]")).click();



        Thread.sleep(2000);
       // go back to main screen by Back button
        driver.findElement(By.name("backArrow")).click();
        Thread.sleep(2000);

        //navigate to Shows tab
        driver.findElement(By.id("SHOWS")).click();


        // go to Profile and Settings screen
       // driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"profile unauth\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"profile\")]")).click();
        Thread.sleep(3000);
        //print out screen name
        MobileElement header = (MobileElement) driver.findElement(By.id("Profile & Settings"));
        String headerProfile = header.getText();
        System.out.println(headerProfile);
       //print out Message from Profile screen
        MobileElement Messaging = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,\"access\")]"));
        String profileMessaging = Messaging.getText();
        System.out.println(profileMessaging);

        Thread.sleep(5000);
       // go to app settings screen
        driver.findElement(By.id("App Settings")).click();
        Thread.sleep(2000);

        // go back to main screen by Back button
        driver.findElement(By.name("backArrow")).click();

        Thread.sleep(2000);
        // go to About screen
        driver.findElement(By.id("About")).click();
     System.out.println("About screen");


        // print out if Global Logo found
        MobileElement GlobalLogo = (MobileElement) driver.findElement(By.name("global"));
               // driver.findElement(By.xpath("//XCUIElementTypeImage[contains(@name,\"logo\")]"));
        String Logo = GlobalLogo.getText();
        System.out.println("Global Logo" + Logo);

        Thread.sleep(2000);
       // print out app version
        MobileElement Version = (MobileElement) driver.findElement(By.id("App Version: 5.0-B30"));
        String AppVersion = Version.getText();
        System.out.println("App Version  " + AppVersion);


        Thread.sleep(2000);

       // go to Terms and conditions screen, select browser and back
        driver.findElement(By.id("TERMS AND CONDITIONS")).click();



       //Below code should be activated when running on BS devices

 /*           MobileElement popUpChrome = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Chrome\"]"));
            if (popUpChrome.isDisplayed()) {
                popUpChrome.click();
                MobileElement popUpButtonAlways = driver.findElement(By.id("android:id/button_always"));
                popUpButtonAlways.click();
            } else {
              driver.findElement(By.id("Return to Global TV")).click();

                logger.atInfo().log("Select Browser PopUp Not Displayed");

                   }

*/
        Thread.sleep(2000);

        driver.findElement(By.id("Return to Global TV")).click();


        // go to Privacy Policy screen and Back
        driver.findElement(By.id("PRIVACY POLICY")).click();

        driver.findElement(By.id("Return to Global TV")).click();

        // go to Ads Terms and conditions screen and back
        driver.findElement(By.id("ADVERTISING TERMS & CONDITIONS")).click();

        driver.findElement(By.id("Return to Global TV")).click();

        // go to About Ad choices screen and back
        driver.findElement(By.id("Ad Choices")).click();


        driver.findElement(By.id("Return to Global TV")).click();

        // go to Copyright screen
        // print out Copyright message
        MobileElement Copyright = (MobileElement) driver.findElement(By.id("© Corus Entertainment Inc. 2020. All Rights Reserved"));
        String AppCopyright = Copyright.getText();
        System.out.println("App Copyright  " + AppCopyright);

        Thread.sleep(2000);


    }
}
