package tests.get_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

@Test
public class GetEmployeeByID extends TestBase {

    public void testGetEmployeeByID() {
        // Define the employee ID you want to retrieve
        String employeeId = "1";

        // Send request to get the employee by ID
        Response response = RequestBuilder.getRequest("/employee/" + employeeId);
        Assert.assertEquals(response.getStatusCode(), 200);

        // Parse the response body
        String responseBody = ResponseParser.getResponseAsString(response);

        // Validate status is "success"
        Assert.assertTrue(responseBody.contains("\"status\":\"success\""));

        // Validate data contains the employee's ID
        Assert.assertTrue(responseBody.contains("\"id\":" + employeeId));

        // Validate data contains other expected fields (e.g., employee_name, employee_salary, etc.)
        Assert.assertTrue(responseBody.contains("\"employee_name\":"));

        // You can add more validations as needed
    }
}
