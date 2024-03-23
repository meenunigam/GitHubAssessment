package com.GitHub.API;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateRepo {
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test(priority=0)
	public void createRepo() {
		File createData=new File("./src/test/resources/RequestData/createData.json");
		
		
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer ")
			.body(createData)
		.when()
		 .post("/user/repos");
		
		res.then()
	 	.statusCode(201);
		res.body().prettyPrint();
		
		JsonPath jsonpath = res.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println("New Repo Name = " + repoNames);
		
		String userName = jsonpath.getString("owner.login");
		System.out.println("Login Name = " + userName);
		
		String type = jsonpath.getString("owner.type");
		System.out.println("Type = " + type);
		
		Assert.assertEquals(res.statusCode(), 201);
		
		System.out.println("Status code = " + res.statusCode());
		
	}
	
	@Test(priority=1)
	public void createRepoExisting() {
		File updateData=new File("./src/test/resources/RequestData/updateData.json");
		
		
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer ")
			.body(updateData)
		.when()
		 .post("/user/repos");
		
		res.then()
	 	.statusCode(422);
		res.body().prettyPrint();
		
		JsonPath jsonpath = res.jsonPath();
		
		String message = jsonpath.getString("message");
		System.out.println("Message = " + message);
		
		Assert.assertEquals(res.statusCode(), 422);
		
		System.out.println("Status code = " + res.statusCode());
		
	}

}
