/**
 * Pastes text from the clipboard to the current caret position in the
 * currently selected buffer
 * 
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
	 * Pastes text
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		//save state
		BufferContext.getBuffer(index).
			saveState(GUI_BufferWindow.getWindow(index).getCursorPosition());
		//paste text
		GUI_BufferWindow aWindow = 
				GUI_BufferWindow.getWindow(index);
		aWindow.getTextArea().paste();	
	}

}
