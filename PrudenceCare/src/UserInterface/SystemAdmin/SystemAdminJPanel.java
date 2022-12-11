/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.DiagnosticsEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Enterprise.VaccineEnterprise;
import Business.Essentials.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Patient.Patient;
import Business.Role.Admin;
import Business.Role.AmbulanceDriverRole;
import Business.Role.Rider;
import Business.Role.FDARole;
import Business.Role.InsuranceAdminRole;
import Business.Role.InsuranceClaimRole;
import Business.Role.DiagnosticsAdmin;
import Business.Role.DiagnosticsCrew;
import Business.Role.ManufactureAdminRole;
import Business.Role.PatientRole;
import Business.Role.PharmacyAdminRole;
import Business.Role.VaccineAdminRole;
import Business.Role.VaccineScientistRole;
import Business.Role.VaccineTestingStaffRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
//import userinterface.SystemAdminWorkArea.
/**
 *
 * @author MyPC1
 */
public class SystemAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    
    public SystemAdminJPanel(JPanel userProcessContainer,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
         jScrollPane2.getViewport().setBackground(Color.WHITE);
         
//         DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) jTree.getCellRenderer();
//        Icon closedIcon = new ImageIcon("folder_10px.png");
//        Icon openIcon = new ImageIcon("management_10px.png");
//        Icon leafIcon = new ImageIcon("opened_folder_10px.png");
//        renderer.setClosedIcon(closedIcon);
//        renderer.setOpenIcon(openIcon);
//        renderer.setLeafIcon(leafIcon);
        
        populateTree();

    }
    
 
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree.getModel();
        ArrayList<Network> networkList=ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> orgList;
        ArrayList<UserAccount> userList;
        
        int count=0;
        String role;
        Network network;
        Enterprise enterprise;
        Organization organization;
        UserAccount user = null;
        String org = null;
        Type type;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        DefaultMutableTreeNode userNode = null;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
  
                    orgList=enterprise.getOrganizationDirectory().getOrganizationList(); 
                  for (int l=0;l<orgList.size();l++){         
                     organization=orgList.get(l);
                    organizationNode=new DefaultMutableTreeNode(organization.getOrganizationType());
                     enterpriseNode.insert(organizationNode, l);
                       
                   userList=organization.getUserAccountDirectory().getUserAccountList();
                    for (int k=0;k<userList.size();k++){ 
                        user=userList.get(k);
                        
                        if(user.getRole().toString().equals(organization.getOrganizationType())){
                            System.out.print("Hi");
                            userNode=new DefaultMutableTreeNode(user.getEmployee().getName());
                            organizationNode.insert(userNode, k);
                    }   
                    }
            }
                }
        
        }
        model.reload();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnltab = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl = new javax.swing.JPanel();
        pnl2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        lblSelectedNode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnltab.setBackground(new java.awt.Color(255, 255, 255));
        pnltab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(213, 176, 181));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Network Tree");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnltab.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 340, 108));

        jButton2.setBackground(new java.awt.Color(217, 185, 41));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("Home");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnltab.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, 108));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Administrator Profile !");
        pnltab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("Welcome to System ");
        pnltab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 40));

        add(pnltab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 870));

        pnl.setBackground(new java.awt.Color(195, 199, 210));
        pnl.setLayout(new java.awt.CardLayout());

        pnl2.setBackground(new java.awt.Color(238, 233, 234));

        jTree.setBackground(new java.awt.Color(0, 0, 0));
        jTree.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTree.setOpaque(false);
        jTree.setRootVisible(false);
        jTree.setRowHeight(25);
        jTree.setVisibleRowCount(30);
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree);

        lblSelectedNode.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblSelectedNode.setText("<View_selected_node>");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Selected Node:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setText("NETWORK TREE");

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(365, 365, 365))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectedNode, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectedNode, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pnl.add(pnl2, "card3");

        add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 940, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl1);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl2);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnltab;
    // End of variables declaration//GEN-END:variables
}
