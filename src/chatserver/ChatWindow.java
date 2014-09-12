/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sridhar
 */
public class ChatWindow extends JFrame{
    public JPanel main=new JPanel();
    public static JTextArea chatHistory=new JTextArea();
    public JScrollPane sp=new JScrollPane(chatHistory);
    public static JTextArea chatText=new JTextArea();
    public JScrollPane sp2=new JScrollPane(chatText);
    public JPanel down=new JPanel();
    public JButton send=new JButton("Send");
    private static String sendText="";
    private Socket sock=null;
    private static Socket sock2;
    public ChatWindow(String title,Socket ser){
        this.setTitle(title);
        sock=ser;
        sock2=sock;
    }
    public void createWindow() throws IOException{
        BoxLayout lay=new BoxLayout(main, BoxLayout.Y_AXIS);
        main.setLayout(lay);
        chatHistory.setEditable(false);
        chatHistory.setRows(20);
        chatHistory.setLineWrap(true);
        down.setLayout(new FlowLayout());
        chatText.setRows(2);
        chatText.setColumns(20);
        chatText.setMargin(new Insets(5,5,5,5));
        chatText.setLineWrap(true);
        sp2.setFocusable(true);
        //sp2.setSize(300,50);
        //sp2.setMaximumSize(new Dimension(300,50));
        down.add(sp2);
        down.add(send);
        main.add(sp);
        main.add(down);
        this.getContentPane().add(main);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setFocusable(true);
        chatText.addKeyListener(new KeyListener(){
               @Override
               public void keyTyped(KeyEvent e) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   
               
               }

               @Override
               public void keyPressed(KeyEvent e) {
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   
               }

               @Override
               public void keyReleased(KeyEvent e) {
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   ChatSend sen;
                   try {
                       sock2=sock;
                       sen = new ChatSend(ChatWindow.sock2);
                       if(e.getKeyCode()==KeyEvent.VK_ENTER){
                       
                       sendText=ChatWindow.chatText.getText();
                       sen.sendText(sendText);
                       ChatWindow.chatHistory.append(sendText);
                       ChatWindow.chatText.setText("");
                   }
                   else{
                       sendText="";
                   }
                   } catch (IOException ex) {
                       Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }
           });
    }
    public static String returnText(){
        return sendText;
    }
}
