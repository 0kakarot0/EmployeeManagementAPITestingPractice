package tests.get_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

public class GetEmployees extends TestBase {
    @Test
    public void testGetAllEmployees() {
        // Send request to get all employees
        Response response = RequestBuilder.getRequest("/employees");
        Assert.assertEquals(response.getStatusCode(), 200);

        // Parse the response body
        String responseBody = ResponseParser.getResponseAsString(response);

        // Validate status is "success"
        Assert.assertTrue(responseBody.contains("\"status\":\"success\""));

        // Validate data is not empty
        Assert.assertTrue(responseBody.contains("\"data\":"));

        // Validate each employee's name
        String[] employeeNames = {"Tiger Nixon", "Garrett Winters", "Ashton Cox", "Cedric Kelly", "Airi Satou"};
        for (String employeeName : employeeNames) {
            Assert.assertTrue(responseBody.contains("\"employee_name\":\"" + employeeName + "\""));
        }
    }

}
