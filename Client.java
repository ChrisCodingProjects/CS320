import java.io.*;
import java.net.*;
import java.util.Date;
import java.awt.*;
import javax.swing.*;

// Author of this project: Christopher Majek 
// Client base file provided by Professor Akbas
// Submission date: Dec 12th, 2022
// Final Assignment, client class for sending and receiving network traffic

// Client program designed to send height and weight to a server and recieve processed BMI
public class Client extends JFrame
{
    // Text area to display contents
    private JTextField jtf = new JTextField();
    private JTextArea jta = new JTextArea();

    // IO streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) 
    {
        new Client();
    }

    public Client() 
    {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(jtf, BorderLayout.CENTER);

        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!

        try 
        {
            // Create a socket to connect to the server
            Socket socket = new Socket("127.0.0.1", 8000);

            // Create an input stream to receive data from the server
            inputFromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            outputToServer = new DataOutputStream(socket.getOutputStream());

            jta.append("Client started at " + new Date() + '\n');
            try 
            {
                double weight = 156 / 2.2;
                double height = 72 * .0253;
        
                // Send the height and weight to the server
                outputToServer.writeDouble(weight);
                outputToServer.writeDouble(height);
                outputToServer.flush();

                // Get BMI from the server
                double bmi = inputFromServer.readDouble();
        
                // Display BMI to the text area
                jta.append("Weight sent: " + weight + "\n");
                jta.append("Height sent: " + height + "\n");
                jta.append("BMI received from the server is " + bmi + '\n');
            }
            catch (IOException ex) 
            {
                System.err.println(ex);
            }
        }
        catch (IOException ex) 
        {
            jta.append(ex.toString());
        }
    }
}