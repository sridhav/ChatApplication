/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class Server {
    private ServerSocket serv;
    private Socket cli;
    private ArrayList<Socket> clients=new ArrayList<Socket>();
    private ArrayList<ChatWindow> chats=new ArrayList<ChatWindow>();
    private int i=0;
    public Server(int port){
        try {
            serv=new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Cannot create server on the port:"+port+"\n Exception :"+ex);
        }
    }
    public void startServer(){
        while(true){
            try {
                cli=serv.accept();
                clients.add(cli);
                chats.add(new ChatWindow("Hello",cli));
                Thread m=new Thread(new ChatWinThread(cli,chats.get(i)));
                m.start();
                i++;
            } catch (IOException ex) {
               System.out.println("Cannot Accept Connections :"+ex);
            }
        }   
    }
}
