
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

class Buffer extends Observable {
	private File file;
	private String plainText;
	private String fileName;
	private boolean neverSaved, saved;
	private HTMLConstruct head;
	private BufferState buffState;
	private static ArrayList<Buffer> bufferList;	
	
	/**
	 * Class default constructor sets global variables to default parameters
	 */
	public Buffer() {
		plainText = "";
		head = new HTMLTag();
		fileName = "Untitled.html";
		neverSaved = true;
		saved = false;
		
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
		file = f;
		fileName = file.getPath();
		neverSaved = false;
		saved = true;
		
		readInFile();
		
		if(bufferList == null)
			bufferList = new ArrayList<Buffer>();
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
	 * Inserts an HTML tag into the buffer
	 * @param html HTMLConstruct to be inserted
	 */
	public void insertTag(HTMLConstruct html) {
		buffState.insertTag(html);
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
	 * value is returned if it fails and the buffer changes to illformed state
	 */
	public boolean wellFormCheck() {
		boolean checker = false;
		String check1, check2;
		ArrayList<String> stack = new ArrayList<String>();
		ArrayList<String> tags = getAllTags();
		
		for(int i = 0; i < tags.size(); i++) {
			check1 = tags.get(i); //Extract tag
					
		//Add the tag to the stack if it is an open tag and not an img src tag
			if(!check1.contains("/")) 
				stack.add(0, check1);
		//Check for end tag, if found scan stack and remove matching open tag
			else if(check1.contains("/")) { //End tag found
				//extract </> decorators
				check2 = check1.substring(2, check1.length() -2);
						
				//compare the tag to all open tags on the stack
				//remove matching open tag when found
				for(int x = 0; x < stack.size(); x++) {
					//Handle special cases
					if(stack.get(x).contains("img src"))
						stack.remove(x);
					if(stack.get(x).contains("a href"))
						stack.set(x, "<a>");
					//Check for matching opening tag, remove if found	
					if(stack.get(x).substring(1, stack.get(x).length() -2).
											      equalsIgnoreCase(check2)) {
						stack.remove(x);
						x = stack.size();
						checker = true;
					}
					if(!checker) //Handles extra closing tags
							stack.add(0, check1);
			
				}//for(x)
			}//else if(charAt)
		}//for(i)

		if(stack.size() == 0) {
			buffState = new BufferState_Well(this);
			return true;
		}
		else {
			buffState = new BufferState_Ill(this);
			return false;
		}
	}//Wellformcheck
	
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

	public String getText() {
		return plainText;
	}
	
	public void setText(String t) {
		plainText = t;
	}
}