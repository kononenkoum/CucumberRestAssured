package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.example.Keeper;
import org.example.entity.Person;
import org.example.utils.RequestSpecificationBuilder;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static org.example.Constants.GET_PERSON_LIST;

public class GetListStepDefs {
    private final RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilder();
    @When("ask person list")
    public void askPersonList() {
        ValidatableResponse response = requestSpecificationBuilder.buildSpecification(baseURI, GET_PERSON_LIST).get().then();
        Keeper.put("response", response);
    }

    @Then("get person list")
    public void getPersonList() {
        ValidatableResponse response = (ValidatableResponse) Keeper.get("response");
        List<Person> personList = response.extract().body().jsonPath().getList(".", Person.class);
        Assert.assertTrue(personList.size() > 0);
        Keeper.put("personList", personList);
    }

    @And("all person info contains {string}")
    public void allPersonInfoContains(String arg0) {
        List<Person> personList = (List<Person>) Keeper.get("personList");
        personList.forEach(person -> Assert.assertTrue(person.getAboutMe().contains(arg0)));
    }
}
