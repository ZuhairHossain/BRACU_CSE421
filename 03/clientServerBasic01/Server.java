package clientServerBasic01;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server Running at port : 7777");

                /**Server stays  in blocking mode until unless client connects with Server**/

                Socket socket = ss.accept();
                System.out.println("Client Connected");

                String today = new Date().toString();

                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(today);

                ss.close();
            }
        }
        catch (Exception o){
            System.out.println(o);
        }
    }
}
