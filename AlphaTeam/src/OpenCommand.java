/**
 * Opens an existing html file and loads it into the buffer, creates
 * an associated bufferWindow
 * 
 * @author mhickson
 * @author Stephen Brewster
 */

import javax.swing.JFileChooser;

public class OpenCommand implements Command {

	/**
	 * Default Constructor
	 */
	public OpenCommand() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * Allows user to choose a file, creates a buffer/bufferwindow for it
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		//Allow user to choose file to open
		JFileChooser fChooser = new JFileChooser();
        fChooser.showOpenDialog(null);
       
        //Create buffer and view
        Buffer b = new Buffer(fChooser.getSelectedFile());
		GUI_BufferWindow aWindow  = new GUI_BufferWindow(b.getFileName()); 
       
		//Add elements to lists
		GUI_Main.addBuffer(aWindow); //Add bufferwindow to GUI
		GUI_BufferWindow.addWindow(aWindow); //Add bufferwindow to static list
		Buffer.addBuffer(b);
		
		//Add file text to view
		aWindow.setText(b.getText());
		
		//Add any url links to link view
		GUI_LinkView.setLinks(b.getURLList());
	}

}
