package model;

public class Employee {
	private String empid;
	private String empfname;
	private String emplname;
	private String emppasswd;
	private int emprole;
	
	public Employee(String empid,  String emppasswd) {
		this.empid = empid;
		this.emppasswd = emppasswd;
	}
	public String getId() {return empid;}
	public String getFname() {return empfname;}
	public String getLname() {return emplname;}
	public String getPasswd() {return emppasswd;}
	public int getRole() {return emprole;}
}

