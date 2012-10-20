/**
 * 
 */

/**
 * @author mhickson
 *
 */
public class InsertTagCommand implements Command {
	
	private HTMLConstruct tag;

	/**
	 * 
	 */
	public InsertTagCommand(String tagStr) {
		if(tagStr.contains("_b"))
			tag = new HTMLBoldTag();
		if(tagStr.contains("_i"))
			tag = new HTMLItalicTag();
		if(tagStr.contains("_HTML"))
			tag = new HTMLTag();
		
	}

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int i = GUI_Main.getSelectedTab();
		GUI_BufferWindow.getWindow(i).insertTag(tag);
		Buffer.getBuffer(i).insertTag(tag);
	}

}
