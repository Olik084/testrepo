package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepExample {
    private WebDriver driver;
    public StepExample(){this.driver=Hooks.driver;}

    @Given("^I am on the page$")
    public void iAmOnThePage() {
        driver.get("https://www.google.com/");
    }

    @Given("^I send Get request$")
    public void iSendGetRequest() {
        
    }
}

