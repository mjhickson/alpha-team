/**
 * Controls state specific functions for the Buffer class when it is in the ill-formed state
 * @author Stephen Brewster
 */
import javax.swing.JOptionPane;

class BufferState_Ill extends BufferState {
	
	private Buffer parent;
	
	/**
	 * Constructor, recieves buffer object as parent
	 * @param parent Buffer object for the state object
	 */
	public BufferState_Ill(Buffer parent) {
		this.parent = parent;
	}
	
	/**
	 * Displays the content using indented form
	 */
	public void displayContent() {
		JOptionPane.showMessageDialog(null,
				"Unable to display formatted text - HTML is not well-formed.");
	}
	
	/**
	 * Saves the buffer to file
	 * @param as Triggers save as functions
	 */
	public boolean saveFile(boolean as) {
		JOptionPane.showMessageDialog(null, "Unable to save file - HTML is not well-formed.");
		return false;
	}
	
	/**
	 * Inserts an HTML tag
	 * @param html HTMLConstruct to be inserted
	 */
	public void insertTag(HTMLConstruct html) {
		JOptionPane.showMessageDialog(null, 
				"Unable to insert tags - HTML is not well-formed.");
	}
}