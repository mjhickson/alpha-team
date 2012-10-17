/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class NewCommand implements Command {

	/**
	 * 
	 */
	public NewCommand() {
		
	}

	/**
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		Buffer b = new Buffer();
		Buffer.addBuffer(b);
		GUI_Main.registerObserver(b);
	}

}
