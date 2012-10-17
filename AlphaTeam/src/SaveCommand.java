/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class SaveCommand implements Command {
	
	private boolean saveAs;
	
	/**
	 * 
	 */
	public SaveCommand() {
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		Buffer.getBuffer(index).saveFile();
		GUI_Main.updateTabs();
	}

}
