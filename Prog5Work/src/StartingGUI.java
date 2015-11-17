/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author Jake Ira
 @author Nick Sosinski
 */
public class StartingGUI extends java.awt.Frame
{

   private final Prog5GUI game = new Prog5GUI();
   private String[] commandString = new String[1];
   
   /**
    Creates new form StartingGUI
    */
   public StartingGUI()
   {
      initComponents();
   }

   /**
    This method is called from within the constructor to initialize the form.
    WARNING: Do NOT modify this code. The content of this method is always
    regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      titleLabel = new java.awt.Label();
      survivalButton = new java.awt.Button();
      roundsButton = new java.awt.Button();
      highScoresButton = new java.awt.Button();

      setBackground(java.awt.Color.red);
      setMaximumSize(new java.awt.Dimension(566, 416));
      setMinimumSize(new java.awt.Dimension(566, 416));
      addWindowListener(new java.awt.event.WindowAdapter()
      {
         public void windowClosing(java.awt.event.WindowEvent evt)
         {
            exitForm(evt);
         }
      });
      setLayout(null);

      titleLabel.setAlignment(java.awt.Label.CENTER);
      titleLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
      titleLabel.setName(""); // NOI18N
      titleLabel.setText("Cowboy ScanMan ");
      add(titleLabel);
      titleLabel.setBounds(10, 60, 550, 50);

      survivalButton.setLabel("Survival Mode");
      survivalButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            survivalButtonActionPerformed(evt);
         }
      });
      add(survivalButton);
      survivalButton.setBounds(221, 250, 90, 24);

      roundsButton.setLabel("Rounds");
      roundsButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            roundsButtonActionPerformed(evt);
         }
      });
      add(roundsButton);
      roundsButton.setBounds(220, 190, 90, 24);

      highScoresButton.setLabel("High Scores");
      highScoresButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            highScoresButtonActionPerformed(evt);
         }
      });
      add(highScoresButton);
      highScoresButton.setBounds(220, 310, 90, 24);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       System.exit(0);
    }//GEN-LAST:event_exitForm

   private void survivalButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_survivalButtonActionPerformed
   {//GEN-HEADEREND:event_survivalButtonActionPerformed
      this.hide();
      commandString[0] = "survival";
      game.main(commandString);
   }//GEN-LAST:event_survivalButtonActionPerformed

   private void roundsButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_roundsButtonActionPerformed
   {//GEN-HEADEREND:event_roundsButtonActionPerformed
      this.hide();
      commandString[0] = "rounds";
      game.main(commandString);
   }//GEN-LAST:event_roundsButtonActionPerformed

   private void highScoresButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_highScoresButtonActionPerformed
   {//GEN-HEADEREND:event_highScoresButtonActionPerformed

   }//GEN-LAST:event_highScoresButtonActionPerformed

   /**
    @param args the command line arguments
    */
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new StartingGUI().setVisible(true);
         }
      });
   }


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.Button highScoresButton;
   private java.awt.Button roundsButton;
   private java.awt.Button survivalButton;
   private java.awt.Label titleLabel;
   // End of variables declaration//GEN-END:variables
}
