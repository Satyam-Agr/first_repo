package Github_Repos.first_repo.practice_codes.NetworkingMessage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
public class MessageClient {
    
    private JTextField outgoing;
    private JTextArea incomming;
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket ;

    public void go() {
        setUpNetworking();
        outgoing = new JTextField(20);
        incomming = new JTextArea("Start:-\n");
        incomming.setEditable(false);
        incomming.setLineWrap(true);
        JScrollPane chat = new JScrollPane(incomming);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, chat);
        frame.getContentPane().add(BorderLayout.SOUTH, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void setUpNetworking() {
        try {
            socket = new Socket ("localhost", 5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            Thread thread = new Thread(() -> reciveMessage());
            thread.start();
            System.out.println("Networking established.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }
    private void reciveMessage() {
        try{
            while (true) {
                String in = reader.readLine().trim();
                incomming.append("\n" + in);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new MessageClient().go();
    }
}
