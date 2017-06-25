package main;
import java.rmi.RemoteException;

import gui.Spielfeld;

public class Main {
	public static void main(String[] args) throws RemoteException {
		Spielfeld spielfeld = new Spielfeld();
		spielfeld.setSize(800, 600);
		spielfeld.setVisible(true);
	}
}



