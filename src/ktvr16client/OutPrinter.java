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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvm
 */
public class OutPrinter implements Runnable{
    PrintWriter outPrint;
    BufferedReader kbRead;

    public OutPrinter(PrintWriter outPrint) {
        this.outPrint=outPrint;
        this.kbRead = new BufferedReader(new InputStreamReader(System.in));
    }
    
    @Override
    public void run() {
        do {            
            try {
                String line = kbRead.readLine();
                if("stop".equals(line)){
                    outPrint.println(line);
                    break;
                }
                outPrint.println(line);
            } catch (IOException ex) {
                Logger.getLogger(OutPrinter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } while (true);
        System.exit(0);
    }
    
}
