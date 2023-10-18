package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.example.Keeper;
import org.example.entity.Person;
import org.example.utils.RequestSpecificationBuilder;

import static io.restassured.RestAssured.baseURI;
import static org.example.Constants.ADD_PERSON;

public class AddUserStepsDef {
    private final RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilder();

    @When("add new person with params {string}, {string}, {string}")
    public void addNewPersonWithParams(String arg0, String arg1, String arg2) {
        Person person = new Person(arg0, arg1, arg2);
        ValidatableResponse response = requestSpecificationBuilder.buildSpecification(baseURI, ADD_PERSON).body(person).post().then();
        Keeper.put("response", response);
    }
}
