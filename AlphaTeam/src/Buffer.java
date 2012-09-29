import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Author: Stephen Brewster Group 1
 * Date:   9/21/2012
 * Description: This class contains the individual properties of the buffer, primary
 * functions include the encapsulation of file data including; name, path, contents, 
 * save state, and is responsible for storing & passing i/o information to the GUI/user
 * regarding the currently accessed HTML files.
 * @author Stephen Brewster
 */


class Buffer {
	private JTextArea disWindow;
	private JScrollPane scroller;
	private File file;
	private String plainText;
	private String fileName;
	private boolean neverSaved, saved, wellFormState;
	private static ArrayList<Buffer> bufferList;
	private HTMLConstruct head;
	private BufferState buffState;
	
	/**
	 * Class default constructor sets global variables to default parameters
	 */
	public Buffer() {
		disWindow = new JTextArea();
		scroller = new JScrollPane(disWindow);
		head = new HTMLTag();
		fileName = "Untitled.html";
		neverSaved = true;
		saved = false;
		wellFormState = true;
		buffState = new BufferState_Well(this);
		
		if(bufferList == null)
				bufferList = new ArrayList<Buffer>();
	}
	
	/**
	 * Class constructor specifying a file to be used for loading the global variables
	 * @param f File object to have its content extracted and loaded into a buffer
	 */
	public Buffer(File f) {
		plainText = "";
		disWindow = new JTextArea();
		scroller = new JScrollPane(disWindow);
		file = f;
		fileName = file.getPath();
		neverSaved = false;
		saved = true;
		wellFormState = false;
		buffState = new BufferState_Ill(this);
		
		readInFile();
		
		if(bufferList == null)
			bufferList = new ArrayList<Buffer>();
	}
	
	/**
	 * Internal method for reading in the content of a  file(global) and assigning it to 
	 * the appropriate global variables
	 */
	private void readInFile() {
		
		String temp = "";
		try {
			BufferedReader bufferIn = new BufferedReader(new FileReader(file));
			while ((temp = bufferIn.readLine()) != null) {
				disWindow.append(temp);
			}
			bufferIn.close();
		}catch(IOException e) {}

	}
	
	/**
	 * Public method for saving HTML buffer contents to a file
	 * @param as Boolean true value triggers "Save As" functions
	 * @return boolean Affirmation of successful save
	 */
	public boolean saveFile(boolean as) {
		if(buffState.saveFile(as)) {
			neverSaved = false;
			saved = true;
			return true;
		} else
			return false;
	}
	
	/**
	 * Returns the buffer at index 'i'
	 * @param i Index of the buffer to be returned
	 * @return Buffer
	 */
	public static Buffer getBuffer(int i) {
		return bufferList.get(i);
	}
	
	/**
	 * Adds a buffer to the list of currently loaded buffers
	 * @param b Buffer object to be added to the list
	 */
	public static void addBuffer(Buffer b) {
		bufferList.add(b);
	}
	
	/**
	 * Removes the buffer at the index location 'i'
	 * @param i Index location of the buffer to be removed
	 */
	public static void removeBuffer(int i) {
		bufferList.remove(i);
	}
	
	/**
	 * Sets the text in the output window with the global variable 'plainText'
	 */
	private void displayContent() {
		buffState.diplayContent();
	}
	
	/**
	 * Inserts an HTML tag into the buffer
	 * @param html HTMLConstruct to be inserted
	 */
	public void insertTag(HTMLConstruct html) {
		buffState.insertTag(html);
	}
	
	public JScrollPane getWindow() {
		return scroller;
	}
	
	public JTextArea getTextArea() {
		return disWindow;
	}

	public String getFileName() {
		return fileName;
	}
	
	public File getFile() {
		return file;
	}
	
	public HTMLConstruct getHead() {
		return head;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean getNeverSaved() {
		return neverSaved;
	}
	
	public void setNeverSaved(boolean s) {
		neverSaved = s;
	}
	public void setSaved(boolean s) {
		saved = s;
	}
	
	public boolean getSaved() {
		return saved;
	}
	
	public void setWrapping(boolean b) {
		disWindow.setLineWrap(b);
	}
	
}