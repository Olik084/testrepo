package stepDefinitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import org.json.simple.JSONObject;
import org.testng.Assert;


public class delete {
    @Given("^I am deleting an entry$")
    public void iAmDeletingAnEntry() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/1");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
    }
}
