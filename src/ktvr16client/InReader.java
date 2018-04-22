/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktvr16client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvm
 */
public class InReader implements Runnable{
    BufferedReader inRead;

    public InReader(BufferedReader inRead) {
        this.inRead = inRead;
    }

    @Override
    public void run() {
        String line;
        do {            
            try {
                line = inRead.readLine();
                if("by-by".equals(line)){
                    System.out.println(line);
                    break;
                }
                System.out.println(line);
            } catch (IOException ex) {
                Logger.getLogger(InReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
        System.exit(0);
    }
    
}
