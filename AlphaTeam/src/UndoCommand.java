/**
 * 
 */

/**
 * @author Maddison Hickson
 *
 */
public class UndoCommand implements Command {

	/**
	 * 
	 */
	public UndoCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	/**
	 * Undoes the last action performed.
	 * So tells the Buffer to revert back to a previous saved memento.
	 */
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		BufferContext b = BufferContext.getBuffer(index);

		int cursor = b.undo();

		//Reset text in window 
		GUI_BufferWindow.getWindow(index).setText(b.getText());
		GUI_BufferWindow.getWindow(index).setCaretPos(cursor);
	}

}
