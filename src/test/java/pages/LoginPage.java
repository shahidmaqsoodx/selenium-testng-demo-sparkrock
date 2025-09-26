package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private explicit wait method (page-specific as this "page" class doesn't extend BaseTest.java)
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Steps
    public void setUsername(String username) {
        waitForElement(usernameField, 5).sendKeys(username);
    }

    public void setPassword(String password) {
        waitForElement(passwordField, 5).sendKeys(password);
    }

    public void clickLogin() {
        waitForElement(loginButton, 5).click();
    }

    public String getFlashMessage() {
        return waitForElement(flashMessage, 5).getText();
    }

    public void loginAs(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}
