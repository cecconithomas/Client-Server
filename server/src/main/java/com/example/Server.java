package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("SERVER");
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket clientSocket = serverSocket.accept();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        
        String inputLine;
        do {
            inputLine = in.readLine();
            System.out.println("Ricevuto dal client: " + inputLine); 
            out.println(inputLine.toUpperCase());
        } while (inputLine != null && !inputLine.equals("exit"));
        
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
