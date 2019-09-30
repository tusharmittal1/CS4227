package pk_factory;

import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;

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