/**
 * Executes the close command functions, checks for save states, saves if necessary
 * @author mhickson
 * @author Stephen Brewster
 *
 */
public class CloseCommand implements Command {

	/**
	 * Default constructor
	 */
	public CloseCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int index = GUI_Main.getSelectedTab(); //Retrieve index of current tab to be closed
		Buffer b = Buffer.getBuffer(index);
		
		//If buffer is currently saved close the tab
		if(b.getSaved()) {
			close(index);
		} else if(b.getNeverSaved() || !b.getSaved()){ //If buffer has never been saved, save as
			SaveCommand saveCommand = new SaveCommand();
			saveCommand.execute();
			close(index);
		} 
	}//execute
	
	/**
	 * closes the tab in the GUI and removes the Buffer from the list
	 * @param index location of tab/buffer to be removed
	 */
	private void close(int index) {
		Buffer.removeBuffer(index);
		GUI_Main.removeTab(index);
	}
}
