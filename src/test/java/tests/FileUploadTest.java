package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.InvalidArgumentException;
import pages.FileUploadPage;

import java.io.File;
import java.net.URL;

public class FileUploadTest extends BaseTest {

    /* 
     * Helper: get file path from resources folder
     * System.Property("user.dir") - sometimes causes issue on CLI runs
     * so using this to get dynamic path
     * */
    private String getResourceFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        return new File(resource.getFile()).getAbsolutePath();
    }

    @Test
    public void testValidFileUpload() {
        driver.get(baseUrl + "/upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        String filePath = getResourceFilePath("testfile.txt");
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

        // Skip sendKeys; just click Upload button directly
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

        String file1 = getResourceFilePath("file1.txt");
        String file2 = getResourceFilePath("file2.txt");

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
