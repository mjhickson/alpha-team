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
	private BufferContext memento;
	
	public BufferMemento(BufferContext buffer){
		memento = buffer;
	}
	
	/**
	 * gets the state that memento represents.
	 * 
	 * @return a Buffer class in a specific state
	 */
	public BufferContext getState(){
		return memento;
	}
}
