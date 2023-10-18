package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.example.Keeper;
import org.example.utils.RequestSpecificationBuilder;

import static io.restassured.RestAssured.baseURI;
import static org.example.Constants.RESET;

public class UtilStepDefs {
    private final RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilder();
    @Then("^result (\\d+)$")
    public void result(int arg0) {
        ValidatableResponse response = (ValidatableResponse) Keeper.get("response");
        response.statusCode(arg0);
    }


    @After
    public void clear() {
        requestSpecificationBuilder.buildSpecification(baseURI, RESET).get().then();
    }
}
