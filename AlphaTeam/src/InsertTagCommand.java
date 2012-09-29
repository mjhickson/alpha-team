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
		Buffer b = Buffer.getBuffer(GUI_Main.getSelectedTab());
		b.insertTag(tag);
	}

}
