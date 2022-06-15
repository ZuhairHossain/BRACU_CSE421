package clientServerBasic04.v2;

import java.net.*;
import java.io.*;
import java.lang.Exception;

public class Server{
    public static void main(String[] args) throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(a);

        ServerSocket s1 = new ServerSocket(8888);
        Socket s2 = s1.accept();
        System.out.println("connected with client");

        BufferedOutputStream x = new BufferedOutputStream(s2.getOutputStream());
        DataOutputStream output = new DataOutputStream(x);
        output.writeUTF("Choose an option from these three \n (1) add\n (2) subtract\n (3) multiply");
        output.flush();

        BufferedInputStream p = new BufferedInputStream(s2.getInputStream());
        DataInputStream input = new DataInputStream(p);

            String fromClient = input.readUTF();
            System.out.println();
            System.out.println("client choose " + fromClient + " operation");
            System.out.println("Now Enter the first number");
            Double n1 = Double.parseDouble(buffer.readLine());
            System.out.println("enter second number");
            Double n2 = Double.parseDouble(buffer.readLine());

            switch (fromClient) {
                case "1":
                    System.out.println("Addition of two numbers = " + (n1 + n2));
                    break;
                case "2":
                    System.out.println("Subtraction of two numbers = " + (n1 - n2));
                    break;
                case "3":
                    System.out.println("Multiply of two numbers = " + (n1 * n2));
                    break;
                default:
                    System.out.println("Invalid operation");
            }

            s2.close();
            input.close();
            output.close();
    }
}
