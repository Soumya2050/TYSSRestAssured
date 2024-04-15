package requestAndResponseSpecBuilder;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.CreateApojoRMG;
import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateProjectRMG {

	public static void main(String[] args) {
		JavaUtility jLib = new JavaUtility();

		CreateApojoRMG postData = new CreateApojoRMG("Soumya", "soumya~~" + jLib.getRandomNum() + "", "ongoing", 12);

		RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification respone = new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).build();

		given().spec(request).body(postData).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().spec(respone).time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
				/* .statusLine(Matchers.stringContainsInOrder("Created")) */.log().all();

	}

	@Test
	public void a() {
		String s = "aabbacnn";
		LinkedHashMap<Character, Object> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), null);
		}

		for (Entry<Character, Object> m : map.entrySet()) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (m.getKey() == s.charAt(i)) {
					count++;
				}
			}
			System.out.println(m.getKey() + " occures " + count);
		}
	}

	@Test
	public void arrayReverse() {
		String s = "aabbacnn";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!(map.containsKey(s.charAt(i)))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		for (Entry<Character, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + "====>" + m.getValue());
		}

	}

	@Test
	public void ArrayReverse() {
		int a[] = { 1, 2, 4, 3, 5 };
//		output= {5,4,3,2,1};

		System.out.print("{");
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];// i=0>1,i=1>2,i=2>3,i=3>4
			a[i] = a[n - i - 1];// 6,5,4
			a[n - i - 1] = temp;// 1,2,3
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			if (i < n - 1) {
				System.out.print(",");
			}
		}
		System.out.print("}");
	}

	@Test
	public void countSpaceInaString() {
		String s = "my name is soumya";
		String str[] = s.split(" ");
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if ((str[i] != " ")) {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void replace() {

		int a[] = { 1, 2, 4, 3, 5 };
		int n = a.length - 1;

		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[n];
			a[n--] = temp;
		}
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void amastrongNumber() {
		int n
		= 153;
		int temp = n;
		int rem = 0;
		int sum = 0;
		while (n > 0) {
			rem = n % 10;
			sum += rem * rem * rem;
			n = n / 10;
		}
		if (temp == sum) {
			System.out.println(sum + " : is an amastrong number ");
		} else {
			System.out.println(sum + " : is not an amastrong number ");
		}
	}

}
