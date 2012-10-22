/**
 * Author: Stephen Brewster Group 1
 * Date:   9/17/2012
 * Description:
 * 		Provides formatting for GUI components of the HTML Editor
 * @author Stephen Brewster
 */


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.*;

public class Formatter {
	private Border border;
	private Color bg;
	private Dimension button;
	
	/**
	 * Default constructor: sets up formatted components with their values
	 */
	public Formatter() {
		border = BorderFactory.createBevelBorder(1);
		bg = new Color(250,250,250);
		button = new Dimension(80,30);
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public Color getBg() {
		return bg;
	}

	public void setBg(Color bg) {
		this.bg = bg;
	}

	public Dimension getButton() {
		return button;
	}

	public void setButton(Dimension button) {
		this.button = button;
	}
}