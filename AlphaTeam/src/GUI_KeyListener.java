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

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		int index = GUI_Main.getSelectedTab();
		StringBuffer temp = new StringBuffer(GUI_BufferWindow.getWindow(index).getText());
		temp.insert(GUI_BufferWindow.getWindow(index).getCursorPosition(), e.getKeyChar());
		Buffer.getBuffer(index).setText(temp.toString());
	}
}