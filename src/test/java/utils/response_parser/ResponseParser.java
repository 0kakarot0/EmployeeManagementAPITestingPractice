package utils.response_parser;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ResponseParser {

    public static String getResponseAsString(Response response) {
        return response.getBody().asString();
    }

    public static String getHeaderValue(Response response, String headerName) {
        return response.getHeader(headerName);
    }

    public static Headers getAllHeaders(Response response) {
        return response.getHeaders();
    }

    // Method to parse JSON response and extract a specific value by key
    public static String getJsonValueByKey(Response response, String key) {
        return response.jsonPath().getString(key);
    }

    // Method to extract a specific value from XML response by using XPath
    // Example: extractValueByXPath(response, "//book[1]/title")
    // This will extract the title of the first book in the XML response
    public static String extractValueByXPath(Response response, String xPathExpression) {
        return response.xmlPath().getString(xPathExpression);
    }
}
