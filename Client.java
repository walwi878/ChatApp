import java.io.*;
import java.net.*;

public class Client {

    public static void main (String [] args){
        try {
            int port = Integer.parseInt(args[0]);
            Socket socket = new Socket(args[1], Integer.parseInt(args[0]));
            System.err.println("Connected to localhost on port 7775");
            new ReadWriteThread(socket.getInputStream(), System.out, "").start();
            new ReadWriteThread(System.in, socket.getOutputStream(), "--> ").start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
                                       
