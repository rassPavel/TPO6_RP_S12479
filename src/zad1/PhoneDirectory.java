package zad1;

/**
 * Created by pavel on 22.05.16.
 */
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
import java.io.*;

public class PhoneDirectory extends PortableRemoteObject implements PhoneDirectoryInterface{

    private Map pbMap = new HashMap();

    public PhoneDirectory(String fileName) throws RemoteException{
        super();
        // Inicjalna zawartość książki telefonicznej
        // jest wczytywana z pliku o formacie
        //  imię  numer_telefonu
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(" +", 2);
                pbMap.put(info[0], info[1]);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    // Zwraca numer telefonu dla podanej osoby
    public String get(String name) throws RemoteException{
        return (String) pbMap.get(name);
    }

    // Dodaje nową osobę do książki
    // Wynik:
    // - true - dodana
    // - false - nie (przy próbie dodania osoby zapisanej już w książce)
    public boolean add(String name, String telephone) throws RemoteException{
        if (pbMap.containsKey(name)) return false;
        pbMap.put(name, telephone);
        return true;
    }

    // Zastępuje numer podanej osoby nowym
    // Wynik:
    // - true (numer zastąpiony)
    // - false (nie - próba podania nowegu numeru nieistniejącej osoby)
    public boolean replace(String name, String telephone) throws RemoteException{
        if (!pbMap.containsKey(name)) return false;
        pbMap.put(name, telephone);
        return true;
    }

}
