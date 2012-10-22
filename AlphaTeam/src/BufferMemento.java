/**
 * 
 */

/**
 * @author Maddison Hickson
 *
 */
public class BufferMemento {
	private BufferContext memento;
	public BufferMemento(BufferContext bufferContext){
		memento = bufferContext;
	}
	
	public BufferContext getState(){
		return memento;
	}
}
