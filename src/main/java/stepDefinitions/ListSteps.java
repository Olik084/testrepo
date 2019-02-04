package stepDefinitions;


import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;



public class ListSteps {

    @Given("^I have created a list$")
    public void iHaveCreatedAList() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        request.body(json.toJSONString());
        List<Map<String, Object>> products = get("http://localhost:3000/posts").as(new TypeRef<List<Map<String, Object>>>() {
        });

        assertThat(products.get(1).get("id"), equalTo("35"));
        assertThat(products.get(1).get("author"), equalTo("Cool"));
        assertThat(products.get(0).get("title"), equalTo("Mama"));
        assertThat(products.get(4).get("author"), equalTo("Olga"));
        assertThat(products.get(2).get("title"), equalTo("And one more to test"));
    }
}

