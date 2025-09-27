package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CheckboxPage {
    private WebDriver driver;

    private By checkboxes = By.cssSelector("#checkboxes input");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private explicit wait method (page-specific as this "page" class doesn't extend BaseTest.java)
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Get all checkboxes
    public List<WebElement> getAllCheckboxes() {
        waitForElement(checkboxes, 5);
        return driver.findElements(checkboxes);
    }

    // Toggle checkbox at given index (0-based)
    public void toggleCheckbox(int index) {
        WebElement checkbox = getAllCheckboxes().get(index);
        checkbox.click();
    }

    // Check if checkbox at given index is selected
    public boolean isCheckboxSelected(int index) {
        return getAllCheckboxes().get(index).isSelected();
    }
}
