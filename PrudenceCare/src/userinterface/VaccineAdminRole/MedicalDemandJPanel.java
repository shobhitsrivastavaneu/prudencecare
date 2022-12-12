/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Essentials.Medicine;
import Business.Network.Network;
import Business.Organization.PharmacyOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabPatientWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Manasa
 */
public class MedicalDemandJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmaReportJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    PharmacyOrganization organization;
    UserAccount account;
    public MedicalDemandJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.organization = organization;
        this.account=account;
        populateCovidCases(); //covid medicine number of requests - each req display
        populateMedicineGraph();//medicine number of buyers
        populateConditionDemand(); //condition pie chart
        populateConditionMedDemands(); //For each condtion medicine more of demand
         this.setSize(1466, 902);
                introPanel.setBounds(171, 33, 1293, 101);
        jLabel7.setBounds(1, 1, 160, 113);
        jTabbedPane1.setBounds(1, 130, 1228, 782);

                lblEnterprise.setText(enterprise.getName());
        lblAccount.setText("Logged in as: "+account.getUsername());
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);

        for (int i = 0; i < covidTable.getModel().getColumnCount(); i++) {
            covidTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        covidTable.setShowGrid(true);
       covidTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
       jTabbedPane1.setBackground(Color.WHITE);
        

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   // All pharmacies in the network
     public void populateCovidCases(){
        Map<String,Integer> covMed = new HashMap<String,Integer>();
        for(Network n : business.getNetworkList()){
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                if("Pharmacy".equals(e.getEnterpriseType().getValue())){
                    

        PharmacyEnterprise pharmaEnterprise = (PharmacyEnterprise) e;
        for(Medicine med : pharmaEnterprise.getMedicineCatalog().getMedicineList()){
            int medCount =0;
            if(med.getCondition().equalsIgnoreCase("covid")){
                for(PharmaWorkRequest request: business.getPharmaQueue().getPharmaList()){
                    Map<Medicine,Integer> medMap = request.getMedList();
                    for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {
                         if(medicine.getKey().getName().equals(med.getName())){
                             medCount+=medicine.getValue();
                         }
                    } 
                }
                covMed.put(med.getName(), medCount);
            }
        }
                        }
            }
        }
        DefaultTableModel model = (DefaultTableModel)covidTable.getModel();
        model.setRowCount(0);
         for (Map.Entry<String,Integer> medEntry : covMed.entrySet()) {   
               Object row[] = new Object[8];
                 row[0] = medEntry.getKey();
                 row[1] = medEntry.getValue();
                   model.addRow(row); 
            }
    }   
     private  Map<String,Date> sortByDate(Map<String, Date> map){
        List<Map.Entry<String, Date>> tempList = new LinkedList<Map.Entry<String, Date>>(map.entrySet());
        Collections.sort(tempList, new Comparator<Map.Entry<String, Date>>(){
            public int compare(Map.Entry<String, Date> obj1,Map.Entry<String, Date> obj2) {
                    return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        Map<String, Date> sortedMap = new LinkedHashMap<String, Date>();
        for (Map.Entry<String, Date> entry : tempList){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    } 
 
    public void populateMedicineGraph(){
    DefaultCategoryDataset category = new DefaultCategoryDataset();
            for(Network n : business.getNetworkList()){
            for(Enterprise enterP: n.getEnterpriseDirectory().getEnterpriseList()){
               if("Pharmacy".equals(enterP.getEnterpriseType().getValue())){
                    
    PharmacyEnterprise e = (PharmacyEnterprise) enterP;
    for(Medicine medicine: e.getMedicineCatalog().getMedicineList()){
        int count = 0;
        for(PharmaWorkRequest req: business.getPharmaQueue().getPharmaList()){
                    Map<Medicine,Integer> medMap = req.getMedList();
                    for (Map.Entry<Medicine,Integer> med : medMap.entrySet()) {
                         if(med.getKey().getName().equals(medicine.getName())){
                             count+=med.getValue();
                         }
                    } 
                }
                category.setValue(count, "MedicineRequests", medicine.getName());
        }
                        }
            }
        }
   
       JFreeChart chart=ChartFactory.createBarChart("Medicine Demand Chart", "Medicine", "MedicineRequests", category, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p= (CategoryPlot)chart.getPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("Medicine Demand Chart", chart);
        
        demandPanel.setLayout(new java.awt.BorderLayout());
        demandPanel.add(new ChartPanel(chart));
        demandPanel.setPreferredSize(new Dimension(300,300));
    
}
   public void populateConditionMedDemands(){
    DefaultCategoryDataset category = new DefaultCategoryDataset();
                for(Network n : business.getNetworkList()){
            for(Enterprise enterP: n.getEnterpriseDirectory().getEnterpriseList()){
                if("Pharmacy".equals(enterP.getEnterpriseType().getValue())){
                    
    PharmacyEnterprise e = (PharmacyEnterprise) enterP;
    for(Medicine medicine: e.getMedicineCatalog().getMedicineList()){
        int count = 0;
        for(PharmaWorkRequest req: business.getPharmaQueue().getPharmaList()){
                    Map<Medicine,Integer> medMap = req.getMedList();
                    for (Map.Entry<Medicine,Integer> med : medMap.entrySet()) {
                         if(med.getKey().getName().equals(medicine.getName())){
                             count+=med.getValue();
                         }
                    } 
                }
                category.addValue(count, medicine.getName(), medicine.getCondition());
        }
                }
                }
                }


   
       JFreeChart chart=ChartFactory.createBarChart("Medicine Demand Chart", "Medicine", "MedicineRequests", category, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p= (CategoryPlot)chart.getPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("Medicine Demand Chart", chart);
        
        medDemandPanel.setLayout(new java.awt.BorderLayout());
        medDemandPanel.add(new ChartPanel(chart));
        medDemandPanel.setPreferredSize(new Dimension(610,400));
    
}
    public void populateConditionDemand(){
               int diabetesCount = 0;
        int covidCount=0;
        int heartCount=0;
        int respCount=0;
        int feverCount=0;
        int entCount=0;
        int painCount=0;
                        for(Network n : business.getNetworkList()){
            for(Enterprise enterP: n.getEnterpriseDirectory().getEnterpriseList()){
                if("Pharmacy".equals(enterP.getEnterpriseType().getValue())){
    PharmacyEnterprise e = (PharmacyEnterprise) enterP;
    for(PharmaWorkRequest req: business.getPharmaQueue().getPharmaList()){
                    Map<Medicine,Integer> medMap = req.getMedList();
                    for (Map.Entry<Medicine,Integer> med : medMap.entrySet()) {
                         if(med.getKey().getCondition().equalsIgnoreCase("Covid")){
                             covidCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Heart")){
                             heartCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Resp")){
                             respCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Fever")){
                             feverCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Ent")){
                             entCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Pain")){
                             painCount+=med.getValue();
                         }else if(med.getKey().getCondition().equalsIgnoreCase("Diabetes")){
                             diabetesCount+=med.getValue();
                         }
                    } 
    }
                }
            }
                        }
        DefaultPieDataset piedataset= new DefaultPieDataset();
        piedataset.setValue("Covid-Relief", covidCount);
        piedataset.setValue("Heart Problems",heartCount);
        piedataset.setValue("Diabetes",diabetesCount);
        piedataset.setValue("Respiratory Problems",respCount);
        piedataset.setValue("EnT Medicines",entCount);
        piedataset.setValue("Fever",feverCount);
        piedataset.setValue("PainKillers",painCount);        
        JFreeChart chart=ChartFactory.createPieChart("Medicine Type Chart", piedataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame=new ChartFrame("Medicine Type Chart", chart);
       conditionPanel.setLayout(new java.awt.BorderLayout());
        conditionPanel.add(new ChartPanel(chart));
        conditionPanel.setPreferredSize(new Dimension(300,300));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        covidTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        conditionPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        medDemandPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        demandPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        introPanel.setBackground(new java.awt.Color(0, 0, 102));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Medical Demands Portal");

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backJButton1.setBackground(new java.awt.Color(0, 0, 102));
        backJButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(255, 255, 255));
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/home2.png"))); // NOI18N
        backJButton1.setText("Home");
        backJButton1.setBorder(null);
        backJButton1.setBorderPainted(false);
        backJButton1.setContentAreaFilled(false);
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(158, 158, 158)
                .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backJButton1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        covidTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Medicine", "Requests"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(covidTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Covid Medicine Analysis", jPanel2);

        conditionPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Age-Group");

        javax.swing.GroupLayout conditionPanelLayout = new javax.swing.GroupLayout(conditionPanel);
        conditionPanel.setLayout(conditionPanelLayout);
        conditionPanelLayout.setHorizontalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel12)
                .addContainerGap(896, Short.MAX_VALUE))
        );
        conditionPanelLayout.setVerticalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(512, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conditionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(conditionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medical Condition Analysis", jPanel5);

        medDemandPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Age-Group");

        javax.swing.GroupLayout medDemandPanelLayout = new javax.swing.GroupLayout(medDemandPanel);
        medDemandPanel.setLayout(medDemandPanelLayout);
        medDemandPanelLayout.setHorizontalGroup(
            medDemandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medDemandPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel11)
                .addContainerGap(864, Short.MAX_VALUE))
        );
        medDemandPanelLayout.setVerticalGroup(
            medDemandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medDemandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(551, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(medDemandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(medDemandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medical Condition Demands", jPanel4);

        demandPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Age-Group");

        javax.swing.GroupLayout demandPanelLayout = new javax.swing.GroupLayout(demandPanel);
        demandPanel.setLayout(demandPanelLayout);
        demandPanelLayout.setHorizontalGroup(
            demandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(demandPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel13)
                .addContainerGap(896, Short.MAX_VALUE))
        );
        demandPanelLayout.setVerticalGroup(
            demandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(demandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(545, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(demandPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(demandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medicine Demands", jPanel6);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/vacreport.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1094, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        if(this.jTabbedPane1.getSelectedIndex() == 0){//covid medicines
             populateCovidCases(); //newly approved
        }else if(this.jTabbedPane1.getSelectedIndex() ==  1){//condition analysis
           populateConditionDemand(); //covid medicine number of requests - each req display
        }else if(this.jTabbedPane1.getSelectedIndex() ==  2){//condition demands
            populateConditionMedDemands();//age group pie chart
        }else if(this.jTabbedPane1.getSelectedIndex() ==  3){//medicine demands
            populateMedicineGraph(); //condition pie chart
        }

    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JPanel conditionPanel;
    private javax.swing.JTable covidTable;
    private javax.swing.JPanel demandPanel;
    private javax.swing.JPanel introPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JPanel medDemandPanel;
    // End of variables declaration//GEN-END:variables
}
