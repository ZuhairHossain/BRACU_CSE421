package ClientServerHometask;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private Socket socket;

    ServerThread(Socket s) {
        socket = s;
    }

    public void run() {
        DataOutputStream output = null;
        try {
            InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
            BufferedReader reader = new BufferedReader(input);

            output = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);


            while (true) {
                String client_response = reader.readLine();
                if (client_response.equalsIgnoreCase("end game")) {
                    writer.println("goodbye");
                    break;
                }
                else {
                    writer.println(client_response.toUpperCase());
                }
            }

        }
        catch (IOException ex) {
            Logger.getLogger(clientServerBasic03.ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


