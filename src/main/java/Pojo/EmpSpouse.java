package Pojo;

public class EmpSpouse {
	
	String name;
	int age;
	int []phNo;
	
	public EmpSpouse(String name, int age, int[] phNo) {
		super();
		this.name = name;
		this.age = age;
		this.phNo = phNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int[] getPhNo() {
		return phNo;
	}
	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}
	
	public EmpSpouse() {
		
	}
	
	

}
