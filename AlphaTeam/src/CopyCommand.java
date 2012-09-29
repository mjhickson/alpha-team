/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class CopyCommand implements Command {

	/**
	 * 
	 */
	public CopyCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = Buffer.getBuffer(GUI_Main.getSelectedTab());
		b.getTextArea().copy();
	}

}
