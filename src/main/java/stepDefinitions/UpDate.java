package stepDefinitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import org.json.simple.JSONObject;
import org.testng.Assert;


public class UpDate {
    @Given("^I want to update the entry$")
    public void iWantToUpdateTheEntry() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", "2");
        json.put("title", "And one more to test");
        json.put("author", "Magic");

        request.body(json.toJSONString());

        Response response = request.put("http://localhost:3000/posts/2");
        int code = response.getStatusCode();
        System.out.println("response code "+code);
        Assert.assertEquals(code, 200);
    }
}
