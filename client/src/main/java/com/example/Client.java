package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("CLIENT");
        Socket socket = new Socket("localhost", 3000);
        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        
        String inputUtente;
        do {
            System.out.print("Inserisci stringa: ");
            inputUtente = scanner.nextLine();
            
            out.println(inputUtente);
            
            String risposta = in.readLine();
            System.out.println("Risposta: " + risposta);
        } while (!inputUtente.equals("exit"));
        
        scanner.close();
        in.close();
        out.close();
        socket.close();
    }
}
