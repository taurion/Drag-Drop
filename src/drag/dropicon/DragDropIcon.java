/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drag.dropicon;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 *
 * @author dam
 */
public class DragDropIcon extends JFrame{

   private String impedir = "/images/";
   
   public DragDropIcon(){
       
       setTitle("Icon Drag & Drop");
       
       JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,50,15));
       
       ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource(impedir+"crying.png"));
       ImageIcon icon2 = new javax.swing.ImageIcon(getClass().getResource(impedir+"mad.png"));
       ImageIcon icon3 = new javax.swing.ImageIcon(getClass().getResource(impedir+"sad.png"));
       
       JButton button = new JButton(icon2);
       button.setFocusable(false);
       
       JLabel label1 = new JLabel(icon1,JLabel.CENTER);
       JLabel label2 = new JLabel(icon3,JLabel.CENTER);
       
       MouseListener listener = new MouseAdapter(){
           public void mousePressed(MouseEvent e){
               JComponent c=(JComponent) e.getSource();
               TransferHandler handler = c.getTransferHandler();
               handler.exportAsDrag(c, e, TransferHandler.COPY);
           }
       };
       label1.addMouseListener(listener);
       label2.addMouseListener(listener);
       
       label1.setTransferHandler(new TransferHandler("icon"));
       button.setTransferHandler(new TransferHandler("icon"));
       label2.setTransferHandler(new TransferHandler("icon"));
       
       panel.add(label1);
       panel.add(button);
       panel.add(label2);
       add(panel);
       
       pack();
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setVisible(true);
       
   }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DragDropIcon();
    }
}
