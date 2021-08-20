package entity;

import java.io.Serializable;

public class Experience extends Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getExplnYear() {
		return explnYear;
	}
	public void setExplnYear(int explnYear) {
		this.explnYear = explnYear;
	}
	public String getProSkill() {
		return proSkill;
	}
	public Experience(int id, String fullname, String birthday, String phone, String email, int explnYear,
			String proSkill) {
		super(id, fullname, birthday, phone, email);
		this.explnYear = explnYear;
		this.proSkill = proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	private int explnYear;
	private String proSkill;

	@Override
	public String getEmployee_type() {
		// TODO Auto-generated method stub
		 return "Chuyen vien";
	
	}
	public Experience(int explnYear, String proSkill) {
		super();
		this.explnYear = explnYear;
		this.proSkill = proSkill;
	}
	public Experience() {
		super();

	}	
	@Override
	public void ShowInfo() {

		System.out.println("Id: "+getId());
		System.out.println("Fullname: "+getFullname());
		System.out.println("Birthday: "+getBirthday());
		System.out.println("Phone: "+getPhone());
		System.out.println("email: "+getEmail());
		System.out.println("Employee type: "+getEmployee_type() );
		System.out.println("Employee count: "+getEmployee_count());  //static
		
		System.out.println("So nam kinh nghiem: "+explnYear);
		System.out.println("Ky nang chuyen mon: "+proSkill);
	}
	
//	public void nhapThongTin() {
//		super.nhapThongTin();
//		System.out.println("Nhap so nam kinh nghiem: ");
//		explnYear = Integer.parseInt(sc.nextLine());
//		System.out.println("Nhap ki nang: ");
//		proSkill = sc.nextLine();
//	}
}
