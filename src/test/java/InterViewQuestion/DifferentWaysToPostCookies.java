package InterViewQuestion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

public class DifferentWaysToPostCookies {
	
	@Test
	public void method1() {
		
		given().cookie("abcg","52572")
		.cookie("sndjhd","djhj65")
		.get("/endPoint");		
	}
	
	@Test
	public void method2() {
		baseURI = "https://reqres.in";
		
		Map<String, String> map = new LinkedHashMap<>();
		map.put("jnbch", "2426547+");
		map.put("z sndxkh", "d cnndgbkv");
		map.put("smndf", "32563msjdgf");
		
		given().cookies(map).when().get("/api/users/7").then().statusCode(200).log().all();
	}
	
	@Test
	public void method3() {
		
		baseURI = "https://reqres.in";
		Cookie cok = new Cookie.Builder("name","soumya").build();
		given().cookie(cok).when().get("/api/users/9").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void method4() {
		
		baseURI = "https://reqres.in";
		 RequestSpecification request = new RequestSpecBuilder()
				.addCookie("mdnf","sdnfbr")
				.addCookie("mwndfb","sdnbh")
				.addCookie("mdfcn b","sjdbhcgfh").build();
		 
		 given().spec(request).when().get("/api/users/9").then().log().all();
				
	}

}
