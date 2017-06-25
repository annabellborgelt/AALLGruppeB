package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Schiffe;
import main.SchiffeInterface;

public class Spielfeld extends JFrame {
	private static final long serialVersionUID = 3571603337396435035L;
	
	SchiffeInterface schiffeI;
	
	private CheckBoxen checkBoxen = new CheckBoxen();
	//private Schiffe schiffe;// = new Schiffe();
	JTextField zug = new JTextField();
	JTextField stand = new JTextField();

	Integer[] spielstand = new Integer[2];
	int spieler = 0;

	public Spielfeld(SchiffeInterface si) throws RemoteException {
		super("Schiffe versenken");
		this.schiffeI = si;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = new JPanel(new BorderLayout());
		hauptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Starten");
		start.addActionListener(new MeinStartListener());
		buttonBox.add(start);
		//schiffe = new Schiffe();
		zug.setText("Spieler 1 ist dran");
		zug.setEditable(false);
		buttonBox.add(zug);
		stand.setEditable(false);
		buttonBox.add(stand);

		hauptPanel.add(BorderLayout.EAST, buttonBox);
		hauptPanel.add(new Spielfelder(checkBoxen));
		getContentPane().add(hauptPanel);
	}
	
	public void setSchiffeInterface(SchiffeInterface si){
		this.schiffeI = si;
	}

	public class MeinStartListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			int anzahlSchuesse = 0;
			int anzahlTreffer = 0;
			int i = 0;

			for (JCheckBox checkBox : checkBoxen.getBoxen()) {
				if (checkBox.isSelected()) {
					anzahlSchuesse++;
					//if (schiffe.getSchiffe().contains(i)) {
					//	anzahlTreffer++;
					//}
					try {
						if (schiffeI.contains(i)) {
							anzahlTreffer++;
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i++;
			}
			stand.setText("Schüsse: " + anzahlSchuesse + " Treffer: "
					+ anzahlTreffer);

			if (anzahlTreffer == 15) {
				spielstand[spieler] = anzahlSchuesse;
				for (JCheckBox checkBox : checkBoxen.getBoxen()) {
					checkBox.setSelected(false);
				}
				if (spieler == 0) {
					zug.setText("Spieler 2 ist dran");
					spieler = 1;
				} else {
					String message = "Das Spiel ist vorbei.\n";
					if (spielstand[0] < spielstand[1]) {
						message += "Gewonnen hat Spieler 1. Mit "
								+ spielstand[0] + "Schüssen.";
					} else if (spielstand[0] > spielstand[1]) {
						message += "Gewonnen hat Spieler 2. Mit "
								+ spielstand[1] + "Schüssen.";
					} else {
						message += "Das Spiel ist unentschieden";
					}
					JOptionPane.showMessageDialog(null, message);
				}
			}

		}
	}
}
