package Github_Repos.first_repo.practice_codes.NetworkingMessage;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;
import static java.nio.charset.StandardCharsets.UTF_8;
public class SimpleChatServer {
    private final List<PrintWriter> clientWriters = new ArrayList<>();
    private static int connections = 0;
    public static void main(String[] args) {
        new SimpleChatServer().go();
    }
    public void go() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(5000));
            while (serverSocketChannel.isOpen()) {
                SocketChannel clientSocket = serverSocketChannel.accept();
                connections++;
                PrintWriter writer = new PrintWriter(Channels.newWriter(clientSocket, UTF_8));
                clientWriters.add(writer);
                threadPool.submit(new ClientHandler(clientSocket, connections));
                System.out.println("got a connection");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void tellEveryone(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
            writer.flush();
        }
    }
    public class ClientHandler implements Runnable {
        BufferedReader reader;
        SocketChannel socket;
        int userID;
        public ClientHandler(SocketChannel clientSocket, int userID) {
            socket = clientSocket;
            reader = new BufferedReader(Channels.newReader(socket, UTF_8));
            this.userID = userID;
        }
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone("User "+userID+": "+message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

