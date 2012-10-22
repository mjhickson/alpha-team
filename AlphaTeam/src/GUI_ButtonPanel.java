/**
 * Creates the quick insert button panel for the HTML editor
 * @author Stephen Brewster
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GUI_ButtonPanel extends JPanel{
	
	private JButton insertHead,
					insertBold,
					insertItalic,
					insertLink,
					insertImg,
					linkView;
	
	private JTextField tRow, tCol;
	private Formatter formatter;
	private GUI_ActionListener actionListener;
	
	public GUI_ButtonPanel() {
		formatter = new Formatter();
		actionListener = new GUI_ActionListener();
		
		setLayout(new GridLayout(6,1,10,10));
		setAlignmentX(JComponent.CENTER_ALIGNMENT);
		setBackground(formatter.getBg());
		setBorder(BorderFactory.createTitledBorder("Insert"));
		setPreferredSize(new Dimension(130,200));
		
		//Create buttons
		insertHead = new JButton("<h1>");
		insertHead.setActionCommand("insert_head");
		insertHead.setPreferredSize(formatter.getButton());
		insertHead.addActionListener(actionListener);
		
		insertBold = new JButton("<b>");
		insertBold.setActionCommand("insert_b");
		insertBold.setPreferredSize(formatter.getButton());
		insertBold.addActionListener(actionListener);
		
		insertItalic = new JButton("<i>");
		insertItalic.setActionCommand("insert_i");
		insertItalic.setPreferredSize(formatter.getButton());
		insertItalic.addActionListener(actionListener);
	
		insertImg = new JButton("<img src>");
		insertImg.setActionCommand("insert_Img");
		insertImg.setPreferredSize(formatter.getButton());
		insertImg.addActionListener(actionListener);
		
		insertLink = new JButton("<a href>");
		insertLink.setActionCommand("insert_ahref");
		insertLink.setPreferredSize(formatter.getButton());
		insertLink.addActionListener(actionListener);

		linkView = new JButton("Link View");
		linkView.setActionCommand("viewLinks");
		linkView.setPreferredSize(formatter.getButton());
		linkView.addActionListener(actionListener);
		
		tRow = new JTextField();
		tCol = new JTextField();
		
		//Panel for table insertion
		JPanel insertTable_p = new JPanel();
		insertTable_p.setLayout(new GridLayout(2,1));
		insertTable_p.add(insertImg);
		
		JPanel tableDim = new JPanel();
		tableDim.add(tRow);
		tableDim.add(tCol);	
			insertTable_p.add(tableDim);
			
		add(insertHead);		
		add(insertBold);
		add(insertItalic);
		add(insertImg);
		add(insertLink);
		add(linkView);
	}
}