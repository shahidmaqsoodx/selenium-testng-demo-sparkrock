package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FileUploadPage {
    private WebDriver driver;

    private By chooseFileInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    // Local explicit waiter
    private WebElement waitForElement(By locator, int seconds) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Upload file
    public void uploadFile(String filePath) {
        WebElement fileInput = waitForElement(chooseFileInput, 5);
        fileInput.sendKeys(filePath);

        WebElement uploadBtn = waitForElement(uploadButton, 5);
        uploadBtn.click();
    }

    // Get uploaded filename text
    public String getUploadedFileName() {
        return waitForElement(uploadedFiles, 5).getText();
    }
    
    // Click upload button without selecting a file
    public void clickUploadWithoutFile() {
        WebElement uploadBtn = waitForElement(uploadButton, 5);
        uploadBtn.click();
    }

}
