package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotUtil;
import utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SignUpStepDef {
    WebDriver driver;
    @After
    public void tearDown(){
        driver.close();
    }

    @Given("user is on Sign Up page")
    public void userIsOnSignUpPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        try {
            driver.get("https://dev.staging.mvp.leaseoasis.ae/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("title of the page: "+driver.getTitle());
            Assert.assertTrue(driver.getTitle().toString().contains("Lease Oasis"));
            driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login']")).isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"LandingPage");
        }
    }

    @When("user enters valid Data")
    public void userEntersValidData(DataTable dataTable) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<Map<String,String>> table =  dataTable.asMaps(String.class,String.class);

            driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys(table.get(0).get("FirstName"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys(table.get(0).get("LastName"));
            String EmailId = Utils.randomEmailCreation();
            System.out.println("Random email id is: "+EmailId);
            driver.findElement(By.xpath("//*[@name='email']")).sendKeys(EmailId);
            Thread.sleep(3000);
            int number = Utils.randonNumerGenerator();
            driver.findElement(By.xpath("//*[@name='contactNumber']")).sendKeys(String.valueOf(number));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Test@123");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='confirmPassword']")).sendKeys("Test@123");
            Thread.sleep(2000);
            driver.findElement(By.id("policy")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("policy1")).click();
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"Sign Up Page");
        }

    }

    @Then("Clicked on sign up button and validate the OTP Validation screen")
    public void clickedOnSignUpButtonAndValidateTheOTPValidationScreen() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[text()='OTP Verification']")).getText().toString();
            Assert.assertEquals( driver.findElement(By.xpath("//*[text()='OTP Verification']")).getText().toString(),"OTP Verification");
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='OTP Verification']")).isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            ScreenshotUtil.takeScreenshot(driver,"OTP Validation screen");
        }
    }
}
