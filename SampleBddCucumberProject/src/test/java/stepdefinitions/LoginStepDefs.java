package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    @Given("user is on login page")
    public void user_on_login_page() {
        System.out.println("User on login page");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println("User enters credentials");
    }

    @Then("user is redirected to the homepage")
    public void user_redirected_homepage() {
        System.out.println("User redirected");
    }
}
