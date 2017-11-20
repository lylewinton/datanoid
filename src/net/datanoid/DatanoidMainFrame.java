/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datanoid;

import java.awt.AWTException;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.font.TextAttribute;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author lylejw
 */
public class DatanoidMainFrame extends javax.swing.JFrame {

    private final DatanoidFoldersComboBoxModel currentFolderModel;

    /**
     * Creates new form DatanoidMainFrame
     */
    public DatanoidMainFrame() {
        initComponents();
        
        // Attach the currentFolder ComboBox to a DatanoidFolders custom model
        currentFolderModel = new DatanoidFoldersComboBoxModel();
        currentFolder.setModel(currentFolderModel);
        
        javax.swing.JPanel testPanel = new javax.swing.JPanel();
        tabbedPane.addTab("Backup", null, testPanel, "Choose backup locations");
        //folderTabs.add( testPanel );
        // TODO Plan to auto construct tabs from plugins
        
        // Set the icons
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resource/disk-16.png"));
        setIconImage(icon);
        
        // Close is minimise
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setExtendedState(javax.swing.JFrame.ICONIFIED);
            }
        });

        // Try to setup the system tray
        if(SystemTray.isSupported()){
            tray=SystemTray.getSystemTray();

            // Create the trayIcon menu...
            PopupMenu popup=new PopupMenu();
            MenuItem defaultItem=new MenuItem("Open Datanoid");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(javax.swing.JFrame.NORMAL);
                }
            });
            java.util.Map<TextAttribute, Object> attributes = new java.util.HashMap<>();
            attributes.put(TextAttribute.FAMILY, Font.DIALOG);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            attributes.put(TextAttribute.SIZE, 14);
            defaultItem.setFont(Font.getFont(attributes));
            popup.add(defaultItem);
            MenuItem exitItem=new MenuItem("Exit");
            exitItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
            exitItem.setFont(Font.getFont(attributes));
            popup.add(exitItem);
            // Create the trayIcon...
            trayIcon=new TrayIcon(icon, "Datanoid", popup);
            trayIcon.setImageAutoSize(true);
            // On double clicking the trayIcon...
            trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(javax.swing.JFrame.NORMAL);
                }
            });
            // Single clicking button1 on the trayIcon...
            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ( (e.getButton() == MouseEvent.BUTTON1) && (e.getClickCount() == 1) ) {
                        setVisible(true);
                        setExtendedState(javax.swing.JFrame.NORMAL);
                    }
                }
            }); 
            // Listen for window state changes then either tray or un-tray
            addWindowStateListener(new WindowStateListener() {
                public void windowStateChanged(WindowEvent e) {
                    if(e.getNewState()==ICONIFIED){
                        try {
                            tray.add(trayIcon);
                            setVisible(false);
                            System.out.println("added to SystemTray");
                        } catch (AWTException ex) {
                            System.out.println("unable to add to tray");
                        }
                    }
                    if(e.getNewState()==7){
                                try{
                        tray.add(trayIcon);
                        setVisible(false);
                        System.out.println("added to SystemTray");
                        }catch(AWTException ex){
                        System.out.println("unable to add to system tray");
                        }
                    }
                    if(e.getNewState()==MAXIMIZED_BOTH){
                                tray.remove(trayIcon);
                                setVisible(true);
                                System.out.println("Tray icon removed");
                            }
                    if(e.getNewState()==NORMAL){
                        tray.remove(trayIcon);
                        setVisible(true);
                        System.out.println("Tray icon removed");
                    }
                }
            });

        }else{
            System.out.println("system tray not supported");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        folderPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentFolder = new javax.swing.JComboBox<>();
        nonLocalFolder = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/datanoid/resource/disk-64.png"))); // NOI18N
        jLabel11.setToolTipText("");
        jLabel11.setAlignmentX(0.5F);
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));

        jLabel12.setText("Select a watched folder to set up: ");

        currentFolder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add a new folder..." }));
        currentFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentFolderActionPerformed(evt);
            }
        });

        nonLocalFolder.setText("<html>Tick if the folder is a removable disk or network drive<br/>&nbsp;and can be disconnected from time to time.</html>");
        nonLocalFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonLocalFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout folderPanelLayout = new javax.swing.GroupLayout(folderPanel);
        folderPanel.setLayout(folderPanelLayout);
        folderPanelLayout.setHorizontalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, folderPanelLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(folderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, folderPanelLayout.createSequentialGroup()
                        .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nonLocalFolder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                            .addComponent(currentFolder, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        folderPanelLayout.setVerticalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPanelLayout.createSequentialGroup()
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(folderPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nonLocalFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(folderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(folderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currentFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentFolderActionPerformed
        System.out.println(evt.toString());
        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            if (currentFolder.getSelectedIndex() == (currentFolder.getItemCount()-1)) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showDialog(this,"Select");
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //This is where a real application would deal with the file.
                    //currentFolder.insertItemAt(file.getAbsolutePath(), currentFolder.getItemCount()-1);
                    DatanoidFolders df = DatanoidFolders.getInstance();
                    df.add(file.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }
            } else {
                System.out.println("selected "+currentFolder.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_currentFolderActionPerformed

    private void nonLocalFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonLocalFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nonLocalFolderActionPerformed

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
            java.util.logging.Logger.getLogger(DatanoidMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatanoidMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatanoidMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatanoidMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatanoidMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> currentFolder;
    private javax.swing.JPanel folderPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JCheckBox nonLocalFolder;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

    private TrayIcon trayIcon;
    private SystemTray tray;
}
