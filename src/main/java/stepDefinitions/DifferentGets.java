package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class DifferentGets {
    Response response;


    @And("^I manage to sout get header$")
    public void iManageToSoutGetHeader() {
        com.jayway.restassured.response.Response response = get("http://localhost:3000/posts/123");
        System.out.println("Response on header: " + response.header("Content-Type"));
        System.out.println("----------------------------");
        System.out.print(System.lineSeparator());

        //     String data = get("http://localhost:3000/posts").asString();
        //     System.out.println("Url is "+data);
//
    }

    //
    @Given("^I sout get cookie$")
    public void iSoutGetCookie() {
        com.jayway.restassured.response.Response response = get("http://localhost:3000/posts/123");
        System.out.println("Response on cookie: " + response.cookie("Content-Type"));
        System.out.println("----------------------------");
        System.out.print(System.getProperty("line.separator"));
    }




    @And("^I sout headers$")
    public void iSoutHeaders() {
        com.jayway.restassured.response.Response response = get("http://localhost:3000/posts/123");
        System.out.println("Response on headers: " + "\n" + response.getHeaders());
        System.out.println("----------------------------");
        System.out.print(System.lineSeparator());
    }


    @Then("^I sout get else$")
    public void iSoutGetElse() {
        com.jayway.restassured.response.Response response = get("http://localhost:3000/posts/123");
        System.out.println("Response on session ID: " + response.getSessionId());
        System.out.println("----------------------------");
        System.out.print(System.lineSeparator());
    }

    @Then("^I also try other get$")
    public void iAlsoTryOtherGet() {
        com.jayway.restassured.response.Response response = get("http://localhost:3000/posts/123");
        System.out.println("Response on Status Line: " + response.getStatusLine());
        System.out.println("----------------------------");
        System.out.print(System.lineSeparator());
    }
}
