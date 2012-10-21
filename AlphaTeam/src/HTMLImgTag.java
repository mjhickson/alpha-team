/**
 * HTMLImgTag.java
 */

/**
 * @author Michael Yeaple
 */

public class HTMLImgTag extends HTMLConstruct {
	
	//Declare private vars
	private String src;
	
	/**
	 * Default constructor
	 */
	public HTMLImgTag(){
		tagName = "img";
		sTag = "<img>";
		eTag = "</img>";
		text = "";
	}
	
	/**
	 * Constructor to be used if a source is passed in.
	 * Sets up the IMG tag with the specified source.
	 * @param src - The image source.
	 */
	public HTMLImgTag(String src){
		tagName = "img";
		eTag = "</img>";
		text = "";
		setSrc(src); //Sets up the image source and start tag using the src parameter.
	}
	
	/**
	 * Gets the image source.
	 * @return src - The image source.
	 */
	public String getSrc(){
		return src;
	}
	
	/**
	 * Sets a new image source.
	 * @param src - The image source to be set.
	 */
	public void setSrc(String src){
		sTag = "<img src=\"" + src + "\">";
		this.src = src;
	}
	
}
