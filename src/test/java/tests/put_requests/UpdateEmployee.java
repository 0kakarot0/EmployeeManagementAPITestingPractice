package tests.put_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

@Test
public class UpdateEmployee extends TestBase {

    public void testUpdateEmployee() {
        // Define the employee ID and request body for updating the employee
        String employeeId = "25"; // ID of the employee to update
        String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

        // Send request to update the employee
        Response response = RequestBuilder.putRequest("/update/" + employeeId, requestBody);
        Assert.assertEquals(response.getStatusCode(), 200);

        // Parse the response body
        String responseBody = ResponseParser.getResponseAsString(response);

        // Validate status is "success"
        Assert.assertTrue(responseBody.contains("\"status\":\"success\""));

        // Validate data contains the updated employee details
        Assert.assertTrue(responseBody.contains("\"name\":\"test\""));
        Assert.assertTrue(responseBody.contains("\"salary\":\"123\""));
        Assert.assertTrue(responseBody.contains("\"age\":\"23\""));
        Assert.assertTrue(responseBody.contains("\"id\":" + employeeId));

        // You can add more validations as needed
    }
}
