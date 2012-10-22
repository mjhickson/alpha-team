/**
 * Enables text wrap in current buffer
 * @author mhickson
 * @author Stephen Brewster
 */
public class WrapCommand implements Command {

	private boolean wrap;
	/**
	 * Primary constructor: accepts a boolean to set text wrap policy
	 * @param wrap
	 */
	public WrapCommand(boolean wrap) {
		this.wrap = wrap;
	}

	/**
	 * Sets line wrap policy
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		GUI_BufferWindow.getWindow(index).setWordWrap(wrap);
	}

}
