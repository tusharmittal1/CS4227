package pk_userUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class displayMovies extends Frame {
    JComboBox selectMovie;
    JComboBox selectDate;
    JComboBox selectTime;
    private String selectedMovie;
    private String selectedTime;
    private Date selectedDate;
    JButton viewSeats = new JButton("view seats");
    JLabel genre;

    public displayMovies(){
        displayFrame();
    }
    @Override
    void displayFrame() {
    	String[] name = ui.getMovieNames();
        selectMovie = new JComboBox(name);
        selectDate = new JComboBox();
        selectTime = new JComboBox();
        genre = new JLabel("");
        selectMovie.addActionListener(this);
        selectDate.addActionListener(this);
        selectTime.addActionListener(this);
        viewSeats.addActionListener(this);
        setTitle("New Booking");
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        selectMovie.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewSeats.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(selectMovie);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(genre);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(selectDate);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(selectTime);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(viewSeats);
        add(panel);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object getButton = e.getSource();
        if(getButton == selectMovie) {
        	selectedMovie = selectMovie.getSelectedItem().toString();
            genre.setText(ui.getGenre(selectedMovie));
            Date[] dates = ui.getDates(selectedMovie);
            selectDate.removeAllItems();
            for(int i = 0; i < dates.length; i++) {
                selectDate.addItem(dates[i]);
            }
        }
        if(getButton == selectDate) {
        	selectedDate = (Date) selectDate.getSelectedItem();
        	String[] times = ui.getTimes(selectedDate);
        	selectTime.removeAllItems();
        	for(int i = 0; i < times.length;i++) {
        		selectTime.addItem(times[i]);
        	}
        }
        if(getButton == viewSeats) {
        	selectedTime = selectTime.getSelectedItem().toString();
        	displaySeats display = new displaySeats(ui.getSeats(selectedTime), ui);
        }
    }
}
