package org.example.utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.example.Constants.GET_PERSON_INFO;

public class RequestSpecificationBuilder {
    public RequestSpecification buildSpecification(String url, String path){
        return given().when().contentType(ContentType.JSON).baseUri(url)
                .port(21986).basePath(path);
    }
}
