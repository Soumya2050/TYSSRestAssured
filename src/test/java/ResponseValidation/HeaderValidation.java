package ResponseValidation;

import static io.restassured.RestAssured.*;

import static org.testng.Assert.*;
import io.restassured.response.Response;

public class HeaderValidation {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expected_stausLine = "HTTP/1.1 200 ";
		String expected_vary = "Access-Control-Request-Headers";
		String expected_Pragma = "no-cache";
		String expected_Connection = "keep-alive";
		String expected_Content_Type = "application/json";
		String expected_Cache_Control = "no-cache, no-store, max-age=0, must-revalidate";

		Response response = when().get("/projects/TY_PROJ_12435");

		String statusline = response.statusLine();
		System.out.println(statusline);
		assertEquals(statusline, expected_stausLine);

		String vary = response.getHeader("Vary");
		System.err.println(vary);
		assertEquals(vary, expected_vary);

		String pragma = response.getHeader("Pragma");
		System.out.println(pragma);
		assertEquals(pragma, expected_Pragma);

		String connection = response.getHeader("Connection");
		System.err.println(connection);
		assertEquals(connection, expected_Connection);

		String contentType = response.getContentType();
		System.out.println(contentType);
		assertEquals(contentType, expected_Content_Type);

		String cacheControl = response.getHeader("Cache-Control");
		System.err.println(cacheControl);
		assertEquals(cacheControl, expected_Cache_Control);

	}

}
