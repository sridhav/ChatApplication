/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class Client {
   private Socket cli;
   private ChatWindow chat=null;
   public Client(String host, int port){
       try {
           
           cli=new Socket(host,port);
           chat=new ChatWindow("Client Chat",cli);
           chat.createWindow();
           Thread recv=new Thread(new Chat2Thread(cli));
           recv.start();
       } catch (UnknownHostException ex) {
           System.out.println("Host not found "+host+":"+port+"\n Exception :"+ex);
       } catch (IOException ex) {
           System.out.println("Exception :"+ex);
       }
   }
   
 
   
   
}
