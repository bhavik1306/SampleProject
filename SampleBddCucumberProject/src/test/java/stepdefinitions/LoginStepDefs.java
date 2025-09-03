package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ScreenshotUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class LoginStepDefs {
    WebDriver driver = DriverManager.getDriver();

    @Given("user is on login page")
    public void user_on_login_page() throws InterruptedException {
        try {
            driver.get("https://dev.staging.mvp.leaseoasis.ae/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("title of the page: "+driver.getTitle());
            Assert.assertTrue(driver.getTitle().toString().contains("Lease Oasis"));
        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"LandingPage");
        }
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials(DataTable dataTable) throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            List<Map<String,String>> table = dataTable.asMaps(String.class,String.class);

            driver.findElement(By.xpath("//*[text()='Log In']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='Operator']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys(table.get(0).get("Username"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(table.get(0).get("Password"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"LogInPage");
        }
    }

    @Then("user is redirected to the homepage")
    public void user_redirected_homepage() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            System.out.println("title of the page: " + driver.getTitle());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"OperatorDashboard");
        }
    }

}
