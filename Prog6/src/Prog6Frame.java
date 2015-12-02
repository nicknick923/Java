
/**
~Jake
 @author Nick Sosinski
 @author Jake Ira
 */
public class Prog6Frame extends java.awt.Frame
{

   RpnEvaluator rpnEval;

   /**
    Creates new form Prog6Frame
    */
   public Prog6Frame()
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

      queueLabel = new java.awt.Label();
      stackLa = new java.awt.Label();
      stepButton = new java.awt.Button();
      clearAllButton = new java.awt.Button();
      expressionLabel = new java.awt.Label();
      answerLabel = new java.awt.Label();
      RPNTextField = new java.awt.TextField();
      answerTextField = new java.awt.TextField();
      queueList = new java.awt.List();
      stackList = new java.awt.List();

      setMinimumSize(new java.awt.Dimension(500, 500));
      addWindowListener(new java.awt.event.WindowAdapter()
      {
         public void windowClosing(java.awt.event.WindowEvent evt)
         {
            exitForm(evt);
         }
      });
      setLayout(null);

      queueLabel.setName(""); // NOI18N
      queueLabel.setText("Queue");
      add(queueLabel);
      queueLabel.setBounds(20, 20, 41, 20);

      stackLa.setText("Stack");
      add(stackLa);
      stackLa.setBounds(140, 20, 34, 20);

      stepButton.setLabel("Step");
      stepButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            stepButtonActionPerformed(evt);
         }
      });
      add(stepButton);
      stepButton.setBounds(250, 60, 41, 24);

      clearAllButton.setLabel("Click to clear all");
      clearAllButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            clearAllButtonActionPerformed(evt);
         }
      });
      add(clearAllButton);
      clearAllButton.setBounds(250, 100, 100, 24);

      expressionLabel.setText("Raw RPN expression");
      add(expressionLabel);
      expressionLabel.setBounds(20, 210, 130, 20);

      answerLabel.setText("Answer");
      add(answerLabel);
      answerLabel.setBounds(20, 240, 50, 20);

      RPNTextField.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            RPNTextFieldActionPerformed(evt);
         }
      });
      RPNTextField.addTextListener(new java.awt.event.TextListener()
      {
         public void textValueChanged(java.awt.event.TextEvent evt)
         {
            RPNTextFieldTextValueChanged(evt);
         }
      });
      add(RPNTextField);
      RPNTextField.setBounds(150, 210, 180, 20);

      answerTextField.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            answerTextFieldActionPerformed(evt);
         }
      });
      add(answerTextField);
      answerTextField.setBounds(80, 240, 190, 20);

      queueList.setName("queueList"); // NOI18N
      add(queueList);
      queueList.setBounds(20, 40, 100, 160);

      stackList.setName("stackList"); // NOI18N
      add(stackList);
      stackList.setBounds(140, 40, 100, 160);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       System.exit(0);
    }//GEN-LAST:event_exitForm
/**
    ~Nick
    @param evt 
    */
   private void stepButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stepButtonActionPerformed
   {//GEN-HEADEREND:event_stepButtonActionPerformed
      if (rpnEval.getDone())
         try
         {
            answerTextField.setText(rpnEval.getAnswer().toString());
         }
         catch (Exception e)
         {
         }
      if (rpnEval != null)
         rpnEval.processToken();
      updateStackAndQueue();

   }//GEN-LAST:event_stepButtonActionPerformed
/**
   ~Jake
   @param evt 
   */
   private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearAllButtonActionPerformed
   {//GEN-HEADEREND:event_clearAllButtonActionPerformed
      queueList.removeAll();
      stackList.removeAll();
   }//GEN-LAST:event_clearAllButtonActionPerformed

   private void RPNTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RPNTextFieldActionPerformed
   {//GEN-HEADEREND:event_RPNTextFieldActionPerformed

   }//GEN-LAST:event_RPNTextFieldActionPerformed

   private void answerTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_answerTextFieldActionPerformed
   {//GEN-HEADEREND:event_answerTextFieldActionPerformed

   }//GEN-LAST:event_answerTextFieldActionPerformed
/**
   ~Nick
   @param evt 
   */
   private void RPNTextFieldTextValueChanged(java.awt.event.TextEvent evt)//GEN-FIRST:event_RPNTextFieldTextValueChanged
   {//GEN-HEADEREND:event_RPNTextFieldTextValueChanged
      rpnEval = new RpnEvaluator(RPNTextField.getText());
   }//GEN-LAST:event_RPNTextFieldTextValueChanged
/**
   ~Jake
   */
   private void updateStackAndQueue()
   {
      Stack tempStack = rpnEval.getStack();
      Queue tempQueue = rpnEval.getQueue();
      while (!tempStack.isEmpty())
         stackList.add(tempStack.pop().toString());
      while (!tempQueue.isEmpty())
         queueList.add(tempQueue.remove().toString());
   }

   /**
   ~Nick
    @param args the command line arguments
    */
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog6Frame().setVisible(true);
         }
      });
   }


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.TextField RPNTextField;
   private java.awt.Label answerLabel;
   private java.awt.TextField answerTextField;
   private java.awt.Button clearAllButton;
   private java.awt.Label expressionLabel;
   private java.awt.Label queueLabel;
   private java.awt.List queueList;
   private java.awt.Label stackLa;
   private java.awt.List stackList;
   private java.awt.Button stepButton;
   // End of variables declaration//GEN-END:variables
}
