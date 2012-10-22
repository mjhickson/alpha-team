/**
 * Window for displaying a list of strings (urls) Can receive a full
 * arraylist or an individual string
 * 
 * @author Stephen Brewster
 */

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class GUI_LinkView extends JFrame {
	private static JTextArea disWindow;
	private static JScrollPane scroller;
	private static ArrayList<String> urlList;
	
	/**
	 * Default constructor: sets up GUI components
	 */
	public GUI_LinkView() {
		disWindow = new JTextArea();
			disWindow.setBorder(BorderFactory.createTitledBorder("Link View"));
		scroller = new JScrollPane(disWindow);
		urlList = new ArrayList<String>();
		add(scroller);
	}
	
	/**
	 * Displays a list of Strings (urls) in the link view window
	 * @param links ArrayList of strings to be displayed
	 */
	public static void displayLinks(ArrayList<String> links) {
		disWindow.setText("");
		
		for(int i = 0; i < links.size(); i++) {
			disWindow.append(links.get(i) + "\n");
		}
	}
	
	/**
	 * Adds a new url link to the static list
	 * @param link
	 */
	public static void addLink(String link) {
		urlList.add(link);
		displayLinks(urlList);
	}
	
	/**
	 * Receives a list of links to be displayed
	 * @param links ArrayList of strings (urls) to be displayed
	 */
	public static void setLinks(ArrayList<String> links) {
		urlList = links;
		displayLinks(urlList);
	}
}