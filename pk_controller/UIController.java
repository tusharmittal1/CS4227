package pk_controller;


import java.util.*;

import pk_business.Login;
import pk_business.Menu;
import pk_userUI.LoginMenu;
import pk_userUI.UserMenu;
import pk_userUI.displaySeats;
import pk_users.User;
public class UIController {
	
	private Menu newMenu;
	private static int userId;
	private String[] seats;
	
	public void displayLogin() {
		LoginMenu menu = new LoginMenu();
	}
	
	public void displayUserMenu() {
		UserMenu menu = new UserMenu();
	}
	
	public void checkLogin(String username, String password) {
		Login login = new Login();
		int openMenu = login.checkLogin(username, password);
		userId = login.getUser();
		if(openMenu == 1) {
			displayUserMenu();
		}
		else {
			displayLogin();
		}
	}

	public String[] getMovieNames() {
		newMenu = new Menu();
		return newMenu.getMovieNames();
	}
	
	public String getGenre(String name) {
		return newMenu.getGenre(name);
	}
	
	public Date[] getDates(String name) {
		return newMenu.getDates(name);
	}
	
	public String[] getTimes(Date date) {
		return newMenu.getTimes(date);
	}
	
	public String[] getSeats(String time) {
		seats = newMenu.getSeats(time);
		return seats;
	}
	
	public void setSeats(String[] array, int numberOfSeats) {
		newMenu.setSeats(array, numberOfSeats);
	}
	
	public void addBooking(String paymentType) {
		newMenu.addBooking(paymentType,userId);
	}
}
