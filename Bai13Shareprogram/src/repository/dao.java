package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class dao {
	private static final String File_name = "list.txt";
	
	public void write(List<Employee> list) throws IOException {
		System.out.println("Bat dau luu");
		
		FileOutputStream out = null;
		ObjectOutputStream outO = null;
		try {
			out = new FileOutputStream(new File(File_name), true);
			outO = new ObjectOutputStream(out);
			outO.writeObject(list);
			closeStream(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			closeStream(outO);
		}
	}
	


	public List<Employee> read() {
	        List<Employee> employeeList = new ArrayList<>();
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            fis = new FileInputStream(File_name);
	            ois = new ObjectInputStream(fis);
	            employeeList =  (List<Employee>) ois.readObject();
	            closeStream(fis);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            
	            closeStream(ois);
	        }
	        return employeeList;
	    }
	 
	    private void closeStream(InputStream is) {
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	    private void closeStream(OutputStream os) {
	        if (os != null) {
	            try {
	                os.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
