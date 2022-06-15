package clientServerBasic02;

import clientServerBasic03.ServerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server Running at port : 7777");

                /**Server stays  in blocking mode until unless client connects with Server**/

                Socket socket = ss.accept();
                System.out.println("Client Connected");

                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);

                //String today = new Date().toString();

                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);

                while (true) {
                    String client_response = reader.readLine();
                    if (client_response.equalsIgnoreCase("end game")) {
                        writer.println("goodbye");
                        break;
                    }
                    else {
                        writer.println(client_response);
                    }
                }

                ss.close();
            }
        }
        catch (Exception o){
            System.out.println(o);
        }
    }
}

