package com.GitHub.API;

import java.io.File;

import static org.hamcrest.Matcher.*;

import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateRepo {
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void UpdateRepo() {
		File updateData=new File("./src/test/resources/RequestData/updateData.json");
		
		
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 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")
			.body(updateData)
		.when()
		 .patch("/repos/meenunigam/sample");
		
		res.then()
	 	.statusCode(200);
		
		res.body().prettyPrint();
		
		JsonPath jsonpath = res.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println("New Repo Name = " + repoNames);
		
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println("Status code = " + res.statusCode());
		res.then().statusCode(200);
		res.prettyPrint();
		//res.then().body("Status",Matcher.is("success"));
		
	}

}
