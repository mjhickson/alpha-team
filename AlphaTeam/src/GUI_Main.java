import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/*
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Builds GUI interface for the HTML Editor
 */

public class GUI_Main extends JFrame {
	
	private GUI_ActionListener actionListener;
	private GUI_MenuBar menuBar;
	private Formatter formatter;
	private static JTabbedPane tabs;
	private JButton closeTab;
	
	public GUI_Main() {
		formatter = new Formatter();
		actionListener = new GUI_ActionListener();
		
		menuBar = new GUI_MenuBar();
		setJMenuBar(menuBar); //Set menuBar to the JFrame
		
		tabs = new JTabbedPane();
		closeTab = new JButton("x");
		

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
		
	}
	
	public static void addBuffer(Buffer buf) {
		tabs.add(buf.getFileName(), buf.getWindow());
		tabs.setSelectedIndex(tabs.getTabCount() - 1); //Set new tab as currently selected
	}
	
	/*
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
	
	/*
	 * Removes tab at desired index
	 * @param int Index of the tab to be removed
	 */
	public static void removeTab(int i) {
		tabs.remove(i);
	}
	
	public static void updateTabs() {
		for(int i = 0; i < tabs.getTabCount(); i++) {
			tabs.setTitleAt(i, Buffer.getBuffer(i).getFileName()); 	
		}

	}
	
	public static void main(String[] args) {
		//Set look and feel
	    try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	    	// handle exception
	    }
	
		GUI_Main frame = new GUI_Main();
		frame.setTitle("HTML Editor");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}