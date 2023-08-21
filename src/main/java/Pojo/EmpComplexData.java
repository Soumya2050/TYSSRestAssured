package Pojo;

public class EmpComplexData {

	String name;
	String empId;
	EmpSpouse spouse;
	int sal;
	int[] mobNo;
	String[] mail;
	int age;

	public EmpComplexData(String name, String empId, int sal, int[] mobNo, String[] mail, int age, EmpSpouse spouse) {
		super();
		this.name = name;
		this.empId = empId;
		this.sal = sal;
		this.mobNo = mobNo;
		this.mail = mail;
		this.age = age;
		this.spouse = spouse;

	}

	

	public EmpSpouse getSpouse() {
		return spouse;
	}



	public void setSpouse(EmpSpouse spouse) {
		this.spouse = spouse;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int[] getMobNo() {
		return mobNo;
	}

	public void setMobNo(int[] mobNo) {
		this.mobNo = mobNo;
	}

	public String[] getMail() {
		return mail;
	}

	public void setMail(String[] mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EmpComplexData() {

	}

}
