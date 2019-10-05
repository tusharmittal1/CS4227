package userInterface;

import javax.swing.*;

import controllers.UIController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame implements ActionListener {
    private JTextField username = new JTextField();
    private JTextField password = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton createUser = new JButton("Create User");

    public LoginMenu(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
        if(buttonPressed == loginButton){
                UIController ui = new UIController();
                ui.checkLogin(username.getText(), password.getText());
                dispose();
        }
        else {
        	dispose();
        	RegisterMenu menu = new RegisterMenu();
        	
        }
    }
}