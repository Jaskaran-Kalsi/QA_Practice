package ca.testng.practice.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BSSwipe extends BSBase {
@Test
    public void test() throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click Skip button
        WebElement skipButton = driver.findElement(MobileBy.AndroidUIAutomator("text(\"SKIP\")"));
        skipButton.click();

        //navigate to Shows - Global brand
        WebElement LogoClick = driver.findElement(MobileBy.AndroidUIAutomator("description(\"global\")"));
        LogoClick.click();


        // lookup for element to refresh appium
        List<AndroidElement> shows = driver.findElements(By.id("com.shawmedia.smglobal:id/general_show_art_image_view"));
        List<String> showsName = new ArrayList<>();
        for (AndroidElement el : shows) {
            showsName.add(el.getAttribute("content-desc"));
        }
        List<String> previousList = new ArrayList<>();
        boolean showFound = false;
        while (!previousList.equals(showsName) && !showFound) {
            for (AndroidElement el : shows) {
                if (el.getAttribute("content-desc").contains("Survivor: Winners at War")) {
                    el.click();
                    showFound = true;
                    break;
                }
            }
            if (showFound) {
                break;}
            // scroll screen
            swipe();
            Thread.sleep(2000);
            previousList.clear();
            previousList.addAll(showsName);
            shows = driver.findElements(By.id("com.shawmedia.smglobal:id/general_show_art_image_view"));
            showsName.clear();
            for (AndroidElement el : shows) {
                showsName.add(el.getAttribute("content-desc"));
            }
        }

//click on show to get show details page
        //WebElement show = driver.findElement(MobileBy.AndroidUIAutomator("description(\"A Little Late with Lilly Singh\")"));
        //show.click();

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//click Back button to return to Shows screen - Global brand
          WebElement BackButton = driver.findElement(By.id("com.shawmedia.smglobal:id/detail_page_back_button"));
          BackButton.click();
    //navigate to Home
    driver.findElement(MobileBy.AndroidUIAutomator("text(\"HOME\")")).click();
    // Thread.sleep(2000);

    //scroll down
    // calculate bottom & top of the screen
    Dimension size = driver.manage().window().getSize();
    int middleX = (int) (size.getWidth() * 0.5);
    int bottomY = (int) (size.getHeight() * 0.8);
    int topY = (int) (size.getHeight() * 0.3);
    // lookup for element to refresh appium
    List<AndroidElement> lst = driver.findElement(By.id("com.shawmedia.smglobal:id/shows_grid_view"));

    System.out.println(lst.size());
    // scroll screen
    new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
            .perform();
    new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
            .perform();
    new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
            .perform();
    new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
            .perform();
    WebElement show1=driver.findElement(MobileBy.AndroidUIAutomator("description(\"Scott’s Vacation House Rules\")"));
    show1.click();

     //Click More/Less buttons
    driver.findElement(By.id("com.shawmedia.smglobal:id/detail_page_more_less_button")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("com.shawmedia.smglobal:id/detail_page_more_less_button")).click();

    //navigate to Home
    driver.findElement(MobileBy.AndroidUIAutomator("text(\"HOME\")")).click();



}
}