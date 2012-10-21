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
	public SaveCommand(boolean as) {
		saveAs = as;
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab();
		Buffer.getBuffer(index).saveFile(saveAs);
		//Sets the title in the window with the filename
		GUI_BufferWindow.getWindow(index).setTitle(Buffer.getBuffer(index).getFileName());
		GUI_Main.updateTabs(); //Update tab titles
	}

}
