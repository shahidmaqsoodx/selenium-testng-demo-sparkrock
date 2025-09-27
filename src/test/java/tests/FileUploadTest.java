package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.InvalidArgumentException;
import pages.FileUploadPage;

public class FileUploadTest extends BaseTest {

    @Test
    public void testValidFileUpload() {
        driver.get(baseUrl + "/upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        String filePath = System.getProperty("user.dir") + "/src/test/resources/testfile.txt";
        fileUploadPage.uploadFile(filePath);

        Assert.assertEquals(
                fileUploadPage.getUploadedFileName(),
                "testfile.txt",
                "Uploaded file name did not match expected."
        );
    }

    @Test
    public void testEmptyFileUpload() {
        driver.get(baseUrl + "/upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.clickUploadWithoutFile();

        boolean noFileDisplayed = false;
        try {
            String uploadedFile = fileUploadPage.getUploadedFileName();
            noFileDisplayed = uploadedFile.isEmpty();
        } catch (org.openqa.selenium.TimeoutException e) {
            // Element not found = no file uploaded
            noFileDisplayed = true;
        }

        Assert.assertTrue(
                noFileDisplayed,
                "Expected no file to be uploaded when skipping file selection."
        );
    }


    @Test
    public void testMultipleFileUploadBoundary() {
        driver.get(baseUrl + "/upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        String file1 = System.getProperty("user.dir") + "/src/test/resources/file1.txt";
        String file2 = System.getProperty("user.dir") + "/src/test/resources/file2.txt";

        boolean exceptionThrown = false;
        try {
            fileUploadPage.uploadFile(file1 + "\n" + file2);
        } catch (InvalidArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(
                exceptionThrown,
                "Expected InvalidArgumentException when trying multiple file upload."
        );
    }
}
