import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class GUI_BufferWindow {
	private JTextArea disWindow;
	private JScrollPane scroller;
	private String title;
	private GUI_KeyListener keyListen;
	private static ArrayList<GUI_BufferWindow> bufferWindows;
	
	public GUI_BufferWindow(String name) {
		if(bufferWindows == null)
			bufferWindows = new ArrayList<GUI_BufferWindow>();
		
		keyListen = new GUI_KeyListener();	
		disWindow = new JTextArea();
		disWindow.addKeyListener(keyListen);
		scroller = new JScrollPane(disWindow);
		title = name;
	}
	
	public void insertTag(HTMLConstruct tag) {
		disWindow.insert(tag.getSTag(), disWindow.getCaretPosition());
		disWindow.insert(tag.getETag(), disWindow.getCaretPosition());
	}

	public void setText(String text) {
		disWindow.setText(text);
	}
	
	public String getText() {
		return disWindow.getText();
	}
	
	public JScrollPane getWindow() {
		return scroller;
	}
	
	public void update() {
		//disWindow.updateUI();
		//disWindow.revalidate();
		//disWindow.repaint();
	}
	
	public String getTitle() {
		return title;
	}
	
	public static void addWindow(GUI_BufferWindow win) {
		bufferWindows.add(win);
	}
	
	public static void removeWindow(int index) {
		bufferWindows.remove(index);
	}
	
	public static GUI_BufferWindow getWindow(int index) {
		return bufferWindows.get(index);
	}
}