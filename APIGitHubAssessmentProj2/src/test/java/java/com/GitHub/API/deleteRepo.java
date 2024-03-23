package com.GitHub.API;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class deleteRepo {
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void deleteExistingRepo() {
		
		
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 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")
		.when()
		 .delete("/repos/meenunigam/Hello-World2");
		
		res.then()
	 	.statusCode(204);
		
		Assert.assertEquals(res.statusCode(), 204);
		
		System.out.println("Status code = " + res.statusCode());
		
	}
	
	@Test
	public void deleteNonExistingRepo() {
		
		
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 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")
		.when()
		 .delete("/repos/meenunigam/NoRepo");
		
		res.then()
	 	.statusCode(404);
		
		res.body().prettyPrint();
		
		JsonPath jsonpath = res.jsonPath();
		
		String message = jsonpath.getString("message");
		System.out.println("Message = " + message);
		
		Assert.assertEquals(res.statusCode(), 404);
		
		System.out.println("Status code = " + res.statusCode());
		
	}

}
