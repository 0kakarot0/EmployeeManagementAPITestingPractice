package tests.get_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

public class GetEmployeeByName extends TestBase {

    @Test
    public void getEmployeeByName() {
        String name = "Bradley Greer";

        // Send request to get all employees
        Response response = RequestBuilder.getRequest("/employees");
        Assert.assertEquals(response.statusCode(), 200);

        //Parse the response Body
        String responseBody = ResponseParser.getResponseAsString(response);

        //Parse the json response
        JSONObject jsonResponse = new JSONObject(responseBody);

        //assert that status is success
        Assert.assertEquals(jsonResponse.getString("status"), "success");

        // get the employee data array
        JSONArray employeeDataArray = jsonResponse.getJSONArray("data");

        for (int i = 0; i < employeeDataArray.length(); i++) {
            JSONObject employeeObject = employeeDataArray.getJSONObject(i);
            String employeeName = employeeObject.getString("employee_name");

            if (employeeName.equals(name)) {
                System.out.println("Employee Found: " + employeeName);
                break;
            }
        }


    }
}
