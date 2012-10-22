/**
 * Cuts text and sends to clipboard
 * @author mhickson
 * @author Stephen Brewster
 */
public class CutCommand implements Command {

	/**
	 * Default constructor
	 */
	public CutCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cuts selected text from the buffer window
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		GUI_BufferWindow aWindow = 
				GUI_BufferWindow.getWindow(GUI_Main.getSelectedTab());
		aWindow.getTextArea().cut();
	}

}
