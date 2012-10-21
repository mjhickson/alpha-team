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
	public InsertTagCommand(HTMLConstruct tag) {
		this.tag = tag;
	}
		
	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	@Override
	public void execute() {
		int i = GUI_Main.getSelectedTab();
		GUI_BufferWindow.getWindow(i).insertTag(tag);
		Buffer.getBuffer(i).setText(GUI_BufferWindow.getWindow(i).getText());
		
	}

}
