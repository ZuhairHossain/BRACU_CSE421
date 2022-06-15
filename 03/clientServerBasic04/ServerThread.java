package clientServerBasic04;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket s) {

        socket = s;
    }

    public void run() {
        DataOutputStream output = null;
        try {
            InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
            BufferedReader read = new BufferedReader(input);


            output = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            while (true) {
                writer.println("Please enter your choice");
                writer.println("(1): Add two numbers");
                writer.println("(2): Subtract two numbers");
                writer.println("(3): Multiply two numbers");
                writer.println("Enter 'exit' to terminate the program");

                String client_response = read.readLine();

                if (client_response.equalsIgnoreCase("exit")) {
                    break;
                }

                else if(client_response.equals("1")){
                    writer.println("1");
                    writer.println("You have to enter two number for addition");
                    writer.println("Please enter the first number");
                    int a = Integer.parseInt(read.readLine());
                    writer.println("Please enter the second number");
                    int b = Integer.parseInt(read.readLine());
                    writer.println(a+b);
                }

                else if(client_response.equals("2")){
                    writer.println("2");
                    writer.println("You have to enter two number for subtract");
                    writer.println("Please enter the first number");
                    int a = Integer.parseInt(read.readLine());
                    writer.println("Please enter the second number");
                    int b = Integer.parseInt(read.readLine());
                    writer.println(a-b);
                }

                else if(client_response.equals("3")){
                    writer.println("3");
                    writer.println("You have to enter two number for multiply");
                    writer.println("Please enter the first number");
                    int a = Integer.parseInt(read.readLine());
                    writer.println("Please enter the second number");
                    int b = Integer.parseInt(read.readLine());
                    writer.println(a*b);
                }

                else {
                    writer.println("wrong input, please give a valid input by reading carefully");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
