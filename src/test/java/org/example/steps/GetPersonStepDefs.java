package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Keeper;
import org.example.utils.RequestSpecificationBuilder;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.example.Constants.GET_PERSON_INFO;
import static org.hamcrest.Matchers.equalTo;

public class GetPersonStepDefs {
    private final RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilder();

    @When("^send \"([^\"]*)\"$")
    public void send(String arg0) {
        ValidatableResponse response = requestSpecificationBuilder.buildSpecification(baseURI, GET_PERSON_INFO).param("name", arg0).get().then();
        Keeper.put("response", response);
    }

    @When("send ")
    public void send() {
        ValidatableResponse response = requestSpecificationBuilder.buildSpecification(baseURI, GET_PERSON_INFO).get().then();
        Keeper.put("response", response);

    }

    @And("^body\\.phone is \"([^\"]*)\"$")
    public void bodyPhoneIs(String arg0) {
        ValidatableResponse response = (ValidatableResponse) Keeper.get("response");
        response.assertThat()
                .body("phone", equalTo(arg0));
    }
    @Then("body.phone is ")
    public void bodyPhoneIs() {
    }
}
