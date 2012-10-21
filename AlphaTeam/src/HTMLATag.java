/**
 * HTMLATag.java
 */

/**
 * @author Michael Yeaple
 * @authro Stephen Brewster
 */

public class HTMLATag extends HTMLConstruct {
	
	//Declare private vars
	private String url;
	
	/**
	 * Default constructor
	 */
	public HTMLATag(){
		tagName = "a";
		sTag = "<a>";
		eTag = "</a>";
		text = "";
	}
	
	/**
	 * Constructor to be used for URL and link text.
	 * Sets up the A tag with the specified URL.
	 * @param url - The A tag's URL.
	 */
	public HTMLATag(String url, String linktext){
		tagName = "a";
		eTag = "</a>";
		text = linktext;
		setURL(url); //Sets up the URL and start tag using the URL parameter.
	}
	
	/**
	 * Gets the url.
	 * @return url - The A tag's URL.
	 */
	public String getURL(){
		return url;
	}
	
	/**
	 * Sets a new URL.
	 * @param src - The URL to be set.
	 */
	public void setURL(String url){
		sTag = "<a href=\"" + url + "\">";
		this.url = url;
	}
}