import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

// Author of this project: Christopher Majek 
// Server base file provided by Professor Akbas
// Submission date: Dec 12th, 2022
// Final Assignment, Server class for processing network traffic for multiple clients by using multi threading

public class MultiThreadedServer extends JFrame
{
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) 
    {
        new MultiThreadedServer();
    }

    // Creates a server that makes a thread for each connecting client
    public MultiThreadedServer() 
    {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!
        int clientNumber = 1;

        try 
        {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + '\n');

            while (true) 
            {
                // Listen for a connection request
                Socket socket = serverSocket.accept();
                jta.append("connected to client " + clientNumber + '\n');

                // Creates a new thread for each connecting user
                HandleClient thread = new HandleClient(socket);
                thread.start();
                clientNumber++;
            }
        }
        catch(IOException ex) 
        {
            System.err.println(ex);
        }
    }

    // Mini application that handles a client thread
    class HandleClient extends Thread
    {
        private Socket socket;
        public HandleClient(Socket serverSocket)
        {
            this.socket = serverSocket;
        }

        // This thread calculates and responds with BMI from input streams recieved from each client
        public void run()
        {
            try
            {
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                socket.getOutputStream());

                // Receive weight and height from the client
                double weight = inputFromClient.readDouble();
                jta.append("Weight received from client: " + weight + '\n');
                double height = inputFromClient.readDouble();
                jta.append("Height received from client: " + height + '\n');
                
                // Compute bmi
                double bmi = weight / (height * height);

                // Send BMI back to the client
                outputToClient.writeDouble(bmi);

                jta.append("BMI found: " + bmi + '\n');
            }
            catch(IOException ex) 
            {
                System.err.println(ex);
            }
        }
    }
} 

