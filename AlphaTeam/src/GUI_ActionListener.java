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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New")) {
			GUI_Main.addBuffer(new Buffer());
		}
			
		if(e.getActionCommand().equals("Open")) {
			JFileChooser fChooser = new JFileChooser();
	        fChooser.showOpenDialog(null);
	        GUI_Main.addBuffer(new Buffer(fChooser.getSelectedFile()));
		}
		
		if(e.getActionCommand().equals("Save")) {
			GUI_Main.saveFile(false);
		}
		
		if(e.getActionCommand().equals("Save As")) {
			GUI_Main.saveFile(true);
		}
		
	}
}