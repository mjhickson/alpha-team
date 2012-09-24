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
	
	//Adds a child HTMLConstruct
	public void add(HTMLConstruct construct);
	
	//Removes a childHTMLConstruct
	public void remove(HTMLConstruct construct);
	
	//Returns reference to child
	public ArrayList<HTMLConstruct> getChild();
	
	//Sets the text in between HTML Tags
	public void setText(String text);
	
	//Gets the text in between HTML Tags
	public String getText();
	
	//Gets the tag name (identifier for the HTML tag)
	public String getTagName();
	
	//Gets the start tag
	public String getSTag();
	
	//Gets the end tag
	public String getETag();
	
}