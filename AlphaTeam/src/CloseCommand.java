/**
 * 
 */

/**
 * @author mhickson
 *
 */
public class CloseCommand implements Command {

	/**
	 * 
	 */
	public CloseCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
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
			SaveCommand saveCommand = new SaveCommand(b.getNeverSaved());
			saveCommand.execute();
			close(index);
		} 
	}//execute
	
	private void close(int index) {
		Buffer.removeBuffer(index);
		GUI_Main.removeTab(index);
	}
}
