import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

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
			newCommand.execute(); //Opens a new html buffer/file
		}
			
		if(e.getActionCommand().equals("Open")) {
			openCommand.execute(); //Opens an existing html buffer/file
		}
		
		if(e.getActionCommand().equals("Save")) {
			//Saves the current document using its current filename
			SaveCommand saveCommand = new SaveCommand(false);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Save As")) {
			//Saves the current document using a new filename
			SaveCommand saveCommand = new SaveCommand(true);
			saveCommand.execute();
		}
		
		if(e.getActionCommand().equals("Close")) {
			//Closes the current document, saves first if necessary/desired
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
		
		if(e.getActionCommand().equals("confirmLinkParameters")) {
			String params[] = GUI_Main.getLinkParameters();
			GUI_Main.setLinkInputVisible(false);
			
			//Create tag
			HTMLConstruct tag;
				tag = new HTMLATag(params[0], params[1]);
			
			//Create insert command
			InsertTagCommand insrtTag = new InsertTagCommand(tag);
			insrtTag.execute();
		}
		
		if(e.getActionCommand().equals("cancelLinkParameters")) {
			GUI_Main.setLinkInputVisible(false);
		}
		
		//Inserts html tags into the current document
		if(e.getActionCommand().contains("insert_")) {
			HTMLConstruct tag;
				tag = new HTMLTag(); //Provide default tag
			String tagStr = e.getActionCommand();
			InsertTagCommand insrtTag;
			
			//Inserts A Href (link) tag
			if(tagStr.contains("_ahref")) {
				GUI_Main.setLinkInputVisible(true);
			}
			
			//Inserts b (bold) tag
			if(tagStr.contains("_b")) {
				tag = new HTMLBoldTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			//Inserts i (italic) tag
			if(tagStr.contains("_i")) {
				tag = new HTMLItalicTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			//Inserts an HTML tag
			if(tagStr.contains("_HTML")) {
				tag = new HTMLTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			//Inserts header tag
			if(tagStr.contains("_head")) {
				tag = new HTMLHeadTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
			}
			
			//Inserts ordered, unordered and dictionary Lists
			if(tagStr.contains("_list")) {
				//Inserts an ordered list
				if(tagStr.contains("_ordered")) {
					tag = new HTMLOrderedListTag();
						insrtTag = new InsertTagCommand(tag);
						insrtTag.execute();
				}
				
				//Inserts an unordered list
				if(tagStr.contains("_unordered")) {
					tag = new HTMLUnorderedListTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
				}
				
				//Inserts a dictionary list
				if(tagStr.contains("_dictionary")) {
					tag = new HTMLDefinitionListTag();
					insrtTag = new InsertTagCommand(tag);
					insrtTag.execute();
				}
			}
			
			/*
			Inserts a table tag including tr/td tags.
			Extracts dimensions from the action command and builds
			table structure
			*/
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
					}//for(j)
					
					//Shift caret to end of </tr> to set up for next row
					GUI_BufferWindow.getWindow(index).shiftCaret(5);
				}//for(i)		
			}//table insertion
		}//insert
		
	}//actionperformed
}//class