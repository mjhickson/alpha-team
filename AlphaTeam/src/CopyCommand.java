/**
 * Copies selected text to clipboard
 * @author mhickson
 * @author Stephen Brewster
 */
public class CopyCommand implements Command {

	/**
	 * Default constructor
	 */
	public CopyCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Copies text from the buffer window
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		GUI_BufferWindow aWindow = 
				GUI_BufferWindow.getWindow(GUI_Main.getSelectedTab());
		aWindow.getTextArea().copy();
	}

}
