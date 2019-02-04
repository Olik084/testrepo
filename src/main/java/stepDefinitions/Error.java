package stepDefinitions;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.get;

public class Error {
    @Given("^I can not find the page$")
    public void iCanNotFindThePage() {
        Response resp = get("http://localhost:3000/posts/200");
        int code = ((Response) resp).getStatusCode();
        System.out.println("Status code "+code);
        Assert.assertEquals(code, 404);
    }
}
