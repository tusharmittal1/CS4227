package pk_userUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pk_business.Login;

public class RegisterMenu extends Frame{
	private JTextField username = new JTextField();
    private JTextField password = new JTextField();
    private JButton loginButton = new JButton("Go back");
    private JButton createUser = new JButton("Register");

    public RegisterMenu(){
        displayFrame();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == loginButton) {
			LoginMenu login = new LoginMenu();
		}else
		{
			Login logi = new Login();
			logi.registerUser(username.getText(), password.getText());
		}
	}

	@Override
	void displayFrame() {
		setTitle("Login Screen");
        setLayout(new GridLayout(3,3));
        add(username);
        add(new JLabel("Username"));
        add(password);
        add(new JLabel("Password"));
        add(loginButton);
        add(createUser);
        loginButton.addActionListener(this);
        createUser.addActionListener(this);
        setSize(600,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		
	}
}
