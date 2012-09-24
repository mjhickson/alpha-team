/**
 * 
 */

/**
 * @author mhickson
 *
 */
public class NewCommand implements Command {

	/**
	 * 
	 */
	public NewCommand() {
		
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = new Buffer();
		Buffer.addBuffer(b);
		GUI_Main.addBuffer(b);
	}

}
