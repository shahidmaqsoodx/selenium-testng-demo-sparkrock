package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ScreenshotUtil;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://the-internet.herokuapp.com"; // hard-coded for now, can add as a config later 
    
    @BeforeMethod
    public void setupTest() {
        //Selenium Manager (Selenium 4.6+) handles driver download & path setup automatically (No WebDriverManager library needed)
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
    
 // Generic explicit wait helper
    protected WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
