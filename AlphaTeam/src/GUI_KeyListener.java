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
		GUI_BufferWindow.getWindow(index).update();
		Buffer.getBuffer(index).setText(GUI_BufferWindow.getWindow(index).getText());
		
		System.out.println(GUI_BufferWindow.getWindow(index).getText());
		System.out.println(Buffer.getBuffer(index).getText());
	}
}