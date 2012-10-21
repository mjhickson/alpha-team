/**
 * HTMLATag.java
 */

/**
 * @author Michael Yeaple
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
	 * Constructor to be used if a URL is passed in.
	 * Sets up the A tag with the specified URL.
	 * @param url - The A tag's URL.
	 */
	public HTMLATag(String url){
		tagName = "a";
		eTag = "</a>";
		text = "";
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
		sTag = "<img src=\"" + url + "\">";
		this.url = url;
	}
	
}