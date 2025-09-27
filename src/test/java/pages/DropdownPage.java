package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class DropdownPage {
    private WebDriver driver;

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private explicit wait method (page-specific as this "page" class doesn't extend BaseTest.java)
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Select an option by visible text
    public void selectOption(String optionText) {
        WebElement dropdownElement = waitForElement(dropdown, 5);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

    // Get currently selected option
    public String getSelectedOption() {
        WebElement dropdownElement = waitForElement(dropdown, 5);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}
