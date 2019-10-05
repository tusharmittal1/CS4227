package userInterface;

import javax.swing.*;

import controllers.UIController;

import java.awt.event.ActionListener;

abstract class Frame extends JFrame implements ActionListener {
	UIController ui = new UIController();
    abstract void displayFrame();
}
