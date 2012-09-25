/**
 * HTMLBoldTag.java
 */

/**
 * @author Michael Yeaple
 */

import java.util.ArrayList;
import java.util.List;


public class HTMLBoldTag implements HTMLConstruct {

	private String tagName;
	private String sTag;
	private String eTag;
	private String text;
	private List<HTMLConstruct> childConstructs = new ArrayList<HTMLConstruct>();
	
	public HTMLBoldTag(){
		tagName = "b";
		sTag = "<b>";
		eTag = "</b>";
		text = "";
	}
	
	//Adds a child construct
	public void add(HTMLConstruct construct){
		childConstructs.add(construct);
	}
	
	//Removes a child construct
	public void remove(HTMLConstruct construct){
		childConstructs.remove(construct);
	}

	//Sets the text in between the HTML tags
	public void setText(String text) {
		this.text = text;
	}
	
	//Gets the text in between the HTML tags
	public String getText() {
		return text;
	}

	//Gets the tag name (identifier for the type of tag)
	public String getTagName() {
		return tagName;
	}

	//Gets the start tag
	public String getSTag() {
		return sTag;
	}

	//Gets the end tag
	public String getETag() {
		return eTag;
	}
	
	//Recursive function to return the composite structure as a string
	public String getHTML(String htmlString){
		String html = "";
		
		html = sTag;
		
		if ( childConstructs.size() == 0){
			html += text;
		} else{
			
			for ( int i = 0; i < childConstructs.size(); i++){
				htmlString += childConstructs.get(i).getHTML(htmlString);
			}
			
		}
		
		html += eTag;
		
		return html;
	}

}
