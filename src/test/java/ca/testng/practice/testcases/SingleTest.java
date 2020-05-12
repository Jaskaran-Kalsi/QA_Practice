package ca.testng.practice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author jkalsi - QA_Practice
 * @since May 05, 2020
 */
public class SingleTest extends BaseTest {
    @Test
    public void test() {
        // Write first test in this.
        logger.atInfo().log("Starting Test...");
        WebElement search = driver.findElement(By.id("org.wikipedia.alpha:id/search_container"));
        search.sendKeys("Hello");
    }
}
