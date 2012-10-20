/**
 * 
 */

/**
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
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = Buffer.getBuffer(GUI_Main.getSelectedTab());
		
	}

}
