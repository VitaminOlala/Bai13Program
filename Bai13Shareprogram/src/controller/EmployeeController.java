package controller;

import java.security.Provider.Service;

import entity.Employee;
import service.ServiceImpl;

public class EmployeeController {
	ServiceImpl sv = new ServiceImpl();
	
	public void addEmployee(Employee epl) {
		sv.add(epl);
	}
	public void showMainExp() {
		sv.showInfoExp();

	}
	public void showMainAll() {
		sv.showInfoAll();

	}
	public void showMainFresh() {
		sv.showInfoFresher();

	}
	public void showMainIntern() {

		sv.showInfoIntern();
	}
	
	public boolean removeById(int id) {
		return sv.deleteById(id);
	}
	public void saveToFile() {
		sv.saveFile();
	}
	public void readFromFile() {
		sv.readFile();;
	}
	public void countEpl() {
		
		System.out.println("Tong so nhan vien la: "+sv.count());
	}
}
