package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot)driver; //Down-casting (explicit)
        	File src = ts.getScreenshotAs(OutputType.FILE); 

            // Ensure screenshots folder exists
            String folderPath = "screenshots/";
            Files.createDirectories(Paths.get(folderPath));

            String filePath = folderPath + testName + "_" + System.currentTimeMillis() + ".png";
            File dest = new File(filePath);
            Files.copy(src.toPath(), dest.toPath()); //Copy screenshot to the created screenshots folder

            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
