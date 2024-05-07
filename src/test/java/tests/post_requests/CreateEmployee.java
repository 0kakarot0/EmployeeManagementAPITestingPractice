package tests.post_requests;


import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

@Test
public class CreateEmployee extends TestBase {

    public void testCreateEmployee() {
        // Define the request body for creating a new employee
        String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

        // Send request to create a new employee
        Response response = RequestBuilder.postRequest("/create", requestBody);
        Assert.assertEquals(response.getStatusCode(), 200);

        // Parse the response body
        String responseBody = ResponseParser.getResponseAsString(response);

        // Validate status is "success"
        Assert.assertTrue(responseBody.contains("\"status\":\"success\""));

        // Validate data contains the newly created employee details
        Assert.assertTrue(responseBody.contains("\"name\":\"test\""));
        Assert.assertTrue(responseBody.contains("\"salary\":\"123\""));
        Assert.assertTrue(responseBody.contains("\"age\":\"23\""));
        Assert.assertTrue(responseBody.contains("\"id\":"));

        // You can add more validations as needed
    }
}

