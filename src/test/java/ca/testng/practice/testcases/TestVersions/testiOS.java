package ca.testng.practice.testcases.TestVersions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class testiOS {


    public static IOSDriver<IOSElement> capabilities() throws MalformedURLException, InterruptedException {

        IOSDriver<IOSElement>driver;

        File fs=new File("/Users/ekotliar/Library/Developer/Xcode/DerivedData/UICatalog-edshimdbbpmcjdhbqlxxffiplwle/Build/Products/Debug-iphonesimulator/UICatalog.app");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(10000);
        return driver;

    }

}

