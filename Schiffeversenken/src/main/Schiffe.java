package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Schiffe extends UnicastRemoteObject implements SchiffeInterface{
	ArrayList<Integer> schiffe = new ArrayList<Integer>();
	
	public ArrayList<Integer> getSchiffe() {
		return schiffe;
	}

	public void setSchiffe(ArrayList<Integer> schiffe) {
		this.schiffe = schiffe;
	}

	public Schiffe() throws RemoteException {
		for (int k = 0; k <= 14; k++) {
			int zahl = (int) Math.round(Math.random() * 48);
			if (schiffe.contains(zahl)) {
				k--;
			} else {
				schiffe.add(zahl);
			}
		}
	}

	@Override
	public boolean contains(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return this.getSchiffe().contains(i);
	}

}
