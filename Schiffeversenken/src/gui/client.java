package gui;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import main.SchiffeInterface;

public class client {
	SchiffeInterface myClient;
	public static void main(String[] args) throws RemoteException, NotBoundException {
		try {
			
			SchiffeInterface clientAdder = (SchiffeInterface) Naming.lookup("rmi://localhost:12345/Adder");
			boolean result = clientAdder.contains(9);
			System.out.println("Result is :" + result);
			
			Spielfeld spielfeld = new Spielfeld(clientAdder);
			spielfeld.setSize(800, 600);
			spielfeld.setVisible(true);

		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}


}
