package ClientServerHometask;

import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server Running at port : 7777");

                /**Server stays  in blocking mode until unless client connects with Server**/

                Socket socket = ss.accept();
                System.out.println("Client Connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

                ss.close();
            }
        }
        catch (Exception o){
            System.out.println(o);
        }
    }
}

