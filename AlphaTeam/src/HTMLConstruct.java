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
	
	protected String tagName; //Name of the tag (i.e. A, IMG, etc.)
	protected String sTag; //Start tag (i.e. <h1>, <b>, etc.)
	protected String eTag; //End tag (i.e. </h1>, </b>, etc.)
	protected String text; //Text contained within the tag (Text the user writes within a tag).
	protected int indentNum; //Number of times to indent before writing the tag.
	//Children of tag, if applicable.
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
	 * Sets the number of indentations before a tag is inserted.
	 * @param num
	 */
	public void setIndentNum(int num){
		indentNum = num;
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
	 * Returns the number of indentations before a tag is inserted.
	 * @return indentNum
	 */
	public int getIndentNum(){
		return indentNum;
	}

	/**
	 * Returns an ArrayList of the child tags.
	 * @return ArrayList<HTMLConstruct> childConstructs
	 */
	public ArrayList<HTMLConstruct> getChild() {
		return childConstructs;
	}
	
	/**
	 * Increases all indentation from this structure on by the passed in integer.
	 */
	public void increaseIndent(int num){
		indentNum += num;
		
		//Call the function recursively for all children of the construct.
		for ( int i = 0; i < childConstructs.size(); i++){
			childConstructs.get(i).increaseIndent(num);
		}
	}
	
	/**
	 * Recursive function to get the HTML tag composite structure as a String.
	 * @param html - the HTML as a string.
	 * @return String html
	 */
	public String getHTML(String html, boolean isIndenting){
		
		if(html != ""){
			//If this is not the first tag in the string, make a new line.
			html += "\n";
		}
		
		if (isIndenting){
			//Indent the number of times applicable for the tag, if applicable.
			for ( int i = 0; i < indentNum; i++ ){
				html += "\t";
			}
		}
		
		html += sTag + text; //Add the start tag and text to the string.
		
		//Call the function recursively for all children of the construct.
		for ( int i = 0; i < childConstructs.size(); i++ ){
			html += childConstructs.get(i).getHTML(html, isIndenting);
		}
		
		if (isIndenting){
			//Indent the number of times applicable before inserting the end tag.
			for ( int i = 0; i < indentNum; i++ ){
				html += "\t";
			}
		}
		
		html += eTag; //Add the end tag to the string.
		
		return html;
	}	
}
