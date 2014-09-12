/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class Chat2Thread implements Runnable{
  private Socket serv=null;
  private BufferedReader in=null;
  public Chat2Thread(Socket m) throws IOException{
        serv=m;
       in=new BufferedReader(new InputStreamReader(serv.getInputStream())); 
    }
    
    @Override
    public void run() {
        
        String inp="";
        String inp2="";
        while(true){
            try {
                inp = in.readLine();
                if(!inp.equals(inp2)){
                    ChatWindow.chatHistory.append(inp+"\n");
                }
                Thread.sleep(100);
            } catch (IOException ex) {
                Logger.getLogger(Chat2Thread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chat2Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      }
    }
    
    

