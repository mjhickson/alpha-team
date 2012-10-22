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
		//parent.getText().setText(parent.getHead().getHTML(""));
	}
	
	/**
	 * Saves the buffer to file
	 * @param as Triggers the save as functions
	 */
	public boolean saveFile(boolean as) {
		if(as || parent.getNeverSaved()) {
			JFileChooser fChooser = new JFileChooser();
			fChooser.setApproveButtonText("Save As");
			fChooser.showOpenDialog(null);
			parent.setFileName(fChooser.getSelectedFile().getPath());
      
			//Check if file ends with .html and add if necessary
			if(!parent.getFileName().contains(".html"))
				parent.setFileName(parent.getFileName() + ".html");
			parent.setNeverSaved(false); //File has been saved at least once
		}//if
		
		//Save file
		try {
			BufferedWriter bufferOut = new BufferedWriter(new FileWriter(parent.getFileName()));
			bufferOut.write(parent.getText());
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
	public void insertTag(HTMLConstruct tag) {
		//parent.buildHTML();
	}
}