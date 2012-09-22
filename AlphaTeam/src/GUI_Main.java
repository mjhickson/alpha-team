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
	private static ArrayList<Buffer> buff;
	private JButton add;

	public GUI_Main() {
		formatter = new Formatter();
		tabs = new JTabbedPane();
		actionListener = new GUI_ActionListener();
		buff = new ArrayList<Buffer>();
		
		menuBar = new GUI_MenuBar();
		setJMenuBar(menuBar); //Set menuBar to the JFrame

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
		buff.add(buf);
	}
	
	/*
	 * Public method which saves the currently selected buffer content to its file
	 */
	public static void saveFile(boolean as) {
		//Check for no open file buffers before attempting to save
		if(tabs.getTabCount() >= 1) {
			int index = tabs.getSelectedIndex();
			if(buff.get(index).getNeverSaved() || as) { //'Save As' to the currently selected buffer
				buff.get(index).saveAsFile();
				tabs.setTitleAt(index, buff.get(index).getFileName()); 
			} else 
				buff.get(index).saveToFile();
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