package aravind.dto;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	private int iduser;
	private String name;
	private int age;

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
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public User(int iduser, String name, int age) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.age = age;
	}

	
}
