import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Supplies the actionlistener class for the execution of commands
 *	issued by the HTML Editor
 */
public class GUI_ActionListener implements ActionListener {

	private NewCommand newCommand = new NewCommand();
	private OpenCommand openCommand = new OpenCommand();
	private CloseCommand closeCommand = new CloseCommand();
	
	private CutCommand cutCommand = new CutCommand();
	private CopyCommand copyCommand = new CopyCommand();
	private PasteCommand pasteCommand = new PasteCommand();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New")) {
			newCommand.execute();
		}
			
		if(e.getActionCommand().equals("Open")) {
			openCommand.execute();
		}
		
		if(e.getActionCommand().equals("Save")) {
			SaveCommand saveCommand = new SaveCommand(false);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Save As")) {
			SaveCommand saveCommand = new SaveCommand(true);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Close")) {
			closeCommand.execute();
		}
		
		if(e.getActionCommand().equals("Copy")) {
			copyCommand.execute();
		}
		
		if(e.getActionCommand().equals("Cut")) {
			cutCommand.execute();
		}
		
		if(e.getActionCommand().equals("Paste")) {
			pasteCommand.execute();
		}
		
		if(e.getActionCommand().contains("insert_")) {
			HTMLConstruct tag;
				tag = new HTMLTag(); //Provide default tag
			String tagStr = e.getActionCommand();
			InsertTagCommand insrtTag;
			
			if(tagStr.contains("_b")) {
				tag = new HTMLBoldTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			if(tagStr.contains("_i")) {
				tag = new HTMLItalicTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			if(tagStr.contains("_HTML")) {
				tag = new HTMLTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			//If a table has been inserted
			if(tagStr.contains("_Table")) {
				//Split the command to extract table dimensions
				String tableParse[];
				tableParse = tagStr.split("_");
				//Insert table tag
				tag = new HTMLTableTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
					
				int index = GUI_Main.getSelectedTab(); //Get index
				
				//extracts the size of the table and inserts tr/td tags	
				for(int i = 0; i < Integer.parseInt(tableParse[3]); i++) {
					//Insert tr tag
					tag = new HTMLTableRowTag();
						insrtTag = new InsertTagCommand(tag);
						insrtTag.execute();
					//Insert necessary number of td tags
					for(int j = 0; j < Integer.parseInt(tableParse[2]); j++) {
						tag = new HTMLTableDataTag();
							insrtTag = new InsertTagCommand(tag);
							insrtTag.execute();
						//Shift caret to avoid unwanted nesting of td tags
						GUI_BufferWindow.getWindow(index).
											shiftCaret(tag.getETag().length());
					}
					//Shift caret to end of </tr> to set up for next row
					GUI_BufferWindow.getWindow(index).
								shiftCaret((tag.getETag().length() *   
										   	  (Integer.parseInt(tableParse[2]) - 1)));					
				}//for				
			}//if _table
		}//if _insert
		
	}//actionperformed
}//class