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
public class ChatSend{
    private Socket serv=null;
    private PrintWriter out=null;
    public ChatSend(Socket m) throws IOException{
        serv=m;
        out=new PrintWriter(serv.getOutputStream(),true);
        
    }
    
   
    public void sendText(String tex) {  
        out.println(tex);
    }
    
}
