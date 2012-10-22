/**
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Builds GUI interface for the HTML Editor. Holds the frames for 
 * inputting HTML tag parameters and the link view window. 
 * @author Stephen Brewster
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Observable;

class GUI_Main extends JFrame {

	private GUI_ActionListener actionListener;
	private GUI_MenuBar menuBar;
	private Formatter formatter;
	private static JTabbedPane tabs;
	private static JFrame aHrefFrame, imgSrcFrame, linkView;

	public GUI_Main() {
		formatter = new Formatter();
		actionListener = new GUI_ActionListener();
		
		menuBar = new GUI_MenuBar();
		setJMenuBar(menuBar); //Set menuBar to the JFrame
		
		tabs = new JTabbedPane(); //Holds all bufferwindows opened

		//Build panels
		//Left Panel
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(150,0));
		leftPanel.setBorder(formatter.getBorder());
		leftPanel.setBackground(formatter.getBg());
			leftPanel.add(new GUI_ButtonPanel());
			add(leftPanel, BorderLayout.WEST);
		
		//Center Panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,1));
		centerPanel.setBorder(formatter.getBorder());
		centerPanel.setBackground(formatter.getBg());
		centerPanel.add(tabs);
			add(centerPanel, BorderLayout.CENTER);

			
		//Create the link input frame and set parameters
		aHrefFrame = new GUI_AHrefParameters();
		aHrefFrame.setVisible(false);
		aHrefFrame.setBounds(500, 300, 250, 170);
		aHrefFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Create img src frame for specifing an img to create tag for
		imgSrcFrame = new GUI_ImgSrcParameters();
		imgSrcFrame.setVisible(false);
		imgSrcFrame.setBounds(500, 300, 450, 120);
		imgSrcFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Create link view frame for displaying URL lists
		linkView = new GUI_LinkView();
		linkView.setVisible(false);
		linkView.setBounds(850, 50, 200, 400);
		linkView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	/**
	 * Public method which saves the currently selected buffer content to its file
	 */
	public static int getSelectedTab() {
		//Check for no open file buffers 
		if(tabs.getTabCount() >= 1) {
			return tabs.getSelectedIndex();
		} else {
			return -1; //Return -1 if there are no tabs open
		}
	}
	
	/**
	 * Removes tab at desired index
	 * @param int Index of the tab to be removed
	 */
	public static void removeTab(int i) {
		tabs.remove(i);
	}
	
	/**
	 * Updates the file names on the tabs
	 */
	public static void updateTabs() {
		for(int i = 0; i < tabs.getTabCount(); i++) {
			tabs.setTitleAt(i, GUI_BufferWindow.getWindow(i).getTitle()); 	
		}
	}

	/**
	 * Adds a new buffer to the GUI
	 * @param win JScrollPane window object
	 */
	public static void addBuffer(GUI_BufferWindow win) {
		tabs.add(win.getWindow(), win.getTitle());
		tabs.setSelectedIndex(tabs.getTabCount() - 1);
	}
	
	/**
	 * Sets the visibility of the A Href link insertion input window
	 * @param vis Boolean visibility value for the window
	 */
	public static void setLinkInputVisible(boolean vis) {
		aHrefFrame.setVisible(vis);
	}
	
	/**
	 * Returns the text located in the A Href parameter window
	 * @return aHrefInfo Array containing 2 strings used to insert a href tag
	 */
	public static String[] getLinkParameters() {
		String aHrefInfo[] = new String[2];
		aHrefInfo[0] = GUI_AHrefParameters.getURL(); //Retrieve URL
		aHrefInfo[1] = GUI_AHrefParameters.getText(); //Retrieve Text
			GUI_AHrefParameters.clearFields(); //Clear fields
		return aHrefInfo;
	}
	
	/**
	 * Sets the visibility of the Img Src path finder window
	 * @param vis Boolean visibility value for the window
	 */
	public static void setImgSrcInputVisible(boolean vis) {
		imgSrcFrame.setVisible(vis);
	}
	
	/**
	 * retreives the text in the path name file of the img src window
	 * @return path Pathname of the img tag to be inserted
	 */
	public static String getImgSrcParameters() {
		String pathName = GUI_ImgSrcParameters.getPath();
		GUI_ImgSrcParameters.clearFields();
		return pathName;
	}
	
	/**
	 * Sets the visibility of the link view window
	 * @param vis Boolean value for the window visibility
	 */
	public static void setLinkViewVisible(boolean vis) {
		linkView.setVisible(vis);
	}
	
	/**
	 * Main method runs HTML Editor
	 * @param args
	 */
	public static void main(String[] args) {
		//Set look and feel
	    try {
       //  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	    	// handle exception
	    }
	
		GUI_Main frame = new GUI_Main();
		frame.setTitle("HTML Editor");
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(50, 50, 800, 600 );
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}