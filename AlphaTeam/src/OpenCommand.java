import javax.swing.JFileChooser;

/**
 * 
 */

/**
 * @author mhickson
 * @author Stephen Brewster
 */
public class OpenCommand implements Command {

	/**
	 * 
	 */
	public OpenCommand() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		JFileChooser fChooser = new JFileChooser();
        fChooser.showOpenDialog(null);
       
        Buffer b = new Buffer(fChooser.getSelectedFile());
        Buffer.addBuffer(b);
        GUI_Main.addBuffer(b);
	}

}
