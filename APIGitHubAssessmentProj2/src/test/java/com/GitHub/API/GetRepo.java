package com.GitHub.API;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.GitHub.POJO.responsePOJO;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRepo {
	RequestSpecification specOne;
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://api.github.com";
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		specOne = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
	}
	
	
	@Test
	public void getUserOneRepo() {
		
		Response res= RestAssured
		.given()
			.log().all()
			.header("Authorization", "Bearer token")
		.when()
		 .get("/repos/meenunigam/TestPostMan");
		
		res.then()
	 		.statusCode(200);
		res.body().prettyPrint();
		res.then().log().all()
		
		JsonPath jsonpath = res.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println(repoNames);
		String fullName = jsonpath.getString("full_name");
		System.out.println(fullName);
		String defBranch = jsonpath.getString("default_branch");
		System.out.println("Default Branch is " + defBranch);
		
		System.out.println("Content type = " + res.header("Content-Type"));
	
		
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println("Status code = " + res.statusCode());
		
	}
	
	@Test
	public void getNonexistingRepo() {
		
		Response res= RestAssured
		.given()
			.header("Authorization", "Bearer token")
		.when()
		 .get("/repos/meenunigam/Junk");
		
		res.then()
	 	.statusCode(404);
		res.body().prettyPrint();
		
		JsonPath jsonpath = res.jsonPath();
		String message = jsonpath.getString("message");
		System.out.println("Message = " + message);
		
		Assert.assertEquals(res.statusCode(), 404);
		
		System.out.println("Status code = " + res.statusCode());
		
	}
	
	@Test
	public void getAllRepos() {
		
		Response res= RestAssured
		.given()
			.header("Authorization", "Bearer token")
		.when()
		 	.get("/user/repos");
		 res.then()
		 	.statusCode(200);
		 res.body().prettyPrint();
		 //res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema/GitHubResponseSchema.json"));
		
		
		//responsePOJO[] arrlist = res.as(responsePOJO[].class);
		//System.out.println(arrlist[0].getName());
		
		//List<responsePOJO> list = res.as(new TypeRef<List<responsePOJO>> () {});
		//System.out.println(list.get(0).);
		
		JsonPath jsonpath = res.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println(repoNames);
		String fullName = jsonpath.getString("full_name");
		System.out.println(fullName);
		String defBranch = jsonpath.getString("default_branch");
		System.out.println("Default Branch is " + defBranch);
		
		System.out.println("Number of Repos = " + repoNames.length());
		
		System.out.println("Content type = " + res.header("Content-Type"));
	
		
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println("Status code = " + res.statusCode());
		//System.out.println("Total Number of Repos = " + res.body().jsonPath().get("size"));
		
		//String id = jsonpath.getString("id");
		//System.out.println("Number of Repos = " + jsonpath.get("id.length()"));
		//System.out.println("Number of Repos = " + re);
		
		List<Integer> data = res.body().jsonPath().getList("findAll().name");
		System.out.println("Count of Repos = " + data.size());
		
	
		
	}

}
