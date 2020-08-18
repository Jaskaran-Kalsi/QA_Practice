package ca.testng.practice.testcases.TestVersions;


import ca.testng.practice.testcases.TestVersions.IOSBaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author jkalsi - QA_Practice
 * @since May 05, 2020
 */
public class IOSSingleTest extends IOSBaseTest {
    @Test
    public void test() throws InterruptedException {
        String searchTerm = "Hello";
        IOSElement textButton =
                (IOSElement) new WebDriverWait(driver, 30)
                        .until(
                                ExpectedConditions.elementToBeClickable(
                                        MobileBy.AccessibilityId("Text Button")
                                )
                        );
        textButton.click();

        IOSElement textInput =
                (IOSElement) new WebDriverWait(driver, 30)
                        .until(
                                ExpectedConditions.elementToBeClickable(
                                        MobileBy.AccessibilityId("Text Input")
                                )
                        );
        textInput.sendKeys(searchTerm + "\n");

        Thread.sleep(5000);

        IOSElement textOutput =
                (IOSElement) new WebDriverWait(driver, 30)
                        .until(
                                ExpectedConditions.elementToBeClickable(
                                        MobileBy.AccessibilityId("Text Output")
                                )
                        );

        Assert.assertEquals(textOutput.getText(), searchTerm);
    }
}
