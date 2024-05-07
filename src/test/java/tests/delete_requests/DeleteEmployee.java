package tests.delete_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

@Test
public class DeleteEmployee extends TestBase {

    public void testDeleteEmployee() {
        // Define the employee ID to delete
        String employeeId = "719";

        // Send request to delete the employee
        Response response = RequestBuilder.deleteRequest("/delete/" + employeeId);
        Assert.assertEquals(response.getStatusCode(), 200);

        // Parse the response body
        String responseBody = ResponseParser.getResponseAsString(response);

        // Validate status is "success"
        Assert.assertTrue(responseBody.contains("\"status\":\"success\""));

        // Validate message indicates successful deletion
        Assert.assertTrue(responseBody.contains("successfully! deleted Records"));

        // You can add more validations as needed
    }
}
