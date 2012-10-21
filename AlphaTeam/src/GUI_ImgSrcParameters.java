/**
 * Supplies the input fields for inserting an image into the HTML
 * editor. It is created by GUI_Main and is made visible as needed
 * from a command in the action listener
 * @author Stephen Brewster
 */

import java.awt.Dimension;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GUI_ImgSrcParameters extends JFrame {
	private static JTextField path;
	private JLabel path_l;
	private JButton confirmImg, cancel, fileBrowse;
	GUI_ActionListener actionListener;
	
	public GUI_ImgSrcParameters() {
		actionListener = new GUI_ActionListener();
		
		//Declare and initialize GUI components
		path = new JTextField();
			path.setPreferredSize(new Dimension(300,25));
		path_l = new JLabel("Path: ");
		
		confirmImg = new JButton("Confirm"); //Sends parameters through
			confirmImg.addActionListener(actionListener);
			confirmImg.setActionCommand("confirmImgSrc");
		cancel = new JButton("Cancel"); //Cancels link insertion
			cancel.addActionListener(actionListener);
			cancel.setActionCommand("cancelImgSrc");
		fileBrowse = new JButton("...");
			fileBrowse.addActionListener(actionListener);
			fileBrowse.setActionCommand("fileBrowse");
		
		//Build Window
		setLayout(new GridLayout(3,1));
		
		JPanel path_p = new JPanel(); //Holds url fields
		path_p.add(path_l);
		path_p.add(path);
		path_p.add(fileBrowse);
		
		JPanel button_p = new JPanel(); //Holds action buttons
		button_p.add(confirmImg);
		button_p.add(cancel);
		
		add(path_p);
		add(button_p);
	}//Constructor
	
	public static String getPath() {
		return path.getText();
	}
	
	public static void clearFields() {
		path.setText("");
	}
	
	public static void choosePath() {
		JFileChooser fChooser = new JFileChooser();
		fChooser.setApproveButtonText("Save As");
		fChooser.showOpenDialog(null);
		path.setText(fChooser.getSelectedFile().getPath());
	}
}