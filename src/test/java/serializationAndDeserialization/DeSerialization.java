package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpComplexData;
import Pojo.EmployePOJO;

public class DeSerialization {

	@Test
	public void emp() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper obj = new ObjectMapper();
		 EmployePOJO data = obj.readValue(new File("./emp1.json"), EmployePOJO.class);
		  System.out.println("NAME:- " + data.getName());
		   System.out.println("MAIL:- " + data.getEmail());
		    System.out.println("AGE:- " + data.getAge());
		     System.out.println("EMPNO:- " + data.getEmpNo());
		      System.out.println("SAL:- " + data.getSal());
		       System.out.println("PHno:- " + data.getPhNo());

	}
	
	
	@Test
	public void deSerializationWithComplexData() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper obj = new ObjectMapper();
		
		EmpComplexData data = obj.readValue(new File("./cData.json"), EmpComplexData.class);
		
		System.out.println(data.getName());
		System.out.println(data.getEmpId());
		System.out.println(data.getSal());
		System.out.println("MAIL:- " +data.getMail()[0]);
		System.out.println(data.getMobNo()[1]);
		System.out.println("AGE:- " +data.getAge());
	}
	
	@Test
	public void objectInSideObject() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		
		EmpComplexData data = obj.readValue(new File("./coData.json"), EmpComplexData.class);
		
		System.out.println("Emp Name:- "+data.getName());
		System.out.println("EmpId:-"+data.getEmpId());
		System.err.println("EmpSpouseName:-"+data.getSpouse().getName());
		System.err.println("EmpSpouseAge:-"+data.getSpouse().getAge());
		System.err.println("EmpSpousePhNo:-"+data.getSpouse().getPhNo()[0]);
		System.out.println("EmpSal:-"+data.getSal());
		System.out.println("EmpMail:- "+data.getMail()[0]);
		System.out.println("EmpPhNo:- "+data.getMobNo()[1]);
		System.out.println("EmpAge:- "+data.getAge());
	}

}
