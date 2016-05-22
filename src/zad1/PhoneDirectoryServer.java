package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by pavel on 22.05.16.
 */
public class PhoneDirectoryServer {

    private PhoneDirectoryServer(){
        try {

            PhoneDirectory ref = new PhoneDirectory(System.getProperty("user.dir") + "/src/tel/name_number");

            Context ctx = new InitialContext();
            ctx.rebind("PhoneDirectoryService", ref );

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void startServer(){
        //set selektorowy server
    }

    public static void main(String [] args){
        new PhoneDirectoryServer();
    }

}
