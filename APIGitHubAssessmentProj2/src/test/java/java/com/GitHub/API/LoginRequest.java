package com.GitHub.API;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class LoginRequest {
	private static String mytoken=null;
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
	}
	
	@Test
	public void loginToTekarch() {
		File file = new File("./src/test/resources/RequestData/LoginData.json");
		
		Response response = RestAssured
				.given().contentType(ContentType.JSON)
				.body(file)
				.when()
				.post("login");
		
		response.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(lessThan(4000L));
		response.prettyPrint();
		
		mytoken=response.body().jsonPath().get("[0].token");
		System.out.println("token recieved="+mytoken);
		System.out.println(response.statusCode());
	
	
	
	}
	

}
