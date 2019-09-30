package pk_program;
import java.util.*;

import pk_business.Login;
import pk_controller.UIController;
import pk_database.DatabaseControl;
import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;

public class CinemaProgram {

	public static void main ( String args [] ){
		UIController uc = new UIController();
		uc.displayLogin();
	}

}
