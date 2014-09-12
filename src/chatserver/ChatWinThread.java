/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class ChatWinThread implements Runnable {
    private Socket sock=null;
    private ChatWindow chat;
    public ChatWinThread(Socket m, ChatWindow ch) throws IOException{
        sock=m;
       chat=ch;
    }
    
    @Override
    public void run() {
        try {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 chat=new ChatWindow("Server ChatWindow",sock);
                 chat.createWindow();
                Thread recv=new Thread(new Chat2Thread(sock));
                 recv.start();
        } catch (IOException ex) {
            Logger.getLogger(ChatWinThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
