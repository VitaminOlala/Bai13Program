package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public abstract class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fullname;
	private String birthday;
	private String phone;
	private String email;
	private String employee_type;
	static int employee_count = 0;
	
	
	public Employee(int id, String fullname, String birthday, String phone, String email) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;

	}

	public static int getEmployee_count() {
		return employee_count;
	}

	public static void setEmployee_count(int employee_count) {
		Employee.employee_count = employee_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



//	public static int getEmployee_count() {
//		return employee_count ;
//	}


	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public Employee() {
		super();
//		employee_count++;
//		System.out.println("hellloo");
		
	}


	List<Certificate> listCer;

	public abstract void ShowInfo();




//	
//	public void BirthdayException() throws RuntimeException {
//		throw new RuntimeException("Nhap sai dinh dang ngay sinh");
//	}
	
}
