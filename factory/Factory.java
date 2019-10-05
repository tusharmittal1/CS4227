package factory;

import users.Customer;
import users.Manager;
import users.User;

public class Factory {
	
	private User instance;
	public Factory(){
		
	}
	public User instanceManager(int s1 , String s2 , String s3){
		instance = new Manager( s1 ,  s2 ,  s3);
		return instance;
	}
	public User instanceCustomer(int s1 , String s2 , String s3){
		instance = new Customer( s1 ,  s2 ,  s3);
		return instance;
	}
}