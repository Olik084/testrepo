package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.get;

public class ResponseTime {
    @Given("^I get info on the product$")
    public void iGetInfoOnTheProduct() {
        Response resp = get("http://localhost:3000/posts");
        int code = ((Response) resp).getStatusCode();
        System.out.println("Status code "+code);
        Assert.assertEquals(code, 200);
    }

    //Or you can also use:
    //int code=get("").getStatusCode();
    //Assert.assertEquals(code, 200);

    //String data= get("").asString();
    //long time=getTime();


    @And("^I check response time$")
    public void iCheckResponseTime() {
        Response resp = get("http://localhost:3000/posts");
        String data = resp.asString();
        System.out.println(" Data is "+data);
        System.out.println("Response time "+resp.getTime());
    }
}
