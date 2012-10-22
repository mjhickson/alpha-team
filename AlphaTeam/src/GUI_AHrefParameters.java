/**
 * Supplies the input fields for inserting a link into the HTML
 * editor. It is created by GUI_Main and is made visible as needed
 * from a command in the action listener
 * @author Stephen Brewster
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GUI_AHrefParameters extends JFrame {
	private static JTextField url;
	private static JTextField text;
	private JLabel url_l;
	private JLabel text_l;
	private JButton confirmLink, cancel;
	GUI_ActionListener actionListener;
	
	public GUI_AHrefParameters() {
		actionListener = new GUI_ActionListener();
		
		//Declare and initialize GUI components
		url = new JTextField("http:\\\\");
			url.setCaretPosition(7);
			url.setPreferredSize(new Dimension(150,25));
		text = new JTextField();
			text.setPreferredSize(new Dimension(150,25));
		url_l = new JLabel("       URL: ");
		text_l = new JLabel("Link Text: ");
		
		confirmLink = new JButton("Confirm"); //Sends parameters through
			confirmLink.addActionListener(actionListener);
			confirmLink.setActionCommand("confirmLinkParameters");
		cancel = new JButton("Cancel"); //Cancels link insertion
			cancel.addActionListener(actionListener);
			cancel.setActionCommand("cancelLinkParameters");
		
		//Build Window
		setLayout(new GridLayout(3,1));
		
		JPanel url_p = new JPanel(); //Holds url fields
		url_p.add(url_l);
		url_p.add(url);
		
		JPanel text_p = new JPanel(); //holds text fields
		text_p.add(text_l);
		text_p.add(text);
		
		JPanel button_p = new JPanel(); //Holds action buttons
		button_p.add(confirmLink);
		button_p.add(cancel);
		
		add(url_p);
		add(text_p);
		add(button_p);
	}//Constructor

	public static String getURL() {
		return url.getText();
	}
	
	public static String getText() {
		return text.getText();
	}
	
	/**
	 * Clears the text fields
	 */
	public static void clearFields() {
		text.setText("");
		url.setText("http:\\");
	}
}