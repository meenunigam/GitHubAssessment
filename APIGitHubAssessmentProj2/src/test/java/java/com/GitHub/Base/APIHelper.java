package com.GitHub.Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;

import com.GitHub.Utils.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class APIHelper {
	
	RequestSpecification reqSpec;
	
	public APIHelper() {
		RestAssured.baseURI = EnvironmentDetails.getProperty("baseURL");
		reqSpec = RestAssured.given();
		
	}
	
	public HashMap<String, String> getHeaders() {
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", EnvironmentDetails.getProperty("token"));
		return headers;
		
	}
	
	public Response getOneRepo(String repoName) {
		reqSpec = RestAssured.given();
		reqSpec.headers(getHeaders());
		String owner = EnvironmentDetails.getProperty("owner");
		Response response = null;
		
		try {
			response = reqSpec.get("/repos/" + owner + "/" + repoName);
			response.then().log().all();
			
		}
		catch (Exception e){
			Assert.fail("GetData is failing due to " + e.getMessage());
		}
		return response;
	}
	
	public Response getAllRepos() {
		
		reqSpec = RestAssured.given();
		reqSpec.headers(getHeaders());
		Response response = null;
		
		try {
			response = reqSpec.get("/user/repos");
			response.then().log().all();
			
		}
		catch (Exception e){
			Assert.fail("GetData is failing due to " + e.getMessage());
		}
		return response;
	}
	
	public Response getNBonExistingRepo() {
		
		reqSpec = RestAssured.given();
		reqSpec.headers(getHeaders());
		String owner = EnvironmentDetails.getProperty("owner");
		Response response = null;
		
		try {
			response = reqSpec.get("/repos"  + owner + "/" + "Junk");
			response.then().log().all();
			
		}
		catch (Exception e){
			Assert.fail("GetData is failing due to " + e.getMessage());
		}
		return response;
	}
	
public Response createRepo(String repoName) throws IOException {
		
		File updateData=new File("./src/test/resources/RequestData/updateData.json");
		ObjectMapper objMap = new ObjectMapper();
		JsonNode rootNode = objMap.readTree(updateData);
		((ObjectNode) rootNode).put("name",repoName);
		//write the modified json back to the file
		objMap.writeValue(updateData, rootNode);
		
		//String requestBody = "{\"name\":\" + repoName + \",\"description\":\"Thisisyourfirstrepo!\",\"homepage\":\"https://github.com\",\"private\":false,\"}";
		reqSpec = RestAssured.given();
		reqSpec.headers(getHeaders());
		Response response = null;
		
		try {
			reqSpec.body(updateData);
			response = reqSpec.post("/user/repos");
			response.then().log().all();
			
		}
		catch (Exception e){
			Assert.fail("GetData is failing due to " + e.getMessage());
		}
		return response;
	}
	

}
