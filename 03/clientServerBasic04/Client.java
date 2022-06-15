package clientServerBasic04;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);

            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader read = new BufferedReader(input);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            Scanner sc = new Scanner(System.in);

            int check = 0;
            while(check == 0) {
                String reading = read.readLine();;

                String in = "";
                if (reading.equals("Please enter your choice")){
                    System.out.println("Please enter your choice");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(read.readLine());
                    }
                    in = sc.nextLine();

                    if (in.contains("exit")) {
                        writer.println("exit");
                        System.out.println("connection over");
                        check = 1;
                        break;
                    }
                }

                else if (reading.equals("1") || reading.equals("2") || reading.equals("3")){
                    for (int i = 0; i < 2; i++) {
                        System.out.println(read.readLine());
                    }
                    in = sc.nextLine();
                    System.out.println(read.readLine());
                    in = sc.nextLine();
                    System.out.println(read.readLine());
                    System.out.println(read.readLine());
                }

                else{
                    System.out.println("wrong input");
                }

                /**
                writer.println(in);
                System.out.println(read.readLine());

                writer.println(sc.nextLine());
                System.out.println(read.readLine());

                writer.println(sc.nextLine());
                System.out.println(read.readLine());
                **/
            }


            //sc.close();
            //s.close();

        }
        catch (Exception o) {
            System.out.println(o);
        }
    }
}
