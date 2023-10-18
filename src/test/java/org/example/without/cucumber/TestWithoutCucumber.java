package org.example.without.cucumber;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestWithoutCucumber {
    @Test
    public void testUrl(){
        given().when().contentType(ContentType.JSON).baseUri(baseURI)
                .port(21986).basePath("/getPersonInfo").param("name", "Ivan")
                .get().then().statusCode(200).assertThat()
                .body("phone", equalTo("+79863456545"));
    }

}
