package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Emp;
import Pojo.Emp2;
import Pojo.EmpComplexData;
import Pojo.EmpSpouse;
import Pojo.EmployePOJO;

public class Serialization {
	@Test
	public void emp() throws JsonGenerationException, JsonMappingException, IOException {

		EmployePOJO poj = new EmployePOJO("soumya", "ty1235", "srjena@gmail.com", 2500, 24, 7077522939l);

		ObjectMapper map = new ObjectMapper();

		/*
		 * {"name":"soumya","empNo":"ty1235","email":"srjena@gmail.com","sal":2500,"age"
		 * :24,"phNo":7077522939}
		 */

		map.writeValue(new File("./emp1.json"), poj);

		/*
		 * { map.writerWithDefaultPrettyPrinter().writeValue(new File("./emp2.json"),
		 * poj); "name" : "soumya", "empNo" : "ty1235", "email" : "srjena@gmail.com",
		 * "sal" : 2500, "age" : 24, "phNo" : 7077522939 }
		 */
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./emp2.json"), poj);

	}

	@Test
	public void serializationWithComplexData() throws JsonGenerationException, JsonMappingException, IOException {

		int[] PhNo = { 12345, 45675 };

		String[] mail = { "acndfcb@gmail.com", "snedhbf@gmail.com" };
		EmpSpouse e = new EmpSpouse("jk", 21, PhNo);
		EmpComplexData data = new EmpComplexData("soumya", "yudb455", 25, PhNo, mail, 23, e);

		ObjectMapper obj = new ObjectMapper();

		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./cdData.json"), data);
	}

	@Test
	public void objectInsideObject() throws JsonGenerationException, JsonMappingException, IOException {

		int[] PhNo = { 12345, 45675 };
		String[] mail = { "acndfcb@gmail.com", "snedhbf@gmail.com" };
		EmpSpouse e = new EmpSpouse("jk", 21, PhNo);

		EmpComplexData po = new EmpComplexData("soumya", "whsd", 25000, PhNo, mail, 24, e);

		ObjectMapper obj = new ObjectMapper();

		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./coData.json"), po);
	}

	@Test
	public void arrayObject() throws JsonGenerationException, JsonMappingException, IOException {

		int[] PhNo = { 12345, 45675 };
		int[] PhNo1 = { 123453245, 4567524 };
		String[] mail = { "acndfcb@gmail.com", "snedhbf@gmail.com" };
		String[] mail1 = { "acndfcb,msdnf@gmail.com", "snedhbfsmdnkb@gmail.com" };
		EmpSpouse e = new EmpSpouse("jk", 21, PhNo);

		EmpSpouse e1 = new EmpSpouse("ndhfgjmnhjdsg", 21, PhNo1);

		EmpComplexData[] po = { new EmpComplexData("soumya", "whsd", 25000, PhNo, mail, 24, e),
				new EmpComplexData("Manoranjan", "xyz", 45000, PhNo1, mail1, 24, e1) };

		Emp employ[] = {new Emp(po)};
		
		
		ObjectMapper obj = new ObjectMapper();

		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./Data.txt"), employ);
	}

}
