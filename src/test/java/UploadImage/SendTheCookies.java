package UploadImage;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.http.Cookie;

public class SendTheCookies {
	
	public static void main(String[] args) {
		baseURI = "https://reqres.in";
		Cookie cok = new Cookie.Builder("name","soumya").build();
		Map<String, String> map = new LinkedHashMap<>();
		map.put("jnbch", "2426547+");
		map.put("z sndxkh", "d cnndgbkv");
		
		given().cookie(cok).when().get("/api/users/9").then().statusCode(200).log().all();
		
		given().cookies(map).when().get("/api/users/7").then().statusCode(200).log().all();
				
	}

}
