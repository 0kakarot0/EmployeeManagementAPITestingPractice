package utils.request_builder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint);
    }

    public static Response postRequest(String endpoint, Object requestBody) {
        return given()
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    public static Response putRequest(String endpoint, Object requestBody) {
        return given()
                .body(requestBody)
                .when()
                .put(endpoint);
    }

    public static Response deleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint);
    }

    public static Response patchRequest(String endpoint, Object requestBody) {
        return given()
                .body(requestBody)
                .when()
                .patch(endpoint);
    }
}
