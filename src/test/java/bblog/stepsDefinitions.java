package bblog;

import bblog.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsDefinitions {

    private HomePage homePage;

    public stepsDefinitions(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        homePage.navigateTo(url);
    }

    @Given("I navigate to HOME{string}")
    public void i_navigate_to_home(String url) {
        homePage.navigateToHome(url);
    }


    @When("I enter my Email")
    public void i_enter_my_email() {
        //todo decrypt from file and pass parameter
        homePage.enterEmail();
    }

    @When("I enter my Username")
    public void i_enter_my_username() {
        //todo decrypt from file and pass parameter
        homePage.enterUserName();
    }

    @When("I enter my Password")
    public void i_enter_my_password() {
        //todo decrypt from file and pass parameter
        homePage.enterPassword();
    }

    @When("I click Sign in")
    public void i_click_Sign_in() {
        homePage.clickSignIn();
    }

    @Then("I expect to be navigated to the Home Page")
    public void i_expect_to_be_navigated_to_the_home_page() {
        homePage.verifyHomePage();
    }
}
