/**
 * 
 */

/**
 * @author mhickson
 *
 */
public class PasteCommand implements Command {

	/**
	 * 
	 */
	public PasteCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = Buffer.getBuffer(GUI_Main.getSelectedTab());
		b.getTextArea().paste();
	}

}
