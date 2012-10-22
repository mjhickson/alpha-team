/**
 * Picks up keys from a GUI_BufferWindow and inserts them into the 
 * associated buffer
 * 
 * @author Stephen Brewster
 */

import java.awt.event.KeyListener;

class GUI_KeyListener implements KeyListener {
	public GUI_KeyListener() {
		
	}
	
	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * When a key is typed it is passed to the associated buffer
	 */
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		int index = GUI_Main.getSelectedTab();
		
		//Insert new key pressed into a temp string
		StringBuffer temp = new StringBuffer(GUI_BufferWindow.getWindow(index).getText());
		temp.insert(GUI_BufferWindow.getWindow(index).getCursorPosition(), e.getKeyChar());
		
		//Send newly made string to the buffer
		BufferContext.getBuffer(index).setText(temp.toString());
	}
}