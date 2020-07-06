package ca.testng.practice.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class VideoPlayback2 extends BSBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException, FileNotFoundException {
// TODO Auto-generated method stub

        try {
            //click Skip button
            WebElement skipButton = driver.findElement(MobileBy.AndroidUIAutomator("text(\"SKIP\")"));
            skipButton.click();
        } catch (Exception e){
            System.out.println("Skip is not found");

        }

        //scroll down - 1 method
        // calculate bottom & top of the screen
        Dimension size = driver.manage().window().getSize();
        int middleX = (int) (size.getWidth() * 0.5);
        int bottomY = (int) (size.getHeight() * 0.8);
        int topY = (int) (size.getHeight() * 0.3);
        // lookup for element to refresh appium
        List<AndroidElement> lst = driver.findElements(By.id("com.shawmedia.smglobal:id/home_show_art_image_view"));
        System.out.println(lst.size());
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
                .perform();
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
                .perform();


        // Scroll down - 2 method -  using swipe() method in BSBAse
       // swipe();
       // Thread.sleep(3000);

        //Find Top News Collection - must end with /..
        WebElement topNewCollection = driver.findElement(By.xpath("//android.widget.TextView[@text='Top News']/.."));

        //find webelements within Top News collection

        List<WebElement> listOfThumbnails1 = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));

        //print names of the thumbnails
        for (WebElement thumbnail : listOfThumbnails1) {
            WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_episode_title"));
            System.out.println(des.getText());
        }
        //Swipe the first set of thumbnails - using swipeHorizontal method in BSBase
        swipeHorizontal(listOfThumbnails1.get(1), listOfThumbnails1.get(0));
         // Find Elements and swipe
       // List<WebElement> listOfThumbnails3 = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));
        swipeHorizontal(listOfThumbnails1.get(1), listOfThumbnails1.get(0));

        // Find list of Elements and swipe
        //List<WebElement> listOfThumbnails4 = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));
        swipeHorizontal(listOfThumbnails1.get(1), listOfThumbnails1.get(0));

        //click on thumbnail to open player
        List<WebElement> listOfThumbnails2 = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));
        listOfThumbnails2.get(3).findElement(By.id("com.shawmedia.smglobal:id/home_page_video_art_view")).click();

       // Thread.sleep(30000);


        //tap on Pause button to pause playback
        //
        driver.findElement(By.id("com.shawmedia.smglobal:id/exo_pause")).click();
        Thread.sleep(2000);


        //click Back button to close the player

        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton\n")).click();
        //or
        driver.findElement(By.id("com.shawmedia.smglobal:id/player_back_button")).click();


        Thread.sleep(10000);


    }
}

