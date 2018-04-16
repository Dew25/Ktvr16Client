/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktvr16client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Melnikov
 */
public class Ktvr16Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 3001;
        
        Socket sc = new Socket(ip, port);
        BufferedReader br = 
          new BufferedReader(new InputStreamReader(sc.getInputStream()));
        PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);
        BufferedReader keyboard = 
          new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        String clientStr = "";
        do{
            line = br.readLine();
            System.out.println(line);
            clientStr = keyboard.readLine();
            pw.println(clientStr);
        }while(true);
    }
    
}
