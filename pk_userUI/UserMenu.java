package pk_userUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class UserMenu extends Frame {

    private JButton createNewBooking = new JButton("create New Booking");
    private JButton reqRefund = new JButton("Request Refund");

    public UserMenu(){
        displayFrame();
    }
    @Override
    void displayFrame() {
        setTitle("UserMenu");
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        createNewBooking.addActionListener(this);
        reqRefund.addActionListener(this);
        createNewBooking.setAlignmentX(Component.CENTER_ALIGNMENT);
        createNewBooking.setAlignmentY(Component.CENTER_ALIGNMENT);
        reqRefund.setAlignmentX(Component.CENTER_ALIGNMENT);
        reqRefund.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.add(createNewBooking);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(reqRefund);
        add(panel);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if(buttonPressed == createNewBooking){
           displayMovies movies = new displayMovies();
        }
    }
}