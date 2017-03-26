package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entity.User;

public class UserDao {
	private String filename;
	public boolean login(User user) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filename));
			while (input.hasNext()) {
			String[] data=input.nextLine().split(",");
			//System.out.println(data[0]+","+data[1]);
			if(data[0].equals(user.getUsername()) && data[1].equals(user.getPassword())){
				input.close();
				return true;
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		input.close();
		return false;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	

}
