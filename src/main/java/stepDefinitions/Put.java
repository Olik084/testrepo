package stepDefinitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class Put {
    @Given("^try out put$")
    public void tryOutPut() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", "36");
        json.put("title", "WebServices");
        json.put("author", "Cool");

        request.body(json.toJSONString());

        Response response = request.post("http://localhost:3000/posts");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 201);

    }
}

