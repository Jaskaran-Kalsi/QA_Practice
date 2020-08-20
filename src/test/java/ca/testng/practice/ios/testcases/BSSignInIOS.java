package ca.testng.practice.ios.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BSSignInIOS extends BSBaseIOS {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click Skip button
        //driver.findElement(MobileBy.AccessibilityId("SKIP")).click();

        // click Next button
        driver.findElement(MobileBy.AccessibilityId("NEXT")).click();

        //click Sign In button
        driver.findElement(MobileBy.AccessibilityId("SIGN IN")).click();
        Thread.sleep(3000);

        //select Shaw to complete sign in flow
        driver.findElement(By.id("Shaw")).click();
        Thread.sleep(3000);

        //enter shaw creds
        driver.findElement(By.name("username")).click();
        MobileElement username=driver.findElement(By.name("username"));
        username.click();
        username.sendKeys("corusf.reerange@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.name("password")).click();
        MobileElement password=driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("Welcome00");
        Thread.sleep(2000);

        driver.findElement(By.name("Sign In")).click();
        Thread.sleep(50000);

        driver.findElement(By.name("OK")).click();
        Thread.sleep(50000);



        // navigate to Shows screen
            driver.findElement(By.id("SHOWS")).click();
            Thread.sleep(1000);


            //navigate to HGTV shows
            driver.findElement(By.id("history")).click();
            Thread.sleep(1000);

            //navigate to Alone show details screen
            driver.findElement(By.id("Alone")).click();

        //Verify Play button is displayed and launch palyer
        MobileElement playButton=driver.findElement(By.name("media-play"));
        System.out.println("Play button is displayed");
        playButton.click();



        System.out.println("Test completed successfully");

        }
    }