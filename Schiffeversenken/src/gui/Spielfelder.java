package gui;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class Spielfelder extends JPanel {

	private static final long serialVersionUID = 7565153830521091850L;

	public Spielfelder(CheckBoxen checkBoxen) {
		super();
		GridLayout layout = new GridLayout(7, 7);
		layout.setVgap(1);
		layout.setHgap(2);
		setLayout(layout);
		for (JCheckBox cb : checkBoxen.getBoxen()) {
			add(cb);
		}
	}

}
