import java.util.ArrayList;

/**
 * HTMLConstruct.java
 * 
 * An interface for the HTMLConstruct Objects. This is the Component part
 * of the Composite pattern.
 * The HTMLConstruct classes that implement this interface can all 
 * be either leaves or composites.
 */

/**
 * An interface for the HTMLConstruct Objects. This is the Component part
 * of the Composite pattern.
 * The HTMLConstruct classes that implement this interface can all 
 * be either leaves or composites.
 * 
 * @author Michael Yeaple
 */

public interface HTMLConstruct {
	
	/**
	 * Adds a child HTMLConstruct.
	 * @param HTMLConstruct construct
	 */
	public void add(HTMLConstruct construct);
	
	/**
	 * Removes a childHTMLConstruct.
	 * @param HTMLConstruct construct
	 */
	public void remove(HTMLConstruct construct);
	
	/**
	 * Sets the text in between HTML Tags.
	 * @param String text
	 */
	public void setText(String text);
	
	/**
	 * Returns the text in between the HTML Tag (ex: <b>This part of the tag.</b>).
	 * @return String text
	 */
	public String getText();
	
	/**
	 * Returns the tag name (identifier for the HTML tag).
	 * @return String tagName
	 */
	public String getTagName();
	
	/**
	 * Return the start tag of a construct (ex: <b>).
	 * @return String sTag
	 */
	public String getSTag();
	
	/**
	 * Returns the end tag of a construct (ex: </b>).
	 * @return String eTag
	 */
	public String getETag();
	
	/**
	 * Returns an ArrayList of the child tags.
	 * @return ArrayList<HTMLConstruct> childConstructs
	 */
	public ArrayList<HTMLConstruct> getChild();
	
	/**
	 * Recursive function to get the HTML tag composite structure as a String.
	 * @param html - the HTML as a string.
	 * @param isIndenting - boolean for whether the structure should be indented or not.
	 * @param iNum - int for the number of indents before the tag should be inserted (initial value should be 0).
	 * @return String html
	 */
	public String getHTML(String html, boolean isIndenting, int iNum);
}
