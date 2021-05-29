package com.automation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BestbuyAPIPlayground {
	JSONObject requestBody;
	String baseUrl = "http://localhost:3030";
	String Id = "";

	@BeforeTest
	public void beforeMethod() {
		baseURI = baseUrl;

	}

	@Test
	@Ignore
	public void getAllStoresData() {

		Response response = given().header("Content-Type", "application/json").when().get("/stores");
		System.out.println("Response : " + response.asPrettyString());
	}

	@Test
	public void addNewStore() {

		Response response = given().header("Content-Type", "application/json").body(addNewStoreData().toJSONString())
				.log().all().when().post("/stores");
		System.out.println("Response : " + response.asPrettyString());

		JsonPath jsonpath = response.jsonPath();

		Id = jsonpath.getString("id");
		System.out.println("Id " + Id);

	}

	@Test
	public void deleteNewAddedStore() {
		Response response = given().header("Content-Type", "application/json").when().delete("/stores/" + Id);
		System.out.println("Response : " + response.asPrettyString());
	}

	@Test
	public void getDataOfdeletedStore() {
		Response response = given().header("Content-Type", "application/json").when().get("/stores/8937");
		System.out.println("Response : " + response.asPrettyString());
	}

	public JSONObject addNewStoreData() {
		requestBody = new JSONObject();
		requestBody.put("name", "besyBuy");
		requestBody.put("type", "E- commerce");
		requestBody.put("address", "abc");
		requestBody.put("address2", "ABCD");
		requestBody.put("city", "Brampton");
		requestBody.put("state", "ON");
		requestBody.put("zip", "12345");
		requestBody.put("lat", 0);
		requestBody.put("lng", 0);
		requestBody.put("hours", "3");
		return requestBody;
	}

	@AfterMethod
	public void afterMethod() {

	}

}
