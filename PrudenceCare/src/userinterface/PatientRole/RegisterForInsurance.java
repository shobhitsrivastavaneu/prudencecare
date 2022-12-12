/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Network.Network;
import Business.Organization.InsuranceAdminOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import userinterface.InsuranceAdminWorkArea.ViewPolicyWorkAreaJPanel;

/**
 *
 * @author Shobhit
 */
public class RegisterForInsurance extends javax.swing.JPanel {

    /**
     * Creates new form RegisterForInsurance
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount userAccount;
    
    public RegisterForInsurance(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem,InsuranceAdminOrganization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.userAccount=account;
        populateTree();
        
        tblSearch.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblSearch.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(48,59,88));
         headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblSearch.getModel().getColumnCount(); i++) {
            tblSearch.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblSearch.setShowGrid(true);
        tblSearch.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
        
        
        tblConfirmedPolicy.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,15));
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblConfirmedPolicy.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(48,59,88));
         headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < tblConfirmedPolicy.getModel().getColumnCount(); i++) {
            tblConfirmedPolicy.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblConfirmedPolicy.setShowGrid(true);
        tblConfirmedPolicy.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
        

        
    for(Network network:ecosystem.getNetworkList()){
    for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
    if(e.getEnterpriseType().equals(e.getEnterpriseType().Insurance)){
           jComboBox1.addItem(e.getName());   
    
    }
    }
    }
    }
    
     public void populateTree(){
     
       String y=(String) jComboBox1.getSelectedItem();
        int flag=0;
        DefaultTableModel model = (DefaultTableModel) tblSearch.getModel();
                model.setRowCount(0);
        for (InsurancePolicy r: ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
          
            if (r.getEnterprise().equals(y)) {
                flag=1;}
                else{flag=0;
            }
            if(flag==1){               
                Object row[] = new Object[6];
                row[0] = r;
                row[1] = r.getZipCode();
                row[2] = r.getMonthlyPremium();
                row[3] = r.getAgeGroup();
                row[4] = r.getPolicyMax();
                row[5] = r.getPolicyType();
                ((DefaultTableModel) tblSearch.getModel()).addRow(row);
                      
            }
            flag=0;
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

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConfirmedPolicy = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtAdult = new javax.swing.JTextField();
        btnSubmit1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy Name", "Zipcode", "Monthly Premium", "AgeGroup", "PolicyMax", "Policy Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSearch);
        if (tblSearch.getColumnModel().getColumnCount() > 0) {
            tblSearch.getColumnModel().getColumn(0).setResizable(false);
            tblSearch.getColumnModel().getColumn(1).setResizable(false);
            tblSearch.getColumnModel().getColumn(2).setResizable(false);
            tblSearch.getColumnModel().getColumn(3).setResizable(false);
            tblSearch.getColumnModel().getColumn(4).setResizable(false);
            tblSearch.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Select Insurance Company:");

        btnSubmit.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnRequest.setBackground(new java.awt.Color(0, 0, 0));
        btnRequest.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRequest.setText("Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnView.setText("View Insurance Policy Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/available_updates_40px.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblConfirmedPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy Name", "Policy Type", "Policy Maximum", "Total members", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblConfirmedPolicy);
        if (tblConfirmedPolicy.getColumnModel().getColumnCount() > 0) {
            tblConfirmedPolicy.getColumnModel().getColumn(0).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(1).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(2).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(3).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(4).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(4).setHeaderValue("Total Cost");
        }

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("If family policy enter the number of members else proceed :");

        txtAdult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAdultMouseClicked(evt);
            }
        });
        txtAdult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdultActionPerformed(evt);
            }
        });

        btnSubmit1.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnSubmit1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit1.setText("Proceed");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REGISTER FOR INSURANCE");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/backIcon.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setOpaque(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(398, 398, 398))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(jLabel7))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(398, 398, 398))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(425, 425, 425))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnView)
                                .addGap(27, 27, 27)
                                .addComponent(btnRefresh)))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(btnRefresh))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        populateTree();
   
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:

        
        int selectedRow =  tblConfirmedPolicy.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
        

        InsurancePolicy insurance = (InsurancePolicy) tblConfirmedPolicy.getValueAt(selectedRow, 0);
        WorkRequest request = new InsuranceWorkRequest();
        request.setSender(userAccount);
        request.setStatus("Insurance Requested");
        
        request.setEnterprise(insurance.getEnterprise());
        request.setInsurancepolicy(insurance.getPolicyName());
        
        request.setRequestDate(new Date());
        ecosystem.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null,"Successfully Requested");
        }      
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblSearch.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
            InsurancePolicy a = (InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
            ViewPolicyWorkAreaJPanel vpeaj = new ViewPolicyWorkAreaJPanel(userProcessContainer, ecosystem, a,false);
            userProcessContainer.add("ViewPolicyWorkAreaJPanel", vpeaj);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PatientInsuranceWorkAreaJPanel pajp = (PatientInsuranceWorkAreaJPanel) component;
        pajp.populateTree();
        pajp.populateComboBox();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
 
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTree();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtAdultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdultActionPerformed

    private void txtAdultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdultMouseClicked
        // TODO add your handling code here:
       int selectedRow =  tblSearch.getSelectedRow(); 
        InsurancePolicy r =(InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
       if(r.getPolicyType().equals("Individual"))
       { JOptionPane.showMessageDialog(null,"Enter for policy type family only");
           
       }
        
    }//GEN-LAST:event_txtAdultMouseClicked

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        double z = 0;
        double y;
        String members = txtAdult.getText();
        int selectedRow = tblSearch.getSelectedRow();
        String e = "";
        int ages = 0;
        int agee = 0;
        InsurancePolicy r = (InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
        String age = r.getAgeGroup();
        if (age.equals("18-30")) {
            ages = 18;
            agee = 30;
        }
        if (age.equals("30-45")) {
            ages = 30;
            agee = 45;
        }
        if (age.equals("45-60")) {
            ages = 45;
            agee = 60;
        }
        if (age.equals("60-80")) {
            ages = 60;
            agee = 80;
        }
        if (age.equals("80-100")) {
            ages = 80;
            agee = 100;
        }

        for (Patient p : ecosystem.getPatientDirectory().getpatientlist()) {
            if (p.getUserName().equals(userAccount.getEmployee().getName())) {
                if (!(p.getAge() >= ages && p.getAge() <= agee)) {
                    e = "Please choose a policy for your age group";
                }
            }
        }
        if (r.getPolicyType().equals("Family")) {
            if (members.equals("")) {
                e = "Please enter the number of members who fall under the choosen policy age group or below";
            } else {
                double x = Double.parseDouble(members);
                if (x == 0.0) {
                    x = 1;
                }
                y = x * r.getMonthlyPremium();
                z = x;
                r.setTotalcost(y);
            }

        } else {
            r.setTotalcost(r.getMonthlyPremium());
            z = 1;
        }

        if ((e.equals(""))) {
            DefaultTableModel model = (DefaultTableModel) tblConfirmedPolicy.getModel();
            model.setRowCount(0);

            Object row[] = new Object[5];
            row[0] = r;
            row[1] = r.getPolicyType();
            row[2] = r.getPolicyMax();
            row[3] = z;
            row[4] = r.getTotalcost();

            model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_btnSubmit1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblConfirmedPolicy;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtAdult;
    // End of variables declaration//GEN-END:variables
}