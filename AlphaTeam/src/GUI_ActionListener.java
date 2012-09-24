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
			CloseCommand closeCommand = new CloseCommand();
			closeCommand.execute();
		}
	}
}