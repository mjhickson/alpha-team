/**
 * Abstract class for the BufferState objects
 * @author Stephen Brewster
 *
 */

abstract class BufferState {
	public BufferState() {
		
	}
	
	/**
	 * Outputs text to buffer window
	 */
	public void diplayContent() {
		
	}
	
	/**
	 * Saves the file, displays error message if HTML is ill-formed
	 */
	public boolean saveFile(boolean as) {
		return true;
	}
	
	/**
	 * Inserts a tag into the Buffer, error message if HTML is ill-formed
	 */
	public void insertTag(HTMLConstruct html) {
		
	}
}