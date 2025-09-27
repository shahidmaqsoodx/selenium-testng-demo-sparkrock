package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SecureAreaPage {
    private WebDriver driver;

    // Locators
    private By header = By.tagName("h2");
    private By flashMessage = By.id("flash");

    // Constructor
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private explicit wait method (page-specific as it doesn't extend BaseTest)
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Steps
    public String getHeaderText() {
        return waitForElement(header, 5).getText();
    }

    /**
     * Flash message also appears on this page after a successful login.
     * We keep this method here (and in LoginPage) because the element 
     * exists in both contexts but represents different outcomes
     * even though the locators look similar:
     * - LoginPage -> invalid login flash
     * - SecureAreaPage -> successful login flash
     */
    public String getFlashMessage() {
        return waitForElement(flashMessage, 5).getText();
    }
}
