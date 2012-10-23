/**
 * 
 */

/**
 * Author: Maddison Hickson
 * Date: 10/20/2012
 * Description: Is a memento(stored state) for Buffer.
 * @author Maddison Hickson
 *
 */
public class BufferMemento {
	//A copy of the Buffer in a specific state
	private String theText;
	private int cursorPos;
	
	public BufferMemento(String text, int cursorPos){
		theText = text;
		this.cursorPos = cursorPos;
	}

	public String getTheText() {
		return theText;
	}

	public int getCursorPos() {
		return cursorPos;
	}
}
