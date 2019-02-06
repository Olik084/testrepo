package stepDefinitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.mapper.TypeRef;
import org.hamcrest.core.IsEqual;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneAfterAnother {
    @Given("^I am posting new post$")
    public void iAmPostingNewPost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", "125");
        json.put("title", "OneAfterAnother");
        json.put("author", "Despicable me");

        request.body(json.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 201);

    }

  //  @And("^I check response time$")
  //  public void iCheckResponseTime() {
  //      Response resp = get("http://localhost:3000/posts");
  //      String data = resp.asString();
  //      System.out.println(" Data is "+data);
  //      System.out.println("Response time "+resp.getTime());
  //  }

   @And("^I check that post is created$")
   public void iCheckThatPostIsCreated() {
  //    RestAssured.baseURI = "http://localhost:3000/posts";
  //    given().
  //            queryParam("ID", 122).
  //            when().
  //            get("8").
  //            then().
  //            body("title", equalTo("null"));
       io.restassured.specification.RequestSpecification request = io.restassured.RestAssured.given();
       request.header("Content-Type", "application/json; charset=utf-8");
       JSONObject json = new JSONObject();
       request.body(json.toJSONString());
       List<Map<String, Object>> products = get("http://localhost:3000/posts").as(new TypeRef<List<Map<String, Object>>>() {
       });

       assertThat(products.get(14).get("id"), IsEqual.equalTo("125"));
       assertThat(products.get(14).get("author"), IsEqual.equalTo("Despicable me"));
       assertThat(products.get(14).get("title"), IsEqual.equalTo("OneAfterAnother"));
   }
}
