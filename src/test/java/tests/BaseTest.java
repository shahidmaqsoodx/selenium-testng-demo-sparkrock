package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenshotUtil;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://the-internet.herokuapp.com"; // hard-coded for now, can add as a config later 
    
    @BeforeMethod
    public void setupTest() {
        // Selenium Manager (Selenium 4.6+) handles driver download & path setup automatically
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        // Capture a full page screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
