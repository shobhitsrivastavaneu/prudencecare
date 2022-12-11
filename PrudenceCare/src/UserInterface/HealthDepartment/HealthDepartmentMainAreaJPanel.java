/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HealthDepartment;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.DiagnosticsAdmin.DiagnosticsReportJPanel;
import userinterface.DispensaryAdmin.DispensaryReportJPanel;
//import userinterface.VaccineAdminRole.VaccineCompReportJPanel;

/**
 *
 * @author parvathypillai
 */
public class HealthDepartmentMainAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HealthDepartmentMainAreaJPanel
     */
    
        private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;  
        
    public HealthDepartmentMainAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
        valueLabel.setText(enterprise.getName());
        populateComboBox();
    }
    private void populateComboBox() {
        networkJComboBox.removeAllItems();
        networkJComboBox.addItem("");

        for (Network network : business.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }
        public void populateHospitalList(){
        if((networkJComboBox.getSelectedItem().equals(""))){
         JOptionPane.showMessageDialog(null, "Please choose a network!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
        DefaultTableModel model = (DefaultTableModel)hospTable.getModel();
        model.setRowCount(0);
     
        Network network = (Network) networkJComboBox.getSelectedItem();
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if((e.getEnterpriseType().getValue()).equals("Hospital")){

             Object row[] = new Object[8];
                 row[0] = e;
                 model.addRow(row); 
            }
        }
        }
       public void populatePharmacyList(){
        if((networkJComboBox.getSelectedItem().equals(""))){
         JOptionPane.showMessageDialog(null, "Please choose a network!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
        DefaultTableModel model = (DefaultTableModel)pharmaTable.getModel();
        model.setRowCount(0);
     
        Network network = (Network) networkJComboBox.getSelectedItem();
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if((e.getEnterpriseType().getValue()).equals("Pharmacy")){

             Object row[] = new Object[8];
                 row[0] = e;
                 model.addRow(row); 
            }
        }
        }
        public void populateLaboratoryList(){
        if((networkJComboBox.getSelectedItem().equals(""))){
         JOptionPane.showMessageDialog(null, "Please choose a network!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
        DefaultTableModel model = (DefaultTableModel)labTable.getModel();
        model.setRowCount(0);
     
        Network network = (Network) networkJComboBox.getSelectedItem();
       ;
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if((e.getEnterpriseType().getValue()).equals("Laboratory")){

             Object row[] = new Object[8];
                 row[0] = e;
                 model.addRow(row); 
            }
        }
        }
        public void populateVaccineCompList(){
        if((networkJComboBox.getSelectedItem().equals(""))){
         JOptionPane.showMessageDialog(null, "Please choose a network!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
        DefaultTableModel model = (DefaultTableModel)vacTable.getModel();
        model.setRowCount(0);
     
        Network network = (Network) networkJComboBox.getSelectedItem();
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if((e.getEnterpriseType().getValue()).equals("VaccineCompany")){

             Object row[] = new Object[8];
                 row[0] = e;
                 model.addRow(row); 
            }
        }
        }
       public void populateInsuranceCompList(){
        if((networkJComboBox.getSelectedItem().equals(""))){
         JOptionPane.showMessageDialog(null, "Please choose a network!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
        DefaultTableModel model = (DefaultTableModel)insureTable.getModel();
        model.setRowCount(0);
     
        Network network = (Network) networkJComboBox.getSelectedItem();
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if((e.getEnterpriseType().getValue()).equals("InsuranceCompany")){

             Object row[] = new Object[8];
                 row[0] = e;
                 model.addRow(row); 
            }
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

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLab = new javax.swing.JButton();
        btnHosp = new javax.swing.JButton();
        btnPharma = new javax.swing.JButton();
        btnVac = new javax.swing.JButton();
        btnInsure = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hospTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        labTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        vacTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        pharmaTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        insureTable = new javax.swing.JTable();
        btnHospStat = new javax.swing.JButton();
        networkJComboBox = new javax.swing.JComboBox();
        btnLabStat = new javax.swing.JButton();
        btnPharmaStat = new javax.swing.JButton();
        btnVacStat = new javax.swing.JButton();
        btnInsureStat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        enterpriseLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        enterpriseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enterpriseLabel.setText("Enterprise :");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Network:");

        btnLab.setBackground(new java.awt.Color(49, 163, 222));
        btnLab.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnLab.setForeground(new java.awt.Color(255, 255, 255));
        btnLab.setText("View Laboratories");
        btnLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.white));
        btnLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabActionPerformed(evt);
            }
        });

        btnHosp.setBackground(new java.awt.Color(49, 163, 222));
        btnHosp.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnHosp.setForeground(new java.awt.Color(255, 255, 255));
        btnHosp.setText("View Hospital");
        btnHosp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.white));
        btnHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospActionPerformed(evt);
            }
        });

        btnPharma.setBackground(new java.awt.Color(49, 163, 222));
        btnPharma.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnPharma.setForeground(new java.awt.Color(255, 255, 255));
        btnPharma.setText("View Pharmacy");
        btnPharma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.white));
        btnPharma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPharmaActionPerformed(evt);
            }
        });

        btnVac.setBackground(new java.awt.Color(49, 163, 222));
        btnVac.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnVac.setForeground(new java.awt.Color(255, 255, 255));
        btnVac.setText("View VaccineCompanies");
        btnVac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.white));
        btnVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacActionPerformed(evt);
            }
        });

        btnInsure.setBackground(new java.awt.Color(49, 163, 222));
        btnInsure.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnInsure.setForeground(new java.awt.Color(255, 255, 255));
        btnInsure.setText("View Insurance Policies");
        btnInsure.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.white));
        btnInsure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsureActionPerformed(evt);
            }
        });

        hospTable.setBackground(new java.awt.Color(182, 220, 237));
        hospTable.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        hospTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Hospital Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hospTable);
        if (hospTable.getColumnModel().getColumnCount() > 0) {
            hospTable.getColumnModel().getColumn(0).setResizable(false);
        }

        labTable.setBackground(new java.awt.Color(182, 220, 237));
        labTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        labTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Laboratory Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(labTable);
        if (labTable.getColumnModel().getColumnCount() > 0) {
            labTable.getColumnModel().getColumn(0).setResizable(false);
        }

        vacTable.setBackground(new java.awt.Color(182, 220, 237));
        vacTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Vaccine Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(vacTable);
        if (vacTable.getColumnModel().getColumnCount() > 0) {
            vacTable.getColumnModel().getColumn(0).setResizable(false);
        }

        pharmaTable.setBackground(new java.awt.Color(182, 220, 237));
        pharmaTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        pharmaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Pharmacy Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(pharmaTable);
        if (pharmaTable.getColumnModel().getColumnCount() > 0) {
            pharmaTable.getColumnModel().getColumn(0).setResizable(false);
        }

        insureTable.setBackground(new java.awt.Color(182, 220, 237));
        insureTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        insureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Insurance Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(insureTable);
        if (insureTable.getColumnModel().getColumnCount() > 0) {
            insureTable.getColumnModel().getColumn(0).setResizable(false);
        }

        btnHospStat.setBackground(new java.awt.Color(49, 163, 222));
        btnHospStat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnHospStat.setForeground(new java.awt.Color(255, 255, 255));
        btnHospStat.setText("View Statistics");
        btnHospStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHospStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospStatActionPerformed(evt);
            }
        });

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        btnLabStat.setBackground(new java.awt.Color(49, 163, 222));
        btnLabStat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnLabStat.setForeground(new java.awt.Color(255, 255, 255));
        btnLabStat.setText("View Statistics");
        btnLabStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLabStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabStatActionPerformed(evt);
            }
        });

        btnPharmaStat.setBackground(new java.awt.Color(49, 163, 222));
        btnPharmaStat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnPharmaStat.setForeground(new java.awt.Color(255, 255, 255));
        btnPharmaStat.setText("View Statistics");
        btnPharmaStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPharmaStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPharmaStatActionPerformed(evt);
            }
        });

        btnVacStat.setBackground(new java.awt.Color(49, 163, 222));
        btnVacStat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnVacStat.setForeground(new java.awt.Color(255, 255, 255));
        btnVacStat.setText("View Statistics");
        btnVacStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVacStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacStatActionPerformed(evt);
            }
        });

        btnInsureStat.setBackground(new java.awt.Color(49, 163, 222));
        btnInsureStat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnInsureStat.setForeground(new java.awt.Color(255, 255, 255));
        btnInsureStat.setText("View Statistics");
        btnInsureStat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white));
        btnInsureStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsureStatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(networkJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHospStat, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLabStat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHosp, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLab, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPharmaStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnPharma, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnVacStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVac, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnInsure, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnInsureStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel)
                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLab, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPharma, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVac, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInsure, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHosp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHospStat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLabStat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPharmaStat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVacStat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnInsureStat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabActionPerformed
        // TODO add your handling code here:
        populateLaboratoryList();
    }//GEN-LAST:event_btnLabActionPerformed

    private void btnHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospActionPerformed
        // TODO add your handling code here:
        populateHospitalList();
    }//GEN-LAST:event_btnHospActionPerformed

    private void btnPharmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPharmaActionPerformed
        // TODO add your handling code here:
        populatePharmacyList();
    }//GEN-LAST:event_btnPharmaActionPerformed

    private void btnVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacActionPerformed
        // TODO add your handling code here:
        populateVaccineCompList();
    }//GEN-LAST:event_btnVacActionPerformed

    private void btnInsureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsureActionPerformed
        // TODO add your handling code here:
        populateInsuranceCompList();
    }//GEN-LAST:event_btnInsureActionPerformed

    private void btnHospStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospStatActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnHospStatActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void btnLabStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabStatActionPerformed
        // TODO add your handling code here:
        int selectedRow = labTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Laboratory from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Enterprise ePrise = (Enterprise)labTable.getValueAt(selectedRow, 0);
        LabReportJPanel labreportCompJPanel = new LabReportJPanel(userProcessContainer,account,ePrise,business);
        userProcessContainer.add("labreportCompJPanel", labreportCompJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);       
    }//GEN-LAST:event_btnLabStatActionPerformed

    private void btnPharmaStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPharmaStatActionPerformed
        // TODO add your handling code here:
        int selectedRow = pharmaTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Pharmacy from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
         Enterprise ePrise = (Enterprise)pharmaTable.getValueAt(selectedRow, 0);
        DispensaryReportJPanel pharreportCompJPanel = new DispensaryReportJPanel(userProcessContainer,account,ePrise,business);
        userProcessContainer.add("pharreportCompJPanel", pharreportCompJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPharmaStatActionPerformed

    private void btnVacStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacStatActionPerformed
        // TODO add your handling code here:
                int selectedRow = vacTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a VaccineCompany from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Enterprise ePrise = (Enterprise)vacTable.getValueAt(selectedRow, 0);
        VaccineCompReportJPanel vacreportCompJPanel = new VaccineCompReportJPanel(userProcessContainer, account,ePrise,business);
        userProcessContainer.add("vacreportCompJPanel", vacreportCompJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVacStatActionPerformed

    private void btnInsureStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsureStatActionPerformed
        // TODO add your handling code here:
        int selectedRow = insureTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a InsuranceCompany from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnInsureStatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHosp;
    private javax.swing.JButton btnHospStat;
    private javax.swing.JButton btnInsure;
    private javax.swing.JButton btnInsureStat;
    private javax.swing.JButton btnLab;
    private javax.swing.JButton btnLabStat;
    private javax.swing.JButton btnPharma;
    private javax.swing.JButton btnPharmaStat;
    private javax.swing.JButton btnVac;
    private javax.swing.JButton btnVacStat;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JTable hospTable;
    private javax.swing.JTable insureTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable labTable;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JTable pharmaTable;
    private javax.swing.JTable vacTable;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
