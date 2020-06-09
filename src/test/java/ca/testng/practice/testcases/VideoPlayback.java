package ca.testng.practice.testcases;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import javax.tools.StandardJavaFileManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.PrintStream;

public class VideoPlayback extends BSBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException, FileNotFoundException {
        // TODO Auto-generated method stub


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click Skip button
        WebElement skipButton = driver.findElement(MobileBy.AndroidUIAutomator("text(\"SKIP\")"));
        skipButton.click();
        //driver.findElement(By.id("com.shawmedia.smglobal:id/home_page_video_art_view")).click();

        swipe();
        Thread.sleep(3000);

        //MobileElement elementFrom =driver.findElement(MobileBy.AndroidUIAutomator("description(\"Port Hope police hand out tickets to park-goers\")"));
        //MobileElement elementTo = driver.findElement(MobileBy.AndroidUIAutomator("description(\"Watch out for loan scams during COVID-19 pandemic, experts warn\")"));


        WebElement topNewCollection = driver.findElement(By.xpath("//android.widget.TextView[@text='Top News']/.."));
        List<WebElement> listOfThumbnails = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));

       swipeHoriz();


        //com.shawmedia.smglobal:id/home_page_video_play_lock_icon
/*        try
        {
            System.setOut(new PrintStream(new FileOutputStream("listOfThumbnails")));
            System.out.println();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


/*String text = "Top News";
        WebElement el = driver.findElement(MobileBy
               .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.shawmedia.smglobal:id/home_page_collection_list_item_rv\")).setAsVerticalList().scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));

        String text1 = "Watch out for loan scams during COVID-19 pandemic, experts warn";
        WebElement el1 = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.shawmedia.smglobal:id/home_page_collection_list_item_rv\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\""+text1+"\"));"));

        driver.findElement(MobileBy.id("com.shawmedia.smglobal:id/home_page_video_art_view")).click();
*/
        Thread.sleep(3000);


    }
}

