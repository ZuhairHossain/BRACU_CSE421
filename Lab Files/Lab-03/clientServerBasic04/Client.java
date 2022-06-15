package clientServerBasic04.v2;

import java.io.*;
import java.lang.Exception;
import java.net.*;

public class Client {
    public static void main(String []args) throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(a);
        
        
        Socket clientSoc = new Socket("localhost", 8888);
        System.out.println("connected to server");
        
        
            BufferedInputStream x = new BufferedInputStream(clientSoc.getInputStream());
            DataInputStream input = new DataInputStream(x);

            String fromServer = input.readUTF();
            System.out.println(fromServer);
            System.out.println();


            System.out.println("Enter your option");
            String choice = buffer.readLine();
            BufferedOutputStream y = new BufferedOutputStream(clientSoc.getOutputStream());
            DataOutputStream output = new DataOutputStream(y);
            output.writeUTF(choice);
            output.flush();

            clientSoc.close();
            output.close();
            input.close();
    }
}
