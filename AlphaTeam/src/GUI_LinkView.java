/**
 * Window for displaying a list of strings (urls) Can receive a full
 * arraylist or an individual string
 * 
 * @author Stephen Brewster
 */

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class GUI_LinkView extends JFrame {
	private static JTextArea disWindow;
	private static JScrollPane scroller;
	private static ArrayList<String> urlList;
	private JButton refresh, sort;
	private GUI_ActionListener actionListen;
	
	/**
	 * Default constructor: sets up GUI components
	 */
	public GUI_LinkView() {
		actionListen = new GUI_ActionListener();
		disWindow = new JTextArea();
			disWindow.setBorder(BorderFactory.createTitledBorder("Link View"));
		scroller = new JScrollPane(disWindow);
			scroller.setPreferredSize(new Dimension(180,300));
		urlList = new ArrayList<String>();
		
		refresh = new JButton("Refresh");
			refresh.addActionListener(actionListen);
		sort = new JButton("Sort");
			sort.addActionListener(actionListen);
		
		JPanel fullPanel = new JPanel();
		fullPanel.setLayout(new BoxLayout(fullPanel, BoxLayout.Y_AXIS));
		
		JPanel text_p = new JPanel();
		text_p.add(scroller);
		
		JPanel button_p = new JPanel();
		button_p.add(refresh);
		button_p.add(sort);
		
		fullPanel.add(text_p);
		fullPanel.add(button_p);
		
		add(fullPanel);
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
	
	/**
	 * Sorts links in the display alphabetically using bubble sort
	 */
	public static void sortLinks() {
		boolean sorted = false;
		
		//While still unsorted keep sorting
		while(!sorted) {
			sorted = true; //Checks for a fully sorted list
			String holder = "";
			
			//Main sorting loop
			for(int i = 0; i < urlList.size() - 1; i++) {
				if(urlList.get(i).compareToIgnoreCase(urlList.get(i+1)) >= 0) {
					holder = urlList.get(i);
					urlList.set(i, urlList.get(i+1));
					urlList.set(i + 1, holder);
					sorted = false; //Not sorted yet
				}
			}//for(i)
		}//while
		
		displayLinks(urlList); //Display the newly sorted list
	}//sortLinks
}