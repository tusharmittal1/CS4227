package pk_userUI;

import javax.swing.*;

import pk_controller.UIController;

import java.awt.event.ActionListener;

abstract class Frame extends JFrame implements ActionListener {
	UIController ui = new UIController();
    abstract void displayFrame();
}
