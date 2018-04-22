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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvm
 */
public class App {
    String ip = "localhost";
    int port = 3001;
    Socket sc;
    BufferedReader inRead;
    PrintWriter outPrint;
    BufferedReader kbRead;
    String line = "";
    String clientStr = "";
    public App() {
        try {
            sc = new Socket(ip, port);
            inRead = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            outPrint = new PrintWriter(sc.getOutputStream(),true);
            kbRead = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        InReader inReader = new InReader(inRead);
        new Thread(inReader).start();
        
        OutPrinter outPrinter = new OutPrinter(outPrint);
        new Thread(outPrinter).start();
        
        
    }
    
}
