import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class TaskList extends JFrame implements ItemListener {
	
	ListView lv;
	GridView gv;
	CalendarView cv;
	JPanel cardPanel;
	JComboBox<String> viewSwitcher;
	GridBagConstraints c;
	
	public TaskList(String name) {
		super(name);
		
		c = new GridBagConstraints();
		
		this.setSize(1000, 650);
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(1000, 650));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		String comboBoxItems[] = {"List View", "Grid View", "Calendar View"};
		viewSwitcher = new JComboBox<String>(comboBoxItems);
		viewSwitcher.setEditable(false);
		viewSwitcher.addItemListener(this);
		c.anchor = c.NORTHWEST;
		c.ipadx = 10;
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 0;
		this.add(viewSwitcher, c);
		
		lv = new ListView();
		gv = new GridView();
		cv = new CalendarView();
		
		cardPanel = new JPanel(new CardLayout());		
		cardPanel.add(lv, "List View");
		cardPanel.add(gv, "Grid View");	
		c.ipadx = 10;
		c.ipady = 10;
		c.gridx = 1;
		c.gridy = 3;
		this.add(cardPanel, c);		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(cardPanel.getLayout());
	    cl.show(cardPanel, (String)e.getItem());
	}
}
