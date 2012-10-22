/**
 * Supplies the input fields for inserting an image into the HTML
 * editor. It is created by GUI_Main and is made visible as needed
 * from a command in the action listener
 * @author Stephen Brewster
 */

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFileChooser;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class GUI_ImgSrcParameters extends JFrame {
	private static JTextField path;
	private JLabel path_l;
	private JButton confirmImg, cancel, fileBrowse;
	private GUI_ActionListener actionListener;
	private static JLabel imgPreview;
	private static ImageIcon preview;
	private static JScrollPane imgScroller;
	
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

		preview = new ImageIcon("DefPreview.jpg");
		imgPreview = new JLabel(preview);
		imgScroller = new JScrollPane(imgPreview);
		
		//Build Window
		JPanel fullPanel = new JPanel();
		fullPanel.setLayout(new BoxLayout(fullPanel, BoxLayout.Y_AXIS));
		
		JPanel path_p = new JPanel(); //Holds url fields
		path_p.add(path_l);
		path_p.add(path);
		path_p.add(fileBrowse);
		
		JPanel button_p = new JPanel(); //Holds action buttons
		button_p.add(confirmImg);
		button_p.add(cancel);
		
		JPanel image_p = new JPanel();
		image_p.add(imgScroller);
		
		fullPanel.add(path_p);
		fullPanel.add(button_p);
		fullPanel.add(image_p);
		add(fullPanel);
	}//Constructor
	
	public static String getPath() {
		return path.getText();
	}
	
	/**
	 * Clears the text field
	 */
	public static void clearFields() {
		path.setText("");
	}
	
	/**
	 * Opens a JFileChooser for user selection of an image and sets
	 * the textfield to the chosen file
	 */
	public static void choosePath() {
		JFileChooser fChooser = new JFileChooser();
		fChooser.setApproveButtonText("Open");
		fChooser.showOpenDialog(null);
		path.setText(fChooser.getSelectedFile().getPath());
		preview = new ImageIcon(path.getText());
		imgPreview.setIcon(preview);
	}
}