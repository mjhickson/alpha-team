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
	 * Primary constructor accepts a boolean to determin save vs save as
	 * @param as
	 */
	public SaveCommand(boolean as) {
		saveAs = as;
	}

	/**
	 * Saves the currently selected buffer
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
