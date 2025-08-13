package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileNamePrefix) {
        // Generate timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = fileNamePrefix + "_" + timestamp + ".png";

        // Take screenshot and save to file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), new File("screenshots/" + fileName).toPath());
            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }    }
}
