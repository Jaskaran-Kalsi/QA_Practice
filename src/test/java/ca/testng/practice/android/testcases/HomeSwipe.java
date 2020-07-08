package ca.testng.practice.android.testcases;

import ca.testng.practice.android.testcases.BSBase;
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
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeSwipe extends BSBase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      try {
          //click Skip button
          WebElement skipButton = driver.findElement(MobileBy.AndroidUIAutomator("text(\"SKIP\")"));
          skipButton.click();
      } catch (Exception e){
          System.out.println("Skip is not found");

      }
      //swipe once to make Latest Episodes row fully visible
        swipe();

        //Find Latest Episodes Collection - must end with /..
        WebElement latestEpisodesCollection = driver.findElement(By.xpath("//android.widget.TextView[@text='Latest Global TV Episodes']/.."));

        //find webelements within Latest Episodes collection
        List<WebElement> listOfThumbnails = latestEpisodesCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));

/*         for (WebElement thumbnail : listOfThumbnails) {
            WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_show_title"));
            System.out.println(des.getText());
        }
 */
        swipeHorizontal(listOfThumbnails.get(1), listOfThumbnails.get(0));

         List<WebElement> listOfThumbnails1 = latestEpisodesCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));

/*       for (WebElement thumbnail : listOfThumbnails1) {
            WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_show_title"));
            System.out.println(des.getText());
        }

 */
        swipeHorizontal(listOfThumbnails1.get(2), listOfThumbnails.get(1));

//      swipeHorizontal(listOfThumbnails2.get(2), listOfThumbnails1.get(1));

        List<WebElement> listOfThumbnails2 = latestEpisodesCollection.findElements(By.id("com.shawmedia.smglobal:id/home_page_video_layout"));


/*       for (WebElement thumbnail : listOfThumbnails2) {
            WebElement des = thumbnail.findElement(By.id("com.shawmedia.smglobal:id/home_page_description_episode_title"));
            System.out.println(des.getText());
        }
*/
        swipeHorizontal(listOfThumbnails2.get(2), listOfThumbnails1.get(1));
/*
      //Swipe down and click on show tile - works good - number of Touchactions should be set by experiment
        Dimension size = driver.manage().window().getSize();
        int middleX = (int) (size.getWidth() * 0.5);
        int bottomY = (int) (size.getHeight() * 0.9);
        int topY = (int) (size.getHeight() * 0.1);
        // lookup for element to refresh appium
        List<AndroidElement> lst = driver.findElements(By.id("com.shawmedia.smglobal:id/home_show_art_image_view"));
        System.out.println(lst.size());
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
                .perform();
        //new TouchAction((PerformsTouchActions) driver).press(PointOption.point(middleX, bottomY))
                //.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(middleX, topY)).release()
                //.perform();
        WebElement show=driver.findElement(MobileBy.AndroidUIAutomator("description(\"Survivor: Winners at War\")"));
        show.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        //Click Back button
        WebElement BackButton = driver.findElement(By.id("com.shawmedia.smglobal:id/detail_page_back_button"));
        BackButton.click();

// another way of reaching show tile on Home screen - number of swipes should be set by experiment
        swipe();
        Thread.sleep(2000);

        swipe();
        Thread.sleep(2000);

        swipe();
        Thread.sleep(2000);

        WebElement showRules = driver.findElement(MobileBy.AndroidUIAutomator("description(\"The Sinner\")"));
        showRules.click();

        //Click Back button
        WebElement BackButton1 = driver.findElement(By.id("com.shawmedia.smglobal:id/detail_page_back_button"));
        BackButton1.click();
*/
        Thread.sleep(10000);

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }
}
