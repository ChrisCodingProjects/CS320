import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

// Author of this project: Christopher Majek 
// Server base file provided by Professor Akbas
// Submission date: Dec 12th, 2022
// Final Assignment, Server class for processing network traffic

public class Server extends JFrame 
{
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) 
    {
        new Server();
    }

    // Creates a server that calculates and responds with BMI from input streams
    public Server() 
    {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!

        try 
        {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + '\n');

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(
            socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
            socket.getOutputStream());

            while (true) 
            {
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
        }
        catch(IOException ex) 
        {
            System.err.println(ex);
        }
    }
} 
