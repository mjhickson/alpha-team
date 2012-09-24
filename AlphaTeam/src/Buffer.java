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

/*
 * Author: Stephen Brewster Group 1
 * Date:   9/21/2012
 * Description: This class contains the individual properties of the buffer, primary
 * functions include the encapsulation of file data including; name, path, contents, 
 * save state, and is responsible for storing & passing i/o information to the GUI/user
 * regarding the currently accessed HTML files.
 */


class Buffer {
	private JTextArea disWindow;
	private JScrollPane scroller;
	private File file;
	private String plainText;
	private String fileName;
	private boolean neverSaved, saved;
	private static ArrayList<Buffer> bufferList;
	
	/*
	 * Class default constructor sets global variables to default parameters
	 */
	public Buffer() {
		disWindow = new JTextArea();
		scroller = new JScrollPane(disWindow);
		plainText = "<HTML>\n</HTML>";
		fileName = "Untitled.html";
		neverSaved = true;
		saved = false;
		
		displayPlainText();
		
		if(bufferList == null)
				bufferList = new ArrayList<Buffer>();
	}
	
	/*
	 * Class constructor specifying a file to be used for loading the global variables
	 * @param File file object to have its content extracted and loaded into a buffer
	 */
	public Buffer(File f) {
		plainText = "";
		disWindow = new JTextArea();
		scroller = new JScrollPane(disWindow);
		file = f;
		fileName = file.getPath();
		neverSaved = false;
		saved = true;
		
		readInFile();
		displayPlainText();
		
		if(bufferList == null)
			bufferList = new ArrayList<Buffer>();
	}
	
	/*
	 * Internal method for reading in the content of a  file(global) and assigning it to 
	 * the appropriate global variables
	 */
	private void readInFile() {
		
		String temp = "";
		try {
			BufferedReader bufferIn = new BufferedReader(new FileReader(file));
			while ((temp = bufferIn.readLine()) != null) {
				plainText += temp + "\n";
			}
			bufferIn.close();
		}catch(IOException e) {}

	}
	
	/*
	 * Public method for saving HTML buffer contents to a file
	 * @param String Used as the file name to be saved to
	 */
	public boolean saveFile(boolean as) {
		if(as || neverSaved) {
			JFileChooser fChooser = new JFileChooser();
			fChooser.setApproveButtonText("Save As");
			fChooser.showOpenDialog(null);
			fileName = fChooser.getSelectedFile().getPath();
      
			//Check if file ends with .html and add if necessary
			if(!fileName.contains(".html"))
				fileName += ".html";
			neverSaved = false; //File has been saved at least once
		}//if
		
		//Save file
		try {
			BufferedWriter bufferOut = new BufferedWriter(new FileWriter(fileName));
			bufferOut.write(disWindow.getText());
			saved = true;
	        bufferOut.close();
	        
	        return true; //Notify calling object that save was successful
		} catch(IOException e) {
			return false; //Notify calling object that save failed
		}
	}
	
	/*
	 * Returns the buffer at index 'i'
	 * @param int Index of the buffer to be returned
	 */
	public static Buffer getBuffer(int i) {
		return bufferList.get(i);
	}
	
	/*
	 * Adds a buffer to the list of currently loaded buffers
	 * @param Buffer Buffer object to be added to the list
	 */
	public static void addBuffer(Buffer b) {
		bufferList.add(b);
	}
	
	/*
	 * Removes the buffer at the index location 'i'
	 * @param int Index location of the buffer to be removed
	 */
	public static void removeBuffer(int i) {
		bufferList.remove(i);
	}
	
	/*
	 * Sets the text in the output window with the global variable 'plainText'
	 */
	private void displayPlainText() {
		disWindow.setText(plainText);
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

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean getNeverSaved() {
		return neverSaved;
	}
	
	public void setSaved(boolean s) {
		saved = s;
	}
	
	public boolean getSaved() {
		return saved;
	}
	
}