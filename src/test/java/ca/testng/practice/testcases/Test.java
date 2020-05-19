package ca.testng.practice.testcases;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Test {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        //File f=new File("resources");

        File fs=new File("/Users/ekotliar/IdeaProjects/BrowserStackTesting1/src/test/resources/WikipediaSample(1).apk");
        //File fs=new File("/Users/ekotliar/IdeaProjects/BrowserStackTesting1/src/test/resources/original.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(10000);

        driver.findElementByClassName("android.widget.TextView").click();
        driver.findElementByClassName("android.widget.TextView").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
        driver.findElementById("org.wikipedia.alpha:id/search_close_btn").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hotel");

        //Thread.sleep(10000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert(allProductsName.size() > 0);
        driver.findElementsByClassName("android.widget.TextView").get(1).click();
        Thread.sleep(10000);

        driver.quit();
    }

}

