package medunna.step_definitions.api_step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import medunna.pojos.ResponsePojo;
import medunna.pojos.TestItemPojo;
import medunna.step_definitions.db_step_definitions.DBTestItemStepDefs;
import medunna.step_definitions.ui_step_definitions.UIStepDefs;

import static io.restassured.RestAssured.given;
import static medunna.hooks.Hook.specification;
import static org.junit.Assert.assertEquals;


public class APIStepDefs {
    Response response;
    TestItemPojo expectedData;


    @Given("A Get request is sent")
    public void aGetRequestIsSent() {
        specification.pathParams("first","api","second","c-test-items","third", DBTestItemStepDefs.testItemId);

        expectedData = new TestItemPojo(UIStepDefs.name,UIStepDefs.expectedDescription,UIStepDefs.expectedPrice,UIStepDefs.expectedMinValue,UIStepDefs.expectedMaxValue);

        response= given(specification).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("Response is validated")
    public void responseIsValidated() {
        ResponsePojo actualData = response.as(ResponsePojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getMinValue(),actualData.getDefaultValMin());
        assertEquals(expectedData.getMaxValue(),actualData.getDefaultValMax());


    }
}
