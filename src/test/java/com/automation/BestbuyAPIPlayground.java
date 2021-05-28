package com.automation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BestbuyAPIPlayground {
	JSONObject requestBody;
	String baseUrl = "http://localhost:3030";

	@BeforeTest
	public void beforeMethod() {
		baseURI = baseUrl;

	}

	@Test
	public void getAllStoresData() {

		Response response = given().header("Content-Type", "application/json").when().get("/stores");
		System.out.println("Response : " + response.asPrettyString());
	}

	@Test
	public void addNewStore() {

		requestBody = new JSONObject();
		requestBody.put("name", "besyBuy");
		requestBody.put("type", "E- commerce");
		
		requestBody.put("address","abc");
		requestBody.put("address2","ABCD");
		requestBody.put("city","Brampton");
		requestBody.put("state","ON");
		requestBody.put("zip","12345");
		requestBody.put("lat", 0);
		requestBody.put("lng",0);
		requestBody.put("hours","3");
	

	Response response=	given().header("Content-Type", "application/json").body(requestBody.toJSONString()).log().all().when()
				.post("/stores");
	System.out.println("Response : " + response.asPrettyString());
	
	
	}

	@AfterMethod
	public void afterMethod() {

	}

}
