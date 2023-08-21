package com.RMGyantra.Utility;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	/**
	 * This method is used to capture the data in the response body
	 * @param response
	 * @param path
	 * @return
	 */
	public String getData(Response response,String path) {
		
		String data = response.jsonPath().getString(path);
		return data;
	}

}
