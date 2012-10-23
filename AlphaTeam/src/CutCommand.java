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
		int index = GUI_Main.getSelectedTab();
		BufferContext.getBuffer(index).
			saveState(GUI_BufferWindow.getWindow(index).getCursorPosition());
		GUI_BufferWindow.getWindow(index).getTextArea().cut();
	}

}
