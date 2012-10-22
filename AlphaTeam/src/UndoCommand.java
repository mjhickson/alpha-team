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
	public void execute() {
		// TODO Auto-generated method stub
		int i = GUI_Main.getSelectedTab();
		BufferContext.getBuffer(i).undo();
	}

}
