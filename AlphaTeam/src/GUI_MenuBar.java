import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Supplies the JMenuBar for the HTML Editor
 * @author Stephen Brewster
 */

public class GUI_MenuBar extends JMenuBar{
	
	private JMenuBar menuBar;
	
	private JMenu fileMenu, 
					editMenu, 
					insertMenu, 
					helpMenu,
				  	textMenu, 
				  	tableMenu, 
				  	headersMenu, 
				  	listMenu;
	
	private JMenuItem openFile, 
						newFile, 
						cutText, 
					  	copyText, 
					  	pasteText, 
					  	undo,
					  	aboutEditor,
					  	saveFile, 
					  	saveAs, 
					  	bulleted, 
					  	numbered,
					  	dictionary,
						bold, 
						italic, 
						header,
						img,
						ahref,
						specify,
						close;
	private JMenu[] tableGrid;
	private JMenuItem[][] tableGridSelect;
	
	private static JRadioButtonMenuItem autoWrap, autoIndent;
	private GUI_ActionListener actionListener;
	
	public GUI_MenuBar() {
		actionListener = new GUI_ActionListener();
		
		//Initialize menus
		fileMenu = new JMenu("File");
			fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu = new JMenu("Edit");
			editMenu.setMnemonic(KeyEvent.VK_E);
		insertMenu = new JMenu("Insert");
			insertMenu.setMnemonic(KeyEvent.VK_I);
		helpMenu = new JMenu("Help");
			helpMenu.setMnemonic(KeyEvent.VK_H);
			
			//'Insert' submenus
			textMenu = new JMenu("Text Format");
			tableMenu = new JMenu("Table");
			headersMenu = new JMenu("Headers");
			listMenu = new JMenu("Lists");
			tableGrid = new JMenu[11];
			//Special case
			specify = new JMenuItem("Specify...");
				specify.addActionListener(actionListener);
				tableMenu.add(specify);
				
			tableGridSelect = new JMenuItem[11][11];
			
			for(int i = 1; i < 11; i++)	{
				tableGrid[i] = new JMenu(i + " x ...");
				tableMenu.add(tableGrid[i]);
				
				for(int j = 1; j < 11; j++) {
					tableGridSelect[i][j] = new JMenuItem(i + " x " + j);
					tableGrid[i].add(tableGridSelect[i][j]);
					tableGridSelect[i][j].addActionListener(actionListener);
					tableGridSelect[i][j].setActionCommand("insert_Table_" + i + "_" + j);
				}
			}
			
			//Add menus to bar
			add(fileMenu);
			add(editMenu);
			add(insertMenu);
			add(helpMenu);
				
		//Initialize menu items *********************************************
		//file
			newFile = new JMenuItem("New");
				newFile.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
				newFile.setMnemonic(KeyEvent.VK_N);
				newFile.addActionListener(actionListener);
			openFile = new JMenuItem("Open");
				openFile.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
				openFile.setMnemonic(KeyEvent.VK_O);
				openFile.addActionListener(actionListener);
			saveFile = new JMenuItem("Save");
				saveFile.setAccelerator(
			        KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
				saveFile.setMnemonic(KeyEvent.VK_S);
				saveFile.addActionListener(actionListener);
			saveAs = new JMenuItem("Save As");
				saveAs.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				saveAs.setMnemonic(KeyEvent.VK_A);
				saveAs.addActionListener(actionListener);
			close = new JMenuItem("Close");
				close.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
				close.setMnemonic(KeyEvent.VK_A);
				close.addActionListener(actionListener);
			
		//edit
			copyText = new JMenuItem("Copy");
				copyText.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
				copyText.setMnemonic(KeyEvent.VK_C);
				copyText.addActionListener(actionListener);
			cutText = new JMenuItem("Cut");
				cutText.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
				cutText.setMnemonic(KeyEvent.VK_X);
				cutText.addActionListener(actionListener);
			pasteText = new JMenuItem("Paste");
				pasteText.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
				pasteText.setMnemonic(KeyEvent.VK_V);
				pasteText.addActionListener(actionListener);
			autoWrap = new JRadioButtonMenuItem("Auto-Wrap");
				autoWrap.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
				autoWrap.setMnemonic(KeyEvent.VK_W);
				autoWrap.addActionListener(actionListener);
			autoIndent = new JRadioButtonMenuItem("Auto-Indent");
				autoIndent.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
				autoIndent.setMnemonic(KeyEvent.VK_I);
				autoIndent.addActionListener(actionListener);
			undo = new JMenuItem("Undo");
				undo.setAccelerator(
			         KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
				undo.setMnemonic(KeyEvent.VK_Z);
				undo.addActionListener(actionListener);
				
			//Insert items
			bold = new JMenuItem("Bold");
				bold.addActionListener(actionListener);
				bold.setActionCommand("insert_b");
			italic = new JMenuItem("Italic");
				italic.addActionListener(actionListener);
				italic.setActionCommand("insert_i");
			header = new JMenuItem("Header");
				header.addActionListener(actionListener);
				header.setActionCommand("insert_head");
			bulleted = new JMenuItem("Bullets");
				bulleted.addActionListener(actionListener);
				bulleted.setActionCommand("insert_list_unordered");
			numbered = new JMenuItem("Numbered");
				numbered.addActionListener(actionListener);
				numbered.setActionCommand("insert_list_ordered");
			dictionary = new JMenuItem("Dictionary");
				dictionary.addActionListener(actionListener);	
				dictionary.setActionCommand("insert_list_dictionary");
			img = new JMenuItem("Image");
				img.addActionListener(actionListener);
				img.setActionCommand("insert_Img");
			ahref = new JMenuItem("A Href");
				ahref.addActionListener(actionListener);
				ahref.setActionCommand("insert_ahref");
		//help
			aboutEditor = new JMenuItem("About");
				aboutEditor.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
				aboutEditor.setMnemonic(KeyEvent.VK_A);
				aboutEditor.addActionListener(actionListener);
		
		//Menu creation **************************************
		//file
		fileMenu.add(newFile);
			fileMenu.addSeparator();
		fileMenu.add(openFile);
			fileMenu.addSeparator();
		fileMenu.add(close);
			fileMenu.addSeparator();
		fileMenu.add(saveFile);
		fileMenu.add(saveAs);
		
		//edit
		editMenu.add(copyText);
		editMenu.add(cutText);
			editMenu.addSeparator();
		editMenu.add(pasteText);
			editMenu.addSeparator();
		editMenu.add(undo);
			editMenu.addSeparator();
		editMenu.add(autoWrap);
		editMenu.add(autoIndent);
		
		//insert
		insertMenu.add(headersMenu);
		insertMenu.add(textMenu);
		insertMenu.add(tableMenu);
		insertMenu.add(listMenu);
		insertMenu.add(img);
		insertMenu.add(ahref);
			listMenu.add(bulleted);
			listMenu.add(numbered);
			listMenu.add(dictionary);
			headersMenu.add(header);
			textMenu.add(bold);
			textMenu.add(italic);
			
		//help
		helpMenu.add(aboutEditor);
	}//Constructor
	
	public static boolean getWrapState() {
		return autoWrap.isSelected();
	}
}