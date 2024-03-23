package com.GitHub.CRUD;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.GitHub.Base.APIHelper;
import com.GitHub.Base.BaseTest;
import com.GitHub.Utils.ExtentReportsUtility;
import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GitHubCRUDOper extends BaseTest{
	
	ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	APIHelper apihelper;
	String id, node_id, name, full_Name, description, homepage;
	boolean Private;
	private Faker faker;
	String repoName;
	String newRepoName;
	
	@BeforeClass
	public void doThisFirst() {
		faker = new Faker();
		apihelper = new APIHelper();
		repoName = "Hello-World" + faker.number().numberBetween(1, 200);
		System.out.println(repoName);
		newRepoName = repoName + faker.number().numberBetween(200, 400);
	}
	
	@Test (priority = 1, description = "Calls APIHelper for getOneRepo")
	public void validateGetOneRepo() {
		
		Response singleRepo = apihelper.getOneRepo(repoName);
		singleRepo.then()
 		.statusCode(200);
		singleRepo.body().prettyPrint();
		JsonPath jsonpath = singleRepo.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println(repoNames);
		String fullName = jsonpath.getString("full_name");
		System.out.println(fullName);
		String defBranch = jsonpath.getString("default_branch");
		System.out.println("Default Branch is " + defBranch);
		
		System.out.println("Content type = " + singleRepo.header("Content-Type"));
	
		
		Assert.assertEquals(singleRepo.statusCode(), 200);
		
		System.out.println("Status code = " + singleRepo.statusCode());
		
		report.logTestInfo("validateGetOneRepo has been validated successfully");
	}
	
	@Test (priority = 2, description = "Validate Get all Repos")
	public void validateGetAllRepos() {
		
		Response singleRepo = apihelper.getAllRepos();
		singleRepo.then()
 		.statusCode(200);
		singleRepo.body().prettyPrint();
		JsonPath jsonpath = singleRepo.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println(repoNames);
		String fullName = jsonpath.getString("full_name");
		System.out.println(fullName);
		String defBranch = jsonpath.getString("default_branch");
		System.out.println("Default Branch is " + defBranch);
		
		System.out.println("Content type = " + singleRepo.header("Content-Type"));
	
		
		Assert.assertEquals(singleRepo.statusCode(), 200);
		
		System.out.println("Status code = " + singleRepo.statusCode());
		
		report.logTestInfo("validateGetOneRepo has been validated successfully");
	}
	
	@Test(priority=0, description = "Create Repo")
	public void validateCreateRepo() throws IOException {
		
		Response createRepo = apihelper.createRepo(repoName);
		createRepo.then()
 		.statusCode(201);
		createRepo.body().prettyPrint();
		JsonPath jsonpath = createRepo.jsonPath();
		String repoNames = jsonpath.getString("name");
		System.out.println(repoNames);
		String fullName = jsonpath.getString("full_name");
		System.out.println(fullName);
		String defBranch = jsonpath.getString("default_branch");
		System.out.println("Default Branch is " + defBranch);
		
		System.out.println("Content type = " + createRepo.header("Content-Type"));
	
		
		Assert.assertEquals(createRepo.statusCode(), 201);
		
		System.out.println("Status code = " + createRepo.statusCode());
		
		report.logTestInfo("validateCreateRepo has been validated successfully");
	}

}
