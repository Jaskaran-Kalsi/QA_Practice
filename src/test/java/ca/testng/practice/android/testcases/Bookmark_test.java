package ca.testng.practice.android.testcases;

import ca.testng.practice.android.testcases.AndroidBaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Bookmark_test extends AndroidBaseTest {

    //Perform search and create a Article List

    @Test
    public void test() {
        String searchTerm = "Gros Morne National Park";

        logger.atInfo().log("Starting Test...");
        WebElement search = driver.findElement(MobileBy.AccessibilityId("Search Wikipedia"));
        search.click();

        WebElement searchBox = driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text"));
        searchBox.sendKeys(searchTerm);
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement bookMark = (WebElement) ((AndroidDriver) driver).findElementsByClassName("android.widget.ImageView").get(3);
        bookMark.click();

        //Click Got It button in onboarding

        WebElement gotIt = ((AndroidDriver) driver).findElementById("org.wikipedia.alpha:id/onboarding_button");
        gotIt.click();

        //Create New List - select text field and hit Android back key to clear default text
        //Create list name

        WebElement listField = ((AndroidDriver) driver).findElementById("org.wikipedia.alpha:id/text_input");
        listField.click();
        listField.clear();
        listField.sendKeys("National Parks");

        //Click OK button
        var ok = ((AndroidDriver) driver).findElement(MobileBy.id("android:id/button1"));
        ok.click();














    }



}
