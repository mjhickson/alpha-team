/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class CutCommand implements Command {

	/**
	 * 
	 */
	public CutCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		GUI_BufferWindow aWindow = 
				GUI_BufferWindow.getWindow(GUI_Main.getSelectedTab());
		aWindow.getTextArea().cut();
	}

}
