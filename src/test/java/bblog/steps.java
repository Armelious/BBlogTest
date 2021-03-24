package bblog;

import bblog.pageobjects.HomePageObject;
import io.cucumber.java.en.Given;

public class steps {

    private HomePageObject homePage;

    @Given("I navigated to {string}")
    public void i_navigated_to(String url) {
        homePage.navigateTo(url);
    }
}
