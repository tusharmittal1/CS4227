package pk_userUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pk_controller.UIController;

public class PaymentMenu extends Frame{

	private String[] options = {"PayPal", "Credit Card", "Debit Card"};
	private JComboBox paymentMethod;
	private JButton confirm;
	private String selected;
	public PaymentMenu(UIController object) {
		ui = object;
		displayFrame();
	}
	
	@Override
	void displayFrame() {
		paymentMethod = new JComboBox(options);
		JLabel amount = new JLabel("amount");
		confirm = new JButton("Confirm");
		paymentMethod.addActionListener(this);
		confirm.addActionListener(this);
		setTitle("New Booking");
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        paymentMethod.setAlignmentX(Component.CENTER_ALIGNMENT);
        amount.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(paymentMethod);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(amount);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(confirm);
        add(panel);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object button = e.getSource();
		if(button == paymentMethod) {
        	selected = paymentMethod.getSelectedItem().toString();
        	}
		if(button == confirm) {
			ui.addBooking(selected);
			dispose();
			ui.displayUserMenu();
		}
	}

}
