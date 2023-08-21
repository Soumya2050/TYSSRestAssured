package Pojo;

public class EmployePOJO {
	
	String name;
	String empNo;
	String email;
	int  sal;
	int age;
	long phNo;
	public EmployePOJO(String name, String empNo, String email, int sal, int age, long phNo) {
		super();
		this.name = name;
		this.empNo = empNo;
		this.email = email;
		this.sal = sal;
		this.age = age;
		this.phNo = phNo;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	
	public EmployePOJO() {
		
	}
	

}
