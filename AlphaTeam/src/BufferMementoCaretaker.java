/**
 * 
 */
import java.util.ArrayList;
/**
 * @author Maddison Hickson
 *
 */
public class BufferMementoCaretaker {
	private ArrayList<BufferMemento> mementoStack;
	
	public BufferMementoCaretaker(){
		mementoStack = new ArrayList<BufferMemento>();	
	}
	
	/**
	 * adds a memento for the caretaker to hold. If more than two states are
	 * already being stored then the oldest if removed, which is the first
	 * in the ArrayList.
	 * 
	 * @param bufferState, the new memento
	 */
	public void addMemento(BufferMemento bufferState){
		mementoStack.add(bufferState);
		if(mementoStack.size() > 2){
			mementoStack.remove(0);
		}
	}
	
	/**
	 * Gives the last memento the caretaker was given. Also removes the last
	 * memento the caretaker was given.
	 * @return lastState, the last memento the caretaker was given
	 */
	public BufferMemento getLastState(){
		BufferMemento lastState = mementoStack.get(mementoStack.size()-1);
		mementoStack.remove(mementoStack.size()-1);
		return lastState;
	}
}
