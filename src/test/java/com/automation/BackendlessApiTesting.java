package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BackendlessApiTesting {

    String applicationId = "7A75552C-D1E1-4125-A95C-4337AC9240D3";
    String restApiKey = "/0B7315B9-0778-475C-8CD6-2B8EB6037012";

    String baseUrl = "https://api.backendless.com/";

@Test
public void testLoginApi(){
JSONObject requestBody = new JSONObject();
requestBody.put("login" , "harpreetkaur13@gmail.com");
requestBody.put("password", "password");

given().baseUri(baseUrl+applicationId+restApiKey).header("Content-Type", "application/json").body(requestBody.toJSONString())
.log().all().when().post("/users/login").then().log().all().statusCode(200);
}

}