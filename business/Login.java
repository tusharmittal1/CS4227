package business;
import java.util.ArrayList;


import controllers.UIController;
import persistance.DatabaseAccessObject;
import users.User;

public class Login{
	private UIController ui = new UIController();
	private User currentUser;
	
	public int checkLogin( String in_Username , String in_Password ){
		boolean success = false;
	
		DatabaseAccessObject dc = null;
		try {
			dc = new DatabaseAccessObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = dc.getUsers();
		for( User temp : tempUsers ){
			if( temp.getUsername().matches(in_Username) && temp.getPassword().matches(in_Password)){
				currentUser = temp;
				success = true;
			}
	
		}
		if(success && (currentUser instanceof User)) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public void registerUser(String in_Username, String in_Password) {
		boolean success = false;
		
		DatabaseAccessObject dc = null;
		dc = new DatabaseAccessObject();
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = dc.getUsers();
		for( User temp : tempUsers ){
			if(temp.getUsername().matches(in_Username)){
				success = true;
			}
		}
		if(!success) {
			dc.addUser(in_Username, in_Password);
			System.out.print("User Created");
			ui.displayLogin();
		}
	}
	
	public int getUser(){
		return currentUser.getUserID();
	}
}