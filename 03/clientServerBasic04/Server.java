package clientServerBasic04;

import java.net.*;


public class Server {
    public static void main(String[] args){
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(6666);
                System.out.println("Server Running at port : 6666");

                Socket socket = ss.accept();
                System.out.println("Client Connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

                ss.close();
            }
        }
        catch (Exception e) {
            System.out.println("server connection failed " + e);
        }

    }
}
