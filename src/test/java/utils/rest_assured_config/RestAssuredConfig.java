package utils.rest_assured_config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.basic;

public class RestAssuredConfig {

    public static void setup() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        // You can add more configuration here, like authentication, headers, etc.
//        setAuthentication();
    }

    private static void setAuthentication() {
        // Example: Basic Authentication
        RestAssured.authentication = basic("your_username", "your_password");

    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .log().all();
    }
}
