package ca.testng.practice.ios.testcases;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.net.MalformedURLException;

public class PickerViewiOS extends testiOS {
    public static void main(String[] arg) throws MalformedURLException, InterruptedException {
        IOSDriver<IOSElement> driver= capabilities();

/*        driver.findElement(By.id("Alert Views")).click();
        driver.findElement(By.name("Text Entry")).click();
       Thread.sleep(2000);
/*        driver.findElement(By.id("Text Entry")).sendKeys("Hello");
        Thread.sleep(2000);
        driver.findElement(By.id("OK")).click();
*/
/*        driver.findElement(By.id("Cancel")).click();
        driver.navigate().back();
        //or to navigate back as below
        // driver.findElement(By.name("UICatalog")).click();

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x, endy)).release()
                .perform();

        driver.findElementByAccessibilityId("Switches").click();
 */       driver.navigate().back();
        driver.findElementByAccessibilityId("Steppers").click();
        driver.findElementsByName("Increment").get(0).click();
        driver.findElementsByName("Increment").get(0).click();
        driver.findElementsByName("Increment").get(2).click();
        System.out.println("DEFAULT");

        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
        System.out.println("TINTED");
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
        System.out.println("CUSTOM");
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(3).getText());
        driver.navigate().back();

        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByName("Green color component value").sendKeys("220");
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("40");
        driver.findElementById("Blue color component value").sendKeys("100");









    }
}
