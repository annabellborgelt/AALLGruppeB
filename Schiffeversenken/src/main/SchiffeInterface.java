package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SchiffeInterface extends Remote {
	public boolean contains(int i) throws RemoteException;

	//public int add(int i, int j);

}
