/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datanoid;

/**
 *
 * @author lylejw
 */
public class DatanoidFolderFrame extends javax.swing.JPanel {

    /**
     * Creates new form DatanoidFolderFrame
     */
    public DatanoidFolderFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentFolder = new javax.swing.JComboBox<>();
        nonLocalFolder = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.getViewport().setOpaque(false);
        jTextArea1 = new javax.swing.JTextArea();

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/datanoid/resource/disk-64.png"))); // NOI18N
        jLabel11.setToolTipText("");
        jLabel11.setAlignmentX(0.5F);
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));

        jLabel12.setText("Select a folder: ");

        currentFolder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add a new folder..." }));

        nonLocalFolder.setText("<html>Tick if the folder is a removable disk or network drive<br/>&nbsp;and can be disconnected from time to time.</html>");
        nonLocalFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonLocalFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentFolder, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nonLocalFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nonLocalFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(null);
        jScrollPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(0,0,0,0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(jTextArea1.getFont().deriveFont((float)14));
        jTextArea1.setRows(4);
        jTextArea1.setText("Settings:\n* Daily backups occur at 3am\n* Backups are kept for the past 3 months\n* Backup integrity checks occur every 7 days\n* Backup files are encrypted for security");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jTextArea1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextArea1.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nonLocalFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonLocalFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nonLocalFolderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> currentFolder;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox nonLocalFolder;
    // End of variables declaration//GEN-END:variables
}