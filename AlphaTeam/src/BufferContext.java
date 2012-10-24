/**
 * Author: Stephen Brewster Group 1
 * Date:   9/21/2012
 * Description: This class contains the individual properties of the buffer, primary
 * functions include the encapsulation of file data including; name, path, contents, 
 * save state, and is responsible for storing & passing i/o information to the GUI/user
 * regarding the currently accessed HTML files. Uses state pattern to change behavior
 * when HTML code is not "well-formed"
 *
 * State classes: BufferState_Ill, BufferState_Well
 *
 * @author Stephen Brewster
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;

class BufferContext extends Observable {
	private File file;
	private String plainText;
	private String fileName;
	private boolean neverSaved, saved;
	private HTMLConstruct head;
	private BufferState buffState;
	private BufferMementoCaretaker caretaker;
	private static ArrayList<BufferContext> bufferList;
	
	/**
	 * Class default constructor sets global variables to default parameters
	 */
	public BufferContext() {
		plainText = "";
		head = new HTMLTag();
		fileName = "Untitled.html";
		neverSaved = true;
		saved = false;
		
		buffState = new BufferState_Well(this);
		caretaker = new BufferMementoCaretaker();
		if(bufferList == null)
				bufferList = new ArrayList<BufferContext>();
	}
	
	/**
	 * Class constructor specifying a file to be used for loading the global variables
	 * @param f File object to have its content extracted and loaded into a buffer
	 */
	public BufferContext(File f) {
		plainText = "";
		file = f;
		fileName = file.getPath();
		neverSaved = false;
		saved = true;
		caretaker = new BufferMementoCaretaker();
		
		readInFile();
		
		if(bufferList == null)
			bufferList = new ArrayList<BufferContext>();
	}
	
	/**
	 * Internal method for reading in the content of a  file(global) and assigning it to 
	 * the appropriate global variables
	 */
	private void readInFile() {
		plainText = "";
		String temp = "";
		try {
			BufferedReader bufferIn = new BufferedReader(new FileReader(file));
			while ((temp = bufferIn.readLine()) != null) {
				plainText += temp;
			}
			bufferIn.close();
		}catch(IOException e) {}
		wellFormCheck();
	}
	
	/**
	 * Public method for saving HTML buffer contents to a file
	 * @param as Boolean true value triggers "Save As" functions
	 * @return boolean Affirmation of successful save
	 */
	public boolean saveFile(boolean as) {
		wellFormCheck();
		//getAllTags();
		
		if(buffState.saveFile(as)) {
			neverSaved = false;
			saved = true;
			return true;
		} else
			return false;
	}
	
	/**
	 * Saves the state of the BufferContext
	 */
	public void saveState(int cursorPos) {
		caretaker.addMemento(new BufferMemento(plainText, cursorPos));
	}
	
	/**
	 * Recovers the previous state of the BufferContext
	 */
	public int undo() {
		BufferMemento mem = caretaker.getLastState();
		plainText = mem.getTheText();
		if (mem == null){
			return 0;
		}
		else{
			return mem.getCursorPos();
		}
	}
	
	/**
	 * Returns the buffer at index 'i'
	 * @param i Index of the buffer to be returned
	 * @return BufferContext
	 */
	public static BufferContext getBuffer(int i) {
		return bufferList.get(i);
	}
	
	/**
	 * Inserts an HTML tag into the buffer
	 * @param html HTMLConstruct to be inserted
	 */
	public void insertTag(HTMLConstruct html) {
		buffState.insertTag(html);
	}
	
	/**
	 * Adds a buffer to the list of currently loaded buffers
	 * @param b BufferContext object to be added to the list
	 */
	public static void addBuffer(BufferContext b) {
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
	 * Extracts all html tags from text and places them in a list
	 * @return links ArrayList<String> containing all HTML tags
	 */
	public ArrayList<String> getAllTags() {
		int startMarker, j;
		ArrayList<String> tags = new ArrayList<String>();
		
		
		//Loop through entire text looking for html tags
		for(int i = 0; i < plainText.length(); i++) {
			
			if(plainText.charAt(i) == '<') { //Tag found
				startMarker = i; //Index in plaintext where tag starts
				j = i;
				
				//Find bounds of tag in text
				while(plainText.charAt(j) != '>') {
					j++;
				}
				j++; //End of tag index
				tags.add(plainText.substring(startMarker, j));
				i = j - 1;
			}
		}
		return tags;
	}
	
	/**
	 * Searches for all links and returns them in a list
	 * @return urlList List of URLs
	 */
	public ArrayList<String> getURLList() {
		ArrayList<String> tagList = getAllTags();
		ArrayList<String> urlList = new ArrayList<String>();
		int x = 0;
		String temp;
			
		//Search tags for links and extract url
		for(int i = 0; i < tagList.size(); i++) {
			temp = "";
			x = 9;
			
			if(tagList.get(i).contains("a href")) {
				while(tagList.get(i).charAt(x) != '\"') {//Extract url
					temp += tagList.get(i).charAt(x); 
					x++;
				}
			urlList.add(temp);
			}
		}
		return urlList;
	}
	
	/**
	 * Checks the buffer text to ensure that it is well-formed. A false return
	 * value is returned if it fails and the buffer changes to ill-formed state
	 * @return 
	 */
	public boolean wellFormCheck() {
		boolean checker = true;
		String check1, check2 = "";
		int bo = 0, bc = 0;
		ArrayList<String> stack = new ArrayList<String>();
		ArrayList<String> tags = getAllTags();
		
	//Check for proper number of brackets
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) == '<')
				bo++;
			if(plainText.charAt(i) == '>')
				bc++;
		}//for(j)

		if(bc != bo)
			checker = false; //Well form failed

	//Check open/close tag association
		if(checker) {
			for(int i = 0; i < tags.size(); i ++) {
				check1 = tags.get(i);
				
				if(!check1.contains("/")) { //Opening tag found
					stack.add(check1);
				}
				else {
					for(int j = 0; j < stack.size(); j++) { //Find open tag
						if(stack.get(j).contains(
								check1.substring(2, check1.length() - 1))) {
							stack.remove(j); //Remove open tag
							j = stack.size();
						}
					}//for(j)
				}//else
			}//for(i)
		}//if(checker)
		
		if(stack.size() > 0)
			checker = false;
	
	//Finalize results
		if(checker) {
			buffState = new BufferState_Well(this);
			return true;
		}
		else {
			buffState = new BufferState_Ill(this);
			return false;
		}
	}//Wellformcheck
	
	/**
	 * Give you the file name that the buffer is editing
	 * @return filename, Stirng of the file name
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * returns the file object that the Buffer is editing
	 * @return file object that the buffer is editing
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * gives you a HTMLHeadTag
	 * @return HTMLHeadTag
	 */
	public HTMLConstruct getHead() {
		return head;
	}
	
	/**
	 * sets the filename that the Buffer is editing
	 * @param fileName, String of the file the buffer is editing
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * returns whether the buffer has never been saved
	 * @return neverSaved, a boolean to tell whether a buffer has never been saved
	 */
	public boolean getNeverSaved() {
		return neverSaved;
	}
	
	/**
	 * sets whether a buffer has never been saved
	 * @param s, true if buffer has never been saved
	 */
	public void setNeverSaved(boolean s) {
		neverSaved = s;
	}
	
	/**
	 * sets whether a buffer has been saved
	 * @param s, true if the buffer has beeen saved
	 */
	public void setSaved(boolean s) {
		saved = s;
	}
	
	/**
	 * gets whether a buffer has been saved
	 * @return saved, true if has been saved, false if has not been saved
	 */
	public boolean getSaved() {
		return saved;
	}
	
	/**
	 * gets the HTML text stored in the buffer
	 * @return plainText, String of the text in the buffer
	 */
	public String getText() {
		return plainText;
	}
	
	/**
	 * sets the HMTL text in the buffer
	 * @param t, the HTML text that is to be set in the buffer
	 */
	public void setText(String t) {
		plainText = t;
	}
}