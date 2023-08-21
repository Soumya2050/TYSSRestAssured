package UploadImage;

import static io.restassured.RestAssured.*;

import java.io.File;


public class UploadImageInPetStore {
	
	public static void main(String[] args) {
//		baseURI="petstore.swagger.io/v2";
		int petId = 2050;
		File  file = new File("./C:/Users/srjen/OneDrive/Pictures/Screenshots.png");
		
		given().pathParam("pid", petId).multiPart("Image", file).contentType("image/jpg")
		.when().post("https://petstore.swagger.io/v2/pet/{pid}")
		.then().assertThat().statusCode(200).log().all();
	}

}
