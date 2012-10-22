/**
 * Creates a new Buffer and BufferWindow
 * @author mhickson
 * @author Stephen Brewster
 */
public class NewCommand implements Command {
	
	/**
	 * Default constructor
	 */
	public NewCommand() {
	}

	/**
	 * Creates Buffer and BufferWindow, adds them to static lists
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		//Create buffer and associated view/controller
		Buffer b = new Buffer();
		GUI_BufferWindow aWindow  = new GUI_BufferWindow(b.getFileName()); 
		
		//Add new elements to their lists
		Buffer.addBuffer(b); //Add new buffer to static list
		GUI_Main.addBuffer(aWindow); //Add bufferwindow to GUI
		GUI_BufferWindow.addWindow(aWindow); //Add new bufferwindow to static list
		
		//Insert initial HTML tags
		InsertTagCommand insHTML = new InsertTagCommand(new HTMLTag());
		insHTML.execute();
	}

}
