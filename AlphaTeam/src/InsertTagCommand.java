
/**
 * Inserts an HTML tag into the buffer
 * @author mhickson
 * @author Stephen Brewster
 *
 */

import javax.swing.JOptionPane;

public class InsertTagCommand implements Command {
	
	private HTMLConstruct tag;

	/**
	 * Constructor receives html tag and sets to global variable for execution
	 */
	public InsertTagCommand(HTMLConstruct tag) {
		this.tag = tag;
	}
		
	/**
	 * Inserts a tag into the bufferwindow and buffer if html is well-formed
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int i = GUI_Main.getSelectedTab();
		
		if(BufferContext.getBuffer(i).wellFormCheck()) {
			//Save state
			BufferContext.getBuffer(i).saveState(
					GUI_BufferWindow.getWindow(i).getCursorPosition());
			//Insert tag
			GUI_BufferWindow.getWindow(i).insertTag(tag);
			BufferContext.getBuffer(i).setText(GUI_BufferWindow.getWindow(i).getText());
		}
		else
			JOptionPane.showMessageDialog(null, 
					"Unable to insert tags - HTML is not well-formed.");
	}

}
