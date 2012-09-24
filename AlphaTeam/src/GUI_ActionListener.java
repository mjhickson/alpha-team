import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/*
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Supplies the actionlistener class for the execution of commands
 *	issued by the HTML Editor
 */
public class GUI_ActionListener implements ActionListener {

	private NewCommand newCommand = new NewCommand();
	private OpenCommand openCommand = new OpenCommand();
	private CloseCommand closeCommand = new CloseCommand();
	
	private CutCommand cutCommand = new CutCommand();
	private CopyCommand copyCommand = new CopyCommand();
	private PasteCommand pasteCommand = new PasteCommand();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New")) {
			newCommand.execute();
		}
			
		if(e.getActionCommand().equals("Open")) {
			openCommand.execute();
		}
		
		if(e.getActionCommand().equals("Save")) {
			SaveCommand saveCommand = new SaveCommand(false);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Save As")) {
			SaveCommand saveCommand = new SaveCommand(true);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Close")) {
			closeCommand.execute();
		}
		
		if(e.getActionCommand().equals("Copy")) {
			copyCommand.execute();
		}
		
		if(e.getActionCommand().equals("Cut")) {
			cutCommand.execute();
		}
		
		if(e.getActionCommand().equals("Paste")) {
			pasteCommand.execute();
		}
		
		if(e.getActionCommand().contains("insert_")) {
			InsertTagCommand insrtTag = new InsertTagCommand(e.getActionCommand());
			insrtTag.execute();
		}

	}
}