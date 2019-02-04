package stepDefinitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class OneAfterAnother {
    @Given("^I am posting new past$")
    public void iAmPostingNewPast() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", "121");
        json.put("title", "OneAfterAnother");
        json.put("author", "Despicable me");

        request.body(json.toJSONString());

    }

    @And("^I check response time$")
    public void iCheckResponseTime() {
        Response resp = get("http://localhost:3000/posts");
        String data = resp.asString();
        System.out.println(" Data is "+data);
        System.out.println("Response time "+resp.getTime());
    }

   @And("^I check that post is created$")
   public void iCheckThatPostIsCreated() {
       RestAssured.baseURI = "http://localhost:3000/posts";
       given().
               queryParam("ID", 121).
               when().
               get("8").
               then().
               body("title", equalTo("OneAfterAnother"));
   }
}
