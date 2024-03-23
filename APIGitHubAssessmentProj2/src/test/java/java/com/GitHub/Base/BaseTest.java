package com.GitHub.Base;



import org.testng.annotations.BeforeSuite;

import com.GitHub.Utils.EnvironmentDetails;

public class BaseTest {
	 @BeforeSuite
	    public void beforeSuite() {
	        EnvironmentDetails.loadProperties();
	        //TestDataUtils.loadProperties();
	    }

}
