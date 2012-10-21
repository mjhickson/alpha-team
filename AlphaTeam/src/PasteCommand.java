/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class PasteCommand implements Command {

	/**
	 * 
	 */
	public PasteCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		GUI_BufferWindow aWindow = 
				GUI_BufferWindow.getWindow(GUI_Main.getSelectedTab());
		aWindow.getTextArea().paste();	
	}

}
