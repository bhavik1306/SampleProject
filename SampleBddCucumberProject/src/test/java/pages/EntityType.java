package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ScreenshotUtil;

public class EntityType {

    public static void selectEntityType(String entityValue, WebDriver driver){
        try {
            WebElement element = driver.findElement(By.xpath("(//button[@role='combobox'])[2]//following::select"));
            Select sel = new Select(element);
            sel.selectByValue(entityValue);
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"entityTypeField");
        }
    }
}
