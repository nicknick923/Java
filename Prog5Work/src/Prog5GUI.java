
import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author Nick
 */
public class Prog5GUI extends java.awt.Frame implements java.awt.event.ActionListener
{
private final teddyFig Teddy;

private javax.swing.Timer moveTimer = new javax.swing.Timer(200, this);

   /**
    Creates new form Prog5GUI
    */
   public Prog5GUI()
   {
      initComponents();
      Teddy = new teddyFig(gamePanel);
      moveTimer.start();
   }

   /**
    This method is called from within the constructor to initialize the form.
    WARNING: Do NOT modify this code. The content of this method is always
    regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      gamePanel = new java.awt.Panel();

      setMinimumSize(new java.awt.Dimension(500, 500));
      addWindowListener(new java.awt.event.WindowAdapter()
      {
         public void windowClosing(java.awt.event.WindowEvent evt)
         {
            exitForm(evt);
         }
      });
      setLayout(null);

      gamePanel.setBackground(new java.awt.Color(200, 200, 200));
      add(gamePanel);
      gamePanel.setBounds(20, 30, 360, 270);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       System.exit(0);
    }//GEN-LAST:event_exitForm

   /**
    @param args the command line arguments
    */
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog5GUI().setVisible(true);
         }
      });
   }
   @Override
   public void actionPerformed(ActionEvent ae)
   {
      Teddy.hide();
      Teddy.move();
      Teddy.draw();
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.Panel gamePanel;
   // End of variables declaration//GEN-END:variables
}
