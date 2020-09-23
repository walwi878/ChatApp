import java.io.*;
import java.net.*;

public class Server {

    public static void main (String [] args){
        try {
            int port = Integer.parseInt(args[0]);
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Waiting for a client to connect");
            Socket socket = serverSocket.accept();
            System.err.println("Accepted connection on port 7775");
            new ReadWriteThread(socket.getInputStream(), System.out, "").start();
            new ReadWriteThread(System.in, socket.getOutputStream(), "--> ").start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
