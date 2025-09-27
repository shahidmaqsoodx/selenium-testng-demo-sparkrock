package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertsPage {
    private WebDriver driver;

    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By resultMessage = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private explicit wait method (page-specific as this "page" class doesn't extend BaseTest.java)
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click JS Alert and accept
    public void triggerAndAcceptAlert() {
        waitForElement(jsAlertButton, 5).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Click JS Confirm and dismiss
    public void triggerAndDismissConfirm() {
        waitForElement(jsConfirmButton, 5).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Get result message after alert action
    public String getResultMessage() {
        return waitForElement(resultMessage, 5).getText();
    }
}
