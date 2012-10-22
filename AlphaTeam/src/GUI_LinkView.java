import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class GUI_LinkView extends JFrame {
	private static JTextArea disWindow;
	private static JScrollPane scroller;
	
	public GUI_LinkView() {
		disWindow = new JTextArea();
			disWindow.setBorder(BorderFactory.createTitledBorder("Link View"));
		scroller = new JScrollPane(disWindow);
		add(scroller);
	}
	
	public static void displayLinks(ArrayList<String> links) {
		for(int i = 0; i < links.size(); i++) {
			disWindow.append(links.get(i) + "\n");
		}
	}
}