/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class WrapCommand implements Command {

	private boolean wrap;
	/**
	 * 
	 */
	public WrapCommand(boolean wrap) {
		this.wrap = wrap;
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		GUI_BufferWindow.getWindow(index).setWordWrap(wrap);
	}

}
