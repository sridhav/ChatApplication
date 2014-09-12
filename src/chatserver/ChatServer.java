/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

/**
 *
 * @author Sridhar
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Server servStart=new Server(12346);
        servStart.startServer();
    }
}
