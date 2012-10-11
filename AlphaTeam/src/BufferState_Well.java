/**
 * Provides the well-formed state functions for the Buffer
 * @author Stephen Brewster
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class BufferState_Well extends BufferState {
	
	private Buffer parent;
	
	/**
	 * Constructor
	 * @param parent Buffer object
	 */
	public BufferState_Well(Buffer parent) {
		this.parent = parent;
	}
	
	/**
	 * Displays the HTML content using indented formatting
	 */
	public void displayContent() {
		parent.getTextArea().setText(parent.getHead().getHTML("", true, 0));
	}
	
	/**
	 * Saves the buffer to file
	 * @param as Triggers the save as functions
	 */
	public boolean saveFile(boolean as) {
		String fileName = parent.getFileName();
		boolean neverSaved = parent.getNeverSaved();
		JTextArea disWindow = parent.getTextArea();
		
		if(as || neverSaved) {
			JFileChooser fChooser = new JFileChooser();
			fChooser.setApproveButtonText("Save As");
			fChooser.showOpenDialog(null);
			fileName = fChooser.getSelectedFile().getPath();
      
			//Check if file ends with .html and add if necessary
			if(!fileName.contains(".html"))
				fileName += ".html";
			parent.setFileName(fileName);
			parent.setNeverSaved(false); //File has been saved at least once
		}//if
		
		//Save file
		try {
			BufferedWriter bufferOut = new BufferedWriter(new FileWriter(fileName));
			bufferOut.write(parent.getTextArea().getText());
	        bufferOut.close();
	        
	        return true; //Notify calling object that save was successful
		} catch(IOException e) {
			return false; //Notify calling object that save failed
		}
	}
	
	/**
	 * Inserts an HTML tag into the buffer
	 * @param html HTMLConstruc to be inserted
	 */
	public void insertTag(HTMLConstruct html) {
		JTextArea temp = parent.getTextArea();
		int pos = temp.getCaretPosition();
		temp.insert(html.getSTag(), pos);
		temp.insert(html.getETag(), temp.getCaretPosition());

		temp.setCaretPosition(pos + html.getSTag().length());
	}
}