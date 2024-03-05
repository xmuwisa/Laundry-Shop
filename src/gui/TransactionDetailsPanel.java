package gui;
import session.SessionManager;
import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luisa Eustaquio
 */
public class TransactionDetailsPanel extends javax.swing.JFrame {
    private String loggedInUsername, userRole, transacStatus;
    private int transacID;
    
    /**
     * Creates new form TransactionDetailsPanel
     */
    public TransactionDetailsPanel(int transactionID, String transactionStatus) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        getLoggedInUser();
        displayTransactionDetails(transactionID);
        transacStatus = transactionStatus;
        
        System.out.println("Transac Status" + transacStatus);
        adminBtns();
        updateCancelBtn();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnApproveTransac = new javax.swing.JButton();
        btnCancelTransac = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblDropOffDate = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblSubmittedDate = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        lblCompletedDate = new javax.swing.JLabel();
        lblTransacStatus = new javax.swing.JLabel();
        lblPaymentStatus = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDeliveryMethod = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblTransactionID = new javax.swing.JLabel();
        lblKilo = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        lblAddOn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnApproveTransac.setBackground(new java.awt.Color(204, 255, 204));
        btnApproveTransac.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnApproveTransac.setText("Approve Transaction");
        btnApproveTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveTransacActionPerformed(evt);
            }
        });
        getContentPane().add(btnApproveTransac, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        btnCancelTransac.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelTransac.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelTransac.setText("Cancel Transaction");
        btnCancelTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelTransacActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelTransac, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        lblDropOffDate.setText("jLabel3");
        getContentPane().add(lblDropOffDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        lblTotal.setText("jLabel3");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        lblSubmittedDate.setText("jLabel3");
        getContentPane().add(lblSubmittedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        lblNote.setText("jLabel3");
        getContentPane().add(lblNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        lblCompletedDate.setText("jLabel3");
        getContentPane().add(lblCompletedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        lblTransacStatus.setText("jLabel3");
        getContentPane().add(lblTransacStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        lblPaymentStatus.setText("jLabel3");
        getContentPane().add(lblPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        lblName.setText("jLabel1");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        lblDeliveryMethod.setText("jLabel3");
        getContentPane().add(lblDeliveryMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        lblContact.setText("jLabel2");
        getContentPane().add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        lblAddress.setText("jLabel3");
        getContentPane().add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        lblTransactionID.setText("jLabel1");
        getContentPane().add(lblTransactionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        lblKilo.setText("jLabel3");
        getContentPane().add(lblKilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        lblService.setText("jLabel1");
        getContentPane().add(lblService, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        lblAddOn.setText("jLabel1");
        getContentPane().add(lblAddOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Address:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Date Submitted");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Customer Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Contact Number:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Addtional Note:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Add ons:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Transaction ID:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Total:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Service Type:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Kilo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Delivery Method:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Transaction Status");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Payment Status:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Drop off Date:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Date Completed:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getLoggedInUser() {
        loggedInUsername = SessionManager.getLoggedInUser();
        userRole = SessionManager.getRoleByUsername(loggedInUsername);
    }
    
    private void updateCancelBtn() {
        switch (userRole) {
            case "admin":
                btnCancelTransac.setText("Cancel Transaction");
                break;
            default:
                System.out.println("Transac Status" + transacStatus);
                switch (transacStatus) {
                    case "approved":
                        btnCancelTransac.setText("Request Cancel Transaction");
                        break;
                    case "request cancel":
                        btnCancelTransac.setText("Requested Cancel");
                        break;
                    case "cancelled":
                        btnCancelTransac.setVisible(false);
                        break;
                    default:
                        btnCancelTransac.setText("Cancel Transaction");
                        break;
                }
                break;
        }
        
    }
    
    private void adminBtns() {
        System.out.println("User Role: " + userRole);
        switch (userRole) {
            case "admin":
                btnApproveTransac.setVisible(true);
                switch (transacStatus) {
                    case "approved":
                        btnApproveTransac.setVisible(false);
                        btnCancelTransac.setVisible(true);
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(false);
                        break;
                    case "cancelled":
                        btnApproveTransac.setVisible(false);
                        btnCancelTransac.setVisible(false);
                        btnDelete.setVisible(true);
                        btnUpdate.setVisible(false);
                        break;
                    default:
                        btnUpdate.setVisible(false);
                        btnDelete.setVisible(false);
                        break;
                }
                break;
            default:
                btnApproveTransac.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                break;
        }
        
        
    }
    
    private void btnApproveTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveTransacActionPerformed
        switch (transacStatus) {
            case "pending":
                int option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to approve this transaction?", "Approve Transaction", javax.swing.JOptionPane.YES_NO_OPTION);
                if (option == javax.swing.JOptionPane.YES_OPTION) {
                    updateTransactionStatus("approved");
                    headToAdminPanel();
                }
                break;
            case "cancelled":
                btnApproveTransac.setVisible(false);
                break;
            case "request cancel":
                option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to approve this transaction? Customer is requesting cancellation.", "Approve Transaction", javax.swing.JOptionPane.YES_NO_OPTION);
                if (option == javax.swing.JOptionPane.YES_OPTION) {
                    updateTransactionStatus("approved");
                    headToAdminPanel();
                }
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "You cannot approve this transaction because it is already approved or under process.", "Okay", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btnApproveTransacActionPerformed

    private void btnCancelTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelTransacActionPerformed
        switch (userRole) {
            case "customer":
            switch (transacStatus) {
                case "pending":
                    int option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this transaction?", "Cancel Transaction", javax.swing.JOptionPane.YES_NO_OPTION);
                    if (option == javax.swing.JOptionPane.YES_OPTION) {
                        updateTransactionStatus("cancelled");
                        headToCustomerPanel();
                    }
                    break;
                case "approved":
                    option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to request cancel for this transaction?", "Request Cancel", javax.swing.JOptionPane.YES_NO_OPTION);
                    if (option == javax.swing.JOptionPane.YES_OPTION) {
                        updateTransactionStatus("request cancel");
                        headToCustomerPanel();
                    }
                    break;
                default:
                    javax.swing.JOptionPane.showMessageDialog(this, "You cannot cancel this transaction because it is already cancelled or under process by the admin.", "Okay", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            break;
            case "admin":
                if (!transacStatus.equals("cancelled")) {
                    int option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this transaction?", "Cancel Transaction", javax.swing.JOptionPane.YES_NO_OPTION);
                    if (option == javax.swing.JOptionPane.YES_OPTION) {
                        updateTransactionStatus("cancelled");
                        headToAdminPanel();
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "This transaction is already cancelled.", "Cancel Transaction", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnCancelTransacActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        switch (userRole) {
            case "admin":
                headToAdminPanel();
                break;
            default:
                headToCustomerPanel();
                break;
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        UpdateTransacDetailsPanel updateTransacDetailsPanel = new UpdateTransacDetailsPanel(transacID);
        updateTransacDetailsPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int option = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this transaction?", "Delete Transaction", javax.swing.JOptionPane.YES_NO_OPTION);
        if (option == javax.swing.JOptionPane.YES_OPTION) {
            try (Connection conn = DatabaseUtils.getConnection()) {
                int customerID = 0;
                try (PreparedStatement customerIdStmt = conn.prepareStatement("SELECT c_id FROM tbl_transactions WHERE t_id = ?")) {
                    customerIdStmt.setInt(1, transacID);
                    try (ResultSet rs = customerIdStmt.executeQuery()) {
                        if (rs.next()) {
                            customerID = rs.getInt("c_id");
                        }
                    }
                }

                try (PreparedStatement transactionStmt = conn.prepareStatement("DELETE FROM tbl_transactions WHERE t_id = ?")) {
                    transactionStmt.setInt(1, transacID);
                    int rowsDeleted = transactionStmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Transaction with ID " + transacID + " deleted successfully.");
                        javax.swing.JOptionPane.showMessageDialog(this, "Transaction deleted successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                        if (customerID != 0) {
                            try (PreparedStatement customerStmt = conn.prepareStatement("DELETE FROM tbl_customers WHERE c_id = ?")) {
                                customerStmt.setInt(1, customerID);
                                customerStmt.executeUpdate();
                            }
                        }

                        headToAdminPanel();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void headToAdminPanel() {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.setVisible(true);
        this.dispose();
    }
    
    private void headToCustomerPanel() {
        CustomerPanel customerPanel = new CustomerPanel();
        customerPanel.setVisible(true);
        this.dispose();
    }
    
    private void updateTransactionStatus(String newStatus) {
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE tbl_transactions SET t_transacStatus = ? WHERE t_id = ?")) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, transacID);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Transaction status updated successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void displayTransactionDetails(int transactionID) {
        transacID = transactionID;
        try (Connection conn = DatabaseUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT c.c_name, c.c_contact, c.c_address, t.s_id, t.a_id, s.s_name, a.a_name, t.t_dropOffDate, t.t_deliveryMethod, t.t_submittedDate, t.t_completedDate, t.t_kilo, t.t_total, t.t_note, t.t_transacStatus, t.t_paymentStatus "
                    + "FROM tbl_transactions t "
                    + "INNER JOIN tbl_customers c ON t.c_id = c.c_id "
                    + "INNER JOIN tbl_services s ON t.s_id = s.s_id "
                    + "INNER JOIN tbl_addOns a ON t.a_id = a.a_id "
                    + "WHERE t.t_id = ?")) {
            stmt.setInt(1, transactionID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("c_name");
                    String contact = rs.getString("c_contact");
                    String address = rs.getString("c_address");
                    String dropOffDate = rs.getString("t_dropOffDate");
                    String deliveryMethod = rs.getString("t_deliveryMethod");
                    String submittedDate = rs.getString("t_submittedDate");
                    String completedDate = rs.getString("t_completedDate");
                    String service = rs.getString("s_name");
                    String addOn = rs.getString("a_name");
                    String kilo = rs.getString("t_kilo");
                    String total = rs.getString("t_total");
                    String note = rs.getString("t_note");
                    String transactionStatus = rs.getString("t_transacStatus");
                    String paymentStatus = rs.getString("t_paymentStatus");

                    lblTransactionID.setText(String.valueOf(transactionID));
                    lblName.setText(name);
                    lblContact.setText(contact);
                    lblAddress.setText(address);
                    lblDeliveryMethod.setText(deliveryMethod);
                    lblDropOffDate.setText(dropOffDate);
                    lblSubmittedDate.setText(submittedDate);
                    lblCompletedDate.setText(completedDate);
                    lblService.setText(service);
                    lblAddOn.setText(addOn);
                    lblKilo.setText(kilo);
                    lblTotal.setText(total);
                    lblNote.setText(note);
                    lblTransacStatus.setText(transactionStatus);
                    lblPaymentStatus.setText(paymentStatus);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
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
            java.util.logging.Logger.getLogger(TransactionDetailsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionDetailsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionDetailsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionDetailsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int transactionID = 0;
                String transactionStatus = "";
                new TransactionDetailsPanel(transactionID, transactionStatus).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveTransac;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelTransac;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAddOn;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCompletedDate;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblDeliveryMethod;
    private javax.swing.JLabel lblDropOffDate;
    private javax.swing.JLabel lblKilo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblPaymentStatus;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblSubmittedDate;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTransacStatus;
    private javax.swing.JLabel lblTransactionID;
    // End of variables declaration//GEN-END:variables
}
