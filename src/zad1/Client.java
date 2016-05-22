package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.io.*;

/**
 * Created by pavel on 22.05.16.
 */
public class Client {

    public static void  main( String args[] ) {
        new Client();
    }

    private Client(){
        try {
            Context ctx = new InitialContext();

            Object objref = ctx.lookup("AddressInfoService");

            PhoneDirectoryInterface pdi;
            pdi = (PhoneDirectoryInterface) PortableRemoteObject.narrow(
                    objref, PhoneDirectoryInterface.class);

            comunication(pdi);


        } catch( Exception e ) {
            e.printStackTrace( );
        }
    }

    private void comunication(PhoneDirectoryInterface obj){

        String []str;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader console = null;

        try {
            is = System.in;
            isr = new InputStreamReader(is);
            console = new BufferedReader(new InputStreamReader(System.in));

                loop:
                while (true) {
                    str = console.readLine().split(" ");
                    switch (str[0]) {
                        case "get":
                            obj.get(str[1]);
                            break;
                        case "add":
                            obj.add(str[1], str[2]);
                            break;
                        case "replace":
                            obj.replace(str[1], str[2]);
                            break;
                        case "bye": break loop;
                    }

                }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                console.close();
                isr.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
