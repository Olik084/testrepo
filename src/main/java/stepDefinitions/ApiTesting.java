package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.hamcrest.Matchers.*;

import static com.jayway.restassured.RestAssured.given;

public class ApiTesting {

    private String name;
    private String description;
    private String url;

    public String getUrl() {
        return url;
    }

    public ApiTesting setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ApiTesting setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ApiTesting setName(String name) {
        this.name = name;
        return this;
    }



    @Given("^I want info on people$")
    public void iWantInfoOnPeople() {
        given().
                when().
                get("https://swapi.co/api/people/").
                then().
                assertThat().
                statusCode(200);
    }

    @And("^I want also starships$")
    public void iWantAlsoStarships() {
        given().
                when().
                get("https://swapi.co/api/starships/").
                then().
                assertThat().
                statusCode(200);
    }

    @And("^a Planet$")
    public void aPlanet() {
        given().
                when().
                get("https://swapi.co/api/planets/7").
                then().
                assertThat().
                statusCode(200);
    }

    @Given("^I send best get request ever$")
    public void iSendBestGetRequestEver() {
        given().
                when().
                get("https://swapi.co/api/people/1/").
                then().
                assertThat().
                statusCode(200);
    }
}
