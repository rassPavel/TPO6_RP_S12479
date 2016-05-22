package zad1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pavel on 22.05.16.
 */
public interface PhoneDirectoryInterface extends Remote {

    public String get(String name) throws RemoteException;

    public boolean add(String name, String telephone) throws RemoteException;

    public boolean replace(String name, String telephone) throws RemoteException;

}
