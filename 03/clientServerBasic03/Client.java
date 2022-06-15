package clientServerBasic03;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",7777);

            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            Scanner sc = new Scanner(System.in);

            while (true){
                System.out.println("Say something to the server - ");
                String in = sc.nextLine();

                writer.println(in);
                String response = reader.readLine();
                System.out.println("From server - " + response);

                if (response.equalsIgnoreCase("goodbye")){
                    break;
                }
            }

            s.close();
        }
        catch (Exception o){
            System.out.println(o);
        }
    }
}
