/**
 * 
 */

/**
 * @author Maddison Hickson
 *
 */
public class BufferMemento {
	private Buffer memento;
	public BufferMemento(Buffer buffer){
		memento = buffer;
	}
	
	public Buffer getState(){
		return memento;
	}
}
