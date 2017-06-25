package gui;

import java.util.ArrayList;

import javax.swing.JCheckBox;

public class CheckBoxen {
	ArrayList<JCheckBox> boxen = new ArrayList<JCheckBox>();

	public ArrayList<JCheckBox> getBoxen() {
		return boxen;
	}

	public void setBoxen(ArrayList<JCheckBox> boxen) {
		this.boxen = boxen;
	}

	public CheckBoxen() {
		for (int i = 0; i < 49; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			boxen.add(c);
		}
	}
}
