/**
 * Supplies window view/controller for a buffer. Keeps a static list of all
 * bufferwindow, this list is parallel with the static list in buffer
 * 
 * @author Stephen Brewster
 */
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class GUI_BufferWindow {
	private JTextArea disWindow;
	private JScrollPane scroller;
	private String title;
	private GUI_KeyListener keyListen;
	private static ArrayList<GUI_BufferWindow> bufferWindows;
	
	/**
	 * Primary constructor initializes gui components
	 * @param name Title of the window (filename of the buffer)
	 */
	public GUI_BufferWindow(String name) {
		if(bufferWindows == null)
			bufferWindows = new ArrayList<GUI_BufferWindow>();
		
		keyListen = new GUI_KeyListener();	
		disWindow = new JTextArea();
			disWindow.addKeyListener(keyListen);
			disWindow.setWrapStyleWord(true);
		scroller = new JScrollPane(disWindow);
		title = name;
	}
	
	/**
	 * Inserts an HTML tag into the window
	 * Caret is set between open and close tags to provide easy nesting
	 * @param tag HTML tag to be inserted
	 */
	public void insertTag(HTMLConstruct tag) {
		disWindow.insert(tag.getSTag(), disWindow.getCaretPosition());
		disWindow.insert(tag.getETag(), disWindow.getCaretPosition());
		disWindow.setCaretPosition(disWindow.getCaretPosition() - tag.getETag().length());
		disWindow.insert(tag.getText(), disWindow.getCaretPosition());
	}
	
	/**
	 * Sets line wrapping policy of the window
	 * @param wrap Boolean value set to line wrap policy
	 */
	public void setWordWrap(boolean wrap) {
		disWindow.setLineWrap(wrap);
	}
	
	/**
	 * Shifts the position of the caret in the window by an integer value
	 * @param shift Integer value to shift the caret
	 */
	public void shiftCaret(int shift) {
		disWindow.setCaretPosition(disWindow.getCaretPosition() + shift);
	}

	/**
	 * Places the caret at a specified position
	 * @param pos
	 */
	public void setCaretPos(int pos) {
		disWindow.setCaretPosition(pos);
	}
	
	/**
	 * sets the text that is viewable in the currently selected Buffer Window
	 * @param text, the HTML text
	 */
	public void setText(String text) {
		disWindow.setText(text);
	}
	
	/**
	 * gets the text that is viewable in the currently selected Buffer Window
	 * @return the text viewable in the Buffer Window
	 */
	public String getText() {
		return disWindow.getText();
	}
	
	/**
	 * gets the JScrollPane that makes up the buffer window
	 * @return scroller, JScrollPane
	 */
	public JScrollPane getWindow() {
		return scroller;
	}
	
	/**
	 * gets the JTextArea of the currently selected window
	 * @return disWindow
	 */
	public JTextArea getTextArea() {
		return disWindow;
	}
	
	/**
	 * gets the title of the currently selected Buffer window
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * sets the title of the currently selected Buffer window
	 * @param title, string of the title you want to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * gets the position of the cursor in the currently selected
	 * Buffer Windown
	 * @return an int reperenation of where the cursor is
	 */
	public int getCursorPosition() {
		return disWindow.getCaretPosition();
	}
	
	/**
	 * Adds a new BufferWindow to the static list
	 * @param win GUI_BufferWindow
	 */
	public static void addWindow(GUI_BufferWindow win) {
		bufferWindows.add(win);
	}
	
	/**
	 * Removes BufferWindow at index
	 * @param index 
	 */
	public static void removeWindow(int index) {
		bufferWindows.remove(index);
	}
	
	/**
	 * Returns BufferWindow at index
	 * @param index
	 * @return
	 */
	public static GUI_BufferWindow getWindow(int index) {
			return bufferWindows.get(index);
	}
}