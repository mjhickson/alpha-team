/**
 * 
 */

/**
 * @author mhickson
 *
 */
public class CutCommand implements Command {

	/**
	 * 
	 */
	public CutCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = Buffer.getBuffer(GUI_Main.getSelectedTab());
		b.getTextArea().cut();
	}

}
