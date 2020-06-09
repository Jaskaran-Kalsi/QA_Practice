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

        List<String> listThumbnailDes = new ArrayList<>();
        List<String> oldListThumbnailDes = new ArrayList<>();
        for (WebElement thumbnail : listOfThumbnails) {
            WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_episode_title"));
            listThumbnailDes.add(des.getText());
        }

        while (!listThumbnailDes.equals(oldListThumbnailDes)) {

            swipeHorizontal(listOfThumbnails.get(listOfThumbnails.size() - 1), listOfThumbnails.get(0));
            oldListThumbnailDes = listThumbnailDes;
            listThumbnailDes.clear();
            Thread.sleep(1000);
            listOfThumbnails = topNewCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));
            System.out.println(listOfThumbnails.size());
            for (WebElement thumbnail : listOfThumbnails) {
                WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_episode_title"));
                listThumbnailDes.add(des.getText());
            }
        }
        // swipeHoriz();


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

