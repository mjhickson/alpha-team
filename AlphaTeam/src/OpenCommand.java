import javax.swing.JFileChooser;

/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class OpenCommand implements Command {

	/**
	 * 
	 */
	public OpenCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
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
	}

}
