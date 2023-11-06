package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{

    Socket s;
    public ServerThread(Socket s){
        this.s = s;
    }
    public void run()
    {
        try {
        System.out.println("Server avviato");
        System.out.println("Un client si è connesso");
    
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String notaRicevuta;
        int n = 0;
        do {
            n++;
            notaRicevuta = in.readLine();
            System.out.println("Il client ha inviato " + notaRicevuta);
            if(n > 1)
            {
                System.out.println("Nota aggiunta numero" + " " + n);
                out.writeBytes("1" + '\n');
            }
            else if(n < 2)
            {
                System.out.println("Nota aggiunta numero" + " " + n);
                out.writeBytes("2" + '\n');
            }
        } while (notaRicevuta != null);
            System.out.println("3");
            out.writeBytes("3" + '\n');
            System.out.println(n);
            //server.close();
            //s.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Errore durante l'istanza del server !");
        System.exit(1);
    }
    }
}