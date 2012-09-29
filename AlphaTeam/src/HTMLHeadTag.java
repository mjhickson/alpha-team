import java.util.ArrayList;


public class HTMLHeadTag implements HTMLConstruct {

	private String tagName;
	private String sTag;
	private String eTag;
	private String text;
	private int indentNum;
	private ArrayList<HTMLConstruct> childConstructs = new ArrayList<HTMLConstruct>();
	
	public HTMLHeadTag(){
		tagName = "h";
		sTag = "<h1>";
		eTag = "</h1>";
		indentNum = -1;
		text = "";
	}
	
	public HTMLHeadTag(int i) {
		tagName = "h" + i;
		sTag = "<h" + i + ">";
		eTag = "</h" + i + ">";
		indentNum = -1;
		text = "";
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
	 * Sets the number of indents before the construct.
	 * @param int iNum
	 */
	public void setIndentNum(int iNum){
		indentNum = iNum;
	}
	
	/**
	 * Returns the number of indents before the construct.
	 * @return int indentNum
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
	 * Recursive function to get the HTML tag composite structure as a String.
	 * @param html - the HTML as a string.
	 * @param isIndenting - boolean for whether the structure should be indented or not.
	 * @param iNum - int for the number of indents before the tag should be inserted (initial value should be 0).
	 * @return String html
	 */
	public String getHTML(String html, boolean isIndenting, int iNum){
		if( indentNum != -1 ){
			iNum = indentNum;
		}
		
		html += "\n";
				
		if (isIndenting){
			for ( int j = 0; j < iNum; j++ ){
				html += "\t";
			}
		}
		html += sTag;
		
		iNum++;
		
		if ( childConstructs.size() == 0){
			html += text;
		} else{
			
			for ( int i = 0; i < childConstructs.size(); i++){
				html += childConstructs.get(i).getHTML(html, isIndenting, iNum);
			}
			
		}
		
		html += eTag;
		
		return html;
	}

}