
import java.awt.event.ActionEvent;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class Prog5GUI extends java.awt.Frame implements java.awt.event.ActionListener
{
//private final teddyFig Teddy;
private final listOfPFigures figureList;
private final javax.swing.Timer moveTimer = new javax.swing.Timer(200, this);

   /**
    Creates new form Prog5GUI
    */
   public Prog5GUI()
   {
      initComponents();
      figureList  = new listOfPFigures(gamePanel);
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
      clearAllFigs = new java.awt.Button();
      addFigure = new java.awt.Button();
      addEnemy = new java.awt.Button();
      addxBoxDeathBox = new java.awt.Button();

      setMinimumSize(new java.awt.Dimension(1000, 1000));
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
      gamePanel.setBounds(20, 30, 750, 560);

      clearAllFigs.setActionCommand("clearAllFigs");
      clearAllFigs.setLabel("Clear All Figures");
      clearAllFigs.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            clearAllFigsActionPerformed(evt);
         }
      });
      add(clearAllFigs);
      clearAllFigs.setBounds(100, 600, 100, 24);

      addFigure.setActionCommand("addFig");
      addFigure.setLabel("Add Teddy");
      addFigure.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            addFigureActionPerformed(evt);
         }
      });
      add(addFigure);
      addFigure.setBounds(20, 600, 73, 24);

      addEnemy.setActionCommand("addEnemy");
      addEnemy.setLabel("Add Enemy");
      addEnemy.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            addEnemyActionPerformed(evt);
         }
      });
      add(addEnemy);
      addEnemy.setBounds(210, 600, 70, 24);

      addxBoxDeathBox.setActionCommand("addxBoxDeathBox");
      addxBoxDeathBox.setLabel("Add xBoxDeathBox");
      addxBoxDeathBox.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            addxBoxDeathBoxActionPerformed(evt);
         }
      });
      add(addxBoxDeathBox);
      addxBoxDeathBox.setBounds(300, 600, 130, 24);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       System.exit(0);
    }//GEN-LAST:event_exitForm

   private void clearAllFigsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearAllFigsActionPerformed
   {//GEN-HEADEREND:event_clearAllFigsActionPerformed
      figureList.removeAllFigures();
   }//GEN-LAST:event_clearAllFigsActionPerformed

   private void addFigureActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addFigureActionPerformed
   {//GEN-HEADEREND:event_addFigureActionPerformed
      figureList.addFigure(new teddyFig(gamePanel));
   }//GEN-LAST:event_addFigureActionPerformed

   private void addEnemyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addEnemyActionPerformed
   {//GEN-HEADEREND:event_addEnemyActionPerformed
      figureList.addFigure(new deathBox(gamePanel));
   }//GEN-LAST:event_addEnemyActionPerformed

   private void addxBoxDeathBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addxBoxDeathBoxActionPerformed
   {//GEN-HEADEREND:event_addxBoxDeathBoxActionPerformed
      figureList.addFigure(new xBoxDeathBox(gamePanel));
   }//GEN-LAST:event_addxBoxDeathBoxActionPerformed

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
      figureList.drawAll();
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.Button addEnemy;
   private java.awt.Button addFigure;
   private java.awt.Button addxBoxDeathBox;
   private java.awt.Button clearAllFigs;
   private java.awt.Panel gamePanel;
   // End of variables declaration//GEN-END:variables
}
