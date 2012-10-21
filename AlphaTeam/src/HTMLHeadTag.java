/**
 * HTMLHeadTag.java
 */

/**
 * @author Michael Yeaple
 */


public class HTMLHeadTag extends HTMLConstruct {
	
	public HTMLHeadTag(){
		tagName = "h1";
		sTag = "<h1>";
		eTag = "</h1>";
		text = "";
	}
	
	/**
	 * Specific constructor
	 * @param headerNum - the number of the heading type (1-6)
	 */
	public HTMLHeadTag(int headerNum){
		if (headerNum >= 1 && headerNum <= 6){
			tagName = "h" + headerNum;
			sTag = "<h" + headerNum + ">";
			eTag = "</h" + headerNum + ">";
		}
		text = "";
	}
	
}