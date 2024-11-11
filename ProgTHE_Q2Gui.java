/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progthe_q2;

//imports that helps certains methods and functions work
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgTHE_Q2Gui extends javax.swing.JFrame {
    //initialising my variables as global so i can use them throughout the code 
    String comboBoxValues;
    String estateAgentNameValue;
    String propertyPriceValue;
    String commissionPercentageValue;
    double commissionCalculated;
    
    public ProgTHE_Q2Gui() {
        initComponents();
      //  ProcessInfomationButton();
    }
       
    private void ProcessInfomationButton(){
        //https://www.youtube.com/watch?v=jp3E4xDTlU0 - video that code was adapted from   https://www.geeksforgeeks.org/java-swing-jtextarea/  - (GeeksforGeeks, 2018)
        EstateAgent estateAgent = new EstateAgent () ;
      //  boolean valid = estateAgent.DataValidiation(estateAgentNameValue, comboBoxValues, propertyPriceValue, commissionPercentageValue);
     //accepting input from the user and converting the to string or text so they can be stored
      comboBoxValues = agentLocationComboBox.getSelectedItem().toString();
     estateAgentNameValue = estateAgentNameTextField.getText();
     propertyPriceValue = propertyPriceTextField.getText();
     commissionPercentageValue = commissionPercentageTextField.getText();
     commissionCalculated = estateAgent.CalculateTotalCommission(propertyPriceValue, commissionPercentageValue);
   //calls the method from the other class 
     boolean valid = estateAgent.DataValidiation(estateAgentNameValue, comboBoxValues, propertyPriceValue, commissionPercentageValue);
    //is a boolean so it is testing true aand false if false it will produce a system output
     if(valid) {// takes information that is entered and displays it in the text area 
    estateAgentReportTextArea.append("agent location " + comboBoxValues + "\n");
    estateAgentReportTextArea.append("agents name " +estateAgentNameValue + "\n");
    estateAgentReportTextArea.append("value of property "+propertyPriceValue + "\n");
    estateAgentReportTextArea.append("commission percentage "+commissionPercentageValue + "\n");
    estateAgentReportTextArea.append("commission calculated "+commissionCalculated + "\n");
     }
     else {
           
           // data does not meet validation 
                System.out.println("Invalid data type or empty colomn");
           
            }
    
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agentLocation = new javax.swing.JLabel();
        agentLocationComboBox = new javax.swing.JComboBox<>();
        estateAgentName = new javax.swing.JLabel();
        estateAgentNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        propertyPriceTextField = new javax.swing.JTextField();
        commissionPercentage = new javax.swing.JLabel();
        commissionPercentageTextField = new javax.swing.JTextField();
        estateAgentReport = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estateAgentReportTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ProcessReportMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();
        SaveReportMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ESTATE AGENT REPORT");

        agentLocation.setText("Agent Location :");

        agentLocationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cape Town", "Durban", "Pretoria" }));

        estateAgentName.setText("Estate Agent Name: ");

        jLabel1.setText("Property Price: ");

        propertyPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyPriceTextFieldActionPerformed(evt);
            }
        });

        commissionPercentage.setText("Commission Percentage:");

        estateAgentReport.setText("Estate Agent Report:");

        estateAgentReportTextArea.setColumns(20);
        estateAgentReportTextArea.setRows(5);
        jScrollPane1.setViewportView(estateAgentReportTextArea);

        jMenu1.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        ProcessReportMenuItem.setText("Process Report");
        ProcessReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessReportMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(ProcessReportMenuItem);

        ClearMenuItem.setText("Clear");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(ClearMenuItem);

        SaveReportMenuItem.setText("Save Report");
        SaveReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveReportMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(SaveReportMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(estateAgentReport, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(commissionPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agentLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estateAgentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agentLocationComboBox, 0, 0, Short.MAX_VALUE)
                            .addComponent(estateAgentNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(propertyPriceTextField)
                            .addComponent(commissionPercentageTextField))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agentLocationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agentLocation))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estateAgentName)
                    .addComponent(estateAgentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(propertyPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commissionPercentage)
                    .addComponent(commissionPercentageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(estateAgentReport)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void propertyPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propertyPriceTextFieldActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);// this code ends the application when called on 
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ProcessReportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessReportMenuItemActionPerformed
        ProcessInfomationButton();// calls the method that was done above 
    }//GEN-LAST:event_ProcessReportMenuItemActionPerformed

    private void ClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearMenuItemActionPerformed
       // resets the textfields so they can accept new information 
        commissionPercentageTextField.setText(null);
        estateAgentNameTextField.setText(null);
        estateAgentReportTextArea.setText(null);//https://www.youtube.com/watch?v=j1l0Q-P60Rk  - code was adapted from video (www.youtube.com, n.d.)
        propertyPriceTextField.setText(null);
        agentLocationComboBox.getSelectedIndex();
    }//GEN-LAST:event_ClearMenuItemActionPerformed

    private void SaveReportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveReportMenuItemActionPerformed
        //gets the information that is stored in the text area 
       String info = estateAgentReportTextArea.getText() ;
        try {
            FileWriter writer = new FileWriter("report.txt") ;// this is where the text file is created and called upon
            writer.write(info);
            writer.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ProgTHE_Q2Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        //https://www.geeksforgeeks.org/java-program-to-write-into-a-file/  - (GeeksforGeeks, 2021) code was adapted to send to text file
    }//GEN-LAST:event_SaveReportMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProgTHE_Q2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgTHE_Q2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgTHE_Q2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgTHE_Q2Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgTHE_Q2Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JMenuItem ProcessReportMenuItem;
    private javax.swing.JMenuItem SaveReportMenuItem;
    private javax.swing.JLabel agentLocation;
    private javax.swing.JComboBox<String> agentLocationComboBox;
    private javax.swing.JLabel commissionPercentage;
    private javax.swing.JTextField commissionPercentageTextField;
    private javax.swing.JLabel estateAgentName;
    private javax.swing.JTextField estateAgentNameTextField;
    private javax.swing.JLabel estateAgentReport;
    private javax.swing.JTextArea estateAgentReportTextArea;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField propertyPriceTextField;
    // End of variables declaration//GEN-END:variables
}
