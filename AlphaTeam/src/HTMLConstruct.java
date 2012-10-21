import java.util.ArrayList;

/**
 * HTMLConstruct.java
 */

/**
 * Defines an interface for the HTMLConstruct Objects. This is the Component part
 * of the Composite pattern.
 * Implements default behavior for all concrete constructs.
 * All children of HTMLConstruct may either be leaves or composites
 * in the Composite pattern.
 * 
 * @author Michael Yeaple
 */

public class HTMLConstruct {
	
	protected String tagName;
	protected String sTag;
	protected String eTag;
	protected String text;
	protected ArrayList<HTMLConstruct> childConstructs = new ArrayList<HTMLConstruct>();
	
	public HTMLConstruct(){
		// HTMLConstructs should not actually be used. This simply defines the default methods
		// and variables to be inherited by all concrete constructs.
	}
	
	/**
	 * Adds a child HTMLConstruct.
	 * @param HTMLConstruct construct
	 */
	public void add(HTMLConstruct construct){
		childConstructs.add(construct);
	}
	
	/**
	 * Removes a childHTMLConstruct.
	 * @param HTMLConstruct construct
	 */
	public void remove(HTMLConstruct construct){
		childConstructs.remove(construct);
	}

	/**
	 * Sets the text in between HTML Tags.
	 * @param String text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Returns the text in between the HTML Tag (ex: <b>This part of the tag.</b>).
	 * @return String text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the tag name (identifier for the HTML tag).
	 * @return String tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Return the start tag of a construct (ex: <b>).
	 * @return String sTag
	 */
	public String getSTag() {
		return sTag;
	}

	/**
	 * Returns the end tag of a construct (ex: </b>).
	 * @return String eTag
	 */
	public String getETag() {
		return eTag;
	}

	/**
	 * Returns an ArrayList of the child tags.
	 * @return ArrayList<HTMLConstruct> childConstructs
	 */
	public ArrayList<HTMLConstruct> getChild() {
		return childConstructs;
	}
	
	/**
	 * Recursive function to get the HTML tag composite structure as a String.
	 * @param html - the HTML as a string.
	 * @return String html
	 */
	public String getHTML(String html){
		html += sTag;
		
		if ( childConstructs.size() == 0){
			html += text;
		} else{
			
			for ( int i = 0; i < childConstructs.size(); i++){
				html += childConstructs.get(i).getHTML(html);
			}
			
		}
		
		html += eTag;
		
		return html;
	}
	
}
