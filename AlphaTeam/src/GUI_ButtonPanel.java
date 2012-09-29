/**
 * Creates the quick insert button panel for the HTML editor
 * @author Stephen Brewster
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

class GUI_ButtonPanel extends JPanel{
	
	private JButton insertHTML,
					insertBold,
					insertItalic,
					insertList;
	
	private Formatter formatter;
	private GUI_ActionListener actionListener;
	
	public GUI_ButtonPanel() {
		formatter = new Formatter();
		actionListener = new GUI_ActionListener();
		setLayout(new GridLayout(5,1,10,10));
		setAlignmentX(JComponent.CENTER_ALIGNMENT);
		setBackground(formatter.getBg());
		setBorder(BorderFactory.createTitledBorder("Insert"));
		setPreferredSize(new Dimension(130,200));
		
		//Initialize buttons
		insertHTML = new JButton("</HTML>");
		insertHTML.setActionCommand("insert_HTML");
		insertHTML.setPreferredSize(formatter.getButton());
		insertHTML.addActionListener(actionListener);
		
		insertBold = new JButton("</b>");
		insertBold.setActionCommand("insert_b");
		insertBold.setPreferredSize(formatter.getButton());
		insertBold.addActionListener(actionListener);
		
		insertItalic = new JButton("</i>");
		insertItalic.setActionCommand("insert_i");
		insertItalic.setPreferredSize(formatter.getButton());
		insertItalic.addActionListener(actionListener);
		
		add(insertBold);
		add(insertItalic);
		add(insertHTML);
	}
}