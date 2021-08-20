package service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import repository.dao;
import repository.repo;

import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ServiceImpl implements Service{
	public static Scanner sc = new Scanner(System.in);
	repo repos = new repo();
	static int count =0;
//	List<Experience> li3 = repos.getListExp();
//	List<Fresher> li1 = repos.getListFresh();
//	List<Intern>li= repos.getListIntern();
	
	
	private dao employeeDao;
	List<Employee> list = repos.getListEpl();
	
	public ServiceImpl() {
		employeeDao = new dao();
//		list = employeeDao.read();
	}

	@Override
	public void add(Employee epl) {
		 
		
		if(epl instanceof Experience) {
			Experience exp = (Experience) epl;
			list.add(exp);
			
			count++;



		}
		else if(epl instanceof Fresher) {
			Fresher fr = (Fresher) epl;
			list.add(fr);
			count++;


		
		}else if(epl instanceof Intern) {
			Intern in = (Intern) epl;
			repos.getListEpl().add(in);
			count++;

		}

	}

//	private void getEmployee_count() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		Employee epl = null;
		boolean check  = false;
		for(int i=0; i<list.size(); i++) {
			if(id == list.get(i).getId()) {
					check = true;
//					list.get(i).setFullname();
//					list.get(i).setBirthday();
//					list.get(i).setEmail();
//					list.get(i).setExplnYear();
//					list.get(i).setPhone();
//					list.get(i).
				
			}
		}
		
	}
	
	private String inputName() {
		System.out.println("Nhap lai fullname: ");
		return sc.nextLine();
	}

	private String inputBirthday() {
		String he;
		while (true) {
			
			System.out.println("Nhap ngay sinh: ");
			he = sc.nextLine();
			
			if (he.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date d = sdf.parse(he);
					String b2 = sdf.format(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			} else {
				System.out.println("Sai ngay sinh hop le");
			}
		}
		return he;
	}
	private String inputEmail() {
		String phone;
		while(true) {
			try {
				System.out.println("Nhap phone number: ");
				phone = sc.nextLine();
				Pattern p = Pattern.compile("^[0-9]"); //Nhap dung 10 so {10}$
				if(p.matcher(phone).find()) {
					System.out.println("Phone valid");
					break;
				}				
			}catch(Exception e) {
				System.out.println("Sai dinh dang phone.Nhap lai:");
			}

//				throw new RuntimeException("Phone not valid");
			}
		return phone;
	}
	private String inputExplnYear() {
		System.out.println("Nhap lai so nam kinh nghiem: ");
		return sc.nextLine();
	}
	private String inputPhone() {
		System.out.println("Nhap lai phone: ");
		return sc.nextLine();
	}
	private String input() {
		System.out.println("Nhap lai fullname: ");
		return sc.nextLine();
	}
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub

		Employee em11 = this.list.stream().filter(epl -> epl.getId()== id).findFirst().orElse(null);
		
		if(em11 == null) {
			return false;
		}
		this.list.remove(em11);
//		try {
//			employeeDao.write(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		count--;
		return true;	
	}

	@Override
	public void showInfoExp() {
		
		for (Employee experience : list) {
			if(experience.getEmployee_type() == "Chuyen vien") {
			experience.ShowInfo();
			}
		}
	}

//	@Override
//	public void countEmployee() {
//		this.list.stream().map(epl -> epl.getId()).count();
//	}

	@Override
	public void showInfoFresher() {
		
		for (Employee epl : list) {
			if(epl.getEmployee_type() == "Fresher") {
			
				epl.ShowInfo();
			}
		}
//		return this.list.stream().filter(o -> o.getEmployee_type().contains("Fresher")).collect(Collectors.toList());
	}

	@Override
	public void showInfoIntern() {
		
		for (Employee epl : list) {
			if(epl.getEmployee_type() == "Thuc tap sinh") {
				
				epl.ShowInfo();
			}
		}
//		return this.list.stream().filter(o -> o.getEmployee_type().contains("Thuc tap sinh")).collect(Collectors.toList());
	}

	@Override
	public void showInfoAll() {

		 this.list.stream().forEach(epl -> epl.ShowInfo());
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		try {
			employeeDao.write(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
	}

	@Override
	public void readFile() {
		// TODO Auto-generated method stub
		list=employeeDao.read();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
		
	}
	
	

}
