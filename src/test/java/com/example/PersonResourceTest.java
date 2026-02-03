package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class PersonResourceTest {
    @Test
    void test() {
        given()
                .when()
                .get("/person")
                .then()
                .statusCode(RestResponse.StatusCode.OK);
    }
}