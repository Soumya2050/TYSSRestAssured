package InterViewQuestion;

import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class HideSencitiveDataOutOfLog {
	
	@Test
	public void method() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Set<String> header = new LinkedHashSet<>();
		header.add("Pragma");
		header.add("X-Frame-Options");
		header.add("Transfer-Encoding");
		header.add("Vary");
		
		given().header("Pragma","no-cache")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(header)))
		.log().all()
		.when().get("/projects/TYP_PROJ_850").then().assertThat();
		
	}

}
